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
import com.cqupt.mis.rms.model.CourseContributeNew;
import com.cqupt.mis.rms.model.CourseContributeMemberNew;
import com.cqupt.mis.rms.model.Proofs;
import com.cqupt.mis.rms.service.SubmitInfoAndProofsService;
import com.cqupt.mis.rms.utils.Confirm;
import com.cqupt.mis.rms.utils.GenerateUtils;
import com.cqupt.mis.rms.utils.TypeConvert;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

/**
*<p>Title:处理教师用户提交课程建设信息的Action</p>
*<p>Description:接收用户提交的信息并处理</p>
*@author LvHai
*@version 1.0
**/
@SuppressWarnings("serial")
public class SubmitCourseContributeNewAction extends ActionSupport implements ServletContextAware {
	//注入服务层接口
	private SubmitInfoAndProofsService submitInfoAndProofsService;
	
	private String classContribute;
	private String typeContribute;
	private String timeContribute;
	private String courseName;
	private String checkTime;
	private String endTime;
	private Float collegeAward;
	private String remarks;
	private String applicantRanking;
	

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
		List<CourseContributeMemberNew> courseContributeMembers = new ArrayList<CourseContributeMemberNew>();
		String id = GenerateUtils.getID();//生成ID
		String targetDirectory = context.getRealPath(GenerateUtils.generateSavePath());//获得路径
		CourseContributeNew courseContributeNew = new CourseContributeNew();
		courseContributeNew.setSubmitUser(user);
		courseContributeNew.setCheckTime(TypeConvert.stringOrNullToDate(checkTime));
		courseContributeNew.setClassContribute(classContribute);
		courseContributeNew.setCollegeAward(collegeAward);
		courseContributeNew.setCourseId(id);
		courseContributeNew.setCourseName(courseName);
		courseContributeNew.setEndTime(TypeConvert.stringOrNullToDate(endTime));
		courseContributeNew.setRemarks(remarks);
		courseContributeNew.setTimeContribute(timeContribute);
		courseContributeNew.setTypeContribute(typeContribute);
		courseContributeNew.setApplicantRanking(applicantRanking);
		courseContributeNew.setStatus(status);
		
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
			        proof.setInfoApprovedId(id);
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
						CourseContributeMemberNew courseContributeMemberNew = new CourseContributeMemberNew();
						courseContributeMemberNew.setCourseContributeNew(courseContributeNew);
						courseContributeMemberNew.setMemberName(memberName[j]);
						if(!"".equals(remarksMem[j]) && remarksMem[j] != null){
							courseContributeMemberNew.setRemarks(remarksMem[j]);
						}
						
						courseContributeMembers.add(courseContributeMemberNew);
					}
				}
			}
			
			boolean result1 = submitInfoAndProofsService.submitInfo(courseContributeNew);
			boolean result2 = submitInfoAndProofsService.submitResearchMemberInfo(21, courseContributeMembers);
			boolean result3 = submitInfoAndProofsService.submitProofs(proofs);
			Confirm confirm = new Confirm();
			if(result1 && result2 && result3){
				confirm.setIsSuccess("right");
				confirm.setMessage("本科教学工程信息添加成功");
				confirm.setUrl("viewCourseContributeNew.action");
				confirm.setRetName("个人本科教学工程信息页面");
			}else{
				confirm.setIsSuccess("error");
				confirm.setMessage("本科教学工程信息添加失败");
				confirm.setUrl("viewCourseContributeNew.action");
				confirm.setRetName("个人本科教学工程信息页面");
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

	public void setClassContribute(String classContribute) {
		this.classContribute = classContribute;
	}

	public void setTypeContribute(String typeContribute) {
		this.typeContribute = typeContribute;
	}

	public void setTimeContribute(String timeContribute) {
		this.timeContribute = timeContribute;
	}

	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}

	public void setCheckTime(String checkTime) {
		this.checkTime = checkTime;
	}

	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}

	public void setCollegeAward(Float collegeAward) {
		this.collegeAward = collegeAward;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
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
	public String getApplicantRanking() {
		return applicantRanking;
	}

	public void setApplicantRanking(String applicantRanking) {
		this.applicantRanking = applicantRanking;
	}
}
