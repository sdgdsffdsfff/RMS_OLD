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
	<title>录入科技项目信息</title>
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
	<form id="form" name="form" action="submitScienceTechProject.action" onsubmit="return checkClickAndSubmit();" method="post" enctype="multipart/form-data">
	<div id="allpage">
	<div class="item">
		<div class="title">
			录入科技项目信息
			<div class="clear"></div>
		</div>
		<div class="content">
			<div class="title">
				科技项目基本信息
			</div>
			<div class="line">
				<div class="element">
					<label for="projectName">项目名称:</label>
					<input type="text" id="projectName" name="projectName" class=":required" />
				</div>
				<div class="element">
					<label for="timeProjectApproved"></label>
					<input type="text" id="timeProjectApproved" name="timeProjectApproved" />
				</div>
				<div class="element">
					<label for="totalFundContract">合同总经费（千元）:</label>
					<input type="text" id="totalFundContract" name="totalFundContract" class=":number" />
				</div>
			</div>
			<div class="line">
				<div class="element">
					<label for="sortSubject">学科分类:</label>
					<input type="text" id="sortSubject" name="sortSubject" />
				</div>
				<div class="element">
					<label for="sortActivity">活动分类:</label>
					<input type="text" id="sortActivity" name="sortActivity" />
				</div>
				<div class="element">
					<label for="originProject">项目来源:</label>
					<input type="text" id="originProject" name="originProject" />
				</div>
			</div>
			<div class="line">
				<div class="element">
					<label for="formOrganization">组织形式:</label>
					<input type="text" id="formOrganization" name="formOrganization" />
				</div>
				<div class="element">
					<label for="formCooperation">合作形式:</label>
					<input type="text" id="formCooperation" name="formCooperation" />
				</div>
				<div class="element">
					<label for="organReliedProject">项目依托科研机构:</label>
					<input type="text" id="organReliedProject" name="organReliedProject" />
				</div>
			</div>
			<div class="line">
				<div class="element">
					<label for="industryService">服务的国民经济行业:</label>
					<input type="text" id="industryService" name="industryService" />
				</div>
				<div class="element">
					<label for="unitProject">项目所在部门:</label>
					<input type="text" id="unitProject" name="unitProject" />
				</div>
			</div>
			
			<div class="clear" style="height:30px;"></div>
			<div class="title">
				科技项目详细信息
			</div>
			
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
			<div class="title">
			参与人信息
			</div>
			<div id="membertoolbar"></div>
			<div class="line spe">
				<div class="element del person">
					<label for="memberName">参与人姓名:</label>
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
		<p>（1）填报当年度列入学校年度计划和虽未列入计划，但通过签订合同、协议或计划任务书经学校确认的理、工、农、医、学科的各类科技课题。</p>
		<p>（2）项目批准(合同签订)时间：8位数,前4位年份后4位月份+日期。例:2000年4月1日填为2000-04-01.</p>
		<p>（3）当年投入人员（人年）为折算数，按高级、中级、初级和其他（不计研究生）人数分别乘以本年度工作月数/10的加和，科技人员的年工作月数不超过10个月。投入研究时间以月来计，一年以十个月计。</p>
		<p>（4）学科分类：根据国标GB/T13745-92《学科分类与代码》，按二级学科填报（代码＋名称）。《学科分类与代码》可到科技处网页上查询。</p>
		<p>（5）活动类型：分为“基础研究”、“应用研究”、“试验发展”、“R&D成果应用”和“科技服务”填写。</p>
		<p>（6）项目来源：纵向项目填写下达项目名称，如科技部863项目、重庆市自然科学基金项目等；横向项目和院定项目分别标注“横向”、“院定”即可。</p>
		<p>（7）项目组织形式：“牵头单位”和“合作单位”。</p>
		<p>（8）项目合作形式：按“与国外合作”、“与国内高校合作”、“与国内研究机构合作”、“与在华外商独资企业合作”、“与国内其他企业合作”、“独立完成”和“其他”。</p>
		<p>（9）项目服务的国民经济行业：参见附表。</p>
		
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