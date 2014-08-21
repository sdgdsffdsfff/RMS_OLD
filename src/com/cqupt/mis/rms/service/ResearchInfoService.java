package com.cqupt.mis.rms.service;

import java.util.List;

import com.cqupt.mis.rms.model.HumanitiesProjectDetail;
import com.cqupt.mis.rms.model.Proofs;
import com.cqupt.mis.rms.model.ScienceDetailTechProject;

/**
 * <p>Title:管理用户个人科研信息的服务层接口</p>
 * <p>Copyright:Copyright(c)2012</p>
 * <p>Company:重邮信管工作室 </p>
 * @author LvHai
 * @version 1.0
 * */
public interface ResearchInfoService {
	
	/**
	 * 根据用户ID和要查找的科研信息的modelName，找出该用户已提交的该科研的全部信息。
	 * @param userId 用户Id
	 * @param modelName 要查找该类科研信息的model名称
	 * @return 科研信息 List<Object>
	 */	
	public Object viewResearchInfo(String submitUserId, String modelName);
	
	/**
	 * 根据科研信息ID删除该信息。
	 * @param researchId 科研信息Id
	 * @param researchModelName 要查找科研信息的model名称
	 * @param researchFactor model中标志科研信息Id的参数
	 * @param memberModelName 要查找成员信息的model名称
	 * @param memberFactor model中标志成员信息id的参数
	 * @param fileBasePath 存放文件的基本路径
	 * @return boolean 删除成功返回true，否则返回false
	 */	
	public boolean deleteResearchInfo(String[] researchIds, String researchModelName, String researchFactor,
			String memberModelName, String memberFactor, String fileBasePath);
	
	/**
	 * 根据科研信息ID删除该信息。
	 * @param researchId 科研信息Id
	 * @param researchModelName 要查找基本科研信息的model名称
	 * @param researchFactor model中标志基本科研信息Id的参数
	 * @param detailModelName 要查找详细科研信息的model名称
	 * @param detailFactor model中标志详细基本信息Id的参数
	 * @param memberModelName 要查找成员信息的model名称
	 * @param memberFactor model中标志成员信息id的参数
	 * @param fileBasePath 存放文件的基本路径
	 * @return boolean 删除成功返回true，否则返回false
	 */	
	public boolean deleteResearchInfo(String[] researchIds, String researchModelName, String researchFactor, 
			String detailModelName, String detailFactor, String memberModelName, String memberFactor, String fileBasePath);
	
	/**
	 * 根据科研信息ID删除该信息。
	 * @param researchId 科研信息Id
	 * @param researchModelName 要查找科研信息的model名称
	 * @param researchFactor model中标志科研信息Id的参数
	 * @param fileBasePath 存放文件的基本路径
	 * @return boolean 删除成功返回true，否则返回false
	 */	
	public boolean deleteResearchInfo(String[] researchIds, String researchModelName, String researchFactor, String fileBasePath);
	
	/**
	 * 根据旁证材料ID删除旁证材料信息及文件
	 * @param proofIds 旁证材料ID
	 * @param fileBasePath 存放文件的基本路径
	 * @return boolean 删除成功返回true，否则返回false
	 */
	public boolean deleteProof(String[] proofIds, String fileBasePath);
	
	/**
	 * 修改个人的基本科研信息
	 * @param researchId 科研信息的ID
	 * @param researchObject 修改后的科研信息对象
	 * @return boolean 修改成功则返回true，否则返回false
	 */
	public boolean modifyResearchInfo(Object researchObject);
	
	/**
	 * 修改旁证材料信息
	 * @param proofs 旁证材料信息
	 * @return boolean 修改成功则返回true，否则返回false
	 */
	public boolean modifyProofs(List<Proofs> proofs);
	
	/**
	 * 修改科研信息成员信息
	 * @param researchId 科研信息的ID
	 * @param memberModelName 要查找成员信息的model名称
	 * @param memberFactor model中标志成员信息id的参数
	 * @param researchFactor model中标志科研信息id的参数
	 * @param flag 标志成员信息的参数
	 * @param memberListObject 成员信息列表
	 * @return boolean 修改成功则返回true，否则返回false
	 */
	public boolean modifyResearchMemberInfo(String researchId, String memberModelName, String memberFactor, String researchFactor, int flag, Object memberListObject);
	
	/**
	 * 添加项目详细信息
	 * @param object 项目的详细信息对象
	 * @param projectId 项目ID
	 * @param status 项目状态的代号
	 * @param modelName modelName
	 * @param factorName 参数名
	 * @return boolean 添加成功则返回true，否则返回false
	 */
	public boolean addProjectDetailInfo(Object object, String projectId, int status, String modelName, String factorName);
	
	/**
	 * 修改理科项目详细信息
	 * @param deatilProjectId 理科科研项目的详细信息ID
	 * @param scienceDetailTechProject 理科科研项目的详细信息
	 * @param status 状态
	 * @return void
	 */
	public void modifyScienceProjectDetailInfo(String deatilProjectId, ScienceDetailTechProject scienceDetailTechProject, int status);
	
	/**
	 * 修改人文社科项目详细信息
	 * @param id 人文社科项目的详细信息ID
	 * @param humanitiesProjectDetail 人文社科项目的详细信息
	 * @param status 状态
	 * @return void
	 */
	public void modifyHumanitiesProjectDetailInfo(int id, HumanitiesProjectDetail humanitiesProjectDetail, int status);
	
	/**
	 * 查看最新更新的理科项目详细信息
	 * @param projectId 项目的详细信息ID
	 * @return ScienceDetailTechProject 理科项目详细信息
	 */
	public ScienceDetailTechProject showScienceProjectDetailInfoByDate(String projectId);
	
	/**
	 * 查看最新更新的人文社科项目详细信息
	 * @param projectId 项目的详细信息ID
	 * @return HumanitiesProjectDetail 人文社科项目详细信息
	 */
	public HumanitiesProjectDetail showHumanitiesProjectDetailInfoByDate(String projectId);
	
}
