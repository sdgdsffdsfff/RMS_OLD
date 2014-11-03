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
	<title>教学成果奖信息查询</title>
	<link href="lib/ligerUI/skins/Aqua/css/ligerui-all.css" rel="stylesheet" type="text/css" />
	<link href="lib/ligerUI/skins/ligerui-icons.css" rel="stylesheet" type="text/css" />
    <link href="css/Data.css" rel="stylesheet" type="text/css" />
    <link href="css/search.css" rel="stylesheet" type="text/css" />
    <script src="lib/jquery/jquery-1.5.2.min.js" type="text/javascript"></script>
    <script src="lib/ligerUI/js/ligerui.min.js" type="text/javascript"></script> 
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
    
    <script src="js/search/SearchStudentAwards.js" type="text/javascript"></script>
</head>
<body style="padding:0px; "> 
  
 <form id="form1" action="searchCollegeTeacherAwardsRecordInfo.action" method="post"> 
<div id="hippo">
	<ul class="list">
		<li class="til">
			<span class="logical">查询条件</span>
			<div class="clear"></div>
		</li>
		<li class="item">
			<span class="logical">
			</span>
			<select class="logical_item" name="stringName1" id="stringName1">
				<option>请选择</option>
				<option value="recordId">记录编号</option>
				<option value="recordName">记录名称</option>
				<option value="submitUser">提交者</option>
				<option value="approvedUser">审批者</option>
				<option value="teacher">获奖教师</option>
				<s:iterator value="#fields" id="f">
					<option value="<s:property value="#f.name"/>"><s:property value="#f.description"/></option>
				</s:iterator>
			</select>
			<input type="text" class="logical_word"  name="stringValue1" id="stringValue1"/>
			<div class="clear"></div>
			
			<span class="logical">
			</span>
			<select class="logical_item" name="stringName2" id="stringName2">
				<option>请选择</option>
				<option value="recordId">记录编号</option>
				<option value="recordName">记录名称</option>
				<option value="submitUser">提交者</option>
				<option value="approvedUser">审批者</option>
				<option value="teacher">获奖教师</option>
				<s:iterator value="#fields" id="f">
					<option value="<s:property value="#f.name"/>"><s:property value="#f.description"/></option>
				</s:iterator>
			</select>
			<input type="text" class="logical_word"  name="stringValue2" id="stringValue2"/>
			<div class="clear"></div>
			<div class="clear"></div>
		</li>
		<li class="item">
			<span class="logical">
			</span>
			<select class="logical_item" name="stringName3" id="stringName3">
				<option>请选择</option>
				<option value="recordId">记录编号</option>
				<option value="recordName">记录名称</option>
				<option value="submitUser">提交者</option>
				<option value="approvedUser">审批者</option>
				<option value="teacher">获奖教师</option>
				<s:iterator value="#fields" id="f">
					<option value="<s:property value="#f.name"/>"><s:property value="#f.description"/></option>
				</s:iterator>
			</select>
			
			<p id="tijiao" style="margin:1em 0 1em 20em;">
		             <input type="submit" class="btn" value="查询" />
		             <input type="reset" class="btn" value="重置" />
	        </p>
			<input type="text" class="logical_word"  name="stringValue3" id="stringValue3"/>
			<div class="clear"></div>
			
			<span class="logical">
			</span>
			<select class="logical_item" name="stringName4" id="stringName4">
				<option>请选择</option>
				<option value="recordId">记录编号</option>
				<option value="recordName">记录名称</option>
				<option value="submitUser">提交者</option>
				<option value="approvedUser">审批者</option>
				<option value="teacher">获奖教师</option>
				<s:iterator value="#fields" id="f">
					<option value="<s:property value="#f.name"/>"><s:property value="#f.description"/></option>
				</s:iterator>
			</select>
			<input type="text" class="logical_word"  name="stringValue4" id="stringValue4"/>
			<div class="clear"></div>
		</li>
	</ul>
</div>

	
   <%--  <table border="1">
    	<tr>
    		<th>提交者</th>
    		<th>审批者</th>
    		<th>操作</th>
    		<th>信息名字</th>
    		<s:iterator value="#fields" id="f">
     			<th><s:property value="#f.description"/></th>
     		</s:iterator>	
     	</tr>
     	<s:iterator value="#teacherAwardsInfos" id="i">
     		<tr>
     			<td><s:property value="#i.model.submitUser.userName"/></td>
     			<td><s:property value="#i.model.approvedUser.userName"/></td>
     			<td><a href="viewTeacherAwardsRecordDetail.action?recordId=<s:property value="#i.model.id"/>">查看详细</a></td>
     			<td><s:property value="#i.model.name"/></td>
     			<s:iterator value="#i.model.fields" id="f2">
     				<td><s:property value="#f2.value"/></td>
     			</s:iterator>
     		</tr>
     	</s:iterator>
     	</table>  --%>
  </form>
</body>
</html>