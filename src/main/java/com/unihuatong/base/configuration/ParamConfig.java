package com.unihuatong.base.configuration;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ParamConfig {
	@Value("${session_type}")
	private String sessionType;
	
	@Value("${session_timeout}")
	private Integer sessionTimeout;
	
	@Value("${aop_log_type}")
	private String aopLogType;

	public String getSessionType() {
		return sessionType;
	}

	public void setSessionType(String sessionType) {
		this.sessionType = sessionType;
	}

	public Integer getSessionTimeout() {
		return sessionTimeout;
	}

	public void setSessionTimeout(Integer sessionTimeout) {
		this.sessionTimeout = sessionTimeout;
	}

	public String getAopLogType() {
		return aopLogType;
	}

	public void setAopLogType(String aopLogType) {
		this.aopLogType = aopLogType;
	}

}
