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
import com.cqupt.mis.rms.model.TeachAchievementsNew;
import com.cqupt.mis.rms.model.TeachersAwardsNew;
import com.cqupt.mis.rms.service.SubmitInfoAndProofsService;
import com.cqupt.mis.rms.utils.Confirm;
import com.cqupt.mis.rms.utils.GenerateUtils;
import com.cqupt.mis.rms.utils.TypeConvert;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

/**
*<p>Title:处理教师用户提交发表教改论文信息的Action</p>
*<p>Description:接收用户提交的信息并处理</p>
*@author LvHai
*@version 1.0
**/
@SuppressWarnings("serial")
public class SubmitTeachAchievementsNewAction extends ActionSupport implements ServletContextAware {
	//注入服务层接口
	private SubmitInfoAndProofsService submitInfoAndProofsService;
	
	private String classAchievements;
	private String projectName;
	private String levelAchievements;
	private String timeAchievements;
	private String collegeAward;
	private String remarks;//备注
	private String wordsNumber;//字数(千字)
	private String firstChargeMan;//是否为第一负责人
	private String authorRank;//作者排名
    private String publisher;//出版单位
	

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
		List<TeachersAwardsNew> teachersAwards = new ArrayList<TeachersAwardsNew>();
		String id = GenerateUtils.getID();//生成ID
		String targetDirectory = context.getRealPath(GenerateUtils.generateSavePath());//获得路径
		TeachAchievementsNew teachAchievements = new TeachAchievementsNew();
		teachAchievements.setAchievementsId(id);
		teachAchievements.setClassAchievements(classAchievements);
		if(""!=collegeAward)
		{
			teachAchievements.setCollegeAward(Float.parseFloat(collegeAward));
		}
		else
		{
			teachAchievements.setCollegeAward(0f);
		}
		if(""!=wordsNumber)
		{
			teachAchievements.setWordsNumber(Float.parseFloat(wordsNumber));
		}
		else
		{
			teachAchievements.setWordsNumber(0f);
		}
		
		teachAchievements.setLevelAchievements(levelAchievements);
		teachAchievements.setProjectName(projectName);
		teachAchievements.setAuthorRank(authorRank);
		teachAchievements.setFirstChargeMan(firstChargeMan);
		teachAchievements.setPublisher(publisher);
		teachAchievements.setRemarks(remarks);
		teachAchievements.setTimeAchievements(TypeConvert.stringOrNullToDate(timeAchievements));
		teachAchievements.setSubmitUser(user);
		teachAchievements.setStatus(status);
		
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
						TeachersAwardsNew teachersAward = new TeachersAwardsNew();
						teachersAward.setTeachAchievementsNew(teachAchievements);
						teachersAward.setMemberName(memberName[j]);
						if(!"".equals(remarksMem[j]) && remarksMem[j] != null){
							teachersAward.setRemarks(remarksMem[j]);
						}
						teachersAwards.add(teachersAward);
					}
				}
			}
			
			boolean result1 = submitInfoAndProofsService.submitInfo(teachAchievements);
			boolean result2 = submitInfoAndProofsService.submitResearchMemberInfo(22, teachersAwards);
			boolean result3 = submitInfoAndProofsService.submitProofs(proofs);
			Confirm confirm = new Confirm();
			if(result1 && result2 && result3){
				confirm.setIsSuccess("right");
				confirm.setMessage("发表教改论文信息添加成功");
				confirm.setUrl("viewTeachAchievements.action");
				confirm.setRetName("个人发表教改论文信息页面");
			}else{
				confirm.setIsSuccess("error");
				confirm.setMessage("发表教改论文信息添加失败");
				confirm.setUrl("viewTeachAchievements.action");
				confirm.setRetName("个人发表教改论文信息页面");
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

	public void setClassAchievements(String classAchievements) {
		this.classAchievements = classAchievements;
	}

	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}

	public void setLevelAchievements(String levelAchievements) {
		this.levelAchievements = levelAchievements;
	}

	public void setTimeAchievements(String timeAchievements) {
		this.timeAchievements = timeAchievements;
	}

	public void setCollegeAward(String collegeAward) {
		this.collegeAward = collegeAward;
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
	public String getFirstChargeMan() {
		return firstChargeMan;
	}

	public void setFirstChargeMan(String firstChargeMan) {
		this.firstChargeMan = firstChargeMan;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

	public void setWordsNumber(String wordsNumber) {
		this.wordsNumber = wordsNumber;
	}

	public void setAuthorRank(String authorRank) {
		this.authorRank = authorRank;
	}

	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}

}
