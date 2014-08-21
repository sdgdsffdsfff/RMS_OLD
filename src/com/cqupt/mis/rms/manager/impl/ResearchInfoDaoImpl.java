package com.cqupt.mis.rms.manager.impl;

import java.io.File;
import java.util.List;

import com.cqupt.mis.rms.manager.BaseHibernateDaoSupport;
import com.cqupt.mis.rms.manager.ResearchInfoDao;
import com.cqupt.mis.rms.model.CQUPTUser;
import com.cqupt.mis.rms.model.Proofs;

/**
*<p>Title:管理用户个人科研信息接口的实现类</p>
*<p>Copyright:Copyright(c)2012</p>
*<p>Company:重邮信管工作室 </p>
*@author LvHai
*@version 1.0
*/
public class ResearchInfoDaoImpl extends BaseHibernateDaoSupport implements
		ResearchInfoDao {
	
	@Override
	public Object findResearchInfoByUserIdAndModelName(String submitUserId,
			String modelName) {
		String hql = "from " + modelName + " modelName where modelName.submitUser.userId = ? ";
		return this.getSession().createQuery(hql).setParameter(0, submitUserId).list();
	}

	@Override
	public void updateResearchInfo(Object object) {
		if(object != null){
			this.getHibernateTemplate().update(object);
		}
	}

	@Override
	public void addProof(Proofs proof) {
		if(proof != null){
			this.getHibernateTemplate().persist(proof);
		}
	}

	@Override
	public void deleteProof(int proofId) {
		String hql = "delete from Proofs proofs where proofs.proofId = ?";
		this.getSession().createQuery(hql).setParameter(0, proofId).executeUpdate();
	}

	@Override
	public void addMemberInfo(Object object) {
		if(object != null){
			this.getHibernateTemplate().persist(object);
		}
	}

	@Override
	public void deleteMemberInfo(Object object) {
		if(object != null){
			this.getHibernateTemplate().delete(object);
		}
	}

	@Override
	public Object findResearchInfoByIdAndModelNameAndFactor(String modelId,
			String modelName, String modelFactor) {
		String hql = "from " + modelName + " model where model." + modelFactor + " = ?";
		return this.getSession().createQuery(hql).setParameter(0, modelId).uniqueResult();
	}
	
	@Override
	public Object findResearchInfoByIdAndModelNameAndFactor(int modelId,
			String modelName, String modelFactor) {
		String hql = "from " + modelName + " model where model." + modelFactor + " = " + modelId;
		return this.getSession().createQuery(hql).uniqueResult();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Proofs> findProofByApprovedId(String approvedId) {
		String hql = "from Proofs proofs where proofs.infoApprovedId = ?";
		return this.getSession().createQuery(hql).setParameter(0, approvedId).list();
	}

	@Override
	public Object findMemberByIdAndModelNameAndFactor(String researchId,
			String modelName, String modelFactor) {
		String hql = "from " + modelName + " model where model." + modelFactor + " = ?";
		return this.getSession().createQuery(hql).setParameter(0, researchId).list();
	}

	@Override
	public void deleteResearchInfo(Object object) {
		if(object != null){
			this.getHibernateTemplate().delete(object);
		}
	}

	@Override
	public void deleteInfoByResearchId(String researchId,
			String researchModelName, String researchFactor) {
		String hql = "delete from " + researchModelName + " modelName where modelName." + researchFactor + " = ?";
		this.getSession().createQuery(hql).setParameter(0, researchId).executeUpdate();
	}

	@Override
	public void deleteProofByResearchId(String researchId) {
		String hql = "delete from Proofs proofs where proofs.infoApprovedId = ?";
		this.getSession().createQuery(hql).setParameter(0, researchId).executeUpdate();
	}

	@Override
	public void deleteMemberInfoByResearchId(String researchId,
			String memberModelName, String memberFactor, String researchFactor) {
		String hql = "delete from " + memberModelName + " modelName where modelName."+memberFactor+"."+researchFactor+" = ?";
		this.getSession().createQuery(hql).setParameter(0, researchId).executeUpdate();
	}

	@Override
	public boolean deleteFile(String fileName, String filePath) {
		String path = filePath + "\\" + fileName;
		File file = new File(path);
		if(file.isFile() && file.exists()){
			file.delete();
			return true;
		}else{
			return false;
		}
		
	}

	@Override
	public void deleteDetailInfoByResearchId(String researchId,
			String detailModelName, String detailFactor, String researchFactor) {
		String hql = "delete from " + detailModelName + " modelName where modelName."+detailFactor+"."+researchFactor+" = ?";
		this.getSession().createQuery(hql).setParameter(0, researchId).executeUpdate();
		
	}

	@Override
	public int findStatusByResearchId(String researchId, String modelName,
			String modelFactor) {
		String hql = "select status from " + modelName + " model where model." + modelFactor + " = ?";
		int result = -1;
		Object object = this.getSession().createQuery(hql).setParameter(0, researchId).uniqueResult();
		if(object !=null){
			result = (Integer)object;
		}
		return result;
	}

	@Override
	public Object findDetailByIdAndModelNameAndFactor(String researchId,
			String modelName, String modelFactor) {
		String hql = "from " + modelName + " model where model." + modelFactor + " = ?";
		return this.getSession().createQuery(hql).setParameter(0, researchId).list();
	}

	@Override
	public Proofs findProofById(int proofId) {
		String hql = "from Proofs proofs where proofs.proofId = ?";
		return (Proofs)this.getSession().createQuery(hql).setParameter(0, proofId).uniqueResult();
	}
	
	@Override
	public CQUPTUser findCQUPTUserByUserName(String userNmae) {
		// TODO Auto-generated method stub
		String hql = "from CQUPTUser cquptuser where cquptuser.userName = :username ";
		return (CQUPTUser) this.getSession().createQuery(hql).setParameter("username", userNmae).uniqueResult();
	}

	@Override
	public void addProjectDetailInfo(Object object) {
		if(object != null){
			this.getHibernateTemplate().persist(object);
		}
	}

	@Override
	public void updateProjectDetailStatus(String projectId, int status, String modelName,
			String factorName) {
		String hql = "update " + modelName + " modelName set modelName.status = "+ status +" where modelName." + factorName +" = ?";
		this.getSession().createQuery(hql).setParameter(0, projectId).executeUpdate();
		
	}

	@Override
	public Object findProjectDetailByDate(String projectId, String modelName,
			String factorName, String iDFactorName) {
		String hql = "from " + modelName + " modelName where modelName."+iDFactorName+" = ? and (modelName."+factorName+".status = 4 or modelName."+factorName+".status =7) order by modelName.updateTime desc";
		return this.getSession().createQuery(hql).setParameter(0, projectId).list();
	}

}
