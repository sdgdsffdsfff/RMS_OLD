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
    <title>人文社科论文详细信息</title>
    
    <link href="lib/ligerUI/skins/Aqua/css/ligerui-all.css" rel="stylesheet" type="text/css" />
    <link href="lib/ligerUI/skins/ligerui-icons.css" rel="stylesheet" type="text/css" />
    <link href="css/Data.css" rel="stylesheet" type="text/css" />
    <script src="lib/jquery/jquery-1.5.2.min.js" type="text/javascript"></script>
    <script src="lib/ligerUI/js/ligerui.min.js" type="text/javascript"></script>
    <script src="js/teacher/detailInfo.js" type="text/javascript"></script>
    
    <link rel="stylesheet" type="text/css" href="js/XYTipsWindow/style.css">
	<script type="text/javascript" src="js/XYTipsWindow/jquery.XYTipsWindow.2.8.js"></script>
	<script type="text/javascript" src="js/jquery.clearfield.js"></script>
</head>
<body style="padding:0px;"> 
		

<div id="allpage">

	<div class="item">
		<div class="title">
			1.人文社科论文信息
		</div>
    	<s:iterator  value="humanitiesPaper" >
		<div class="content">
			<div class="line">
				<div class="element">
					<label for="paperName">成果名称:</label>
					<input type="text" id="paperName" name="paperName" value='<s:property value="paperName"/>' readonly/>
				</div>
				<div class="element">
					<label for="publishedTime">出版日期/期号:</label>
					<input type="text" id="publishedTime" name="publishedTime" value='<s:property value="publishedTime"/>' readonly/>
				</div>
				<div class="element">
					<label for="postPublication">发表刊物:</label>
					<input type="text" id="postPublication" name="postPublication" value='<s:property value="postPublication"/>' readonly/>
				</div>
			</div>
			<div class="line">
				<div class="element">
					<label for="publishedGrades">刊物级别:</label>
					<input type="text" id="publishedGrades" name="publishedGrades" value='<s:property value="publishedGrades"/>' readonly/>
				</div>
				<div class="element">
					<label for="searchStation">检索情况:</label>
					<input type="text" id="searchStation" name="searchStation" value='<s:property value="searchStation"/>' readonly/>
				</div>
				<div class="element">
					<label for="belongProject">成果所属项目:</label>
					<input type="text" id="belongProject" name="belongProject" value='<s:property value="belongProject"/>' readonly/>
				</div>
			</div>
			<div class="line">
			    <div class="element">
					<label for="subjectsClassify">学科分类:</label>
					<input type="text" id="subjectsClassify" name="subjectsClassify" value='<s:property value="subjectsClassify"/>' readonly/>
				</div>
				<div class="element">
					<label for="achievementQuote">成果引用采纳情况:</label>
					<input type="text" id="achievementQuote" name="achievementQuote" value='<s:property value="achievementQuote"/>' readonly/>
				</div>
			</div>
			
			<div class="line">
			    <div class="element">
					<label for="submitUser">提交该信息的用户:</label>
					<input type="text" id="submitUser" name="submitUser" value='<s:property value="submitUser.userName"/>'/>
				</div>
				<div class="element">
					<label for="approvedUser">审批该信息的用户:</label>
					<input type="text" id="approvedUser" name="approvedUser" value='<s:property value="approvedUser.userName"/>'/>
				</div>
				<div class="element">
					<label for="status">该信息的状态:</label>
					<s:if test="status==0">
					<input type="text" id="status" name="status" value='已保存' />
					</s:if>
					<s:if test="status==1">
					<input type="text" id="status" name="status" value='未审批' />
					</s:if>
					<s:if test="status==2">
					<input type="text" id="status" name="status" value='已审批通过' />
					</s:if>
					<s:if test="status==3">
					<input type="text" id="status" name="status" value='审批未通过' />
					</s:if>
				</div>
			</div>
			<div class="line">
		     	<div class="element">
					<label for="returnReason">返回原因:</label>
					<input type="text" id="returnReason" name="returnReason" value='<s:property value="returnReason"/>'/>
				</div>
			</div>
		</div>
		</s:iterator>
	</div>
	<div class="clear" style="height:15px;"></div>
	<div class="item">
		<div class="title">
			2.论文作者信息
		</div>
		<s:iterator value="memberList" >
		<div class="content">
			<div class="line">
				<div class="element">
					<label for="authorName">作者姓名:</label>
					<input type="text" id="authorName" name="authorName" value='<s:property value="authorName"/>'/>
				</div>
				<div class="element">
					<label for="remarks">备注:</label>
					<input type="text" id="remarks" name="remarks" value='<s:property value="remarks"/>'/>
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

</body>
</html>