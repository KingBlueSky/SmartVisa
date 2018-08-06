package com.smart.visa.common.advice;

import com.smart.visa.common.api.ApiResponse;
import com.smart.visa.common.exception.BaseException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import java.nio.charset.StandardCharsets;
import java.util.Optional;

/**
 * Version:     1.0
 * Description: 全局异常处理
 * @author Administrator
 */
@Slf4j
@RestControllerAdvice
public class GlobalExceptionControllerAdvice {

    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.OK)
    public ApiResponse handleException(Exception e, HttpServletRequest request, HttpServletResponse response) {

        response.setContentType(MediaType.APPLICATION_JSON_UTF8.toString());
        response.setCharacterEncoding(StandardCharsets.UTF_8.name());

        writeHeader(response);

        handleCommon(e, request);
        // 如果是系统自定义常规异常
        if (e instanceof BaseException) {
            return ApiResponse.builder().code(((BaseException) e).getCode()).message(e.getMessage()).data(new Object()).build();
        }

        return ApiResponse.builder()
                .code(HttpStatus.INTERNAL_SERVER_ERROR.value())
                .message(HttpStatus.INTERNAL_SERVER_ERROR.getReasonPhrase())
                .data(new Object()).build();

    }

    private void handleCommon(Throwable e, HttpServletRequest request) {
        if (e != null) {
            log.error("host:" + request.getRemoteHost() + ", uri:" + request.getRequestURI() + ", referrer:" + request.getHeader(HttpHeaders.REFERER), e);
        }
    }

    private void writeHeader(HttpServletResponse response) {
        response.setHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE);
    }

    @ExceptionHandler(ConstraintViolationException.class)
    @ResponseStatus(HttpStatus.OK)
    public ApiResponse handleConstraintViolationException(ConstraintViolationException e, HttpServletRequest request, HttpServletResponse response) {
        writeHeader(response);
        String message  = null;
        Optional<ConstraintViolation<?>> optional = e.getConstraintViolations().stream().findFirst();
        if (optional.isPresent()) {
            ConstraintViolation<?> constraintViolation = optional.get();
            message = constraintViolation.getPropertyPath() + ": " + constraintViolation.getMessage();
        }
        return ApiResponse.builder().code(HttpStatus.BAD_REQUEST.value()).message(message).data(new Object()).build();
    }

}
