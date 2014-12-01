package com.cqupt.mis.rms.action.teacher;

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
import com.cqupt.mis.rms.model.LearningEvaluationData;
import com.cqupt.mis.rms.model.LearningEvaluationField;
import com.cqupt.mis.rms.model.LearningEvaluationRecord;
import com.cqupt.mis.rms.model.LearningRecordAward;
import com.cqupt.mis.rms.model.Proofs;
import com.cqupt.mis.rms.service.SubmitInfoAndProofsService;
import com.cqupt.mis.rms.utils.Confirm;
import com.cqupt.mis.rms.utils.DynamicDataFieldUtils;
import com.cqupt.mis.rms.utils.GenerateUtils;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class SubmitLearningEvaluationRecordAction extends ActionSupport implements ServletContextAware{



		//注入服务层接口
		private SubmitInfoAndProofsService submitInfoAndProofsService;
		private DynamicDataRecordDao dynamicDataRecordDao;
		private SearchDao searchDao;
		 
		private LearningEvaluationField learningEvaluationField;
		private String projectName;
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
			
			HttpServletRequest request = ServletActionContext.getRequest();
			//如果submit==保存，status=0，如果submit==提交，status=1
			int status;
			if("保存".equals(submit)){
				status = 0;
			}else if("提交".equals(submit)){
				status = 1;
			}else{
				status = -1;
			}
			String id = GenerateUtils.getID();//生成ID
			//取得存放在session中的userId
			String userId = (String)ActionContext.getContext().getSession().get("userId");
			CQUPTUser user = new CQUPTUser();
			user.setUserId(userId);
			
			/*
			 * 构建一条记录对象
			 */
			
			LearningEvaluationRecord learningEvaluationRecord = new LearningEvaluationRecord();
			learningEvaluationRecord.setId(id);
			learningEvaluationRecord.setName(projectName);
			learningEvaluationRecord.setSubmitUser(user);
			learningEvaluationRecord.setStatus(status);
			List<LearningEvaluationField> fieldsFromDataBase = searchDao.SearchObjectsByFactor("com.cqupt.mis.rms.model.LearningEvaluationField", "isDelete", 0);
			Set<LearningEvaluationData> fields = new HashSet<LearningEvaluationData>();
			//将前台已填写的字段封装成LearningEvaluationData对象
			
			for(LearningEvaluationField f : fieldsFromDataBase) {
				String value = (String) request.getParameter(f.getName());
				if(value==null || "".equals(value)) {
					continue;
				} else {
				
					LearningEvaluationData tempData = new LearningEvaluationData();
					tempData.setRecord(learningEvaluationRecord);
					tempData.setField(f);
					tempData.setValue(value);
					fields.add(tempData);
				}
			}
			learningEvaluationRecord.setFields(fields);
			
			
			/*
			 * 构建上传材料，获奖教师的对象
			 */
			String targetDirectory = context.getRealPath(GenerateUtils.generateSavePath());//获得路径
			List<Proofs> proofs = new ArrayList<Proofs>();
			List<LearningRecordAward> learningRecordAwardList = new ArrayList<LearningRecordAward>();
			
			
			
			
			
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

//				保存成员信息
				if(memberName != null){
					for(int j = 0; j < memberName.length; j++){
						if(!"".equals(memberName[j]) && memberName[j] != null){
							LearningRecordAward learningRecordAward = new LearningRecordAward();
							learningRecordAward.setLearningEvaluationRecord(learningEvaluationRecord);
							learningRecordAward.setMemberName(memberName[j]);
							if(!"".equals(remarksMem[j]) && remarksMem[j] != null){
								learningRecordAward.setRemarks(remarksMem[j]);
							}
							learningRecordAwardList.add(learningRecordAward);
						}
					}
				}
				
				boolean result1 = dynamicDataRecordDao.addRecord(learningEvaluationRecord);
				boolean result2 = submitInfoAndProofsService.submitResearchMemberInfo(32, learningRecordAwardList);
				boolean result3 = submitInfoAndProofsService.submitProofs(proofs);
				Confirm confirm = new Confirm();
				if(result1 && result2 && result3){
					confirm.setIsSuccess("right");
					confirm.setMessage(DynamicDataFieldUtils.getInfoNameByClassNum(7)+"添加成功");
					confirm.setUrl("viewLearningEvaluationRecords.action");
					confirm.setRetName("管理个人"+DynamicDataFieldUtils.getInfoNameByClassNum(7)+"页面");
				}else{
					confirm.setIsSuccess("error");
					confirm.setMessage(DynamicDataFieldUtils.getInfoNameByClassNum(7)+"添加失败");
					confirm.setUrl("viewLearningEvaluationRecords.action");
					confirm.setRetName("管理个人"+DynamicDataFieldUtils.getInfoNameByClassNum(7)+"页面");
				}
				ActionContext.getContext().put("confirm", confirm);
				return SUCCESS;
			} catch (Exception e) {
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
		

		public void setSubmit(String submit) {
			this.submit = submit;
		}

		public void setRemarksMem(String[] remarksMem) {
			this.remarksMem = remarksMem;
		}

		public void setDescProof(String[] descProof) {
			this.descProof = descProof;
		}
		public SearchDao getSearchDao() {
			return searchDao;
		}

		public void setSearchDao(SearchDao searchDao) {
			this.searchDao = searchDao;
		}

		public LearningEvaluationField getLearningEvaluationField() {
			return learningEvaluationField;
		}

		public void setlearningEvaluationField(LearningEvaluationField learningEvaluationField) {
			this.learningEvaluationField = learningEvaluationField;
		}


		public String getProjectName() {
		return projectName;
		}

		public void setProjectName(String projectName) {
			this.projectName = projectName;
		}

		public SubmitInfoAndProofsService getSubmitInfoAndProofsService() {
			return submitInfoAndProofsService;
		}

		public String getSubmit() {
			return submit;
		}

		public String[] getMemberName() {
			return memberName;
		}
	
		public String[] getRemarksMem() {
			return remarksMem;
		}
	
		public File[] getUpload() {
			return upload;
		}
	
		public String[] getUploadContentType() {
			return uploadContentType;
		}
	
		public String[] getUploadFileName() {
			return uploadFileName;
		}
	
		public String[] getDescProof() {
			return descProof;
		}
	
		public ServletContext getContext() {
			return context;
		}
		public DynamicDataRecordDao getDynamicDataRecordDao() {
			return dynamicDataRecordDao;
		}

		public void setDynamicDataRecordDao(DynamicDataRecordDao dynamicDataRecordDao) {
			this.dynamicDataRecordDao = dynamicDataRecordDao;
		}
}
