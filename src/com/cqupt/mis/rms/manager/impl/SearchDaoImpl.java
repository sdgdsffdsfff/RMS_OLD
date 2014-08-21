package com.cqupt.mis.rms.manager.impl;

import java.util.Date;
import java.util.List;

import com.cqupt.mis.rms.manager.BaseHibernateDaoSupport;
import com.cqupt.mis.rms.manager.SearchDao;

public class SearchDaoImpl extends BaseHibernateDaoSupport implements SearchDao {

	@SuppressWarnings("unchecked")
	@Override
	public <T, T1> T SearchUniqueObjectsByFactor(String className,
			String factorName, T1 factorValue) {
		// TODO Auto-generated method stub
		String hql = "from "+className+" u where u."+factorName+" = ?";
		return (T)this.getSession().createQuery(hql).setParameter(0, factorValue).uniqueResult();
	}

	@SuppressWarnings("unchecked")
	@Override
	public <T, T1, T2> T SearchUniqueObjectsByFactor(String className,
			String factorName1, T1 factorValue1, String factorName2,
			T2 factorValue2) {
		// TODO Auto-generated method stub
		String hql = "from "+className+" u where u."+factorName1+" = ? and u."+factorName2+" = ?";
		return (T)this.getSession().createQuery(hql).setParameter(0, factorValue1).setParameter(1, factorValue2).uniqueResult();
	}

	@SuppressWarnings("unchecked")
	@Override
	public <T, T1, T2, T3> T SearchUniqueObjectsByFactor(String className,
			String factorName1, T1 factorValue1, String factorName2,
			T2 factorValue2, String factorName3, T3 factorValue3) {
		// TODO Auto-generated method stub
		String hql = "from "+className+" u where u."+factorName1+" = ? and u."+factorName2+" = ? and u."+factorName3+" = ?";
		return (T)this.getSession().createQuery(hql).setParameter(0, factorValue1).setParameter(1, factorValue2).setParameter(2, factorValue3).uniqueResult();
	}

	@SuppressWarnings("unchecked")
	@Override
	public <T, T1, T2, T3, T4> T SearchUniqueObjectsByFactor(String className,
			String factorName1, T1 factorValue1, String factorName2,
			T2 factorValue2, String factorName3, T3 factorValue3,
			String factorName4, T4 factorValue4) {
		// TODO Auto-generated method stub
		String hql = "from "+className+" u where u."+factorName1+" = ? and u."+factorName2+" = ? and u."+factorName3+" = ? and u."+factorName4+" = ?";
		return (T)this.getSession().createQuery(hql).setParameter(0, factorValue1).setParameter(1, factorValue2).setParameter(2, factorValue3).setParameter(3, factorValue4).uniqueResult();
	}

	@SuppressWarnings("unchecked")
	@Override
	public <T, T1> List<T> SearchObjectsByFactor(String className,
			String factorName, T1 factorValue) {
		// TODO Auto-generated method stub
		String hql = "from "+className+" u where u."+factorName+" = ?";
		return this.getSession().createQuery(hql).setParameter(0, factorValue).list();
	}

	@SuppressWarnings("unchecked")
	@Override
	public <T, T1, T2> List<T> SearchObjectsByFactor(String className,
			String factorName1, T1 factorValue1, String factorName2,
			T2 factorValue2) {
		// TODO Auto-generated method stub
		String hql = "from "+className+" u where u."+factorName1+" = ? and u."+factorName2+" = ?";
		return this.getSession().createQuery(hql).setParameter(0, factorValue1).setParameter(1, factorValue2).list();
	}

	@SuppressWarnings("unchecked")
	@Override
	public <T, T1, T2, T3> List<T> SearchObjectsByFactor(String className,
			String factorName1, T1 factorValue1, String factorName2,
			T2 factorValue2, String factorName3, T3 factorValue3) {
		// TODO Auto-generated method stub
		String hql = "from "+className+" u where u."+factorName1+" = ? and u."+factorName2+" = ? and u."+factorName3+" = ?";
		return this.getSession().createQuery(hql).setParameter(0, factorValue1).setParameter(1, factorValue2).setParameter(2, factorValue3).list();
	}

	@SuppressWarnings("unchecked")
	@Override
	public <T, T1, T2, T3, T4> List<T> SearchObjectsByFactor(String className,
			String factorName1, T1 factorValue1, String factorName2,
			T2 factorValue2, String factorName3, T3 factorValue3,
			String factorName4, T4 factorValue4) {
		// TODO Auto-generated method stub
		String hql = "from "+className+" u where u."+factorName1+" = ? and u."+factorName2+" = ? and u."+factorName3+" = ? and u."+factorName4+" = ?";
		return this.getSession().createQuery(hql).setParameter(0, factorValue1).setParameter(1, factorValue2).setParameter(2, factorValue3).setParameter(3, factorValue4).list();
	}

	@SuppressWarnings("unchecked")
	@Override
	public <T> List<T> SearchObjectsLikeFactor(String className,
			String factorName, String factorValue) {
		// TODO Auto-generated method stub
		String hql = "from "+className+" u where u."+factorName+" like :factorValue";
		return this.getSession().createQuery(hql).setParameter("factorValue", "%"+factorValue+"%").list();
	}

	@SuppressWarnings("unchecked")
	@Override
	public <T> List<T> SearchObjectsLikeFactor(String className,
			String factorName1, String factorValue1, String factorName2,
			String factorValue2) {
		// TODO Auto-generated method stub
		String hql = "from "+className+" u where u."+factorName1+" like :factorValue1 and u."+factorName2+" like :factorValue2";
		return this.getSession().createQuery(hql).setParameter("factorValue1", "%"+factorValue1+"%").setParameter("factorValue2", "%"+factorValue2+"%").list();
	}

	@SuppressWarnings("unchecked")
	@Override
	public <T> List<T> SearchObjectsLikeFactor(String className,
			String factorName1, String factorValue1, String factorName2,
			String factorValue2, String factorName3, String factorValue3) {
		// TODO Auto-generated method stub
		String hql = "from "+className+" u where u."+factorName1+" like :factorValue1 and u."+factorName2+" like :factorValue2 and u."+factorName3+" like :factorValue3";
		return this.getSession().createQuery(hql).setParameter("factorValue1", "%"+factorValue1+"%").setParameter("factorValue2", "%"+factorValue2+"%").setParameter("factorValue3", "%"+factorValue3+"%").list();
	}

	@SuppressWarnings("unchecked")
	@Override
	public <T> List<T> SearchObjectsLikeFactor(
			String className, String factorName1, String factorValue1,
			String factorName2, String factorValue2, String factorName3,
			String factorValue3, String factorName4, String factorValue4) {
		// TODO Auto-generated method stub
		String hql = "from "+className+" u where u."+factorName1+" like :factorValue1 and u."+factorName2+" like :factorValue2 and u."+factorName3+" like :factorValue3 and u."+factorName4+" like :factorValue4";
		return this.getSession().createQuery(hql).setParameter("factorValue1", "%"+factorValue1+"%").setParameter("factorValue2", "%"+factorValue2+"%").setParameter("factorValue3", "%"+factorValue3+"%").setParameter("factorValue4", "%"+factorValue4+"%").list();
	}

	@SuppressWarnings("unchecked")
	@Override
	public <T, T1> List<T> SearchObjectsLikeFactor(String className,
			String factorName, T1 beginFactorValue, T1 endFactorValue) {
		// TODO Auto-generated method stub
		String hql = "from "+className+" u where u."+factorName+" > "+beginFactorValue+" and u."+factorName+" < "+endFactorValue+"";
		return this.getHibernateTemplate().find(hql);
	}

	@SuppressWarnings("unchecked")
	@Override
	public <T> List<T> SearchObjectsLikeDateFactor(String className,
			String factorName, Date beginFactorValue, Date endFactorValue) {
		// TODO Auto-generated method stub
		String hql = "from "+className+" u where u."+factorName+" between ? and ?";
		return this.getSession().createQuery(hql).setDate(0, beginFactorValue).setDate(1, beginFactorValue).list();
	}
	
	
}
