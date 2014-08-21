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
    <title>查看人文社科科研项目信息</title>
    
    <link href="lib/ligerUI/skins/Aqua/css/ligerui-all.css" rel="stylesheet" type="text/css" />
    <link href="lib/ligerUI/skins/ligerui-icons.css" rel="stylesheet" type="text/css" />
    <link href="css/Data.css" rel="stylesheet" type="text/css" />
    <script src="lib/jquery/jquery-1.5.2.min.js" type="text/javascript"></script>
    <script src="lib/ligerUI/js/ligerui.min.js" type="text/javascript"></script>
    <script src="js/vanadium.js" type="text/javascript"></script>
	<script src="js/check.js" type="text/javascript"></script>
	<script src="js/teacher/showdetailinfo.js" type="text/javascript"></script>
	<link href="css/input.css" rel="stylesheet" type="text/css" />
</head>
<body style="padding:0px;"> 
		
	<form id="form" name="form" action="modifyHumanitiesProjectDetail.action" onsubmit="return checkClickAndSubmit();" method="post">
	<div id="allpage">

	<div class="item">
		<div class="title">
			科技项目详细信息
		</div>
		<div class="content">
			<div class="clear" style="height:15px;"></div>
			<s:iterator value="humanitiesProjectDetail" >
			<input type="hidden" id="id" name="id" value='<s:property value="id"/>'/>
			<div class="line">
				<div class="element">
					<label for="updateTime">更新时间:</label>
					<input type="text" id="updateTime" name="updateTime" value="${updateTime}" readonly/>
				</div>
				<div class="element">
					<label for="projectStatus">目前状态（在研/完成）:</label>
					<input type="text" id="projectStatus" name="projectStatus" value='<s:property value="projectStatus"/>' />
				</div>
				<div class="element">
					<label for="money">当年投入经费（万元）:</label>
					<input type="text" id="money" name="money" value='<s:property value="money"/>' class=":number"/>
				</div>
			</div>
			<div class="line">
				<div class="element">
					<label for="timePerPerson">每人当年投入研究时间（月/研究人员姓名）:</label>
					<input type="text" id="timePerPerson" name="timePerPerson" value='<s:property value="timePerPerson"/>' />
				</div>
			</div>
			</s:iterator>
		</div>
		</div>
		<div class="clear" style="height:30px;"></div>
	<p id="tijiao">
		<input type="submit" id="submit" name="submit" onclick="checkResult('save');" class="btn" value="保存" />
		<input type="submit" id="submit" name="submit" onclick="checkResult('confirm');" class="btn" value="提交" />
		<input type="reset" class="btn" value="重置" />
	</p>
	</div>
    
	</form>

</body>
</html>