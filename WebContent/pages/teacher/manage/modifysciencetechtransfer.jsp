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
    <title>修改理科技术转让信息</title>
    
    <link href="lib/ligerUI/skins/Aqua/css/ligerui-all.css" rel="stylesheet" type="text/css" />
    <link href="lib/ligerUI/skins/ligerui-icons.css" rel="stylesheet" type="text/css" />
    <link href="css/Data.css" rel="stylesheet" type="text/css" />
    <script src="lib/jquery/jquery-1.5.2.min.js" type="text/javascript"></script>
    <script src="js/modifyPerson.js" type="text/javascript"></script>
    <script src="js/vanadium.js" type="text/javascript"></script>
	<script src="js/check.js" type="text/javascript"></script>
	<link href="css/input.css" rel="stylesheet" type="text/css" />
	<link href="css/upload.css" rel="stylesheet" type="text/css" />
	<script src="js/teacher/modifySciTransferInfo.js" type="text/javascript"></script>
	<script src="lib/ligerUI/js/ligerui.min.js" type="text/javascript"></script>
	
	<link rel="stylesheet" type="text/css" href="js/XYTipsWindow/style.css">
	<script type="text/javascript" src="js/XYTipsWindow/jquery.XYTipsWindow.2.8.js"></script>
	<script type="text/javascript" src="js/jquery.clearfield.js"></script>
</head>
<body style="padding:0px;"> 
		
	<form id="form" name="form" action="modifyScienceTechTransfer.action" onsubmit="return checkClickAndSubmit();" method="post" enctype="multipart/form-data">
	<div id="allpage">

	<div class="item">
		<div class="title">
			1.技术转让信息
		</div>
		<div class="content">
		<s:iterator value="scienceTechTransfer" >
		<input type="hidden" id="transferId" name="transferId" value='<s:property value="transferId"/>'/>
			<div class="line">
				<div class="element">
					<label for="collegeIn">所在学院:</label>
					<input type="text" id="collegeIn" name="collegeIn" value='<s:property value="collegeIn"/>' class=":required"/>
				</div>
				<div class="element">
					<label for="techName">项目/专利/技术名称:</label>
					<input type="text" id="techName" name="techName" value='<s:property value="techName"/>' class=":required"/>
				</div>
				<div class="element">
					<label for="projectLeader">项目负责人:</label>
					<input type="text" id="projectLeader" name="projectLeader" value='<s:property value="projectLeader"/>' />
				</div>
			</div>
			<div class="line">
				<div class="element">
					<label for="transfereeUnit">受让单位:</label>
					<input type="text" id="transfereeUnit" name="transfereeUnit" value='<s:property value="transfereeUnit"/>' />
				</div>
				<div class="element">
					<label for="unitProperties">受让单位性质:</label>
					<input type="text" id="unitProperties" name="unitProperties" value='<s:property value="unitProperties"/>' />
				</div>
			</div>
			<div class="line">
				<div class="element">
					<label for="contractAmount">合同金额（万元）:</label>
					<input type="text" id="contractAmount" name="contractAmount" value='<s:property value="contractAmount"/>' class=":number"/>
				</div>
			    <div class="element">
					<label for="realIncome">当年实际收入（万元）:</label>
					<input type="text" id="realIncome" name="realIncome" value='<s:property value="realIncome"/>' class=":number"/>
				</div>
				<div class="element">
					<label for="transformationWay">成果转化方式:</label>
					<input type="text" id="transformationWay" name="transformationWay" value='<s:property value="transformationWay"/>' />
				</div>
			</div>
			<div class="line">
			    <div class="element">
					<label for="startTime"></label>
					<input type="text" id="startTime" name="startTime" value="${startTime}"/>
				</div>
				<div class="element">
					<label for="endTime"></label>
					<input type="text" id="endTime" name="endTime" value="${endTime}"/>
				</div>
			</div>
			<div class="line">
			    <div class="element">
					<label for="remarks">备注:</label>
					<input type="text" id="remarks" name="remarks" value='<s:property value="remarks"/>' />
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
			<div class="title">
			2.项目负责人/成员信息
			</div>
			<div id="membertoolbar"></div>
			<s:if test="%{#memberList == null || #memberList.isEmpty()}">
				<div class="line spe">
					<div class="element del person">
						<label for="memberName">负责人/成员姓名:</label>
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
					<label for="memberName">负责人/成员姓名:</label>
					<input type="text" id="memberName" name="memberName" value='<s:property value="leaderName"/>'/>
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
    	<div class="bottomcontent">
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
		<div class="clear" style="height:30px;"></div><br/>
		
		<p>说明：</p>
		<p>（1）技术转让需提交合同复印件。</p>
		<p>（2）受让单位性质：按国有企业、外资企业、民营企业和其他四类填报。</p>
		<p>（3）成果转化方式：按采纳和转让填报。</p>
		
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