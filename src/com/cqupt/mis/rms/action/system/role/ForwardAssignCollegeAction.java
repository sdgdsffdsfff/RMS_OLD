/**
 * 
 */
package com.cqupt.mis.rms.action.system.role;

import java.util.List;

import com.cqupt.mis.rms.model.CQUPTCollege;
import com.cqupt.mis.rms.service.PurviewService;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

/**
 * @author lim
 * 
 */
@SuppressWarnings("serial")
public class ForwardAssignCollegeAction extends ActionSupport {
	// 注入角色Id属性
	private int roleId;
	// 注入权限服务层接口
	private PurviewService purviewService;

	public void setPurviewService(PurviewService purviewService) {
		this.purviewService = purviewService;
	}

	public void setRoleId(int roleId) {
		this.roleId = roleId;
	}

	@Override
	public String execute() throws Exception {
		// 获取userId和roleId
		int userRoleId = (Integer) ActionContext.getContext().getSession()
				.get("roleId");
		// 找出一级菜单，parentId=0
		List<CQUPTCollege> collegeList = purviewService
				.findCQUPTCollegeListByRoleId(userRoleId);
		if (collegeList != null) {
			StringBuffer sb = new StringBuffer();
			// 获取一级菜单
			for (CQUPTCollege college : collegeList) {
				sb.append("<tr>");
				sb.append("<td align=\"left\" style=\"padding-left: 80px;\" width=\"100\">");
				// 显示一级菜单
				sb.append("<input type=\"checkbox\"  name=\"collegeId\" value=\""
						+ college.getCollegeId()
						+ "\"/>"
						+ college.getCollegeName());
				sb.append("</td>");
				sb.append("</tr>");
			}
			ActionContext.getContext().put("roleId", roleId);
			ActionContext.getContext().put("collegeId", sb.toString());
		}
		return SUCCESS;
	}

}
