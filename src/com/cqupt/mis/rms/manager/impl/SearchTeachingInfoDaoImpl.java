package com.cqupt.mis.rms.manager.impl;

import java.util.List;

import com.cqupt.mis.rms.manager.BaseHibernateDaoSupport;
import com.cqupt.mis.rms.manager.SearchTeachingInfoDao;

public class SearchTeachingInfoDaoImpl extends BaseHibernateDaoSupport implements SearchTeachingInfoDao {

	@Override
	public List<Object> findAllInfoByUserIdAndClassName(String submitUserId,
			String ClassName) {
		String hql = "from " + ClassName + " modelName where modelName.submitUser.userId = ? ";
		return this.getSession().createQuery(hql).setParameter(0, submitUserId).list();
	}


}
