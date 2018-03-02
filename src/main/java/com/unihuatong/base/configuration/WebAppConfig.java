package com.unihuatong.base.configuration;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import com.unihuatong.base.manager.interceptor.ParamAndAuthInterceptor;

@Configuration
public class WebAppConfig extends WebMvcConfigurerAdapter {

	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		super.addInterceptors(registry);
		registry.addInterceptor(new ParamAndAuthInterceptor()).addPathPatterns("/**").excludePathPatterns("/druid/**");
		// registry.addInterceptor(new
		// MybatisStatementInterceptor()).addPathPatterns("/**")
		// .excludePathPatterns("/druid/**");
	}

}
