/**
*Copyright(c)2012 重邮信管工作室
*All right reserved.
*/
package com.cqupt.mis.rms.action.teacher.modify;

import java.io.File;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletContext;

import org.apache.commons.io.FileUtils;
import org.apache.struts2.util.ServletContextAware;

import com.cqupt.mis.rms.manager.ResearchInfoDao;
import com.cqupt.mis.rms.model.Proofs;
import com.cqupt.mis.rms.model.ScienceDetailTechProject;
import com.cqupt.mis.rms.model.ScienceTechProject;
import com.cqupt.mis.rms.model.ScienceTechProjectMember;
import com.cqupt.mis.rms.service.ResearchInfoService;
import com.cqupt.mis.rms.utils.Confirm;
import com.cqupt.mis.rms.utils.GenerateUtils;
import com.cqupt.mis.rms.utils.TypeConvert;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

/**
*<p>Title:处理教师用户提交理科科技项目基本信息的Action</p>
*<p>Description:接收用户提交的信息并处理</p>
*@author LvHai
*@version 1.0
**/
@SuppressWarnings("serial")
public class ModifyScienceTechProjectAction extends ActionSupport implements ServletContextAware {
	//注入接口
	private ResearchInfoService researchInfoService;
	private ResearchInfoDao researchInfoDao;
	
	//科技项目基本信息
	private String projectId;
	private String projectName;
	private String timeProjectApproved;
	private float totalFundContract;
	private String sortSubject;
	private String sortActivity;
	private String originProject;
	private String formOrganization;
	private String formCooperation;
	private String organReliedProject;
	private String industryService;
	private String unitProject;
	
	//科技项目详细信息
	private String deatilProjectId;
	private float inputThisYear;
	private float expenditureThisYear;
	private int totalStaff;
	private int advancedStaff;
	private int middleStaff;
	private int juniorStaff;
	private int otherStaff;
	private int graduateJoin;
	private String projectStatus;
	
	private String submit;
	
	//成员名字
	private String[] memberName;
	private String[] remarksMem;

	//上传文件
	private File[] upload;// 实际上传文件
	private String[] uploadContentType; // 文件的内容类型
	private String[] uploadFileName; // 上传文件名
	private String[] descProof;//旁证材料描述
	private ServletContext servletContext;
	@Override
	public void setServletContext(ServletContext servletContext) {
		this.servletContext = servletContext;
	}

	public String execute() throws Exception {
		
		//如果submit==保存，status=0，如果submit==提交，status=1
		int status;
		if("保存".equals(submit)){
			status = 0;
		}else if("提交".equals(submit)){
			status = 1;
		}else{
			status = -1;
		}
		
		List<Proofs> proofs = new ArrayList<Proofs>();
		List<ScienceTechProjectMember> scienceTechProjectMembers = new ArrayList<ScienceTechProjectMember>();
		String targetDirectory = servletContext.getRealPath(GenerateUtils.generateSavePath());//获得路径
		//设置科技项目基本信息
		ScienceTechProject scienceTechProject = (ScienceTechProject)researchInfoDao.findResearchInfoByIdAndModelNameAndFactor(projectId, "ScienceTechProject", "projectId");
		scienceTechProject.setFormCooperation(formCooperation);
		scienceTechProject.setFormOrganization(formOrganization);
		scienceTechProject.setIndustryService(industryService);
		scienceTechProject.setOrganReliedProject(organReliedProject);
		scienceTechProject.setOriginProject(originProject);
		scienceTechProject.setProjectId(projectId);
		scienceTechProject.setProjectName(projectName);
		scienceTechProject.setSortActivity(sortActivity);
		scienceTechProject.setSortSubject(sortSubject);
		scienceTechProject.setTimeProjectApproved(TypeConvert.stringOrNullToDate(timeProjectApproved));
		scienceTechProject.setTotalFundContract(totalFundContract);
		scienceTechProject.setUnitProject(unitProject);
		scienceTechProject.setStatus(status);
		//设置科技项目详细信息
		ScienceDetailTechProject scienceDetailTechProject = (ScienceDetailTechProject)researchInfoDao.findResearchInfoByIdAndModelNameAndFactor(deatilProjectId, "ScienceDetailTechProject", "deatilProjectId");
		scienceDetailTechProject.setAdvancedStaff(advancedStaff);
		scienceDetailTechProject.setDeatilProjectId(deatilProjectId);
		scienceDetailTechProject.setExpenditureThisYear(expenditureThisYear);
		scienceDetailTechProject.setGraduateJoin(graduateJoin);
		scienceDetailTechProject.setInputThisYear(inputThisYear);
		scienceDetailTechProject.setJuniorStaff(juniorStaff);
		scienceDetailTechProject.setMiddleStaff(middleStaff);
		scienceDetailTechProject.setOtherStaff(otherStaff);
		scienceDetailTechProject.setProjectStatus(projectStatus);
		scienceDetailTechProject.setScienceTechProject(scienceTechProject);
		scienceDetailTechProject.setTotalStaff(totalStaff);
		scienceDetailTechProject.setUpdateTime(new Date());//更新时间设置为当前信息提交时间
		
		
		try {
			//上传旁证材料
			if(upload != null){
				for (int i = 0; i < upload.length; i++){
					String fileName = uploadFileName[i];// 上传的文件名
					String fileType = uploadContentType[i];// 文件类型
					String targetFileName = GenerateUtils.generateFileName(fileName);   
			        File target = new File(targetDirectory, targetFileName); 
			        FileUtils.copyFile(upload[i], target);
			        Proofs proof = new Proofs();
			        proof.setInfoApprovedId(projectId);
			        proof.setTimeProofUpload(new Date());
			        proof.setUploadProofName(fileName);
			        proof.setUploadContentType(fileType);
			        proof.setUploadRealName(targetFileName);
			        proof.setProofPath(GenerateUtils.generateSavePath());
			        if(!"".equals(descProof[i]) && descProof[i] != null){
			        	proof.setDescProof(descProof[i]);
			        }
			        proofs.add(proof);
				}
			}
			
			//保存成员信息
			if(memberName != null){
				for(int j = 0; j < memberName.length; j++){
					if(!"".equals(memberName[j]) && memberName[j] != null){
						ScienceTechProjectMember scienceTechProjectMember = new ScienceTechProjectMember();
						scienceTechProjectMember.setProject(scienceTechProject);
						scienceTechProjectMember.setMemberName(memberName[j]);
						if(!"".equals(remarksMem[j]) && remarksMem[j] != null){
							scienceTechProjectMember.setRemarks(remarksMem[j]);
						}
						scienceTechProjectMembers.add(scienceTechProjectMember);
					}
				}
			}
			
			boolean result1 = researchInfoService.modifyResearchInfo(scienceDetailTechProject);
			boolean result2 = researchInfoService.modifyResearchInfo(scienceTechProject);
			boolean result3 = researchInfoService.modifyProofs(proofs);
			boolean result4 = researchInfoService.modifyResearchMemberInfo(projectId, "ScienceTechProjectMember", "project", "projectId", 2, scienceTechProjectMembers);
			Confirm confirm = new Confirm();
			if(result1 && result2 && result3 && result4){
				confirm.setIsSuccess("right");
				confirm.setMessage("理科科技项目信息修改成功");
				confirm.setUrl("viewScienceTechProject.action");
				confirm.setRetName("个人理科科技项目信息页面");
			}else{
				confirm.setIsSuccess("error");
				confirm.setMessage("理科科技项目信息修改失败");
				confirm.setUrl("viewScienceTechProject.action");
				confirm.setRetName("个人理科科技项目信息页面");
			}
			ActionContext.getContext().put("confirm", confirm);
			return SUCCESS;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return ERROR;
		}
	}

	public void setResearchInfoService(ResearchInfoService researchInfoService) {
		this.researchInfoService = researchInfoService;
	}

	public void setResearchInfoDao(ResearchInfoDao researchInfoDao) {
		this.researchInfoDao = researchInfoDao;
	}

	public void setProjectId(String projectId) {
		this.projectId = projectId;
	}

	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}

	public void setTimeProjectApproved(String timeProjectApproved) {
		this.timeProjectApproved = timeProjectApproved;
	}

	public void setTotalFundContract(float totalFundContract) {
		this.totalFundContract = totalFundContract;
	}

	public void setSortSubject(String sortSubject) {
		this.sortSubject = sortSubject;
	}

	public void setSortActivity(String sortActivity) {
		this.sortActivity = sortActivity;
	}

	public void setOriginProject(String originProject) {
		this.originProject = originProject;
	}

	public void setFormOrganization(String formOrganization) {
		this.formOrganization = formOrganization;
	}

	public void setFormCooperation(String formCooperation) {
		this.formCooperation = formCooperation;
	}

	public void setOrganReliedProject(String organReliedProject) {
		this.organReliedProject = organReliedProject;
	}

	public void setIndustryService(String industryService) {
		this.industryService = industryService;
	}

	public void setUnitProject(String unitProject) {
		this.unitProject = unitProject;
	}

	public void setDeatilProjectId(String deatilProjectId) {
		this.deatilProjectId = deatilProjectId;
	}

	public void setInputThisYear(float inputThisYear) {
		this.inputThisYear = inputThisYear;
	}

	public void setExpenditureThisYear(float expenditureThisYear) {
		this.expenditureThisYear = expenditureThisYear;
	}

	public void setTotalStaff(int totalStaff) {
		this.totalStaff = totalStaff;
	}

	public void setAdvancedStaff(int advancedStaff) {
		this.advancedStaff = advancedStaff;
	}

	public void setMiddleStaff(int middleStaff) {
		this.middleStaff = middleStaff;
	}

	public void setJuniorStaff(int juniorStaff) {
		this.juniorStaff = juniorStaff;
	}

	public void setOtherStaff(int otherStaff) {
		this.otherStaff = otherStaff;
	}

	public void setGraduateJoin(int graduateJoin) {
		this.graduateJoin = graduateJoin;
	}

	public void setProjectStatus(String projectStatus) {
		this.projectStatus = projectStatus;
	}

	public void setSubmit(String submit) {
		this.submit = submit;
	}

	public void setMemberName(String[] memberName) {
		this.memberName = memberName;
	}

	public void setUpload(File[] upload) {
		this.upload = upload;
	}

	public void setUploadContentType(String[] uploadContentType) {
		this.uploadContentType = uploadContentType;
	}

	public void setUploadFileName(String[] uploadFileName) {
		this.uploadFileName = uploadFileName;
	}

	public void setRemarksMem(String[] remarksMem) {
		this.remarksMem = remarksMem;
	}

	public void setDescProof(String[] descProof) {
		this.descProof = descProof;
	}
	
}
