package com.cqupt.mis.rms.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.cqupt.mis.rms.manager.SearchDao;
import com.cqupt.mis.rms.model.CQUPTUser;
import com.cqupt.mis.rms.model.HumanitiesProject;
import com.cqupt.mis.rms.model.HumanitiesProjectDetail;
import com.cqupt.mis.rms.model.HumanitiesProjectMember;
import com.cqupt.mis.rms.service.HumanitiesProjectService;
import com.cqupt.mis.rms.service.model.ProjectInfo;

public class HumanitiesProjectServiceImpl implements HumanitiesProjectService {
	private SearchDao searchDao;
	
	public void setSearchDao(SearchDao searchDao) {
		this.searchDao = searchDao;
	}
	@Override
	public ProjectInfo<HumanitiesProject, HumanitiesProjectDetail, HumanitiesProjectMember> findHumanitiesProjectInfoByProjectId(
			String projectId) {
		// TODO Auto-generated method stub
		ProjectInfo<HumanitiesProject, HumanitiesProjectDetail, HumanitiesProjectMember> projectInfo = new ProjectInfo<HumanitiesProject, HumanitiesProjectDetail, HumanitiesProjectMember>();
		List<HumanitiesProjectDetail> humanitiesProjectDetails = this.searchDao.SearchObjectsByFactor("HumanitiesProjectDetail", "humanitiesProject.projectId", projectId);
		List<HumanitiesProjectMember> humanitiesProjectMembers = this.searchDao.SearchObjectsByFactor("HumanitiesProjectMember", "humanitiesProject.projectId", projectId);
		projectInfo.setProject((HumanitiesProject)this.searchDao.SearchUniqueObjectsByFactor("HumanitiesProject", "projectId", projectId));
		projectInfo.setDetail(humanitiesProjectDetails);
		projectInfo.setMember(humanitiesProjectMembers);
		return projectInfo;
	}

	@Override
	public List<ProjectInfo<HumanitiesProject, HumanitiesProjectDetail, HumanitiesProjectMember>> findHumanitiesProjectInfoByUser(
			List<CQUPTUser> CQUPTUsers) {
		// TODO Auto-generated method stub
		List<ProjectInfo<HumanitiesProject, HumanitiesProjectDetail, HumanitiesProjectMember>> projectInfos = new ArrayList<ProjectInfo<HumanitiesProject, HumanitiesProjectDetail, HumanitiesProjectMember>>();

			for (int i = 0; i < CQUPTUsers.size(); i++) {
				List<HumanitiesProject> humanitiesProjects = this.searchDao.SearchObjectsByFactor("HumanitiesProject", "submitUser.userId", CQUPTUsers.get(i).getUserId());
				for(HumanitiesProject humanitiesProject:humanitiesProjects){
					projectInfos.add(this.findHumanitiesProjectInfoByProjectId(humanitiesProject.getProjectId()));
				}
			}
		return projectInfos;
	}

	@Override
	public List<ProjectInfo<HumanitiesProject, HumanitiesProjectDetail, HumanitiesProjectMember>> SearchHumanitiesProjectInfoByStringFactor(
			List<ProjectInfo<HumanitiesProject, HumanitiesProjectDetail, HumanitiesProjectMember>> projectInfos,
			String factorName, String factorValue) {
		// TODO Auto-generated method stub
		List<ProjectInfo<HumanitiesProject, HumanitiesProjectDetail, HumanitiesProjectMember>> projectInfo = new ArrayList<ProjectInfo<HumanitiesProject, HumanitiesProjectDetail, HumanitiesProjectMember>>();
		int num =0;
		if(factorName.endsWith("projectId")){
			num =1;
		}else if(factorName.endsWith("projectName")){
			num = 2;
		}else if(factorName.endsWith("projectNumber")){
			num = 3;
		}else if(factorName.endsWith("projectOrigin")){
			num = 4;
		}else if(factorName.endsWith("submitUser")){
			num = 5;
		}else if(factorName.endsWith("approvedUser")){
			num = 6;
		}else if(factorName.endsWith("status")){
			num = 7;
		}else if(factorName.endsWith("member")){
			num = 8;
		}else{
			System.out.println("输入的factorName值有误！您输入的factorName值："+factorName);
		}
		
		for(int i=0;i<projectInfos.size();i++){
			switch(num)
			{
			case 1:{
				if(projectInfos.get(i).getProject().getProjectId().indexOf(factorValue)!=-1){
					projectInfo.add(projectInfos.get(i));
				}
				break;
			}
			case 2:{
				if(projectInfos.get(i).getProject().getProjectName().indexOf(factorValue)!=-1){
					projectInfo.add(projectInfos.get(i));
				}
				break;
			}
			case 3:{
				if(projectInfos.get(i).getProject().getProjectNumber().indexOf(factorValue)!=-1){
					projectInfo.add(projectInfos.get(i));
				}
				break;
			}
			case 4:{
				if(projectInfos.get(i).getProject().getProjectOrigin().indexOf(factorValue)!=-1){
					projectInfo.add(projectInfos.get(i));
				}
				break;
			}
			case 5:{
				if(projectInfos.get(i).getProject().getSubmitUser()!=null){
					if(projectInfos.get(i).getProject().getSubmitUser().getUserName().indexOf(factorValue)!=-1){
						projectInfo.add(projectInfos.get(i));
					}
				}
				break;
			}
			case 6:{
				if(projectInfos.get(i).getProject().getApprovedUser()!=null){
					if(projectInfos.get(i).getProject().getApprovedUser().getUserName().indexOf(factorValue)!=-1){
						projectInfo.add(projectInfos.get(i));
					}
				}
				break;
			}
			case 7:{
				int status = java.lang.Integer.parseInt(factorValue);
				if(projectInfos.get(i).getProject().getStatus()==status){
					projectInfo.add(projectInfos.get(i));
				}
				break;
			}
			case 8:{
				for(int j = 0;j<projectInfos.get(i).getMember().size();j++){
					if(projectInfos.get(i).getMember().get(j).getMemberName().indexOf(factorValue)!=-1){
						projectInfo.add(projectInfos.get(i));
						break;
					}
				}
				break;
			}
			default:break;
			}
		}
		return projectInfo;
	}

	@Override
	public List<ProjectInfo<HumanitiesProject, HumanitiesProjectDetail, HumanitiesProjectMember>> SearchHumanitiesProjectInfoByNumFactor(
			List<ProjectInfo<HumanitiesProject, HumanitiesProjectDetail, HumanitiesProjectMember>> projectInfos,
			String factorName, float minFloatValue, float maxFloatValue) {
		// TODO Auto-generated method stub
		List<ProjectInfo<HumanitiesProject, HumanitiesProjectDetail, HumanitiesProjectMember>> projectInfo = new ArrayList<ProjectInfo<HumanitiesProject, HumanitiesProjectDetail, HumanitiesProjectMember>>();
		int num =0;
		if(factorName.endsWith("money")){
			num =1;
		}else{
			System.out.println("输入的factorName值有误！您输入的factorName值："+factorName);
		}
		for(int i=0;i<projectInfos.size();i++){
			switch(num)
			{
			case 1:{
				for(int j=0;j<projectInfos.get(i).getDetail().size();j++){
					if((projectInfos.get(i).getDetail().get(j).getMoney()>minFloatValue||projectInfos.get(i).getDetail().get(j).getMoney()==minFloatValue)
							&&(projectInfos.get(i).getDetail().get(j).getMoney()<maxFloatValue||projectInfos.get(i).getDetail().get(j).getMoney()==maxFloatValue)){
						projectInfo.add(projectInfos.get(i));
						break;
					}
				}
				break;
			}
			default:break;
			}
		}
		return projectInfo;
	}

	@Override
	public List<ProjectInfo<HumanitiesProject, HumanitiesProjectDetail, HumanitiesProjectMember>> SearchHumanitiesProjectInfoByDateFactor(
			List<ProjectInfo<HumanitiesProject, HumanitiesProjectDetail, HumanitiesProjectMember>> projectInfos,
			String factorName, Date begin, Date end) {
		// TODO Auto-generated method stub
		List<ProjectInfo<HumanitiesProject, HumanitiesProjectDetail, HumanitiesProjectMember>> projectInfo = new ArrayList<ProjectInfo<HumanitiesProject, HumanitiesProjectDetail, HumanitiesProjectMember>>();
		int num =0;
		if(factorName.endsWith("timeApproved")){
			num =1;
		}else if(factorName.endsWith("updateTime")){
			num = 2;
		}else{
			System.out.println("输入的factorName值有误！您输入的factorName值："+factorName);
		}
		for(int i=0;i<projectInfos.size();i++){
			switch(num)
			{
			case 1:{
				if(projectInfos.get(i).getProject().getTimeApproved().after(begin)&&projectInfos.get(i).getProject().getTimeApproved().before(end)){
					projectInfo.add(projectInfos.get(i));
				}
				break;
			}
			case 2:{
				for(int j=0;j<projectInfos.get(i).getDetail().size();j++){
					if(projectInfos.get(i).getDetail().get(j).getUpdateTime().after(begin)&&projectInfos.get(i).getDetail().get(j).getUpdateTime().before(end)){
						projectInfo.add(projectInfos.get(i));
						break;
					}
				}
				break;
			}
			default:break;
			}
		}
		return projectInfo;
	}

}
