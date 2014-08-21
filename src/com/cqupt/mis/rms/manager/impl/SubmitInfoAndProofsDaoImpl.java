/**
*Copyright(c)2012 重邮信管工作室
*All right reserved.
*/
package com.cqupt.mis.rms.manager.impl;

import com.cqupt.mis.rms.manager.BaseHibernateDaoSupport;
import com.cqupt.mis.rms.manager.SubmitInfoAndProofsDao;
import com.cqupt.mis.rms.model.Proofs;

/**
*<p>Title:管理各类科研信息的实现类</p>
*<p>Description:处理用户管理各类科研信息时对数据库的操作</p>
*@author LvHai
*@version 1.0
*/
public class SubmitInfoAndProofsDaoImpl extends BaseHibernateDaoSupport implements SubmitInfoAndProofsDao {

	@Override
	public boolean addInfo(Object object) {
		// TODO Auto-generated method stub
		boolean result = false;
		try {
			this.getHibernateTemplate().merge(object);
			result = true;
		} catch (Exception e) {
			result = false;
			e.printStackTrace();
		}
		return result;
	}

	@Override
	public void addProof(Proofs proof) {
		// TODO Auto-generated method stub
		this.getHibernateTemplate().persist(proof);
	}


}
