package com.cqupt.mis.rms.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import com.cqupt.mis.rms.manager.SearchDao;
import com.cqupt.mis.rms.model.CQUPTUser;
import com.cqupt.mis.rms.model.MajorContributeData;
import com.cqupt.mis.rms.model.MajorContributeRecord;
import com.cqupt.mis.rms.model.MajorRecordMember;
import com.cqupt.mis.rms.service.MajorContributeRecordInfoService;
import com.cqupt.mis.rms.service.model.ModelInfo;

/**
 * 查找专业建设信息的Service实现
 * @author Bern
 *
 */
public class MajorContributeRecordInfoServiceImpl implements MajorContributeRecordInfoService {
	//注入Dao层
	private SearchDao searchDao;
		
	@Override
	public ModelInfo<MajorContributeRecord, MajorRecordMember> findMajorContributeRecordInfoByRecordId(
			String recordId) {
		ModelInfo<MajorContributeRecord, MajorRecordMember> majorContributeRecordInfo = new ModelInfo<MajorContributeRecord, MajorRecordMember>();
		//查找awardsId相应的学生获奖指导教师集合
		List<MajorRecordMember> majorRecordMembers = this.searchDao.SearchObjectsByFactor("MajorRecordMember", "majorContributeRecord.id", recordId);
		//查找awardsId相应的学生获奖记录集合,并设置到模型中
		majorContributeRecordInfo.setModel((MajorContributeRecord)this.searchDao.SearchUniqueObjectsByFactor("MajorContributeRecord", "id", recordId));
		majorContributeRecordInfo.setModelList(majorRecordMembers);
		return majorContributeRecordInfo;
	}

	@Override
	public List<ModelInfo<MajorContributeRecord, MajorRecordMember>> findAllMajorContributeRecordInfo(
			List<CQUPTUser> CQUPTUsers) {
		List<ModelInfo<MajorContributeRecord, MajorRecordMember>> majorContributeRecordInfos = new ArrayList<ModelInfo<MajorContributeRecord, MajorRecordMember>>();
		List<String> recordIds = new ArrayList<String>();
		
		/*
		 * 查找管理权限内的学生获奖记录Id集合
		 */
		recordIds.add("null");
		for (int i=0; i<CQUPTUsers.size(); i++) {
			List<MajorRecordMember> majorRecordMembers = searchDao.SearchObjectsByFactor("MajorRecordMember", "memberId", CQUPTUsers.get(i).getUserId());
				
			for (int j=0; j<majorRecordMembers.size(); j++) {
				boolean b = false;
				for (int z=0; z<recordIds.size(); z++) {
					if (recordIds.get(z).equals(majorRecordMembers.get(j).getMajorContributeRecord().getId())) {
						b = true;
					}	
				}
				if (b == false) {
					recordIds.add(majorRecordMembers.get(j).getMajorContributeRecord().getId());
				}
			}
		}
		
//		recordIds.add("20141211112610517");
//		recordIds.add("20141221235455446");
//		recordIds.add("20141230121217347");
//		recordIds.add("20141211140443410");
		/*
		 * 通过已查找的记录id来查找相应的学生获奖信息记录
		 */
		for(int i=1; i<recordIds.size(); i++){
			majorContributeRecordInfos.add(this.findMajorContributeRecordInfoByRecordId(recordIds.get(i)));
		}
		return majorContributeRecordInfos;
	}

	@Override
	public List<ModelInfo<MajorContributeRecord, MajorRecordMember>> searchMajorContributeRecordInfoByStringFactor(
			List<ModelInfo<MajorContributeRecord, MajorRecordMember>> majorContributeRecordInfos,
			String factorName, String factorValue) {
		List<ModelInfo<MajorContributeRecord, MajorRecordMember>> returnMajorContributeRecordInfos = new ArrayList<ModelInfo<MajorContributeRecord, MajorRecordMember>>();
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
		
		for(int i=0; i<majorContributeRecordInfos.size(); i++){
			switch(num)
			{
			case 1:{
				if(majorContributeRecordInfos.get(i).getModel().getId().indexOf(factorValue)!=-1){
					returnMajorContributeRecordInfos.add(majorContributeRecordInfos.get(i));
				}
				break;
			}
			case 2:{
				if(majorContributeRecordInfos.get(i).getModel().getName().indexOf(factorValue)!=-1){
					returnMajorContributeRecordInfos.add(majorContributeRecordInfos.get(i));
				}
				break;
			}
			case 3:{
				int status = java.lang.Integer.parseInt(factorValue);
				if(majorContributeRecordInfos.get(i).getModel().getStatus() == status){
					returnMajorContributeRecordInfos.add(majorContributeRecordInfos.get(i));
				}
				break;
			}
			case 4:{
				if(majorContributeRecordInfos.get(i).getModel().getSubmitUser().getUserName().indexOf(factorValue)!=-1){
					returnMajorContributeRecordInfos.add(majorContributeRecordInfos.get(i));
				}
				break;
			}
			case 5:{
				if(majorContributeRecordInfos.get(i).getModel().getApprovedUser().getUserName().indexOf(factorValue)!=-1){
					returnMajorContributeRecordInfos.add(majorContributeRecordInfos.get(i));
				}
				break;
			}
			case 6:{
				Set<MajorContributeData> fields = majorContributeRecordInfos.get(i).getModel().getFields();
				for(MajorContributeData d : fields) {
					if(d.getField().getName().equals(factorName) && d.getValue().indexOf(factorValue)!=-1) {
						returnMajorContributeRecordInfos.add(majorContributeRecordInfos.get(i));
						break;
					}
				}
				break;
			}
			default:break;
			}
		}
		return returnMajorContributeRecordInfos;
	}
	
	public void setSearchDao(SearchDao searchDao) {
		this.searchDao = searchDao;
	}
}
