package com.cqupt.mis.rms.action.college;

import java.util.List;

import com.cqupt.mis.rms.model.Proofs;
import com.cqupt.mis.rms.model.ScienceBook;
import com.cqupt.mis.rms.model.ScienceBookAuthor;
import com.cqupt.mis.rms.model.ScienceDetailTechProject;
import com.cqupt.mis.rms.model.ScienceGovAwardPerson;
import com.cqupt.mis.rms.model.ScienceGovernmentAward;
import com.cqupt.mis.rms.model.ScienceInventors;
import com.cqupt.mis.rms.model.ScienceIpRights;
import com.cqupt.mis.rms.model.ScienceOrganization;
import com.cqupt.mis.rms.model.SciencePaper;
import com.cqupt.mis.rms.model.SciencePaperAuthor;
import com.cqupt.mis.rms.model.ScienceTechAttendPerson;
import com.cqupt.mis.rms.model.ScienceTechExchange;
import com.cqupt.mis.rms.model.ScienceTechProject;
import com.cqupt.mis.rms.model.ScienceTechProjectMember;
import com.cqupt.mis.rms.model.ScienceTechTransfer;
import com.cqupt.mis.rms.model.ScienceTransferLeader;
import com.cqupt.mis.rms.service.CollegeManagerService;
import com.opensymphony.xwork2.ActionSupport;
/**
 * <p>Title:实现得到满足要求的理工科研类信息的action</p>
 * <p>Copyright:Copyright(c)2012</p>
 * <p>Company:重邮信管工作室 </p>
 * @author HHY
 * @version 1.0
 * */
@SuppressWarnings("serial")
public class ManagerCollegeTecStatusAction extends ActionSupport{

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


    //理工科研类
    //得到满足要求的理工科研类著作的相关信息
    private List<ScienceBook> scienceBooklists;
    //得到满足要求的理工科研类政府科技奖励的相关信息
    private List<ScienceGovernmentAward> scienceGovernmentAwardlists;
    //得到满足要求的理工科研类知识产权情况的相关信息
    private List<ScienceIpRights> scienceIpRightslists;
    //得到满足要求的理工科研类活动机构的相关信息
    private List<ScienceOrganization> scienceOrganizationlists;
    //得到满足要求的理工科研类论文的相关信息
    private List<SciencePaper> sciencePaperlists;
    //得到满足要求的理工科研类技术转让情况的相关信息
    private List<ScienceTechTransfer> scienceTechTransferlists;
    //得到满足要求的理工科研类科技项目相关信息
    private List<ScienceTechProject> scienceTechProjectlists;
    //得到满足要求的理工科研类技术交流情况的相关信息
    private List<ScienceTechExchange> scienceTechExchangelists;
    
    private List<ScienceTechAttendPerson> scienceTechAttendPersonlists;
    
    //得到满足要求的理工科研类著作参与人的相关信息
    private List<ScienceBookAuthor> scienceBookAuthorlists;
    //得到满足要求的理工科研类政府科技奖励参与人的相关信息
    private List<ScienceGovAwardPerson> scienceGovAwardPersonlists;
    //得到满足要求的理工科研类知识产权情况参与人的相关信息
    private List<ScienceInventors> scienceInventorslists;
    //得到满足要求的理工科研类论文参与人的相关信息
    private List<SciencePaperAuthor> sciencePaperAuthorlists;
   
    //得到满足要求的理工科研类科技项目详细信息
    private List<ScienceDetailTechProject> scienceDetailTechProjectlists;
    //得到满足要求的理工科研类科技项目参与人信息
    private List<ScienceTechProjectMember> scienceTechProjectMemberlists;
    
    /*
     * 新添加内容：技术转让负责人信息
     * LvHai 2012-10-31
     * */
    private List<ScienceTransferLeader> scienceTransferLeaderlists;
   
    //得到与之对应的旁证材料
    private List<Proofs> proofslists;
    
    public List<Proofs> getProofslists() {
		return proofslists;
	}

	public void setProofslists(List<Proofs> proofslists) {
		this.proofslists = proofslists;
	}

	public List<ScienceBookAuthor> getScienceBookAuthorlists() {
		return scienceBookAuthorlists;
	}

	public void setScienceBookAuthorlists(
			List<ScienceBookAuthor> scienceBookAuthorlists) {
		this.scienceBookAuthorlists = scienceBookAuthorlists;
	}

	public List<ScienceGovAwardPerson> getScienceGovAwardPersonlists() {
		return scienceGovAwardPersonlists;
	}

	public void setScienceGovAwardPersonlists(
			List<ScienceGovAwardPerson> scienceGovAwardPersonlists) {
		this.scienceGovAwardPersonlists = scienceGovAwardPersonlists;
	}

	public List<ScienceInventors> getScienceInventorslists() {
		return scienceInventorslists;
	}

	public void setScienceInventorslists(
			List<ScienceInventors> scienceInventorslists) {
		this.scienceInventorslists = scienceInventorslists;
	}

	public List<SciencePaperAuthor> getSciencePaperAuthorlists() {
		return sciencePaperAuthorlists;
	}

	public void setSciencePaperAuthorlists(
			List<SciencePaperAuthor> sciencePaperAuthorlists) {
		this.sciencePaperAuthorlists = sciencePaperAuthorlists;
	}

	public List<ScienceDetailTechProject> getScienceDetailTechProjectlists() {
		return scienceDetailTechProjectlists;
	}

	public void setScienceDetailTechProjectlists(
			List<ScienceDetailTechProject> scienceDetailTechProjectlists) {
		this.scienceDetailTechProjectlists = scienceDetailTechProjectlists;
	}

	public List<ScienceTechProjectMember> getScienceTechProjectMemberlists() {
		return scienceTechProjectMemberlists;
	}

	public void setScienceTechProjectMemberlists(
			List<ScienceTechProjectMember> scienceTechProjectMemberlists) {
		this.scienceTechProjectMemberlists = scienceTechProjectMemberlists;
	}

    public CollegeManagerService getCollegeManagerService() {
		return collegeManagerService;
	}

	public void setCollegeManagerService(CollegeManagerService collegeManagerService) {
		this.collegeManagerService = collegeManagerService;
	}

	

	public List<ScienceBook> getScienceBooklists() {
		return scienceBooklists;
	}

	public void setScienceBooklists(List<ScienceBook> scienceBooklists) {
		this.scienceBooklists = scienceBooklists;
	}

	public List<ScienceGovernmentAward> getScienceGovernmentAwardlists() {
		return scienceGovernmentAwardlists;
	}

	public void setScienceGovernmentAwardlists(
			List<ScienceGovernmentAward> scienceGovernmentAwardlists) {
		this.scienceGovernmentAwardlists = scienceGovernmentAwardlists;
	}

	public List<ScienceIpRights> getScienceIpRightslists() {
		return scienceIpRightslists;
	}

	public void setScienceIpRightslists(List<ScienceIpRights> scienceIpRightslists) {
		this.scienceIpRightslists = scienceIpRightslists;
	}

	public List<ScienceOrganization> getScienceOrganizationlists() {
		return scienceOrganizationlists;
	}

	public void setScienceOrganizationlists(
			List<ScienceOrganization> scienceOrganizationlists) {
		this.scienceOrganizationlists = scienceOrganizationlists;
	}

	public List<SciencePaper> getSciencePaperlists() {
		return sciencePaperlists;
	}

	public void setSciencePaperlists(List<SciencePaper> sciencePaperlists) {
		this.sciencePaperlists = sciencePaperlists;
	}

	public List<ScienceTechTransfer> getScienceTechTransferlists() {
		return scienceTechTransferlists;
	}

	public void setScienceTechTransferlists(
			List<ScienceTechTransfer> scienceTechTransferlists) {
		this.scienceTechTransferlists = scienceTechTransferlists;
	}

	public List<ScienceTechProject> getScienceTechProjectlists() {
		return scienceTechProjectlists;
	}

	public void setScienceTechProjectlists(
			List<ScienceTechProject> scienceTechProjectlists) {
		this.scienceTechProjectlists = scienceTechProjectlists;
	}

	public List<ScienceTechExchange> getScienceTechExchangelists() {
		return scienceTechExchangelists;
	}

	public void setScienceTechExchangelists(
			List<ScienceTechExchange> scienceTechExchangelists) {
		this.scienceTechExchangelists = scienceTechExchangelists;
	}

	
	
    @SuppressWarnings("unchecked")
	public String scienceBook(){
    	//得到满足要求的理工科研类著作的相关信息
    	scienceBooklists = (List<ScienceBook>) 
    			collegeManagerService.getInfoByFactor(id, "ScienceBook","bookId");
    	
    	//得到满足要求的理工科研类著作人的相关信息
    	scienceBookAuthorlists = (List<ScienceBookAuthor>)
    			collegeManagerService.getInfoByFactor(id, "ScienceBookAuthor", "scienceBook.bookId");
    	
    	//得到满足要求的理工科研类著作的相关信息的旁证材料
    	proofslists = (List<Proofs>)
    			collegeManagerService.getInfoByFactor(id, "Proofs", "infoApprovedId");
		
    	return "ScienceBook";
	}
    
   
    @SuppressWarnings("unchecked")
	public String scienceGovernmentAward(){
		 //得到满足要求的理工科研类政府科技奖励的相关信息
    	scienceGovernmentAwardlists = (List<ScienceGovernmentAward>) 
    			collegeManagerService.getInfoByFactor(id, "ScienceGovernmentAward","awardId");
		
    	 //得到满足要求的理工科研类政府科技奖励获得人的相关信息
    	scienceGovAwardPersonlists = (List<ScienceGovAwardPerson>)
    			collegeManagerService.getInfoByFactor(id, "ScienceGovAwardPerson", "scienceGovernmentAward.awardId");
    	
    	 //得到满足要求的理工科研类政府科技奖励的相关信息的旁证材料
    	proofslists = (List<Proofs>)
    			collegeManagerService.getInfoByFactor(id, "Proofs", "infoApprovedId");
    	
		return "ScienceGovernmentAward";
	}
    
  
    @SuppressWarnings("unchecked")
	public String scienceIpRights(){
    	//得到满足要求的理工科研类知识产权情况的相关信息
    	scienceIpRightslists = (List<ScienceIpRights>) 
    			collegeManagerService.getInfoByFactor(id, "ScienceIpRights","rightsId");
		
    	 //得到满足要求的理工科研类知识产权人情况的相关信息
    	scienceInventorslists = (List<ScienceInventors>)
    			collegeManagerService.getInfoByFactor(id, "ScienceInventors", "scienceIpRights.rightsId");
    	
    	  //得到满足要求的理工科研类知识产权情况的相关信息的旁证材料
    	proofslists = (List<Proofs>)
    			collegeManagerService.getInfoByFactor(id, "Proofs", "infoApprovedId");
    	
		return "ScienceIpRights";
	}
   
    
    @SuppressWarnings("unchecked")
	public String scienceOrganization(){
    	//得到满足要求的理工科研类活动机构的相关信息
    	scienceOrganizationlists = (List<ScienceOrganization>) 
    			collegeManagerService.getInfoByFactor(id, "ScienceOrganization","organizationId");
		
    	//得到满足要求的理工科研类活动机构的相关信息的旁证材料
    	proofslists = (List<Proofs>)
    			collegeManagerService.getInfoByFactor(id, "Proofs", "infoApprovedId");
    	
		return "ScienceOrganization";
	}
    
   
    @SuppressWarnings("unchecked")
	public String sciencePaper(){
    	 //得到满足要求的理工科研类论文的相关信息
    	sciencePaperlists = (List<SciencePaper>) 
    			collegeManagerService.getInfoByFactor(id, "SciencePaper","paperId");
    	
    	 //得到满足要求的理工科研类论文作者的相关信息
    	sciencePaperAuthorlists = (List<SciencePaperAuthor>)
    			collegeManagerService.getInfoByFactor(id, "SciencePaperAuthor", "sciencePaper.paperId");
    	
    	 //得到满足要求的理工科研类论文的相关信息的旁证材料
    	proofslists = (List<Proofs>)
    			collegeManagerService.getInfoByFactor(id, "Proofs", "infoApprovedId");
    	
    	return "SciencePaper";
	}
 
    
    @SuppressWarnings("unchecked")
	public String scienceTechTransfer(){
    	//得到满足要求的理工科研类技术转让情况的相关信息
    	scienceTechTransferlists = (List<ScienceTechTransfer>) 
    			collegeManagerService.getInfoByFactor(id, "ScienceTechTransfer","transferId");
		
    	//得到满足要求的理工技术转让项目负责人信息
    	scienceTransferLeaderlists = (List<ScienceTransferLeader>)
    			collegeManagerService.getInfoByFactor(id, "ScienceTransferLeader", "scienceTechTransfer.transferId");
    	
    	//得到满足要求的理工科研类技术转让情况的相关信息的旁证材料
    	proofslists = (List<Proofs>)
    			collegeManagerService.getInfoByFactor(id, "Proofs", "infoApprovedId");
		
    	return "ScienceTechTransfer";
	}
    
   
    @SuppressWarnings("unchecked")
	public String scienceTechProject(){
    	 //得到满足要求的理工科研类科技项目相关信息
    	scienceTechProjectlists = (List<ScienceTechProject>) 
    			collegeManagerService.getInfoByFactor(id, "ScienceTechProject","projectId");
    	
    	 //得到满足要求的理工科研类科技项目参与人相关信息
    	scienceDetailTechProjectlists = (List<ScienceDetailTechProject>) 
    			collegeManagerService.getInfoByFactor(id, "ScienceDetailTechProject", "scienceTechProject.projectId");
		
    	 //得到满足要求的理工科研类科技项目详细信息
    	scienceTechProjectMemberlists = (List<ScienceTechProjectMember>)
    			collegeManagerService.getInfoByFactor(id, "ScienceTechProjectMember", "project.projectId");
    	
    	 //得到满足要求的理工科研类科技项目相关信息的旁证材料
    	proofslists = (List<Proofs>)
    			collegeManagerService.getInfoByFactor(id, "Proofs", "infoApprovedId");
    	
    	return "ScienceTechProject";
	}
    
    
    @SuppressWarnings("unchecked")
	public String scienceTechExchange(){
    	//得到满足要求的理工科研类技术转让情况的相关信息
    	scienceTechExchangelists = (List<ScienceTechExchange>) 
    			collegeManagerService.getInfoByFactor(id, "ScienceTechExchange","techExchangeId");
    	
    	scienceTechAttendPersonlists = (List<ScienceTechAttendPerson>)
    			collegeManagerService.getInfoByFactor(id, "ScienceTechAttendPerson", "scienceTechExchange.techExchangeId");
    	
    	//得到满足要求的理工科研类技术转让情况的相关信息的旁证材料
    	proofslists = (List<Proofs>)
    		
    			collegeManagerService.getInfoByFactor(id, "Proofs", "infoApprovedId");
    	
		return "ScienceTechExchange";
	}

	public List<ScienceTechAttendPerson> getScienceTechAttendPersonlists() {
		return scienceTechAttendPersonlists;
	}

	public void setScienceTechAttendPersonlists(
			List<ScienceTechAttendPerson> scienceTechAttendPersonlists) {
		this.scienceTechAttendPersonlists = scienceTechAttendPersonlists;
	}

	public List<ScienceTransferLeader> getScienceTransferLeaderlists() {
		return scienceTransferLeaderlists;
	}

	public void setScienceTransferLeaderlists(
			List<ScienceTransferLeader> scienceTransferLeaderlists) {
		this.scienceTransferLeaderlists = scienceTransferLeaderlists;
	}
    
}
