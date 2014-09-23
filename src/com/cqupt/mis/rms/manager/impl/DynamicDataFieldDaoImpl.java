package com.cqupt.mis.rms.manager.impl;

import java.util.List;

import com.cqupt.mis.rms.manager.BaseHibernateDaoSupport;
import com.cqupt.mis.rms.manager.DynamicDataFieldDao;

public class DynamicDataFieldDaoImpl extends BaseHibernateDaoSupport implements DynamicDataFieldDao {

	@Override
	public boolean addField(Object obj) {
		this.getHibernateTemplate().save(obj);
		return false;
	}

	@Override
	public boolean deleteField(Object obj) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean updateField(Object obj) {
		this.getHibernateTemplate().update(obj);
		return false;
	}

	@Override
	public List<Object> findAllFields(String className) {
		
		return null;
	}

}
