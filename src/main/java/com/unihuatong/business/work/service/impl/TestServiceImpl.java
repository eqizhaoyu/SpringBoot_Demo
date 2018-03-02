package com.unihuatong.business.work.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.unihuatong.base.common.threadLocal.ParamsThreadLocal;
import com.unihuatong.base.manager.base.dao.IBaseDao;
import com.unihuatong.base.util.BaseUtils;
import com.unihuatong.business.work.service.ITestService;

/**
 * @Description TODO(用一句话描述该文件做什么)
 * @author 戚兆宇
 * @date 2018年2月28日 下午3:28:48
 *
 */
@Service
public class TestServiceImpl implements ITestService {

	@Autowired
	private IBaseDao baseDao;

	public Object selectObj(String str) {
		ParamsThreadLocal.put("id", str);
		return baseDao.findForObject("selectObj");
	}

	public Object selectList() {
		return baseDao.findForList("selectList");
	}

	public void addObj() {
		ParamsThreadLocal.put("id", BaseUtils.getUUID());
		baseDao.save("addObj");
	}

	public void updateObj() {
		baseDao.update("updateObj");
	}

	public void deleteObj() {
		baseDao.delete("deleteObj");
	}
}
