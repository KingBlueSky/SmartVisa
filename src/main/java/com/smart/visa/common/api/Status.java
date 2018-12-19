/******************************************************************************
 *  Copyright ©2016 ZQJ CO., LTD.
 ******************************************************************************/
package com.smart.visa.common.api;

/**
 * 使用的状态码:消息类 <br>
 * 命名规则：<br>
 * 用户功能：1xx<br>
 * 消息功能：2xx<br>
 * 系统功能：5xx<br>
 *
 * @author zhuxuanlin
 *
 */
public enum Status {

	STATUS_101(101, "token或userName不能为空"),
	STATUS_102(102, "token无效或过期"),
	STATUS_103(103, "生成邀请码成功"),
	STATUS_105(105, "请勿重复加入"),
	STATUS_106(106, "加入成功"),
	STATUS_109(109, "当前用户还未生成home"),
	STATUS_110(110, "用户注册信息添加成功"),
	STATUS_111(111, "用户登录信息添加成功"),
	STATUS_112(112, "用户关注信息添加成功"),
	STATUS_113(113, "用户信息不存在"),
	STATUS_114(114, "用户查找成功"),
	STATUS_501(501, "获取成功"),
	STATUS_502(502, "天气获取失败"),
	STATUS_503(503, "请填写意见和联系方式"),
	STATUS_504(504, "长度非法"),
	STATUS_505(505, "发送失败"),
	
	STATUS_701(701, "获取成功"),
	STATUS_702(702, "发送执行指令成功"),
	STATUS_703(703, "添加成功"),
	STATUS_704(704, "修改成功"),
	STATUS_705(705, "删除成功"),
	STATUS_706(706, "重命名成功"),
	STATUS_708(708, "图片上传成功"),
	STATUS_709(709, "场景日志清除成功"),
	
	STATUS_995(995, "操作成功"),
	STATUS_996(996, "操作失败"),
	STATUS_997(997, "服务器返回加密失败"),
	STATUS_998(998, "服务器解密失败"),
	STATUS_999(999, "系统异常");

	/**
	 * 状态码
	 */
	private int code;

	/**
	 * 消息
	 */
	private String msg;

	/**
	 * 构造函数
	 * 
	 * @param code
	 * @param msg
	 */
	private Status(int code, String msg) {
		this.code = code;
		this.msg = msg;
	}

	/**
	 * 取得 状态码
	 * 
	 * @return 状态码
	 */
	public int getCode() {
		return code;
	}

	/**
	 * 取得 消息
	 * 
	 * @return 消息
	 */
	public String getMsg() {
		return msg;
	}

}
