package com.cqupt.mis.rms.service;
/**
 * 教学类信息的Service层接口
 * @author Bern
 *
 */
public interface ResearchRecordInfoService {
	
	/**
	 * 根据科研信息ID删除该信息。
	 * @param researchId 科研信息Id
	 * @param researchModelName 要查找动态记录类的类名
	 * @param memberModelName 要查找成员信息的model名称
	 * @param dynamicDataModelName 要查找的动态字段值类类名
	 * @param memberFactor model中标志成员信息id的参数
	 * @param fileBasePath 存放文件的基本路径
	 * @return boolean 删除成功返回true，否则返回false
	 */	
	public boolean deleteResearchInfo(String[] researchIds, String recordModelName, String memberModelName, 
			String dynamicDataModelName, String dynamicDataModelFactorName, String memberFactor, String fileBasePath);
}
