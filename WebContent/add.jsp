<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>信息添加</title>
</head>
<body>
      欢迎${user.userName}访问~
	<form action="${pageContext.request.contextPath }/PublishData"
		method="post">
		<input type="text" name="title" placeholder="标题" />
		<input type="text" name="content" placeholder="内容" />
		<input type="hidden" name="author" value= "${user.userName}" />
		<input type="submit" value="添加">
	</form>

</body>
</html>