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
	<script src="js/teacher/inputInfo.js" type="text/javascript"></script>
	<script src="lib/ligerUI/js/ligerui.min.js" type="text/javascript"></script>
</head>
<body style="padding:0px;">
	<form id="form" name="form" action="findDynamicDataField.action" method="post">
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
					<select style="width:150px" name="classNum">
						<option value="1">专业建设/教改项目</option>
						<option value="2">课程建设</option>
						<option value="3">教学成果</option>
						<option value="4">教材立项</option>
						<option selected="selected" value="5">学生获奖信息</option>
					</select>
				</div>
			</div>
		</div>
	</div>
	</div>
		<button type="submit">查询</button>
	</form>
	
	<s:if test="#allFields!=null">
	<table border="1">
		<tr>
			<th>字段数据库名</th>
			<th>字段前台展示名</th>
			<th>字段提交时间</th>
			<th>操作</th>
			<th>操作</th>
		</tr>
		<s:iterator value="#allFields" id="f">
		<tr>
			<td><s:property value="#f.name"/></td>
			<td><s:property value="#f.description"/></td>
			<td><s:property value="#f.submitTime"/></td>
			<td>删除</td>
			<td>修改</td>
		</tr>
		</s:iterator>
	</table>
	</s:if>
</body>
</html>