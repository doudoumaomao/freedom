<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ page language="java" contentType="text/html; charset=utf-8"%>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <%@ include file="../../common/head.jsp" %>
     
    <script type="text/javascript">
    	function itemclick(item)
        {
            alert(item.text);
        }
    	function addSysUser()
    	{
        $.ligerDialog.open({ 
            title: '新增用户',
            url: 'addSysUser_User.action', 
            width: 500, 
            height: 400, 
            isResize: true,
            buttons: [{ text: '确定' }, { text: '取消'}]
            }); 
    	}
        $(function ()
        {
            $("#userManageTable").ligerGrid({
                checkbox: true,
                columns: [
                         { display: '用户ID', name: 'userid' ,hide : 1},
                         { display: '姓名', name: 'userName',isAllowHide : false},
                         { display: '帐号', name: 'accounts'},
                         { display: '密码', name: 'password'},
                         { display: '加密密码', name: 'encryptionPassword'},
                         { display: '用户类型', name: 'userType'},
                         { display: '是否锁定登录', name: 'locked'},
                         { display: '状态', name: 'state'},
                         { display: '创建时间', name: 'foundTime',type: 'date'},
                         { display: '创建人', name: 'foundPerson'},
                         { display: '创建IP', name: 'foundIP'},
                         { display: '最后修改时间', name: 'amendTime',type : 'date'},
                         { display: '最后修改人', name: 'amendPerson'}
                     ], 
                url: '/ajaxGetUserList_User.action',
                sortName: 'userid',
                pageSize: 40,
                width: '100%', 
                height: '100%',
                dataAction: 'server',
                selectRowButtonOnly: true,
                showTableToggleBtn : true,
                rownumbers:true,
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



