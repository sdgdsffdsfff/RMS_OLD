<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@taglib prefix="s" uri="/struts-tags" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%    
      String path = request.getContextPath();
      String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
       
%>
<html xmlns="http://www.w3.org/1999/xhtml">
<base href="<%=basePath%>">
<head>
        <title>教改项目信息</title>
    <link href="lib/ligerUI/skins/Aqua/css/ligerui-all.css" rel="stylesheet" type="text/css" />
    <link href="css/Data.css" rel="stylesheet" type="text/css" />
    <script src="lib/jquery/jquery-1.3.2.min.js" type="text/javascript"></script> 
    <script src="lib/ligerUI/js/core/base.js" type="text/javascript"></script>
    <script src="lib/ligerUI/js/plugins/ligerGrid.js" type="text/javascript"></script> 
    <script src="lib/ligerUI/js/plugins/ligerTextBox.js" type="text/javascript"></script>
    <script src="lib/ligerUI/js/plugins/ligerCheckBox.js" type="text/javascript"></script>
    <script src="lib/ligerUI/js/plugins/ligerMenu.js" type="text/javascript"></script>
    <script src="lib/ligerUI/js/plugins/ligerComboBox.js" type="text/javascript"></script>
    <script src="lib/ligerUI/js/plugins/ligerMenuBar.js" type="text/javascript"></script>
    <script src="lib/ligerUI/js/plugins/ligerToolBar.js" type="text/javascript"></script>
    <script src="lib/ligerUI/js/plugins/ligerButton.js" type="text/javascript"></script>
    <script src="lib/ligerUI/js/plugins/ligerResizable.js" type="text/javascript"></script>
    <script src="lib/ligerUI/js/plugins/ligerDialog.js" type="text/javascript"></script>
    <script src="lib/ligerUI/js/plugins/ligerDrag.js" type="text/javascript"></script>
    
    <script src="js/collegeaprovel/simple/educationalReformRecord.js" type="text/javascript"></script>    
 </head>
<body style="padding:0px; overflow:hidden;"> 
  <form id="form1" > 
    <div id="maingrid" style="margin:0; padding:0">
    		<s:iterator value="records">
     			<script type="text/javascript">
	     			var row = {
	     			        id:"${id}",
	     			        submitUser: "${submitUser.userName}",
	     					name: "${name}", 
	     					Status: "${statusDes}"
					};
	     			rows.push(row);
	     		</script>
   			</s:iterator> 
    	</div>
  </form>
</body>
</html>
