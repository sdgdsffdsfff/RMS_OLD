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
import com.cqupt.mis.rms.model.ScienceOrganization;
import com.cqupt.mis.rms.service.ResearchInfoService;
import com.cqupt.mis.rms.utils.Confirm;
import com.cqupt.mis.rms.utils.GenerateUtils;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

/**
*<p>Title:处理教师用户活动机构信息表信息的Action</p>
*<p>Description:接收用户提交的信息并处理</p>
*@author LvHai
*@version 1.0
**/
@SuppressWarnings("serial")
public class ModifyScienceOrganizationAction extends ActionSupport implements ServletContextAware {
	//注入接口
	private ResearchInfoService researchInfoService;
	private ResearchInfoDao researchInfoDao;
	
	private String organizationId;
	private String organizationName;
	private String organizationType;
	private String organizationCategory;
	private String sortSubject;
	private String modusComposition;
	private int totalEmployees;
	private int doctorEmployees;
	private int masterEmployees;
	private int totalIts;
	private int advancedIts;
	private int middleIts;
	private int juniorIts;
	private int otherIts;
	private int numGraduates;
	private float internalExpenditures;
	private float rdExpenditures;
	private int numIssueAssume;
	private float assetsFixed;
	private float assetsEquipment;
	private float assetsImport;
	private String industryService;
	
	private String submit;

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
		String targetDirectory = servletContext.getRealPath(GenerateUtils.generateSavePath());//获得路径
		ScienceOrganization scienceOrganization = (ScienceOrganization)researchInfoDao.findResearchInfoByIdAndModelNameAndFactor(organizationId, "ScienceOrganization", "organizationId");
		scienceOrganization.setOrganizationId(organizationId);
		scienceOrganization.setAdvancedIts(advancedIts);
		scienceOrganization.setAssetsEquipment(assetsEquipment);
		scienceOrganization.setAssetsFixed(assetsFixed);
		scienceOrganization.setAssetsImport(assetsImport);
		scienceOrganization.setDoctorEmployees(doctorEmployees);
		scienceOrganization.setIndustryService(industryService);
		scienceOrganization.setInternalExpenditures(internalExpenditures);
		scienceOrganization.setJuniorIts(juniorIts);
		scienceOrganization.setMasterEmployees(masterEmployees);
		scienceOrganization.setMiddleIts(middleIts);
		scienceOrganization.setModusComposition(modusComposition);
		scienceOrganization.setNumGraduates(numGraduates);
		scienceOrganization.setNumIssueAssume(numIssueAssume);
		scienceOrganization.setOrganizationCategory(organizationCategory);
		scienceOrganization.setOrganizationName(organizationName);
		scienceOrganization.setOrganizationType(organizationType);
		scienceOrganization.setOtherIts(otherIts);
		scienceOrganization.setRdExpenditures(rdExpenditures);
		scienceOrganization.setSortSubject(sortSubject);
		scienceOrganization.setTotalEmployees(totalEmployees);
		scienceOrganization.setTotalIts(totalIts);
		scienceOrganization.setStatus(status);
		
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
			        proof.setInfoApprovedId(organizationId);
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
			
			boolean result1 = researchInfoService.modifyResearchInfo(scienceOrganization);
			boolean result2 = researchInfoService.modifyProofs(proofs);
			Confirm confirm = new Confirm();
			if(result1 && result2){
				confirm.setIsSuccess("right");
				confirm.setMessage("科技活动机构信息修改成功");
				confirm.setUrl("viewScienceOrganization.action");
				confirm.setRetName("个人科技活动机构信息页面");
			}else{
				confirm.setIsSuccess("error");
				confirm.setMessage("科技活动机构信息修改失败");
				confirm.setUrl("viewScienceOrganization.action");
				confirm.setRetName("个人科技活动机构信息页面");
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

	public void setOrganizationId(String organizationId) {
		this.organizationId = organizationId;
	}

	public void setOrganizationName(String organizationName) {
		this.organizationName = organizationName;
	}

	public void setOrganizationType(String organizationType) {
		this.organizationType = organizationType;
	}

	public void setOrganizationCategory(String organizationCategory) {
		this.organizationCategory = organizationCategory;
	}

	public void setSortSubject(String sortSubject) {
		this.sortSubject = sortSubject;
	}

	public void setModusComposition(String modusComposition) {
		this.modusComposition = modusComposition;
	}

	public void setTotalEmployees(int totalEmployees) {
		this.totalEmployees = totalEmployees;
	}

	public void setDoctorEmployees(int doctorEmployees) {
		this.doctorEmployees = doctorEmployees;
	}

	public void setMasterEmployees(int masterEmployees) {
		this.masterEmployees = masterEmployees;
	}

	public void setTotalIts(int totalIts) {
		this.totalIts = totalIts;
	}

	public void setAdvancedIts(int advancedIts) {
		this.advancedIts = advancedIts;
	}

	public void setMiddleIts(int middleIts) {
		this.middleIts = middleIts;
	}

	public void setJuniorIts(int juniorIts) {
		this.juniorIts = juniorIts;
	}

	public void setOtherIts(int otherIts) {
		this.otherIts = otherIts;
	}

	public void setNumGraduates(int numGraduates) {
		this.numGraduates = numGraduates;
	}

	public void setInternalExpenditures(float internalExpenditures) {
		this.internalExpenditures = internalExpenditures;
	}

	public void setRdExpenditures(float rdExpenditures) {
		this.rdExpenditures = rdExpenditures;
	}

	public void setNumIssueAssume(int numIssueAssume) {
		this.numIssueAssume = numIssueAssume;
	}

	public void setAssetsFixed(float assetsFixed) {
		this.assetsFixed = assetsFixed;
	}

	public void setAssetsEquipment(float assetsEquipment) {
		this.assetsEquipment = assetsEquipment;
	}

	public void setAssetsImport(float assetsImport) {
		this.assetsImport = assetsImport;
	}

	public void setIndustryService(String industryService) {
		this.industryService = industryService;
	}

	public void setSubmit(String submit) {
		this.submit = submit;
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

	public void setDescProof(String[] descProof) {
		this.descProof = descProof;
	}
	
}
