/**
 * 
 */
package com.cqupt.mis.rms.manager;

import java.util.List;

import com.cqupt.mis.rms.model.CQUPTCollege;

/**
 * <p>Title:管理学院信息的接口</p>
 * <p>Copyright:Copyright(c)2012</p>
 * <p>Company:重邮信管工作室 </p>
 * @author LM
 * @version 1.0
 * */
public interface CollegeInfoDao {
	/**
	 * 增加学院信息
	 * @param collegeInfo 学院信息
	 * */
	public void addCollegeInfo(CQUPTCollege collegeInfo);
	/**
	 * 修改学院信息
	 * @param collegeInfo 需要更新的实体信息
	 * */
	public void updateCollegeInfoByEntity(CQUPTCollege collegeInfo);
	/**
	 * 查询学院信息
	 * @param collegeId 学院编号
	 * @return CQUPTCollege 满足条件的学院信息
	 * */
	public CQUPTCollege findCQUPTCollegeByCollegeId(String collegeId);
	/**
	 * 根据角色信息，查找该角色下面的所有学院信息
	 * @param roleId 角色Id
	 * @return List<CQUPTCollege> 返回满足条件的学院信息列表
	 * */
	public List<CQUPTCollege> findCQUPTCollegeListByRoleId(int roleId);
	
}
