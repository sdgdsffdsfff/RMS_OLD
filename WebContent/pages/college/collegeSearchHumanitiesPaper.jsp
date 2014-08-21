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
    
    <script src="js/search/SearchHumanitiesPaper.js" type="text/javascript"></script>
</head>
<body style="padding:0px; "> 

<div class="l-loading" style="display:block" id="pageloading"></div> 
  
 <form id="form1" action="searchCollegeHumanitiesPaperInfo.action" method="post"> 
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
				<option value="paperId">论文ID</option>
				<option value="paperName">论文名称</option>
				<option value="publishedTime">出版日期</option>
				<option value="postPublication">发表刊物</option>
				<option value="publishedGrades">刊物级别</option>
				<option value="searchStation">检索情况</option>
				<option value="belongProject">所属项目</option>
				<option value="subjectsClassify">学科门类</option>
				<option value="achievementQuote">引用采纳情况</option>
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
				<option value="paperId">论文ID</option>
				<option value="paperName">论文名称</option>
				<option value="publishedTime">出版日期</option>
				<option value="postPublication">发表刊物</option>
				<option value="publishedGrades">刊物级别</option>
				<option value="searchStation">检索情况</option>
				<option value="belongProject">所属项目</option>
				<option value="subjectsClassify">学科门类</option>
				<option value="achievementQuote">引用采纳情况</option>
				<option value="submitUser">提交者</option>
				<option value="approvedUser">审批者</option>
				<option value="author">作者</option>
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
				<option value="paperId">论文ID</option>
				<option value="paperName">论文名称</option>
				<option value="publishedTime">出版日期</option>
				<option value="postPublication">发表刊物</option>
				<option value="publishedGrades">刊物级别</option>
				<option value="searchStation">检索情况</option>
				<option value="belongProject">所属项目</option>
				<option value="subjectsClassify">学科门类</option>
				<option value="achievementQuote">引用采纳情况</option>
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
				<option value="paperId">论文ID</option>
				<option value="paperName">论文名称</option>
				<option value="publishedTime">出版日期</option>
				<option value="postPublication">发表刊物</option>
				<option value="publishedGrades">刊物级别</option>
				<option value="searchStation">检索情况</option>
				<option value="belongProject">所属项目</option>
				<option value="subjectsClassify">学科门类</option>
				<option value="achievementQuote">引用采纳情况</option>
				<option value="submitUser">提交者</option>
				<option value="approvedUser">审批者</option>
				<option value="author">作者</option>
			</select>
			<input type="text" class="logical_word"  name="stringValue4" id="stringValue4"/>
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
     
    
   <c:if test="${not empty humanitiesPaperInfos}">
     	 <c:forEach items="${humanitiesPaperInfos}" var="humanitiesPaperInfo">
     	 	<script type="text/javascript">
				var row = {paperId: "${humanitiesPaperInfo.model.paperId}",
						paperName: "${humanitiesPaperInfo.model.paperName}", 
						publishedTime: "${humanitiesPaperInfo.model.publishedTime}", 
						postPublication: "${humanitiesPaperInfo.model.postPublication}", 
						publishedGrades:"${humanitiesPaperInfo.model.publishedGrades}",
						searchStation:"${humanitiesPaperInfo.model.searchStation}",
						belongProject:"${humanitiesPaperInfo.model.belongProject}",
						subjectsClassify:"${humanitiesPaperInfo.model.subjectsClassify}",
						achievementQuote:"${humanitiesPaperInfo.model.achievementQuote}",
						submitUser:"${humanitiesPaperInfo.model.submitUser.userName}",
						approvedUser:"${humanitiesPaperInfo.model.approvedUser.userName}",
						Status: "${humanitiesPaperInfo.model.status}",
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