<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ page language="java" contentType="text/html; charset=utf-8"%>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <title></title>
    <link href="js/ligerUI/skins/Aqua/css/ligerui-all.css" rel="stylesheet" type="text/css" />
    <link href="js/ligerUI/skins/ligerui-icons.css" rel="stylesheet" type="text/css" />

    <script src="js/jquery-1.7.2.min.js" type="text/javascript"></script>    
    <script src="js/ligerUI/js/core/base.js" type="text/javascript"></script>
    <script src="js/ligerUI/js/plugins/ligerForm.js" type="text/javascript"></script>
    <script src="js/ligerUI/js/plugins/ligerDateEditor.js" type="text/javascript"></script>
    <script src="js/ligerUI/js/plugins/ligerComboBox.js" type="text/javascript"></script>
    <script src="js/ligerUI/js/plugins/ligerCheckBox.js" type="text/javascript"></script>
    <script src="js/ligerUI/js/plugins/ligerButton.js" type="text/javascript"></script>
    <script src="js/ligerUI/js/plugins/ligerDialog.js" type="text/javascript"></script>
    <script src="js/ligerUI/js/plugins/ligerRadio.js" type="text/javascript"></script>
    <script src="js/ligerUI/js/plugins/ligerSpinner.js" type="text/javascript"></script>
    <script src="js/ligerUI/js/plugins/ligerTextBox.js" type="text/javascript"></script> 
    <script src="js/ligerUI/js/plugins/ligerTip.js" type="text/javascript"></script>
    <script src="js/jquery-validation/jquery.validate.min.js" type="text/javascript"></script> 
    <script src="js/jquery-validation/jquery.metadata.js" type="text/javascript"></script>
    <script src="js/jquery-validation/messages_cn.js" type="text/javascript"></script>
    <script type="text/javascript">
    var eee;
    $(function ()
    {
        $.metadata.setType("attr", "validate");
        var v = $("form").validate({
            debug: true,
            errorPlacement: function (lable, element)
            {
                if (element.hasClass("l-textarea"))
                {
                    element.ligerTip({ content: lable.html(), target: element[0] }); 
                }
                else if (element.hasClass("l-text-field"))
                {
                    element.parent().ligerTip({ content: lable.html(), target: element[0] });
                }
                else
                {
                    lable.appendTo(element.parents("td:first").next("td"));
                }
            },
            success: function (lable)
            {
                lable.ligerHideTip();
                lable.remove();
            },
            submitHandler: function ()
            {
                $("form .l-text,.l-textarea").ligerHideTip();
                document.getElementById("userForm").submit();
            }
        });
        $("form").ligerForm();
    }); 
    </script>
</head>
<body style="padding: 6px; overflow: hidden;">
  <form name="userForm" method="post" action="addSysUser_User.action" id="userForm">
  <input type="hidden" name="flag" value="true" />
        <table cellpadding="0" cellspacing="0" class="l-table-edit" >
            <tr>
                <td width="20%" align="right" class="l-table-edit-td">姓名：</td>
                <td width="30%" class="l-table-edit-td"><input name="userName" type="text" id="userName" ltype="text" validate="{required:true}" /></td>
                <td width="20%" align="right" class="l-table-edit-td">类型：</td>
                <td width="30%" class="l-table-edit-td"><select name="userTypeId" id="userTypeId" ltype="select"></select></td>
            </tr>
            <tr>
                <td align="right" class="l-table-edit-td" valign="top">帐号：</td>
                <td align="left" colspan="3" class="l-table-edit-td"><input name="account" type="text" id="account" ltype="text" validate="{required:true}" /></td>
            </tr>   
            <tr>
                <td align="right" class="l-table-edit-td" valign="top">密码：</td>
                <td align="left" class="l-table-edit-td"><input name="password" type="password" id="password" ltype="text" validate="{required:true}" /></td>
                <td align="right">确认密码：</td>
                <td align="left" class="l-table-edit-td"><input name="confirmPassword" type="password" id="confirmPassword" ltype="text" validate="{required:true}" /></td>
            </tr>
            <tr>
                <td align="right" class="l-table-edit-td" valign="top">状态：</td>
                <td align="left" colspan="3" class="l-table-edit-td"><select name="state" id="state" ltype="select">
					<option value="normal" >正常</option>
					</select>
				</td>
            </tr> 
            <tr>
                <td align="center" class="l-table-edit-td" valign="top"><input type="submit" value="提交" id="Button1" class="l-button" /></td>
            </tr>
        </table>
</form>
</body>
</html>



