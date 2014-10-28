package com.cqupt.mis.rms.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import com.cqupt.mis.rms.manager.SearchDao;
import com.cqupt.mis.rms.model.CQUPTUser;
import com.cqupt.mis.rms.model.EducationalRecordAward;
import com.cqupt.mis.rms.model.EducationalReformData;
import com.cqupt.mis.rms.model.EducationalReformRecord;
import com.cqupt.mis.rms.service.EducationalReformRecordInfoService;
import com.cqupt.mis.rms.service.model.ModelInfo;

public class EducationalReformRecordInfoServiceImpl implements EducationalReformRecordInfoService {
	//注入Dao层
	private SearchDao searchDao;
	
	@Override
	public ModelInfo<EducationalReformRecord, EducationalRecordAward> findEducationalReformRecordInfoByAwardsId(
			String recordId) {
		ModelInfo<EducationalReformRecord, EducationalRecordAward> educationalReformRecordInfo = new ModelInfo<EducationalReformRecord, EducationalRecordAward>();
		//查找recordId相应的教改结题类信息指导教师集合
		List<EducationalRecordAward> educationalRecordAwards = this.searchDao.SearchObjectsByFactor("EducationalRecordAward", "educationalReformRecord.id", recordId);
		//查找recordId相应的教改结题记录集合,并设置到模型中
		educationalReformRecordInfo.setModel((EducationalReformRecord)this.searchDao.SearchUniqueObjectsByFactor("EducationalReformRecord", "id", recordId));
		educationalReformRecordInfo.setModelList(educationalRecordAwards);
		return educationalReformRecordInfo;
	}

	@Override
	public List<ModelInfo<EducationalReformRecord, EducationalRecordAward>> findAllEducationalReformRecordInfo(
			List<CQUPTUser> CQUPTUsers) {
		List<ModelInfo<EducationalReformRecord, EducationalRecordAward>> educationalReformRecordInfos = new ArrayList<ModelInfo<EducationalReformRecord, EducationalRecordAward>>();
		List<String> recordIds = new ArrayList<String>();
		
		/*
		 * 查找管理权限内的教改结题记录Id集合
		 */
		recordIds.add("null");
		for (int i=0; i<CQUPTUsers.size(); i++) {
			List<EducationalRecordAward> educationalRecordAwards = searchDao.SearchObjectsByFactor("EducationalRecordAward", "memberId", CQUPTUsers.get(i).getUserId());
				
			for (int j=0; j<educationalRecordAwards.size(); j++) {
				boolean b = false;
				for (int z=0; z<recordIds.size(); z++) {
					if (recordIds.get(z).equals(educationalRecordAwards.get(j).getEducationalReformRecord().getId())) {
						b = true;
					}	
				}
				if (b == false) {
					recordIds.add(educationalRecordAwards.get(j).getEducationalReformRecord().getId());
				}
			}
		}
		
		/*
		 * 通过已查找的记录id来查找相应的教改结题信息记录
		 */
		for(int i=1; i<recordIds.size(); i++){
			educationalReformRecordInfos.add(this.findEducationalReformRecordInfoByAwardsId(recordIds.get(i)));
		}
		return educationalReformRecordInfos;
	}

	@Override
	public List<ModelInfo<EducationalReformRecord, EducationalRecordAward>> searchEducationalReformRecordInfoByStringFactor(
			List<ModelInfo<EducationalReformRecord, EducationalRecordAward>> educationalReformInfosRecord,
			String factorName, String factorValue) {
		List<ModelInfo<EducationalReformRecord, EducationalRecordAward>> returnEducationalReformRecordInfos = new ArrayList<ModelInfo<EducationalReformRecord, EducationalRecordAward>>();
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
		
		for(int i=0; i<educationalReformInfosRecord.size(); i++){
			switch(num)
			{
			case 1:{
				if(educationalReformInfosRecord.get(i).getModel().getId().indexOf(factorValue)!=-1){
					returnEducationalReformRecordInfos.add(educationalReformInfosRecord.get(i));
				}
				break;
			}
			case 2:{
				if(educationalReformInfosRecord.get(i).getModel().getName().indexOf(factorValue)!=-1){
					returnEducationalReformRecordInfos.add(educationalReformInfosRecord.get(i));
				}
				break;
			}
			case 3:{
				int status = java.lang.Integer.parseInt(factorValue);
				if(educationalReformInfosRecord.get(i).getModel().getStatus() == status){
					returnEducationalReformRecordInfos.add(educationalReformInfosRecord.get(i));
				}
				break;
			}
			case 4:{
				if(educationalReformInfosRecord.get(i).getModel().getSubmitUser().getUserName().indexOf(factorValue)!=-1){
					returnEducationalReformRecordInfos.add(educationalReformInfosRecord.get(i));
				}
				break;
			}
			case 5:{
				if(educationalReformInfosRecord.get(i).getModel().getApprovedUser().getUserName().indexOf(factorValue)!=-1){
					returnEducationalReformRecordInfos.add(educationalReformInfosRecord.get(i));
				}
				break;
			}
			case 6:{
				Set<EducationalReformData> fields = educationalReformInfosRecord.get(i).getModel().getFields();
				for(EducationalReformData d : fields) {
					if(d.getField().getName().equals(factorName) && d.getValue().indexOf(factorValue)!=-1) {
						returnEducationalReformRecordInfos.add(educationalReformInfosRecord.get(i));
						break;
					}
				}
				break;
			}
			default:break;
			}
		}
		return returnEducationalReformRecordInfos;
	}

	public SearchDao getSearchDao() {
		return searchDao;
	}

	public void setSearchDao(SearchDao searchDao) {
		this.searchDao = searchDao;
	}
}
