package com.unihuatong.base.common.entity;

/**
 * @Description 返回值枚举
 * @author 戚兆宇
 * @date 2017年2月28日 下午4:31:17
 */

public enum ResultEnum {

	SUCCESS("0", "处理成功"), TIMEOUT("-1", "登录超时"), SERVICE_ERROR("-2", "业务错误"), SYS_ERROR("-3", "系统错误");

	private String code;// 错误码
	private String msg;// 显示信息

	ResultEnum(String code, String msg) {
		this.code = code;
		this.msg = msg;
	}

	public String getCode() {
		return code;
	}

	public String getMsg() {
		return msg;
	}

}
