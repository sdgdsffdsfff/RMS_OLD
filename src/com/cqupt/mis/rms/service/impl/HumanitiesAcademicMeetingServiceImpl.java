package com.cqupt.mis.rms.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.cqupt.mis.rms.manager.SearchDao;
import com.cqupt.mis.rms.model.CQUPTUser;
import com.cqupt.mis.rms.model.HumanitiesAcademicMeeting;
import com.cqupt.mis.rms.model.HumanitiesAcademicMeetingPerson;
import com.cqupt.mis.rms.service.HumanitiesAcademicMeetingService;
import com.cqupt.mis.rms.service.model.ModelInfo;

public class HumanitiesAcademicMeetingServiceImpl implements
		HumanitiesAcademicMeetingService {
	private SearchDao searchDao;
	
	public void setSearchDao(SearchDao searchDao) {
		this.searchDao = searchDao;
	}
	@Override
	public ModelInfo<HumanitiesAcademicMeeting, HumanitiesAcademicMeetingPerson> findHumanitiesAcademicMeetingByAcademicMeetingId(
			String academicMeetingId) {
		// TODO Auto-generated method stub
		ModelInfo<HumanitiesAcademicMeeting, HumanitiesAcademicMeetingPerson> humanitiesAcademicMeeting = new ModelInfo<HumanitiesAcademicMeeting, HumanitiesAcademicMeetingPerson>();
		List<HumanitiesAcademicMeetingPerson> humanitiesAcademicMeetingPersons = this.searchDao.SearchObjectsByFactor("HumanitiesAcademicMeetingPerson", "humanitiesAcademicMeeting.academicMeetingId", academicMeetingId);
		humanitiesAcademicMeeting.setModelList(humanitiesAcademicMeetingPersons);
		humanitiesAcademicMeeting.setModel((HumanitiesAcademicMeeting)this.searchDao.SearchUniqueObjectsByFactor("HumanitiesAcademicMeeting", "academicMeetingId", academicMeetingId));
		return humanitiesAcademicMeeting;
	}

	@Override
	public List<ModelInfo<HumanitiesAcademicMeeting, HumanitiesAcademicMeetingPerson>> findAllHumanitiesAcademicMeeting(
			List<CQUPTUser> CQUPTUsers) {
		// TODO Auto-generated method stub
		List<ModelInfo<HumanitiesAcademicMeeting, HumanitiesAcademicMeetingPerson>> humanitiesAcademicMeetings = new ArrayList<ModelInfo<HumanitiesAcademicMeeting, HumanitiesAcademicMeetingPerson>>();

			for (int i = 0; i < CQUPTUsers.size(); i++) {
				List<HumanitiesAcademicMeeting> HumanitiesAcademicMeetings = searchDao.SearchObjectsByFactor("HumanitiesAcademicMeeting", "submitUser.userId", CQUPTUsers.get(i).getUserId());
				for(HumanitiesAcademicMeeting HumanitiesAcademicMeeting:HumanitiesAcademicMeetings){
					humanitiesAcademicMeetings.add(this.findHumanitiesAcademicMeetingByAcademicMeetingId(HumanitiesAcademicMeeting.getAcademicMeetingId()));
				}
			}
		return humanitiesAcademicMeetings;
	}

	@Override
	public List<ModelInfo<HumanitiesAcademicMeeting, HumanitiesAcademicMeetingPerson>> searchHumanitiesAcademicMeetingByStringFactor(
			List<ModelInfo<HumanitiesAcademicMeeting, HumanitiesAcademicMeetingPerson>> humanitiesAcademicMeetings,
			String factorName, String factorValue) {
		// TODO Auto-generated method stub
		List<ModelInfo<HumanitiesAcademicMeeting, HumanitiesAcademicMeetingPerson>> humanitiesAcademicMeeting = new ArrayList<ModelInfo<HumanitiesAcademicMeeting, HumanitiesAcademicMeetingPerson>>();
		int num = 0;
		if(factorName.equals("academicMeetingId")){
			num = 1;
		}else if(factorName.equals("academicMeetingName")){
			num = 2;
		}else if(factorName.equals("hostUnit")){
			num = 3;
		}else if(factorName.equals("meetingClassify")){
			num = 4;
		}else if(factorName.equals("meetingLocation")){
			num = 5;
		}else if(factorName.equals("participantsNumber")){
			num = 6;
		}else if(factorName.equals("submitUser")){
			num = 7;
		}else if(factorName.equals("approvedUser")){
			num = 8;
		}else if(factorName.equals("status")){
			num = 9;
		}else if(factorName.equals("author")){
			num = 10;
		}else{
			System.out.println("输入的factorName值有误！您输入的factorName值："+factorName);
		}
		for(int i=0;i<humanitiesAcademicMeetings.size();i++){
			switch(num)
			{
			case 1:{
				if(humanitiesAcademicMeetings.get(i).getModel().getAcademicMeetingId().indexOf(factorValue)!=-1){
					humanitiesAcademicMeeting.add(humanitiesAcademicMeetings.get(i));
				}
				break;
			}
			case 2:{
				if(humanitiesAcademicMeetings.get(i).getModel().getAcademicMeetingName().indexOf(factorValue)!=-1){
					humanitiesAcademicMeeting.add(humanitiesAcademicMeetings.get(i));
				}
				break;
			}
			case 3:{
				if(humanitiesAcademicMeetings.get(i).getModel().getHostUnit().indexOf(factorValue)!=-1){
					humanitiesAcademicMeeting.add(humanitiesAcademicMeetings.get(i));
				}
				break;
			}
			case 4:{
				if(humanitiesAcademicMeetings.get(i).getModel().getMeetingClassify().indexOf(factorValue)!=-1){
					humanitiesAcademicMeeting.add(humanitiesAcademicMeetings.get(i));
				}
				break;
			}
			case 5:{
				if(humanitiesAcademicMeetings.get(i).getModel().getMeetingLocation().indexOf(factorValue)!=-1){
					humanitiesAcademicMeeting.add(humanitiesAcademicMeetings.get(i));
				}
				break;
			}
			case 6:{
				if(humanitiesAcademicMeetings.get(i).getModel().getParticipantsNumber().indexOf(factorValue)!=-1){
					humanitiesAcademicMeeting.add(humanitiesAcademicMeetings.get(i));
				}
				break;
			}
			case 7:{
				if(humanitiesAcademicMeetings.get(i).getModel().getSubmitUser()!=null){
					if(humanitiesAcademicMeetings.get(i).getModel().getSubmitUser().getUserName().indexOf(factorValue)!=-1){
						humanitiesAcademicMeeting.add(humanitiesAcademicMeetings.get(i));
					}
				}
				break;
			}
			case 8:{
				if(humanitiesAcademicMeetings.get(i).getModel().getApprovedUser()!=null){
					if(humanitiesAcademicMeetings.get(i).getModel().getApprovedUser().getUserName().indexOf(factorValue)!=-1){
						humanitiesAcademicMeeting.add(humanitiesAcademicMeetings.get(i));
					}
				}
				break;
			}
			case 9:{
				int status = java.lang.Integer.parseInt(factorValue);
				if(humanitiesAcademicMeetings.get(i).getModel().getStatus()==status){
					humanitiesAcademicMeeting.add(humanitiesAcademicMeetings.get(i));
				}
				break;
			}
			case 10:{
				for(int j=0;j<humanitiesAcademicMeetings.get(i).getModelList().size();j++){
					if(humanitiesAcademicMeetings.get(i).getModelList().get(j).getMeetingPersonName().indexOf(factorValue)!=-1){
						humanitiesAcademicMeeting.add(humanitiesAcademicMeetings.get(i));
						break;
					}
				}
				break;
			}
			default:break;
			}
		}
		return humanitiesAcademicMeeting;
	}

	@Override
	public List<ModelInfo<HumanitiesAcademicMeeting, HumanitiesAcademicMeetingPerson>> searchHumanitiesAcademicMeetingByDateFactor(
			List<ModelInfo<HumanitiesAcademicMeeting, HumanitiesAcademicMeetingPerson>> humanitiesAcademicMeetings,
			String factorName, Date begin, Date end) {
		// TODO Auto-generated method stub
		List<ModelInfo<HumanitiesAcademicMeeting, HumanitiesAcademicMeetingPerson>> humanitiesAcademicMeeting = new ArrayList<ModelInfo<HumanitiesAcademicMeeting, HumanitiesAcademicMeetingPerson>>();
		int num = 0;
		if(factorName.equals("holdingTime")){
			num = 1;
		}else{
			System.out.println("输入的factorName值有误！您输入的factorName值："+factorName);
		}
		
		for(int i=0;i<humanitiesAcademicMeetings.size();i++){
			switch(num)
			{
			case 1:{
				if(humanitiesAcademicMeetings.get(i).getModel().getHoldingTime().after(begin)&&humanitiesAcademicMeetings.get(i).getModel().getHoldingTime().before(end)){
					humanitiesAcademicMeeting.add(humanitiesAcademicMeetings.get(i));
				}
				break;
			}
			default:break;
			}
		}
		return humanitiesAcademicMeeting;
	}

}
