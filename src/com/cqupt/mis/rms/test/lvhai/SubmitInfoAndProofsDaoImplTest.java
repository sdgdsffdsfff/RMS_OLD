package com.cqupt.mis.rms.test.lvhai;

import java.util.Date;

import com.cqupt.mis.rms.manager.SubmitInfoAndProofsDao;
import com.cqupt.mis.rms.model.Proofs;
import com.cqupt.mis.rms.model.SciencePaper;
import com.cqupt.mis.rms.utils.AbstractTest;
import com.cqupt.mis.rms.utils.GenerateUtils;

public class SubmitInfoAndProofsDaoImplTest extends AbstractTest {
	private SubmitInfoAndProofsDao submitInfoAndProofsDao;

	public void setSubmitInfoAndProofsDao(
			SubmitInfoAndProofsDao submitInfoAndProofsDao) {
		this.submitInfoAndProofsDao = submitInfoAndProofsDao;
	}

	@Override
	public void init() {
		submitInfoAndProofsDao = (SubmitInfoAndProofsDao)this.configYourManager("submitInfoAndProofsDao");
	}
	
	public void testAddInfo(){
		this.init();
		
		try {
			SciencePaper sciencePaper = new SciencePaper();
			sciencePaper.setPaperId(GenerateUtils.getID());
			sciencePaper.setDepartment("测试部门");
			sciencePaper.setPaperName("测试论文名称");
			submitInfoAndProofsDao.addInfo(sciencePaper);
			System.out.println("测试成功！");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void testAddProof(){
		this.init();
		try {
			Proofs proof = new Proofs();
			proof.setInfoApprovedId(GenerateUtils.getID());
			proof.setTimeProofUpload(new Date());
			proof.setDescProof("测试保存旁证材料接口");
			proof.setProofPath("测试路径");
			proof.setUploadContentType("文件类型");
			proof.setUploadProofName("文件保存的名称");
			proof.setUploadRealName("文件的真实名称");
			submitInfoAndProofsDao.addProof(proof);
			System.out.println("测试成功！");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		SubmitInfoAndProofsDaoImplTest s = new SubmitInfoAndProofsDaoImplTest();
		s.testAddInfo();
		s.testAddProof();
	}
}
