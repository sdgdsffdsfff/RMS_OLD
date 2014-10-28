package com.cqupt.mis.rms.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import com.cqupt.mis.rms.manager.SearchDao;
import com.cqupt.mis.rms.model.CQUPTUser;
import com.cqupt.mis.rms.model.QualityProjectData;
import com.cqupt.mis.rms.model.QualityProjectRecord;
import com.cqupt.mis.rms.model.QualityRecordAward;
import com.cqupt.mis.rms.service.QualityProjectRecordInfoService;
import com.cqupt.mis.rms.service.model.ModelInfo;

public class QualityProjectRecordInfoServiceImpl implements QualityProjectRecordInfoService {
	//注入Dao层
	private SearchDao searchDao;
		
	@Override
	public ModelInfo<QualityProjectRecord, QualityRecordAward> findQualityProjectRecordInfoByAwardsId(
			String recordId) {
		ModelInfo<QualityProjectRecord, QualityRecordAward> excellentTrainerRecordInfo = new ModelInfo<QualityProjectRecord, QualityRecordAward>();
		//查找recordId相应的质量工程信息指导教师集合
		List<QualityRecordAward> qualityProjectAwards = this.searchDao.SearchObjectsByFactor("QualityRecordAward", "qualityProjectRecord.id", recordId);
		//查找recordId相应的质量工程记录集合,并设置到模型中
		excellentTrainerRecordInfo.setModel((QualityProjectRecord)this.searchDao.SearchUniqueObjectsByFactor("QualityProjectRecord", "id", recordId));
		excellentTrainerRecordInfo.setModelList(qualityProjectAwards);
		return excellentTrainerRecordInfo;
	}

	@Override
	public List<ModelInfo<QualityProjectRecord, QualityRecordAward>> findAllQualityProjectRecordInfo(
			List<CQUPTUser> CQUPTUsers) {
		List<ModelInfo<QualityProjectRecord, QualityRecordAward>> qualityProjectRecordInfos = new ArrayList<ModelInfo<QualityProjectRecord, QualityRecordAward>>();
		List<String> recordIds = new ArrayList<String>();
		
		/*
		 * 查找管理权限内的质量工程记录Id集合
		 */
		recordIds.add("null");
		for (int i=0; i<CQUPTUsers.size(); i++) {
			List<QualityRecordAward> qualityProjectAwards = searchDao.SearchObjectsByFactor("QualityRecordAward", "memberId", CQUPTUsers.get(i).getUserId());
				
			for (int j=0; j<qualityProjectAwards.size(); j++) {
				boolean b = false;
				for (int z=0; z<recordIds.size(); z++) {
					if (recordIds.get(z).equals(qualityProjectAwards.get(j).getQualityProjectRecord().getId())) {
						b = true;
					}	
				}
				if (b == false) {
					recordIds.add(qualityProjectAwards.get(j).getQualityProjectRecord().getId());
				}
			}
		}
		
		/*
		 * 通过已查找的记录id来查找相应的学生获奖信息记录
		 */
		for(int i=1; i<recordIds.size(); i++){
			qualityProjectRecordInfos.add(this.findQualityProjectRecordInfoByAwardsId(recordIds.get(i)));
		}
		return qualityProjectRecordInfos;
	}

	@Override
	public List<ModelInfo<QualityProjectRecord, QualityRecordAward>> searchQualityProjectRecordInfoByStringFactor(
			List<ModelInfo<QualityProjectRecord, QualityRecordAward>> qualityProjectInfosRecord,
			String factorName, String factorValue) {
		List<ModelInfo<QualityProjectRecord, QualityRecordAward>> returnQualityProjectRecordInfos = new ArrayList<ModelInfo<QualityProjectRecord, QualityRecordAward>>();
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
		
		for(int i=0; i<qualityProjectInfosRecord.size(); i++){
			switch(num)
			{
			case 1:{
				if(qualityProjectInfosRecord.get(i).getModel().getId().indexOf(factorValue)!=-1){
					returnQualityProjectRecordInfos.add(qualityProjectInfosRecord.get(i));
				}
				break;
			}
			case 2:{
				if(qualityProjectInfosRecord.get(i).getModel().getName().indexOf(factorValue)!=-1){
					returnQualityProjectRecordInfos.add(qualityProjectInfosRecord.get(i));
				}
				break;
			}
			case 3:{
				int status = java.lang.Integer.parseInt(factorValue);
				if(qualityProjectInfosRecord.get(i).getModel().getStatus() == status){
					returnQualityProjectRecordInfos.add(qualityProjectInfosRecord.get(i));
				}
				break;
			}
			case 4:{
				if(qualityProjectInfosRecord.get(i).getModel().getSubmitUser().getUserName().indexOf(factorValue)!=-1){
					returnQualityProjectRecordInfos.add(qualityProjectInfosRecord.get(i));
				}
				break;
			}
			case 5:{
				if(qualityProjectInfosRecord.get(i).getModel().getApprovedUser().getUserName().indexOf(factorValue)!=-1){
					returnQualityProjectRecordInfos.add(qualityProjectInfosRecord.get(i));
				}
				break;
			}
			case 6:{
				Set<QualityProjectData> fields = qualityProjectInfosRecord.get(i).getModel().getFields();
				for(QualityProjectData d : fields) {
					if(d.getField().getName().equals(factorName) && d.getValue().indexOf(factorValue)!=-1) {
						returnQualityProjectRecordInfos.add(qualityProjectInfosRecord.get(i));
						break;
					}
				}
				break;
			}
			default:break;
			}
		}
		return returnQualityProjectRecordInfos;
	}

	public SearchDao getSearchDao() {
		return searchDao;
	}

	public void setSearchDao(SearchDao searchDao) {
		this.searchDao = searchDao;
	}

	
}
