package com.unihuatong.business.auth.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.unihuatong.base.common.annotation.LogRecord;
import com.unihuatong.base.common.annotation.NotNeedLogin;
import com.unihuatong.base.common.entity.BaseResult;
import com.unihuatong.base.common.entity.ResultEnum;
import com.unihuatong.base.common.exception.BusinessException;
import com.unihuatong.base.common.threadLocal.ParamsThreadLocal;
import com.unihuatong.base.common.threadLocal.SessionThreadLocal;
import com.unihuatong.base.util.BaseUtils;
import com.unihuatong.business.auth.entity.User;
import com.unihuatong.business.auth.service.IUserService;

/**
 * @Description TODO(用一句话描述该文件做什么)
 * @author 戚兆宇
 * @date 2018年2月22日 上午9:43:17
 *
 */
@RestController
public class UserController {

	@Autowired
	private IUserService userService;

	@RequestMapping("/login")
	@LogRecord(title = "后台登录", content = "人员登录")
	@NotNeedLogin
	public Object login() {
		System.out.println(ParamsThreadLocal.get("loginName"));
		System.out.println(ParamsThreadLocal.get("password"));
		User user = userService.getUserByLoginNameAndPassword();

		if (user == null) {
			throw new BusinessException("帐号不存在或者用户名密码错误，请重试!", ResultEnum.SERVICE_ERROR.getCode());// 没有帐号
		}

		SessionThreadLocal.setUser(user);

		Map<String, Object> map = new HashMap<String, Object>();
		ParamsThreadLocal.put("uid", BaseUtils.getUUID());

		map.put("id", user.getId());
		map.put("realName", user.getRealName());
		map.put("uid", ParamsThreadLocal.get("uid"));

		BaseResult baseResult = new BaseResult();
		baseResult.setCode(ResultEnum.SUCCESS.getCode());
		baseResult.setMsg(ResultEnum.SUCCESS.getMsg());
		baseResult.setObj(map);

		return baseResult;
	}

	@RequestMapping("/addUser")
	@LogRecord(title = "用户管理", content = "新增用户")
	@NotNeedLogin
	public Object addUser() {
		userService.addUser();
		return "插入成功";
	}

	@RequestMapping("/updateUser")
	@LogRecord(title = "用户管理", content = "修改用户")
	@NotNeedLogin
	public Object updateUser() {
		userService.updateUser();
		return "用户修改成功";
	}
}
