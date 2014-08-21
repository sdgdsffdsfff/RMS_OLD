<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%    
      String path = request.getContextPath();
      String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
       
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<base href="<%=basePath%>">
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>重庆市大学生创新创业训练计划项目信息</title>
	<link href="lib/ligerUI/skins/Aqua/css/ligerui-all.css" rel="stylesheet" type="text/css" />
	<link href="lib/ligerUI/skins/ligerui-icons.css" rel="stylesheet" type="text/css" />
    <link href="css/Data.css" rel="stylesheet" type="text/css" />
    <script src="lib/jquery/jquery-1.5.2.min.js" type="text/javascript"></script>
    <script src="lib/ligerUI/js/ligerui.min.js" type="text/javascript"></script>
    <script src="js/teacher/viewTeachAchievementsCQ.js" type="text/javascript"></script>
</head>
<body style="padding:0px; overflow:hidden;">
	<div class="l-loading" style="display:block" id="pageloading"></div> 
  	<form id="form1"> 
		<div id="toptoolbar"></div> 
    	<div id="maingrid" style="margin:0; padding:0">
    		<s:iterator value="teachAchievementsCQList">
     			<script type="text/javascript">
     			 var row = { achievementsId: "${achievementsId}", 
	     	    		 	 classAchievements: "${classAchievements}",
	     	    		 	 gradeAchievements: "${gradeAchievements}",
	     	    		 	 projectName: "${projectName}",
	     	    		 	 timeAchievements: "${timeAchievements}",
	     	    		 	 certificationUnit: "${certificationUnit}",
	     	    		 	 reportedAmounts: "${reportedAmounts}",
	     	    		 	 remarks: "${remarks}",
	     	    		 	 verifyAmounts: "${verifyAmounts}",
	     	    		  	 submitUser: "${submitUser.userName}",
	     	    		 	 approvedUser: "${approvedUser.userName}",
	     	    		 	 Status: "${status}",
	     	    		 	 returnReason: "${returnReason}",
	     	    		 	 projectType: "${projectType}",
	     	    		 	 standbyField1: "${standbyField1}"
     		 	   };
     				rows.push(row);
     			</script> 
   			</s:iterator> 
    	</div>
	</form>

  	<div style="display:none;">
	</div>
	
</body>
</html>