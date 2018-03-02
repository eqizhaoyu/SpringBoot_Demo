package com.unihuatong.base.common.entity;

public enum ExceptionEnum {
	NEED_LOGIN("1000", "请先登录");

	private String errorCode;
	private String errorMsg;

	ExceptionEnum(String errorCode, String errorMsg) {
		this.errorCode = errorCode;
		this.errorMsg = errorMsg;
	}

	public String getErrorCode() {
		return errorCode;
	}

	public String getErrorMsg() {
		return errorMsg;
	}

}
