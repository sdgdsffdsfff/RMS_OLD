<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%    
      String path = request.getContextPath();
      String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
       
%>
<%@ taglib uri="purviewTag" prefix="purviewTag"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link href="/RMS/css/admin/common.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="/RMS/js/jquery-1.4.2.js"></script>
<script type="text/javascript" src="/RMS/js/admin/center.js"></script>
<style type="text/css" title="currentStyle">
@import "/RMS/js/media/css/demo_page.css";
@import "/RMS/js/media/css/demo_table.css";
</style>
<script type="text/javascript" language="javascript" src="/RMS/js/media/js/jquery.dataTables.js"></script>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<base href="<%=basePath%>">



<link href="lib/ligerUI/skins/Aqua/css/ligerui-all.css" rel="stylesheet" type="text/css" />
<link href="lib/ligerUI/skins/ligerui-icons.css" rel="stylesheet" type="text/css" />
    <link href="css/Data.css" rel="stylesheet" type="text/css" />
    <script src="lib/jquery/jquery-1.5.2.min.js" type="text/javascript"></script>
    <script src="lib/ligerUI/js/ligerui.min.js" type="text/javascript"></script>
<script src="js/teacher/viewmanageTeacher.js" type="text/javascript"></script>
<title>教师信息</title>
</head>
<body style="padding:0px; overflow:hidden;">
	<div class="l-loading" style="display:block" id="pageloading"></div> 
  	<form id="form1"> 
 		<div id="topmenu"></div> 
		<div id="toptoolbar"></div> 
    	<div id="maingrid" style="margin:0; padding:0">
    		<s:iterator value="collegeteacherList">
     			<script type="text/javascript">
					var row = {userId: "${userId}", 
							   cquptCollege: "${cquptCollege.collegeName}", 
							   department: "${department}", 
							   userName: "${userName}", 
							   gender: "${gender}", 
							   origin: "${origin}", 
							   nationality: "${nationality}", 
							   birthday: "${birthday}", 
							   politicalStatus: "${politicalStatus}", 
							   timeBeginCqupt: "${timeBeginCqupt}",
							   timeBeginWork: "${timeBeginWork}", 
							   firstDegree: "${firstDegree}", 
							   firstProfessionalName: "${firstProfessionalName}", 
							   firstGraduateSchool: "${firstGraduateSchool}", 
							   lastDegree: "${lastDegree}", 
							   lastProfessionalName: "${lastProfessionalName}", 
							   lastGraduateSchool: "${lastGraduateSchool}", 
							   lastAcademic: "${lastAcademic}"};
					rows.push(row);
     			</script> 
   			</s:iterator> 
    	</div>
	</form>

  	<div style="display:none;">
	</div>
	
</body>
</body>
</html>