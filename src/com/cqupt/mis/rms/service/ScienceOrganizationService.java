package com.cqupt.mis.rms.service;

import java.util.List;

import com.cqupt.mis.rms.model.CQUPTUser;
import com.cqupt.mis.rms.model.ScienceOrganization;

public interface ScienceOrganizationService {
	//根据科研机构ID查找科研机构信息
	public ScienceOrganization findScienceOrganizationById(String id);
	
	//根据机构名称和该名称的值查找科研机构集合
	public List<ScienceOrganization> findScienceOrganizationByFactor(String factorName,String factorValue);
	
	//根据用户集合查找与该用户群体相关的科研机构信息。
	public List<ScienceOrganization> findAllScienceOrganization(List<CQUPTUser> CQUPTUsers);
	
	//根据用户ID查找包涵该用户的科研机构信息
	public List<ScienceOrganization> findherselfScienceOrganization(String userId);
	
	
	//从指定科研机构集合中筛选符合条件的科研机构集合
	//筛检字段为字符串类型
	public List<ScienceOrganization> searchScienceOrganizationByStringFactor(List<ScienceOrganization> scienceOrganizations,String factorName,String factorValue);
	//筛检字段为数值类型
	public List<ScienceOrganization> searchScienceOrganizationByNumFactor(List<ScienceOrganization> scienceOrganizations,String factorName,float minFactorValue,float maxFactorValue);
	
}
