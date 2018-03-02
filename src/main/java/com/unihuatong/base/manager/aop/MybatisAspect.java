package com.unihuatong.base.manager.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import com.unihuatong.base.common.entity.MybatisStatementEntity;
import com.unihuatong.base.common.threadLocal.MybatisStatementLocal;

@Aspect
@Component
public class MybatisAspect {

	@Pointcut("execution (* com.unihuatong.business..*.service.impl.*.*(..))")
	public void execute() {
	}

	@Before("execute()")
	public void doBefore(JoinPoint joinPoint) throws Throwable {
		MybatisStatementEntity mybatisStatementEntity = new MybatisStatementEntity();
		mybatisStatementEntity.setNamespace(joinPoint.getTarget().getClass().getSimpleName());
		mybatisStatementEntity.setStatement(joinPoint.getSignature().getName());
		MybatisStatementLocal.set(mybatisStatementEntity);
	}

	@After("execute()")
	public void doAfter(JoinPoint joinPoint) throws Throwable {
		MybatisStatementLocal.remove();
	}
}
