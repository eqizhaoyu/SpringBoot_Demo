package com.unihuatong.base.manager.session.cache.local;

import com.unihuatong.base.manager.session.cache.ISessionCache;
import com.unihuatong.base.manager.session.entity.TransSession;

public class LocalSessionCacheImpl implements ISessionCache{

	@Override
	public TransSession getSession(String id) {
		return SessionMap.getSessionCache(id);
	}

	@Override
	public void setSession(TransSession session) {
		SessionMap.setSessionCache(session);
	}

	@Override
	public void remove(String id) {
		SessionMap.removeSessionCache(id);
	}

}
