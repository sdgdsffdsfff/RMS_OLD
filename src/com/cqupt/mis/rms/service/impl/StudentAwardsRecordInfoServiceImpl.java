package com.cqupt.mis.rms.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import com.cqupt.mis.rms.manager.SearchDao;
import com.cqupt.mis.rms.model.CQUPTUser;
import com.cqupt.mis.rms.model.StudentAwards;
import com.cqupt.mis.rms.model.StudentAwardsData;
import com.cqupt.mis.rms.model.StudentAwardsRecord;
import com.cqupt.mis.rms.model.StudentInstructor;
import com.cqupt.mis.rms.model.StudentRecordInstructor;
import com.cqupt.mis.rms.service.StudentAwardsRecordInfoService;
import com.cqupt.mis.rms.service.model.ModelInfo;

/**
 * 查找学生获奖信息的Service实现
 * @author Bern
 *
 */
public class StudentAwardsRecordInfoServiceImpl implements StudentAwardsRecordInfoService {
	//注入Dao层
	private SearchDao searchDao;
	
	@Override
	public ModelInfo<StudentAwardsRecord, StudentRecordInstructor> findStudentAwardsRecordInfoByAwardsId(
			String awardsId) {
		ModelInfo<StudentAwardsRecord, StudentRecordInstructor> studentAwardsRecordInfo = new ModelInfo<StudentAwardsRecord, StudentRecordInstructor>();
		//查找awardsId相应的学生获奖指导教师集合
		List<StudentRecordInstructor> studentRecordInstructors = this.searchDao.SearchObjectsByFactor("StudentRecordInstructor", "studentAwardsRecord.id", awardsId);
		//查找awardsId相应的学生获奖记录集合,并设置到模型中
		studentAwardsRecordInfo.setModel((StudentAwardsRecord)this.searchDao.SearchUniqueObjectsByFactor("StudentAwardsRecord", "id", awardsId));
		studentAwardsRecordInfo.setModelList(studentRecordInstructors);
		return studentAwardsRecordInfo;
	}

	@Override
	public List<ModelInfo<StudentAwardsRecord, StudentRecordInstructor>> findAllStudentAwardsRecordInfo(
			List<CQUPTUser> CQUPTUsers) {
		List<ModelInfo<StudentAwardsRecord, StudentRecordInstructor>> studentAwardsRecordInfos = new ArrayList<ModelInfo<StudentAwardsRecord, StudentRecordInstructor>>();
		List<String> awardsIds = new ArrayList<String>();
		
		/*
		 * 查找管理权限内的学生获奖记录Id集合
		 */
		awardsIds.add("null");
		for (int i=0; i<CQUPTUsers.size(); i++) {
			List<StudentRecordInstructor> studentRecordInstructors = searchDao.SearchObjectsByFactor("StudentRecordInstructor", "instructorId", CQUPTUsers.get(i).getUserId());
				
			for (int j=0; j<studentRecordInstructors.size(); j++) {
				boolean b = false;
				for (int z=0; z<awardsIds.size(); z++) {
					if (awardsIds.get(z).equals(studentRecordInstructors.get(j).getStudentAwardsRecord().getId())) {
						b = true;
					}	
				}
				if (b == false) {
					awardsIds.add(studentRecordInstructors.get(j).getStudentAwardsRecord().getId());
				}
			}
		}
		
		/*
		 * 通过已查找的记录id来查找相应的学生获奖信息记录
		 */
		for(int i=1; i<awardsIds.size(); i++){
			studentAwardsRecordInfos.add(this.findStudentAwardsRecordInfoByAwardsId(awardsIds.get(i)));
		}
		return studentAwardsRecordInfos;
	}

	@Override
	public List<ModelInfo<StudentAwardsRecord, StudentRecordInstructor>> searchStudentAwardsRecordInfoByStringFactor(
			List<ModelInfo<StudentAwardsRecord, StudentRecordInstructor>> studentAwardsRecordInfos,
			String factorName, String factorValue) {
		List<ModelInfo<StudentAwardsRecord, StudentRecordInstructor>> returnStudentAwardsRecordInfos = new ArrayList<ModelInfo<StudentAwardsRecord, StudentRecordInstructor>>();
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
		
		for(int i=0; i<studentAwardsRecordInfos.size(); i++){
			switch(num)
			{
			case 1:{
				if(studentAwardsRecordInfos.get(i).getModel().getId().indexOf(factorValue)!=-1){
					returnStudentAwardsRecordInfos.add(studentAwardsRecordInfos.get(i));
				}
				break;
			}
			case 2:{
				if(studentAwardsRecordInfos.get(i).getModel().getName().indexOf(factorValue)!=-1){
					returnStudentAwardsRecordInfos.add(studentAwardsRecordInfos.get(i));
				}
				break;
			}
			case 3:{
				int status = java.lang.Integer.parseInt(factorValue);
				if(studentAwardsRecordInfos.get(i).getModel().getStatus() == status){
					returnStudentAwardsRecordInfos.add(studentAwardsRecordInfos.get(i));
				}
				break;
			}
			case 4:{
				if(studentAwardsRecordInfos.get(i).getModel().getSubmitUser().getUserName().indexOf(factorValue)!=-1){
					returnStudentAwardsRecordInfos.add(studentAwardsRecordInfos.get(i));
				}
				break;
			}
			case 5:{
				if(studentAwardsRecordInfos.get(i).getModel().getApprovedUser().getUserName().indexOf(factorValue)!=-1){
					returnStudentAwardsRecordInfos.add(studentAwardsRecordInfos.get(i));
				}
				break;
			}
			case 6:{
				Set<StudentAwardsData> fields = studentAwardsRecordInfos.get(i).getModel().getFields();
				for(StudentAwardsData d : fields) {
					if(d.getField().getName().equals(factorName) && d.getValue().indexOf(factorValue)!=-1) {
						returnStudentAwardsRecordInfos.add(studentAwardsRecordInfos.get(i));
						break;
					}
				}
				break;
			}
			default:break;
			}
		}
		return returnStudentAwardsRecordInfos;
	}

	public void setSearchDao(SearchDao searchDao) {
		this.searchDao = searchDao;
	}
}
