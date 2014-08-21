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
    <title>人文社科科研项目详细信息</title>
    
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
			1.科研项目基本信息
		</div>
    	<s:iterator value="humanitiesProject" >
		<div class="content">
			<div class="line">
				<div class="element">
					<label for="projectName">项目名称:</label>
					<input type="text" id="projectName" name="projectName" value='<s:property value="projectName"/>' readonly/>
				</div>
				<div class="element">
					<label for="projectNumber">项目编号:</label>
					<input type="text" id="projectNumber" name="projectNumber" value='<s:property value="projectNumber"/>' readonly/>
				</div>
				<div class="element">
					<label for="projectOrigin">项目来源:</label>
					<input type="text" id="projectOrigin" name="projectOrigin" value='<s:property value="projectOrigin"/>' readonly/>
				</div>
			</div>
			<div class="line">
				<div class="element">
					<label for="timeApproved">批准时间:</label>
					<input type="text" id="timeApproved" name="timeApproved" value="${timeApproved}" readonly/>
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
					<s:if test="status==4">
					<input type="text" id="status" name="status" value='已保存(已更新)' />
					</s:if>
					<s:if test="status==5">
					<input type="text" id="status" name="status" value='未审批(已更新)' />
					</s:if>
					<s:if test="status==6">
					<input type="text" id="status" name="status" value='审批通过(已更新)' />
					</s:if>
					<s:if test="status==7">
					<input type="text" id="status" name="status" value='审批未通过(已更新)' />
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
			2.科研项目详细信息
		</div>
    	<s:iterator value="humanitiesProjectDetail" >
		<div class="content">
			<div class="line">
				<div class="element">
					<label for="updateTime">更新时间:</label>
					<input type="text" id="updateTime" name="updateTime" value="${updateTime}" readonly/>
				</div>
				<div class="element">
					<label for="projectStatus">目前状态（在研/完成）:</label>
					<input type="text" id="projectStatus" name="projectStatus" value='<s:property value="projectStatus"/>' readonly/>
				</div>
				<div class="element">
					<label for="money">当年投入经费（万元）:</label>
					<input type="text" id="money" name="money" value='<s:property value="money"/>' readonly/>
				</div>
			</div>
			<div class="line">
				<div class="element">
					<label for="timePerPerson">每人当年投入研究时间（月/研究人员姓名）:</label>
					<input type="text" id="timePerPerson" name="timePerPerson" value='<s:property value="timePerPerson"/>' readonly/>
				</div>
			</div>
		</div>
		</s:iterator>
	</div>
	<div class="clear" style="height:15px;"></div>
	<div class="item">
		<div class="title">
			3.科研项目参与人信息
		</div>
		<s:iterator value="memberList" >
		<div class="content">
			<div class="line">
				<div class="element">
					<label for="memberName">参与人员的姓名:</label>
					<input type="text" id="memberName" name="memberName" value='<s:property value="memberName"/>'/>
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
			4.旁证材料
		</div>
		<div class="content">
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
    	</div>
    </div>
    
</div>

</body>
</html>