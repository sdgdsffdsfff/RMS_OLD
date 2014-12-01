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
import com.cqupt.mis.rms.model.ExcellentRecordAward;
import com.cqupt.mis.rms.model.ExcellentTrainerData;
import com.cqupt.mis.rms.model.ExcellentTrainerField;
import com.cqupt.mis.rms.model.ExcellentTrainerRecord;
import com.cqupt.mis.rms.model.Proofs;
import com.cqupt.mis.rms.service.SubmitInfoAndProofsService;
import com.cqupt.mis.rms.utils.Confirm;
import com.cqupt.mis.rms.utils.DynamicDataFieldUtils;
import com.cqupt.mis.rms.utils.GenerateUtils;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class SubmitExcellentTrainerRecordAction extends ActionSupport implements ServletContextAware{



		//注入服务层接口
		private SubmitInfoAndProofsService submitInfoAndProofsService;
		private DynamicDataRecordDao dynamicDataRecordDao;
		private SearchDao searchDao;
		 
		private ExcellentTrainerField excellentTrainerField;
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

			ExcellentTrainerRecord excellentTrainerRecord = new ExcellentTrainerRecord();
			excellentTrainerRecord.setId(id);
			excellentTrainerRecord.setName(projectName);
			excellentTrainerRecord.setSubmitUser(user);
			excellentTrainerRecord.setStatus(status);
			List<ExcellentTrainerField> fieldsFromDataBase = searchDao.SearchObjectsByFactor("com.cqupt.mis.rms.model.ExcellentTrainerField", "isDelete", 0);
			Set<ExcellentTrainerData> fields = new HashSet<ExcellentTrainerData>();
			//将前台已填写的字段封装成ExcellentTrainerData对象
			
			for(ExcellentTrainerField f : fieldsFromDataBase) {
				String value = (String) request.getParameter(f.getName());
				if(value==null || "".equals(value)) {
					continue;
				} else {
				
					ExcellentTrainerData tempData = new ExcellentTrainerData();
					tempData.setRecord(excellentTrainerRecord);
					tempData.setField(f);
					tempData.setValue(value);
					fields.add(tempData);
				}
			}
			excellentTrainerRecord.setFields(fields);
			
			
			/*
			 * 构建上传材料，获奖教师的对象
			 */
			String targetDirectory = context.getRealPath(GenerateUtils.generateSavePath());//获得路径
			List<Proofs> proofs = new ArrayList<Proofs>();
			List<ExcellentRecordAward> excellentRecordAwardList = new ArrayList<ExcellentRecordAward>();
			
			
			
			
			
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
							ExcellentRecordAward excellentRecordAward = new ExcellentRecordAward();
							excellentRecordAward.setExcellentTrainerRecord(excellentTrainerRecord);
							excellentRecordAward.setMemberName(memberName[j]);
							if(!"".equals(remarksMem[j]) && remarksMem[j] != null){
								excellentRecordAward.setRemarks(remarksMem[j]);
							}
							excellentRecordAwardList.add(excellentRecordAward);
						}
					}
				}
				
				boolean result1 = dynamicDataRecordDao.addRecord(excellentTrainerRecord);
				boolean result2 = submitInfoAndProofsService.submitResearchMemberInfo(30, excellentRecordAwardList);
				boolean result3 = submitInfoAndProofsService.submitProofs(proofs);
				Confirm confirm = new Confirm();
				if(result1 && result2 && result3){
					confirm.setIsSuccess("right");
					confirm.setMessage(DynamicDataFieldUtils.getInfoNameByClassNum(2)+"添加成功");
					confirm.setUrl("viewExcellentTrainerRecords.action");
					confirm.setRetName("管理个人"+DynamicDataFieldUtils.getInfoNameByClassNum(2)+"页面");
				}else{
					confirm.setIsSuccess("error");
					confirm.setMessage(DynamicDataFieldUtils.getInfoNameByClassNum(2)+"添加失败");
					confirm.setUrl("viewExcellentTrainerRecords.action");
					confirm.setRetName("管理个人"+DynamicDataFieldUtils.getInfoNameByClassNum(2)+"页面");
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

		public ExcellentTrainerField getExcellentTrainerField() {
			return excellentTrainerField;
		}

		public void setExcellentTrainerField(ExcellentTrainerField excellentTrainerField) {
			this.excellentTrainerField = excellentTrainerField;
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
