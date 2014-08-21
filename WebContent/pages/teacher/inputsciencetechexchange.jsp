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
	<title>录入科技交流信息</title>
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
	<form id="form" name="form" action="submitScienceTechExchange.action" onsubmit="return checkClickAndSubmit();" method="post" enctype="multipart/form-data">
	<div id="allpage">
	<div class="item">
		<div class="title">
			录入科技交流信息
			<div class="clear"></div>
		</div>
		<div class="content">
			<div class="line">
				<div class="element">
					<label for="collegesIn">所在部门:</label>
					<input type="text" id="collegesIn" name="collegesIn" class=":required" />
				</div>
				<div class="element">
					<label for="exchangeType">形式:</label>
					<input type="text" id="exchangeType" name="exchangeType" class=":required" />
				</div>
			</div>
			<div class="line">
				<div class="element">
					<label for="sendNumber">派遣人数（合作研究）:</label>
					<input type="text" id="sendNumber" name="sendNumber" class=":digits" />
				</div>
				<div class="element">
					<label for="receiveNumber">接受人数（合作研究）:</label>
					<input type="text" id="receiveNumber" name="receiveNumber" class=":digits" />
				</div>
			</div>
			<div class="line">
				<div class="element">
					<label for="attendNumber">出席人数（国际学术会议）:</label>
					<input type="text" id="attendNumber" name="attendNumber" class=":digits" />
				</div>
				<div class="element">
					<label for="papersNumber">交流论文篇数（国际学术会议）:</label>
					<input type="text" id="papersNumber" name="papersNumber" class=":digits" />
				</div>
				<div class="element">
					<label for="specialInvitedNumber">特邀报告篇数（国际学术会议）:</label>
					<input type="text" id="specialInvitedNumber" name="specialInvitedNumber" class=":digits" />
				</div>
			</div>
			<div class="line">
				<div class="element">
					<label for="exchangeHost">主办单位（国际学术会议）:</label>
					<input type="text" id="exchangeHost" name="exchangeHost" />
				</div>
			</div>
			
			<div class="clear" style="height:15px;"></div>
			<div class="title">
			参加人员信息
			</div>
			<div id="membertoolbar"></div>
			<div class="line spe">
				<div class="element del person">
					<label for="memberName">参加人员姓名:</label>
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
		
		<div class="clear" style="height:30px;"></div><br/>
		
    	<p>说明：</p>
		<p>（1）形式：国内；国境外（包括港澳）。</p><br/>
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