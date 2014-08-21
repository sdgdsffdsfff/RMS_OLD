package com.cqupt.mis.rms.service;

import java.util.List;

import com.cqupt.mis.rms.model.CQUPTCollege;

/**
 * <p>Title:管理用户信息的服务层接口</p>
 * <p>Copyright:Copyright(c)2012</p>
 * <p>Company:重邮信管工作室 </p>
 * @author HHY
 * @version 1.0
 * */
public interface CollegeManagerService {
	
	/**
	 * 通过id得到相应的信息
	 * @param id  需要的信息的id
	 * @param modelName 需要查询的model的名称(注意大小写)
	 * @param idName model中做对应的id的名称
	 * @return Object 返回相应的信息
	 * */
	public Object getInfoByFactor(String factorValue, String modelName,String factorName);	
	
	/**
	 * 得到所有的信息
	 * @param modelName 需要查询的model的名称(注意大小写)
	 * @return Object 返回相应信息
	 * */
	public Object getInfo(String modelName);
	
	/**
	 * 得到所有的信息
	 * @param modelName 需要查询的model的名称(注意大小写)
	 * @return Object 返回相应信息
	 * */
	public Object findInfo(String modelName);
	
	/**
	 * 设置通过审批
	 * @param id  需要的信息的id
	 * @param modelName 需要的信息对应的modelName名称
	 * @param status 需要的设置的信息状态
	 * @param idName 在表中该id的名称
	 * @param approvedUserId 审批该项目的人员id号
	 * @return boolean 操作成功返回true，失败返回false
	 * */
	public boolean updateInfoById(String id, String modelName, String status,String idName,String approvedUserId);
	
	/**
	 * 设置新的通过审批
	 * @param id  需要的信息的id
	 * @param modelName 需要的信息对应的modelName名称
	 * @param status 需要的设置的信息状态
	 * @param idName 在表中该id的名称
	 * @param approvedUserId 审批该项目的人员id号
	 * @param verify_amounts 学院核实金额
	 * @return boolean 操作成功返回true，失败返回false
	 * */
	public boolean updateInfoByIdNew(String id, String modelName, String status,String idName,String approvedUserId,Float verify_amounts);

	/**
	 * 设置通过未审批
	 * @param id  需要的信息的id
	 * @param modelName 需要的信息对应的modelName名称
	 * @param status 需要的设置的信息状态
	 * @param idName 在表中该id的名称
	 * @param approvedUserId 审批该项目的人员id号
	 * @param returnReason 未通过的理由
	 * @return boolean 操作成功返回true 失败返回false
	 * */
	public boolean updateRejectInfoById(String id, String modelName,
			String status, String idName, String approvedUserId,
			String returnReason);
	
	public List<CQUPTCollege> getAllCollege();
}
