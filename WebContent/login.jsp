<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>用户登录</title>
<style type="text/css">
	.error {
		color: red;
	}
</style>
</head>
<body>
<!-- 登录表单 -->
	<form action="LoginController" method="post">
		<input type="text" name="username" placeholder="用户名" />
		<input type="password" name="password" placeholder="密码" /> 
		<input type="submit" value="登录">
	</form>
	
	<!-- EL表达式 -->
	<span class="error">${error }</span>
</body>
</html>