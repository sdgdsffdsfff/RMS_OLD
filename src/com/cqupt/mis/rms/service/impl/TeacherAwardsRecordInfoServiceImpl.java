package com.cqupt.mis.rms.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import com.cqupt.mis.rms.manager.SearchDao;
import com.cqupt.mis.rms.model.CQUPTUser;
import com.cqupt.mis.rms.model.StudentAwardsData;
import com.cqupt.mis.rms.model.TeachersAwardsData;
import com.cqupt.mis.rms.model.TeachersAwardsRecord;
import com.cqupt.mis.rms.model.TeachersRecordAchievements;
import com.cqupt.mis.rms.service.TeacherAwardsRecordInfoService;
import com.cqupt.mis.rms.service.model.ModelInfo;

/**
 * 查找教学成果奖奖信息的Service实现
 * @author liu
 *
 */
public class TeacherAwardsRecordInfoServiceImpl implements TeacherAwardsRecordInfoService {
	//注入Dao层
	private SearchDao searchDao;


	@Override
	public ModelInfo<TeachersAwardsRecord, TeachersRecordAchievements> findTeacherAwardsRecordInfoByAwardsId(
			String awardsId) {
		ModelInfo<TeachersAwardsRecord, TeachersRecordAchievements> teacherAwardsRecordInfo = new ModelInfo<TeachersAwardsRecord, TeachersRecordAchievements>();
		//查找awardsId相应的学生获奖指导教师集合
		List<TeachersRecordAchievements> teachersRecordAchievements = this.searchDao.SearchObjectsByFactor("TeachersRecordAchievements", "teachersAwardsRecord.id", awardsId);
		//查找awardsId相应的学生获奖记录集合,并设置到模型中
		teacherAwardsRecordInfo.setModel((TeachersAwardsRecord)this.searchDao.SearchUniqueObjectsByFactor("TeachersAwardsRecord", "id", awardsId));
		teacherAwardsRecordInfo.setModelList(teachersRecordAchievements);
		return teacherAwardsRecordInfo;
	}

	@Override
	public List<ModelInfo<TeachersAwardsRecord, TeachersRecordAchievements>> findAllTeacherAwardsRecordInfo(
			List<CQUPTUser> CQUPTUsers) {
		List<ModelInfo<TeachersAwardsRecord, TeachersRecordAchievements>> teacherAwardsRecordInfos = new ArrayList<ModelInfo<TeachersAwardsRecord, TeachersRecordAchievements>>();
		List<String> awardsIds = new ArrayList<String>();
		
		/*
		 * 查找管理权限内的学生获奖记录Id集合
		 */
		awardsIds.add("null");
		for (int i=0; i<CQUPTUsers.size(); i++) {
			List<TeachersRecordAchievements> teachersRecordAchievements = searchDao.SearchObjectsByFactor("TeachersRecordAchievements", "awardId", CQUPTUsers.get(i).getUserId());
				
			for (int j=0; j<teachersRecordAchievements.size(); j++) {
				boolean b = false;
				for (int z=0; z<awardsIds.size(); z++) {
					if (awardsIds.get(z).equals(teachersRecordAchievements.get(j).getTeachersAwardsRecord().getId())) {
						b = true;
					}	
				}
				if (b == false) {
					awardsIds.add(teachersRecordAchievements.get(j).getTeachersAwardsRecord().getId());
				}
			}
		}
		
		/*
		 * 通过已查找的记录id来查找相应的学生获奖信息记录
		 */
		for(int i=1; i<awardsIds.size(); i++){
			teacherAwardsRecordInfos.add(this.findTeacherAwardsRecordInfoByAwardsId(awardsIds.get(i)));//bug
		}
		return teacherAwardsRecordInfos;
	}


	@Override
	public List<ModelInfo<TeachersAwardsRecord, TeachersRecordAchievements>> searchTeacherAwardsRecordInfoByStringFactor(
			List<ModelInfo<TeachersAwardsRecord, TeachersRecordAchievements>> teacherAwardsRecordInfos,
			String factorName, String factorValue) {
		List<ModelInfo<TeachersAwardsRecord, TeachersRecordAchievements>> returnTeacherAwardsRecordInfos = new ArrayList<ModelInfo<TeachersAwardsRecord, TeachersRecordAchievements>>();
		int num = 0;
		//判断查找的是哪个字段
		if("recordId".equals(factorName)) {
			num = 1;
		} else if ("recordName".equals(factorName)) {
			num = 2;
		} else if("status".equals(factorName)) {	
			num = 3;
		} else if("submitUser".equals(factorName)) {
			num = 4;
		} else if("approvedUser".equals(factorName)) {
			num = 5;
		} else {		//动态字段
			num = 6;
		}
		
		for(int i=0; i<teacherAwardsRecordInfos.size(); i++){
			switch(num)
			{
			case 1:{
				if(teacherAwardsRecordInfos.get(i).getModel().getId().indexOf(factorValue)!=-1){
					returnTeacherAwardsRecordInfos.add(teacherAwardsRecordInfos.get(i));
				}
				break;
			}
			case 2:{
				if(teacherAwardsRecordInfos.get(i).getModel().getName().indexOf(factorValue)!=-1){
					returnTeacherAwardsRecordInfos.add(teacherAwardsRecordInfos.get(i));
				}
				break;
			}
			case 3:{
				int status = java.lang.Integer.parseInt(factorValue);
				if(teacherAwardsRecordInfos.get(i).getModel().getStatus() == status){
					returnTeacherAwardsRecordInfos.add(teacherAwardsRecordInfos.get(i));
				}
				break;
			}
			case 4:{
				if(teacherAwardsRecordInfos.get(i).getModel().getSubmitUser().getUserName().indexOf(factorValue)!=-1){
					returnTeacherAwardsRecordInfos.add(teacherAwardsRecordInfos.get(i));
				}
				break;
			}
			case 5:{
				if(teacherAwardsRecordInfos.get(i).getModel().getApprovedUser().getUserName().indexOf(factorValue)!=-1){
					returnTeacherAwardsRecordInfos.add(teacherAwardsRecordInfos.get(i));
				}
				break;
			}
			case 6:{
				Set<TeachersAwardsData> fields = teacherAwardsRecordInfos.get(i).getModel().getFields();
				for(TeachersAwardsData d : fields) {
					if(d.getField().getName().equals(factorName) && d.getValue().indexOf(factorValue)!=-1) {
						returnTeacherAwardsRecordInfos.add(teacherAwardsRecordInfos.get(i));
						break;
					}
				}
				break;
			}
			default:break;
			}
		}
		return returnTeacherAwardsRecordInfos;
	}
	
	
	public void setSearchDao(SearchDao searchDao) {
		this.searchDao = searchDao;
	}



}
