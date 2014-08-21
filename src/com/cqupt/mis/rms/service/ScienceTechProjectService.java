package com.cqupt.mis.rms.service;

import java.util.Date;
import java.util.List;

import com.cqupt.mis.rms.model.CQUPTUser;
import com.cqupt.mis.rms.model.ScienceDetailTechProject;
import com.cqupt.mis.rms.model.ScienceTechProject;
import com.cqupt.mis.rms.model.ScienceTechProjectMember;
import com.cqupt.mis.rms.service.model.ProjectInfo;

public interface ScienceTechProjectService {
	//根据项目ID查找项目整体信息
	public ProjectInfo<ScienceTechProject,ScienceDetailTechProject,ScienceTechProjectMember> findScienceProjectInfoByProjectId(String projectId);
	
	//根据项目成员ID查找该人员的所有项目Info信息
	public List<ProjectInfo<ScienceTechProject,ScienceDetailTechProject,ScienceTechProjectMember>> findScienceProjectInfoByMemberId(String memberId);
	
	//根据用户集合查找与该用户群体相关的项目Info信息集合。
	public List<ProjectInfo<ScienceTechProject,ScienceDetailTechProject,ScienceTechProjectMember>> findScienceProjectInfoByUser(List<CQUPTUser> CQUPTUsers);
	
	//从指定ScienceProjectInfo集合中筛检出符合条件的ProjectInfo集合
	//筛检字段为字符串类型
	public List<ProjectInfo<ScienceTechProject,ScienceDetailTechProject,ScienceTechProjectMember>> SearchScienceProjectInfoByProjectStringFactor(List<ProjectInfo<ScienceTechProject,ScienceDetailTechProject,ScienceTechProjectMember>> projectInfos,String factorName,String factorValue);
	//筛检字段为数值类型
	public List<ProjectInfo<ScienceTechProject,ScienceDetailTechProject,ScienceTechProjectMember>> SearchScienceProjectInfoByProjectNumFactor(List<ProjectInfo<ScienceTechProject,ScienceDetailTechProject,ScienceTechProjectMember>> projectInfos,String factorName,float minFloatValue,float maxFloatValue);
	//筛检字段为时间类型
	public List<ProjectInfo<ScienceTechProject,ScienceDetailTechProject,ScienceTechProjectMember>> SearchScienceProjectInfoByProjectDateFactor(List<ProjectInfo<ScienceTechProject,ScienceDetailTechProject,ScienceTechProjectMember>> projectInfos,String factorName,Date begin,Date end);
	
	
}
