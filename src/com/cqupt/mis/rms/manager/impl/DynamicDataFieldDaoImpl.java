package com.cqupt.mis.rms.manager.impl;

import java.util.List;

import ognl.SetPropertyAccessor;

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
			String hql = "update "+className+" field set field.isDelete= ?, field.order=0 where field.id= ?";
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
	public <T> List<T> findAllFields(String className) {
		List<T> list = null;
		try {
			String hql = "from "+className+" field where field.isDelete=0 order by field.order";
			list = getSession().createQuery(hql).list();
		} catch(Exception e) {
			e.printStackTrace();
		}
		return list;
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

	@Override
	public int countField(String className) {
		int count = 0;
		try { 
			String hql = "select count(*) from "+className+" field where field.isDelete=0";
			count = ((Long) getSession().createQuery(hql).uniqueResult()).intValue();
		} catch(Exception e) {
			e.printStackTrace();
		}
		return count;
	}

	@Override
	public boolean updateOrder(String className, int beginorder, int endOrder, boolean add) {
		boolean result = false;
		String hql = "";
		//根据add的值不同建立相应的hql语句
		if(add) {
			hql = "update "+className+" field set field.order=field.order+1 where field.order between ? and ?";
		} else  {
			hql = "update "+className+" field set field.order=field.order-1 where field.order between ? and ?";
		}
		
		try {
			getSession().createQuery(hql).setParameter(0, beginorder).setParameter(1, endOrder).executeUpdate();
			result = true;
		} catch(Exception e) {
			e.printStackTrace();
		}
		return result;
	}
	
}
