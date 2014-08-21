package com.cqupt.mis.rms.model;

import java.util.HashSet;
import java.util.Set;

/**
 * <p>Title:用户登录信息类</p>
 * <p>Copyright:Copyright(c)2012</p>
 * <p>Company:重邮信管工作室 </p>
 * @author LM
 * @version 1.0
 * */
public class UserLogin{
	// 员工ID
	private String userId;
	// 登录密
	private String userPwd;
	//映射和用户角色信息表之间的的多对一关联关系
	private Set<UserRoleInfo> userRoleInfo = new HashSet<UserRoleInfo>();
	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getUserPwd() {
		return userPwd;
	}

	public void setUserPwd(String userPwd) {
		this.userPwd = userPwd;
	}

	public Set<UserRoleInfo> getUserRoleInfo() {
		return userRoleInfo;
	}

	public void setUserRoleInfo(Set<UserRoleInfo> userRoleInfo) {
		this.userRoleInfo = userRoleInfo;
	}
	
}

