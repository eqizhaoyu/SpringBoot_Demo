package com.unihuatong.base.manager.session.cache;

import com.unihuatong.base.manager.session.entity.TransSession;

public interface ISessionCache {
	
	TransSession getSession(String id);
	void setSession(TransSession session);
	void remove(String id);
}
