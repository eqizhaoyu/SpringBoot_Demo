package com.unihuatong.base.util;

import java.util.UUID;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @Description TODO(用一句话描述该文件做什么)
 * @author 戚兆宇
 * @date 2018年2月28日 下午2:03:49
 *
 */
public class BaseUtils {

	/**
	 * 
	 * @Description 获取系统UUID
	 * @param patten
	 * @return
	 */
	public static synchronized String getUUID() {
		return UUID.randomUUID().toString().replaceAll("-", "");
	}

	/**
	 * @Description 如果str 符合 regex的正则表达式格式,返回true, 否则返回 false;
	 * @param regex
	 *            正则表达式字符串
	 * @param str
	 *            要匹配的字符串
	 * @return
	 */
	public static boolean match(String regex, String str) {
		if (regex == null) {
			return false;
		}
		Pattern pattern = Pattern.compile(regex);
		Matcher matcher = pattern.matcher(str);
		return matcher.matches();
	}

}
