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
<title>录入技术转让信息</title>
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
	<form id="form" name="form" action="submitScienceTechTransfer.action" onsubmit="return checkClickAndSubmit();" method="post" enctype="multipart/form-data">
	<div id="allpage">
	<div class="item">
		<div class="title">
			录入技术转让信息
			<div class="clear"></div>
		</div>
		<div class="content">
			<div class="line">
				<div class="element">
					<label for="collegeIn">所在学院:</label>
					<input type="text" id="collegeIn" name="collegeIn" class=":required" />
				</div>
				<div class="element">
					<label for="techName">项目/专利/技术名称:</label>
					<input type="text" id="techName" name="techName" class=":required" />
				</div>
			</div>
			<div class="line">
				<div class="element">
					<label for="transfereeUnit">受让单位:</label>
					<input type="text" id="transfereeUnit" name="transfereeUnit" />
				</div>
				<div class="element">
					<label for="unitProperties">受让单位性质:</label>
					<input type="text" id="unitProperties" name="unitProperties" />
				</div>
				<div class="element">
					<label for="contractAmount">合同金额（万元）:</label>
					<input type="text" id="contractAmount" name="contractAmount" class=":number" />
				</div>
			</div>
			<div class="line">
				<div class="element">
					<label for="realIncome">当年实际收入（万元）:</label>
					<input type="text" id="realIncome" name="realIncome" class=":number" />
				</div>
				<div class="element">
					<label for="transformationWay">成果转化方式:</label>
					<input type="text" id="transformationWay" name="transformationWay" />
				</div>
			</div>
			<div class="line">
				<div class="element">
					<label for="startTime"></label>
					<input type="text" id="startTime" name="startTime" />
				</div>
				<div class="element">
					<label for="endTime1"></label>
					<input type="text" id="endTime1" name="endTime" />
				</div>
				<div class="element">
					<label for="remarks">备注:</label>
					<input type="text" id="remarks" name="remarks" />
				</div>
			</div>
			
			<div class="clear" style="height:15px;"></div>
			<div class="title">
			项目负责人/成员信息
			</div>
			<div id="membertoolbar"></div>
			<div class="line spe">
				<div class="element del person">
					<label for="memberName">负责人/成员姓名:</label>
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
		<p>（1）技术转让需提交合同复印件。</p>
		<p>（2）受让单位性质：按国有企业、外资企业、民营企业和其他四类填报。</p>
		<p>（3）成果转化方式：按采纳和转让填报。</p>
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