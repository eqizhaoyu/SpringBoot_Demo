package com.unihuatong.business.auth.service;

import com.unihuatong.business.auth.entity.User;

/**
 * @Description TODO(用一句话描述该文件做什么)
 * @author 戚兆宇
 * @date 2018年2月22日 上午9:43:02
 *
 */
public interface IUserService {

	User getUserByLoginNameAndPassword();

	void addUser();

	void updateUser();
}
