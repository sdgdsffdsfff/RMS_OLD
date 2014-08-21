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
    
    <script src="js/search/SearchScienceTechExchange.js" type="text/javascript"></script>
</head>
<body style="padding:0px; "> 

<div class="l-loading" style="display:block" id="pageloading"></div> 
  
 <form id="form1" action="searchSchoolScienceTechExchange.action" method="post"> 



<div id="hippo">
	<ul class="list">
		<li class="item">
			<span class="logical">
			</span>
			<span class="logical">学院：</span>
			<select class="logical_item" name="collegeId">
				<option value="all">全部</option>
				<c:if test="${not empty cquptColleges}">
					<c:forEach items="${cquptColleges}" var="cquptCollege">
						<option value="${cquptCollege.collegeId }">${cquptCollege.collegeName }</option>
					</c:forEach>
				</c:if>
			</select>
			<div class="clear"></div>
		</li>
		<li class="item">
			<span class="logical">
			</span>
			<select class="logical_item" name="stringName1">
				<option>请选择</option>
				<option value="techExchangeId">科技交流编号</option>
				<option value="collegesIn">所在学院</option>
				<option value="exchangeType">交流形式</option>
				<option value="exchangeHost">主办方</option>
				<option value="submitUser">提交者</option>
				<option value="approvedUser">审批者</option>
				<option value="person">参与人</option>
			</select>
			<input type="text" class="logical_word"  name="stringValue1"/>
			<div class="clear"></div>
			
			<span class="logical">
			</span>
			<select class="logical_item" name="stringName2">
				<option>请选择</option>
				<option value="techExchangeId">科技交流编号</option>
				<option value="collegesIn">所在学院</option>
				<option value="exchangeType">交流形式</option>
				<option value="exchangeHost">主办方</option>
				<option value="submitUser">提交者</option>
				<option value="approvedUser">审批者</option>
				<option value="person">参与人</option>
			</select>
			<input type="text" class="logical_word"  name="stringValue2"/>
			<div class="clear"></div>
		</li>
		<li class="item">
			<span class="logical">
			</span>
			<select class="logical_item" name="stringName3">
				<option>请选择</option>
				<option value="techExchangeId">科技交流编号</option>
				<option value="collegesIn">所在学院</option>
				<option value="exchangeType">交流形式</option>
				<option value="exchangeHost">主办方</option>
				<option value="submitUser">提交者</option>
				<option value="approvedUser">审批者</option>
				<option value="person">参与人</option>
			</select>
			<input type="text" class="logical_word"  name="stringValue3"/>
			<div class="clear"></div>
			
			<span class="logical">
			</span>
			<select class="logical_item" name="stringName4">
				<option>请选择</option>
				<option value="techExchangeId">科技交流编号</option>
				<option value="collegesIn">所在学院</option>
				<option value="exchangeType">交流形式</option>
				<option value="exchangeHost">主办方</option>
				<option value="submitUser">提交者</option>
				<option value="approvedUser">审批者</option>
				<option value="person">参与人</option>
			</select>
			<input type="text" class="logical_word"  name="stringValue4"/>
			<div class="clear"></div>
		</li>
		<li class="item">
			<span class="logical">
			</span>
			<select class="logical_item" name="floatName1">
				<option>请选择</option>
				<option value="sendNumber">派遣人数</option>
				<option value="receiveNumber">接收人数</option>
				<option value="attendNumber">出席人数</option>
				<option value="papersNumber">交流论文篇数</option>
				<option value="specialInvitedNumber">特邀报告篇数</option>
			</select>
			<input type="text" class="logical_word"  name="minFloatValue1"/>
			<div class="clear"></div>
			<input type="text" class="logical_word"  name="maxFloatValue1"/>
			<div class="clear"></div>
		</li>
		<li class="item">
			<span class="logical">
			</span>
			<select class="logical_item" name="floatName2">
				<option>请选择</option>
				<option value="sendNumber">派遣人数</option>
				<option value="receiveNumber">接收人数</option>
				<option value="attendNumber">出席人数</option>
				<option value="papersNumber">交流论文篇数</option>
				<option value="specialInvitedNumber">特邀报告篇数</option>
			</select>
			<input type="text" class="logical_word"  name="minFloatValue2"/>
			<div class="clear"></div>
			<input type="text" class="logical_word"  name="maxFloatValue2"/>
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
     
    
   <c:if test="${not empty scienceTechExchange}">
     	 <c:forEach items="${scienceTechExchange}" var="scienceTechExchanges">
     	 	<script type="text/javascript">
				var row = {techExchangeId: "${scienceTechExchanges.model.techExchangeId}",
						collegesIn: "${scienceTechExchanges.model.collegesIn}", 
						exchangeType: "${scienceTechExchanges.model.exchangeType}", 
						sendNumber: "${scienceTechExchanges.model.sendNumber}", 
						receiveNumber:"${scienceTechExchanges.model.receiveNumber}",
						attendNumber:"${scienceTechExchanges.model.attendNumber}",
						papersNumber:"${scienceTechExchanges.model.papersNumber}",
						specialInvitedNumber:"${scienceTechExchanges.model.specialInvitedNumber}",
						exchangeHost:"${scienceTechExchanges.model.exchangeHost}",
						submitUser:"${scienceTechExchanges.model.submitUser.userName}",
						approvedUser:"${scienceTechExchanges.model.approvedUser.userName}",
						Status: "${scienceTechExchanges.model.status}"
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