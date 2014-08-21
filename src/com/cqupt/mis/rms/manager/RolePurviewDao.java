package com.cqupt.mis.rms.manager;

import java.util.List;

import com.cqupt.mis.rms.model.Rolepurview;
/**
 * <p>Title:管理角色模块信息的接口</p>
 * <p>Copyright:Copyright(c)2012</p>
 * <p>Company:重邮信管工作室 </p>
 * @author LM
 * @version 1.0
 * */
public interface RolePurviewDao {
	/**
	 * 为某个角色添加一个模块信息
	 * @param rolepurview 角色模块实体
	 * */
	public void addRolePurviewByEntity(Rolepurview rolepurview);
	/**
	 * 为某个角色添加多个模块
	 * @param roleId 角色Id
	 * @param purviewIdArr 模块集合
	 * */
	public void addRolePurviewByRoleIdAndpurviewIdArray(int roleId,int[] purviewIdArray);
	/**
	 * 根据角色Id，删除角色模块表中与该角色相关的所有的信息
	 * @param roleId 角色Id
	 * */
	public void deleteRolePurviewByRoleId(int roleId);
	/**
	 * 根据模块Id，删除角色模块表中与该模块相关的所有的信息
	 * @param purviewId 模块Id
	 * */
	public void deleteRolePurviewByPurviewId(int purviewId);
	/**
	 * 根据模块Id，查找角色模块表中与该模块相关的角色模块信息
	 * @param purviewId 模块Id
	 * @return List<Rolepurview> 满足条件的角色模块信息
	 * */
	public List<Rolepurview> findRolePurviewListByPurviewId(int purviewId);
	/**
	 * 根据角色Id，查找角色模块表中与该角色相关的角色模块信息
	 * @param roleId 角色Id
	 * @return List<Rolepurview> 满足条件的角色模块信息
	 * */
	public List<Rolepurview> findRolePurviewListByroleId(int roleId);
	/**
	 * 更具角色编号和模块编号，查找该角色模块信息
	 * @param roleId 角色Id
	 * @param purviewId 模块Id
	 * @return 角色模块信息
	 */
	public Rolepurview findRolepurviewByRoleIdAndPurviewId(int roleId,int purviewId);
}
