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
<title>录入政府科技奖励信息</title>
    <link href="lib/ligerUI/skins/Aqua/css/ligerui-all.css" rel="stylesheet" type="text/css" />
    <link href="lib/ligerUI/skins/ligerui-icons.css" rel="stylesheet" type="text/css" />
    <link href="css/Data.css" rel="stylesheet" type="text/css" />
    <script src="lib/jquery/jquery-1.5.2.min.js" type="text/javascript"></script> 
    <script src="js/addPerson.js" type="text/javascript"></script>
    <script src="js/vanadium.js" type="text/javascript"></script>
	<script src="js/check.js" type="text/javascript"></script>
	<link href="css/input.css" rel="stylesheet" type="text/css" />
	<link href="css/upload.css" rel="stylesheet" type="text/css" />
	<script src="js/teacher/inputInfo.js" type="text/javascript"></script>
	<script src="lib/ligerUI/js/ligerui.min.js" type="text/javascript"></script>
</head>
<body style="padding:0px;">
	<form id="form" name="form" action="submitScienceGovernmentAward.action" onsubmit="return checkClickAndSubmit();" method="post" enctype="multipart/form-data">
	<div id="allpage">
	<div class="item">
		<div class="title">
			录入政府科技奖励信息
			<div class="clear"></div>
		</div>
		<div class="content">
			<div class="line">
				<div class="element">
					<label for="collegesIn">所在学院:</label>
					<input type="text" id="collegesIn" name="collegesIn" class=":required" />
				</div>
				<div class="element">
					<label for="projectName">项目名称:</label>
					<input type="text" id="projectName" name="projectName" class=":required" />
				</div>
				<div class="element">
					<label for="awardingGrades">奖励等级:</label>
					<input type="text" id="awardingGrades" name="awardingGrades" />
				</div>
			</div>
			<div class="line">
				<div class="element">
					<label for="completeUnit">主要完成单位:</label>
					<input type="text" id="completeUnit" name="completeUnit" />
				</div>
			</div>
			<div class="line">
				<div class="element">
					<label for="unitAward">配套单位奖励金额（万元）:</label>
					<input type="text" id="unitAward" name="unitAward" class=":number" />
				</div>
				<div class="element">
					<label for="personAward">配套个人奖励金额（万元）:</label>
					<input type="text" id="personAward" name="personAward" class=":number" />
				</div>
				<div class="element">
					<label for="totalAward">合计奖励金额（万元）:</label>
					<input type="text" id="totalAward" name="totalAward" class=":number" />
				</div>
			</div>
			<div class="line">
				<div class="element">
					<label for="remarks">备注:</label>
					<input type="text" id="remarks" name="remarks" />
				</div>
			</div>
			
			<div class="clear" style="height:15px;"></div>
			<div class="title">
			完成人信息
			</div>
			<div id="membertoolbar"></div>
			<div class="line spe">
				<div class="element del person">
					<label for="memberName">完成人姓名:</label>
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