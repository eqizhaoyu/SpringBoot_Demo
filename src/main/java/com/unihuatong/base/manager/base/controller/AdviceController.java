package com.unihuatong.base.manager.base.controller;

import java.io.IOException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.unihuatong.base.common.entity.BaseResult;
import com.unihuatong.base.common.entity.ResultEnum;
import com.unihuatong.base.common.exception.BusinessException;

@RestControllerAdvice
public class AdviceController {

	private final static Logger logger = LoggerFactory.getLogger(AdviceController.class);

	/**
	 * 基于@ExceptionHandler异常处理
	 * 
	 * @throws IOException
	 */
	@ExceptionHandler(value = { Exception.class })
	public BaseResult executeException(Exception ex) {
		logger.error("系统异常", ex);

		BaseResult baseResult = new BaseResult();
		baseResult.setCode(ResultEnum.SYS_ERROR.getCode());
		baseResult.setMsg(ResultEnum.SYS_ERROR.getMsg());
		return baseResult;
	}

	@ExceptionHandler(value = { BusinessException.class })
	public BaseResult executeBussinessException(BusinessException ex) {
		BaseResult baseResult = new BaseResult();
		String errCode = ex.getErrorCode();
		String errMsg = ex.getMessage();

		if (StringUtils.isEmpty(errCode)) {
			baseResult.setCode(ResultEnum.SERVICE_ERROR.getCode());
		} else {
			baseResult.setCode(errCode);
		}

		if (StringUtils.isEmpty(errMsg)) {
			baseResult.setMsg(ResultEnum.SERVICE_ERROR.getMsg());
		} else {
			baseResult.setMsg(errMsg);
		}
		return baseResult;
	}

}
