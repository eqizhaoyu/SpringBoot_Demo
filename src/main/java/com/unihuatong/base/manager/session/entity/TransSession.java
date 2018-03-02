package com.unihuatong.base.manager.session.entity;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import com.alibaba.druid.util.StringUtils;
import com.unihuatong.base.common.threadLocal.SessionThreadLocal;
import com.unihuatong.base.manager.session.SessionManager;
import com.unihuatong.business.auth.entity.User;

public class TransSession implements Serializable {

	private static final long serialVersionUID = -7154300285263126319L;

	private String id;
	private String loginId;
	private Map<String, Object> paramMap = new HashMap<String, Object>();

	public static TransSession getSession(String id) {
		TransSession session = null;
		if (StringUtils.isEmpty(id)) {
			id = UUID.randomUUID().toString().replaceAll("-", "");
			session = new TransSession(id);
			SessionManager.setSession(session);
		} else {
			session = SessionManager.getSession(id);
			if (session == null) {
				session = new TransSession(id);
				SessionManager.setSession(session);
			}
		}
		return session;
	}

	private TransSession(String id) {
		this.id = id;
	}

	public String getId() {
		return id;
	}

	public String getLoginId() {
		return loginId;
	}

	public void setLoginId(String loginId) {
		this.loginId = loginId;
	}

	public void setAttr(String key, Object value) {
		paramMap.put(key, value);
	}

	public Object getAttr(String key) {
		return paramMap.get(key);
	}

	public void removeAttr(String key) {
		paramMap.remove(key);
	}

	public void destorySession() {
		SessionManager.removeSession(id);
		SessionThreadLocal.remove();
	}

	private User user;

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
}
