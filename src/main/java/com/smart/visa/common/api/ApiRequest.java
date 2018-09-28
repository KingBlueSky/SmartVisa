package com.smart.visa.common.api;

import java.util.Map;

/**
 * 请求报文：
 * phoneType 1:安卓 2:ios;version:app版本号;secrectVersion:秘钥版本号;len:明文字节长度
 * {"header":{"phoneType":"1","homeId":2222222,"version":"0.1","secrectVersion":3,"len":3},"request":{"param":"XXXXX"}}
 * @author zhuxuanlin
 *
 */
public class ApiRequest {
	private Map<String,Object> header;
	
	private Map<String,Object> request;
	
	/**
	 * app传不了userId,在aop时获取userId并设置
	 */
	private Map<String, Object> userInfo;
	
	public Map<String, Object> getRequest() {
		return request;
	}

	public void setRequest(Map<String, Object> request) {
		this.request = request;
	}
	
	public Map<String, Object> getHeader() {
		return header;
	}
	public void setHeader(Map<String, Object> header) {
		this.header = header;
	}
	
	public Map<String, Object> getUserInfo() {
		return userInfo;
	}
	
	public void setUserInfo(Map<String, Object> userInfo) {
		this.userInfo = userInfo;
	}
}
