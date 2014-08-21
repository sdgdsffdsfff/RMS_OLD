<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>高校科研管理系统——登录</title>
<link href="css/common.css" rel="stylesheet" type="text/css" />
<link href="css/logo.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="js/jquery-1.4.2.js"></script>
<script type="text/javascript" src="js/jquery.validate.js"></script>
<script type="text/javascript">
	function loadimage(){
    	document.getElementById("randImage").src = "image.jsp?"+Math.random();
  	}
	$(function() {
		$.ajax({
			url : "forwardLogin.action",
			type : 'POST',
			dataType : 'JSON',
			timeout : 5000,
			error : function() {
				alert('没有选择身份');
			},
			success : function(msg) {
				$("#role").empty();
				$.each(eval(msg), function(i, item) {
					$(
							"<option value='" + item.id + "'>"
									+ item.roleLevelName + "</option>")
							.appendTo($("#role"));
				});
			}
		});
	})
</script>
</head>
<body>
<div id="allpage">
	<div id="logo">
		<a class="left" href="http://www.cqupt.edu.cn" target="_blank">
			<img src="image/logo.png" />
		</a>
		<div class="right">
			<p class="cn">重邮经济管理学院科研信息管理系统</p>
			<p class="slice"></p>
			<p class="en">CQUPT JingGuan KeYanXinXi GuanLiXiTong</p>
		</div>
	</div>
	<div id="mid">
		<div class="left"></div>
		<div class="right radius">
			<form action="login.action" method="post">
				<h3>请输入用户名和密码</h3>
				<FONT color="red"><s:actionerror /></FONT>
				<label for="userName">用户名</label>
				<input type="text" name="userName" id="userName" />
				<p class="clear"></p>
				<label for="userPwd">密码</label>
				<input type="password" name="userPwd" id="userPwd" />
				<p class="clear"></p>
				
				<label for="check">验证码</label>
				<input type="text" name="check" id="check" />
				<img id="randImage" src="image.jsp" />
				<span id="change" onclick="javascript:loadimage();">换一张</span>
				
				<p class="clear"></p>
				<label for="role">身份</label>
				<select name="loginType" id="role">
					<option value="0">请选择角色</option>
				</select>
				<p class="clear"></p>
				<div>
					<input type="submit" value="登录" id="login" />
					<input type="reset" value="重置" id="reset" />
					<p class="clear"></p>
				</div>
			</form>
		</div>
	</div>
	<div id="footer">
		<p>版权所有：&emsp;&emsp;管理员：&emsp;&emsp;电话：&emsp;&emsp;地点：重邮经管学院大楼</p>
		<p class="slice"></p>
		<p>技术支持：重庆邮电大学信管工作室</p>
	</div>
</div>
</body>
</html>