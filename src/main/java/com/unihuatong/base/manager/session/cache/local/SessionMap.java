package com.unihuatong.base.manager.session.cache.local;

import java.util.HashMap;
import java.util.Map;
import java.util.Timer;
import java.util.TimerTask;

import com.alibaba.druid.util.StringUtils;
import com.unihuatong.base.common.threadLocal.ParamConfigLocal;
import com.unihuatong.base.manager.session.entity.TransSession;

public class SessionMap {
	private static Map<String, SessionCache> sessionMap;

	static {
		if (sessionMap == null) {
			sessionMap = new HashMap<String, SessionCache>();
		}
	}

	protected static TransSession getSessionCache(String id) {
		SessionCache sessionCache = sessionMap.get(id);
		if (sessionCache != null) {
			return sessionCache.getSession();
		}
		return null;
	}

	protected static void setSessionCache(final TransSession session) {
		if (session != null && !StringUtils.isEmpty(session.getId())) {
			// 删除旧的Session的定时器
			SessionCache oldSession = sessionMap.get(session.getId());
			if (oldSession != null) {
				oldSession.stopThread();
			}

			// 创建新的session
			SessionCache sessionCache = new SessionCache();
			sessionCache.setSession(session);

			// 设定session定时器
			sessionCache.setThisThread(new TimerTask() {
				@Override
				public void run() {
					sessionMap.remove(session.getId());
				}
			});

			sessionMap.put(session.getId(), sessionCache);

			// 启动session定时器
			Timer timer = new Timer();
			timer.schedule(sessionCache.getThisThread(), ParamConfigLocal.paramConfig.getSessionTimeout() * 1000 * 60);
			// timer.schedule(sessionCache.getThisThread(), 1000 * 10);
		}
	}

	protected static void removeSessionCache(String id) {
		SessionCache sessionCache = sessionMap.get(id);
		if (sessionCache != null) {
			sessionCache.stopThread();
			sessionMap.remove(id);
		}
	}

}
