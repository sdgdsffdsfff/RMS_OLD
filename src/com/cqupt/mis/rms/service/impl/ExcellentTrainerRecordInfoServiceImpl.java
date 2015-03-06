package com.cqupt.mis.rms.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import com.cqupt.mis.rms.manager.SearchDao;
import com.cqupt.mis.rms.model.CQUPTUser;
import com.cqupt.mis.rms.model.ExcellentRecordAward;
import com.cqupt.mis.rms.model.ExcellentTrainerData;
import com.cqupt.mis.rms.model.ExcellentTrainerRecord;
import com.cqupt.mis.rms.service.ExcellentTrainerRecordInfoService;
import com.cqupt.mis.rms.service.model.ModelInfo;

public class ExcellentTrainerRecordInfoServiceImpl implements ExcellentTrainerRecordInfoService {
	//注入Dao层
	private SearchDao searchDao;
	
	@Override
	public ModelInfo<ExcellentTrainerRecord, ExcellentRecordAward> findExcellentTrainerRecordInfoByAwardsId(
			String recordId) {
		ModelInfo<ExcellentTrainerRecord, ExcellentRecordAward> excellentTrainerRecordInfo = new ModelInfo<ExcellentTrainerRecord, ExcellentRecordAward>();
		//查找recordId相应的优秀培训师类信息指导教师集合
		List<ExcellentRecordAward> excellentRecordAwards = this.searchDao.SearchObjectsByFactor("ExcellentRecordAward", "excellentTrainerRecord.id", recordId);
		//查找recordId相应的优秀培训师记录集合,并设置到模型中
		excellentTrainerRecordInfo.setModel((ExcellentTrainerRecord)this.searchDao.SearchUniqueObjectsByFactor("ExcellentTrainerRecord", "id", recordId));
		excellentTrainerRecordInfo.setModelList(excellentRecordAwards);
		return excellentTrainerRecordInfo;
	}

	@Override
	public List<ModelInfo<ExcellentTrainerRecord, ExcellentRecordAward>> findAllExcellentTrainerRecordInfo(
			List<CQUPTUser> CQUPTUsers) {
		List<ModelInfo<ExcellentTrainerRecord, ExcellentRecordAward>> excellentTrainerRecordInfos = new ArrayList<ModelInfo<ExcellentTrainerRecord, ExcellentRecordAward>>();
		List<String> recordIds = new ArrayList<String>();
		
		/*
		 * 查找管理权限内的优秀培训师记录Id集合
		 */
		recordIds.add("null");
		for (int i=0; i<CQUPTUsers.size(); i++) {
			List<ExcellentRecordAward> excellentRecordAwards = searchDao.SearchObjectsByFactor("ExcellentRecordAward", "memberId", CQUPTUsers.get(i).getUserId());
				
			for (int j=0; j<excellentRecordAwards.size(); j++) {
				boolean b = false;
				for (int z=0; z<recordIds.size(); z++) {
					if (recordIds.get(z).equals(excellentRecordAwards.get(j).getExcellentTrainerRecord().getId())) {
						b = true;
					}	
				}
				if (b == false) {
					recordIds.add(excellentRecordAwards.get(j).getExcellentTrainerRecord().getId());
				}
			}
		}
		
//		recordIds.add("20141223153821114");
//		recordIds.add("20141223154652257");
		/*
		 * 通过已查找的记录id来查找相应的学生获奖信息记录
		 */
		for(int i=1; i<recordIds.size(); i++){
			excellentTrainerRecordInfos.add(this.findExcellentTrainerRecordInfoByAwardsId(recordIds.get(i)));
		}
		return excellentTrainerRecordInfos;
	}

	@Override
	public List<ModelInfo<ExcellentTrainerRecord, ExcellentRecordAward>> searchExcellentTrainerRecordInfoByStringFactor(
			List<ModelInfo<ExcellentTrainerRecord, ExcellentRecordAward>> excellentTrainerRecordInfos,
			String factorName, String factorValue) {
		List<ModelInfo<ExcellentTrainerRecord, ExcellentRecordAward>> returnExcellentTrainerRecordInfos = new ArrayList<ModelInfo<ExcellentTrainerRecord, ExcellentRecordAward>>();
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
		
		for(int i=0; i<excellentTrainerRecordInfos.size(); i++){
			switch(num)
			{
			case 1:{
				if(excellentTrainerRecordInfos.get(i).getModel().getId().indexOf(factorValue)!=-1){
					returnExcellentTrainerRecordInfos.add(excellentTrainerRecordInfos.get(i));
				}
				break;
			}
			case 2:{
				if(excellentTrainerRecordInfos.get(i).getModel().getName().indexOf(factorValue)!=-1){
					returnExcellentTrainerRecordInfos.add(excellentTrainerRecordInfos.get(i));
				}
				break;
			}
			case 3:{
				int status = java.lang.Integer.parseInt(factorValue);
				if(excellentTrainerRecordInfos.get(i).getModel().getStatus() == status){
					returnExcellentTrainerRecordInfos.add(excellentTrainerRecordInfos.get(i));
				}
				break;
			}
			case 4:{
				if(excellentTrainerRecordInfos.get(i).getModel().getSubmitUser().getUserName().indexOf(factorValue)!=-1){
					returnExcellentTrainerRecordInfos.add(excellentTrainerRecordInfos.get(i));
				}
				break;
			}
			case 5:{
				if(excellentTrainerRecordInfos.get(i).getModel().getApprovedUser().getUserName().indexOf(factorValue)!=-1){
					returnExcellentTrainerRecordInfos.add(excellentTrainerRecordInfos.get(i));
				}
				break;
			}
			case 6:{
				Set<ExcellentTrainerData> fields = excellentTrainerRecordInfos.get(i).getModel().getFields();
				for(ExcellentTrainerData d : fields) {
					if(d.getField().getName().equals(factorName) && d.getValue().indexOf(factorValue)!=-1) {
						returnExcellentTrainerRecordInfos.add(excellentTrainerRecordInfos.get(i));
						break;
					}
				}
				break;
			}
			default:break;
			}
		}
		return returnExcellentTrainerRecordInfos;
	}

	public SearchDao getSearchDao() {
		return searchDao;
	}

	public void setSearchDao(SearchDao searchDao) {
		this.searchDao = searchDao;
	}

	
}
