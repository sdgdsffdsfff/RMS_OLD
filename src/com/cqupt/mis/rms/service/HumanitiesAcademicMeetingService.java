package com.cqupt.mis.rms.service;

import java.util.Date;
import java.util.List;

import com.cqupt.mis.rms.model.CQUPTUser;
import com.cqupt.mis.rms.model.HumanitiesAcademicMeeting;
import com.cqupt.mis.rms.model.HumanitiesAcademicMeetingPerson;
import com.cqupt.mis.rms.service.model.ModelInfo;

public interface HumanitiesAcademicMeetingService {
	//根据人文社科学术会议ID查找指定学术会议信息
	public ModelInfo<HumanitiesAcademicMeeting, HumanitiesAcademicMeetingPerson> findHumanitiesAcademicMeetingByAcademicMeetingId(String academicMeetingId);
	//根据用户集合查找与该用户群体相关的学术会议信息。
	public List<ModelInfo<HumanitiesAcademicMeeting, HumanitiesAcademicMeetingPerson>> findAllHumanitiesAcademicMeeting(List<CQUPTUser> CQUPTUsers);
	
	//从指定HumanitiesAcademicMeeting集合中筛检出符合条件的HumanitiesAcademicMeeting集合
	//筛选字段为字符串类型
	public List<ModelInfo<HumanitiesAcademicMeeting, HumanitiesAcademicMeetingPerson>> searchHumanitiesAcademicMeetingByStringFactor(List<ModelInfo<HumanitiesAcademicMeeting, HumanitiesAcademicMeetingPerson>> humanitiesAcademicMeetings,String factorName,String factorValue);
	//筛选字段为时间类型
	public List<ModelInfo<HumanitiesAcademicMeeting, HumanitiesAcademicMeetingPerson>> searchHumanitiesAcademicMeetingByDateFactor(List<ModelInfo<HumanitiesAcademicMeeting, HumanitiesAcademicMeetingPerson>> humanitiesAcademicMeetings,String factorName,Date begin,Date end);
	
}
