package com.cqupt.mis.rms.service;

import java.util.List;

import com.cqupt.mis.rms.model.CQUPTUser;
import com.cqupt.mis.rms.model.TeachAchievements;
import com.cqupt.mis.rms.model.TeachersAwards;
import com.cqupt.mis.rms.service.model.ModelInfo;

public interface TeachAchievementsService {
	//根据教学成果ID查找指定教学成果信息
	public ModelInfo<TeachAchievements, TeachersAwards> findTeachAchievementsInfoByAchievementsId(String achievementsId);
	//根据用户集合查找与该用户群体相关的教学成果信息。
	public List<ModelInfo<TeachAchievements, TeachersAwards>> findAllTeachAchievementsInfo(List<CQUPTUser> CQUPTUsers);
	
	//从指定TeachAchievementsInfo集合中筛检出符合条件的TeachAchievementsInfo集合
	//筛选字段为字符串类型
	public List<ModelInfo<TeachAchievements, TeachersAwards>> searchTeachAchievementsInfoByStringFactor(List<ModelInfo<TeachAchievements, TeachersAwards>> teachAchievementsInfos,String factorName,String factorValue);
	//筛选字段为数值类型
	public List<ModelInfo<TeachAchievements, TeachersAwards>> searchTeachAchievementsInfoByNumFactor(List<ModelInfo<TeachAchievements, TeachersAwards>> teachAchievementsInfos,String factorName,float minNum,float maxNum);
	
}
