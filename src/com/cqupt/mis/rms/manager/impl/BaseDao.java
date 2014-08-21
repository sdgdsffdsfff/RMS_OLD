package com.cqupt.mis.rms.manager.impl;

import java.util.ArrayList;
import java.util.List;


import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.cqupt.mis.rms.utils.HibernateUtil;

public class BaseDao {
	/**
	 * 输入hql 语句还有 添加相应的参数 
	 * @param hql
	 * @param params
	 * @return
	 */
	@SuppressWarnings("unchecked")
	protected <T> List<T>  search(String hql, Object... params){
		List<T> list  =  new ArrayList<T>();
		// 创建Session
		Session session = HibernateUtil.getSession();
		// 创建及开启事务对象
		Transaction trans = null;
		try {
			trans = session.beginTransaction();
			
			Query q = session.createQuery(hql);
			for(int i = 0;i < params.length;i++){
				q.setParameter(i, params[i]);
			}
			
			list = q.list();
			for(@SuppressWarnings("unused") Object o: list){
				
			}
			trans.commit();
		} catch (HibernateException e) {
			trans.rollback();
			e.printStackTrace();
		} finally {
			HibernateUtil.closeSession(session);
		}
		return list;
	}
}
