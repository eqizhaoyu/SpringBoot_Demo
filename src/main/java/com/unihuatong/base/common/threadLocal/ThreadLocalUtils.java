package com.unihuatong.base.common.threadLocal;

import com.unihuatong.base.manager.session.SessionManager;

public class ThreadLocalUtils {

	public static void destoryAll() {
		SessionManager.refresh();
		ParamsThreadLocal.remove();
		MybatisStatementLocal.remove();
		SessionThreadLocal.remove();
	}

}
