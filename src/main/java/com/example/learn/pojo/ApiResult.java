package com.example.learn.pojo;


import com.example.learn.constant.ServerResponseEnum;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

/**
 * @author lichuang
 * @date 2022/10/21
 */

@Getter
@Setter
@NoArgsConstructor
public class ApiResult<T> implements Serializable {
    private static final long serialVersionUID = -1005863670741860901L;

    private Integer code;

    private String message;

    private T data;

    private ApiResult(ServerResponseEnum responseCode) {
        this.code = responseCode.getCode();
        this.message = responseCode.getMessage();
    }

    private ApiResult(ServerResponseEnum responseCode, T data) {
        this.code = responseCode.getCode();
        this.message = responseCode.getMessage();
        this.data = data;
    }

    private ApiResult(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

    /**
     * 返回成功信息
     */
    public static <T> ApiResult success(T data) {
        return new ApiResult<>(ServerResponseEnum.SUCCESS, data);
    }

    /**
     * 返回成功信息
     */
    public static ApiResult success() {
        return new ApiResult(ServerResponseEnum.SUCCESS);
    }

    /**
     * 返回错误信息
     */
    public static ApiResult error(ServerResponseEnum responseCode) {
        return new ApiResult(responseCode);
    }
}
