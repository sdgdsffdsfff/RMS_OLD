<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@taglib prefix="s" uri="/struts-tags" %>
<%    
      String path = request.getContextPath();
      String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
       
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<base href="<%=basePath%>">
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>查看个人职称信息</title>
	<link href="lib/ligerUI/skins/Aqua/css/ligerui-all.css" rel="stylesheet" type="text/css" />
	<link href="css/Data.css" rel="stylesheet" type="text/css" />
    <script src="js/jquery-1.4.4.min.js" type="text/javascript"></script> 
    <script src="js/vanadium.js" type="text/javascript"></script>
	<script src="js/check.js" type="text/javascript"></script>
    <style type="text/css">
    	.content form input.btn{background:url(images/button.png) repeat; width:100px; height:25px; line-height:25px; color:#FFF; border:0; cursor:pointer;}
    </style>
</head>
<body style="padding:0px;">
	<div id="allpage">
		<div class="item">
		<div class="title">
			个人职称信息
		</div>
		<s:iterator value="titlesList" >
		<div class="content">
			<div class="line">
				<div class="element">
					<label for="titlesName">职称:</label>
					<input type="text" id="titlesName" name="titlesName" value='<s:property value="titlesName"/>' readonly/>
				</div>
			</div>
			<div class="line">
				<div class="element">
					<label for="timeTitlesBegin">职称开始的时间:</label>
					<input type="text" id="timeTitlesBegin" name="timeTitlesBegin" value="${timeTitlesBegin}" readonly/>
				</div>
				<div class="element">
					<label for="timeTitlesEnd">职称结束的时间:</label>
					<input type="text" id="timeTitlesEnd" name="timeTitlesEnd" value="${timeTitlesEnd}" readonly/>
				</div>
				<div class="element">
					<label for="remarks">备注:</label>
					<input type="text" id="remarks" name="remarks" value='<s:property value="remarks"/>' readonly/>
				</div>
			</div>
		</div>
		<div class="clear" style="height:30px;"></div><br/>
		</s:iterator>
		</div>
		
		<div class="content">
			<form action="pages/common/inputtitles.jsp" method="post">
				<p>
				<input type="submit" class="btn" value="添加职称信息" />
				</p>
			</form>
			
			<div class="clear"></div>
		</div>
		<div class="clear"></div>
	</div>
</body>
</html>