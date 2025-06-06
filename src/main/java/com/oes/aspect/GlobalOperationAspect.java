package com.oes.aspect;

import com.auth0.jwt.interfaces.DecodedJWT;
import com.oes.annotation.GlobalInterceptor;
import com.oes.annotation.VerifyParam;
import com.oes.component.RedisComponent;
import com.oes.controller.ABaseController;
import com.oes.entity.constant.Constant;
import com.oes.entity.dto.LoginDto;
import com.oes.entity.enums.ResponseCodeEnum;
import com.oes.entity.vo.Result;
import com.oes.exception.BusinessException;
import com.oes.utils.JwtUtils;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.annotation.Resource;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.lang.reflect.Method;
import java.lang.reflect.Parameter;

/**
 * @author LongWei
 * @version 1.0
 * @date 2025/3/28 21:59
 */
@Aspect
@Component("globalOperationAspect")
public class GlobalOperationAspect {

    private Logger logger = LoggerFactory.getLogger(GlobalOperationAspect.class);

    @Resource
    private RedisComponent redisComponent;

    @Pointcut("@annotation(com.oes.annotation.GlobalInterceptor)")
    private void requestInterceptor() {
    }

    @Around("requestInterceptor()")
    public Object interceptorDo(ProceedingJoinPoint joinPoint) throws BusinessException {
        try {
            Object target = joinPoint.getTarget();
            Object[] arguments = joinPoint.getArgs();
            String methodName = joinPoint.getSignature().getName();
            Class<?>[] parameterTypes = ((MethodSignature) joinPoint.getSignature()).getMethod().getParameterTypes();
            Method method = target.getClass().getMethod(methodName, parameterTypes);
            GlobalInterceptor interceptor = method.getAnnotation(GlobalInterceptor.class);
            if (null == interceptor) {
                return null;
            }

            if (interceptor.checkParams()) {
                validateParams(method, arguments);
            }

            if (interceptor.checkLogin()) {
                Boolean o = checkLogin();
                if (!o) {
                    return ABaseController.getFailResponseVO("未登录");
                }
            }

            return joinPoint.proceed();
        } catch (BusinessException e) {
            throw e;
        } catch (Exception e) {
            logger.error("请求参数错误:{}",e.toString());
            throw new BusinessException(ResponseCodeEnum.CODE_500);
        } catch (Throwable e) {
            logger.error("请求参数错误:{}",e.toString());
            throw new BusinessException(ResponseCodeEnum.CODE_500);
        }
    }

    private Boolean checkLogin() {
        ServletRequestAttributes requestAttributes = (ServletRequestAttributes)RequestContextHolder.getRequestAttributes();
        if (requestAttributes == null) {
            throw new BusinessException(ResponseCodeEnum.CODE_600);
        }
        HttpServletRequest request = requestAttributes.getRequest();
        Cookie[] cookies = request.getCookies();
        for (Cookie cookie : cookies) {
            if (Constant.COOKIE_USER_LOGIN.equals(cookie.getName())) {
                if (JwtUtils.isValid(cookie.getValue())) {
                    // 查找redis，如果没有数据，就是没有登录
                    LoginDto userLogin = redisComponent.getUserLogin(cookie.getValue());
                    return userLogin != null;
                }
            }
        }
        return false;
    }

    private void validateParams(Method m, Object[] arguments) {
        Parameter[] parameters = m.getParameters();
        for (int i = 0; i < parameters.length; i++) {
            Parameter parameter = parameters[i];
            Object value = arguments[i];

            VerifyParam verifyParam = parameter.getAnnotation(VerifyParam.class);
            if (null == verifyParam) {
                continue;
            }

            if (verifyParam.required() && value == null) {
                throw new BusinessException(ResponseCodeEnum.CODE_600);
            }

        }
    }

}
