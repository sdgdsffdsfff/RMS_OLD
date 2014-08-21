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
    <title>科技 活动机构详细信息</title>
    
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
			1.科技活动机构信息
		</div>
    	<s:iterator value="scienceOrganization" >
		<div class="content">
			<div class="line">
				<div class="element">
					<label for="organizationName">机构名称:</label>
					<input type="text" id="organizationName" name="organizationName" value='<s:property value="organizationName"/>' readonly/>
				</div>
				<div class="element">
					<label for="organizationType">机构类型:</label>
					<input type="text" id="organizationType" name="organizationType" value='<s:property value="organizationType"/>' readonly/>
				</div>
				<div class="element">
					<label for="organizationCategory">机构类别:</label>
					<input type="text" id="organizationCategory" name="organizationCategory" value='<s:property value="organizationCategory"/>' readonly/>
				</div>
			</div>
			<div class="line">
				<div class="element">
					<label for="sortSubject">学科分类:</label>
					<input type="text" id="sortSubject" name="sortSubject" value='<s:property value="sortSubject"/>' readonly/>
				</div>
				<div class="element">
					<label for="modusComposition">组成形式:</label>
					<input type="text" id="modusComposition" name="modusComposition" value='<s:property value="modusComposition"/>' readonly/>
				</div>
			</div>
			<div class="line">
				<div class="element">
					<label for="totalEmployees">从业人员（合计）:</label>
					<input type="text" id="totalEmployees" name="totalEmployees" value='<s:property value="totalEmployees"/>' readonly/>
				</div>
				<div class="element">
					<label for="doctorEmployees">从业人员（其中博士毕业）:</label>
					<input type="text" id="doctorEmployees" name="doctorEmployees" value='<s:property value="doctorEmployees"/>' readonly/>
				</div>
				<div class="element">
					<label for="publishedTime">从业人员（其中硕士毕业）:</label>
					<input type="text" id="masterEmployees" name="masterEmployees" value='<s:property value="masterEmployees"/>' readonly/>
				</div>
			</div>
			<div class="line">
			    <div class="element">
					<label for="totalIts">科技活动人员【人年】（合计）:</label>
					<input type="text" id="totalIts" name="totalIts" value='<s:property value="totalIts"/>' readonly/>
				</div>
				<div class="element">
					<label for="advancedIts">科技活动人员【人年】（高级职称）:</label>
					<input type="text" id="advancedIts" name="advancedIts" value='<s:property value="advancedIts"/>' readonly/>
				</div>
				<div class="element">
					<label for="middleIts">科技活动人员【人年】（中级职称）:</label>
					<input type="text" id="middleIts" name="middleIts" value='<s:property value="middleIts"/>' readonly/>
				</div>
			</div>
			<div class="line">
			    <div class="element">
					<label for="juniorIts">科技活动人员【人年】（初级职称）:</label>
					<input type="text" id="juniorIts" name="juniorIts" value='<s:property value="juniorIts"/>' readonly/>
				</div>
				<div class="element">
					<label for="otherIts">科技活动人员【人年】（其他）:</label>
					<input type="text" id="otherIts" name="otherIts" value='<s:property value="otherIts"/>' readonly/>
				</div>
			</div>
			<div class="line">
			    <div class="element">
					<label for="numGraduates">培养研究生（人）:</label>
					<input type="text" id="numGraduates" name="numGraduates" value='<s:property value="numGraduates"/>' readonly/>
				</div>
				<div class="element">
					<label for="internalExpenditures">当年经费内部支出（千元）:</label>
					<input type="text" id="internalExpenditures" name="internalExpenditures" value='<s:property value="internalExpenditures"/>' readonly/>
				</div>
				<div class="element">
					<label for="rdExpenditures">当年经费内部支出其中R&D支出（千元）:</label>
					<input type="text" id="rdExpenditures" name="rdExpenditures" value='<s:property value="rdExpenditures"/>' readonly/>
				</div>
			</div>
			<div class="line">
			    <div class="element">
					<label for="assetsFixed">固定资产原值（千元）:</label>
					<input type="text" id="assetsFixed" name="assetsFixed" value='<s:property value="assetsFixed"/>' readonly/>
				</div>
				<div class="element">
					<label for="assetsEquipment">固定资产原值其中仪器设备（千元）:</label>
					<input type="text" id="assetsEquipment" name="assetsEquipment" value='<s:property value="assetsEquipment"/>' readonly/>
				</div>
				<div class="element">
					<label for="assetsImport">固定资产原值其中进口（千元）:</label>
					<input type="text" id="assetsImport" name="assetsImport" value='<s:property value="assetsImport"/>' readonly/>
				</div>
			</div>
			<div class="line">
			    <div class="element">
					<label for="numIssueAssume">承担课题（项）:</label>
					<input type="text" id="numIssueAssume" name="numIssueAssume" value='<s:property value="numIssueAssume"/>' readonly/>
				</div>
				<div class="element">
					<label for="industryService">服务的国民经济行业:</label>
					<input type="text" id="industryService" name="industryService" value='<s:property value="industryService"/>' readonly/>
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
			2.旁证材料
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