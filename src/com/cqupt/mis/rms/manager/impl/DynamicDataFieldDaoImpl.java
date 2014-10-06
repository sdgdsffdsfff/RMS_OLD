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
			e.printStackTrace();
		}
		return result;
		
	}

	@Override
	public boolean deleteField(String className, int fieldId) {
		boolean result = false;
		try {
			String hql = "update "+className+" field set field.isDelete= ? where field.id= ?";
			getSession().createQuery(hql).setParameter(0, 1).setParameter(1, fieldId).executeUpdate();
			result = true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	@Override
	public boolean updateField(Object obj) {
		boolean result = false;
		try {
			this.getHibernateTemplate().update(obj);
			result = true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	@Override
	public List<Object> findAllFields(String className) {
		//TODO
		return null;
	}

	@Override
	public Object findFieldByClassNameAndId(String className, int fieldId) {
		Object obj = null;
		try {
			String hql = "from "+className+" field where field.id= ?";
			obj = getSession().createQuery(hql).setParameter(0, fieldId).uniqueResult();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return obj;
	}
	
}
