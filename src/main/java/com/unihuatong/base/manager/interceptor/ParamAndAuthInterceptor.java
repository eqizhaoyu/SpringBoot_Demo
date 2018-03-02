package com.unihuatong.base.manager.interceptor;

import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.IOUtils;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.alibaba.druid.util.StringUtils;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.unihuatong.base.common.annotation.NotNeedLogin;
import com.unihuatong.base.common.entity.ExceptionEnum;
import com.unihuatong.base.common.exception.BusinessException;
import com.unihuatong.base.common.threadLocal.ParamsThreadLocal;
import com.unihuatong.base.common.threadLocal.SessionThreadLocal;
import com.unihuatong.base.manager.session.SessionManager;
import com.unihuatong.base.manager.session.entity.TransSession;

public class ParamAndAuthInterceptor implements HandlerInterceptor {

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		// 初始化参数
		byte[] paramBytes = IOUtils.toByteArray(request.getInputStream());
		JSONObject jsonObject = JSON.parseObject(new String(paramBytes));
		dealJsonObject(ParamsThreadLocal.getAll(), jsonObject);

		// 判断权限
		String uid = (String) ParamsThreadLocal.getAll().get("uid");
		TransSession session = TransSession.getSession(uid);
		SessionThreadLocal.set(session);

		HandlerMethod hm = (HandlerMethod) handler;
		NotNeedLogin notNeedLogin = hm.getMethod().getAnnotation(NotNeedLogin.class);
		if (notNeedLogin == null) {
			String loginId = session.getLoginId();
			if (StringUtils.isEmpty(loginId)) {
				throw new BusinessException(ExceptionEnum.NEED_LOGIN);
			}
		}
		return true;
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {

	}

	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		SessionManager.refresh();
		ParamsThreadLocal.remove();
		SessionThreadLocal.remove();
	}

	private void dealJsonObject(Map<String, Object> jsonMap, JSONObject jsonObject) {
		if (jsonObject != null) {
			Set<String> keySet = jsonObject.keySet();
			Iterator<String> it = keySet.iterator();
			while (it.hasNext()) {
				String key = it.next();
				Object obj = jsonObject.get(key);
				if (obj instanceof JSONObject) {
					dealJsonObject(jsonMap, (JSONObject) obj);
				} else {
					jsonMap.put(key, obj);
				}
			}
		}
	}

}
