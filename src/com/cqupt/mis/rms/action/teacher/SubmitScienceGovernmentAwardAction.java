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
import com.cqupt.mis.rms.model.ScienceGovAwardPerson;
import com.cqupt.mis.rms.model.ScienceGovernmentAward;
import com.cqupt.mis.rms.service.SubmitInfoAndProofsService;
import com.cqupt.mis.rms.utils.Confirm;
import com.cqupt.mis.rms.utils.GenerateUtils;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

/**
*<p>Title:处理教师用户提交政府科技奖励信息的Action</p>
*<p>Description:接收用户提交的信息并处理</p>
*@author LvHai
*@version 1.0
**/
@SuppressWarnings("serial")
public class SubmitScienceGovernmentAwardAction extends ActionSupport implements ServletContextAware {
	//注入服务层接口
	private SubmitInfoAndProofsService submitInfoAndProofsService;
	
	private String collegesIn;
	private String projectName;
	private String awardingGrades;
	private String completeUnit;
	private float unitAward;
	private float personAward;
	private float totalAward;
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
		List<ScienceGovAwardPerson> scienceGovAwardPersons = new ArrayList<ScienceGovAwardPerson>();
		String id = GenerateUtils.getID();//生成ID
		String targetDirectory = context.getRealPath(GenerateUtils.generateSavePath());//获得路径
		ScienceGovernmentAward scienceGovernmentAward = new ScienceGovernmentAward();
		scienceGovernmentAward.setAwardId(id);
		scienceGovernmentAward.setAwardingGrades(awardingGrades);
		scienceGovernmentAward.setCollegesIn(collegesIn);
		scienceGovernmentAward.setCompleteUnit(completeUnit);
		scienceGovernmentAward.setPersonAward(personAward);
		scienceGovernmentAward.setProjectName(projectName);
		scienceGovernmentAward.setRemarks(remarks);
		scienceGovernmentAward.setTotalAward(totalAward);
		scienceGovernmentAward.setUnitAward(unitAward);
		scienceGovernmentAward.setSubmitUser(user);
		scienceGovernmentAward.setStatus(status);
		
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
						ScienceGovAwardPerson scienceGovAwardPerson = new ScienceGovAwardPerson();
						scienceGovAwardPerson.setScienceGovernmentAward(scienceGovernmentAward);
						scienceGovAwardPerson.setMemberName(memberName[j]);
						if(!"".equals(remarksMem[j]) && remarksMem[j] != null){
							scienceGovAwardPerson.setRemarks(remarks);
						}
						scienceGovAwardPersons.add(scienceGovAwardPerson);
					}
				}
			}
			
			boolean result1 = submitInfoAndProofsService.submitInfo(scienceGovernmentAward);
			boolean result2 = submitInfoAndProofsService.submitResearchMemberInfo(4, scienceGovAwardPersons);
			boolean result3 = submitInfoAndProofsService.submitProofs(proofs);
			Confirm confirm = new Confirm();
			if(result1 && result2 && result3){
				confirm.setIsSuccess("right");
				confirm.setMessage("政府科技奖励信息添加成功");
				confirm.setUrl("viewScienceGovernmentAward.action");
				confirm.setRetName("个人政府科技奖励信息页面");
			}else{
				confirm.setIsSuccess("error");
				confirm.setMessage("政府科技奖励信息添加失败");
				confirm.setUrl("viewScienceGovernmentAward.action");
				confirm.setRetName("个人政府科技奖励信息页面");
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

	public void setCollegesIn(String collegesIn) {
		this.collegesIn = collegesIn;
	}

	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}

	public void setAwardingGrades(String awardingGrades) {
		this.awardingGrades = awardingGrades;
	}

	public void setCompleteUnit(String completeUnit) {
		this.completeUnit = completeUnit;
	}

	public void setUnitAward(float unitAward) {
		this.unitAward = unitAward;
	}

	public void setPersonAward(float personAward) {
		this.personAward = personAward;
	}

	public void setTotalAward(float totalAward) {
		this.totalAward = totalAward;
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
	


}
