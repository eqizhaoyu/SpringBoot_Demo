package com.unihuatong.base.manager.session;

import com.unihuatong.base.common.threadLocal.SessionThreadLocal;
import com.unihuatong.base.manager.session.entity.TransSession;

public class SessionManager {
	public static TransSession getSession(String id) {
		return SessionFactory.getSessionCache().getSession(id);
	}

	public static void setSession(TransSession session) {
		SessionFactory.getSessionCache().setSession(session);
	}

	public static void removeSession(String id) {
		SessionFactory.getSessionCache().remove(id);
	}

	public static void refresh() {
		if (SessionThreadLocal.get() != null) {
			setSession(SessionThreadLocal.get());
		}
	}
}
