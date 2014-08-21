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
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>录入发表教改论文信息</title>
    <link href="lib/ligerUI/skins/Aqua/css/ligerui-all.css" rel="stylesheet" type="text/css" />
    <link href="lib/ligerUI/skins/ligerui-icons.css" rel="stylesheet" type="text/css" />
    <link href="css/Data.css" rel="stylesheet" type="text/css" />
    <script src="lib/jquery/jquery-1.5.2.min.js" type="text/javascript"></script> 
    <script src="js/addPerson.js" type="text/javascript"></script>
    <script src="js/vanadium.js" type="text/javascript"></script>
	<script src="js/check.js" type="text/javascript"></script>
	<link href="css/input.css" rel="stylesheet" type="text/css" />
	<link href="css/upload.css" rel="stylesheet" type="text/css" />
	<script src="lib/ligerUI/js/ligerui.min.js" type="text/javascript"></script>
	<script type="text/javascript">
	$(function ()
	{
		$("#timeAchievements").ligerDateEditor({ showTime: true, width: 130, label: '发表日期', labelWidth: 123,labelAlign: 'center', format: "yyyy-MM-dd"});
	});
	</script>
</head>
<body style="padding:0px;">
	<form id="form" name="form" action="submitTeachAchievementsNew.action" onsubmit="return checkClickAndSubmit();" method="post" enctype="multipart/form-data">
	<div id="allpage">
	<div class="item">
		<div class="title">
			录入发表教改论文信息
			<div class="clear"></div>
		</div>
		<div class="content">
			<div class="line">
				<div class="element">
					<label for="classAchievements">期刊类别:</label>
					<select name="classAchievements" id="classAchievements" style="width:155px;height:26px" class=":required">
							<option value="CSSCI来源" >CSSCI来源</option>
							<option value="CSSCI扩展" >CSSCI扩展</option>
							<option value="北大核心" >北大核心</option>
							<option value="一般" >一般</option>		
			 		</select>
				</div>
				<div class="element">
					<label for="levelAchievements">期刊名称:</label>
					<input type="text" id="levelAchievements" name="levelAchievements" class=":required" />
				</div>
				<div class="element">
					<label for="projectName">论文名称:</label>
					<input type="text" id="projectName" name="projectName" class=":required" />
				</div>
				
			</div>
			
			<div class="line">
				<div class="element">
					<label for="firstChargeMan">是否为第一负责人:</label>
					<input type="text" id="firstChargeMan" name="firstChargeMan" class=":required" />
				</div>
				<div class="element">
					<label for="authorRank">作者排名:</label>
					<input type="text" id="authorRank" name="authorRank" class=":required"/>
				</div>
				<div class="element">
					<label for="publisher">出版单位:</label>
					<input type="text" id="publisher" name="publisher" class=":required"/>
				</div>
				
				
			</div>
			
			<div class="line">
				<div class="element">
					<label for="timeAchievements"></label>
					<input type="text" id="timeAchievements" name="timeAchievements" />
				</div>
				<div class="element">
					<label for="wordsNumber">字数（千字）:</label>
					<input type="text" id="wordsNumber" name="wordsNumber" class=":number"/>
				</div>
				<div class="element">
					<label for="remarks">备注:</label>
					<input type="text" id="remarks" name="remarks" />
				</div>
				
			</div>
			<div class="line">
				<div class="element">
					<label for="collegeAward">奖励金额:</label>
					<input type="text" id="collegeAward" name="collegeAward" class=":number" />
				</div>
			</div>
			<div class="clear" style="height:15px;"></div>
			<div class="title">
			作者信息
			</div>
			<div id="membertoolbar"></div>
			<div class="line spe">
				<div class="element del person">
					<label for="memberName">作者姓名:</label>
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