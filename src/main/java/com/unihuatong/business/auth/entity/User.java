package com.unihuatong.business.auth.entity;

import java.io.Serializable;

/**
 * @Description 用户实体类
 * @author 戚兆宇
 * @date 2018年2月22日 上午9:42:29
 *
 */
public class User implements Serializable {

	private static final long serialVersionUID = -8971554984283862884L;

	private String id;
	private String loginName;
	private String password;
	private String realName;
	private String sex;
	private Integer age;
	private Integer tel;

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
	 * 获取loginName
	 * 
	 * @return loginName
	 */
	public String getLoginName() {
		return loginName;
	}

	/**
	 * 设置loginName
	 * 
	 * @param loginName
	 */
	public void setLoginName(String loginName) {
		this.loginName = loginName;
	}

	/**
	 * 获取password
	 * 
	 * @return password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * 设置password
	 * 
	 * @param password
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * 获取realName
	 * 
	 * @return realName
	 */
	public String getRealName() {
		return realName;
	}

	/**
	 * 设置realName
	 * 
	 * @param realName
	 */
	public void setRealName(String realName) {
		this.realName = realName;
	}

	/**
	 * 获取sex
	 * 
	 * @return sex
	 */
	public String getSex() {
		return sex;
	}

	/**
	 * 设置sex
	 * 
	 * @param sex
	 */
	public void setSex(String sex) {
		this.sex = sex;
	}

	/**
	 * 获取age
	 * 
	 * @return age
	 */
	public Integer getAge() {
		return age;
	}

	/**
	 * 设置age
	 * 
	 * @param age
	 */
	public void setAge(Integer age) {
		this.age = age;
	}

	/**
	 * 获取tel
	 * 
	 * @return tel
	 */
	public Integer getTel() {
		return tel;
	}

	/**
	 * 设置tel
	 * 
	 * @param tel
	 */
	public void setTel(Integer tel) {
		this.tel = tel;
	}

}
