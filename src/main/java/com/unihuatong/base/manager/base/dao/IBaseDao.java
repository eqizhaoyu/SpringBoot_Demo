package com.unihuatong.base.manager.base.dao;

import java.util.List;

import com.unihuatong.base.common.entity.PageResult;
import com.unihuatong.business.logs.entity.OpLog;

public interface IBaseDao {

	Object save(String statement);

	/**
	 * 修改对象
	 * 
	 * @param obj
	 * @return @
	 */
	Object update(String statement);

	/**
	 * 删除对象
	 * 
	 * @param obj
	 * @return @
	 */
	Object delete(String statement);

	/**
	 * 查找对象
	 * 
	 * @param obj
	 * @return @
	 */
	<T> T findForObject(String statement);

	/**
	 * 查找对象
	 * 
	 * @param obj
	 * @return @
	 */
	<T> List<T> findForList(String statement);

	/**
	 * 查询分页
	 * 
	 * @param statement
	 * @param basePageEntity
	 * @return
	 */
	PageResult findListPage(String statement);

	/**
	 * 保存日志
	 * 
	 * @param opLog
	 * @return
	 */
	void saveLog(OpLog opLog);
}
