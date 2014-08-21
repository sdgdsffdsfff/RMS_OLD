package com.cqupt.mis.rms.service;

import java.util.Date;
import java.util.List;

import com.cqupt.mis.rms.model.CQUPTUser;
import com.cqupt.mis.rms.model.HumanitiesResearchReward;
import com.cqupt.mis.rms.model.HumanitiesResearchRewardPerson;
import com.cqupt.mis.rms.service.model.ModelInfo;

public interface HumanitiesResearchRewardService {
	//根据人文社科科研获奖ID查找指定科研获奖信息
	public ModelInfo<HumanitiesResearchReward, HumanitiesResearchRewardPerson> findHumanitiesResearchRewardByResearchRewardId(String researchRewardId);
	//根据用户集合查找与该用户群体相关的科研获奖信息。
	public List<ModelInfo<HumanitiesResearchReward, HumanitiesResearchRewardPerson>> findAllHumanitiesResearchReward(List<CQUPTUser> CQUPTUsers);
	
	//从指定HumanitiesResearchRewardInfo集合中筛检出符合条件的HumanitiesResearchRewardInfo集合
	//筛选字段为字符串类型
	public List<ModelInfo<HumanitiesResearchReward, HumanitiesResearchRewardPerson>> searchHumanitiesResearchRewardByStringFactor(List<ModelInfo<HumanitiesResearchReward, HumanitiesResearchRewardPerson>> humanitiesResearchRewards,String factorName,String factorValue);
	//筛选字段为时间类型
	public List<ModelInfo<HumanitiesResearchReward, HumanitiesResearchRewardPerson>> searchHumanitiesResearchRewardByDateFactor(List<ModelInfo<HumanitiesResearchReward, HumanitiesResearchRewardPerson>> humanitiesResearchReward,String factorName,Date begin,Date end);
	
}
