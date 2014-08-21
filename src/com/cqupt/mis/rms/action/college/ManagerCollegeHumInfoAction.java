package com.cqupt.mis.rms.action.college;

import java.util.List;
import com.cqupt.mis.rms.model.HumanitiesAcademicMeeting;
import com.cqupt.mis.rms.model.HumanitiesBook;
import com.cqupt.mis.rms.model.HumanitiesExchangePaper;
import com.cqupt.mis.rms.model.HumanitiesPaper;
import com.cqupt.mis.rms.model.HumanitiesProject;
import com.cqupt.mis.rms.model.HumanitiesResearchReward;
import com.cqupt.mis.rms.service.CollegeManagerService;
import com.opensymphony.xwork2.ActionSupport;
/**
 * <p>Title:实现得到人文社科类信息的action</p>
 * <p>Copyright:Copyright(c)2012</p>
 * <p>Company:重邮信管工作室 </p>
 * @author HHY
 * @version 1.0
 * */
@SuppressWarnings("serial")
public class ManagerCollegeHumInfoAction extends ActionSupport{

	//注入服务层接口
	private CollegeManagerService collegeManagerService;
	
  
    //人文社科类
    //得到全部人文社科类学术会议的相关信息
    private List<HumanitiesAcademicMeeting> humanitiesAcademicMeetinglists;
    //得到全部人文社科类著作的相关信息
    private List<HumanitiesBook> humanitiesBooklists;
    //得到全部人文社科类交流论文的相关信息
    private List<HumanitiesExchangePaper> humanitiesExchangePaperlists;
    //得到全部人文社科类论文的相关信息
    private List<HumanitiesPaper> humanitiesPaperlists;
    //得到全部人文社科类项目基本信息的相关信息
    private List<HumanitiesProject> humanitiesProjectlists;
    //得到全部人文社科类科研获奖的相关信息
    private List<HumanitiesResearchReward> humanitiesResearchRewardlists;
    private String type;

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public CollegeManagerService getCollegeManagerService() {
		return collegeManagerService;
	}

	public void setCollegeManagerService(CollegeManagerService collegeManagerService) {
		this.collegeManagerService = collegeManagerService;
	}

	

	public List<HumanitiesAcademicMeeting> getHumanitiesAcademicMeetinglists() {
		return humanitiesAcademicMeetinglists;
	}

	public void setHumanitiesAcademicMeetinglists(
			List<HumanitiesAcademicMeeting> humanitiesAcademicMeetinglists) {
		this.humanitiesAcademicMeetinglists = humanitiesAcademicMeetinglists;
	}

	public List<HumanitiesBook> getHumanitiesBooklists() {
		return humanitiesBooklists;
	}

	public void setHumanitiesBooklists(List<HumanitiesBook> humanitiesBooklists) {
		this.humanitiesBooklists = humanitiesBooklists;
	}

	public List<HumanitiesExchangePaper> getHumanitiesExchangePaperlists() {
		return humanitiesExchangePaperlists;
	}

	public void setHumanitiesExchangePaperlists(
			List<HumanitiesExchangePaper> humanitiesExchangePaperlists) {
		this.humanitiesExchangePaperlists = humanitiesExchangePaperlists;
	}

	public List<HumanitiesPaper> getHumanitiesPaperlists() {
		return humanitiesPaperlists;
	}

	public void setHumanitiesPaperlists(List<HumanitiesPaper> humanitiesPaperlists) {
		this.humanitiesPaperlists = humanitiesPaperlists;
	}

	public List<HumanitiesProject> getHumanitiesProjectlists() {
		return humanitiesProjectlists;
	}

	public void setHumanitiesProjectlists(
			List<HumanitiesProject> humanitiesProjectlists) {
		this.humanitiesProjectlists = humanitiesProjectlists;
	}

	public List<HumanitiesResearchReward> getHumanitiesResearchRewardlists() {
		return humanitiesResearchRewardlists;
	}

	public void setHumanitiesResearchRewardlists(
			List<HumanitiesResearchReward> humanitiesResearchRewardlists) {
		this.humanitiesResearchRewardlists = humanitiesResearchRewardlists;
	}

	//得到全部人文社科类学术会议的相关信息
	@SuppressWarnings("unchecked")
	public String humanitiesAcademicMeeting(){
		
    	humanitiesAcademicMeetinglists = (List<HumanitiesAcademicMeeting>) 
    			collegeManagerService.getInfo("HumanitiesAcademicMeeting");
    	type="show";
    	return "HumanitiesAcademicMeeting";
	}
    
    //得到全部人文社科类著作的相关信息
    @SuppressWarnings("unchecked")
	public String humanitiesBook(){
		
    	humanitiesBooklists = (List<HumanitiesBook>) 
    			collegeManagerService.getInfo("HumanitiesBook");
    	type="show";
    	return "HumanitiesBook";
	}

    //得到全部人文社科类交流论文的相关信息
    @SuppressWarnings("unchecked")
	public String humanitiesExchangePaper(){
		
    	humanitiesExchangePaperlists = (List<HumanitiesExchangePaper>)
    			collegeManagerService.getInfo("HumanitiesExchangePaper");
    	type="show";
    	return "HumanitiesExchangePaper";
	}
    
    //得到全部人文社科类论文的相关信息
    @SuppressWarnings("unchecked")
	public String humanitiesPaper(){
		
    	humanitiesPaperlists = (List<HumanitiesPaper>) 
    			collegeManagerService.getInfo("HumanitiesPaper");
    	type="show";
    	return "HumanitiesPaper";
	}
    
    //得到全部人文社科类项目基本信息的相关信息
    @SuppressWarnings("unchecked")
	public String humanitiesProject(){
		
    	humanitiesProjectlists = (List<HumanitiesProject>) 
    			collegeManagerService.findInfo("HumanitiesProject");
    	type="show";
    	return "HumanitiesProject";
	}
    
    //得到全部人文社科类科研获奖的相关信息
    @SuppressWarnings("unchecked")
	public String humanitiesResearchReward(){
		
    	humanitiesResearchRewardlists = (List<HumanitiesResearchReward>) 
    			collegeManagerService.getInfo("HumanitiesResearchReward");
    	type="show";
    	return "HumanitiesResearchReward";
	}
  
}
