package com.cqupt.mis.rms.test.lvhai;

import java.util.ArrayList;
import java.util.List;

import com.cqupt.mis.rms.model.SciencePaper;
import com.cqupt.mis.rms.model.SciencePaperAuthor;
import com.cqupt.mis.rms.service.ResearchInfoService;
import com.cqupt.mis.rms.utils.AbstractTest;
@SuppressWarnings("unchecked")
public class ResearchInfoServiceImplTest extends AbstractTest {
	
	private ResearchInfoService researchInfoService;

	@Override
	public void init() {
		researchInfoService = (ResearchInfoService)this.configYourManager("researchInfoService");
	}

	public void testViewResearchInfo(){
		this.init();
		try {
			List<SciencePaper> list = (List<SciencePaper>)researchInfoService.viewResearchInfo("123456", "SciencePaper");
			System.out.println(list.size());
			System.out.println("测试成功！");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void testDeleteResearchInfo(){
		this.init();
		String [] ids = {};
		boolean b = researchInfoService.deleteResearchInfo(ids, "SciencePaper", "paperId", "SciencePaperAuthor", "sciencePaper","");
		System.out.println(b);
		System.out.println("测试成功！");
	}
	
	public void testModifyResearchMemberInfo(){
		this.init();
		List<SciencePaperAuthor> sciencePaperAuthors = new ArrayList<SciencePaperAuthor>();
		researchInfoService.modifyResearchMemberInfo("", "", "", "", 1, sciencePaperAuthors);
		System.out.println("测试成功！");
	}
	
	public static void main(String[] args) {
		ResearchInfoServiceImplTest r = new ResearchInfoServiceImplTest();
		//r.testViewResearchInfo();
		//r.testDeleteResearchInfo();
		r.testModifyResearchMemberInfo();
	}

}
