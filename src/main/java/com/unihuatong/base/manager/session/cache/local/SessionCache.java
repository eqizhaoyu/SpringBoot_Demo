package com.unihuatong.base.manager.session.cache.local;

import java.io.Serializable;
import java.util.TimerTask;

import com.unihuatong.base.manager.session.entity.TransSession;

public class SessionCache implements Serializable {

	private static final long serialVersionUID = 2488817797438712333L;

	private TransSession session;
	private TimerTask thisThread;

	protected TransSession getSession() {
		return session;
	}

	protected void setSession(TransSession session) {
		this.session = session;
	}

	protected TimerTask getThisThread() {
		return thisThread;
	}

	protected void setThisThread(TimerTask thisThread) {
		this.thisThread = thisThread;
	}

	protected void stopThread(){
		thisThread.cancel();
	}
}
