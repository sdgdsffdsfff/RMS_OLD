package com.cqupt.mis.rms.manager.impl;

import java.util.List;

import com.cqupt.mis.rms.manager.BaseHibernateDaoSupport;
import com.cqupt.mis.rms.manager.DynamicDataFieldDao;

public class DynamicDataFieldDaoImpl extends BaseHibernateDaoSupport implements DynamicDataFieldDao {

	@Override
	public boolean addField(Object obj) {
		boolean result = false;
		try {
			this.getHibernateTemplate().save(obj);
			result = true;
		} catch (Exception e) {
			result = false;
			e.printStackTrace();
		}
		return result;
		
	}

	@Override
	public boolean deleteField(Object obj) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean updateField(Object obj) {
		//TODO
		this.getHibernateTemplate().update(obj);
		return false;
	}

	@Override
	public List<Object> findAllFields(String className) {
		//TODO
		return null;
	}

}
