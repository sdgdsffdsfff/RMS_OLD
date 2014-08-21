package com.cqupt.mis.rms.service.impl;

import java.util.List;

import com.cqupt.mis.rms.manager.GetCollegeInfoDao;
import com.cqupt.mis.rms.model.CQUPTCollege;
import com.cqupt.mis.rms.service.CollegeManagerService;

/**
 * <p>Title:管理用户信息的服务曾接口实现类</p>
 * <p>Copyright:Copyright(c)2012</p>
 * <p>Company:重邮信管工作室 </p>
 * @author HHY
 * @version 1.0
 * */
public class CollegeManagerServiceImpl implements CollegeManagerService {
	//注入管理用户信息的底层接口
	private GetCollegeInfoDao getCollegeInfoDao;
	

	public void setGetCollegeInfoDao(GetCollegeInfoDao getCollegeInfoDao) {
		this.getCollegeInfoDao = getCollegeInfoDao;
	}

	/**
	 * 通过id得到相应的信息
	 * @param id  需要的信息的id
	 * @param modelName 需要查询的model的名称(注意大小写)
	 * @param idName model中做对应的id的名称
	 * @return Object 返回相应的信息
	 * */
	@Override
	public List<Object> getInfoByFactor(String factoValue, String modelName,String factorName) {
		// TODO Auto-generated method stub
		@SuppressWarnings("unchecked")
		List<Object> list =  (List<Object>) getCollegeInfoDao.getInfoByFactor(factoValue,modelName,factorName);
		return list;
	}

	/**
	 * 得到所有的信息
	 * @param modelName 需要查询的model的名称(注意大小写)
	 * @return Object 返回相应信息
	 * */
	@Override
	public List<Object> getInfo(String modelName) {
        @SuppressWarnings("unchecked")
		List<Object> lists =  (List<Object>) getCollegeInfoDao.getInfo(modelName); ;
		return lists;
	}
	
	/**
	 * 得到所有的信息
	 * @param modelName 需要查询的model的名称(注意大小写)
	 * @return Object 返回相应信息
	 * */
	@Override
	public List<Object> findInfo(String modelName) {
		@SuppressWarnings("unchecked")
		List<Object> lists =  (List<Object>) getCollegeInfoDao.findInfo(modelName); ;
		return lists;
	}

	/**
	 * 设置通过审批
	 * @param id  需要的信息的id
	 * @param modelName 需要的信息对应的modelName名称
	 * @param status 需要的设置的信息状态
	 * @param idName 在表中该id的名称
	 * @param approvedUserId 审批该项目的人员id号
	 * @return boolean 操作成功返回true，失败返回false
	 * */
	@Override
	public boolean updateInfoById(String id, String modelName, String status,String idName,String approvedUserId) {
		
		boolean managerAction = false;
		
		Integer updateEntities = getCollegeInfoDao.updateInfoById(id, modelName,status,idName,approvedUserId);
		if(updateEntities==1){
			
			 managerAction = true;
		}
		return managerAction;
	}
	
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
	@Override
	public boolean updateInfoByIdNew(String id, String modelName, String status,String idName,String approvedUserId,Float verify_amounts) {
		
		boolean managerAction = false;
		
		Integer updateEntities = getCollegeInfoDao.updateInfoById(id, modelName,status,idName,approvedUserId);
		if(updateEntities==1){
			
			 managerAction = true;
		}
		return managerAction;
	}

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
	@Override
	public boolean updateRejectInfoById(String id, String modelName,
			String status, String idName, String approvedUserId,
			String returnReason) {
       boolean managerAction = false;
		
		Integer updateEntities = getCollegeInfoDao.updateRejectInfoById(id, modelName, status, idName, approvedUserId, returnReason);
		if(updateEntities==1){
			
			 managerAction = true;
		}
		return managerAction;
	}
	
	@Override
	public List<CQUPTCollege> getAllCollege() {
		// TODO Auto-generated method stub
		return getCollegeInfoDao.getAllCollege();
	}
	
}
