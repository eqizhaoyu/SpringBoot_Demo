package com.unihuatong.base.common.exception;

/**
 * @Description 系统异常
 * @author 张永斌
 * @date 2017年11月16日 下午3:10:51
 */

public class SystemException extends RuntimeException {

	private static final long serialVersionUID = 5857632634722827701L;

	private String errorCode;

	public SystemException() {
	}

	public SystemException(String message) {
		super(message);
	}

	public SystemException(String message, String errorCode) {
		super(message);
		this.errorCode = errorCode;
	}

	public SystemException(Throwable cause, String errorCode) {
		super(cause);
		this.errorCode = errorCode;
	}

	public SystemException(Throwable cause, String message, String errorCode) {
		super(message, cause);
		this.errorCode = errorCode;
	}

	public String getErrorCode() {
		return errorCode;
	}
}
