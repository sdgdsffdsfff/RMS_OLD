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
    <title>修改理科科技项目信息</title>
    
    <link href="lib/ligerUI/skins/Aqua/css/ligerui-all.css" rel="stylesheet" type="text/css" />
    <link href="lib/ligerUI/skins/ligerui-icons.css" rel="stylesheet" type="text/css" />
    <link href="css/Data.css" rel="stylesheet" type="text/css" />
    <script src="lib/jquery/jquery-1.5.2.min.js" type="text/javascript"></script>
    <script src="js/modifyPerson.js" type="text/javascript"></script>
    <script src="js/vanadium.js" type="text/javascript"></script>
	<script src="js/check.js" type="text/javascript"></script>
	<link href="css/input.css" rel="stylesheet" type="text/css" />
	<link href="css/upload.css" rel="stylesheet" type="text/css" />
	<script src="js/teacher/modifySciTecProInfo.js" type="text/javascript"></script>
	<script src="lib/ligerUI/js/ligerui.min.js" type="text/javascript"></script>
	
	<link rel="stylesheet" type="text/css" href="js/XYTipsWindow/style.css">
	<script type="text/javascript" src="js/XYTipsWindow/jquery.XYTipsWindow.2.8.js"></script>
	<script type="text/javascript" src="js/jquery.clearfield.js"></script>
</head>
<body style="padding:0px;"> 
		
	<form id="form" name="form" action="modifyScienceTechProject.action" onsubmit="return checkClickAndSubmit();" method="post" enctype="multipart/form-data">
	<div id="allpage">

	<div class="item">
		<div class="title">
			1.科技项目基本信息
		</div>
		<div class="content">
		<s:iterator value="scienceTechProject" >
    	<input type="hidden" id="projectId" name="projectId" value='<s:property value="projectId"/>'/>
			<div class="line">
				<div class="element">
					<label for="projectName">项目名称:</label>
					<input type="text" id="projectName" name="projectName" value='<s:property value="projectName"/>' class=":required"/>
				</div>
				<div class="element">
					<label for="timeProjectApproved"></label>
					<input type="text" id="timeProjectApproved" name="timeProjectApproved" value="${timeProjectApproved}"/>
				</div>
				<div class="element">
					<label for="totalFundContract">合同总经费（千元）:</label>
					<input type="text" id="totalFundContract" name="totalFundContract" value='<s:property value="totalFundContract"/>' class=":number"/>
				</div>
			</div>
			<div class="line">
				<div class="element">
					<label for="sortSubject">学科分类:</label>
					<input type="text" id="sortSubject" name="sortSubject" value='<s:property value="sortSubject"/>' />
				</div>
				<div class="element">
					<label for="sortActivity">活动分类:</label>
					<input type="text" id="sortActivity" name="sortActivity" value='<s:property value="sortActivity"/>' />
				</div>
				<div class="element">
					<label for="originProject">项目来源:</label>
					<input type="text" id="originProject" name="originProject" value='<s:property value="originProject"/>' />
				</div>
			</div>
			<div class="line">
			    <div class="element">
					<label for="formOrganization">组织形式:</label>
					<input type="text" id="formOrganization" name="formOrganization" value='<s:property value="formOrganization"/>' />
				</div>
				<div class="element">
					<label for="formCooperation">合作形式:</label>
					<input type="text" id="formCooperation" name="formCooperation" value='<s:property value="formCooperation"/>' />
				</div>
				<div class="element">
					<label for="organReliedProject">项目依托科研机构:</label>
					<input type="text" id="organReliedProject" name="organReliedProject" value='<s:property value="organReliedProject"/>' />
				</div>
			</div>
			<div class="line">
			    <div class="element">
					<label for="industryService">服务的国民经济行业:</label>
					<input type="text" id="industryService" name="industryService" value='<s:property value="industryService"/>' />
				</div>
				<div class="element">
					<label for="unitProject">项目所在部门:</label>
					<input type="text" id="unitProject" name="unitProject" value='<s:property value="unitProject"/>' />
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
			2.科技项目详细信息
			</div>
			<s:iterator value="scienceDetailTechProject" >
			<input type="hidden" id="deatilProjectId" name="deatilProjectId" value='<s:property value="deatilProjectId"/>'/>
			<div class="line">
				<div class="element">
					<label for="updateTime">更新时间:</label>
					<input type="text" id="updateTime" name="updateTime" value="${updateTime}" readonly/>
				</div>
				<div class="element">
					<label for="inputThisYear">当年拨入经费（千元）:</label>
					<input type="text" id="inputThisYear" name="inputThisYear" value='<s:property value="inputThisYear"/>' class=":number"/>
				</div>
				<div class="element">
					<label for="expenditureThisYear">当年支出经费（千元）:</label>
					<input type="text" id="expenditureThisYear" name="expenditureThisYear" value='<s:property value="expenditureThisYear"/>' class=":number"/>
				</div>
			</div>
			<div class="line">
				<div class="element">
					<label for="totalStaff">当年投入人员（人年）【合计】:</label>
					<input type="text" id="totalStaff" name="totalStaff" value='<s:property value="totalStaff"/>' class=":digits"/>
				</div>
				<div class="element">
					<label for="advancedStaff">当年投入人员（人年）【高级职务】:</label>
					<input type="text" id="advancedStaff" name="advancedStaff" value='<s:property value="advancedStaff"/>' class=":digits"/>
				</div>
				<div class="element">
					<label for="middleStaff">当年投入人员（人年）【中级职务】:</label>
					<input type="text" id="middleStaff" name="middleStaff" value='<s:property value="middleStaff"/>' class=":digits"/>
				</div>
			</div>
			<div class="line">
			    <div class="element">
					<label for="juniorStaff">当年投入人员（人年）【初级职务】:</label>
					<input type="text" id="juniorStaff" name="juniorStaff" value='<s:property value="juniorStaff"/>' class=":digits"/>
				</div>
				<div class="element">
					<label for="otherStaff">当年投入人员（人年）【其他】:</label>
					<input type="text" id="otherStaff" name="otherStaff" value='<s:property value="otherStaff"/>' class=":digits"/>
				</div>
			</div>
			<div class="line">
			    <div class="element">
					<label for="graduateJoin">参与研究生数（人）:</label>
					<input type="text" id="graduateJoin" name="graduateJoin" value='<s:property value="graduateJoin"/>' class=":digits"/>
				</div>
				<div class="element">
					<label for="projectStatus">项目状态:</label>
					<input type="text" id="projectStatus" name="projectStatus" value='<s:property value="projectStatus"/>' />
				</div>
			</div>
			</s:iterator>
			
			<div class="clear" style="height:15px;"></div>
			<div class="title">
			3.科技项目参与人信息
			</div>
			<div id="membertoolbar"></div>
			<s:if test="%{#memberList == null || #memberList.isEmpty()}">
				<div class="line spe">
					<div class="element del person">
						<label for="memberName">参与人员的姓名</label>
						<input type="text" id="memberName" name="memberName" />
					</div>
					<div class="element del detail">
						<label for="remarksMem">备注</label>
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
					<label for="memberName">参与人员的姓名</label>
					<input type="text" id="memberName" name="memberName" value='<s:property value="memberName"/>'/>
				</div>
				<div class="element del detail">
					<label for="remarksMem">备注</label>
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
			4.已上传的旁证材料
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
    	
    	<div class="clear" style="height:15px;"></div><br/>
    		<div class="title">
    		5.添加新的旁证材料
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
		<div class="clear" style="height:15px;"></div><br/>
		<p>说明：</p>
		<p>（1）填报当年度列入学校年度计划和虽未列入计划，但通过签订合同、协议或计划任务书经学校确认的理、工、农、医、学科的各类科技课题。</p>
		<p>（2）项目批准(合同签订)时间：8位数,前4位年份后4位月份+日期。例:2000年4月1日填为2000-04-01.</p>
		<p>（3）当年投入人员（人年）为折算数，按高级、中级、初级和其他（不计研究生）人数分别乘以本年度工作月数/10的加和，科技人员的年工作月数不超过10个月。投入研究时间以月来计，一年以十个月计。</p>
		<p>（4）学科分类：根据国标GB/T13745-92《学科分类与代码》，按二级学科填报（代码＋名称）。《学科分类与代码》可到科技处网页上查询。</p>
		<p>（5）活动类型：分为“基础研究”、“应用研究”、“试验发展”、“R&D成果应用”和“科技服务”填写。</p>
		<p>（6）项目来源：纵向项目填写下达项目名称，如科技部863项目、重庆市自然科学基金项目等；横向项目和院定项目分别标注“横向”、“院定”即可。</p>
		<p>（7）项目组织形式：“牵头单位”和“合作单位”。</p>
		<p>（8）项目合作形式：按“与国外合作”、“与国内高校合作”、“与国内研究机构合作”、“与在华外商独资企业合作”、“与国内其他企业合作”、“独立完成”和“其他”。</p>
		<p>（9）项目服务的国民经济行业：参见附表。</p>
    		
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