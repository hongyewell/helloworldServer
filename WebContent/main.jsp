<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html >
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>信息详情</title>
</head>
<body>
	<!-- 从session中获取用户名 -->
	欢迎${user.userName}访问~
	
		<h2>信息列表</h2>
	<table style="width: 600px; height: 100px; border: 1px solid #ccc; border-collapse: collapse; text-align: center;">
		<thead>
			<tr>
				<th>信息ID</th>
				<th>标题</th>
				<th>内容</th>
				<th>作者</th>
				<th>时间</th>
			</tr>
		</thead>
		<tbody id="news">
		</tbody>

	</table>
	<hr/>
	<a href="add.jsp">添加信息</a>	
	
    <script type="text/javascript" src="${pageContext.request.contextPath}/resources/scripts/jquery-1.8.3.min.js"></script>
	
	<script type="text/javascript">
		var contextPath = '${pageContext.request.contextPath}';
	</script>
	
	<script type="text/javascript">
		$(function() {
			// 使用post请求用户列表数据，渲染在页面上
			$.post(contextPath+'/HelloData', 'json').done(function(datas) {
				
				// 将后台返回的字符串数据转换成json格式的
				datas = JSON.parse(datas);
				var html = '';
				for(var i = 0, len = datas.length; i < len; i++) {
					var news = datas[i];
					
					html += '<tr>'
							+ '<td>'+news.myId+'</td>'
							+ '<td>'+news.myTitle+'</td>'
							+ '<td>'+news.myContent+'</td>'
							+ '<td>'+news.myAuthor+'</td>'
							+ '<td>'+news.myTime+'</td>'
						 + '</tr>';
				}
				// 将拼接后的用户列表渲染在页面上
				$('#news').html(html);
				
			}).fail(function(res) {
			});
			
		});	
	</script>

</body>
</html>