package com.cqupt.mis.rms.test.lvhai;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.cqupt.mis.rms.manager.ResearchInfoDao;
import com.cqupt.mis.rms.model.Proofs;
import com.cqupt.mis.rms.model.ScienceDetailTechProject;
import com.cqupt.mis.rms.model.SciencePaper;
import com.cqupt.mis.rms.model.SciencePaperAuthor;
import com.cqupt.mis.rms.utils.AbstractTest;

@SuppressWarnings("unchecked")
public class ResearchInfoDaoImplTest extends AbstractTest {
	private ResearchInfoDao researchInfoDao;
	
	public void setResearchInfoDao(ResearchInfoDao researchInfoDao) {
		this.researchInfoDao = researchInfoDao;
	}

	@Override
	public void init() {
		researchInfoDao = (ResearchInfoDao)this.configYourManager("researchInfoDao");
	}

	public void testFindResearchInfoByUserIdAndModelName(){
		this.init();
		try {
			List<SciencePaper> list = (List<SciencePaper>)researchInfoDao.findResearchInfoByUserIdAndModelName("123456", "SciencePaper");
			System.out.println(list.size());
			System.out.println("测试成功！");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void testUpdateResearchInfo(){
		this.init();
		try {
			List<SciencePaper> list = (List<SciencePaper>)researchInfoDao.findResearchInfoByUserIdAndModelName("123456", "SciencePaper");
			SciencePaper s = list.get(0);
			s.setRemarks("@@@@@@@@@@@测试备注");
			s.setReturnReason("@@@@@@测试返回理由！");
			researchInfoDao.updateResearchInfo(s);
			System.out.println("测试成功！");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void testAddProof(){
		this.init();
		try {
			Proofs p = new Proofs();
			p.setDescProof("测试描述");
			p.setInfoApprovedId("2022221111122");
			p.setProofPath("path");
			p.setTimeProofUpload(new Date());
			p.setUploadContentType("type/ee");
			p.setUploadProofName("uploadname");
			p.setUploadRealName("realname");
			researchInfoDao.addProof(p);
			System.out.println("测试成功！");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void testDeleteProof(){
		this.init();
		try {
			researchInfoDao.deleteProof(9);
			System.out.println("测试成功！");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void testAddMemberInfo(){
		this.init();
		try {
			SciencePaperAuthor s = new SciencePaperAuthor();
			SciencePaper sciencePaper = new SciencePaper();
			sciencePaper.setPaperId("20120726081407985");
			s.setSciencePaper(sciencePaper);
			s.setAuthorId("xxxxxx");
			s.setMemberName("测试饭");
			s.setOrders(2);
			s.setRemarks("备注测试");
			researchInfoDao.addMemberInfo(s);
			System.out.println("测试成功！");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void testDeleteMemberInfo(){
		this.init();
		try {
			SciencePaperAuthor s = new SciencePaperAuthor();
			s.setId(3);
			researchInfoDao.deleteMemberInfo(s);
			System.out.println("测试成功！");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void testFindResearchInfoByIdAndModelNameAndFactor(){
		this.init();
		try {
			SciencePaper s = (SciencePaper)researchInfoDao.findResearchInfoByIdAndModelNameAndFactor("20120729142850563", "SciencePaper", "paperId");
			System.out.println(s.getPaperName());
			System.out.println("测试成功！");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void testFindProofByApprovedId(){
		this.init();
		try {
			List<Proofs> p = researchInfoDao.findProofByApprovedId("20120820165328518");
			System.out.println(p.size());
			System.out.println("测试成功！");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void testFindMemberByIdAndModelNameAndFactor(){
		this.init();
		try {
			List<SciencePaperAuthor> s = (List<SciencePaperAuthor>)
					researchInfoDao.findMemberByIdAndModelNameAndFactor("20120726081407985", "SciencePaperAuthor", "sciencePaper.paperId");
			System.out.println(s.size());
			System.out.println("测试成功！");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void testDeleteFile(){
		this.init();
		try {
			String fileName = "1208272209544237.jpg";
			String filePath = "D:\\Eclipse-j2ee\\workspace\\.metadata\\.plugins\\org.eclipse.wst.server.core\\tmp0\\wtpwebapps\\RMS\\upload";
			researchInfoDao.deleteFile(fileName, filePath);
			System.out.println("测试成功！");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void testFindStatusByResearchId(){
		this.init();
		try {
			String researchId = "201207260814079851";
			String modelName = "SciencePaper";
			String modelFactor = "paperId";
			int status = researchInfoDao.findStatusByResearchId(researchId, modelName, modelFactor);
			System.out.println("status:"+status);
			System.out.println("测试成功！");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void testFindDetailByIdAndModelNameAndFactor(){
		this.init();
		try {
			String researchId = "20120725000013655";
			String modelName = "ScienceDetailTechProject";
			String modelFactor = "scienceTechProject.projectId";
			List<ScienceDetailTechProject> s = (List<ScienceDetailTechProject>)researchInfoDao.findDetailByIdAndModelNameAndFactor(researchId, modelName, modelFactor);
			System.out.println("s.size:"+s.size());
			System.out.println("测试成功！");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public void testFindProofById(){
		this.init();
		try {
			int a = 20;
			Proofs p = researchInfoDao.findProofById(a);
			System.out.println(p.getProofPath());
			System.out.println("测试成功！");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public void testFindProjectDetailByDate(){
		this.init();
		try {
			String projectId = "2012091120183471";
			List<ScienceDetailTechProject> s = new ArrayList<ScienceDetailTechProject>();
			s = (List<ScienceDetailTechProject>)researchInfoDao.findProjectDetailByDate(projectId, "ScienceDetailTechProject", "scienceTechProject", "scienceTechProject.projectId");
			System.out.println(s.size());
			for(int i = 0; i<s.size(); i++){
				ScienceDetailTechProject a = new ScienceDetailTechProject();
				a = s.get(i);
				System.out.println(a.getUpdateTime());
			}
			System.out.println("测试成功！");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		ResearchInfoDaoImplTest r = new ResearchInfoDaoImplTest();
		//r.testFindResearchInfoByUserIdAndModelName();
		//r.testUpdateResearchInfo();
		//r.testAddProof();
		//r.testDeleteProof();
		//r.testAddMemberInfo();
		//r.testDeleteMemberInfo();
		//r.testFindResearchInfoByIdAndModelNameAndFactor();
		//r.testFindProofByApprovedId();
		//r.testFindMemberByIdAndModelNameAndFactor();
		//r.testDeleteFile();
		//r.testFindStatusByResearchId();
		//r.testFindDetailByIdAndModelNameAndFactor();
		//r.testFindProofById();
		r.testFindProjectDetailByDate();
	}

}
