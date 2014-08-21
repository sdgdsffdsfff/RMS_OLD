package com.cqupt.mis.rms.manager;

import java.util.List;

import com.cqupt.mis.rms.model.UserRoleInfo;

/**
 * <p>Title:管理用户和角色信息的接口</p>
 * <p>Copyright:Copyright(c)2012</p>
 * <p>Company:重邮信管工作室 </p>
 * @author LM
 * @version 1.0
 * */
public interface UserRoleInfoDao {
	/**
	 * 为某个员工添加多个角色
	 * @param userID 员工Id
	 * @param RoleIdArr 需要添加的角色集合
	 * */
	public void addUserRoleInfo(String userID,int[] RoleIdArr);
	/**
	 * 根据用户Id删除用户角色信息表中该用户的所有角色数据——用于重新赋予用户角色信息的时候，先删除已经有的用户角色信息
	 * @param userId 用户Id
	 * */
	public void deleteUserRoleInfoByUserId(String userId);
	/**
	 * 根据角色Id删除用户角色信息表中该角色的所有用户数据
	 * @param roleId 角色Id
	 * */
	public void deleteUserRoleInfoByRoleId(int roleId);
	/**
	 * 查找所有的用户角色信息
	 * @return List<UserRoleInfo> 所有的用户角色信息
	 * */
	public List<UserRoleInfo> findAllUserRoleInfo();
}
