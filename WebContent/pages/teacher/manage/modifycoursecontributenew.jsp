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
    <title>修改本科教学工程信息</title>
    
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
	
	<link rel="stylesheet" type="text/css" href="js/XYTipsWindow/style.css">
	<script type="text/javascript" src="js/XYTipsWindow/jquery.XYTipsWindow.2.8.js"></script>
	<script type="text/javascript" src="js/jquery.clearfield.js"></script>
	
	
</head>
<body style="padding:0px;"> 
		
	<form id="form" name="form" action="modifyCourseContributeNew.action" onsubmit="return checkClickAndSubmit();" method="post" enctype="multipart/form-data">
	<div id="allpage">

	<div class="item">
		<div class="title">
			1.本科教学工程信息
		</div>
		<div class="content">
		<s:iterator value="CourseContributeNew" >
		<input type="hidden" id="courseId" name="courseId" value='<s:property value="courseId"/>'/>
			<div class="line">
				<div class="element">
					<label for="classContribute">项目级别:</label>
					<select name="classContribute" id="classContribute" style="width:155px;height:26px" >
						<s:if test='classContribute=="国家级"'>
							<option value="国家级" selected="selected">国家级</option>
							<option value="省部级" >省部级</option>
							<option value="校级" >校级</option>
						</s:if>
						<s:elseif test='classContribute=="省部级"'>
							<option value="国家级" >国家级</option>
							<option value="省部级" selected="selected">省部级</option>
							<option value="校级" >校级</option>
						</s:elseif>
						<s:elseif test='classContribute=="校级"'>
							<option value="国家级" >国家级</option>
							<option value="省部级" >省部级</option>
							<option value="校级" selected="selected">校级</option>
						</s:elseif>
			 		</select>
				</div>
				<div class="element">
					<label for="typeContribute">项目类别:</label>
					<select name="typeContribute" id="typeContribute" style="width:155px;height:26px" >
						<s:if test='typeContribute=="高等学校特色专业建设点"'>
							<option value="高等学校特色专业建设点" selected="selected">高等学校特色专业建设点</option>
							<option value="“专业综合改革试点”项目" >“专业综合改革试点”项目</option>
							<option value="精品开放课程" >精品开放课程</option>
							<option value="精品视频公开课" >精品视频公开课</option>
							<option value="教学团队" >教学团队</option>
							<option value="教学名师" >教学名师</option>
							<option value="实验教学示范中心" >实验教学示范中心</option>
							<option value="精品资源共享课" >精品资源共享课</option>
							<option value="重点课程" >重点课程</option>
						</s:if>
						<s:elseif test='typeContribute=="“专业综合改革试点”项目"'>
							<option value="高等学校特色专业建设点" >高等学校特色专业建设点</option>
							<option value="“专业综合改革试点”项目" selected="selected">“专业综合改革试点”项目</option>
							<option value="精品开放课程" >精品开放课程</option>
							<option value="精品视频公开课" >精品视频公开课</option>
							<option value="教学团队" >教学团队</option>
							<option value="教学名师" >教学名师</option>
							<option value="实验教学示范中心" >实验教学示范中心</option>
							<option value="精品资源共享课" >精品资源共享课</option>
							<option value="重点课程" >重点课程</option>
						</s:elseif>
						<s:elseif test='typeContribute=="精品开放课程"'>
							<option value="高等学校特色专业建设点" >高等学校特色专业建设点</option>
							<option value="“专业综合改革试点”项目" >“专业综合改革试点”项目</option>
							<option value="精品开放课程" selected="selected">精品开放课程</option>
							<option value="精品视频公开课" >精品视频公开课</option>
							<option value="教学团队" >教学团队</option>
							<option value="教学名师" >教学名师</option>
							<option value="实验教学示范中心" >实验教学示范中心</option>
							<option value="精品资源共享课" >精品资源共享课</option>
							<option value="重点课程" >重点课程</option>
						</s:elseif>
						<s:elseif test='typeContribute=="精品视频公开课"'>
							<option value="高等学校特色专业建设点" >高等学校特色专业建设点</option>
							<option value="“专业综合改革试点”项目" >“专业综合改革试点”项目</option>
							<option value="精品开放课程" >精品开放课程</option>
							<option value="精品视频公开课" selected="selected">精品视频公开课</option>
							<option value="教学团队" >教学团队</option>
							<option value="教学名师" >教学名师</option>
							<option value="实验教学示范中心" >实验教学示范中心</option>
							<option value="精品资源共享课" >精品资源共享课</option>
							<option value="重点课程" >重点课程</option>
						</s:elseif>
						<s:elseif test='typeContribute=="教学团队"'>
							<option value="高等学校特色专业建设点" >高等学校特色专业建设点</option>
							<option value="“专业综合改革试点”项目" >“专业综合改革试点”项目</option>
							<option value="精品开放课程" >精品开放课程</option>
							<option value="精品视频公开课" >精品视频公开课</option>
							<option value="教学团队" selected="selected">教学团队</option>
							<option value="教学名师" >教学名师</option>
							<option value="实验教学示范中心" >实验教学示范中心</option>
							<option value="精品资源共享课" >精品资源共享课</option>
							<option value="重点课程" >重点课程</option>
						</s:elseif>
						<s:elseif test='typeContribute=="教学名师"'>
							<option value="高等学校特色专业建设点" >高等学校特色专业建设点</option>
							<option value="“专业综合改革试点”项目" >“专业综合改革试点”项目</option>
							<option value="精品开放课程" >精品开放课程</option>
							<option value="精品视频公开课" >精品视频公开课</option>
							<option value="教学团队" >教学团队</option>
							<option value="教学名师" selected="selected">教学名师</option>
							<option value="实验教学示范中心" >实验教学示范中心</option>
							<option value="精品资源共享课" >精品资源共享课</option>
							<option value="重点课程" >重点课程</option>
						</s:elseif>
						<s:elseif test='typeContribute=="实验教学示范中心"'>
							<option value="高等学校特色专业建设点" >高等学校特色专业建设点</option>
							<option value="“专业综合改革试点”项目" >“专业综合改革试点”项目</option>
							<option value="精品开放课程" >精品开放课程</option>
							<option value="精品视频公开课" >精品视频公开课</option>
							<option value="教学团队" >教学团队</option>
							<option value="教学名师" >教学名师</option>
							<option value="实验教学示范中心" selected="selected">实验教学示范中心</option>
							<option value="精品资源共享课" >精品资源共享课</option>
							<option value="重点课程" >重点课程</option>
						</s:elseif>
						<s:elseif test='typeContribute=="精品资源共享课"'>
							<option value="高等学校特色专业建设点" >高等学校特色专业建设点</option>
							<option value="“专业综合改革试点”项目" >“专业综合改革试点”项目</option>
							<option value="精品开放课程" >精品开放课程</option>
							<option value="精品视频公开课" >精品视频公开课</option>
							<option value="教学团队" >教学团队</option>
							<option value="教学名师" >教学名师</option>
							<option value="实验教学示范中心" >实验教学示范中心</option>
							<option value="精品资源共享课" selected="selected">精品资源共享课</option>
							<option value="重点课程" >重点课程</option>
						</s:elseif>
						<s:elseif test='typeContribute=="重点课程"'>
							<option value="高等学校特色专业建设点" >高等学校特色专业建设点</option>
							<option value="“专业综合改革试点”项目" >“专业综合改革试点”项目</option>
							<option value="精品开放课程" >精品开放课程</option>
							<option value="精品视频公开课" >精品视频公开课</option>
							<option value="教学团队" >教学团队</option>
							<option value="教学名师" >教学名师</option>
							<option value="实验教学示范中心" >实验教学示范中心</option>
							<option value="精品资源共享课" >精品资源共享课</option>
							<option value="重点课程" selected="selected">重点课程</option>
						</s:elseif>
			 		</select>
				</div>
				<div class="element">
					<label for="courseName">项目名称:</label>
					<input type="text" id="courseName" name="courseName" value='<s:property value="courseName"/>' class=":required"/>
				</div>
				
			</div>
			<div class="line">
				<div class="element">
					<label for="applicantRanking">申报人排名:</label>
					<input type="text" id="applicantRanking" name="applicantRanking" value='<s:property value="applicantRanking"/>' class=":required"/>
				</div>
				<div class="element">
					<label for="checkTime">立项时间</label>
					<input type="text" id="checkTime" name="checkTime" value="${checkTime}"/>
				</div>
				<div class="element">
					<label for="endTime">结题时间</label>
					<input type="text" id="endTime" name="endTime" value="${endTime}"/>
				</div>
				
			</div>
			<div class="line">
				<div class="element">
					<label for="timeContribute">项目来源:</label>
					<input type="text" id="timeContribute" name="timeContribute" value='<s:property value="timeContribute"/>' class=":required"/>
				</div>
			    <div class="element">
					<label for="collegeAward">奖励金额:</label>
					<input type="text" id="collegeAward" name="collegeAward" value='<s:property value="collegeAward"/>' class=":number"/>
				</div>
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
			2.本科教学工程负责人信息
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
					<label for="memberName">负责人姓名:</label>
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