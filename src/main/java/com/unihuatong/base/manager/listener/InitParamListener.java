package com.unihuatong.base.manager.listener;

import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;

import com.unihuatong.base.common.threadLocal.ParamConfigLocal;
import com.unihuatong.base.configuration.ParamConfig;

public class InitParamListener implements ApplicationListener<ContextRefreshedEvent> {

	@Override
	public void onApplicationEvent(ContextRefreshedEvent event) {
		ParamConfigLocal.paramConfig = event.getApplicationContext().getBean(ParamConfig.class);
	}

}
