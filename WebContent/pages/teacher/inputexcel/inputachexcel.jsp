<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="s" uri="/struts-tags"%>
<%    
      String path = request.getContextPath();
      String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
       
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<base href="<%=basePath%>">
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>导入教学成果类信息</title>
	
	<link href="lib/ligerUI/skins/Aqua/css/ligerui-all.css" rel="stylesheet" type="text/css" />
    <link href="css/Data.css" rel="stylesheet" type="text/css" />
    <link href="lib/ligerUI/skins/Aqua/css/ligerui-all.css" rel="stylesheet" type="text/css" />
	<link href="lib/ligerUI/skins/ligerui-icons.css" rel="stylesheet" type="text/css" />
    <link href="css/Data.css" rel="stylesheet" type="text/css" />
    <script src="lib/jquery/jquery-1.5.2.min.js" type="text/javascript"></script>
    <script src="lib/ligerUI/js/ligerui.min.js" type="text/javascript"></script>
    <script src="js/teacher/viewCourseContribute.js" type="text/javascript"></script>
    <script src="lib/jquery/jquery-1.5.2.min.js" type="text/javascript"></script> 
    <script src="lib/jquery/jquery-1.3.2.min.js" type="text/javascript"></script> 
    <script src="lib/ligerUI/js/ligerui.min.js" type="text/javascript"></script>
    <script type="text/javascript" src="js/ajaxfileupload.js"></script> 
	<script type="text/javascript">
	
	function fileupload(){ 
		
		var reg = /数据全部导入成功！/; 
        if($(".file").val()==""){
        	alert("上传文件不能为空!");  
            return false;  
        } 
        $.ligerDialog.waitting('导入中，请稍候...');
        $.ajaxFileUpload({  
                url:"excelToDBAch.action",  
                secureuri:false,  
                fileElementId:'upload',  
                dataType: 'text/xml',             
                success: function (data) {
                    var url = eval("("+data+")").url;
                    var warning = eval("("+data+")").warning;
                    setTimeout(function (){
            			$.ligerDialog.closeWaitting();
            			
            			if(url==null||url==""){
                			
                			if(reg.test(warning)){
                    			
                				$.ligerDialog.success(warning);
                    		}else{
                        		
                    			$.ligerDialog.error(warning);
                        	}
 							
 							$("#loading").html();
                        }else{
                        	$.ligerDialog.error(warning);
                        	$("#loading").html('<a href="downErrorExcel.action?type=ach&url='+url+'">'+warning+'</a>');
                         }
                    },1500);
                    
                    
                },error: function (data, status, e){  
                    alert("fail");
                }  
            }  
        );  
    }
	</script>
</head>

<body style="padding:0px;">
	<div id="allpage">
	<div class="item">
	    <div class="title">
			<span style="float:left">导入教学成果类信息</span><a style="float:right" href="downExcelModel.action?modelName=Ach">(下载教学成果类信息的excel模板)：</a>
			<div style="clear:both"></div>
		</div>
		
		<br/>
		<div style="margin: 0 0 1em 5em">批量导入数据的注意事项：</div>
   	<div style="margin:0 0 5px 7em ;width:700px">1.请使用教学成果类科研统计的模板填写相应的信息。</div>
   	<div style="margin-left: 7em;width: 700px">2.在批量导入过程中，若有信息导入失败，系统会自动将这些失败信息存放到一个临时的导入失败 的Excel文件中，并提示用户下载该Excel文件。 若需要此文件请及时下载该文件。</div>
		<br/>
		<br/>
		<div class="content">
			<!--<form action="excelToDBTec.action" id="form" name="form" method="post" enctype="multipart/form-data">
			
				--><input type="file" class="file" id="upload" name="upload" value="浏览" />
				<input type="button" name="submit" class="btn" value="导入" onClick="fileupload()" />
				<span id="loading"></span>
		</div>
		
		<div class="clear" style="height:15px;"></div>
    	
	</div>
	
	</div>
	
</body>
</html>
