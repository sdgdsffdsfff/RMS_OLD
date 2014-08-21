package com.cqupt.mis.rms.service;

import java.util.List;

import com.cqupt.mis.rms.model.CQUPTUser;
import com.cqupt.mis.rms.model.TeachingMaterialEditor;
import com.cqupt.mis.rms.model.TeachingMaterialSet;
import com.cqupt.mis.rms.service.model.ModelInfo;

public interface TeachingMaterialSetService {
	//根据教材立项ID查找指定教材立项信息
	public ModelInfo<TeachingMaterialSet, TeachingMaterialEditor> findTeachingMaterialSetByTeachingMaterialId(String teachingMaterialId);
	//根据用户集合查找与该用户群体相关的教材立项信息。
	public List<ModelInfo<TeachingMaterialSet, TeachingMaterialEditor>> findAllTeachingMaterialSet(List<CQUPTUser> CQUPTUsers);
	
	//从指定TeachingMaterialSet集合中筛检出符合条件的TeachingMaterialSet集合
	//筛选字段为字符串类型
	public List<ModelInfo<TeachingMaterialSet, TeachingMaterialEditor>> searchTeachingMaterialSetByStringFactor(List<ModelInfo<TeachingMaterialSet, TeachingMaterialEditor>> teachingMaterialSets,String factorName,String factorValue);
	
}
