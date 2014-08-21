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
import com.cqupt.mis.rms.model.TeachAchievementsDeclarant;
import com.cqupt.mis.rms.model.TeachAchievementsCQ;
import com.cqupt.mis.rms.service.ResearchInfoService;
import com.cqupt.mis.rms.utils.Confirm;
import com.cqupt.mis.rms.utils.GenerateUtils;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

/***************2013-8-12   黄海燕添加*************************/

/**
*<p>Title:新添加的处理教师用户提交重庆市大学生创新创业训练计划项目信息的Action</p>
*<p>Description:接收用户提交的信息并处理</p>
*@author HHY
*@version 1.0
**/
@SuppressWarnings("serial")
public class ModifyTeachAchievementsCQAction extends ActionSupport implements ServletContextAware {
	//注入接口
	private ResearchInfoService researchInfoService;
	private ResearchInfoDao researchInfoDao;
	
	
	
	private String achievementsId;
	private String classAchievements;
	private String gradeAchievements;
	private String projectName;
	private String projectType;
	
	private String timeAchievements;
	private String reportedAmounts;
	private String certificationUnit;
	private String remarks;
	
	
	
	
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
		List<TeachAchievementsDeclarant> teachAchievementsDeclarantlists = new ArrayList<TeachAchievementsDeclarant>();
		String targetDirectory = servletContext.getRealPath(GenerateUtils.generateSavePath());//获得路径
		TeachAchievementsCQ teachAchievementsCQ = (TeachAchievementsCQ)researchInfoDao.findResearchInfoByIdAndModelNameAndFactor(achievementsId, "TeachAchievementsCQ", "achievementsId");
		teachAchievementsCQ.setAchievementsId(achievementsId);
		teachAchievementsCQ.setCertificationUnit(certificationUnit);
		teachAchievementsCQ.setClassAchievements(classAchievements);
		teachAchievementsCQ.setGradeAchievements(gradeAchievements);
		teachAchievementsCQ.setProjectName(projectName);
		teachAchievementsCQ.setProjectType(projectType);
		teachAchievementsCQ.setRemarks(remarks);
		if(""!=reportedAmounts)
		{
			teachAchievementsCQ.setReportedAmounts(reportedAmounts);

		}
		teachAchievementsCQ.setStatus(status);
		teachAchievementsCQ.setTimeAchievements(timeAchievements);
		
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
			        proof.setInfoApprovedId(achievementsId);
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
						TeachAchievementsDeclarant teachAchievementsDeclarant = new TeachAchievementsDeclarant();
						teachAchievementsDeclarant.setTeachAchievementsCQ(teachAchievementsCQ);
						teachAchievementsDeclarant.setDeclarantName(memberName[j]);
						if(!"".equals(remarksMem[j]) && remarksMem[j] != null){
							teachAchievementsDeclarant.setRemarks(remarksMem[j]);
						}
						
						teachAchievementsDeclarantlists.add(teachAchievementsDeclarant);
					}
				}
			}
			
			
			
			
			boolean result1 = researchInfoService.modifyResearchInfo(teachAchievementsCQ);
			boolean result2 = researchInfoService.modifyProofs(proofs);
			boolean result3 = researchInfoService.modifyResearchMemberInfo(achievementsId, "TeachAchievementsDeclarant", "teachAchievementsCQ", "achievementsId", 19, teachAchievementsDeclarantlists);
			Confirm confirm = new Confirm();
			if(result1 && result2 && result3){
				confirm.setIsSuccess("right");
				confirm.setMessage("重庆市大学生创新创业训练计划项目信息修改成功");
				confirm.setUrl("viewTeachAchievementsCQ.action");
				confirm.setRetName("个人重庆市大学生创新创业训练计划项目信息页面");
			}else{
				confirm.setIsSuccess("error");
				confirm.setMessage("重庆市大学生创新创业训练计划项目信息修改失败");
				confirm.setUrl("viewTeachAchievementsCQ.action");
				confirm.setRetName("个人重庆市大学生创新创业训练计划项目信息页面");
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

	public void setAchievementsId(String achievementsId) {
		this.achievementsId = achievementsId;
	}

	public void setClassAchievements(String classAchievements) {
		this.classAchievements = classAchievements;
	}

	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}

	public void setTimeAchievements(String timeAchievements) {
		this.timeAchievements = timeAchievements;
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

	public void setGradeAchievements(String gradeAchievements) {
		this.gradeAchievements = gradeAchievements;
	}

	public void setReportedAmounts(String reportedAmounts) {
		this.reportedAmounts = reportedAmounts;
	}


	public void setCertificationUnit(String certificationUnit) {
		this.certificationUnit = certificationUnit;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}



	public void setProjectType(String projectType) {
		this.projectType = projectType;
	}

}
