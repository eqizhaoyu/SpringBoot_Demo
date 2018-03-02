package com.unihuatong.business.work.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.unihuatong.base.common.annotation.NotNeedLogin;
import com.unihuatong.business.work.service.ITestService;

/**
 * @Description TODO(用一句话描述该文件做什么)
 * @author 戚兆宇
 * @date 2018年2月28日 下午3:28:04
 *
 */
@RestController
@RequestMapping("/test")
public class TestController {

	@Autowired
	private ITestService testService;

	@RequestMapping("/selectObj/{id}")
	@NotNeedLogin
	public Object selectObj(@PathVariable(value = "id") String testId) {
		return testService.selectObj(testId);
	}

	@RequestMapping("/selectList")
	@NotNeedLogin
	public Object selectList() {
		return testService.selectList();
	}

	@RequestMapping("/addObj")
	@NotNeedLogin
	public Object addObj() {
		testService.addObj();
		return "插入成功！";
	}

	@RequestMapping("/updateObj")
	@NotNeedLogin
	public Object updateObj() {
		testService.updateObj();
		return "插入成功！";
	}

	@RequestMapping("/deleteObj")
	@NotNeedLogin
	public Object deleteObj() {
		testService.deleteObj();
		return "删除成功！";
	}
}
