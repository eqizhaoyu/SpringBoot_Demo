package com.unihuatong.base.application;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;

import com.unihuatong.base.manager.listener.InitParamListener;

@SpringBootApplication
@ComponentScan("com.unihuatong")
public class TransportApplication extends SpringBootServletInitializer {
	// 继承SpringBootServletInitializer覆盖configure方法
	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
		return builder.sources(TransportApplication.class);
	}

	public static void main(String[] args) {
		SpringApplication app = new SpringApplication(TransportApplication.class);
		app.addListeners(new InitParamListener());
		app.run(args);
		// SpringApplication.run(TransportApplication.class, args);
	}
}
