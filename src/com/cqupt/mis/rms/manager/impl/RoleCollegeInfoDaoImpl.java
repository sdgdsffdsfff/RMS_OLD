package com.cqupt.mis.rms.manager.impl;

import com.cqupt.mis.rms.manager.BaseHibernateDaoSupport;
import com.cqupt.mis.rms.manager.CollegeInfoDao;
import com.cqupt.mis.rms.manager.RoleCollegeInfoDao;
import com.cqupt.mis.rms.manager.RoleInfoDao;
import com.cqupt.mis.rms.model.CQUPTCollege;
import com.cqupt.mis.rms.model.CQUPTRole;
import com.cqupt.mis.rms.model.RoleCollege;
/**
 * <p>Title:角色管理学院信息的接口实现</p>
 * <p>Copyright:Copyright(c)2012</p>
 * <p>Company:重邮信管工作室 </p>
 * @author LM
 * @version 1.0
 * */
public class RoleCollegeInfoDaoImpl extends BaseHibernateDaoSupport implements RoleCollegeInfoDao {
	private CollegeInfoDao collegeInfoDao;
	private RoleInfoDao roleInfoDao;
	
	public void setCollegeInfoDao(CollegeInfoDao collegeInfoDao) {
		this.collegeInfoDao = collegeInfoDao;
	}

	public void setRoleInfoDao(RoleInfoDao roleInfoDao) {
		this.roleInfoDao = roleInfoDao;
	}

	@Override
	public void addRoleCollegeByRoleIdAndCollegeIds(int roleId, String[] collegeIds) {
		//添加之前先删除已有的角色学院信息
		delRoleCollegeByRoleId(roleId);
		//查找角色信息
		CQUPTRole roleInfo =roleInfoDao.findRoleInfoByroleId(roleId);
		if(collegeIds!=null){
			for(String collegeId : collegeIds ){
				// 学院信息
				CQUPTCollege collegeInfo = collegeInfoDao.findCQUPTCollegeByCollegeId(collegeId);
				RoleCollege roleCollege =  new RoleCollege();
				roleCollege.setCollegeInfo(collegeInfo);
				roleCollege.setRoleInfo(roleInfo);
				addRoleCollegeByRoleCollegeEntity(roleCollege);
			}
		}
	}

	@Override
	public void addRoleCollegeByRoleCollegeEntity(RoleCollege roleCollege) {
		this.getHibernateTemplate().persist(roleCollege);
	}

	@Override
	public void delRoleCollegeByRoleId(int roleId) {
		String hql = "delete from RoleCollege where roleInfo.roleId = ?";
		this.getSession().createQuery(hql).setParameter(0, roleId).executeUpdate();
	}
}
