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
import com.cqupt.mis.rms.model.HumanitiesPaper;
import com.cqupt.mis.rms.model.HumanitiesPaperAuthor;
import com.cqupt.mis.rms.model.Proofs;
import com.cqupt.mis.rms.service.SubmitInfoAndProofsService;
import com.cqupt.mis.rms.utils.Confirm;
import com.cqupt.mis.rms.utils.GenerateUtils;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

/**
*<p>Title:处理教师用户提交人文社科论文信息的Action</p>
*<p>Description:接收用户提交的信息并处理</p>
*@author LvHai
*@version 1.0
**/
@SuppressWarnings("serial")
public class SubmitHumanitiesPaperAction extends ActionSupport implements ServletContextAware {
	//注入服务层接口
	private SubmitInfoAndProofsService submitInfoAndProofsService;
	
	private String paperName;
	private String publishedTime;
	private String postPublication;
	private String publishedGrades;
	private String searchStation;
	private String belongProject;
	private String subjectsClassify;
	private String achievementQuote;
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
		System.out.println("submit:"+submit);
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
		List<HumanitiesPaperAuthor> humanitiesPaperAuthors = new ArrayList<HumanitiesPaperAuthor>();
		String id = GenerateUtils.getID();//生成ID
		String targetDirectory = context.getRealPath(GenerateUtils.generateSavePath());//获得路径
		HumanitiesPaper humanitiesPaper =new HumanitiesPaper();
		humanitiesPaper.setAchievementQuote(achievementQuote);
		humanitiesPaper.setBelongProject(belongProject);
		humanitiesPaper.setPaperId(id);
		humanitiesPaper.setPaperName(paperName);
		humanitiesPaper.setPostPublication(postPublication);
		humanitiesPaper.setPublishedGrades(publishedGrades);
		humanitiesPaper.setPublishedTime(publishedTime);
		humanitiesPaper.setSearchStation(searchStation);
		humanitiesPaper.setSubjectsClassify(subjectsClassify);
		humanitiesPaper.setSubmitUser(user);
		humanitiesPaper.setStatus(status);
		
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
						HumanitiesPaperAuthor humanitiesPaperAuthor = new HumanitiesPaperAuthor();
						humanitiesPaperAuthor.setHumanitiesPaper(humanitiesPaper);
						humanitiesPaperAuthor.setAuthorName(memberName[j]);
						if(!"".equals(remarksMem[j]) && remarksMem[j] != null){
							humanitiesPaperAuthor.setRemarks(remarksMem[j]);
						}
						humanitiesPaperAuthors.add(humanitiesPaperAuthor);
					}
				}
			}
			
			boolean result1 = submitInfoAndProofsService.submitInfo(humanitiesPaper);
			boolean result3 = submitInfoAndProofsService.submitProofs(proofs);
			boolean result2 = submitInfoAndProofsService.submitResearchMemberInfo(7, humanitiesPaperAuthors);
			Confirm confirm = new Confirm();
			if(result1 && result2 && result3){
				confirm.setIsSuccess("right");
				confirm.setMessage("人文社科论文信息添加成功");
				confirm.setUrl("viewHumanitiesPaper.action");
				confirm.setRetName("个人人文社科论文信息页面");
			}else{
				confirm.setIsSuccess("error");
				confirm.setMessage("人文社科论文信息添加失败");
				confirm.setUrl("viewHumanitiesPaper.action");
				confirm.setRetName("个人人文社科论文信息页面");
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

	public void setPaperName(String paperName) {
		this.paperName = paperName;
	}

	public void setPublishedTime(String publishedTime) {
		this.publishedTime = publishedTime;
	}

	public void setPostPublication(String postPublication) {
		this.postPublication = postPublication;
	}

	public void setPublishedGrades(String publishedGrades) {
		this.publishedGrades = publishedGrades;
	}

	public void setSearchStation(String searchStation) {
		this.searchStation = searchStation;
	}

	public void setBelongProject(String belongProject) {
		this.belongProject = belongProject;
	}

	public void setSubjectsClassify(String subjectsClassify) {
		this.subjectsClassify = subjectsClassify;
	}

	public void setAchievementQuote(String achievementQuote) {
		this.achievementQuote = achievementQuote;
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
