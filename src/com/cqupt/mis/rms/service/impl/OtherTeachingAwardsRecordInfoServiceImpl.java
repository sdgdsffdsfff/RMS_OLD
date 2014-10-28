package com.cqupt.mis.rms.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import com.cqupt.mis.rms.manager.SearchDao;
import com.cqupt.mis.rms.model.CQUPTUser;
import com.cqupt.mis.rms.model.OtherTeachingAwardsData;
import com.cqupt.mis.rms.model.OtherTeachingAwardsRecord;
import com.cqupt.mis.rms.model.OtherTeachingRecordAward;
import com.cqupt.mis.rms.service.OtherTeachingAwardsRecordInfoService;
import com.cqupt.mis.rms.service.model.ModelInfo;

public class OtherTeachingAwardsRecordInfoServiceImpl implements OtherTeachingAwardsRecordInfoService {
	//注入Dao层
	private SearchDao searchDao;
	
	@Override
	public ModelInfo<OtherTeachingAwardsRecord, OtherTeachingRecordAward> findOtherTeachingAwardsRecordInfoByAwardsId(
			String recordId) {
		ModelInfo<OtherTeachingAwardsRecord, OtherTeachingRecordAward> otherTeachingAwardsRecordInfo = new ModelInfo<OtherTeachingAwardsRecord, OtherTeachingRecordAward>();
		//查找recordId相应的其他教学奖励类信息指导教师集合
		List<OtherTeachingRecordAward> otherTeachingRecordAwards = this.searchDao.SearchObjectsByFactor("OtherTeachingRecordAward", "otherTeachingAwardsRecord.id", recordId);
		//查找recordId相应的其他教学奖励记录集合,并设置到模型中
		otherTeachingAwardsRecordInfo.setModel((OtherTeachingAwardsRecord)this.searchDao.SearchUniqueObjectsByFactor("OtherTeachingAwardsRecord", "id", recordId));
		otherTeachingAwardsRecordInfo.setModelList(otherTeachingRecordAwards);
		return otherTeachingAwardsRecordInfo;
	}

	@Override
	public List<ModelInfo<OtherTeachingAwardsRecord, OtherTeachingRecordAward>> findAllOtherTeachingAwardsRecordInfo(
			List<CQUPTUser> CQUPTUsers) {
		List<ModelInfo<OtherTeachingAwardsRecord, OtherTeachingRecordAward>> otherTeachingAwardsRecordInfos = new ArrayList<ModelInfo<OtherTeachingAwardsRecord, OtherTeachingRecordAward>>();
		List<String> recordIds = new ArrayList<String>();
		
		/*
		 * 查找管理权限内的其他教学奖励记录Id集合
		 */
		recordIds.add("null");
		for (int i=0; i<CQUPTUsers.size(); i++) {
			List<OtherTeachingRecordAward> excellentRecordAwards = searchDao.SearchObjectsByFactor("OtherTeachingRecordAward", "memberId", CQUPTUsers.get(i).getUserId());
				
			for (int j=0; j<excellentRecordAwards.size(); j++) {
				boolean b = false;
				for (int z=0; z<recordIds.size(); z++) {
					if (recordIds.get(z).equals(excellentRecordAwards.get(j).getOtherTeachingAwardsRecord().getId())) {
						b = true;
					}	
				}
				if (b == false) {
					recordIds.add(excellentRecordAwards.get(j).getOtherTeachingAwardsRecord().getId());
				}
			}
		}
		
		/*
		 * 通过已查找的记录id来查找相应的其他教学奖励信息记录
		 */
		for(int i=1; i<recordIds.size(); i++){
			otherTeachingAwardsRecordInfos.add(this.findOtherTeachingAwardsRecordInfoByAwardsId(recordIds.get(i)));
		}
		return otherTeachingAwardsRecordInfos;
	}

	@Override
	public List<ModelInfo<OtherTeachingAwardsRecord, OtherTeachingRecordAward>> searchOtherTeachingAwardsRecordInfoByStringFactor(
			List<ModelInfo<OtherTeachingAwardsRecord, OtherTeachingRecordAward>> otherTeachingAwardsInfosRecord,
			String factorName, String factorValue) {
		List<ModelInfo<OtherTeachingAwardsRecord, OtherTeachingRecordAward>> returnOtherTeachingAwardsRecordInfos = new ArrayList<ModelInfo<OtherTeachingAwardsRecord, OtherTeachingRecordAward>>();
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
		
		for(int i=0; i<otherTeachingAwardsInfosRecord.size(); i++){
			switch(num)
			{
			case 1:{
				if(otherTeachingAwardsInfosRecord.get(i).getModel().getId().indexOf(factorValue)!=-1){
					returnOtherTeachingAwardsRecordInfos.add(otherTeachingAwardsInfosRecord.get(i));
				}
				break;
			}
			case 2:{
				if(otherTeachingAwardsInfosRecord.get(i).getModel().getName().indexOf(factorValue)!=-1){
					returnOtherTeachingAwardsRecordInfos.add(otherTeachingAwardsInfosRecord.get(i));
				}
				break;
			}
			case 3:{
				int status = java.lang.Integer.parseInt(factorValue);
				if(otherTeachingAwardsInfosRecord.get(i).getModel().getStatus() == status){
					returnOtherTeachingAwardsRecordInfos.add(otherTeachingAwardsInfosRecord.get(i));
				}
				break;
			}
			case 4:{
				if(otherTeachingAwardsInfosRecord.get(i).getModel().getSubmitUser().getUserName().indexOf(factorValue)!=-1){
					returnOtherTeachingAwardsRecordInfos.add(otherTeachingAwardsInfosRecord.get(i));
				}
				break;
			}
			case 5:{
				if(otherTeachingAwardsInfosRecord.get(i).getModel().getApprovedUser().getUserName().indexOf(factorValue)!=-1){
					returnOtherTeachingAwardsRecordInfos.add(otherTeachingAwardsInfosRecord.get(i));
				}
				break;
			}
			case 6:{
				Set<OtherTeachingAwardsData> fields = otherTeachingAwardsInfosRecord.get(i).getModel().getFields();
				for(OtherTeachingAwardsData d : fields) {
					if(d.getField().getName().equals(factorName) && d.getValue().indexOf(factorValue)!=-1) {
						returnOtherTeachingAwardsRecordInfos.add(otherTeachingAwardsInfosRecord.get(i));
						break;
					}
				}
				break;
			}
			default:break;
			}
		}
		return returnOtherTeachingAwardsRecordInfos;
	}

	public SearchDao getSearchDao() {
		return searchDao;
	}

	public void setSearchDao(SearchDao searchDao) {
		this.searchDao = searchDao;
	}
}
