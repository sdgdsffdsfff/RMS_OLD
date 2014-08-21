<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%    
      String path = request.getContextPath();
      String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
       
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<base href="<%=basePath%>">
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>录入本科教学工程信息</title>
    <link href="lib/ligerUI/skins/Aqua/css/ligerui-all.css" rel="stylesheet" type="text/css" />
    <link href="lib/ligerUI/skins/ligerui-icons.css" rel="stylesheet" type="text/css" />
    <link href="css/Data.css" rel="stylesheet" type="text/css" />
    <script src="lib/jquery/jquery-1.5.2.min.js" type="text/javascript"></script>
    <script src="js/addPerson.js" type="text/javascript"></script>
    <script src="js/vanadium.js" type="text/javascript"></script>
	<script src="js/check.js" type="text/javascript"></script>
	<link href="css/input.css" rel="stylesheet" type="text/css" />
	<link href="css/upload.css" rel="stylesheet" type="text/css" />
	<script type="text/javascript">
	$(function ()
	{
		
		$("#rewardTime").ligerDateEditor({ showTime: true, width: 130, label: '获奖时间', labelWidth: 123,labelAlign: 'center', format: "yyyy-MM-dd"});
	});
	</script>
	<script src="lib/ligerUI/js/ligerui.min.js" type="text/javascript"></script>
</head>
<body style="padding:0px;">
	<form id="form" name="form" action="submitStudentAwardsNew.action" onsubmit="return checkClickAndSubmit();" method="post" enctype="multipart/form-data">
	<div id="allpage">
	<div class="item">
		<div class="title">
			录入指导学生参赛获奖信息
			<div class="clear"></div>
		</div>
		<div class="content">
			<div class="line">
				<div class="element">
					<label for="rewardLevel">获奖级别:</label>
					<select name="rewardLevel" id="rewardLevel" style="width:155px;height:26px" class=":required">
							<option value="国家级" >国家级</option>
							<option value="省部级" >省部级</option>
							<option value="校级" >校级</option>
			 		</select>
				</div>
				<div class="element">
					<label for="rewardName">赛事名称:</label>
					<input type="text" id="rewardName" name="rewardName" class=":required" />
				</div>
				<div class="element">
					<label for="rewardStudents">学生团队成员:</label>
					<input type="text" id="rewardStudents" name="rewardStudents" class=":required" />
				</div>
			</div>
			
			<div class="line">
				<div class="element">
					<label for="rewardTime"></label>
					<input type="text" id="rewardTime" name="rewardTime" />
				</div>
			</div>
			
			<div class="line">
			    <div class="element">
					<label for="timeContribute">颁奖单位:</label>
					<input type="text" id="rewardUnit" name="rewardUnit" class=":required" />
				</div>
				<div class="element">
					<label for="collegeAward">奖励金额:</label>
					<input type="text" id="collegeAward" name="collegeAward" class=":number" />
				</div>
				<div class="element">
					<label for="remarks">备注:</label>
					<input type="text" id="remarks" name="remarks" />
				</div>
			</div>
			
			<div class="clear" style="height:15px;"></div>
			<div class="title">
			负责人信息
			</div>
			<div id="membertoolbar"></div>
			<div class="line spe">
				<div class="element del person">
					<label for="firstStudents">排名第一的学生姓名:</label>
					<input type="text" id="firstStudents" name="firstStudents" />
				</div>
				<div class="element del detail">
					<label for="remarksMem">备注:</label>
					<input type="text" id="remarksMem" name="remarksMem" />
				</div>
				<div class="element del">
					<input type="button" style="width:50px;" name="Par" class="delPerson" value="删除" />
				</div>
			</div>
			
			<div id="hippo" style="margin:0; padding:0">
			<div class="clear" style="height:15px;"></div>
    			<div class="title">
    			上传旁证材料
    			</div>
    			<div id="newproofstoolbar"></div>
    			<div class="clear" style="height:15px;"></div>
				<div class="disc common">
					<div class="left text">
						<input type="file" class="file" name="upload" value="浏览" />
					</div>
					<div class="left btn">
						<input type="button" style="width:50px;" name="Par" class="delPerson" value="删除" />
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