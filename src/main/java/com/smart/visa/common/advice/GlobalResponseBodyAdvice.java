package com.smart.visa.common.advice;

import com.alibaba.fastjson.JSON;
import com.smart.visa.common.api.ApiResponse;
import org.springframework.core.MethodParameter;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.http.converter.xml.Jaxb2RootElementHttpMessageConverter;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;

/**
 * Description: 全局返回结果处理
 * @author Administrator
 */
@RestControllerAdvice
public class GlobalResponseBodyAdvice implements ResponseBodyAdvice<Object> {

    private final static ThreadLocal<Boolean> useWrapper = new ThreadLocal<>();

    @Override
    public boolean supports(MethodParameter methodParameter, Class<? extends HttpMessageConverter<?>> converterType) {
        return true;
    }

    @Override
    public Object beforeBodyWrite(Object o
            , MethodParameter methodParameter
            , MediaType mediaType
            , Class<? extends HttpMessageConverter<?>> selectedConverterType
            , ServerHttpRequest serverHttpRequest
            , ServerHttpResponse serverHttpResponse) {

        if (useWrapper.get() != null && !useWrapper.get()) {
            return o;
        }

        if (selectedConverterType == Jaxb2RootElementHttpMessageConverter.class) {
            return o;
        }

        if (selectedConverterType == StringHttpMessageConverter.class) {

            ApiResponse apiResponse = new ApiResponse();
            apiResponse.setData(o);
            return JSON.toJSON(apiResponse);
        }

        if (o instanceof ApiResponse) {
            return o;
        }

        ApiResponse apiResponse = new ApiResponse();
        if(o == null){
            o = new Object();
        }
        apiResponse.setData(o);
        return apiResponse;
    }

}
