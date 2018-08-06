package com.smart.visa.common.exception;

import lombok.Data;

/**
 * Description: 基础异常类
 * @author Administrator
 */
@Data
public class BaseException extends RuntimeException {

    /**
     * 错误码
     */
    private int code;

    /**
     * 错误信息
     */
    private String message;


    public BaseException(int code, String message) {
        super();
        this.code = code;
        this.message = message;
    }
}
