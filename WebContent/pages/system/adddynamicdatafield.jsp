<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<%    
      String path = request.getContextPath();
      String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
       
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<base href="<%=basePath%>">
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>添加动态数据库字段</title>
    <link href="lib/ligerUI/skins/Aqua/css/ligerui-all.css" rel="stylesheet" type="text/css" />
    <link href="lib/ligerUI/skins/ligerui-icons.css" rel="stylesheet" type="text/css" />
    <link href="css/Data.css" rel="stylesheet" type="text/css" />
    <script src="lib/jquery/jquery-1.5.2.min.js" type="text/javascript"></script> 
    <script src="js/addPerson.js" type="text/javascript"></script>
    <script src="js/vanadium.js" type="text/javascript"></script>
	<script src="js/check.js" type="text/javascript"></script>
	<link href="css/input.css" rel="stylesheet" type="text/css" />
	<link href="css/upload.css" rel="stylesheet" type="text/css" />
	<script src="js/teacher/inputInfo.js" type="text/javascript"></script>
	<script src="lib/ligerUI/js/ligerui.min.js" type="text/javascript"></script>
</head>
<body style="padding:0px;">
	<form id="form" name="form" action="dynamicDataFieldManager.action" onsubmit="return checkClickAndSubmit();" method="post">
	<div id="allpage">
	<div class="item">
		<div class="title">
			录入信息类别的选择
			<div class="clear"></div>
		</div>
		<div class="content">
			<div class="line">	<!-- ####三个换行#### -->
				<div class="element">
					<label for="rewardTime">信息类别：</label>
					<select style="width:150px" name="classNum">
						<option value="1">专业建设/教改项目</option>
						<option value="2">课程建设</option>
						<option value="3">教学成果</option>
						<option value="4">教材立项</option>
						<option selected="selected" value="5">学生获奖信息</option>
					</select>
				</div>
			</div>
			
			<div class="clear" style="height:15px;"></div>
			<div class="title">
				添加字段
			</div>
			<div class="item">
				<div class="element del person">
					<label for="fieldName">字段数据库名：</label>
					<input type="text" id="" name="fieldName" class=":required"/>
				</div>
				<div class="element del detail">
					<label for="remarksMem">字段前台展示名：</label>
					<input type="text" id="" name="fieldDes" class=":required"/>
				</div>
			</div>
    			
		</div>
			
	</div>
	
	<div class="clear" style="height:15px;"></div>
	
	<p id="tijiao">
		<input type="submit" id="submit" name="submit" onclick="checkResult('confirm');" class="btn" value="提交" />
		<input type="reset" class="btn" value="重置" />
	</p>
	</div>
	</form>
	
</body>
</html>