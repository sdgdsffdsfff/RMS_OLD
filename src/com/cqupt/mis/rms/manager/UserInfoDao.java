package com.cqupt.mis.rms.manager;

import java.util.List;

import com.cqupt.mis.rms.model.CQUPTUser;
import com.cqupt.mis.rms.model.UserLogin;


/**
 * <p>Title:管理用户登录信息的接口</p>
 * <p>Copyright:Copyright(c)2012</p>
 * <p>Company:重邮信管工作室 </p>
 * @author LM
 * @version 1.0
 * */
public interface UserInfoDao {
	/**
	 * 添加教师登录信息
	 * @param user 需要添加的教师登录信息实体
	 * */
	public void addUserLoginByEntity(UserLogin user);
	/**
	 * 添加教师基本信息
	 * @param user 需要添加的教师基本信息实体
	 * */
	public void addCQUPTUserByEntity(CQUPTUser user);
	/**
	 * 判断用户密码是否正确
	 * @param userId  用户登录Id
	 * @param userpwd 用户密码
	 * @return UserLogin 获得的用户信息
	 * */
	public UserLogin checkUNameAndUPass(String userId,String userpwd);
	/**
	 * 根据用户Id和角色Id，查询用户在该角色下面所能管理的用户基本信息集合
	 * @param userId 用户编号
	 * @param roleId 角色Id
	 * @return 部门链表
	 * */
	public List<CQUPTUser> findCQUPTUserListByUserIdAndRoleId(String userId,int roleId);
	/**
	 * 查找某种角色下面的所有的用户基本信息
	 * @param roleId 角色Id
	 * @return List<CQUPTUser> 返回的该角色下面的用户信息
	 * */
	public List<CQUPTUser> findCQUPTUserByRoleId(int roleId);
	/**
	 * 根据用户Id，查找用户的登录信息
	 * @param userId 用户登录Id
	 * @return UserLogin 用户登录信息
	 * */
	public UserLogin findUserLoginByUserId(String userId);
	
	/**
	 * 查出所有用户
	 * @return
	 */
	public List<CQUPTUser> findUser();
	
	public boolean checkUserId(String userId);
}

