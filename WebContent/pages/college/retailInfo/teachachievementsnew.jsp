<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags" %>
    
<%    
      String path = request.getContextPath();
      String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
       
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<base href="<%=basePath%>">
<head>
        <title>发表教改论文</title>
   
    
    <link href="lib/ligerUI/skins/Aqua/css/ligerui-all.css" rel="stylesheet" type="text/css" />
    <link href="css/Data.css" rel="stylesheet" type="text/css" />
    <script src="lib/jquery/jquery-1.3.2.min.js" type="text/javascript"></script> 
    <script src="lib/ligerUI/js/core/base.js" type="text/javascript"></script>
    <script src="lib/ligerUI/js/plugins/ligerGrid.js" type="text/javascript"></script> 
    <script src="lib/ligerUI/js/plugins/ligerTextBox.js" type="text/javascript"></script>
    <script src="lib/ligerUI/js/plugins/ligerCheckBox.js" type="text/javascript"></script>
    <script src="lib/ligerUI/js/plugins/ligerMenu.js" type="text/javascript"></script>
    <script src="lib/ligerUI/js/plugins/ligerComboBox.js" type="text/javascript"></script>
    <script src="lib/ligerUI/js/plugins/ligerMenuBar.js" type="text/javascript"></script>
    <script src="lib/ligerUI/js/plugins/ligerToolBar.js" type="text/javascript"></script>
    <script src="lib/ligerUI/js/plugins/ligerButton.js" type="text/javascript"></script>
    <script src="lib/ligerUI/js/plugins/ligerResizable.js" type="text/javascript"></script>
    <script src="lib/ligerUI/js/plugins/ligerDialog.js" type="text/javascript"></script>
    <script src="lib/ligerUI/js/plugins/ligerDrag.js" type="text/javascript"></script>
       <link rel="stylesheet" type="text/css" href="js/XYTipsWindow/style.css">
	<script type="text/javascript" src="js/XYTipsWindow/jquery.XYTipsWindow.2.8.js"></script>
	<script type="text/javascript" src="js/jquery.clearfield.js"></script>
    <script src="js/collegeaprovel/detail/CollegeProjectDetail.js" type="text/javascript"></script>

</head>
<body style="padding:0px;"> 
<s:iterator value="teachAchievementsNewlists" >

<div id="allpage">

	<div class="item">
		<div class="title">
			1.发表教改论文信息
		</div>
		<div class="content">
			<div class="line">
				<div class="element">
					<label for="classAchievements">期刊类别:</label>
					<input type="text" id="classAchievements" name="classAchievements" value='<s:property value="classAchievements"/>' readonly/>
				</div>
				<div class="element">
					<label for="levelAchievements">期刊名称:</label>
					<input type="text" id="levelAchievements" name="levelAchievements" value='<s:property value="levelAchievements"/>' readonly/>
				</div>
				<div class="element">
					<label for="projectName">论文名称:</label>
					<input type="text" id="projectName" name="projectName" value='<s:property value="projectName"/>' readonly/>
				</div>
				
			</div>
			<div class="line">
				<div class="element">
					<label for="firstChargeMan">是否为第一负责人:</label>
					<input type="text" id="firstChargeMan" name="firstChargeMan" value='<s:property value="firstChargeMan"/>' readonly/>
				</div>
				<div class="element">
					<label for="authorRank">作者排名:</label>
					<input type="text" id="authorRank" name="authorRank" value='<s:property value="authorRank"/>' readonly/>
				</div>
				<div class="element">
					<label for="publisher">出版单位:</label>
					<input type="text" id="publisher" name="publisher" value='<s:property value="publisher"/>' readonly/>
				</div>
				
				<div class="element">
					<label for="collegeAward">学院奖励:</label>
					<input type="text" id="collegeAward" name="collegeAward" value='<s:property value="collegeAward"/>' readonly/>
				</div>
			</div>
			
			<div class="line">
				<div class="element">
					<label for="timeAchievements">出版日期:</label>
					<input type="text" id="timeAchievements" name="timeAchievements" value='<s:property value="timeAchievements"/>' readonly/>
				</div>
				<div class="element">
					<label for="wordsNumber">字数（千字）:</label>
					<input type="text" id="wordsNumber" name="wordsNumber" value='<s:property value="wordsNumber"/>' readonly/>
				</div>
				<div class="element">
					<label for="remarks">备注:</label>
					<input type="text" id="remarks" name="remarks" value='<s:property value="remarks"/>' readonly/>
				</div>
				
			</div>
			<div class="line">
				<div class="element">
					<label for="collegeAward">奖励金额:</label>
					<input type="text" id="collegeAward" name="collegeAward" value='<s:property value="collegeAward"/>' readonly/>
				</div>
			    <div class="element">
					<label for="submitUser">提交该信息的用户:</label>
					<input type="text" id="submitUser" name="submitUser" value='<s:property value="submitUser.userName"/>'/>
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
		</div>
	</div>
	<div class="clear" style="height:15px;"></div>
	<div class="item">
		<div class="title">
			2.指导教师信息
		</div>
		<s:iterator value="teachersAwardsNewlists" >
		<div class="content">
			<div class="line">
				<div class="element">
					<label for="memberName">指导教师:</label>
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
     	<s:iterator value="proofslists">
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
    
    <div class="item">
		<div class="content">
    	<div style="text-align:right; padding:0 30px 20px 30px;">
	    <form action="collegeUpdateStatus.action?id=<s:property value="achievementsId"/>&modelName=TeachAchievementsNew&idName=achievementsId" onsubmit="return checkPassed();" method="post"> 
		
			<input style="background:url(images/button.png); width:57px; height:25px; border:0; cursor:pointer; color:#fff;" type="submit"  value="审批通过" />
			<input type="hidden" value="2" name="status">
		
	    </form>
	    <form name="form" onsubmit="return checkReturnReason();" action="collegeUpdateStatus.action?id=<s:property value="achievementsId"/>&modelName=TeachAchievementsNew&idName=achievementsId" method="post"> 
	    	<br/>
		    <p>
		    	拒绝理由：
		  		<input type="text" name="returnReason" id="returnReason" style="margin-right:20px;">
				<input type="submit" style="float:right;background:url(images/button.png); width:57px; height:25px; border:0; cursor:pointer;color:#fff;" value="审批拒绝"/>
				<input type="hidden" style="float:right;" value="3" name="status">
			</p>
	    </form>
	  </div>
		</div>
	</div>
    
</div>
</s:iterator>
</body>
</html>