package com.unihuatong.business.logs.entity;

import java.io.Serializable;

/**
 * @Description
 * @author 戚兆宇
 * @date 2017年2月28日 下午3:48:53
 */

public class OpLog implements Serializable {

	private static final long serialVersionUID = 360195681688716100L;

	private String id;
	private String title;
	private String content;
	private String userId;
	private String opTime;
	private String parameter;

	/**
	 * 获取id
	 * 
	 * @return id
	 */
	public String getId() {
		return id;
	}

	/**
	 * 设置id
	 * 
	 * @param id
	 */
	public void setId(String id) {
		this.id = id;
	}

	/**
	 * 获取title
	 * 
	 * @return title
	 */
	public String getTitle() {
		return title;
	}

	/**
	 * 设置title
	 * 
	 * @param title
	 */
	public void setTitle(String title) {
		this.title = title;
	}

	/**
	 * 获取content
	 * 
	 * @return content
	 */
	public String getContent() {
		return content;
	}

	/**
	 * 设置content
	 * 
	 * @param content
	 */
	public void setContent(String content) {
		this.content = content;
	}

	/**
	 * 获取userId
	 * 
	 * @return userId
	 */
	public String getUserId() {
		return userId;
	}

	/**
	 * 设置userId
	 * 
	 * @param userId
	 */
	public void setUserId(String userId) {
		this.userId = userId;
	}

	/**
	 * 获取opTime
	 * 
	 * @return opTime
	 */
	public String getOpTime() {
		return opTime;
	}

	/**
	 * 设置opTime
	 * 
	 * @param opTime
	 */
	public void setOpTime(String opTime) {
		this.opTime = opTime;
	}

	/**
	 * 获取parameter
	 * 
	 * @return parameter
	 */
	public String getParameter() {
		return parameter;
	}

	/**
	 * 设置parameter
	 * 
	 * @param parameter
	 */
	public void setParameter(String parameter) {
		this.parameter = parameter;
	}

}
