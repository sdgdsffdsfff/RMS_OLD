
// JavaScript Document
var $grid;
var manager, g;

 var alert = function (content)
        {
            $.ligerDialog.alert(content);
        };
        var gridManager = null;
        $(function ()
        {
        	//工具条
            $("#toptoolbar").ligerToolBar({ items: [
                { text: '导出Excel', id:'Excel', click: itemclick, icon: 'save' },{ line:true },
                { text: '刷新', id:'refresh', click: itemclick, icon: 'refresh' }
            ]
            });

        	showdata();
        });
        
        function showdata(){
        	//表格
            g = manager = $grid = $("#maingrid").ligerGrid({
                columns: [
                { display: '立项级别', name: 'classContribute', align: 'left', width: 100, minWidth: 60 },
                { display: '立项类别', name: 'typeContribute', align: 'left', width: 100, minWidth: 60 },
                { display: '立项时间', name: 'timeContribute', align: 'left', width: 100, minWidth: 60 },
                { display: '专业名称', name: 'majorName', align: 'left', width: 160, minWidth: 60 },
                { display: '检查时间', name: 'checkTime', align: 'left', width: 100, minWidth: 60 },
                { display: '结题时间', name: 'endTime', align: 'left', width: 100, minWidth: 60 },
                { display: '学院奖励', name: 'rewardCollege', align: 'left', width: 100, minWidth: 60 },
                { display: '提交者', name: 'submitUser', align: 'left', width: 80, minWidth: 60 , frozen: true},
                { display: '审批者', name: 'approvedUser', align: 'left', width: 80, minWidth: 60 , frozen: true},
                { display: '操作', isAllowHide: false, width: 80, frozen: true,
                   	render: function (row)
                       {
                   		var html = '<a href="viewMajorContributeDetail.action?infoid='+row.majorId+'">查看详细</a>';
                           return html;
                       }
                   }
                ], dataAction: 'server', data: rows, sortName: 'majorId',
                width: '100%', height: '100%', pageSize: 100000,rownumbers:true,
                checkbox : true, pageSizeOptions : [10, 30, 50, 100, 500, 100000],
                //应用灰色表头
                cssClass: 'l-grid-gray', 
                heightDiff: -6
            });
            show();
            
           gridManager = $("#maingrid").ligerGetGridManager();

            $("#pageloading").hide();
        }

        function getInfo(){
        	
        	var stringName1 = $("#stringName1").val();
        	var stringValue1 = $("#stringValue1").val();
        	
        	var stringName2 = $("#stringName2").val();
        	var stringValue2 = $("#stringValue2").val();
        	
        	var stringName3 = $("#stringName3").val();
        	var stringValue3 = $("#stringValue3").val();
        	
        	var stringName4 = $("#stringName4").val();
        	var stringValue4 = $("#stringValue4").val();
        	
        	var floatName1 = $("#floatName1").val();
        	var minFloatValue1 = $("#minFloatValue1").val();
        	var maxFloatValue1 = $("#maxFloatValue1").val();
        	
        	var dateName = $("#dateName").val();
        	var begin = $("#begin").val();
        	var end = $("#end").val();
        	
        	
        	$.ajax({
        		type:"POST",
        		url:"searchCollegeMajorContribute.action",
        		datatype:"script",
        		data:{stringName1:stringName1,stringValue1:stringValue1,stringName2:stringName2,stringValue2:stringValue2,
        			stringName3:stringName3,stringValue3:stringValue3,stringName4:stringName4,stringValue4:stringValue4,
        			floatName1:floatName1,minFloatValue1:minFloatValue1,maxFloatValue1:maxFloatValue1,
        			dateName:dateName,begin:begin,end:end
        			},
        		success:callback
        	});
        	}

        function callback(builder){
        	rows = [];
        	var callbackdate = eval("("+builder+")");
        	for(var objid in callbackdate){
        		var majorContributeInfo = callbackdate[objid];		
        		var row = {majorId: majorContributeInfo.majorId,
        				classContribute: majorContributeInfo.classContribute,
        				typeContribute: majorContributeInfo.typeContribute, 
        				timeContribute:majorContributeInfo.timeContribute, 
        				majorName:majorContributeInfo.majorName,
        				checkTime:majorContributeInfo.checkTime,
        				endTime:majorContributeInfo.endTime,
        				rewardCollege:majorContributeInfo.rewardCollege,
        				submitUser:majorContributeInfo.submitUser,
        				approvedUser:majorContributeInfo.approvedUser,
        				Status: majorContributeInfo.Status
        				};
        		rows.push(row);
        	}
        	showdata();	
        }

        
        function itemclick(item)
        { 
            if(item.id)
            {
                switch (item.id)
                {
                	case "refresh":
                	window.location.reload();
                    return;
                	case "Excel":
                    	var data = gridManager.getCheckedRows();
                        if (data.length == 0)
                            alert('请选择行!');
                        else
                        {
                        	var checkedIds = [];
                        	$(data).each(function ()
                            {
                        		checkedIds.push(this.majorId);
                            });
                        	$.ligerDialog.confirm('确定导出已选择的数据?', function (result)
                        	{
                        		if(result)
                        		{
                        			link = 'downLoadExcelbyFactor/downloadMajorContributeExcel.action?factorName=majorId&factorValue='+checkedIds;
                        			downloadExcel(link);
                        		}
                        	});
                        }
                    	
                        return;
                }   
            }
            alert(item.text);
        }
        
        function downloadExcel(link)
        {
        	window.location.href=link;
        }
        
        function show()
        {
            var jsonObj = {};
           
            jsonObj.Rows = rows;
            $grid.set({ data: jsonObj });
            
        }
   	   
   	    
        var rows = [];
