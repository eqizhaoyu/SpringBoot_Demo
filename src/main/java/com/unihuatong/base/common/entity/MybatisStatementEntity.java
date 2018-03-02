package com.unihuatong.base.common.entity;

import java.io.Serializable;

/**
 * @Description Mybatis Statement的实体类
 * @author 张永斌
 * @date 2017年11月20日 上午9:48:14
 */

public class MybatisStatementEntity implements Serializable {

	private static final long serialVersionUID = -7318666791506016053L;

	private String namespace = "";
	private String statement = "";

	public String getNamespace() {
		return namespace;
	}

	public void setNamespace(String namespace) {
		this.namespace = namespace;
	}

	public String getStatement() {
		return statement;
	}

	public void setStatement(String statement) {
		this.statement = statement;
	}

	@Override
	public String toString() {
		return namespace + "." + statement;
	}
	

}
