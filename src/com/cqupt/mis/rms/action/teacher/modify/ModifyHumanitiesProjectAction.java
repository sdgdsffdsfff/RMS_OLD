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
import com.cqupt.mis.rms.model.HumanitiesProject;
import com.cqupt.mis.rms.model.HumanitiesProjectDetail;
import com.cqupt.mis.rms.model.HumanitiesProjectMember;
import com.cqupt.mis.rms.model.Proofs;
import com.cqupt.mis.rms.service.ResearchInfoService;
import com.cqupt.mis.rms.utils.Confirm;
import com.cqupt.mis.rms.utils.GenerateUtils;
import com.cqupt.mis.rms.utils.TypeConvert;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

/**
*<p>Title:处理教师用户修改人文社科科研项目基本信息的Action</p>
*<p>Description:接收用户提交的信息并处理</p>
*@author LvHai
*@version 1.0
**/
@SuppressWarnings("serial")
public class ModifyHumanitiesProjectAction extends ActionSupport implements ServletContextAware {
	///注入接口
	private ResearchInfoService researchInfoService;
	private ResearchInfoDao researchInfoDao;
	//科技项目基本信息
	private String projectId;
	private String projectName;
	private String projectNumber;
	private String projectOrigin;
	private String timeApproved;
	//科技项目详细信息
	private String projectStatus;
	private float money;
	private String timePerPerson;
	
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
		List<HumanitiesProjectMember> humanitiesProjectMembers = new ArrayList<HumanitiesProjectMember>();
		String targetDirectory = servletContext.getRealPath(GenerateUtils.generateSavePath());//获得路径
		//设置科技项目基本信息
		HumanitiesProject humanitiesProject = (HumanitiesProject)researchInfoDao.findResearchInfoByIdAndModelNameAndFactor(projectId, "HumanitiesProject", "projectId");
		humanitiesProject.setProjectId(projectId);
		humanitiesProject.setProjectName(projectName);
		humanitiesProject.setProjectNumber(projectNumber);
		humanitiesProject.setProjectOrigin(projectOrigin);
		humanitiesProject.setTimeApproved(TypeConvert.stringOrNullToDate(timeApproved));
		humanitiesProject.setStatus(status);
		//设置科技项目详细信息
		HumanitiesProjectDetail humanitiesProjectDetail = (HumanitiesProjectDetail)researchInfoDao.findResearchInfoByIdAndModelNameAndFactor(projectId, "HumanitiesProjectDetail", "humanitiesProject.projectId");
		humanitiesProjectDetail.setMoney(money);
		humanitiesProjectDetail.setProjectStatus(projectStatus);
		humanitiesProjectDetail.setTimePerPerson(timePerPerson);
		humanitiesProjectDetail.setUpdateTime(new Date());
		
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
						HumanitiesProjectMember humanitiesProjectMember = new HumanitiesProjectMember();
						humanitiesProjectMember.setHumanitiesProject(humanitiesProject);
						humanitiesProjectMember.setMemberName(memberName[j]);
						if(!"".equals(remarksMem[j]) && remarksMem[j] != null){
							humanitiesProjectMember.setRemarks(remarksMem[j]);
						}
						humanitiesProjectMembers.add(humanitiesProjectMember);
					}
				}
			}
			
			boolean result1 = researchInfoService.modifyResearchInfo(humanitiesProject);
			boolean result2 = researchInfoService.modifyResearchInfo(humanitiesProjectDetail);
			boolean result3 = researchInfoService.modifyProofs(proofs);
			boolean result4 = researchInfoService.modifyResearchMemberInfo(projectId, "HumanitiesProjectMember", "humanitiesProject", "projectId", 9, humanitiesProjectMembers);
			Confirm confirm = new Confirm();
			if(result1 && result2 && result3 && result4){
				confirm.setIsSuccess("right");
				confirm.setMessage("科研项目信息修改成功");
				confirm.setUrl("viewHumanitiesProject.action");
				confirm.setRetName("个人科研项目信息页面");
			}else{
				confirm.setIsSuccess("error");
				confirm.setMessage("科研项目信息修改失败");
				confirm.setUrl("viewHumanitiesProject.action");
				confirm.setRetName("个人科研项目信息页面");
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

	public void setProjectNumber(String projectNumber) {
		this.projectNumber = projectNumber;
	}

	public void setProjectOrigin(String projectOrigin) {
		this.projectOrigin = projectOrigin;
	}

	public void setTimeApproved(String timeApproved) {
		this.timeApproved = timeApproved;
	}

	public void setProjectStatus(String projectStatus) {
		this.projectStatus = projectStatus;
	}

	public void setMoney(float money) {
		this.money = money;
	}

	public void setTimePerPerson(String timePerPerson) {
		this.timePerPerson = timePerPerson;
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
