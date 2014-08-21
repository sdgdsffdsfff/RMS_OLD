package com.cqupt.mis.rms.service;

import java.util.Date;
import java.util.List;

import com.cqupt.mis.rms.model.CQUPTUser;
import com.cqupt.mis.rms.model.HumanitiesProject;
import com.cqupt.mis.rms.model.HumanitiesProjectDetail;
import com.cqupt.mis.rms.model.HumanitiesProjectMember;
import com.cqupt.mis.rms.service.model.ProjectInfo;

public interface HumanitiesProjectService {
	//根据项目ID查找项目整体信息
	public ProjectInfo<HumanitiesProject,HumanitiesProjectDetail,HumanitiesProjectMember> findHumanitiesProjectInfoByProjectId(String projectId);
	
	//根据用户集合查找与该用户群体相关的项目Info信息集合。
	public List<ProjectInfo<HumanitiesProject,HumanitiesProjectDetail,HumanitiesProjectMember>> findHumanitiesProjectInfoByUser(List<CQUPTUser> CQUPTUsers);
	
	//从指定ScienceProjectInfo集合中筛检出符合条件的ProjectInfo集合
	//筛检字段为字符串类型
	public List<ProjectInfo<HumanitiesProject,HumanitiesProjectDetail,HumanitiesProjectMember>> SearchHumanitiesProjectInfoByStringFactor(List<ProjectInfo<HumanitiesProject,HumanitiesProjectDetail,HumanitiesProjectMember>> projectInfos,String factorName,String factorValue);
	//筛检字段为数值类型
	public List<ProjectInfo<HumanitiesProject,HumanitiesProjectDetail,HumanitiesProjectMember>> SearchHumanitiesProjectInfoByNumFactor(List<ProjectInfo<HumanitiesProject,HumanitiesProjectDetail,HumanitiesProjectMember>> projectInfos,String factorName,float minFloatValue,float maxFloatValue);
	//筛检字段为时间类型
	public List<ProjectInfo<HumanitiesProject,HumanitiesProjectDetail,HumanitiesProjectMember>> SearchHumanitiesProjectInfoByDateFactor(List<ProjectInfo<HumanitiesProject,HumanitiesProjectDetail,HumanitiesProjectMember>> projectInfos,String factorName,Date begin,Date end);
	
}
