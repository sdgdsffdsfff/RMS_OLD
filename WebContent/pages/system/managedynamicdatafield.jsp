<%@page import="com.opensymphony.xwork2.ActionContext"%>
<%@page import="java.util.List"%>
<%@page import="com.cqupt.mis.rms.model.*"%>
<%@page import="com.cqupt.mis.rms.service.model.*"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
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
	<title>管理动态数据库字段</title>
    <link href="lib/ligerUI/skins/Aqua/css/ligerui-all.css" rel="stylesheet" type="text/css" />
    <link href="lib/ligerUI/skins/ligerui-icons.css" rel="stylesheet" type="text/css" />
    <link href="css/Data.css" rel="stylesheet" type="text/css" />
    <script src="lib/jquery/jquery-1.5.2.min.js" type="text/javascript"></script> 
    <script src="js/addPerson.js" type="text/javascript"></script>
    <script src="js/vanadium.js" type="text/javascript"></script>
	<script src="js/check.js" type="text/javascript"></script>
	<link href="css/input.css" rel="stylesheet" type="text/css" />
	<link href="css/upload.css" rel="stylesheet" type="text/css" />
	<script type="text/javascript" src="js/admin/checkDynamicFieldForm.js"></script>
	<script src="lib/ligerUI/js/ligerui.min.js" type="text/javascript"></script>
	<script src="js/search/managedynamicdatafield.js" type="text/javascript"></script>
	<script type="text/javascript">
	
	$(function() {
		var order ="${requestScope.classNum}";
		$("#select option").each(function() {  
	        if ($(this).val() == order) {  
	                $(this).attr("selected", true);  
	            
	            }  
	        }); 
	});
	</script>
</head>
<body style="padding:0px;">
	<form id="form" name="form" action="findDynamicDataField.action" onsubmit="return checkClick();" method="post">
	<div id="allpage">
	<div class="item">
		<div class="title">
			管理信息类别的选择
			<div class="clear"></div>
		</div>
		<div class="content">
			<div class="line">
				<div class="element">
					<label for="rewardTime">信息类别：</label>
					<select style="width:150px" name="classNum" id="select">
						<option value="0">请选择信息类别</option>	
						<option value="1">专业建设/教改项目</option>
						<option value="2">优秀培训师信息</option>
						<option value="3">教学成果信息</option>
						<option value="4">教材立项信息</option>
						<option value="5">学生获奖信息</option>
						<option value="6">质量工程信息</option>
						<option value="7">学评教信息</option>
						<option value="8">教改结题项目信息</option>
						<option value="9">其他教学奖励信息</option>
					</select>
				</div>
			</div>
		</div>
	</div>
	</div>
		<button type="submit">查询</button>
		
		<div id="toptoolbar"></div> 
    	<div id="maingrid" style="margin:0; padding:0">
    	<s:if test="#allFields!=null">
    		<s:iterator value="allFields">
     			<script type="text/javascript">
	     			var row = {
	     					id: "${id}",
	     					classNum: "${requestScope.classNum}",
	     					name: "${name}",
	     					description: "${description}", 
	     					submittime: "${submittime}",
	     					order: "${order}"
	     			};
	     			rows.push(row);
	     		</script>
   			</s:iterator> 
   			 </s:if>
    	</div>

<div style="display:none;">

</div>
</form>
</body>
</html>