package com.cqupt.mis.rms.manager;

import java.util.List;

import com.cqupt.mis.rms.model.CQUPTUser;
import com.cqupt.mis.rms.model.Proofs;

/**
 * <p>Title:管理用户个人科研信息的接口</p>
 * <p>Copyright:Copyright(c)2012</p>
 * <p>Company:重邮信管工作室 </p>
 * @author LvHai
 * @version 1.0
 * */
public interface ResearchInfoDao {

	/**
	 * 根据用户ID和要查找的科研信息的modelName，找出该用户已提交的该科研的全部信息。
	 * @param userId 用户Id
	 * @param modelName 要查找该类科研信息的model名称
	 * @return 科研信息 List<Object>
	 */	
	public Object findResearchInfoByUserIdAndModelName(String submitUserId, String modelName);
	
	/**
	 * 更新科研信息
	 * @param object 科研信息
	 * @return void
	 */	
	public void updateResearchInfo(Object object);
	
	/**
	 * 删除科研信息
	 * @param object 科研信息
	 * @return void
	 */	
	public void deleteResearchInfo(Object object);
	
	/**
	 * 根据科研信息Id删除科研信息
	 * @param researchId 科研信息Id
	 * @param researchModelName 要查找科研信息的model名称
	 * @param researchFactor model中标志科研信息Id的参数
	 * @return void
	 */	
	public void deleteInfoByResearchId(String researchId, String researchModelName, String researchFactor);
	
	/**
	*增加一条关于旁证材料的信息
	*@param proof 旁证材料信息
	*@return void
	*/
	public void addProof(Proofs proof);
	
	/**
	*根据旁证材料的ID删除该条旁证材料
	*@param proofId 旁证材料信息
	*@return void
	*/
	public void deleteProof(int proofId);
	
	/**
	 *根据科研信息的ID删除旁证材料
	 *@param researchId 科研信息Id
	 *@return void
	 */
	public void deleteProofByResearchId(String researchId);
	
	/**
	*增加一条科研信息成员的信息
	*@param object 科研成员对象
	*@return void
	*/
	public void addMemberInfo(Object object);
	
	/**
	*根据科研成员对象的标志ID删除该成员信息
	*@param object
	*@return void
	*/
	public void deleteMemberInfo(Object object);
	
	/**
	 *根据科研信息ID删除该科研信息的成员信息
	 *@param researchId 科研信息Id
	 *@param memberModelName 要查找成员信息的model名称
	 *@param memberFactor model中标志成员信息id的参数
	 *@return void
	 */
	public void deleteMemberInfoByResearchId(String researchId, String memberModelName, String memberFactor, String researchFactor);
	
	/**
	 * 查找科研信息
	 * @param modelId 要查找的科研信息的ID
	 * @param modelName 要查找的科研信息对应的model
	 * @param modelFactor model中标志ID的参数
	 * return Object
	 */
	public Object findResearchInfoByIdAndModelNameAndFactor(String modelId, String modelName, String modelFactor);
	/**
	 * 查找科研信息
	 * @param modelId 要查找的科研信息的ID
	 * @param modelName 要查找的科研信息对应的model
	 * @param modelFactor model中标志ID的参数
	 * return Object
	 */
	public Object findResearchInfoByIdAndModelNameAndFactor(int modelId, String modelName, String modelFactor);
	
	/**
	 * 查找旁证材料信息
	 * @param approvedId 被证明的材料的ID
	 * return List<Proofs>
	 */
	public List<Proofs> findProofByApprovedId(String approvedId);
	
	/**
	 * 查找成员信息
	 * @param researchId 与成员信息相关联的科研信息ID
	 * @param modelName 记录该类科研信息的成员model
	 * @param modelFactor 标记科研信息Id的参数
	 * return Object
	 */
	public Object findMemberByIdAndModelNameAndFactor(String researchId, String modelName, String modelFactor);
	
	/**
	 * 删除文件
	 * @param fileName 文件名称
	 * @param path 存放文件的路径
	 * return boolean 删除成功返回true，失败返回false
	 */
	public boolean deleteFile(String fileName, String filePath);
	
	/**
	 *根据科研信息ID删除该科研信息的成员信息
	 *@param researchId 科研信息Id
	 *@param detailModelName 要查找详细科研信息的model名称
	 *@param detailFactor model中标志详细科研信息id的参数
	 *@return void
	 */
	public void deleteDetailInfoByResearchId(String researchId, String detailModelName, String detailFactor, String researchFactor);
	
	/**
	 * 根据科研信息ID查找该信息的状态
	 * @param researchId 与成员信息相关联的科研信息ID
	 * @param modelName 记录该类科研信息的成员model
	 * @param modelFactor 标记科研信息Id的参数
	 * */
	public int findStatusByResearchId(String researchId, String modelName, String modelFactor);
	
	/**
	 * 查找详细科研信息
	 * @param researchId 与详细科研信息相关联的基本科研信息ID
	 * @param modelName 记录该详细科研信息的model
	 * @param modelFactor 标记科研信息Id的参数
	 * return Object
	 */
	public Object findDetailByIdAndModelNameAndFactor(String researchId, String modelName, String modelFactor);
	
	/**
	 * 根据旁证材料ID查找旁证材料信息
	 * @param proofId 旁证材料ID
	 * @return Proofs 旁证材料信息
	 * */
	public Proofs findProofById(int proofId);
	
	/**
	* 根据姓名返回该成员的信息
	* @param String 成员姓名
	* @return 存在该用户信息返回List<CQUPTUser> 不存在则返回空
	*/
	public CQUPTUser findCQUPTUserByUserName(String userNmae);
	
	/**
	 * 添加一条项目详细信息
	 * @param object 项目详细信息对象
	 * @return void
	 */
	public void addProjectDetailInfo(Object object);
	
	/**
	 * 更新项目信息的状态
	 * @param projectId 项目ID
	 * @param status 状态代号
	 * @param modelName model名字
	 * @param factorName 参数名字
	 * @return void
	 */
	public void updateProjectDetailStatus(String projectId, int status, String modelName, String factorName);
	
	/**
	 * 根据最新更新日期查找一条最新的项目信息记录
	 * @param projectId 项目ID
	 * @param modelName model名字
	 * @param factorName 参数名字
	 * @return void
	 */
	public Object findProjectDetailByDate(String projectId, String modelName, String factorName, String iDFactorName);
}
