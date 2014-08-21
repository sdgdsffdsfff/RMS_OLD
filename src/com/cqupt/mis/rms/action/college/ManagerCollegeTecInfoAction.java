package com.cqupt.mis.rms.action.college;

import java.util.List;
import com.cqupt.mis.rms.model.ScienceBook;
import com.cqupt.mis.rms.model.ScienceGovernmentAward;
import com.cqupt.mis.rms.model.ScienceIpRights;
import com.cqupt.mis.rms.model.ScienceOrganization;
import com.cqupt.mis.rms.model.SciencePaper;
import com.cqupt.mis.rms.model.ScienceTechExchange;
import com.cqupt.mis.rms.model.ScienceTechProject;
import com.cqupt.mis.rms.model.ScienceTechTransfer;
import com.cqupt.mis.rms.service.CollegeManagerService;
import com.opensymphony.xwork2.ActionSupport;
/**
 * <p>Title:实现得理工科研类信息的action</p>
 * <p>Copyright:Copyright(c)2012</p>
 * <p>Company:重邮信管工作室 </p>
 * @author HHY
 * @version 1.0
 * */
@SuppressWarnings("serial")
public class ManagerCollegeTecInfoAction extends ActionSupport{

	//注入服务层接口
	private CollegeManagerService collegeManagerService;
	    
    //理工科研类
    //得到全部理工科研类著作的相关信息
    private List<ScienceBook> scienceBooklists;
    //得到全部理工科研类政府科技奖励的相关信息
    private List<ScienceGovernmentAward> scienceGovernmentAwardlists;
    //得到全部理工科研类知识产权情况的相关信息
    private List<ScienceIpRights> scienceIpRightslists;
    //得到全部理工科研类活动机构的相关信息
    private List<ScienceOrganization> scienceOrganizationlists;
    //得到全部理工科研类论文的相关信息
    private List<SciencePaper> sciencePaperlists;
    //得到全部理工科研类技术转让情况的相关信息
    private List<ScienceTechTransfer> scienceTechTransferlists;
    //得到全部理工科研类科技项目相关信息
    private List<ScienceTechProject> scienceTechProjectlists;
    //得到全部理工科研类技术转让情况的相关信息
    private List<ScienceTechExchange> scienceTechExchangelists;
    
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

	
	//得到全部理工科研类著作的相关信息
    @SuppressWarnings("unchecked")
	public String scienceBook(){
		
    	scienceBooklists = (List<ScienceBook>) 
    			collegeManagerService.getInfo("ScienceBook");
    	
    	type="show";
    	return "ScienceBook";
	}
    
    //得到全部理工科研类政府科技奖励的相关信息
    @SuppressWarnings("unchecked")
	public String scienceGovernmentAward(){
		
    	scienceGovernmentAwardlists = (List<ScienceGovernmentAward>) 
    			collegeManagerService.getInfo("ScienceGovernmentAward");
    	
    	type="show";
    	return "ScienceGovernmentAward";
	}
    
    //得到全部理工科研类知识产权情况的相关信息
    @SuppressWarnings("unchecked")
	public String scienceIpRights(){
		
    	scienceIpRightslists = (List<ScienceIpRights>) 
    			collegeManagerService.getInfo("ScienceIpRights");
    	
    	type="show";
    	return "ScienceIpRights";
	}
  
    //得到全部理工科研类活动机构的相关信息
    @SuppressWarnings("unchecked")
	public String scienceOrganization(){
		
    	scienceOrganizationlists = (List<ScienceOrganization>) 
    			collegeManagerService.getInfo("ScienceOrganization");
    	
    	type="show";
    	return "ScienceOrganization";
	}
    
    //得到全部理工科研类论文的相关信息
    @SuppressWarnings("unchecked")
	public String sciencePaper(){
		
    	sciencePaperlists = (List<SciencePaper>) 
    			collegeManagerService.getInfo("SciencePaper");
    	
    	type="show";
    	return "SciencePaper";
	}
 
    //得到全部理工科研类技术转让情况的相关信息
    @SuppressWarnings("unchecked")
	public String scienceTechTransfer(){
		
    	scienceTechTransferlists = (List<ScienceTechTransfer>) 
    			collegeManagerService.getInfo("ScienceTechTransfer");
    	
    	type="show";
    	return "ScienceTechTransfer";
	}
    
    //得到全部理工科研类科技项目相关信息
    @SuppressWarnings("unchecked")
	public String scienceTechProject(){
		
    	scienceTechProjectlists = (List<ScienceTechProject>) 
    			collegeManagerService.findInfo("ScienceTechProject");
    	
    	type="show";
    	return "ScienceTechProject";
	}
    
    //得到全部理工科研类技术转让情况的相关信息
    @SuppressWarnings("unchecked")
	public String scienceTechExchange(){
		
    	scienceTechExchangelists = (List<ScienceTechExchange>)
    			collegeManagerService.getInfo("ScienceTechExchange");
    	
    	type="show";    	
    	return "ScienceTechExchange";
	}
  
}
