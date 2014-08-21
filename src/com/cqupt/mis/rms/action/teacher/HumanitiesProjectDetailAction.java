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

import com.cqupt.mis.rms.manager.ResearchInfoDao;
import com.cqupt.mis.rms.model.HumanitiesProject;
import com.cqupt.mis.rms.model.HumanitiesProjectDetail;
import com.cqupt.mis.rms.model.Proofs;
import com.cqupt.mis.rms.service.ResearchInfoService;
import com.cqupt.mis.rms.utils.Confirm;
import com.cqupt.mis.rms.utils.GenerateUtils;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

/**
*<p>Title:处理教师用户更新理科科技项目详细信息的Action</p>
*<p>Description:接收用户提交的信息并处理</p>
*@author LvHai
*@version 1.0
**/
@SuppressWarnings("serial")
public class HumanitiesProjectDetailAction extends ActionSupport implements ServletContextAware {
	//注入接口
	private ResearchInfoService researchInfoService;
	private ResearchInfoDao researchInfoDao;
	
	private String projectId;
	
	//科技项目详细信息
	private int id;
	private String projectStatus;
	private float money;
	private String timePerPerson;
	
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
	
	public String updateHumanitiesProjectDetail(){
		if(!"".equals(projectId) && projectId != null){
			try {
				//如果submit==保存，status=0，如果submit==提交，status=1
				int status;
				if("保存".equals(submit)){
					status = 4;
				}else if("提交".equals(submit)){
					status = 5;
				}else{
					return ERROR;
				}
				
				String targetDirectory = servletContext.getRealPath(GenerateUtils.generateSavePath());//获得路径
				List<Proofs> proofs = new ArrayList<Proofs>();
				HumanitiesProject humanitiesProject = new HumanitiesProject();
				humanitiesProject.setProjectId(projectId);
				//设置科技项目详细信息
				HumanitiesProjectDetail humanitiesProjectDetail = new HumanitiesProjectDetail();
				humanitiesProjectDetail.setHumanitiesProject(humanitiesProject);
				humanitiesProjectDetail.setMoney(money);
				humanitiesProjectDetail.setProjectStatus(projectStatus);
				humanitiesProjectDetail.setTimePerPerson(timePerPerson);
				humanitiesProjectDetail.setUpdateTime(new Date());
				
				//上传旁证材料
				if(upload != null){
					for (int i = 0; i < upload.length; i++){
						String fileName = uploadFileName[i];// 上传的文件名
						String fileType = uploadContentType[i];// 文件类型
						String targetFileName = GenerateUtils.generateFileName(fileName);   
				        File target = new File(targetDirectory, targetFileName); 
				        FileUtils.copyFile(upload[i], target);
				        Proofs proof = new Proofs();
				        proof.setInfoApprovedId(projectId);
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
				
				boolean result0 = researchInfoService.modifyProofs(proofs);
				boolean result1 = researchInfoService.addProjectDetailInfo(humanitiesProjectDetail, projectId, status, "HumanitiesProject", "projectId");
				Confirm confirm = new Confirm();
				if(result1 && result0){
					confirm.setIsSuccess("right");
					confirm.setMessage("科研项目详细信息添加成功");
					confirm.setUrl("viewHumanitiesProject.action");
					confirm.setRetName("个人科研项目信息页面");
				}else{
					confirm.setIsSuccess("error");
					confirm.setMessage("科研项目详细信息添加失败");
					confirm.setUrl("viewHumanitiesProject.action");
					confirm.setRetName("个人科研项目信息页面");
				}
				ActionContext.getContext().put("confirm", confirm);
				return SUCCESS;
			} catch (Exception e) {
				e.printStackTrace();
				return ERROR;
			}
		}else{
			return ERROR;
		}
		
	}
	
	//根据项目ID查看该项目最新更新的详细信息
		public String showHumanitiesProjectDetail(){
			try {
				HumanitiesProjectDetail humanitiesProjectDetail = researchInfoService.showHumanitiesProjectDetailInfoByDate(projectId);
				ActionContext.getContext().put("humanitiesProjectDetail", humanitiesProjectDetail);
				return SUCCESS;
			} catch (Exception e) {
				e.printStackTrace();
				return ERROR;
			}
		}
		
		//修改或提交更新后的项目详细信息
		public String modifyHumanitiesProjectDetail(){
			try {
				int status;
				if("保存".equals(submit)){
					status = 4;
				}else if("提交".equals(submit)){
					status = 5;
				}else{
					return ERROR;
				}
				
				HumanitiesProjectDetail humanitiesProjectDetail = (HumanitiesProjectDetail)researchInfoDao.findResearchInfoByIdAndModelNameAndFactor(id, "HumanitiesProjectDetail", "id");
				int status0 = humanitiesProjectDetail.getHumanitiesProject().getStatus();
				//4：更新已保存；5：更新已提交；6：更新审批通过；7：更新审批未通过
				Confirm confirm = new Confirm();
				if(status0 == 4 || status0 == 7){
					humanitiesProjectDetail.setMoney(money);
					humanitiesProjectDetail.setProjectStatus(projectStatus);
					humanitiesProjectDetail.setTimePerPerson(timePerPerson);
					humanitiesProjectDetail.setUpdateTime(new Date());
					researchInfoService.modifyHumanitiesProjectDetailInfo(id, humanitiesProjectDetail, status);
					confirm.setIsSuccess("right");
					confirm.setMessage("科研项目详细信息修改成功");
					confirm.setUrl("viewHumanitiesProject.action");
					confirm.setRetName("个人科研项目信息页面");
				}else{
					confirm.setIsSuccess("error");
					confirm.setMessage("科研项目详细信息修改失败");
					confirm.setUrl("viewHumanitiesProject.action");
					confirm.setRetName("个人科研项目信息页面");
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

		public void setProjectId(String projectId) {
			this.projectId = projectId;
		}

		public void setProjectStatus(String projectStatus) {
			this.projectStatus = projectStatus;
		}

		public void setMoney(float money) {
			this.money = money;
		}

		public void setTimePerPerson(String timePerPerson) {
			this.timePerPerson = timePerPerson;
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

		public void setId(int id) {
			this.id = id;
		}
	
}
