package com.unihuatong.base.common.threadLocal;

import com.unihuatong.base.common.entity.MybatisStatementEntity;

/**
 * @Description TODO(用一句话描述该文件做什么)
 * @author 戚兆宇
 * @date 2018年2月24日 下午2:32:03
 *
 */
public class MybatisStatementLocal {
	public static ThreadLocal<MybatisStatementEntity> mybatisStatementLocal = new ThreadLocal<MybatisStatementEntity>();

	public static void set(MybatisStatementEntity mybatisStatementEntity) {
		mybatisStatementLocal.set(mybatisStatementEntity);
	}

	public static String getNamespace() {
		MybatisStatementEntity mybatisStatementEntity = mybatisStatementLocal.get();
		if (mybatisStatementEntity != null) {
			return mybatisStatementEntity.getNamespace();
		}
		return "";
	}

	public static String getStatement() {
		MybatisStatementEntity mybatisStatementEntity = mybatisStatementLocal.get();
		if (mybatisStatementEntity != null) {
			return mybatisStatementEntity.getStatement();
		}
		return "";
	}

	public static String getAllStatement() {
		MybatisStatementEntity mybatisStatementEntity = mybatisStatementLocal.get();
		if (mybatisStatementEntity != null) {
			return mybatisStatementEntity.toString();
		}
		return "";
	}

	public static void remove() {
		mybatisStatementLocal.remove();
	}
}
