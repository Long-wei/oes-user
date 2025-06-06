package com.oes.controller;

import com.oes.annotation.GlobalInterceptor;
import com.oes.annotation.VerifyParam;
import com.oes.component.RedisComponent;
import com.oes.entity.constant.Constant;
import com.oes.entity.dto.LoginDto;
import com.oes.entity.enums.ResponseCodeEnum;
import com.oes.entity.po.User;
import com.oes.entity.vo.Result;
import com.oes.entity.vo.UserVo;
import com.oes.exception.BusinessException;
import com.oes.service.UserService;
import com.oes.service.UserTokenService;
import com.oes.utils.JwtUtils;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.BeanUtils;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.HashMap;

/**
 * @author LongWei
 * @date 2025/5/21 11:32
 */
@Tag(name = "登录注册")
@RestController
@RequestMapping("/account")
public class AccountController extends ABaseController{

    @Resource
    private UserService userService;

    @Resource
    private RedisComponent redisComponent;

    @Resource
    private UserTokenService userTokenService;


    @Operation(summary = "登录")
    @PostMapping("/login")
    @GlobalInterceptor(checkParams = true, checkLogin = false)
    public Result login(
            HttpServletResponse response,
            @VerifyParam(required = true) String username,
            @VerifyParam(required = true) String password
    ) {
        LoginDto login = null;
        try {
            login = userService.login(username, password);
            String token = userTokenService.generateJWTToken(login.getId());
            response.addCookie(userTokenService.generateCookie(token, Constant.COOKIE_USER_LOGIN, "/", Constant.JWT_EXPIRE_USER_LOGIN));
            redisComponent.setUserLogin(token, login);
        } catch (BusinessException e) {
            return getFailResponseVO(e.getMessage());
        }
        User user = userService.findUserById(login.getId());
        UserVo userVo = new UserVo();
        BeanUtils.copyProperties(user, userVo);
        return getSuccessResponseVO(userVo);
    }

    @Operation(summary = "退出登录")
    @PostMapping("/logout")
    @GlobalInterceptor(checkParams = true)
    public Result logout(HttpServletRequest request, HttpServletResponse response) {
        Cookie cookie = null;
        for (Cookie cookieT : request.getCookies()) {
            if (Constant.COOKIE_USER_LOGIN.equals(cookieT.getName())) {
                cookie = cookieT;
            }
        }
        if (cookie==null) {
            throw new BusinessException(ResponseCodeEnum.CODE_600);
        }
        Cookie emptyCookie = userTokenService.generateCookie("", cookie.getName(), "/", 0);
        response.addCookie(emptyCookie);
        redisComponent.removeUserLogin(cookie.getValue());
        return getSuccessResponseVO(null);
    }

}
