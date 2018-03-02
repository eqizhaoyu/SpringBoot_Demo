package com.unihuatong.base.manager.aop;

import java.lang.reflect.Method;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.alibaba.fastjson.JSON;
import com.unihuatong.base.common.annotation.LogRecord;
import com.unihuatong.base.common.threadLocal.ParamsThreadLocal;
import com.unihuatong.base.common.threadLocal.SessionThreadLocal;
import com.unihuatong.business.auth.entity.User;
import com.unihuatong.business.logs.service.ILogService;

@Aspect
@Component
public class LogAspect {

	@Autowired
	private ILogService logService;

	@Pointcut("@annotation(com.unihuatong.base.common.annotation.LogRecord)")
	public void execute() {
	}

	@Around("execute()")
	public Object doAround(ProceedingJoinPoint pjp) throws Throwable {
		Signature sig = pjp.getSignature();
		MethodSignature msig = (MethodSignature) sig;
		Object target = pjp.getTarget();
		Method currentMethod = target.getClass().getMethod(msig.getName(), msig.getParameterTypes());

		LogRecord logRecord = currentMethod.getAnnotation(LogRecord.class);
		String paramValue = null;
		String resultValue = null;
		String loginId = null;
		Object result = null;
		try {
			paramValue = JSON.toJSONString(ParamsThreadLocal.getAll());
			User curUser = SessionThreadLocal.getUser();
			if (curUser != null) {
				loginId = curUser.getId();
			}
			result = pjp.proceed();
			resultValue = JSON.toJSONString(result);

			logService.save(logRecord.title(), logRecord.content(), paramValue, resultValue, loginId);
		} catch (Exception e) {
			resultValue = e.getMessage();
			logService.save(logRecord.title(), logRecord.content(), paramValue, resultValue, loginId);
			throw e;
		}
		return result;
	}

}
