package com.unihuatong.business.logs.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.unihuatong.base.manager.base.dao.IBaseDao;
import com.unihuatong.base.util.BaseUtils;
import com.unihuatong.business.logs.entity.OpLog;
import com.unihuatong.business.logs.service.ILogService;

@Service("logService")
public class LogServiceImpl implements ILogService {

	@Resource
	private IBaseDao baseDao;

	@Override
	public void save(String title, String content, String paramValue, String resultValue, String loginId) {
		new Thread(new Runnable() {
			@Override
			public void run() {
				OpLog opLog = new OpLog();

				StringBuffer logInfoForDB = new StringBuffer();

				logInfoForDB.append("入参: <! ").append(paramValue).append(" !>  ");
				logInfoForDB.append("出参: <! ").append(resultValue).append(" !>  ");

				opLog.setId(BaseUtils.getUUID());
				opLog.setTitle(title);
				opLog.setContent(content);
				opLog.setUserId(loginId);
				opLog.setParameter(logInfoForDB.toString());

				baseDao.saveLog(opLog);
			}
		}).start();

	}
}
