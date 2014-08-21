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
import com.cqupt.mis.rms.model.HumanitiesBook;
import com.cqupt.mis.rms.model.HumanitiesBookAuthor;
import com.cqupt.mis.rms.model.Proofs;
import com.cqupt.mis.rms.service.ResearchInfoService;
import com.cqupt.mis.rms.utils.Confirm;
import com.cqupt.mis.rms.utils.GenerateUtils;
import com.cqupt.mis.rms.utils.TypeConvert;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

/**
*<p>Title:处理教师用户修改人文社科著作信息的Action</p>
*<p>Description:接收用户提交的信息并处理</p>
*@author LvHai
*@version 1.0
**/
@SuppressWarnings("serial")
public class ModifyHumanitiesBookAction extends ActionSupport implements ServletContextAware {
	//注入接口
	private ResearchInfoService researchInfoService;
	private ResearchInfoDao researchInfoDao;
	
	private String bookId;
	private String bookName;
	private String grades;
	private String publisher;
	private String publishedTime;
	private String iSBN;
	private float wordcount;
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
		List<HumanitiesBookAuthor> humanitiesBookAuthors = new ArrayList<HumanitiesBookAuthor>();
		String targetDirectory = servletContext.getRealPath(GenerateUtils.generateSavePath());//获得路径
		
		HumanitiesBook humanitiesBook = (HumanitiesBook)researchInfoDao.findResearchInfoByIdAndModelNameAndFactor(bookId, "HumanitiesBook", "bookId");
		humanitiesBook.setAchievementQuote(achievementQuote);
		humanitiesBook.setBelongProject(belongProject);
		humanitiesBook.setBookId(bookId);
		humanitiesBook.setBookName(bookName);
		humanitiesBook.setGrades(grades);
		humanitiesBook.setISBN(iSBN);
		humanitiesBook.setPublishedTime(TypeConvert.stringOrNullToDate(publishedTime));
		humanitiesBook.setPublisher(publisher);
		humanitiesBook.setSubjectsClassify(subjectsClassify);
		humanitiesBook.setWordcount(wordcount);
		humanitiesBook.setStatus(status);
		
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
			        proof.setInfoApprovedId(bookId);
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
						HumanitiesBookAuthor humanitiesBookAuthor = new HumanitiesBookAuthor();
						humanitiesBookAuthor.setHumanitiesBook(humanitiesBook);
						humanitiesBookAuthor.setAuthorName(memberName[j]);
						if(!"".equals(remarksMem[j]) && remarksMem[j] != null){
							humanitiesBookAuthor.setRemarks(remarksMem[j]);
						}
						humanitiesBookAuthors.add(humanitiesBookAuthor);
					}
				}
			}
			
			boolean result1 = researchInfoService.modifyResearchInfo(humanitiesBook);
			boolean result2 = researchInfoService.modifyProofs(proofs);
			boolean result3 = researchInfoService.modifyResearchMemberInfo(bookId, "HumanitiesBookAuthor", "humanitiesBook", "bookId", 8, humanitiesBookAuthors);
			Confirm confirm = new Confirm();
			if(result1 && result2 && result3){
				confirm.setIsSuccess("right");
				confirm.setMessage("人文社科著作修改成功");
				confirm.setUrl("viewHumanitiesBook.action");
				confirm.setRetName("个人人文社科著作页面");
			}else{
				confirm.setIsSuccess("error");
				confirm.setMessage("人文社科著作修改失败");
				confirm.setUrl("viewHumanitiesBook.action");
				confirm.setRetName("个人人文社科著作页面");
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

	public void setBookId(String bookId) {
		this.bookId = bookId;
	}

	public void setBookName(String bookName) {
		this.bookName = bookName;
	}

	public void setGrades(String grades) {
		this.grades = grades;
	}

	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}

	public void setPublishedTime(String publishedTime) {
		this.publishedTime = publishedTime;
	}

	public void setiSBN(String iSBN) {
		this.iSBN = iSBN;
	}

	public void setWordcount(float wordcount) {
		this.wordcount = wordcount;
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
