package com.example.learn.exception;

import com.example.learn.constant.ServerResponseEnum;
import com.example.learn.pojo.ApiResult;
import org.apache.shiro.authz.UnauthorizedException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * @author lichuang
 * @date 2022/10/21
 */
@RestControllerAdvice
public class UserExceptionHandler {

    @ExceptionHandler(UnauthorizedException.class)
    @ResponseStatus(HttpStatus.UNAUTHORIZED)
    public ApiResult UnAuthorizedExceptionHandler(UnauthorizedException e) {
        return ApiResult.error(ServerResponseEnum.UNAUTHORIZED);
    }
}
