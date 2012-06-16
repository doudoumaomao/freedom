<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ page language="java" contentType="text/html; charset=utf-8"%>
<html>
<head>
<title>登录页面</title>
<link rel="stylesheet" href="css/baseStyle.css" />
<script type="text/javascript" src="js/jquery-1.4.3.min.js" ></script>
</head>
<body>
<div >
	<form action="login_Login.action" method="post" >
		用户名：<input type="text" id="accounts" name="accounts" maxlength="32" />
		<br/>
		密码：<input type="password" id="password" name="password" maxlength="32" />
		<input class="login_btn" id="btlogin" name="btlogin" type="submit" value="登录"  />
		<input type="button" value="注册"  />
	</form>
</div>
</body>
</html>


