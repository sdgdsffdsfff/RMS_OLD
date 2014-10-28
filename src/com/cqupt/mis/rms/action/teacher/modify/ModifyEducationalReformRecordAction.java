package com.cqupt.mis.rms.action.teacher.modify;

import java.io.File;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.io.FileUtils;
import org.apache.struts2.ServletActionContext;
import org.apache.struts2.util.ServletContextAware;

import com.cqupt.mis.rms.manager.DynamicDataRecordDao;
import com.cqupt.mis.rms.manager.SearchDao;
import com.cqupt.mis.rms.model.CQUPTUser;
import com.cqupt.mis.rms.model.EducationalRecordAward;
import com.cqupt.mis.rms.model.EducationalReformData;
import com.cqupt.mis.rms.model.EducationalReformField;
import com.cqupt.mis.rms.model.EducationalReformRecord;
import com.cqupt.mis.rms.model.LearningEvaluationData;
import com.cqupt.mis.rms.model.LearningEvaluationField;
import com.cqupt.mis.rms.model.LearningEvaluationRecord;
import com.cqupt.mis.rms.model.LearningRecordAward;
import com.cqupt.mis.rms.model.Proofs;
import com.cqupt.mis.rms.service.ResearchInfoService;
import com.cqupt.mis.rms.utils.Confirm;
import com.cqupt.mis.rms.utils.GenerateUtils;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class ModifyEducationalReformRecordAction extends ActionSupport implements ServletContextAware {
	private ResearchInfoService researchInfoService;
	private DynamicDataRecordDao dynamicDataRecordDao;
	private SearchDao searchDao;
	
	private String submit;
	private String recordId;
	private String recordName;
	
	//成员名字
	private String[] memberName;
	private String[] remarksMem;

	//上传文件
	private File[] upload;// 实际上传文件
	private String[] uploadContentType; // 文件的内容类型
	private String[] uploadFileName; // 上传文件名
	private String[] descProof;//旁证材料描述
	private ServletContext context;
	
	public String execute() throws Exception {
		HttpServletRequest request = ServletActionContext.getRequest();
		
		//如果submit==保存，status=0，如果submit==提交，status=1
		int status;
		System.out.println("submit:"+submit);
		if("保存".equals(submit)) {
			status = 0;
		} else if("提交".equals(submit)) {
			status = 1;
		} else {
			status = -1;
		}
				
		//取得存放在session中的userId
		String userId = (String)ActionContext.getContext().getSession().get("userId");
		CQUPTUser user = new CQUPTUser();
		user.setUserId(userId);
		
		/*
		 * 构建一条记录对象
		 */
		EducationalReformRecord educationalReformRecord = new EducationalReformRecord();
		educationalReformRecord.setId(recordId);
		educationalReformRecord.setSubmitUser(user);
		educationalReformRecord.setName(recordName);
		educationalReformRecord.setStatus(status);
		List<EducationalReformField> fieldsFromDataBase = searchDao.SearchObjectsByFactor("com.cqupt.mis.rms.model.EducationalReformField", "isDelete", 0);
		Set<EducationalReformData> fields = new HashSet<EducationalReformData>();
		//将前台已填写的字段封装成StudentAwardsData对象
		for(EducationalReformField f : fieldsFromDataBase) {
			String value = (String) request.getParameter(f.getName());
			if(value==null || "".equals(value)) {
				continue;
			} else {
				EducationalReformData tempData = new EducationalReformData();
				tempData.setRecord(educationalReformRecord);
				tempData.setField(f);
				tempData.setValue(value);
				fields.add(tempData);
			}
		}
		educationalReformRecord.setFields(fields);
		
		/*
		 * 构建上传材料，指导教师的对象
		 */
		String targetDirectory = context.getRealPath(GenerateUtils.generateSavePath());//获得路径
		List<Proofs> proofs = new ArrayList<Proofs>();
		List<EducationalRecordAward> educationalRecordAwards = new ArrayList<EducationalRecordAward>();
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
			        proof.setInfoApprovedId(recordId);
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
				for(int j = 0; j < memberName.length; j++) {
					if(!"".equals(memberName[j]) && memberName[j] != null) {
						EducationalRecordAward educationalRecordAward = new EducationalRecordAward();
						educationalRecordAward.setEducationalReformRecord(educationalReformRecord);
						educationalRecordAward.setMemberName(memberName[j]);
						if(!"".equals(remarksMem[j]) && remarksMem[j] != null) {
							educationalRecordAward.setRemarks(remarksMem[j]);
						}
						educationalRecordAwards.add(educationalRecordAward);
					}
				}
			}
		} catch(Exception e) {
			e.printStackTrace();
			return ERROR;
		}
		
		boolean result1 = dynamicDataRecordDao.updateRecord(educationalReformRecord);
		boolean result2 = researchInfoService.modifyProofs(proofs);
		boolean result3 = researchInfoService.modifyResearchMemberInfo(recordId, "EducationalRecordAward", "educationalReformRecord", "id", 32, educationalRecordAwards);//TODO
		Confirm confirm = new Confirm();
		if(result1 && result2 && result3) {
			confirm.setIsSuccess("right");
			confirm.setMessage("教改结题信息修改成功");
			confirm.setUrl("viewEducationalReformRecords.action");
			confirm.setRetName("个人教改结题信息页面");
		} else {
			confirm.setIsSuccess("error");
			confirm.setMessage("教改结题信息修改失败");
			confirm.setUrl("viewEducationalReformRecords.action");
			confirm.setRetName("个人教改结题信息页面");
		}
		ActionContext.getContext().put("confirm", confirm);
		return SUCCESS;
	}
	
	@Override
	public void setServletContext(ServletContext context) {
		this.context = context;
	}

	public ResearchInfoService getResearchInfoService() {
		return researchInfoService;
	}

	public void setResearchInfoService(ResearchInfoService researchInfoService) {
		this.researchInfoService = researchInfoService;
	}

	public DynamicDataRecordDao getDynamicDataRecordDao() {
		return dynamicDataRecordDao;
	}

	public void setDynamicDataRecordDao(DynamicDataRecordDao dynamicDataRecordDao) {
		this.dynamicDataRecordDao = dynamicDataRecordDao;
	}

	public SearchDao getSearchDao() {
		return searchDao;
	}

	public void setSearchDao(SearchDao searchDao) {
		this.searchDao = searchDao;
	}

	public String getSubmit() {
		return submit;
	}

	public void setSubmit(String submit) {
		this.submit = submit;
	}

	public String getRecordId() {
		return recordId;
	}

	public void setRecordId(String recordId) {
		this.recordId = recordId;
	}

	public String getRecordName() {
		return recordName;
	}

	public void setRecordName(String recordName) {
		this.recordName = recordName;
	}

	public String[] getMemberName() {
		return memberName;
	}

	public void setMemberName(String[] memberName) {
		this.memberName = memberName;
	}

	public String[] getRemarksMem() {
		return remarksMem;
	}

	public void setRemarksMem(String[] remarksMem) {
		this.remarksMem = remarksMem;
	}

	public File[] getUpload() {
		return upload;
	}

	public void setUpload(File[] upload) {
		this.upload = upload;
	}

	public String[] getUploadContentType() {
		return uploadContentType;
	}

	public void setUploadContentType(String[] uploadContentType) {
		this.uploadContentType = uploadContentType;
	}

	public String[] getUploadFileName() {
		return uploadFileName;
	}

	public void setUploadFileName(String[] uploadFileName) {
		this.uploadFileName = uploadFileName;
	}

	public String[] getDescProof() {
		return descProof;
	}

	public void setDescProof(String[] descProof) {
		this.descProof = descProof;
	}
	
}
