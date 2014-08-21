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
		
		$("#setTime").ligerDateEditor({ showTime: true, width: 130, label: '出版日期', labelWidth: 123,labelAlign: 'center', format: "yyyy-MM-dd"});
	});
	</script>
	<script src="lib/ligerUI/js/ligerui.min.js" type="text/javascript"></script>
</head>
<body style="padding:0px;">
	<form id="form" name="form" action="submitTeachingMaterialSetNew.action" onsubmit="return checkClickAndSubmit();" method="post" enctype="multipart/form-data">
	<div id="allpage">
	<div class="item">
		<div class="title">
			录入本科教学工程信息
			<div class="clear"></div>
		</div>
		<div class="content">
			<div class="line">
				<div class="element">
					<label for="setClass">教材等级:</label>
					<select name="setClass" id="setClass" style="width:155px;height:26px" class=":required">
							<option value="正式出版国家规划教材" >正式出版国家规划教材</option>
							<option value="正式出版一般教材" >正式出版一般教材</option>
			 		</select>
				</div>
				<div class="element">
					<label for="numberProject">教材类别:</label>
					<select name="numberProject" id="numberProject" style="width:155px;height:26px" class=":required">
							<option value="专著" >专著</option>
							<option value="编著" >编著</option>
							<option value="译著" >译著</option>
			 		</select>
				</div>
				<div class="element">
					<label for="teachingMaterialName">教材名称:</label>
					<input type="text" id="teachingMaterialName" name="teachingMaterialName" class=":required" />
				</div>
				
			</div>
			<div class="line">
				<div class="element">
					<label for="resultsPostedStatus">出版单位:</label>
					<input type="text" id="resultsPostedStatus" name="resultsPostedStatus" class=":required" />
				</div>
				<div class="element">
					<label for="setTime"></label>
					<input type="text" id="setTime" name="setTime" />
				</div>
				
			</div>
			<div class="line">
			    <div class="element">
					<label for="timeContribute">字数（千字）:</label>
					<input type="text" id="wordsNumbers" name="wordsNumbers" class=":required" />
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