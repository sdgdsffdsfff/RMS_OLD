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
    <title>理科科技交流详细信息</title>
    
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
			1.理科科技交流信息
		</div>
    	<s:iterator value="scienceTechExchange" >
		<div class="content">
			<div class="line">
				<div class="element">
					<label for="collegesIn">所在部门:</label>
					<input type="text" id="collegesIn" name="collegesIn" value='<s:property value="collegesIn"/>' readonly/>
				</div>
				<div class="element">
					<label for="exchangeType">形式:</label>
					<input type="text" id="exchangeType" name="exchangeType" value='<s:property value="exchangeType"/>' readonly/>
				</div>
			</div>
			<div class="line">
				<div class="element">
					<label for="sendNumber">派遣人数（合作研究）:</label>
					<input type="text" id="sendNumber" name="sendNumber" value='<s:property value="sendNumber"/>' readonly/>
				</div>
				<div class="element">
					<label for="receiveNumber">接受人数（合作研究）:</label>
					<input type="text" id="receiveNumber" name="receiveNumber" value='<s:property value="receiveNumber"/>' readonly/>
				</div>
			</div>
			<div class="line">
			    <div class="element">
					<label for="attendNumber">出席人数（国际学术会议）:</label>
					<input type="text" id="attendNumber" name="attendNumber" value='<s:property value="attendNumber"/>' readonly/>
				</div>
				<div class="element">
					<label for="papersNumber">交流论文篇数（国际学术会议）:</label>
					<input type="text" id="papersNumber" name="papersNumber" value='<s:property value="papersNumber"/>' readonly/>
				</div>
				<div class="element">
					<label for="specialInvitedNumber">特邀报告篇数（国际学术会议）:</label>
					<input type="text" id="specialInvitedNumber" name="specialInvitedNumber" value='<s:property value="specialInvitedNumber"/>' readonly/>
				</div>
			</div>
			<div class="line">
			    <div class="element">
					<label for="exchangeHost">主办单位（国际学术会议）:</label>
					<input type="text" id="exchangeHost" name="exchangeHost" value='<s:property value="exchangeHost"/>' readonly/>
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
			2.科技交流参与人员信息
		</div>
		<s:iterator value="memberList" >
		<div class="content">
			<div class="line">
				<div class="element">
					<label for="memberName">参与人姓名:</label>
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
			3.旁证材料
		</div>
		<div class="content">
    	<div id="maingrid" style="margin:0; padding:0">
     	<s:iterator value="proofs">
     	<%System.out.println("proof"); %>
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