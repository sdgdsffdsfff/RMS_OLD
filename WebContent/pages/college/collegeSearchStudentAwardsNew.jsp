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
	<title>学生参赛获奖查询</title>
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
    
    <script src="js/search/SearchStudentAwardsNew.js" type="text/javascript"></script>
    <script src="js/search/GetDate.js" type="text/javascript"></script>
	<script>
		var c = new Calendar("c");
		document.write(c);
	</script>
</head>
<body style="padding:0px; "> 

<div class="l-loading" style="display:block" id="pageloading"></div> 
  
 <form id="form1" action="searchSchoolStudentAwardsNew.action" method="post"> 



<div id="hippo">
	<ul class="list">
		<li class="item">
			<span class="logical">
			</span>
			
			<div class="clear"></div>
		</li>
		<li class="item">
			<span class="logical">
			</span>
			<select class="logical_item" name="stringName1">
				<option>请选择</option>
				<option value="awardsId">奖励编号</option>
				<option value="rewardStudents">学生团队成员</option>
				<option value="rewardName">赛事名称</option>
				<option value="rewardLevel">获奖级别</option>
				<option value="rewardUnit">颁奖单位</option>
				<option value="firstStudents">排名第一的学生姓名</option>
			</select>
			<input type="text" class="logical_word"  name="stringValue1"/>
			<div class="clear"></div>
			
			<span class="logical">
			</span>
			<select class="logical_item" name="stringName2">
				<option>请选择</option>
				<option value="awardsId">奖励编号</option>
				<option value="rewardStudents">学生团队成员</option>
				<option value="rewardName">赛事名称</option>
				<option value="rewardLevel">获奖级别</option>
				<option value="rewardUnit">颁奖单位</option>
				<option value="firstStudents">排名第一的学生姓名</option>
			</select>
			<input type="text" class="logical_word"  name="stringValue2"/>
			<div class="clear"></div>
			<div class="clear"></div>
		</li>
		<li class="item">
			<span class="logical">
			</span>
			<select class="logical_item" name="stringName3">
				<option>请选择</option>
				<option value="awardsId">奖励编号</option>
				<option value="rewardStudents">学生团队成员</option>
				<option value="rewardName">赛事名称</option>
				<option value="rewardLevel">获奖级别</option>
				<option value="rewardUnit">颁奖单位</option>
				<option value="firstStudents">排名第一的学生姓名</option>
			</select>
			<input type="text" class="logical_word"  name="stringValue3"/>
			<div class="clear"></div>
			
			<span class="logical">
			</span>
			<select class="logical_item" name="stringName4">
				<option>请选择</option>
				<option value="awardsId">奖励编号</option>
				<option value="rewardStudents">学生团队成员</option>
				<option value="rewardName">赛事名称</option>
				<option value="rewardLevel">获奖级别</option>
				<option value="rewardUnit">颁奖单位</option>
				<option value="firstStudents">排名第一的学生姓名</option>
			</select>
			<input type="text" class="logical_word"  name="stringValue4"/>
			<div class="clear"></div>
		</li>
		<li class="item">
			<span class="logical">
			</span>
			<select class="logical_item" name="floatName1">
				<option>请选择</option>
				<option value="collegeAward">奖励金额</option>
			</select>
			<input type="text" class="logical_word"  name="minFloatValue1"/>
			<div class="clear"></div>
			<input type="text" class="logical_word"  name="maxFloatValue1"/>
			<div class="clear"></div>
		</li>
		
		<li class="item">
			<span class="logical">
			</span>
			<select class="logical_item" name="dateName">
				<option>请选择</option>
				<option value="rewardTime">获奖时间</option>
			</select>
			<input type="text" class="logical_word"  name="begin" onfocus="c.showMoreDay = false;c.show(this);"/>
			<div class="clear"></div>
		</li>
	</ul>
</div>
	<p id="tijiao" style="margin:1em 0 1em 20em;">
		<input type="submit" class="btn" value="查询" />
		<input type="reset" class="btn" value="重置" />
	</p>
	
	<div id="toptoolbar"></div>
    <div id="maingrid" style="margin:0; padding:0">
     
    
   <c:if test="${not empty studentAwardsNewInfos}">
     	 <c:forEach items="${studentAwardsNewInfos}" var="studentAwardsNewInfo">
     	 	<script type="text/javascript">
				var row = {awardsId: "${studentAwardsNewInfo.model.awardsId}",
						rewardStudents: "${studentAwardsNewInfo.model.rewardStudents}",
						rewardName: "${studentAwardsNewInfo.model.rewardName}", 
						rewardLevel: "${studentAwardsNewInfo.model.rewardLevel}", 
						rewardUnit: "${studentAwardsNewInfo.model.rewardUnit}", 
						firstStudents:"${studentAwardsNewInfo.model.firstStudents}",
						rewardTime:"${studentAwardsNewInfo.model.rewardTime}",
						collegeAward:"${studentAwardsNewInfo.model.collegeAward}",
						
						submitUser:"${studentAwardsNewInfo.model.submitUser.userName}",
						approvedUser:"${studentAwardsNewInfo.model.approvedUser.userName}",
						Status: "${studentAwardsNewInfo.model.status}"
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