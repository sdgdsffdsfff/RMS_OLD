package com.cqupt.mis.rms.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.cqupt.mis.rms.manager.SearchDao;
import com.cqupt.mis.rms.model.CQUPTUser;
import com.cqupt.mis.rms.model.ScienceDetailTechProject;
import com.cqupt.mis.rms.model.ScienceTechProject;
import com.cqupt.mis.rms.model.ScienceTechProjectMember;
import com.cqupt.mis.rms.service.ScienceTechProjectService;
import com.cqupt.mis.rms.service.model.ProjectInfo;

public class ScienceTechProjectServiceImpl implements ScienceTechProjectService {
	private SearchDao searchDao;
	
	public void setSearchDao(SearchDao searchDao) {
		this.searchDao = searchDao;
	}

	@Override
	public ProjectInfo<ScienceTechProject, ScienceDetailTechProject, ScienceTechProjectMember> findScienceProjectInfoByProjectId(
			String projectId) {
		// TODO Auto-generated method stub
		ProjectInfo<ScienceTechProject, ScienceDetailTechProject, ScienceTechProjectMember> projectInfo = new ProjectInfo<ScienceTechProject, ScienceDetailTechProject, ScienceTechProjectMember>();
		projectInfo.setProject((ScienceTechProject)this.searchDao.SearchUniqueObjectsByFactor("ScienceTechProject", "projectId", projectId));
		List<ScienceDetailTechProject> scienceDetailTechProjects = this.searchDao.SearchObjectsByFactor("ScienceDetailTechProject", "scienceTechProject.projectId", projectId);
		projectInfo.setDetail(scienceDetailTechProjects);
		List<ScienceTechProjectMember> scienceTechProjectMembers = this.searchDao.SearchObjectsByFactor("ScienceTechProjectMember", "project.projectId", projectId);
		projectInfo.setMember(scienceTechProjectMembers);
		return projectInfo;
	}

	@Override
	public List<ProjectInfo<ScienceTechProject, ScienceDetailTechProject, ScienceTechProjectMember>> findScienceProjectInfoByMemberId(
			String memberId) {
		// TODO Auto-generated method stub
		List<ProjectInfo<ScienceTechProject, ScienceDetailTechProject, ScienceTechProjectMember>> projectInfos = new ArrayList<ProjectInfo<ScienceTechProject, ScienceDetailTechProject, ScienceTechProjectMember>>();
		List<ScienceTechProjectMember> scienceTechProjectMembers = this.searchDao.SearchObjectsByFactor("ScienceTechProjectMember", "memberId", memberId);
		for(int i=0;i<scienceTechProjectMembers.size();i++){
			projectInfos.add(this.findScienceProjectInfoByProjectId(scienceTechProjectMembers.get(i).getProject().getProjectId()));
		}
		return projectInfos;
	}

	@Override
	public List<ProjectInfo<ScienceTechProject, ScienceDetailTechProject, ScienceTechProjectMember>> findScienceProjectInfoByUser(
			List<CQUPTUser> CQUPTUsers) {
		// TODO Auto-generated method stub
		List<ProjectInfo<ScienceTechProject, ScienceDetailTechProject, ScienceTechProjectMember>> projectInfos = new ArrayList<ProjectInfo<ScienceTechProject, ScienceDetailTechProject, ScienceTechProjectMember>>();

			for (int i = 0; i < CQUPTUsers.size(); i++) {
				List<ScienceTechProject> scienceTechProjects = this.searchDao.SearchObjectsByFactor("ScienceTechProject", "submitUser.userId", CQUPTUsers.get(i).getUserId());
				for(ScienceTechProject scienceTechProject:scienceTechProjects){
					projectInfos.add(this.findScienceProjectInfoByProjectId(scienceTechProject.getProjectId()));
				}
			}
		return projectInfos;
	}

	@Override
	public List<ProjectInfo<ScienceTechProject, ScienceDetailTechProject, ScienceTechProjectMember>> SearchScienceProjectInfoByProjectStringFactor(
			List<ProjectInfo<ScienceTechProject, ScienceDetailTechProject, ScienceTechProjectMember>> projectInfos,
			String factorName, String factorValue) {
		// TODO Auto-generated method stub
		List<ProjectInfo<ScienceTechProject, ScienceDetailTechProject, ScienceTechProjectMember>> projectInfo = new ArrayList<ProjectInfo<ScienceTechProject, ScienceDetailTechProject, ScienceTechProjectMember>>();
		int num =0;
		if(factorName.endsWith("projectId")){
			num =1;
		}else if(factorName.endsWith("projectName")){
			num = 2;
		}else if(factorName.endsWith("sortSubject")){
			num = 3;
		}else if(factorName.endsWith("sortActivity")){
			num = 4;
		}else if(factorName.endsWith("originProject")){
			num = 5;
		}else if(factorName.endsWith("formOrganization")){
			num = 6;
		}else if(factorName.endsWith("formCooperation")){
			num = 7;
		}else if(factorName.endsWith("organReliedProject")){
			num = 8;
		}else if(factorName.endsWith("industryService")){
			num = 9;
		}else if(factorName.endsWith("unitProject")){
			num = 10;
		}else if(factorName.endsWith("submitUser")){
			num = 11;
		}else if(factorName.endsWith("approvedUser")){
			num = 12;
		}else if(factorName.endsWith("status")){
			num = 13;
		}else if(factorName.endsWith("member")){
			num = 14;
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
				if(projectInfos.get(i).getProject().getSortSubject().indexOf(factorValue)!=-1){
					projectInfo.add(projectInfos.get(i));
				}
				break;
			}
			case 4:{
				if(projectInfos.get(i).getProject().getSortActivity().indexOf(factorValue)!=-1){
					projectInfo.add(projectInfos.get(i));
				}
				break;
			}
			case 5:{
				if(projectInfos.get(i).getProject().getOriginProject().indexOf(factorValue)!=-1){
					projectInfo.add(projectInfos.get(i));
				}
				break;
			}
			case 6:{
				if(projectInfos.get(i).getProject().getFormOrganization().indexOf(factorValue)!=-1){
					projectInfo.add(projectInfos.get(i));
				}
				break;
			}
			case 7:{
				if(projectInfos.get(i).getProject().getFormCooperation().indexOf(factorValue)!=-1){
					projectInfo.add(projectInfos.get(i));
				}
				break;
			}
			case 8:{
				if(projectInfos.get(i).getProject().getOrganReliedProject().indexOf(factorValue)!=-1){
					projectInfo.add(projectInfos.get(i));
				}
				break;
			}
			case 9:{
				if(projectInfos.get(i).getProject().getIndustryService().indexOf(factorValue)!=-1){
					projectInfo.add(projectInfos.get(i));
				}
				break;
			}
			case 10:{
				if(projectInfos.get(i).getProject().getUnitProject().indexOf(factorValue)!=-1){
					projectInfo.add(projectInfos.get(i));
				}
				break;
			}
			case 11:{
				if(projectInfos.get(i).getProject().getSubmitUser()!=null){
					if(projectInfos.get(i).getProject().getSubmitUser().getUserName().indexOf(factorValue)!=-1){
						projectInfo.add(projectInfos.get(i));
					}
				}				
				break;
			}
			case 12:{
				if(projectInfos.get(i).getProject().getApprovedUser()!=null){
					if(projectInfos.get(i).getProject().getApprovedUser().getUserName().indexOf(factorValue)!=-1){
						projectInfo.add(projectInfos.get(i));
					}
				}
				break;
			}
			case 13:{
				int status = java.lang.Integer.parseInt(factorValue);
				if(projectInfos.get(i).getProject().getStatus()==status){
					projectInfo.add(projectInfos.get(i));
				}
				break;
			}
			case 14:{
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
	public List<ProjectInfo<ScienceTechProject, ScienceDetailTechProject, ScienceTechProjectMember>> SearchScienceProjectInfoByProjectNumFactor(
			List<ProjectInfo<ScienceTechProject, ScienceDetailTechProject, ScienceTechProjectMember>> projectInfos,
			String factorName, float minFloatValue, float maxFloatValue) {
		// TODO Auto-generated method stub
		List<ProjectInfo<ScienceTechProject, ScienceDetailTechProject, ScienceTechProjectMember>> projectInfo = new ArrayList<ProjectInfo<ScienceTechProject, ScienceDetailTechProject, ScienceTechProjectMember>>();
		int num = 0;
		if(factorName.equals("totalFundContract")){
			num = 1;
		}else if(factorName.equals("inputThisYear")){
			num = 2;
		}else if(factorName.equals("expenditureThisYear")){
			num = 3;
		}else if(factorName.equals("totalStaff")){
			num = 4;
		}else if(factorName.equals("advancedStaff")){
			num = 5;
		}else if(factorName.equals("middleStaff")){
			num = 6;
		}else if(factorName.equals("juniorStaff")){
			num = 7;
		}else if(factorName.equals("otherStaff")){
			num = 8;
		}else if(factorName.equals("graduateJoin")){
			num = 9;
		}else{
			System.out.println("输入的factorName值有误！您输入的factorName值："+factorName);
		}
		for(int i=0;i<projectInfos.size();i++){
			switch(num)
			{
			case 1:{
				if((projectInfos.get(i).getProject().getTotalFundContract()>minFloatValue||projectInfos.get(i).getProject().getTotalFundContract()==minFloatValue)
						&&(projectInfos.get(i).getProject().getTotalFundContract()<maxFloatValue||projectInfos.get(i).getProject().getTotalFundContract()==maxFloatValue)){
					projectInfo.add(projectInfos.get(i));
				}
				break;
			}
			
			case 2:{
				for(int j=0;j<projectInfos.get(i).getDetail().size();j++){
					if((projectInfos.get(i).getDetail().get(j).getInputThisYear()>minFloatValue||projectInfos.get(i).getDetail().get(j).getInputThisYear()==minFloatValue)
							&&(projectInfos.get(i).getDetail().get(j).getInputThisYear()<maxFloatValue||projectInfos.get(i).getDetail().get(j).getInputThisYear()==maxFloatValue)){
						projectInfo.add(projectInfos.get(i));
						break;
					}
				}
				break;
			}
			
			case 3:{
				for(int j=0;j<projectInfos.get(i).getDetail().size();j++){
					if((projectInfos.get(i).getDetail().get(j).getExpenditureThisYear()>minFloatValue||projectInfos.get(i).getDetail().get(j).getExpenditureThisYear()==minFloatValue)
							&&(projectInfos.get(i).getDetail().get(j).getExpenditureThisYear()<maxFloatValue||projectInfos.get(i).getDetail().get(j).getExpenditureThisYear()==maxFloatValue)){
						projectInfo.add(projectInfos.get(i));
						break;
					}
				}
				break;
			}
			
			case 4:{
				for(int j=0;j<projectInfos.get(i).getDetail().size();j++){
					if((projectInfos.get(i).getDetail().get(j).getTotalStaff()>minFloatValue||projectInfos.get(i).getDetail().get(j).getTotalStaff()==minFloatValue)
							&&(projectInfos.get(i).getDetail().get(j).getTotalStaff()<maxFloatValue||projectInfos.get(i).getDetail().get(j).getTotalStaff()==maxFloatValue)){
						projectInfo.add(projectInfos.get(i));
						break;
					}
				}
				break;
			}
			
			case 5:{
				for(int j=0;j<projectInfos.get(i).getDetail().size();j++){
					if((projectInfos.get(i).getDetail().get(j).getAdvancedStaff()>minFloatValue||projectInfos.get(i).getDetail().get(j).getAdvancedStaff()==minFloatValue)
							&&(projectInfos.get(i).getDetail().get(j).getAdvancedStaff()<maxFloatValue||projectInfos.get(i).getDetail().get(j).getAdvancedStaff()==maxFloatValue)){
						projectInfo.add(projectInfos.get(i));
						break;
					}
				}
				break;
			}
			
			case 6:{
				for(int j=0;j<projectInfos.get(i).getDetail().size();j++){
					if((projectInfos.get(i).getDetail().get(j).getMiddleStaff()>minFloatValue||projectInfos.get(i).getDetail().get(j).getMiddleStaff()==minFloatValue)
							&&(projectInfos.get(i).getDetail().get(j).getMiddleStaff()<maxFloatValue||projectInfos.get(i).getDetail().get(j).getMiddleStaff()==maxFloatValue)){
						projectInfo.add(projectInfos.get(i));
						break;
					}
				}
				break;
			}
			
			case 7:{
				for(int j=0;j<projectInfos.get(i).getDetail().size();j++){
					if((projectInfos.get(i).getDetail().get(j).getJuniorStaff()>minFloatValue||projectInfos.get(i).getDetail().get(j).getJuniorStaff()==minFloatValue)
							&&(projectInfos.get(i).getDetail().get(j).getJuniorStaff()<maxFloatValue||projectInfos.get(i).getDetail().get(j).getJuniorStaff()==maxFloatValue)){
						projectInfo.add(projectInfos.get(i));
						break;
					}
				}
				break;
			}
			
			case 8:{
				for(int j=0;j<projectInfos.get(i).getDetail().size();j++){
					if((projectInfos.get(i).getDetail().get(j).getOtherStaff()>minFloatValue||projectInfos.get(i).getDetail().get(j).getOtherStaff()==minFloatValue)
							&&(projectInfos.get(i).getDetail().get(j).getOtherStaff()<maxFloatValue||projectInfos.get(i).getDetail().get(j).getOtherStaff()==maxFloatValue)){
						projectInfo.add(projectInfos.get(i));
						break;
					}
				}
				break;
			}
			
			case 9:{
				for(int j=0;j<projectInfos.get(i).getDetail().size();j++){
					if((projectInfos.get(i).getDetail().get(j).getGraduateJoin()>minFloatValue||projectInfos.get(i).getDetail().get(j).getGraduateJoin()==minFloatValue)
							&&(projectInfos.get(i).getDetail().get(j).getGraduateJoin()<maxFloatValue||projectInfos.get(i).getDetail().get(j).getGraduateJoin()==maxFloatValue)){
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
	public List<ProjectInfo<ScienceTechProject, ScienceDetailTechProject, ScienceTechProjectMember>> SearchScienceProjectInfoByProjectDateFactor(
			List<ProjectInfo<ScienceTechProject, ScienceDetailTechProject, ScienceTechProjectMember>> projectInfos,
			String factorName, Date begin, Date end) {
		// TODO Auto-generated method stub
		List<ProjectInfo<ScienceTechProject, ScienceDetailTechProject, ScienceTechProjectMember>> projectInfo = new ArrayList<ProjectInfo<ScienceTechProject, ScienceDetailTechProject, ScienceTechProjectMember>>();
		int num = 0;
		if(factorName.equals("timeProjectApproved")){
			num = 1;
		}else if(factorName.equals("updateTime")){
			num = 2;
		}else{
			System.out.println("输入的factorName值有误！您输入的factorName值："+factorName);
		}
		for(int i=0;i<projectInfos.size();i++){
			switch(num)
			{
			case 1:{
				if(projectInfos.get(i).getProject().getTimeProjectApproved().after(begin)&&projectInfos.get(i).getProject().getTimeProjectApproved().before(end)){
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
