package com.unihuatong.base.manager.base.controller;

import org.springframework.core.MethodParameter;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;

import com.unihuatong.base.common.entity.BaseResult;
import com.unihuatong.base.common.entity.ResultEnum;

@RestControllerAdvice
public class ResponseResultController implements ResponseBodyAdvice<Object> {

	@Override
	public boolean supports(MethodParameter returnType, Class<? extends HttpMessageConverter<?>> converterType) {
		return true;
	}

	@Override
	public Object beforeBodyWrite(Object body, MethodParameter returnType, MediaType selectedContentType,
			Class<? extends HttpMessageConverter<?>> selectedConverterType, ServerHttpRequest request,
			ServerHttpResponse response) {
		if (body instanceof BaseResult || body instanceof byte[] || body instanceof InputStreamResource) {
			return body;
		}
		BaseResult baseResult = new BaseResult();
		baseResult.setCode(ResultEnum.SUCCESS.getCode());
		baseResult.setMsg(ResultEnum.SUCCESS.getMsg());
		baseResult.setObj(body);
		// baseResult.setUid(String.valueOf(ParamsThreadLocal.get("uid")));
		return baseResult;
	}

}
