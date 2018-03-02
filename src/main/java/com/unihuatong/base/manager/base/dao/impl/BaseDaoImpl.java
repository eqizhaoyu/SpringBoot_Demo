package com.unihuatong.base.manager.base.dao.impl;

import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.alibaba.druid.util.StringUtils;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.unihuatong.base.common.entity.PageResult;
import com.unihuatong.base.common.threadLocal.MybatisStatementLocal;
import com.unihuatong.base.common.threadLocal.ParamsThreadLocal;
import com.unihuatong.base.manager.base.dao.IBaseDao;
import com.unihuatong.business.logs.entity.OpLog;

@Repository
public class BaseDaoImpl implements IBaseDao {

	@Autowired
	private SqlSessionTemplate sqlSessionTemplate;

	@Override
	public Object save(String statement) {
		return sqlSessionTemplate.insert(getPrefixStatement(statement), ParamsThreadLocal.getAll());
	}

	@Override
	public Object update(String statement) {
		return sqlSessionTemplate.update(getPrefixStatement(statement), ParamsThreadLocal.getAll());
	}

	@Override
	public Object delete(String statement) {
		return sqlSessionTemplate.delete(getPrefixStatement(statement), ParamsThreadLocal.getAll());
	}

	@Override
	public <T> T findForObject(String statement) {
		return sqlSessionTemplate.selectOne(getPrefixStatement(statement), ParamsThreadLocal.getAll());
	}

	@Override
	public <T> List<T> findForList(String statement) {
		return sqlSessionTemplate.selectList(getPrefixStatement(statement), ParamsThreadLocal.getAll());
	}

	private String getPrefixStatement(String statement) {
		if (StringUtils.isEmpty(statement)) {
			return MybatisStatementLocal.getAllStatement();
		} else if (statement.indexOf(".") > -1) {
			return statement;
		}
		return MybatisStatementLocal.getNamespace() + "." + statement;
	}

	@Override
	public PageResult findListPage(String statement) {
		Map<String, Object> paramMap = ParamsThreadLocal.getAll();
		int pageNo = (int) paramMap.getOrDefault("pageNo", 1);
		int pageSize = (int) paramMap.getOrDefault("pageSize", 10);

		PageResult basePageEntity = new PageResult();

		PageHelper.startPage(pageNo, pageSize);
		List<Object> list = sqlSessionTemplate.selectList(getPrefixStatement(statement), paramMap);
		PageInfo<Object> pageInfo = new PageInfo<Object>(list);
		basePageEntity.setTotalCount(pageInfo.getTotal());
		basePageEntity.setResult(list);
		basePageEntity.setPageNo(pageNo);
		basePageEntity.setPageSize(pageSize);
		return basePageEntity;
	}

	@Override
	public void saveLog(OpLog opLog) {
		sqlSessionTemplate.insert("LogServiceImpl.saveLog", opLog);
	}

}
