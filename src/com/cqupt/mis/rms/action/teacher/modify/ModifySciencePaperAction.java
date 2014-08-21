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
import com.cqupt.mis.rms.model.SciencePaper;
import com.cqupt.mis.rms.model.SciencePaperAuthor;
import com.cqupt.mis.rms.service.ResearchInfoService;
import com.cqupt.mis.rms.utils.Confirm;
import com.cqupt.mis.rms.utils.GenerateUtils;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

/**
*<p>Title:处理用户修改个人科研信息的Action</p>
*<p>Description:接收用户提交的动作并处理</p>
*@author LvHai
*@version 1.0
**/
@SuppressWarnings("serial")
public class ModifySciencePaperAction extends ActionSupport implements ServletContextAware {
	//注入接口
	private ResearchInfoService researchInfoService;
	private ResearchInfoDao researchInfoDao;
	
	private String paperId;
	private String department;
	private String paperName;
	private String subjectsIn;
	private String postPublication;
	private String includeSituation;
	private String publishedTime;
	private String titleNumber;
	private String awardingGrades;
	private float totalPrize;
	private float deductionsDistPosts;
	private float actualAward;
	private String papersUnits;
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
		//如果submit=保存，status=0，如果submit=提交，status=1
		int status;
		if("保存".equals(submit)){
			status = 0;
		}else if("提交".equals(submit)){
			status = 1;
		}else{
			status = -1;
		}
		List<Proofs> proofs = new ArrayList<Proofs>();
		List<SciencePaperAuthor> sciencePaperAuthors = new ArrayList<SciencePaperAuthor>();
		String targetDirectory = servletContext.getRealPath(GenerateUtils.generateSavePath());//获得路径
		
		SciencePaper sciencePaper = (SciencePaper)researchInfoDao.findResearchInfoByIdAndModelNameAndFactor(paperId, "SciencePaper", "paperId");
		sciencePaper.setDepartment(department);
		sciencePaper.setActualAward(actualAward);
		sciencePaper.setAwardingGrades(awardingGrades);
		sciencePaper.setDeductionsDistPosts(deductionsDistPosts);
		sciencePaper.setIncludeSituation(includeSituation);
		sciencePaper.setPaperName(paperName);
		sciencePaper.setPapersUnits(papersUnits);
		sciencePaper.setPostPublication(postPublication);
		sciencePaper.setPublishedTime(publishedTime);
		sciencePaper.setSubjectsIn(subjectsIn);
		sciencePaper.setTitleNumber(titleNumber);
		sciencePaper.setTotalPrize(totalPrize);
		sciencePaper.setStatus(status);
		
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
			        proof.setInfoApprovedId(paperId);
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
						SciencePaperAuthor sciencePaperAuthor = new SciencePaperAuthor();
						sciencePaperAuthor.setSciencePaper(sciencePaper);
						sciencePaperAuthor.setMemberName(memberName[j]);
						if(!"".equals(remarksMem[j]) && remarksMem[j] != null){
							sciencePaperAuthor.setRemarks(remarksMem[j]);
						}
						sciencePaperAuthors.add(sciencePaperAuthor);
					}
				}
			}
			
			boolean result1 = researchInfoService.modifyResearchInfo(sciencePaper);
			boolean result2 = researchInfoService.modifyResearchMemberInfo(paperId, "SciencePaperAuthor", "sciencePaper", "paperId", 1, sciencePaperAuthors);
			boolean result3 = researchInfoService.modifyProofs(proofs);
			Confirm confirm = new Confirm();
			if(result1 && result2 && result3){
				confirm.setIsSuccess("right");
				confirm.setMessage("理科论文信息修改成功");
				confirm.setUrl("viewSciencePaper.action");
				confirm.setRetName("个人理科论文信息页面");
			}else{
				confirm.setIsSuccess("error");
				confirm.setMessage("理科论文信息修改失败");
				confirm.setUrl("viewSciencePaper.action");
				confirm.setRetName("个人理科论文信息页面");
			}
			ActionContext.getContext().put("confirm", confirm);
			return SUCCESS;
		} catch (Exception e) {
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

	public void setPaperId(String paperId) {
		this.paperId = paperId;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public void setPaperName(String paperName) {
		this.paperName = paperName;
	}

	public void setSubjectsIn(String subjectsIn) {
		this.subjectsIn = subjectsIn;
	}

	public void setPostPublication(String postPublication) {
		this.postPublication = postPublication;
	}

	public void setIncludeSituation(String includeSituation) {
		this.includeSituation = includeSituation;
	}

	public void setPublishedTime(String publishedTime) {
		this.publishedTime = publishedTime;
	}

	public void setTitleNumber(String titleNumber) {
		this.titleNumber = titleNumber;
	}

	public void setAwardingGrades(String awardingGrades) {
		this.awardingGrades = awardingGrades;
	}

	public void setTotalPrize(float totalPrize) {
		this.totalPrize = totalPrize;
	}

	public void setDeductionsDistPosts(float deductionsDistPosts) {
		this.deductionsDistPosts = deductionsDistPosts;
	}

	public void setActualAward(float actualAward) {
		this.actualAward = actualAward;
	}

	public void setPapersUnits(String papersUnits) {
		this.papersUnits = papersUnits;
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
