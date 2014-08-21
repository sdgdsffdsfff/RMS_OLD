/**
 * 
 */
package com.cqupt.mis.rms.manager;

import java.util.List;

import com.cqupt.mis.rms.model.RoleLevel;

/**
 * <p>Title:管理角色级别的接口</p>
 * <p>Copyright:Copyright(c)2012</p>
 * <p>Company:重邮信管工作室 </p>
 * @author LM
 * @version 1.0
 * */
public interface RoleLevelDao {
	/**
	 * 添加一种角色级别
	 * @param roleLevel  添加的角色实体
	 * */
	public void addRoleLevelByEntity(RoleLevel roleLevel);
	/**
	 * 删除一种角色级别
	 * @param levelId 角色编号
	 * */
	public void delRoleLevelByLevelId(int levelId);
	/**
	 * 修改角色级别——主要是修改名称
	 * @param roleLevel 需要修改的角色实体
	 * */
	public void updateRoleLevelByEntity(RoleLevel roleLevel);
	/**
	 * 根据角色级别Id，查找某个角色级别
	 * */
	public RoleLevel findRoleLevelByRoleLevelId(int roleLevelId);
	/**
	 * 查找所有的角色级别
	 * */
	public List<RoleLevel> findAllRoleLevel();
	
}
