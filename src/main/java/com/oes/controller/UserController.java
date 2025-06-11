package com.oes.controller;

import com.oes.annotation.GlobalInterceptor;
import com.oes.entity.dto.AlterUserDto;
import com.oes.entity.po.User;
import com.oes.entity.vo.Result;
import com.oes.service.UserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.BeanUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author LongWei
 * @date 2025/5/21 11:27
 */

@Tag(name = "用户接口")
@RestController
@RequestMapping("/user")
public class UserController extends ABaseController{

    @Resource
    private UserService userService;

    @Operation(summary = "用户修改信息")
    @PostMapping("/updateUserInfo")
    @GlobalInterceptor(checkParams = true)
    public Result updateUserInfo (@RequestBody AlterUserDto alterUserDto){
        User user = new User();
        BeanUtils.copyProperties(alterUserDto, user);
        userService.updateUser(user);
        return getSuccessResponseVO(null);
    }


}
