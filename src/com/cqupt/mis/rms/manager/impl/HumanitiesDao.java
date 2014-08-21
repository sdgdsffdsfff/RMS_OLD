package com.cqupt.mis.rms.manager.impl;

import java.util.List;

import com.cqupt.mis.rms.model.HumanitiesAcademicMeeting;
import com.cqupt.mis.rms.model.HumanitiesBook;
import com.cqupt.mis.rms.model.HumanitiesExchangePaper;
import com.cqupt.mis.rms.model.HumanitiesPaper;
import com.cqupt.mis.rms.model.HumanitiesProject;
import com.cqupt.mis.rms.model.HumanitiesResearchReward;

public class HumanitiesDao extends BaseDao {
	/**
	 * 通过 上传的时间 还有状态来查找出 全部人文学科著作信息
	 * @param status
	 * @param updateTime
	 * @return
	 */
	public List<HumanitiesBook> findAllHumanitiesBook(int status,String updateTime){
		String str = "";
		if(status ==2){
			str = " =2 ";
		}else{
			str = " !=2 ";
		}
		String hql = "from HumanitiesBook hb where hb.status"+str+" and hb.bookId like ?";
		return search(hql,updateTime+"%");
	}
	/**
	 * 通过 上传的时间 还有状态来查找出 全部人文社科学术论文
	 * @param status
	 * @param updateTime
	 * @return
	 */
	public List<HumanitiesPaper> findAllHumanitiesPaper(int status,String updateTime){
		String str = "";
		if(status ==2){
			str = " =2 ";
		}else{
			str = " !=2 ";
		}
		String hql = "from HumanitiesPaper hp where hp.status "+str+"  and hp.paperId like ?";
		return search(hql,updateTime+"%");
	}
	/**
	 * 通过 上传的时间 还有状态来查找出 全部人文社科科研项目信息
	 * @param status
	 * @param updateTime
	 * @return
	 */
	public List<HumanitiesProject> findAllHumanitiesProject(int status,String updateTime){
		String str = "";
		if(status ==2){
			str = " =2 ";
		}else{
			str = " !=2 ";
		}
		String hql = "from HumanitiesProject hp where hp.status "+str+"  and hp.projectId like ?";
		return search(hql,updateTime+"%");
	}
	/**
	 *  通过 上传的时间 还有状态来查找出 全部人文社科交流信息论文
	 * @param status
	 * @param updateTime
	 * @return
	 */
	public List<HumanitiesExchangePaper> findAllHumanitiesExchangePaper(int status, String updateTime){
		String str = "";
		if(status ==2){
			str = " =2 ";
		}else{
			str = " !=2 ";
		}
		String hql = "from HumanitiesExchangePaper hep where hep.status "+str+"  and hep.exchangePaperId like ?";
		return search(hql,updateTime+"%");
	}
	/**
	 *  通过 上传的时间 还有状态来查找出 全部人文社科科研获奖信息
	 * @param status
	 * @param updateTime
	 * @return
	 */
	public List<HumanitiesResearchReward> findAllHumanitiesResearchReward(int status, String updateTime){
		String str = "";
		if(status ==2){
			str = " =2 ";
		}else{
			str = " !=2 ";
		}
		String hql ="from HumanitiesResearchReward hr where hr.status "+str+"  and hr.researchRewardId like ?";
		return search(hql,updateTime+"%");
	}
	/**
	 *  通过 上传的时间 还有状态来查找出 全部人文社科学术会议信息
	 * @param status
	 * @param updateTime
	 * @return
	 */
	public List<HumanitiesAcademicMeeting> findAllHumanitiesAcademicMeeting(int status, String updateTime){
		String str = "";
		if(status ==2){
			str = " =2 ";
		}else{
			str = " !=2 ";
		}
		String hql = "from HumanitiesAcademicMeeting ham where ham.status "+str+"  and ham.academicMeetingId like ?";
		return search(hql,updateTime+"%");
	}
}
