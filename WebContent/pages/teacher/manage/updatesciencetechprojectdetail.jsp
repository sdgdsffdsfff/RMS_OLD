<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%    
      String path = request.getContextPath();
      String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
      String projectId =  request.getParameter("projectId");
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<base href="<%=basePath%>">
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>更新科技项目详细信息</title>
    <link href="lib/ligerUI/skins/Aqua/css/ligerui-all.css" rel="stylesheet" type="text/css" />
    <link href="lib/ligerUI/skins/ligerui-icons.css" rel="stylesheet" type="text/css" />
    <link href="css/Data.css" rel="stylesheet" type="text/css" />
    <script src="lib/jquery/jquery-1.5.2.min.js" type="text/javascript"></script> 
    <script src="js/vanadium.js" type="text/javascript"></script>
	<script src="js/check.js" type="text/javascript"></script>
	<link href="css/input.css" rel="stylesheet" type="text/css" />
	<link href="css/upload.css" rel="stylesheet" type="text/css" />
	<script src="js/teacher/inputInfo.js" type="text/javascript"></script>
    <script src="js/addPerson.js" type="text/javascript"></script>
	<script src="lib/ligerUI/js/ligerui.min.js" type="text/javascript"></script>
</head>
<body style="padding:0px;">
	<form id="form" name="form" action="updateScienceTechProjectDetail.action" onsubmit="return checkClickAndSubmit();" method="post" enctype="multipart/form-data">
	<input type="hidden" id="projectId" name="projectId" value="<%=projectId%>"/>
	<div id="allpage">
	<div class="item">
		<div class="title">
			更新科技项目详细信息
			<div class="clear"></div>
		</div>
		<div class="content">
			<div class="line">
				<div class="element">
					<label for="inputThisYear">当年拨入经费（千元）:</label>
					<input type="text" id="inputThisYear" name="inputThisYear" class=":number" />
				</div>
				<div class="element">
					<label for="expenditureThisYear">当年支出经费（千元）:</label>
					<input type="text" id="expenditureThisYear" name="expenditureThisYear" class=":number" />
				</div>
			</div>
			<div class="line">
				<div class="element">
					<label for="totalStaff">当年投入人员（人年）【合计】:</label>
					<input type="text" id="totalStaff" name="totalStaff" class=":digits" />
				</div>
				<div class="element">
					<label for="advancedStaff">当年投入人员（人年）【高级职务】:</label>
					<input type="text" id="advancedStaff" name="advancedStaff" class=":digits" />
				</div>
				<div class="element">
					<label for="middleStaff">当年投入人员（人年）【中级职务】:</label>
					<input type="text" id="middleStaff" name="middleStaff" class=":digits" />
				</div>
			</div>
			<div class="line">
				<div class="element">
					<label for="juniorStaff">当年投入人员（人年）【初级职务】:</label>
					<input type="text" id="juniorStaff" name="juniorStaff" class=":digits" />
				</div>
				<div class="element">
					<label for="otherStaff">当年投入人员（人年）【其他】:</label>
					<input type="text" id="otherStaff" name="otherStaff" class=":digits" />
				</div>
			</div>
			<div class="line">
				<div class="element">
					<label for="graduateJoin">参与研究生数（人）:</label>
					<input type="text" id="graduateJoin" name="graduateJoin" class=":digits" />
				</div>
				<div class="element">
					<label for="projectStatus">项目状态:</label>
					<input type="text" id="projectStatus" name="projectStatus" />
				</div>
			</div>
			
			<div class="clear" style="height:15px;"></div>
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