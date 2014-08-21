package com.cqupt.mis.rms.test.lvhai;


import com.cqupt.mis.rms.manager.SubmitInfoMemberDao;
import com.cqupt.mis.rms.model.CQUPTUser;
import com.cqupt.mis.rms.model.SciencePaper;
import com.cqupt.mis.rms.model.SciencePaperAuthor;
import com.cqupt.mis.rms.utils.AbstractTest;

public class SubmitInfoMemberDaoImplTest extends AbstractTest {
	private SubmitInfoMemberDao submitInfoMemberDao;


	@Override
	public void init() {
		submitInfoMemberDao = (SubmitInfoMemberDao)this.configYourManager("submitInfoMemberDao");
	}
	
	public void setSubmitInfoMemberDao(SubmitInfoMemberDao submitInfoMemberDao) {
		this.submitInfoMemberDao = submitInfoMemberDao;
	}

	public void testFindCQUPTUserByUserName(){
		this.init();
		try {
			CQUPTUser u = submitInfoMemberDao.findCQUPTUserByUserName("爱测试");
			System.out.println(u.getUserId());
			System.out.println("测试成功！");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void testAddInfoMember(){
		this.init();
		SciencePaperAuthor sciencePaperAuthor = new SciencePaperAuthor();
		SciencePaper sciencePaper = new SciencePaper();
		sciencePaper.setPaperId("20120725103824655");
		sciencePaperAuthor.setSciencePaper(sciencePaper);
		sciencePaperAuthor.setMemberName("爱测试");
		sciencePaperAuthor.setAuthorId("123456");
		submitInfoMemberDao.addInfoMember(sciencePaperAuthor);
		try {
			
			System.out.println("测试成功！");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	public static void main(String[] args) {
		SubmitInfoMemberDaoImplTest s = new SubmitInfoMemberDaoImplTest();
		s.testFindCQUPTUserByUserName();
		s.testAddInfoMember();
	}
}
