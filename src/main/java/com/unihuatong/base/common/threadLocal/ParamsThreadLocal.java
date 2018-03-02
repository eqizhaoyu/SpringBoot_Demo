package com.unihuatong.base.common.threadLocal;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.alibaba.fastjson.JSONArray;

/**
 * @Description 
 * @author 张永斌
 * @date 2017年11月20日 下午2:08:26
 */

public class ParamsThreadLocal {
	private static ThreadLocal<Map<String, Object>> paramThreadLocal = new ThreadLocal<Map<String, Object>>(){
		@Override
		protected Map<String, Object> initialValue() {
			return new HashMap<String, Object>();
		}
	};
	
	/**
	 * 
	 * @Description 增加参数
	 * @param key
	 * @param value
	 */
	public static void put(String key, Object value) {
		paramThreadLocal.get().put(key, value);
	}
	
	/**
	 * 
	 * @Description 获取参数
	 * @param key
	 * @return
	 */
	public static Object get(String key) {
		return paramThreadLocal.get().get(key);
	}
	
	/**
	 * 
	 * @Description 增加所有参数
	 * @param map
	 */
	public static void putAll(Map<String, Object> map) {
		paramThreadLocal.get().putAll(map);
	}
	
	/**
	 * 
	 * @Description 获取所有参数
	 * @return
	 */
	public static Map<String, Object> getAll() {
		return paramThreadLocal.get();
	}
	
	/**
	 * 
	 * @Description 删除参数
	 * @param paramNames
	 */
	public static void removeRequestParam(String... paramNames){
		Map<String, Object> requestParamMap = paramThreadLocal.get();
		for(String paramName : paramNames){
			requestParamMap.remove(paramName);
		}
	}
	
	/**
	 * 
	 * @Description 修改参数名
	 * @param oldName 老参数名
	 * @param newName 新参数名
	 */
	public static void changeRequestParamName(String oldName, String newName){
		Map<String, Object> requestParamMap = paramThreadLocal.get();
		if(requestParamMap.containsKey(oldName)){
			Object paramVal = requestParamMap.get(oldName);
			requestParamMap.put(newName, paramVal);
			requestParamMap.remove(oldName);
		}
	}
	
	/**
	 * 
	 * @Description 获取List对象
	 * @param key
	 * @param clazz 格式化对象中的泛型
	 * @return
	 */
	public static <T> List<T> getList(String key, Class<T> clazz){
		if(paramThreadLocal.get().get(key) == null) {
			return null;
		}
		JSONArray obj = (JSONArray) paramThreadLocal.get().get(key);
		return obj.toJavaList(clazz);
	}
	
	/**
	 * 
	 * @Description 清除ThreadLocal缓存，   慎用！！！！！！
	 */
	public static void remove() {
		paramThreadLocal.remove();
	}

}
