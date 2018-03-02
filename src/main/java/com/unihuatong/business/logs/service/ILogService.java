package com.unihuatong.business.logs.service;

public interface ILogService {

	void save(String title, String content, String paramValue, String resultValue, String loginId);

}
