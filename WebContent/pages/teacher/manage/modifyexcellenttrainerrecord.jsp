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
    <title>修改教学技术奖信息</title>
    
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
		
	<form id="form" name="form" action="modifyExcellentTrainerRecord.action" onsubmit="return checkClickAndSubmit();" method="post" enctype="multipart/form-data">
	<div id="allpage">

	<div class="item">
		<div class="title">
			1.教学技术奖信息
		</div>
		<div class="content">
		<input type="hidden" id="recordId" name="recordId" value='<s:property value="#record.id"/>'/>
			<div class="line">
				<div class="element">
					<label for="name">项目名称:</label>
					<input type="text" name="recordName" value='<s:property value="#record.name"/>' class=":required"/>
				</div>	
				<s:iterator value="#record.fields" id="f">
				<div class="element">
					<label for="<s:property value="#f.field.name"/>"><s:property value="#f.field.description"/></label>
					<input type="text" name="<s:property value="#f.field.name"/>" value="<s:property value="#f.value"/>" class=":required" />
				</div>
				</s:iterator>
			</div>
			
			<div class="clear" style="height:15px;"></div>
			<div class="title">
			2.负责人信息
			</div>
			<div id="membertoolbar"></div>
			<s:if test="%{#memberList == null || #memberList.isEmpty()}">
				<div class="line spe">
					<div class="element del person">
						<label for="memberName">负责人姓名:</label>
						<input type="text" id="memberName" name="memberName" />
					</div>
					<div class="element del detail">
						<label for="remarksMem">备注:</label>
						<input type="text" id="remarksMem" name="remarksMem" />
					</div>
					<div class="element del">
						<input type="button" style="width:50px;" name="Par" class="delPerson" value="删除" />
					</div>
				</div>
			</s:if>
			<s:iterator value="memberList" >
			<div class="line spe">
				<div class="element del person">
					<label for="memberName">指导老师姓名:</label>
					<input type="text" id="memberName" name="memberName" value='<s:property value="memberName"/>'/>
				</div>
				<div class="element del detail">
					<label for="remarksMem">备注:</label>
					<input type="text" id="remarksMem" name="remarksMem" value='<s:property value="remarks"/>'/>
				</div>
				<div class="element del">
					<input type="button" style="width:50px;" name="Par" class="delPerson" value="删除" />
				</div>
			</div>
			</s:iterator>
    		
		</div>
		<div class="bottomcontent">
		<div class="clear" style="height:15px;"></div>
			<div class="title">
			3.已上传的旁证材料
			</div>
			<div id="proofstoolbar"></div>
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
    	
    	<div class="clear" style="height:15px;"></div>
    		<div class="title">
    		4.添加新的旁证材料
    		</div>
    		<div id="newproofstoolbar"></div>
    		<div class="clear" style="height:15px;"></div>
    		<div id="hippo" style="margin:0; padding:0">
				<div class="disc common">
					<div class="left text">
						<input type="file" class="file" name="upload" value="浏览" />
					</div>
					<div class="left btn">
						<input type="button" style="width:50px;" name="Par" class="delProof" value="删除" />
					</div>
					<div class="left">
						<label for="descProof">材料描述：</label>
						<input type="text" id="descProof" name="descProof" />
					</div>
					<div class="clear"></div>
				</div>
			</div>
		</div>
	</div>
	
    <p id="tijiao">
		<input type="submit" id="submit" name="submit" onclick="checkResult('save');" class="btn" value="保存" />
		<input type="submit" id="submit" name="submit" onclick="checkResult('confirm');" class="btn" value="提交" />
		<input type="reset" class="btn" value="重置" />
	</p>
	</div>
	</form>

</body>
</html>