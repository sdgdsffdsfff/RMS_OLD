package com.cqupt.mis.rms.manager.impl;

import java.util.List;

import com.cqupt.mis.rms.model.ScienceBook;
import com.cqupt.mis.rms.model.ScienceGovernmentAward;
import com.cqupt.mis.rms.model.ScienceIpRights;
import com.cqupt.mis.rms.model.ScienceOrganization;
import com.cqupt.mis.rms.model.SciencePaper;
import com.cqupt.mis.rms.model.ScienceTechExchange;
import com.cqupt.mis.rms.model.ScienceTechProject;
import com.cqupt.mis.rms.model.ScienceTechTransfer;

public class ScienceDao extends BaseDao{
	/**
	 * 通过上传时间,还有现在的状态来查找全部的  理科科研机构信息
	 * @param status
	 * @param updateTime
	 * @return
	 */
	public List<ScienceOrganization> findAllScienceOrganization(int status,String updateTime){
		String str = "";
		if(status ==2){
			str = " =2 ";
		}else{
			str = " !=2 ";
		}
		String hql = "from ScienceOrganization so where so.status  "+str+"  and so.organizationId like ?";
		return search(hql,updateTime+"%");
	}
	/**
	 * 通过上传时间,还有现在的状态来查找全部的 理科科研项目信息
	 * @param status
	 * @param updateTime
	 * @return
	 */
	public List<ScienceTechProject> findAllScienceTechProject(int status,String updateTime){
		String str = "";
		if(status ==2){
			str = " =2 ";
		}else{
			str = " !=2 ";
		}
		String hql = "from ScienceTechProject st where st.status "+str+"  and st.projectId like ?";
		return search(hql,updateTime+"%");
	}
	/**
	 * 通过上传时间,还有现在的状态来查找全部的 理科著作信息
	 * @param status
	 * @param updateTime
	 * @return
	 */
	public List<ScienceBook> findAllScienceBook(int status,String updateTime){
		String str = "";
		if(status ==2){
			str = " =2 ";
		}else{
			str = " !=2 ";
		}
		String hql = "from ScienceBook sb where sb.status "+str+"  and sb.bookId like ?";
		return search(hql,updateTime+"%");
	}
	/**
	 * 通过上传时间,还有现在的状态来查找全部的 理科论文信息
	 * @param status
	 * @param updateTime
	 * @return
	 */
	public List<SciencePaper> findAllSciencePaper(int status,String updateTime){
		String str = "";
		if(status ==2){
			str = " =2 ";
		}else{
			str = " !=2 ";
		}
		String hql = "from SciencePaper sp where sp.status "+str+"  and sp.paperId like ?";
		return search(hql,updateTime+"%");
	}
	/**
	 * 通过上传时间,还有现在的状态来查找全部的 理科政府科技奖励信息
	 * @param status
	 * @param updateTime
	 * @return
	 */
	public List<ScienceGovernmentAward> findAllScienceGovernmentAward(int status,String updateTime){
		String str = "";
		if(status ==2){
			str = " =2 ";
		}else{
			str = " !=2 ";
		}
		String hql = "from ScienceGovernmentAward sg where sg.status "+str+"  and sg.awardId like  ?";
		return search(hql,updateTime+"%");
	}
	
	/**
	 * 通过上传时间,还有现在的状态来查找全部的 理科知识产权信息
	 * @param status
	 * @param updateTime
	 * @return
	 */
	public List<ScienceIpRights> findAllScienceIpRights(int status,String updateTime){
		String str = "";
		if(status ==2){
			str = " =2 ";
		}else{
			str = " !=2 ";
		}
		String hql = "from ScienceIpRights sr where sr.status "+str+"  and sr.rightsId like ?";
		return search(hql,updateTime+"%");
	}
	
	/**
	 * 通过上传时间,还有现在的状态来 查找全部的 理科技术转让信息
	 * @param status
	 * @param updateTime
	 * @return
	 */
	public List<ScienceTechTransfer> findAllScienceTechTransfer(int status,String updateTime){
		String str = "";
		if(status ==2){
			str = " =2 ";
		}else{
			str = " !=2 ";
		}
		String hql = "from ScienceTechTransfer st where st.status "+str+"  and st.transferId like ?";
		return search(hql,updateTime+"%");
	}
	/**
	 * 通过上传时间,还有现在的状态来找出全部的 理科科技交流信息
	 * @param status
	 * @param updateTime
	 * @return
	 */
	public List<ScienceTechExchange> findAllScienceTechExchange(int status,String updateTime){
		String str = "";
		if(status ==2){
			str = " =2 ";
		}else{
			str = " !=2 ";
		}
		String hql = "from ScienceTechExchange ste where ste.status "+str+"  and ste.techExchangeId like ?";
		return search(hql,updateTime+"%");
	}
//	这里出现了重复实现的类.并且在添加的一栏里面没有 录入 理科政府科技奖励信息 这个选项
//	public List<ScienceGovernmentAward> findAllScienceGovernmentAward(String updateTime){
//		String hql = "from ScienceGovernmentAward sg where sg.status = ? and sg.awardId like ?";
//		return search(hql,2,updateTime+"%");
//	}
}
