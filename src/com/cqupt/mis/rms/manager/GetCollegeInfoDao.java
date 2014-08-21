package com.cqupt.mis.rms.manager;

import java.util.List;

import com.cqupt.mis.rms.model.CQUPTCollege;

/**
 * <p>Title:管理用户登录信息的接口</p>
 * <p>Copyright:Copyright(c)2012</p>
 * <p>Company:重邮信管工作室 </p>
 * @author HHY
 * @version 1.0
 * */

public interface GetCollegeInfoDao {
	
	/**
	 * 通过id得到相应的信息
	 * @param id  需要的信息的id
	 * @param modelName 需要的信息对应的modelName名称
	 * @param idName 需要的信息对应的modelName里关于这个id的命名
	 * @return Object 返回相应的信息model
	 * */
	public Object getInfoByFactor(String factorValue,String modelName,String factorName);
	
	/**
	 * 得到所有的信息
	 * @param id  需要的信息的id
	 * @param modelName 需要的信息对应的modelName名称
	 * @return List<Object> 返回存有信息的数组
	 * */
	public Object getInfo(String modelName);
	
	/**
	 * 得到所有的信息
	 * @param id  需要的信息的id
	 * @param modelName 需要的信息对应的modelName名称
	 * @return List<Object> 返回存有信息的数组
	 * */
	public Object findInfo(String modelName);
	
	/**
	 * 设置通过审批
	 * @param id  需要的信息的id
	 * @param modelName 需要的信息对应的modelName名称
	 * @param status 需要的设置的信息状态
	 * @param idName 在表中该id的名称
	 * @param approvedUserId 审批该项目的人员id号
	 * @return Integer 操作成功更新的条数
	 * */
	public Integer updateInfoById(String id,String modelName,String status,String idName,String approvedUserId);
	
	/**
	 * 设置通过未审批
	 * @param id  需要的信息的id
	 * @param modelName 需要的信息对应的modelName名称
	 * @param status 需要的设置的信息状态
	 * @param idName 在表中该id的名称
	 * @param approvedUserId 审批该项目的人员id号
	 * @param returnReason 未通过的理由
	 * @return Integer 操作成功更新的条数
	 * */
	public Integer updateRejectInfoById(String id, String modelName, String status,
			String idName, String approvedUserId, String returnReason);
	/**
	 * 	得到所有学院	
	 * @return
	 */
	public List<CQUPTCollege> getAllCollege();
}

