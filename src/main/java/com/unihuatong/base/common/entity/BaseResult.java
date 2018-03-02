package com.unihuatong.base.common.entity;

import java.io.Serializable;

/**
 * @Description 返回结果数据
 * @author 戚兆宇
 * @date 2017年2月28日 下午2:46:07
 */
public class BaseResult implements Serializable {
	private static final long serialVersionUID = -3384268589179097369L;
	private String msg;// 处理信息
	private Object obj;// 返回对象
	private String code; // 返回值码
	// private String uid;// 账号的uid

	public Object getObj() {
		return obj;
	}

	public void setObj(Object obj) {
		this.obj = obj;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	// public String getUid() {
	// return uid;
	// }
	//
	// public void setUid(String uid) {
	// this.uid = uid;
	// }

}
