package com.cqupt.mis.rms.manager;

import java.util.List;

import com.cqupt.mis.rms.model.Purviewinfo;
/**
 * <p>Title:管理用户模块信息的接口</p>
 * <p>Copyright:Copyright(c)2012</p>
 * <p>Company:重邮信管工作室 </p>
 * @author HHY
 * @version 1.0
 * */
public interface PurviewDao {
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
	 * 根据parentId查找所有的模块信息
	 * @param parentId 父类Id
	 * @return 模块信息 List<Purviewinfo>
	 */	
	public List<Purviewinfo> findPurviewListByparentId(int parentId);
	/**
	 * 插入模块信息
	 * @param purview 模块信息
	 * @return 模块信息 List<Purviewinfo>
	 */	
	public void addPurviewInfo(Purviewinfo purview);
	/**
	 * 更新模块信息（更具实体更新）
	 * @param purview 模块信息
	 * @return 模块信息 List<Purviewinfo>
	 */	
	public void updatePurview(Purviewinfo purview);
	/**
	 * 单个删除模块ID为purviewId的模块信息
	 * @param purview 模块信息
	 * @return 模块信息 List<Purviewinfo>
	 */	
	public void deletePurview(int purviewId);
	/**
	 * 批量删除模块ID为purviewId的模块集合信息
	 * @param purview 模块信息
	 * @return 模块信息 List<Purviewinfo>
	 */	
	public void deletePurviewArray(int[] purviewIds);
	/**
	 * 根据purviewId查找所有的模块信息
	 * @param purviewId 模块Id
	 * @return 模块信息 List<Purviewinfo>
	 */	
	public Purviewinfo findPurviewByPurviewId(int purviewId);
	/**
	 * 根据用户Id和该用户的角色Id，分页查询模块信息
	 * @param userId用户Id
	 * @param roleId 角色Id
	 * @param offset 开始查询记录
	 * @param pageSize 每页显示记录
	 * @return 模块信息 List<Purviewinfo>
	 */	
	public List<Purviewinfo> findPurviewListByUserIdAndRoleIdUsePage(String userId,int roleId,int offset,int pageSize);
	/**
	 * 返回满足条件的模块的总数
	 * @return 满足条件的模块总是
	 */	
	public int findPurviewListNumber();
}
