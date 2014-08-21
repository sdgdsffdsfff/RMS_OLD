package com.cqupt.mis.rms.manager.impl;

import java.util.List;
import com.cqupt.mis.rms.manager.BaseHibernateDaoSupport;
import com.cqupt.mis.rms.manager.GetCollegeInfoDao;
import com.cqupt.mis.rms.model.CQUPTCollege;

/**
 * <p>Title:管理用户信息的接口实现</p>
 * <p>Copyright:Copyright(c)2012</p>
 * <p>Company:重邮信管工作室 </p>
 * @author HHY
 * @version 1.0
 * */
public class GetCollegeInfoDaoImpl extends BaseHibernateDaoSupport implements GetCollegeInfoDao {
	
	
	
	/**
	 * 通过id得到相应的信息
	 * @param id  需要的信息的id
	 * @param modelName 需要的信息对应的modelName名称
	 * @param idName 需要的信息对应的modelName里关于这个id的命名
	 * @return List<Object> 满足要求的信息
	 * */
	@SuppressWarnings("unchecked")
	@Override
	public List<Object> getInfoByFactor(String factorValue, String modelName,String factorName) {
		
		String hql = "from "+modelName+" user where user."+factorName+"='"+factorValue+"'";
		
		List<Object> lists = this.getSession().createQuery(hql).list();
		return lists;

	}

	/**
	 * 得到所有的信息
	 * @param id  需要的信息的id
	 * @param modelName 需要的信息对应的modelName名称
	 * @return List<Object> 返回存有信息的数组
	 * */
	@Override
	public List<Object> getInfo(String modelName) {
		// TODO Auto-generated method stub
		String hql = "from "+modelName+" model where model.status =1";
		@SuppressWarnings("unchecked")
		List<Object> lists = this.getSession().createQuery(hql).list();
		return lists;
	}
	
	/**
	 * 得到所有的信息
	 * @param id  需要的信息的id
	 * @param modelName 需要的信息对应的modelName名称
	 * @return List<Object> 返回存有信息的数组
	 * */
	@Override
	public List<Object> findInfo(String modelName) {
		// TODO Auto-generated method stub
		String hql = "from "+modelName+" model where model.status in (1,5)";
		@SuppressWarnings("unchecked")
		List<Object> lists = this.getSession().createQuery(hql).list();
		return lists;
	}

	/**
	 * 设置通过审批
	 * @param id  需要的信息的id
	 * @param modelName 需要的信息对应的modelName名称
	 * @param status 需要的设置的信息状态
	 * @param idName 在表中该id的名称
	 * @param approvedUserId 审批该项目的人员id号
	 * @return Integer 操作成功更新的条数
	 * */
	@Override
	public Integer updateInfoById(String id, String modelName, String status,String idName,String approvedUserId) {
		
		// TODO Auto-generated method stub
		
		String hql = "update "+modelName+" model set " +
				"model.status="+status+",model.approvedUser.userId='"+approvedUserId+"' where model."+idName+" ='"+id+"'";
		int updateEntities = this.getSession().createQuery(hql).executeUpdate();
		
		return updateEntities;
	}
	

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
	@Override
	public Integer updateRejectInfoById(String id, String modelName, String status,String idName,String approvedUserId,String returnReason) {
		
		// TODO Auto-generated method stub
		
		String hql = "update "+modelName+" model set " +
				"model.status="+status+", model.approvedUser.userId='"+approvedUserId+"', model.returnReason='"+returnReason+"' where model."+idName+" ='"+id+"'";
		int updateEntities = this.getSession().createQuery(hql).executeUpdate();
		
		return updateEntities;
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<CQUPTCollege> getAllCollege() {
		// TODO Auto-generated method stub
		return getHibernateTemplate().find("from CQUPTCollege");
	}
}
