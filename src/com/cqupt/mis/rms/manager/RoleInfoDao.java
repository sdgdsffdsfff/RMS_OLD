package com.cqupt.mis.rms.manager;

import java.util.List;

import com.cqupt.mis.rms.model.CQUPTRole;
/**
 * <p>Title:角色信息管理的接口</p>
 * <p>Copyright:Copyright(c)2012</p>
 * <p>Company:重邮信管工作室 </p>
 * @author LM
 * @version 1.0
 * */
public interface RoleInfoDao {
	/**
	 * 检查用户是否具有选中的角色级别——辅助用户登录所用
	 * @param roleLevelId 角色级别编号
	 * @param userId 用户登录ID
	 * @return CQUPTRole 获取的角色信息
	 * */
	public CQUPTRole checkRoleLevelByUserIdAndRoleLevelId(String userId,int roleLevelId);
	/**
	 * 分页查询所有的角色信息
	 * @param offset 初始记录位置
	 * @param pageSize 每页显示记录数
	 * @return 角色信息列表
	 **/
	public  List<CQUPTRole> findRoleInfoList(int offset,int pageSize);
	/**
	 * 返回系统中含有的角色总数量
	 * @return 满足条件的角色总数
	 * */
	public int findRoleInfoListNumber();
	/**
	 * 添加一个角色信息
	 * @param roleInfo 角色信息
	 * */
	public void addRoleInfo(CQUPTRole roleInfo);
	/**
	 * 更新角色信息
	 * @param roleInfo 角色信息
	 * */
	public void updateRoleInfo(CQUPTRole roleInfo);
	/**
	 * 根据角色Id，删除单个角色信息
	 * @param roleId 角色Id
	 * */
	public void delRoleInfoByRoleId(int roleId);
	/**
	 * 根据角色级别，删除某个级别下面的所有角色
	 * @param roleLevelId 角色级别Id
	 * */
	public void delRoleInfoByRoleLevelId(int roleLevelId);
	/**
	 * 批量删除角色信息
	 * @param roleIds 需要删除的角色Id集合
	 * */
	public void deleteRoleInfoByRoleIdArray(int[] roleIds);
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
	 * 根据用户登录Id，获取用户的角色信息
	 * @param userId 用户角色Id
	 * @return List<CQUPTRole> 用户角色列表
	 * */
	public  List<CQUPTRole> findRoleInfoListByuserId(String userId);	
}
