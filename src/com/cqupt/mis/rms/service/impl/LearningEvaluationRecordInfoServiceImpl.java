package com.cqupt.mis.rms.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import com.cqupt.mis.rms.manager.SearchDao;
import com.cqupt.mis.rms.model.CQUPTUser;
import com.cqupt.mis.rms.model.LearningEvaluationData;
import com.cqupt.mis.rms.model.LearningEvaluationRecord;
import com.cqupt.mis.rms.model.LearningRecordAward;
import com.cqupt.mis.rms.service.LearningEvaluationRecordInfoService;
import com.cqupt.mis.rms.service.model.ModelInfo;

public class LearningEvaluationRecordInfoServiceImpl implements LearningEvaluationRecordInfoService {
	//注入Dao层
	private SearchDao searchDao;
	
	@Override
	public ModelInfo<LearningEvaluationRecord, LearningRecordAward> findLearningEvaluationRecordInfoByAwardsId(
			String recordId) {
		ModelInfo<LearningEvaluationRecord, LearningRecordAward> learningEvaluationRecordInfo = new ModelInfo<LearningEvaluationRecord, LearningRecordAward>();
		//查找recordId相应的学评教类信息指导教师集合
		List<LearningRecordAward> learningRecordAwards = this.searchDao.SearchObjectsByFactor("LearningRecordAward", "learningEvaluationRecord.id", recordId);
		//查找recordId相应的学评教记录集合,并设置到模型中
		learningEvaluationRecordInfo.setModel((LearningEvaluationRecord)this.searchDao.SearchUniqueObjectsByFactor("LearningEvaluationRecord", "id", recordId));
		learningEvaluationRecordInfo.setModelList(learningRecordAwards);
		return learningEvaluationRecordInfo;
	}

	@Override
	public List<ModelInfo<LearningEvaluationRecord, LearningRecordAward>> findAllLearningEvaluationRecordInfo(
			List<CQUPTUser> CQUPTUsers) {
		List<ModelInfo<LearningEvaluationRecord, LearningRecordAward>> learningEvaluationRecordInfos = new ArrayList<ModelInfo<LearningEvaluationRecord, LearningRecordAward>>();
		List<String> recordIds = new ArrayList<String>();
		
		/*
		 * 查找管理权限内的优秀培训师记录Id集合
		 */
		recordIds.add("null");
		for (int i=0; i<CQUPTUsers.size(); i++) {
			List<LearningRecordAward> learningRecordAwards = searchDao.SearchObjectsByFactor("LearningRecordAward", "memberId", CQUPTUsers.get(i).getUserId());
				
			for (int j=0; j<learningRecordAwards.size(); j++) {
				boolean b = false;
				for (int z=0; z<recordIds.size(); z++) {
					if (recordIds.get(z).equals(learningRecordAwards.get(j).getLearningEvaluationRecord().getId())) {
						b = true;
					}	
				}
				if (b == false) {
					recordIds.add(learningRecordAwards.get(j).getLearningEvaluationRecord().getId());
				}
			}
		}
		
		/*
		 * 通过已查找的记录id来查找相应的学生获奖信息记录
		 */
		for(int i=1; i<recordIds.size(); i++){
			learningEvaluationRecordInfos.add(this.findLearningEvaluationRecordInfoByAwardsId(recordIds.get(i)));
		}
		return learningEvaluationRecordInfos;
	}

	@Override
	public List<ModelInfo<LearningEvaluationRecord, LearningRecordAward>> searchLearningEvaluationRecordInfoByStringFactor(
			List<ModelInfo<LearningEvaluationRecord, LearningRecordAward>> learningEvaluationInfosRecord,
			String factorName, String factorValue) {
		List<ModelInfo<LearningEvaluationRecord, LearningRecordAward>> returnLearningEvaluationRecordInfos = new ArrayList<ModelInfo<LearningEvaluationRecord, LearningRecordAward>>();
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
		
		for(int i=0; i<learningEvaluationInfosRecord.size(); i++){
			switch(num)
			{
			case 1:{
				if(learningEvaluationInfosRecord.get(i).getModel().getId().indexOf(factorValue)!=-1){
					returnLearningEvaluationRecordInfos.add(learningEvaluationInfosRecord.get(i));
				}
				break;
			}
			case 2:{
				if(learningEvaluationInfosRecord.get(i).getModel().getName().indexOf(factorValue)!=-1){
					returnLearningEvaluationRecordInfos.add(learningEvaluationInfosRecord.get(i));
				}
				break;
			}
			case 3:{
				int status = java.lang.Integer.parseInt(factorValue);
				if(learningEvaluationInfosRecord.get(i).getModel().getStatus() == status){
					returnLearningEvaluationRecordInfos.add(learningEvaluationInfosRecord.get(i));
				}
				break;
			}
			case 4:{
				if(learningEvaluationInfosRecord.get(i).getModel().getSubmitUser().getUserName().indexOf(factorValue)!=-1){
					returnLearningEvaluationRecordInfos.add(learningEvaluationInfosRecord.get(i));
				}
				break;
			}
			case 5:{
				if(learningEvaluationInfosRecord.get(i).getModel().getApprovedUser().getUserName().indexOf(factorValue)!=-1){
					returnLearningEvaluationRecordInfos.add(learningEvaluationInfosRecord.get(i));
				}
				break;
			}
			case 6:{
				Set<LearningEvaluationData> fields = learningEvaluationInfosRecord.get(i).getModel().getFields();
				for(LearningEvaluationData d : fields) {
					if(d.getField().getName().equals(factorName) && d.getValue().indexOf(factorValue)!=-1) {
						returnLearningEvaluationRecordInfos.add(learningEvaluationInfosRecord.get(i));
						break;
					}
				}
				break;
			}
			default:break;
			}
		}
		return returnLearningEvaluationRecordInfos;
	}
	
	public SearchDao getSearchDao() {
		return searchDao;
	}

	public void setSearchDao(SearchDao searchDao) {
		this.searchDao = searchDao;
	}
}
