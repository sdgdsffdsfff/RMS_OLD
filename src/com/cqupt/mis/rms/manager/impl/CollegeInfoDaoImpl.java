package com.cqupt.mis.rms.manager.impl;

import java.util.List;

import com.cqupt.mis.rms.manager.BaseHibernateDaoSupport;
import com.cqupt.mis.rms.manager.CollegeInfoDao;
import com.cqupt.mis.rms.model.CQUPTCollege;

public class CollegeInfoDaoImpl extends BaseHibernateDaoSupport implements
		CollegeInfoDao {
	
	@Override
	public void addCollegeInfo(CQUPTCollege collegeInfo) {
		this.getHibernateTemplate().persist(collegeInfo);
	}

	@Override
	public void updateCollegeInfoByEntity(CQUPTCollege collegeInfo) {
		CQUPTCollege cInfo = findCQUPTCollegeByCollegeId(collegeInfo
				.getCollegeId());
		if (cInfo != null) {
			cInfo.setCollegeName(collegeInfo.getCollegeName());
			this.getHibernateTemplate().update(cInfo);
		}

	}

	@Override
	public CQUPTCollege findCQUPTCollegeByCollegeId(String collegeId) {
		return this.getHibernateTemplate().get(CQUPTCollege.class, collegeId);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<CQUPTCollege> findCQUPTCollegeListByRoleId(int roleId) {
		String hql ="select c from CQUPTCollege c,RoleCollege rc where rc.collegeInfo.collegeId = c.collegeId and rc.roleInfo.roleId = ? ";
		return this.getSession().createQuery(hql).setParameter(0, roleId).list();
	}

}
