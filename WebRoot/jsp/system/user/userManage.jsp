<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ page language="java" contentType="text/html; charset=utf-8"%>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <title></title>
    <link href="js/ligerUI/skins/Aqua/css/ligerui-all.css" rel="stylesheet" type="text/css" />
    <link href="js/ligerUI/skins/ligerui-icons.css" rel="stylesheet" type="text/css" />

    <script src="js/jquery-1.7.2.min.js" type="text/javascript"></script>    
    <script src="js/ligerUI/js/core/base.js" type="text/javascript"></script>
    <script src="js/ligerUI/js/plugins/ligerGrid.js" type="text/javascript"></script>
    <script src="js/ligerUI/js/plugins/ligerToolBar.js" type="text/javascript"></script>
    <script src="js/ligerUI/js/plugins/ligerResizable.js" type="text/javascript"></script>
    <script src="js/ligerUI/js/plugins/ligerCheckBox.js" type="text/javascript"></script>
    <script type="text/javascript">
    	var userManageData = eval('({Rows:${userList},Total:1})');
    	function itemclick(item)
        {
            alert(item.text);
        }
    	function addSysUser()
    	{
    		
    	}
        $(function ()
        {
            $("#userManageTable").ligerGrid({
            	checkbox: true,
                columns: [
				{ display: '用户ID', name: 'userid' ,hide : 1},
                { display: '姓名', name: 'userName', align: 'center', minWidth: 90,width : 100},
                { display: '帐号', name: 'accounts', minWidth: 80 ,width : 100},
                { display: '密码', name: 'password', minWidth: 80 ,width : 100},
                { display: '加密密码', name: 'encryptionPassword', minWidth: 80 ,width : 100},
                { display: '创建时间', name: 'foundTime', minWidth: 80 ,width : 100},
                { display: '创建人', name: 'foundPerson', minWidth: 80 ,width : 100},
                { display: '创建IP', name: 'foundIP', minWidth: 80 ,width : 100},
                { display: '最后修改时间', name: 'amendTime', minWidth: 80 ,width : 100},
                { display: '最后修改人', name: 'amendPerson', minWidth: 80 ,width : 100},
                { display: '是否锁定登录', name: 'locked', minWidth: 80 ,width : 100},
                { display: '状态', name: 'state', width: 50, align: 'left' }
                ], pageSize: 30,
                data: userManageData, sortName: 'userid',
                width: '100%', height: '100%',
                selectRowButtonOnly: true,rownumbers:true,
                toolbar: { 
                	items: [
                                   { text: '增加', click: addSysUser, icon: 'add' },
                                   { line: true },
                                   { text: '修改', click: itemclick, icon: 'modify' },
                                   { line: true },
                                   { text: '删除', click: itemclick, img: 'js/ligerUI/skins/icons/delete.gif' }
                           ]}
            });
            $("#pageloading").hide();
        });
    </script>
</head>
<body style="padding: 6px; overflow: hidden;">
    <div class="l-loading" style="display: block" id="pageloading"></div>
     <a class="l-button" style="width:120px;float:left; margin-left:10px; display:none;" onclick="deleteRow()">删除选择的行</a>
    <form>
    	<div id="userManageTable" style="margin: 0; padding: 0"></div>
    </form>
    <div style="display: none;"></div>
</body>
</html>



