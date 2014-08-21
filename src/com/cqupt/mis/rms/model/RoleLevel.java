package com.cqupt.mis.rms.model;

import java.util.HashSet;
import java.util.Set;

/**
 * <p>
 * Title:角色级别表
 * </p>
 * <p>
 * Copyright:Copyright(c)2012
 * </p>
 * <p>
 * Company:重邮信管工作室
 * </p>
 * 
 * @author LM
 * @version 1.0
 * */
public class RoleLevel {
	// 角色级别编号
	private int id;
	// 角色级别名称
	private String roleLevelName;
	// 角色级别说明
	private String roleLevelDescription;
	//映射角色级别和角色之间的多对一关联关系
	private Set<CQUPTRole> roles = new HashSet<CQUPTRole>();

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getRoleLevelName() {
		return roleLevelName;
	}

	public void setRoleLevelName(String roleLevelName) {
		this.roleLevelName = roleLevelName;
	}

	public String getRoleLevelDescription() {
		return roleLevelDescription;
	}

	public void setRoleLevelDescription(String roleLevelDescription) {
		this.roleLevelDescription = roleLevelDescription;
	}

	public Set<CQUPTRole> getRoles() {
		return roles;
	}

	public void setRoles(Set<CQUPTRole> roles) {
		this.roles = roles;
	}

}
