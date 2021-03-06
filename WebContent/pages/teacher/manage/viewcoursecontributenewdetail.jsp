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
    <title>本科教学工程信息</title>
    
    <link href="lib/ligerUI/skins/Aqua/css/ligerui-all.css" rel="stylesheet" type="text/css" />
    <link href="lib/ligerUI/skins/ligerui-icons.css" rel="stylesheet" type="text/css" />
    <link href="css/Data.css" rel="stylesheet" type="text/css" />
    <script src="lib/jquery/jquery-1.5.2.min.js" type="text/javascript"></script>
    <script src="js/modifyPerson.js" type="text/javascript"></script>
    <script src="js/vanadium.js" type="text/javascript"></script>
	<script src="js/check.js" type="text/javascript"></script>
	<link href="css/input.css" rel="stylesheet" type="text/css" />
	<link href="css/upload.css" rel="stylesheet" type="text/css" />
	<script src="js/teacher/modifyInfo.js" type="text/javascript"></script>
	<script src="lib/ligerUI/js/ligerui.min.js" type="text/javascript"></script>
	
	<link rel="stylesheet" type="text/css" href="js/XYTipsWindow/style.css">
	<script type="text/javascript" src="js/XYTipsWindow/jquery.XYTipsWindow.2.8.js"></script>
	<script type="text/javascript" src="js/jquery.clearfield.js"></script>
</head>
<body style="padding:0px;"> 
		
	<div id="allpage">

	<div class="item">
		<div class="title">
			1.本科教学工程信息
		</div>
		<div class="content">
		<s:iterator value="CourseContributeNew" >
		<input type="hidden" id="courseId" name="courseId" value='<s:property value="courseId"/>' readonly/>
			<div class="line">
				<div class="element">
					<label for="classContribute">项目级别:</label>
					<input type="text" id="classContribute" name="classContribute" value='<s:property value="classContribute"/>'readonly/>
				</div>
				<div class="element">
					<label for="typeContribute">项目类别:</label>
					<input type="text" id="typeContribute" name="typeContribute" value='<s:property value="typeContribute"/>'readonly/>
				</div>
				<div class="element">
					<label for="courseName">项目名称:</label>
					<input type="text" id="courseName" name="courseName" value='<s:property value="courseName"/>'readonly/>
				</div>
				
			</div>
			<div class="line">
				<div class="element">
					<label for="applicantRanking">申报人排名:</label>
					<input type="text" id="applicantRanking" name="applicantRanking" value='<s:property value="applicantRanking"/>'readonly/>
				</div>
				<div class="element">
					<label for="checkTime">立项时间</label>
					<input type="text" id="checkTime" name="checkTime" value="${checkTime}" readonly/>
				</div>
				<div class="element">
					<label for="endTime">结题时间</label>
					<input type="text" id="endTime" name="endTime" value="${endTime}" readonly/>
				</div>
				
			</div>
			<div class="line">
				<div class="element">
					<label for="timeContribute">项目来源:</label>
					<input type="text" id="timeContribute" name="timeContribute" value='<s:property value="timeContribute"/>'readonly/>
				</div>
			    <div class="element">
					<label for="collegeAward">奖励金额:</label>
					<input type="text" id="collegeAward" name="collegeAward" value='<s:property value="collegeAward"/>' readonly/>
				</div>
				<div class="element">
					<label for="remarks">备注:</label>
					<input type="text" id="remarks" name="remarks" value='<s:property value="remarks"/>' readonly/>
				</div>
			</div>
			
			<div class="line">
			    <div class="element">
					<label for="submitUser">提交该信息的用户:</label>
					<input type="text" id="submitUser" name="submitUser" value='<s:property value="submitUser.userName"/>' readonly/>
				</div>
				<div class="element">
					<label for="status">该信息的状态:</label>
					<s:if test="status==0">
					<input type="text" id="status" name="status" value='已保存' readonly/>
					</s:if>
					<s:if test="status==1">
					<input type="text" id="status" name="status" value='未审批' readonly/>
					</s:if>
					<s:if test="status==2">
					<input type="text" id="status" name="status" value='已审批通过' readonly/>
					</s:if>
					<s:if test="status==3">
					<input type="text" id="status" name="status" value='审批未通过' readonly/>
					</s:if>
				</div>
			</div>
			<div class="line">
				<div class="element">
					<label for="approvedUser">审批该信息的用户:</label>
					<input type="text" id="approvedUser" name="approvedUser" value='<s:property value="approvedUser.userName"/>' readonly/>
				</div>
		     	<div class="element">
					<label for="returnReason">返回原因:</label>
					<input type="text" id="returnReason" name="returnReason" value='<s:property value="returnReason"/>' readonly/>
				</div>
			</div>
		</s:iterator>
			
		<div class="clear" style="height:15px;"></div>
	    <div class="item">
		<div class="title">
			2.本科教学工程负责人信息
		</div>
		<s:iterator value="memberList" >
		<div class="content">
			<div class="line">
				<div class="element">
					<label for="memberName">负责人姓名:</label>
					<input type="text" id="memberName" name="memberName" value='<s:property value="memberName"/>'/>
				</div>
				<div class="element">
					<label for="remarksMem">备注:</label>
					<input type="text" id="remarksMem" name="remarks" value='<s:property value="remarks"/>'/>
				</div>
			</div>
		</div>
		</s:iterator>
		</div>
		<div class="clear" style="height:15px;"></div>
   	    <div class="item">
    	<div class="title">
			3.旁证材料
		</div>
		
    	<div id="maingrid" style="margin:0; padding:0">
     	<s:iterator value="proofs">
     	<script type="text/javascript">
     		var row = {proofId: "${proofId}", infoApprovedId: "${infoApprovedId}", proofPath: "${proofPath}",
     				uploadProofName: "${uploadProofName}", uploadRealName: "${uploadRealName}", 
     				uploadContentType: "${uploadContentType}", timeProofUpload: "${timeProofUpload}", descProof: "${descProof}"};
			rows.push(row);
     	</script>
     	</s:iterator>
    	</div>
    	<div class="content">
    	</div>
		</div>
	</div>
	
   	</div>
   
	</div>

</body>
</html>