/**
 * 
 */
package com.cqupt.mis.rms.service;

import java.util.List;

import com.cqupt.mis.rms.model.CQUPTCollege;
import com.cqupt.mis.rms.model.CQUPTRole;
import com.cqupt.mis.rms.model.Purviewinfo;
import com.cqupt.mis.rms.model.RoleLevel;
import com.cqupt.mis.rms.model.Rolepurview;
import com.cqupt.mis.rms.service.model.MenuInfo;

/**
 * <p>
 * Title:权限管理服务层接口
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
public interface PurviewService {
	/**
	 * 根据用户ID和角色Id，找出该用户在该角色下面所具有的所有模块信息
	 * @param userId 用户Id
	 * @param roleId 角色Id
	 * @return 模块信息 List<Purviewinfo>
	 */	
	public List<Purviewinfo> findPurviewListByUserIdAndRoleIdForCommonds(String userId,int roleId);	
	/**
	 * 根据用户ID、角色Id和模块的父类ID找出该用户在当前角色下面所具有的所有子模块信息
	 * @param userId 用户Id
	 * @param roleId 角色Id
	 * @param parentId 父类Id
	 * @return 模块信息 List<Purviewinfo>
	 */	
	public List<Purviewinfo> findPurviewListByUserIdAndRoleIdAndParentIdForCommonds(String userId,int roleId,int parentId);
	/**
	 * 更具角色编号和模块编号，查找该角色模块信息
	 * @param roleId 角色Id
	 * @param purviewId 模块Id
	 * @return 角色模块信息
	 */
	public Rolepurview findRolepurviewByRoleIdAndPurviewId(int roleId,int purviewId);
	/**
	 * 获取某用户在某个角色下面的一级和一级菜单对应的其二级菜单列表
	 * @param userId 用户Id
	 * @param roleId 角色Id
	 * @return List<Menu> 所有满足条件的菜单
	 * */
	public List<MenuInfo> findMenuListByUserIdAndRoleId(String userId,int roleId);
	/**
	 * 为某个角色添加多个模块
	 * @param roleId 角色Id
	 * @param purviewIdArr 模块集合
	 * */
	public boolean addRolePurviewByRoleIdAndpurviewIdArray(int roleId,int[] purviewIdArray);
	/**
	 * 分页查询所有的角色信息
	 * @param offset 初始记录位置
	 * @param pageSize 每页显示记录数
	 * @return 角色信息列表
	 **/
	public  List<CQUPTRole> findRoleInfoList(int offset,int pageSize);
	/**
	 * 添加一个角色信息
	 * @param roleInfo 角色信息
	 * */
	public boolean addRoleInfo(CQUPTRole roleInfo);
	/**
	 * 更新角色信息
	 * @param roleInfo 角色信息
	 * */
	public boolean updateRoleInfo(CQUPTRole roleInfo);
	/**
	 * 根据角色Id，删除单个角色信息
	 * @param roleId 角色Id
	 * */
	public boolean delRoleInfoByRoleId(int roleId);
	/**
	 * 根据角色级别，删除某个级别下面的所有角色
	 * @param roleLevelId 角色级别Id
	 * */
	public boolean delRoleInfoByRoleLevelId(int roleLevelId);
	/**
	 * 批量删除角色信息
	 * @param roleIds 需要删除的角色Id集合
	 * */
	public boolean deleteRoleInfoByRoleIdArray(int[] roleIds);
	/**
	 * 根据角色Id查询角色信息
	 * @param roleId 角色Id
	 * @return CQUPTRole 角色信息
	 * */
	public CQUPTRole findRoleInfoByroleId(int roleId);
	/**
	 * 根据角色级别编号，查找某类角色级别下面的所有角色信息
	 * @param roleLevelId 角色级别编号
	 * @return List<CQUPTRole> 满足条件的角色级别链表
	 * */
	public List<CQUPTRole> findCQUPTRoleListByRoleLevelId(int roleLevelId);
	/**
	 * 添加一种角色级别
	 * @param roleLevel  添加的角色实体
	 * */
	public boolean addRoleLevelByEntity(RoleLevel roleLevel);
	/**
	 * 删除一种角色级别
	 * @param levelId 角色编号
	 * */
	public boolean delRoleLevelByLevelId(int levelId);
	/**
	 * 修改角色级别——主要是修改名称
	 * @param roleLevel 需要修改的角色实体
	 * */
	public boolean updateRoleLevelByEntity(RoleLevel roleLevel);
	/**
	 * 根据角色级别Id，查找某个角色级别
	 * */
	public RoleLevel findRoleLevelByRoleLevelId(int roleLevelId);
	/**
	 * 查找所有的角色级别
	 * */
	public List<RoleLevel> findAllRoleLevel();
	/**
	 * 根据角色信息，查找该角色下面的所有学院信息
	 * @param roleId 角色Id
	 * @return List<CQUPTCollege> 返回满足条件的学院信息列表
	 * */
	public List<CQUPTCollege> findCQUPTCollegeListByRoleId(int roleId);
	/**
	 * 根据角色Id和学院Id集合添加角色学院信息——为某类角色的用户授予多个学院的管理权
	 * @param roleId 角色Id
	 * @param collegeIds 学院Id集合
	 * */
	public boolean addRoleCollegeByRoleIdAndCollegeIds(int roleId,String[] collegeIds);
	
}
