/**
 * 
 */
package com.cqupt.mis.rms.test;

import java.util.List;

import com.cqupt.mis.rms.manager.PurviewDao;
import com.cqupt.mis.rms.model.Purviewinfo;
import com.cqupt.mis.rms.utils.AbstractTest;

/**
 * 测试模块信息接口
 * @author lim
 *
 */
public class PurviewDaoImplTest extends AbstractTest {
	private PurviewDao purviewDao;
	
	@Override
	public void init() {
		purviewDao = (PurviewDao)this.configYourManager("purviewDao");
	}

	public void testFindPurviewListByUserIdAndRoleIdForCommonds() {
		init();
		try {
			List<Purviewinfo> list = purviewDao.findPurviewListByUserIdAndRoleIdForCommonds("limin", 2);
			if(!list.isEmpty()){
				for(Purviewinfo p : list){
					//System.out.println("编号为："+p.getPurviewId());
					//打印出该角色所含有的一级菜单
					if(p.getParentPurviewinfo()==null){
						System.out.println("编号为："+p.getPurviewId());
					}
				}
			}else{
				System.out.println("没有找到记录！");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void testFindPurviewListByUserIdAndRoleIdAndParentIdForCommonds() {
		init();
		try {
			List<Purviewinfo> list = purviewDao.findPurviewListByUserIdAndRoleIdAndParentIdForCommonds("limin", 1,3);
			if(!list.isEmpty()){
				for(Purviewinfo p : list){
					System.out.println("编号为："+p.getPurviewId());
				}
			}else{
				System.out.println("没有找到记录！");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void testFindPurviewListByparentId() {
		init();
		try {
			List<Purviewinfo> list = purviewDao.findPurviewListByparentId(2);
			if(!list.isEmpty()){
				for(Purviewinfo p : list){
					System.out.println("编号为："+p.getPurviewId());
				}
			}else{
				System.out.println("没有找到记录！");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void testAddPurviewInfo() {
		init();
		Purviewinfo purview = new Purviewinfo();
		purview.setParentPurviewinfo(null);
		purview.setPurviewName("测试管理2");
		purview.setPurviewRemark("二级菜单");
		purview.setPurviewUrl(null);
		try {
			purviewDao.addPurviewInfo(purview);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void testUpdatePurview() {
		init();
		try {
			Purviewinfo purview = purviewDao.findPurviewByPurviewId(18);
			Purviewinfo parent = purviewDao.findPurviewByPurviewId(5);
			purview.setParentPurviewinfo(parent);
			purview.setPurviewRemark("二级菜单");
			purviewDao.updatePurview(purview);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void testDeletePurview() {
		init();
		try {
			purviewDao.deletePurview(21);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void testDeletePurviewArray() {
		init();
		try {
			int[] array = {19,20};
			purviewDao.deletePurviewArray(array);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void testFindPurviewByPurviewId() {
		init();
		try {
			Purviewinfo purview = purviewDao.findPurviewByPurviewId(18);
			System.out.println("编号为："+purview.getPurviewName());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void testFindPurviewListByUserIdAndRoleIdUsePage() {
		init();
		try {
			List<Purviewinfo> list = purviewDao.findPurviewListByUserIdAndRoleIdUsePage("limin", 2, 5, 5);
			if(!list.isEmpty()){
				for(Purviewinfo p : list){
					System.out.println("名称为："+p.getPurviewId());
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void testFindPurviewListNumber() {
		init();
		try {
			purviewDao.findPurviewListByUserIdAndRoleIdUsePage("limin", 2, 0, 5);
			System.out.println("记录总数为："+purviewDao.findPurviewListNumber());
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
	}
}
