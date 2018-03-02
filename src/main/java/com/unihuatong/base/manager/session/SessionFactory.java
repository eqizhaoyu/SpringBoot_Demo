package com.unihuatong.base.manager.session;

import com.unihuatong.base.common.exception.BusinessException;
import com.unihuatong.base.common.threadLocal.ParamConfigLocal;
import com.unihuatong.base.manager.session.cache.ISessionCache;
import com.unihuatong.base.manager.session.cache.local.LocalSessionCacheImpl;

public class SessionFactory {
	public static ISessionCache sessionCache;

	private SessionFactory() {
	}

	public static ISessionCache getSessionCache() {
		if (sessionCache == null) {
			init();
		}
		return sessionCache;
	}

	private static void init() {
		if ("local".equals(ParamConfigLocal.paramConfig.getSessionType())) {
			sessionCache = new LocalSessionCacheImpl();
		} else {
			throw new BusinessException("获取session缓存方式失败");
		}
	}

}
