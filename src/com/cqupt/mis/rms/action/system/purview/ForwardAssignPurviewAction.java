package com.cqupt.mis.rms.action.system.purview;

import java.util.List;

import com.cqupt.mis.rms.model.Purviewinfo;
import com.cqupt.mis.rms.model.Rolepurview;
import com.cqupt.mis.rms.service.PurviewService;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

/**
 * @author LM
 * 
 */

@SuppressWarnings("serial")
public class ForwardAssignPurviewAction extends ActionSupport {
	// 注入接口属性
	private PurviewService purviewService;
	// 注入普通属性
	private int roleId;

	public PurviewService getPurviewService() {
		return purviewService;
	}

	public void setPurviewService(PurviewService purviewService) {
		this.purviewService = purviewService;
	}

	public int getRoleId() {
		return roleId;
	}

	public void setRoleId(int roleId) {
		this.roleId = roleId;
	}

	@Override
	public String execute() throws Exception {
		// 获取userId和roleId
		String userId = (String) ActionContext.getContext().getSession().get("userId");
		int userRoleId = (Integer) ActionContext.getContext().getSession().get("roleId");
		/*
		 * bern 修改
		 * 当操作用户为管理员时，默认取出所有权限菜单，防止管理员权限丢失
		 * 找出一级菜单，parentId=0
		 */
		List<Purviewinfo> firstPurviewList;
		if(userRoleId == 1) {
			firstPurviewList = purviewService.findPurviewListByUserIdAndRoleIdAndParentIdForCommonds(0);
		}else {
			firstPurviewList = purviewService.findPurviewListByUserIdAndRoleIdAndParentIdForCommonds(userId,userRoleId, 0);
		}
		if (firstPurviewList != null) {
			StringBuffer sb = new StringBuffer();
			// 获取一级菜单
			for (Purviewinfo firstPurview : firstPurviewList) {
				sb.append("<tr>");
				sb.append("<td align=\"right\" style=\"padding-right: 20px;width:20%;\" width=\"100\">");
				// 显示一级菜单,根据该一级菜单是否被某个角色所分配，确实是否被选中
				Rolepurview rolepurview = purviewService.findRolepurviewByRoleIdAndPurviewId(roleId, firstPurview.getPurviewId());
				if(rolepurview!=null){
					sb.append("<input type=\"checkbox\" checked=\"checked\" onclick=\"parentPurview(this);\" name=\"purviewId\" value=\""
							+ firstPurview.getPurviewId()
							+ "\"/>"
							+ firstPurview.getPurviewName());
				}else{
					sb.append("<input type=\"checkbox\" onclick=\"parentPurview(this);\" name=\"purviewId\" value=\""
							+ firstPurview.getPurviewId()
							+ "\"/>"
							+ firstPurview.getPurviewName());
				}
				sb.append("</td>");
				/*
				 * bern 修改
				 * 当操作用户为管理员时，默认取出所有权限菜单，防止管理员权限丢失
				 * 获取一级菜单下面的二级菜单(根据它的PurviewId号)
				 */
				List<Purviewinfo> secondPurviewList;
				if(userRoleId == 1) {
					secondPurviewList = purviewService.findPurviewListByUserIdAndRoleIdAndParentIdForCommonds(firstPurview.getPurviewId());
				}else {
					secondPurviewList = purviewService.findPurviewListByUserIdAndRoleIdAndParentIdForCommonds(userId, userRoleId, firstPurview.getPurviewId());
				}
				if (secondPurviewList != null) {
					sb.append("<td align=\"left\">");
					for (Purviewinfo secondPurviewChild : secondPurviewList) {
						// 显示二级菜单
						Rolepurview secondRolepurview = purviewService.findRolepurviewByRoleIdAndPurviewId(roleId, secondPurviewChild.getPurviewId());
						if(secondRolepurview!=null){
							sb.append("<input type=\"checkbox\" checked=\"checked\" onclick=\"childPurview(this);\" name=\"purviewId\" value=\""
									+ secondPurviewChild.getPurviewId()
									+ "\"/>"
									+ secondPurviewChild.getPurviewName());
						}else{
							sb.append("<input type=\"checkbox\" onclick=\"childPurview(this);\" name=\"purviewId\" value=\""
									+ secondPurviewChild.getPurviewId()
									+ "\"/>"
									+ secondPurviewChild.getPurviewName());
						}
					}
					sb.append("</td>");
				} else {
					sb.append("<td>");
					sb.append("</td>");
				}
				sb.append("</tr>");
			}
			ActionContext.getContext().put("roleId", roleId);
			ActionContext.getContext().put("purviewId", sb.toString());
		}
		return SUCCESS;
	}

}
