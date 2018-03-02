package com.unihuatong.business.auth.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.unihuatong.base.common.threadLocal.ParamsThreadLocal;
import com.unihuatong.base.manager.base.dao.IBaseDao;
import com.unihuatong.base.util.BaseUtils;
import com.unihuatong.business.auth.entity.User;
import com.unihuatong.business.auth.service.IUserService;

/**
 * @Description TODO(用一句话描述该文件做什么)
 * @author 戚兆宇
 * @date 2018年2月27日 下午1:40:35
 *
 */
@Service
public class UserServiceImpl implements IUserService {

	@Autowired
	private IBaseDao baseDao;

	/**
	 * @Description: 根据用户名密码获取用户对象
	 * @param 参数信息
	 * @return 返回信息
	 * @Exception 异常信息
	 *
	 */
	public User getUserByLoginNameAndPassword() {

		return baseDao.findForObject("getUserByLoginNameAndPassword");
	}

	/**
	 * @Description: 新增用户
	 * @param 参数信息
	 * @return 返回信息
	 * @Exception 异常信息
	 *
	 */
	public void addUser() {
		String userId = BaseUtils.getUUID();
		ParamsThreadLocal.put("id", userId);
		baseDao.save("addUser");
	}

	/**
	 * @Description: 新增用户
	 * @param 参数信息
	 * @return 返回信息
	 * @Exception 异常信息
	 *
	 */
	public void updateUser() {
		baseDao.save("updateUser");
	}
}
