package com.cqupt.mis.rms.manager.impl;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.cqupt.mis.rms.model.Proofs;
import com.cqupt.mis.rms.utils.HibernateUtil;

public class ProofsDao {
	
	@SuppressWarnings("unchecked")
	public static List<Proofs> findProofsById(String id){
		List<Proofs> proofs = null;
		// 创建Session
				Session session = HibernateUtil.getSession();
				// 创建及开启事务对象
				Transaction trans = null;
				try {
					trans = session.beginTransaction();
					if(id!=null && !"".equals(id)){
						String hql = "from Proofs p where p.infoApprovedId = ? ";
						proofs = session.createQuery(hql).setParameter(0, id).list();
								
					}
					trans.commit();
				} catch (HibernateException e) {
					trans.rollback();
					e.printStackTrace();
				} finally {
					HibernateUtil.closeSession(session);
				}
				return proofs;
	}
}
