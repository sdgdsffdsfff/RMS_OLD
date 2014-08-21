package com.cqupt.mis.rms.manager;

import com.cqupt.mis.rms.model.RoleCollege;

/**
 * <p>Title:角色管理学院信息的接口</p>
 * <p>Copyright:Copyright(c)2012</p>
 * <p>Company:重邮信管工作室 </p>
 * @author LM
 * @version 1.0
 * */
public interface RoleCollegeInfoDao {
	/**
	 * 根据角色Id和学院Id集合添加角色学院信息——为某类角色的用户授予多个学院的管理权
	 * @param roleId 角色Id
	 * @param collegeIds 学院Id集合
	 * */
	public void addRoleCollegeByRoleIdAndCollegeIds(int roleId,String[] collegeIds);
	/**
	 * 为一种角色的用户添加一个学院的管理权
	 * @param roleDeptinfo 角色学院信息
	 * */
	public void addRoleCollegeByRoleCollegeEntity(RoleCollege roleCollege );
	/**
	 * 根据角色Id，删除角色学院信息——重新授权角色所能管理的学院之前，先删除角色已经存在的所能管理的学院信息
	 * 系统中采用删除在添加的方式，而不再采用修改的方式
	 * @param roleId 角色Id
	 * */
	public void delRoleCollegeByRoleId(int roleId);
}
