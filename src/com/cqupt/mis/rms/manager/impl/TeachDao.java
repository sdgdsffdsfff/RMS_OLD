package com.cqupt.mis.rms.manager.impl;

import java.util.List;

import com.cqupt.mis.rms.model.CourseContributeNew;
import com.cqupt.mis.rms.model.MajorContributeNew;
import com.cqupt.mis.rms.model.StudentAwardsNew;
import com.cqupt.mis.rms.model.TeachAchievementsCQ;
import com.cqupt.mis.rms.model.TeachAchievementsNew;
import com.cqupt.mis.rms.model.TeachingMaterialSetNew;

public class TeachDao extends BaseDao {
	/**
	 * 通过信息的状态,还有上传的时间 来查找全部专业建设信息
	 * @param status
	 * @param updateTime
	 * @return
	 */
	public List<MajorContributeNew> findAllMajorContribute(int status,String updateTime){
		String str = "";
		if(status ==2){
			str = " =2 ";
		}else{
			str = " !=2 ";
		}
		String hql = "from MajorContribute mc where mc.status "+str+"  and mc.majorId like ?";
		return search(hql,updateTime+"%");
	}
	/**
	 * 通过信息的状态,还有上传的时间 来查找全部课程建设信息
	 * @param status
	 * @param updateTime
	 * @return
	 */
	public List<CourseContributeNew> findAllCourseContribute(int status, String updateTime){
		String str = "";
		if(status ==2){
			str = " =2 ";
		}else{
			str = " !=2 ";
		}
		String hql = "from CourseContribute cc where cc.status "+str+"  and cc.courseId like ?";
		return search(hql,updateTime+"%");
	}
	/**
	 * 通过信息的状态,还有上传的时间 来查找全部教学成果信息
	 * @param status
	 * @param updateTime
	 * @return
	 */
	public List<TeachAchievementsNew> findAllTeachAchievements(int status, String updateTime){
		String str = "";
		if(status ==2){
			str = " =2 ";
		}else{
			str = " !=2 ";
		}
		String hql = "from TeachAchievements ta where ta.status "+str+"  and ta.achievementsId like ? ";
		return search(hql,updateTime+"%");
	}
	
	/**
	 * 通过信息的状态,还有上传的时间 来查找全部教学成果信息
	 * @param status
	 * @param updateTime
	 * @return
	 */
	public List<TeachAchievementsCQ> findAllTeachAchievementsCQ(int status, String updateTime){
		String str = "";
		if(status ==2){
			str = " =2 ";
		}else{
			str = " !=2 ";
		}
		String hql = "from TeachAchievementsCQ ta where ta.status "+str+"  and ta.achievementsId like ? ";
		return search(hql,updateTime+"%");
	}
	
	/**
	 * 通过信息的状态,还有上传的时间 来查找全部教材立案信息
	 * @param status
	 * @param updateTime
	 * @return
	 */
	public List<TeachingMaterialSetNew> findAllTeachingMaterialSet(int status, String updateTime){
		String str = "";
		if(status ==2){
			str = " =2 ";
		}else{
			str = " !=2 ";
		}
		String hql = "from TeachingMaterialSet tm left join fetch tm.submitUser  where tm.status "+str+"  and tm.teachingMaterialId like ? ";
		return search(hql,updateTime+"%");
	}
	/**
	 * 通过信息的状态,还有上传的时间 来查找全部学生获奖信息
	 * @param status
	 * @param updateTime
	 * @return
	 */
	public List<StudentAwardsNew> findAllStudentAwards(int status, String updateTime){
		String str = "";
		if(status ==2){
			str = " =2 ";
		}else{
			str = " !=2 ";
		}
		String hql = "from StudentAwards sa where sa.status "+str+"  and sa.awardsId like ?";
		return search(hql,updateTime+"%");
	}
}
