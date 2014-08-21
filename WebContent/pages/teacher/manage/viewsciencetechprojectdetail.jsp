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
    <title>理科科技项目详细信息</title>
    
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
			1.科技项目基本信息
		</div>
    	<s:iterator value="scienceTechProject" >
		<div class="content">
			<div class="line">
				<div class="element">
					<label for="projectName">项目名称:</label>
					<input type="text" id="projectName" name="projectName" value='<s:property value="projectName"/>' readonly/>
				</div>
				<div class="element">
					<label for="timeProjectApproved">合同批准（合同签订）时间:</label>
					<input type="text" id="timeProjectApproved" name="timeProjectApproved" value="${timeProjectApproved}" readonly/>
				</div>
				<div class="element">
					<label for="totalFundContract">合同总经费（千元）:</label>
					<input type="text" id="totalFundContract" name="totalFundContract" value='<s:property value="totalFundContract"/>' readonly/>
				</div>
			</div>
			<div class="line">
				<div class="element">
					<label for="sortSubject">学科分类:</label>
					<input type="text" id="sortSubject" name="sortSubject" value='<s:property value="sortSubject"/>' readonly/>
				</div>
				<div class="element">
					<label for="sortActivity">活动分类:</label>
					<input type="text" id="sortActivity" name="sortActivity" value='<s:property value="sortActivity"/>' readonly/>
				</div>
				<div class="element">
					<label for="originProject">项目来源:</label>
					<input type="text" id="originProject" name="originProject" value='<s:property value="originProject"/>' readonly/>
				</div>
			</div>
			<div class="line">
			    <div class="element">
					<label for="formOrganization">组织形式:</label>
					<input type="text" id="formOrganization" name="formOrganization" value='<s:property value="formOrganization"/>' readonly/>
				</div>
				<div class="element">
					<label for="formCooperation">合作形式:</label>
					<input type="text" id="formCooperation" name="formCooperation" value='<s:property value="formCooperation"/>' readonly/>
				</div>
				<div class="element">
					<label for="organReliedProject">项目依托科研机构:</label>
					<input type="text" id="organReliedProject" name="organReliedProject" value='<s:property value="organReliedProject"/>' readonly/>
				</div>
			</div>
			<div class="line">
			    <div class="element">
					<label for="industryService">服务的国民经济行业:</label>
					<input type="text" id="industryService" name="industryService" value='<s:property value="industryService"/>' readonly/>
				</div>
				<div class="element">
					<label for="unitProject">项目所在部门:</label>
					<input type="text" id="unitProject" name="unitProject" value='<s:property value="unitProject"/>' readonly/>
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
			2.科技项目详细信息
		</div>
		<div class="clear" style="height:15px;"></div>
    	<s:iterator value="scienceDetailTechProject" >
    	<div class="clear" style="height:15px;"></div>
		<div class="content">
			<div class="line">
				<div class="element">
					<label for="updateTime">更新时间:</label>
					<input type="text" id="updateTime" name="updateTime" value="${updateTime}" readonly/>
				</div>
				<div class="element">
					<label for="inputThisYear">当年拨入经费（千元）:</label>
					<input type="text" id="inputThisYear" name="inputThisYear" value='<s:property value="inputThisYear"/>' readonly/>
				</div>
				<div class="element">
					<label for="expenditureThisYear">当年支出经费（千元）:</label>
					<input type="text" id="expenditureThisYear" name="expenditureThisYear" value='<s:property value="expenditureThisYear"/>' readonly/>
				</div>
			</div>
			<div class="line">
				<div class="element">
					<label for="totalStaff">当年投入人员（人年）【合计】:</label>
					<input type="text" id="totalStaff" name="totalStaff" value='<s:property value="totalStaff"/>' readonly/>
				</div>
				<div class="element">
					<label for="advancedStaff">当年投入人员（人年）【高级职务】:</label>
					<input type="text" id="advancedStaff" name="advancedStaff" value='<s:property value="advancedStaff"/>' readonly/>
				</div>
				<div class="element">
					<label for="middleStaff">当年投入人员（人年）【中级职务】:</label>
					<input type="text" id="middleStaff" name="middleStaff" value='<s:property value="middleStaff"/>' readonly/>
				</div>
			</div>
			<div class="line">
			    <div class="element">
					<label for="juniorStaff">当年投入人员（人年）【初级职务】:</label>
					<input type="text" id="juniorStaff" name="juniorStaff" value='<s:property value="juniorStaff"/>' readonly/>
				</div>
				<div class="element">
					<label for="otherStaff">当年投入人员（人年）【其他】:</label>
					<input type="text" id="otherStaff" name="otherStaff" value='<s:property value="otherStaff"/>' readonly/>
				</div>
			</div>
			<div class="line">
			    <div class="element">
					<label for="graduateJoin">参与研究生数（人）:</label>
					<input type="text" id="graduateJoin" name="graduateJoin" value='<s:property value="graduateJoin"/>' readonly/>
				</div>
				<div class="element">
					<label for="projectStatus">项目状态:</label>
					<input type="text" id="projectStatus" name="projectStatus" value='<s:property value="projectStatus"/>' readonly/>
				</div>
			</div>
		</div>
		</s:iterator>
	</div>
	<div class="clear" style="height:15px;"></div>
	<div class="item">
		<div class="title">
			3.科技项目参与人信息
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