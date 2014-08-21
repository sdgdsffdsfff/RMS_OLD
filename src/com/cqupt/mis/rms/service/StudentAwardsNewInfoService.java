package com.cqupt.mis.rms.service;

import java.util.List;

import com.cqupt.mis.rms.model.CQUPTUser;
import com.cqupt.mis.rms.model.StudentAwardsNew;
import com.cqupt.mis.rms.model.StudentInstructorNew;
import com.cqupt.mis.rms.service.model.ModelInfo;

public interface StudentAwardsNewInfoService {
	//根据学生获奖ID查找指定学生获奖信息
	public ModelInfo<StudentAwardsNew, StudentInstructorNew> findStudentAwardsInfoByAwardsId(String awardsId);
	//根据用户集合查找与该用户群体相关的学生获奖信息。
	public List<ModelInfo<StudentAwardsNew, StudentInstructorNew>> findAllStudentAwardsInfo(List<CQUPTUser> CQUPTUsers);
	
	//从指定StudentAwardsInfo集合中筛检出符合条件的StudentAwardsInfo集合
	//筛选字段为字符串类型
	public List<ModelInfo<StudentAwardsNew, StudentInstructorNew>> searchStudentAwardsInfoByStringFactor(List<ModelInfo<StudentAwardsNew, StudentInstructorNew>> studentAwardsInfos,String factorName,String factorValue);
	
}
