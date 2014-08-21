<%@page import="com.opensymphony.xwork2.ActionContext"%>
<%@page import="java.util.List"%>
<%@page import="com.cqupt.mis.rms.model.*"%>
<%@page import="com.cqupt.mis.rms.service.model.*"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%-- <%    
      String path = request.getContextPath();
      String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
       
%>
<base href="<%=basePath%>"> --%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<!-- <html xmlns="http://www.w3.org/1999/xhtml"> -->
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>理工类论文查询</title>
	<link href="lib/ligerUI/skins/Aqua/css/ligerui-all.css" rel="stylesheet" type="text/css" />
	<link href="lib/ligerUI/skins/ligerui-icons.css" rel="stylesheet" type="text/css" />
    <link href="css/Data.css" rel="stylesheet" type="text/css" />
    <link href="css/search.css" rel="stylesheet" type="text/css" />
    <script src="lib/jquery/jquery-1.5.2.min.js" type="text/javascript"></script> 
    <script src="lib/ligerUI/js/core/base.js" type="text/javascript"></script>
    <script src="lib/ligerUI/js/plugins/ligerGrid.js" type="text/javascript"></script> 
    <script src="lib/ligerUI/js/plugins/ligerTextBox.js" type="text/javascript"></script>
    <script src="lib/ligerUI/js/plugins/ligerCheckBox.js" type="text/javascript"></script>
    <script src="lib/ligerUI/js/plugins/ligerMenu.js" type="text/javascript"></script>
    <script src="lib/ligerUI/js/plugins/ligerComboBox.js" type="text/javascript"></script>
    <script src="lib/ligerUI/js/plugins/ligerMenuBar.js" type="text/javascript"></script>
    <script src="lib/ligerUI/js/plugins/ligerToolBar.js" type="text/javascript"></script>
    <script src="lib/ligerUI/js/plugins/ligerButton.js" type="text/javascript"></script>
    <script src="lib/ligerUI/js/plugins/ligerResizable.js" type="text/javascript"></script>
    <script src="lib/ligerUI/js/plugins/ligerDialog.js" type="text/javascript"></script>
    <script src="lib/ligerUI/js/plugins/ligerDrag.js" type="text/javascript"></script>
    
    <script src="js/search/SearchScienceTechProject.js" type="text/javascript"></script>
    <script src="js/search/GetDate.js" type="text/javascript"></script>
	<script>
		var c = new Calendar("c");
		document.write(c);
	</script>
</head>
<body style="padding:0px; "> 

<div class="l-loading" style="display:block" id="pageloading"></div> 
  
 <form id="form1" action="searchSchoolScienceTechProject.action" method="post"> 
<div id="hippo">
	<ul class="list">
		<li class="til">
			<span class="logical" href="#">查询条件</span>
			<div class="clear"></div>
		</li>
		<li class="item">
			<span class="logical">
			</span>
			<select class="logical_item" name="stringName1" id="stringName1">
				<option>请选择</option>
				<option value="projectId">项目编号</option>
				<option value="projectName">项目名称</option>
				<option value="sortSubject">学科分类</option>
				<option value="sortActivity">活动分类</option>
				<option value="originProject">项目来源</option>
				<option value="formOrganization">组织形式</option>
				<option value="formCooperation">合作形式</option>
				<option value="unitProject">所在部门</option>
				<option value="submitUser">提交者</option>
				<option value="approvedUser">审批者</option>
				<option value="author">作者</option>
			</select>
			<input type="text" class="logical_word"  name="stringValue1" id="stringValue1"/>
			<div class="clear"></div>
			
			<span class="logical">
			</span>
			<select class="logical_item" name="stringName2" id="stringName2">
				<option>请选择</option>
				<option value="projectId">项目编号</option>
				<option value="projectName">项目名称</option>
				<option value="sortSubject">学科分类</option>
				<option value="sortActivity">活动分类</option>
				<option value="originProject">项目来源</option>
				<option value="formOrganization">组织形式</option>
				<option value="formCooperation">合作形式</option>
				<option value="unitProject">所在部门</option>
				<option value="submitUser">提交者</option>
				<option value="approvedUser">审批者</option>
				<option value="author">作者</option>
			</select>
			<input type="text" class="logical_word"  name="stringValue2" id="stringValue2"/>
			<div class="clear"></div>
		</li>
		<li class="item">
			<span class="logical">
			</span>
			<select class="logical_item" name="stringName3" id="stringName3">
				<option>请选择</option>
				<option value="projectId">项目编号</option>
				<option value="projectName">项目名称</option>
				<option value="sortSubject">学科分类</option>
				<option value="sortActivity">活动分类</option>
				<option value="originProject">项目来源</option>
				<option value="formOrganization">组织形式</option>
				<option value="formCooperation">合作形式</option>
				<option value="unitProject">所在部门</option>
				<option value="submitUser">提交者</option>
				<option value="approvedUser">审批者</option>
				<option value="author">作者</option>
			</select>
			<input type="text" class="logical_word"  name="stringValue3" id="stringValue3"/>
			<div class="clear"></div>
			
			<span class="logical">
			</span>
			<select class="logical_item" name="stringName4" id="stringName4">
				<option>请选择</option>
				<option value="projectId">项目编号</option>
				<option value="projectName">项目名称</option>
				<option value="sortSubject">学科分类</option>
				<option value="sortActivity">活动分类</option>
				<option value="originProject">项目来源</option>
				<option value="formOrganization">组织形式</option>
				<option value="formCooperation">合作形式</option>
				<option value="unitProject">所在部门</option>
				<option value="submitUser">提交者</option>
				<option value="approvedUser">审批者</option>
				<option value="author">作者</option>
			</select>
			<input type="text" class="logical_word"  name="stringValue4" id="stringValue4"/>
			<div class="clear"></div>
		</li>
		<li class="item">
			<span class="logical">
			</span>
			<select class="logical_item" name="floatName1" id="floatName1">
				<option>请选择</option>
				<option value="totalFundContract">合同经费</option>
				<option value="advanced_staff">高级职务人数</option>
				<option value="middle_staff">中级职务人数</option>
				<option value="junior_staff">低级职务人数</option>
			</select>
			<input type="text" class="logical_word"  name="minFloatValue1" id="minFloatValue1"/>
			<div class="clear"></div>
			<input type="text" class="logical_word"  name="maxFloatValue1" id="maxFloatValue1"/>
			<div class="clear"></div>
		</li>
		
		<li class="item">
			<span class="logical">
			</span>
			<select class="logical_item" name="dateName" id="dateName">
				<option>请选择</option>
				<option value="timeProjectApproved">项目批准时间</option>
				<option value="updateTime">项目更新时间</option>
			</select>
			<input type="text" class="logical_word"  name="begin" onfocus="c.showMoreDay = false;c.show(this);" id="begin"/>
			<div class="clear"></div>
			<input type="text" class="logical_word"  name="end" onfocus="c.showMoreDay = false;c.show(this);" id="end"/>
			<div class="clear"></div>
			
		</li>
	</ul>
</div>
	<p id="tijiao" style="margin:1em 0 1em 20em;">
		<input type="button" onclick="getInfo()" class="btn" value="查询" />
		<input type="reset" class="btn" value="重置" />
	</p>
	
	<div id="toptoolbar"></div>
    <div id="maingrid" style="margin:0; padding:0">
     
    
   <c:if test="${not empty projectInfo}">
     	 <c:forEach items="${projectInfo}" var="projectInfo1">
     	 	<script type="text/javascript">
				var row = {projectId: "${projectInfo1.project.projectId}",
						projectName: "${projectInfo1.project.projectName}", 
						timeProjectApproved: "${projectInfo1.project.timeProjectApproved}", 
						totalFundContract: "${projectInfo1.project.totalFundContract}", 
						sortSubject:"${projectInfo1.project.sortSubject}",
						sortActivity:"${projectInfo1.project.sortActivity}",
						originProject:"${projectInfo1.project.originProject}",
						formOrganization:"${projectInfo1.project.formOrganization}",
						formCooperation:"${projectInfo1.project.formCooperation}",
						organReliedProject:"${projectInfo1.project.organReliedProject}",
						industryService:"${projectInfo1.project.industryService}",
						unitProject:"${projectInfo1.project.unitProject}",
						submitUser:"${projectInfo1.project.submitUser.userName}",
						approvedUser:"${projectInfo1.project.approvedUser.userName}",
						Status: "${projectInfo1.project.status}",
						type: "${type}"
						};
				rows.push(row);
    		 </script>
    </c:forEach>
     </c:if>
     </div> 
  </form>

<div style="display:none;">

</div>
</body>
</html>