package com.smart.visa.common.api;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

/**
 * Description: API响应内容
 * @author Administrator
 */
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
public class ApiResponse<T> implements Serializable {

    private static final long serialVersionUID = -7124605985031425965L;


    /**
     * 状态码
     */
    private int code = 200;

    /**
     * 提示信息
     */
    private String message = "SUCCESS";

    /**
     * 数据内容
     */
    private T data;


    public Map<String,Object> status = new HashMap<String,Object>();

    private Map<String,Object> response = new HashMap<String,Object>();

    public Map<String, Object> getStatus() {
        return status;
    }

    public void setStatus(Map<String, Object> status) {
        this.status = status;
    }

    public Map<String, Object> getResponse() {
        return response;
    }

    public void setResponse(Map<String, Object> response) {
        this.response = response;
    }

}