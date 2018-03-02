package com.unihuatong.base.common.exception;

import com.unihuatong.base.common.entity.ExceptionEnum;

/**
 * @Description 业务异常
 * @author 张永斌
 * @date 2017年11月16日 下午3:11:05
 */

public class BusinessException extends RuntimeException {

	private static final long serialVersionUID = -8761106488658657064L;

	private String errorCode;

	public BusinessException() {
	}

	public BusinessException(String message) {
		super(message);
	}

	public BusinessException(String message, String errorCode) {
		super(message);
		this.errorCode = errorCode;
	}

	public BusinessException(Throwable cause, String errorCode) {
		super(cause);
		this.errorCode = errorCode;
	}

	public BusinessException(Throwable cause, String message, String errorCode) {
		super(message, cause);
		this.errorCode = errorCode;
	}

	public String getErrorCode() {
		return errorCode;
	}

	public BusinessException(ExceptionEnum exceptionEnum) {
		super(exceptionEnum.getErrorMsg());
		this.errorCode = exceptionEnum.getErrorCode();
	}
}
