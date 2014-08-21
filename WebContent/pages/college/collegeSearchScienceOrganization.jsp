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
	<title>理工类科研机构查询</title>
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
    
    <script src="js/search/SearchScienceOrganization.js" type="text/javascript"></script>
</head>
<body style="padding:0px; "> 
<div class="l-loading" style="display:block" id="pageloading"></div> 
  
<form id="form1" action="searchCollegeScienceOrganization.action" method="post">
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
				<option value="organizationId">机构ID</option>
				<option value="organizationName">机构名称</option>
				<option value="organizationType">机构类型</option>
				<option value="organizationCategory">机构类别</option>
				<option value="sortSubject">学科分类</option>
				<option value="modusComposition">组成形式</option>
				<option value="industryService">服务行业</option>
				<option value="submitUser">提交者</option>
				<option value="approvedUser">审批者</option>
			</select>
			<input type="text" class="logical_word"  name="stringValue1" id="stringValue1"/>
			<div class="clear"></div>
			
			<span class="logical">
			</span>
			<select class="logical_item" name="stringName2" id="stringName2">
				<option>请选择</option>
				<option value="organizationId">机构ID</option>
				<option value="organizationName">机构名称</option>
				<option value="organizationType">机构类型</option>
				<option value="organizationCategory">机构类别</option>
				<option value="sortSubject">学科分类</option>
				<option value="modusComposition">组成形式</option>
				<option value="industryService">服务行业</option>
				<option value="submitUser">提交者</option>
				<option value="approvedUser">审批者</option>
			</select>
			<input type="text" class="logical_word"  name="stringValue2" id="stringValue2"/>
			<div class="clear"></div>
			<div class="clear"></div>
		</li>
		<li class="item">
			<span class="logical">
			</span>
			<select class="logical_item" name="floatName1" id="floatName1">
				<option>请选择</option>
				<option value="totalEmployees">从业人员合计</option>
				<option value="doctorEmployees">博士毕业人数</option>
				<option value="masterEmployees">硕士毕业人数</option>
				<option value="totalIts">科技活动人员合计</option>
				<option value="advancedIts">高级职称数量</option>
				<option value="middleIts">中级职称数量</option>
				<option value="juniorIts">低级职称数量</option>
				<option value="otherIts">其他数量</option>
				<option value="numGraduates">培养研究生数量</option>
				<option value="internalExpenditures">经费内部支出</option>
				<option value="rdExpenditures">R&D支出</option>
				<option value="numIssueAssume">承担课题</option>
				<option value="assetsFixed">固定资产原值</option>
				<option value="assetsEquipment">仪器设备价值</option>
				<option value="assetsImport">进口价值</option>
			</select>
			<input type="text" class="logical_word"  name="minFloatValue1" id="minFloatValue1"/>
			<div class="clear"></div>
			<input type="text" class="logical_word"  name="maxFloatValue1" id="maxFloatValue1"/>
			<div class="clear"></div>
		</li>
		
		<li class="item">
			<span class="logical">
			</span>
			<select class="logical_item" name="floatName2" id="floatName2">
				<option>请选择</option>
				<option value="totalEmployees">从业人员合计</option>
				<option value="doctorEmployees">博士毕业人数</option>
				<option value="masterEmployees">硕士毕业人数</option>
				<option value="totalIts">科技活动人员合计</option>
				<option value="advancedIts">高级职称数量</option>
				<option value="middleIts">中级职称数量</option>
				<option value="juniorIts">低级职称数量</option>
				<option value="otherIts">其他数量</option>
				<option value="numGraduates">培养研究生数量</option>
				<option value="internalExpenditures">经费内部支出</option>
				<option value="rdExpenditures">R&D支出</option>
				<option value="numIssueAssume">承担课题</option>
				<option value="assetsFixed">固定资产原值</option>
				<option value="assetsEquipment">仪器设备价值</option>
				<option value="assetsImport">进口价值</option>
			</select>
			<input type="text" class="logical_word"  name="minFloatValue2" id="minFloatValue2"/>
			<div class="clear"></div>
			<input type="text" class="logical_word"  name="maxFloatValue2" id="maxFloatValue2"/>
			<div class="clear"></div>
		</li>
		
		<li class="item">
			<span class="logical">
			</span>
			<select class="logical_item" name="floatName3" id="floatName3">
				<option>请选择</option>
				<option value="totalEmployees">从业人员合计</option>
				<option value="doctorEmployees">博士毕业人数</option>
				<option value="masterEmployees">硕士毕业人数</option>
				<option value="totalIts">科技活动人员合计</option>
				<option value="advancedIts">高级职称数量</option>
				<option value="middleIts">中级职称数量</option>
				<option value="juniorIts">低级职称数量</option>
				<option value="otherIts">其他数量</option>
				<option value="numGraduates">培养研究生数量</option>
				<option value="internalExpenditures">经费内部支出</option>
				<option value="rdExpenditures">R&D支出</option>
				<option value="numIssueAssume">承担课题</option>
				<option value="assetsFixed">固定资产原值</option>
				<option value="assetsEquipment">仪器设备价值</option>
				<option value="assetsImport">进口价值</option>
			</select>
			<input type="text" class="logical_word"  name="minFloatValue3" id="minFloatValue3"/>
			<div class="clear"></div>
			<input type="text" class="logical_word"  name="maxFloatValue3" id="maxFloatValue3"/>
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
     
    
   <c:if test="${not empty scienceOrganizations}">
     	 <c:forEach items="${scienceOrganizations}" var="scienceOrganization">
     	 	<script type="text/javascript">
				var row = {organizationId: "${scienceOrganization.organizationId}",
						organizationName: "${scienceOrganization.organizationName}", 
						organizationType: "${scienceOrganization.organizationType}", 
						organizationCategory: "${scienceOrganization.organizationCategory}", 
						
						sortSubject:"${scienceOrganization.sortSubject}",
						modusComposition:"${scienceOrganization.modusComposition}",
						totalEmployees:"${scienceOrganization.totalEmployees}",
						doctorEmployees:"${scienceOrganization.doctorEmployees}",
						masterEmployees:"${scienceOrganization.masterEmployees}",
						internalExpenditures:"${scienceOrganization.internalExpenditures}",
						rdExpenditures:"${scienceOrganization.rdExpenditures}",
						numIssueAssume:"${scienceOrganization.numIssueAssume}",
						submitUser:"${scienceOrganization.submitUser.userName}",
						approvedUser:"${scienceOrganization.approvedUser.userName}",
						Status: "${scienceOrganization.status}",
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