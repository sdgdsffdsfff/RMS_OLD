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
<title>录入科技活动机构信息</title>
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
	<form id="form" name="form" action="submitScienceOrganization.action" onsubmit="return checkClickAndSubmit();" method="post" enctype="multipart/form-data">
	<div id="allpage">
	<div class="item">
		<div class="title">
			录入科技活动机构信息
			<div class="clear"></div>
		</div>
		<div class="content">
			<div class="line">
				<div class="element">
					<label for="organizationName">机构名称:</label>
					<input type="text" id="organizationName" name="organizationName" class=":required" />
				</div>
				<div class="element">
					<label for="organizationType">机构类型:</label>
					<input type="text" id="organizationType" name="organizationType" />
				</div>
				<div class="element">
					<label for="organizationCategory">机构类别:</label>
					<input type="text" id="organizationCategory" name="organizationCategory" />
				</div>
			</div>
			<div class="line">
				<div class="element">
					<label for="sortSubject">学科分类:</label>
					<input type="text" id="sortSubject" name="sortSubject" />
				</div>
				<div class="element">
					<label for="modusComposition">组成形式:</label>
					<input type="text" id="modusComposition" name="modusComposition" />
				</div>
			</div>
			<div class="line">
				<div class="element">
					<label for="totalEmployees">从业人员（合计）:</label>
					<input type="text" id="totalEmployees" name="totalEmployees" class=":digits" />
				</div>
				<div class="element">
					<label for="doctorEmployees">从业人员（其中博士毕业）:</label>
					<input type="text" id="doctorEmployees" name="doctorEmployees" class=":digits" />
				</div>
				<div class="element">
					<label for="masterEmployees">从业人员（其中硕士毕业）:</label>
					<input type="text" id="masterEmployees" name="masterEmployees" class=":digits" />
				</div>
			</div>
			<div class="line">
				<div class="element">
					<label for="totalIts">科技活动人员【人年】（合计）:</label>
					<input type="text" id="totalIts" name="totalIts" class=":digits" />
				</div>
				<div class="element">
					<label for="advancedIts">科技活动人员【人年】（高级职称）:</label>
					<input type="text" id="advancedIts" name="advancedIts" class=":digits" />
				</div>
				<div class="element">
					<label for="middleIts">科技活动人员【人年】（中级职称）:</label>
					<input type="text" id="middleIts" name="middleIts" class=":digits" />
				</div>
			</div>
			<div class="line">
				<div class="element">
					<label for="juniorIts">科技活动人员【人年】（初级职称）:</label>
					<input type="text" id="juniorIts" name="juniorIts" class=":digits" />
				</div>
				<div class="element">
					<label for="otherIts">科技活动人员【人年】（其他）:</label>
					<input type="text" id="otherIts" name="otherIts" class=":digits" />
				</div>
			</div>
			<div class="line">
				<div class="element">
					<label for="numGraduates">培养研究生（人）:</label>
					<input type="text" id="numGraduates" name="numGraduates" class=":digits" />
				</div>
				<div class="element">
					<label for="internalExpenditures">当年经费内部支出（千元）:</label>
					<input type="text" id="internalExpenditures" name="internalExpenditures" class=":number" />
				</div>
				<div class="element">
					<label for="rdExpenditures">当年经费内部支出其中R&D支出（千元）:</label>
					<input type="text" id="rdExpenditures" name="rdExpenditures" class=":number" />
				</div>
			</div>
			<div class="line">
				<div class="element">
					<label for="assetsFixed">固定资产原值（千元）:</label>
					<input type="text" id="assetsFixed" name="assetsFixed" class=":number" />
				</div>
				<div class="element">
				<label for="assetsEquipment">固定资产原值其中仪器设备（千元）:</label>
					<input type="text" id="assetsEquipment" name="assetsEquipment" class=":number" />
				</div>
				<div class="element">
					<label for="assetsImport">固定资产原值其中进口（千元）:</label>
					<input type="text" id="assetsImport" name="assetsImport" class=":number" />
				</div>
			</div>
			<div class="line">
				<div class="element">
					<label for="numIssueAssume">承担课题（项）:</label>
					<input type="text" id="numIssueAssume" name="numIssueAssume" class=":digits" />
				</div>
				<div class="element">
					<label for="industryService">服务的国民经济行业:</label>
					<input type="text" id="industryService" name="industryService" />
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
		<p>（1）本表仅统计依托各二级部门的重庆市重点实验室和工程研究中心。</p>
		<p>（2）机构类型分为：R&D机构；其他。</p>
		<p>（3）机构类别分：省部级重点实验室和省部级工程技术研究中心。</p>
		<p>（4）学科分类分为：根据国标GB/T13745-92《学科分类与代码》，按二级学科填报（填写名称，不填代码）。《学科分类与代码》可到科技处网页上查询。</p>
		<p>（5）组成形式分：“本校独办”和“校际联合”。</p>
		<p>（6）培养的研究生指截至到年末在机构中在学的研究生，不列入科技人员中，单独统计。</p>
		<p>（7）本年度承担课题数：包括2004年度新立项目、在研以及今年结项的项目。</p>
		<p>（8）当年经费内部支出：指统计年度内科研机构用于内部开展科技活动实际支出的费用；R&D经费：内部开展R&D活动实际支出的费用。	</p>
		<p>（9）年末固定资产原值：指科技机构在建造、购置、安装、改建、扩建、技术改造固定资产时实际支出的全部费用总额。当年已经不再使用的固定资产不统计。</p>
		<p>（10）从业人员含机构中在册的科技人员、管理人员及辅助人员。</p>
		<p>（11）科技活动人员（人年）为折算数，按高级、中级和初级人数分别乘以本年度工作月数/10的加和，科技人员的年工作月数不超过10个月。</p>
		<p>（12）服务的国民经济行业，填写代码。见附件：国民经济行业分类与代码。</p>
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