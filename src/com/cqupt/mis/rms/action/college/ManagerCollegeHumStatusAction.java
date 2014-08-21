package com.cqupt.mis.rms.action.college;

import java.util.List;
import com.cqupt.mis.rms.model.HumanitiesAcademicMeeting;
import com.cqupt.mis.rms.model.HumanitiesAcademicMeetingPerson;
import com.cqupt.mis.rms.model.HumanitiesBook;
import com.cqupt.mis.rms.model.HumanitiesBookAuthor;
import com.cqupt.mis.rms.model.HumanitiesExchangePaper;
import com.cqupt.mis.rms.model.HumanitiesExchangePaperAuthor;
import com.cqupt.mis.rms.model.HumanitiesPaper;
import com.cqupt.mis.rms.model.HumanitiesPaperAuthor;
import com.cqupt.mis.rms.model.HumanitiesProject;
import com.cqupt.mis.rms.model.HumanitiesProjectDetail;
import com.cqupt.mis.rms.model.HumanitiesProjectMember;
import com.cqupt.mis.rms.model.HumanitiesResearchReward;
import com.cqupt.mis.rms.model.HumanitiesResearchRewardPerson;
import com.cqupt.mis.rms.model.Proofs;
import com.cqupt.mis.rms.service.CollegeManagerService;
import com.opensymphony.xwork2.ActionSupport;
/**
 * <p>Title:实现得到满足要求的人文社科类信息的action</p>
 * <p>Copyright:Copyright(c)2012</p>
 * <p>Company:重邮信管工作室 </p>
 * @author HHY
 * @version 1.0
 * */
@SuppressWarnings("serial")
public class ManagerCollegeHumStatusAction extends ActionSupport{

	//注入服务层接口
	private CollegeManagerService collegeManagerService;
	//得到id的值
	private String id;
	private String type;
	
	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

  
    //人文社科类
    //得到满足要求的人文社科类学术会议的相关信息
    private List<HumanitiesAcademicMeeting> humanitiesAcademicMeetinglists;
    //得到满足要求的人文社科类著作的相关信息
    private List<HumanitiesBookAuthor> humanitiesBookAuthorlists;
    //得到满足要求的人文社科类交流论文的相关信息
    private List<HumanitiesExchangePaper> humanitiesExchangePaperlists;
    //得到满足要求的人文社科类论文的相关信息
    private List<HumanitiesPaper> humanitiesPaperlists;
    //得到满足要求的人文社科类项目基本信息的相关信息
    private List<HumanitiesProject> humanitiesProjectlists;
    //得到满足要求的人文社科类科研获奖的相关信息
    private List<HumanitiesResearchReward> humanitiesResearchRewardlists;
    
   //得到满足要求的人文社科类学术会议参与人的相关信息
    private List<HumanitiesAcademicMeetingPerson> humanitiesAcademicMeetingPersonlists;
    //得到满足要求的人文社科类著作参与人的相关信息
    private List<HumanitiesBook> humanitiesBooklists;
    //得到满足要求的人文社科类交流论文参与人的相关信息
    private List<HumanitiesExchangePaperAuthor> humanitiesExchangePaperAuthorlists;
    //得到满足要求的人文社科类论文参与人的相关信息
    private List<HumanitiesPaperAuthor> humanitiesPaperAuthorlists;
    //得到满足要求的人文社科类项目详细信息的相关信息
    private List<HumanitiesProjectDetail> humanitiesProjectDetaillists;
    //得到满足要求的人文社科类项目参与人的相关信息
    private List<HumanitiesProjectMember> humanitiesProjectMemberlists;
    //得到满足要求的人文社科类科研获奖参与人的相关信息
    private List<HumanitiesResearchRewardPerson> HumanitiesResearchRewardPersonlists;
    
    //得到与之对应的旁证材料
    private List<Proofs> proofslists;
    
    public List<Proofs> getProofslists() {
		return proofslists;
	}

	public void setProofslists(List<Proofs> proofslists) {
		this.proofslists = proofslists;
	}

   
    public List<HumanitiesBookAuthor> getHumanitiesBookAuthorlists() {
		return humanitiesBookAuthorlists;
	}

	public void setHumanitiesBookAuthorlists(
			List<HumanitiesBookAuthor> humanitiesBookAuthorlists) {
		this.humanitiesBookAuthorlists = humanitiesBookAuthorlists;
	}

	public List<HumanitiesAcademicMeetingPerson> getHumanitiesAcademicMeetingPersonlists() {
		return humanitiesAcademicMeetingPersonlists;
	}

	public void setHumanitiesAcademicMeetingPersonlists(
			List<HumanitiesAcademicMeetingPerson> humanitiesAcademicMeetingPersonlists) {
		this.humanitiesAcademicMeetingPersonlists = humanitiesAcademicMeetingPersonlists;
	}

	public List<HumanitiesExchangePaperAuthor> getHumanitiesExchangePaperAuthorlists() {
		return humanitiesExchangePaperAuthorlists;
	}

	public void setHumanitiesExchangePaperAuthorlists(
			List<HumanitiesExchangePaperAuthor> humanitiesExchangePaperAuthorlists) {
		this.humanitiesExchangePaperAuthorlists = humanitiesExchangePaperAuthorlists;
	}

	public List<HumanitiesPaperAuthor> getHumanitiesPaperAuthorlists() {
		return humanitiesPaperAuthorlists;
	}

	public void setHumanitiesPaperAuthorlists(
			List<HumanitiesPaperAuthor> humanitiesPaperAuthorlists) {
		this.humanitiesPaperAuthorlists = humanitiesPaperAuthorlists;
	}

	public List<HumanitiesProjectDetail> getHumanitiesProjectDetaillists() {
		return humanitiesProjectDetaillists;
	}

	public void setHumanitiesProjectDetaillists(
			List<HumanitiesProjectDetail> humanitiesProjectDetaillists) {
		this.humanitiesProjectDetaillists = humanitiesProjectDetaillists;
	}

	public List<HumanitiesProjectMember> getHumanitiesProjectMemberlists() {
		return humanitiesProjectMemberlists;
	}

	public void setHumanitiesProjectMemberlists(
			List<HumanitiesProjectMember> humanitiesProjectMemberlists) {
		this.humanitiesProjectMemberlists = humanitiesProjectMemberlists;
	}

	public List<HumanitiesResearchRewardPerson> getHumanitiesResearchRewardPersonlists() {
		return HumanitiesResearchRewardPersonlists;
	}

	public void setHumanitiesResearchRewardPersonlists(
			List<HumanitiesResearchRewardPerson> humanitiesResearchRewardPersonlists) {
		HumanitiesResearchRewardPersonlists = humanitiesResearchRewardPersonlists;
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

	
    @SuppressWarnings("unchecked")
	public String humanitiesAcademicMeeting(){
		//得到满足要求的人文社科类学术会议的相关信息
    	humanitiesAcademicMeetinglists = (List<HumanitiesAcademicMeeting>) 
    			collegeManagerService.getInfoByFactor(id, "HumanitiesAcademicMeeting","academicMeetingId");
    	
    	//得到满足要求的人文社科类学术会议参与人的相关信息
    	humanitiesAcademicMeetingPersonlists = (List<HumanitiesAcademicMeetingPerson>) 
    			collegeManagerService.getInfoByFactor(id, "HumanitiesAcademicMeetingPerson","humanitiesAcademicMeeting.academicMeetingId");
    	
    	//得到满足要求的人文社科类学术会议的相关信息的旁证材料
    	proofslists = (List<Proofs>)
    			collegeManagerService.getInfoByFactor(id, "Proofs", "infoApprovedId");
    	
    	return "HumanitiesAcademicMeeting";
	}
    
   
    
    @SuppressWarnings("unchecked")
	public String humanitiesBook(){
    	//得到满足要求的人文社科类著作的相关信息
    	humanitiesBooklists = (List<HumanitiesBook>) 
    			collegeManagerService.getInfoByFactor(id, "HumanitiesBook","bookId");
    	
    	//得到满足要求的人文社科类著作著作人的相关信息
    	humanitiesBookAuthorlists = (List<HumanitiesBookAuthor>)
    			collegeManagerService.getInfoByFactor(id, "HumanitiesBookAuthor", "humanitiesBook.bookId");
		
    	//得到满足要求的人文社科类著作的相关信息的旁证材料
    	proofslists = (List<Proofs>)
    			collegeManagerService.getInfoByFactor(id, "Proofs", "infoApprovedId");
    	return "HumanitiesBook";
	}
    
   
    @SuppressWarnings("unchecked")
	public String humanitiesExchangePaper(){
	    //得到满足要求的人文社科类交流论文的相关信息
    	humanitiesExchangePaperlists = (List<HumanitiesExchangePaper>) 
    			collegeManagerService.getInfoByFactor(id, "HumanitiesExchangePaper","exchangePaperId");
		
        //得到满足要求的人文社科类交流论文参与人的相关信息
    	humanitiesExchangePaperAuthorlists = (List<HumanitiesExchangePaperAuthor>) 
    			collegeManagerService.getInfoByFactor(id, "HumanitiesExchangePaperAuthor", "humanitiesExchangePaper.exchangePaperId");
		
        //得到满足要求的人文社科类交流论文的相关信息的旁证材料
    	proofslists = (List<Proofs>)
    			collegeManagerService.getInfoByFactor(id, "Proofs", "infoApprovedId");
    	return "HumanitiesExchangePaper";
	}
    
   
    @SuppressWarnings("unchecked")
	public String humanitiesPaper(){
    	//得到满足要求的人文社科类论文的相关信息
    	humanitiesPaperlists = (List<HumanitiesPaper>) 
    			collegeManagerService.getInfoByFactor(id, "HumanitiesPaper","paperId");
		
    	//得到满足要求的人文社科类论文作者的相关信息
    	humanitiesPaperAuthorlists = (List<HumanitiesPaperAuthor>)
    			collegeManagerService.getInfoByFactor(id, "HumanitiesPaperAuthor", "humanitiesPaper.paperId");
    	
    	//得到满足要求的人文社科类论文的相关信息的旁证材料
    	proofslists = (List<Proofs>)
    			collegeManagerService.getInfoByFactor(id, "Proofs", "infoApprovedId");
    	return "HumanitiesPaper";
	}
    
    
    @SuppressWarnings("unchecked")
	public String humanitiesProject(){
    	//得到满足要求的人文社科类项目基本信息的相关信息
    	humanitiesProjectlists = (List<HumanitiesProject>) 
    			collegeManagerService.getInfoByFactor(id, "HumanitiesProject","projectId");
		
    	//得到满足要求的人文社科类项目的详细信息
    	humanitiesProjectDetaillists = (List<HumanitiesProjectDetail>)
    			collegeManagerService.getInfoByFactor(id, "HumanitiesProjectDetail", "humanitiesProject.projectId");
		
    	//得到满足要求的人文社科类项目参与人的相关信息
    	humanitiesProjectMemberlists = (List<HumanitiesProjectMember>)
    			collegeManagerService.getInfoByFactor(id, "HumanitiesProjectMember", "humanitiesProject.projectId");
    
    	//得到满足要求的人文社科类项目基本信息的相关信息的旁证材料
    	proofslists = (List<Proofs>)
    			collegeManagerService.getInfoByFactor(id, "Proofs", "infoApprovedId");
    	return "HumanitiesProject";
	}
 
    
    @SuppressWarnings("unchecked")
	public String humanitiesResearchReward(){
    	//得到满足要求的人文社科类科研获奖的相关信息
    	humanitiesResearchRewardlists = (List<HumanitiesResearchReward>) 
    			collegeManagerService.getInfoByFactor(id, "HumanitiesResearchReward","researchRewardId");
		
    	//得到满足要求的人文社科类科研获奖人的相关信息
    	HumanitiesResearchRewardPersonlists = (List<HumanitiesResearchRewardPerson>)
    			collegeManagerService.getInfoByFactor(id, "HumanitiesResearchRewardPerson", "humanitiesResearchReward.researchRewardId");
		
    	//得到满足要求的人文社科类科研获奖的相关信息的旁证材料
    	proofslists = (List<Proofs>)
    			collegeManagerService.getInfoByFactor(id, "Proofs", "infoApprovedId");
    	return "HumanitiesResearchReward";
	}
  
}
