/**
*Copyright(c)2012 重邮信管工作室
*All right reserved.
*/
package com.cqupt.mis.rms.action.teacher;

import java.io.File;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletContext;

import org.apache.commons.io.FileUtils;
import org.apache.struts2.util.ServletContextAware;

import com.cqupt.mis.rms.model.CQUPTUser;
import com.cqupt.mis.rms.model.Proofs;
import com.cqupt.mis.rms.model.ScienceDetailTechProject;
import com.cqupt.mis.rms.model.ScienceTechProject;
import com.cqupt.mis.rms.model.ScienceTechProjectMember;
import com.cqupt.mis.rms.service.SubmitInfoAndProofsService;
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
public class SubmitScienceTechProjectAction extends ActionSupport implements ServletContextAware {
	//注入服务层接口
	private SubmitInfoAndProofsService submitInfoAndProofsService;
	
	//科技项目基本信息
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
	private ServletContext context;
	@Override
	public void setServletContext(ServletContext context) {
		this.context = context;
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
		
		//取得存放在session中的userId
		String userId = (String)ActionContext.getContext().getSession().get("userId");
		CQUPTUser user = new CQUPTUser();
		user.setUserId(userId);
		List<Proofs> proofs = new ArrayList<Proofs>();
		List<ScienceTechProjectMember> scienceTechProjectMembers = new ArrayList<ScienceTechProjectMember>();
		String id1 = GenerateUtils.getID();//生成基本信息ID
		String id2 = GenerateUtils.getID();//生成详细信息ID
		String targetDirectory = context.getRealPath(GenerateUtils.generateSavePath());//获得路径
		//设置科技项目基本信息
		ScienceTechProject scienceTechProject = new ScienceTechProject();
		scienceTechProject.setFormCooperation(formCooperation);
		scienceTechProject.setFormOrganization(formOrganization);
		scienceTechProject.setIndustryService(industryService);
		scienceTechProject.setOrganReliedProject(organReliedProject);
		scienceTechProject.setOriginProject(originProject);
		scienceTechProject.setProjectId(id1);
		scienceTechProject.setProjectName(projectName);
		scienceTechProject.setSortActivity(sortActivity);
		scienceTechProject.setSortSubject(sortSubject);
		scienceTechProject.setTimeProjectApproved(TypeConvert.stringOrNullToDate(timeProjectApproved));
		scienceTechProject.setTotalFundContract(totalFundContract);
		scienceTechProject.setUnitProject(unitProject);
		scienceTechProject.setSubmitUser(user);
		scienceTechProject.setStatus(status);
		//设置科技项目详细信息
		ScienceDetailTechProject scienceDetailTechProject = new ScienceDetailTechProject();
		scienceDetailTechProject.setAdvancedStaff(advancedStaff);
		scienceDetailTechProject.setDeatilProjectId(id2);
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
			        proof.setInfoApprovedId(id1);
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
			
			boolean result1 = submitInfoAndProofsService.submitInfo(scienceTechProject);
			boolean result2 = submitInfoAndProofsService.submitInfo(scienceDetailTechProject);
			boolean result3 = submitInfoAndProofsService.submitResearchMemberInfo(2, scienceTechProjectMembers);
			boolean result4 = submitInfoAndProofsService.submitProofs(proofs);
			Confirm confirm = new Confirm();
			if(result1 && result2 && result3 && result4){
				confirm.setIsSuccess("right");
				confirm.setMessage("理科科技项目信息添加成功");
				confirm.setUrl("viewScienceTechProject.action");
				confirm.setRetName("个人理科科技项目信息页面");
			}else{
				confirm.setIsSuccess("error");
				confirm.setMessage("理科科技项目信息添加失败");
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
	
	public void setSubmitInfoAndProofsService(
			SubmitInfoAndProofsService submitInfoAndProofsService) {
		this.submitInfoAndProofsService = submitInfoAndProofsService;
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

	public void setContext(ServletContext context) {
		this.context = context;
	}

	public void setProjectName(String projectName) {
		this.projectName = projectName;
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

	public void setTimeProjectApproved(String timeProjectApproved) {
		this.timeProjectApproved = timeProjectApproved;
	}

	public void setSubmit(String submit) {
		this.submit = submit;
	}

	public void setRemarksMem(String[] remarksMem) {
		this.remarksMem = remarksMem;
	}

	public void setDescProof(String[] descProof) {
		this.descProof = descProof;
	}

}
