package com.cqupt.mis.rms.model;

import java.util.HashSet;
import java.util.Set;

/**
 * <p>
 * Title:角色信息
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
public class CQUPTRole {
	// 角色编号
	private int roleId;
	// 角色名字
	private String roleName;
	// 角色级别
	private RoleLevel roleLevel;
	// 角色说明
	private String description;
	// 映射和模块信息的一对多关联关系
	private Set<Rolepurview> rolepurviews = new HashSet<Rolepurview>();
	// 映射角色和学院之间的一对多关联关系
	private Set<RoleCollege> roleColleges = new HashSet<RoleCollege>();

	public int getRoleId() {
		return roleId;
	}

	public void setRoleId(int roleId) {
		this.roleId = roleId;
	}

	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	public RoleLevel getRoleLevel() {
		return roleLevel;
	}

	public void setRoleLevel(RoleLevel roleLevel) {
		this.roleLevel = roleLevel;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Set<Rolepurview> getRolepurviews() {
		return rolepurviews;
	}

	public void setRolepurviews(Set<Rolepurview> rolepurviews) {
		this.rolepurviews = rolepurviews;
	}

	public Set<RoleCollege> getRoleColleges() {
		return roleColleges;
	}

	public void setRoleColleges(Set<RoleCollege> roleColleges) {
		this.roleColleges = roleColleges;
	}

}
