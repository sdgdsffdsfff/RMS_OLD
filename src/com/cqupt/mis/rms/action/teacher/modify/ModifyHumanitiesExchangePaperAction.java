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
import com.cqupt.mis.rms.model.HumanitiesExchangePaper;
import com.cqupt.mis.rms.model.HumanitiesExchangePaperAuthor;
import com.cqupt.mis.rms.model.Proofs;
import com.cqupt.mis.rms.service.ResearchInfoService;
import com.cqupt.mis.rms.utils.Confirm;
import com.cqupt.mis.rms.utils.GenerateUtils;
import com.cqupt.mis.rms.utils.TypeConvert;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

/**
*<p>Title:处理教师用户修改人文社科论文交流信息的Action</p>
*<p>Description:接收用户提交的信息并处理</p>
*@author LvHai
*@version 1.0
**/
@SuppressWarnings("serial")
public class ModifyHumanitiesExchangePaperAction extends ActionSupport implements ServletContextAware {
	//注入接口
	private ResearchInfoService researchInfoService;
	private ResearchInfoDao researchInfoDao;
	
	private String exchangePaperId;
	private String exchangePaperName;
	private String searchStation;
	private String subjectsClassify;
	private String publishedTime;
	private String hostConferenceName;
	
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
		List<HumanitiesExchangePaperAuthor> humanitiesExchangePaperAuthors = new ArrayList<HumanitiesExchangePaperAuthor>();
		String targetDirectory = servletContext.getRealPath(GenerateUtils.generateSavePath());//获得路径
		HumanitiesExchangePaper humanitiesExchangePaper = (HumanitiesExchangePaper)researchInfoDao.findResearchInfoByIdAndModelNameAndFactor(exchangePaperId, "HumanitiesExchangePaper", "exchangePaperId");
		humanitiesExchangePaper.setExchangePaperId(exchangePaperId);
		humanitiesExchangePaper.setExchangePaperName(exchangePaperName);
		humanitiesExchangePaper.setHostConferenceName(hostConferenceName);
		humanitiesExchangePaper.setPublishedTime(TypeConvert.stringOrNullToDate(publishedTime));
		humanitiesExchangePaper.setSearchStation(searchStation);
		humanitiesExchangePaper.setSubjectsClassify(subjectsClassify);
		humanitiesExchangePaper.setStatus(status);
		
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
			        proof.setInfoApprovedId(exchangePaperId);
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
						HumanitiesExchangePaperAuthor humanitiesExchangePaperAuthor = new HumanitiesExchangePaperAuthor();
						humanitiesExchangePaperAuthor.setHumanitiesExchangePaper(humanitiesExchangePaper);;
						humanitiesExchangePaperAuthor.setAuthorName(memberName[j]);
						if(!"".equals(remarksMem[j]) && remarksMem[j] != null){
							humanitiesExchangePaperAuthor.setRemarks(remarksMem[j]);
						}
						humanitiesExchangePaperAuthors.add(humanitiesExchangePaperAuthor);
					}
				}
			}
			
			boolean result1 = researchInfoService.modifyResearchInfo(humanitiesExchangePaper);
			boolean result2 = researchInfoService.modifyProofs(proofs);
			boolean result3 = researchInfoService.modifyResearchMemberInfo(exchangePaperId, "HumanitiesExchangePaperAuthor", "humanitiesExchangePaper", "exchangePaperId", 10, humanitiesExchangePaperAuthors);
			Confirm confirm = new Confirm();
			if(result1 && result2 && result3){
				confirm.setIsSuccess("right");
				confirm.setMessage("人文社科会议交流论文信息修改成功");
				confirm.setUrl("viewHumanitiesExchangePaper.action");
				confirm.setRetName("个人人文社科会议交流论文信息页面");
			}else{
				confirm.setIsSuccess("error");
				confirm.setMessage("人文社科会议交流论文信息修改失败");
				confirm.setUrl("viewHumanitiesExchangePaper.action");
				confirm.setRetName("个人人文社科会议交流论文信息页面");
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

	public void setExchangePaperId(String exchangePaperId) {
		this.exchangePaperId = exchangePaperId;
	}

	public void setExchangePaperName(String exchangePaperName) {
		this.exchangePaperName = exchangePaperName;
	}

	public void setSearchStation(String searchStation) {
		this.searchStation = searchStation;
	}

	public void setSubjectsClassify(String subjectsClassify) {
		this.subjectsClassify = subjectsClassify;
	}

	public void setPublishedTime(String publishedTime) {
		this.publishedTime = publishedTime;
	}

	public void setHostConferenceName(String hostConferenceName) {
		this.hostConferenceName = hostConferenceName;
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
