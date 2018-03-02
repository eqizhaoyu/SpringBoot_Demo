package com.unihuatong.base.common.threadLocal;

import com.unihuatong.base.manager.session.entity.TransSession;
import com.unihuatong.business.auth.entity.User;

/**
 * @Description TODO(用一句话描述该文件做什么)
 * @author 戚兆宇
 * @date 2018年2月24日 下午2:39:54
 *
 */
public class SessionThreadLocal {
	public static ThreadLocal<TransSession> sessionLocal = new ThreadLocal<TransSession>();

	public static void set(TransSession session) {
		sessionLocal.set(session);
	}

	public static TransSession get() {
		return sessionLocal.get();
	}

	public static void remove() {
		sessionLocal.remove();
	}

	public static User getUser() {
		return sessionLocal.get().getUser();
	}

	public static void setUser(User user) {
		sessionLocal.get().setUser(user);
	}

}
