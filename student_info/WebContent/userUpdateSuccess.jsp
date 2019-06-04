<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta http-equiv="Refresh" content="2;URL=${pageContext.request.contextPath }/index_home.jsp" />
<title>Insert title here</title>
<link rel="stylesheet" href="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/css/bootstrap.min.css">  
<script src="https://cdn.staticfile.org/jquery/2.1.1/jquery.min.js"></script>
<script src="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
<body>
	<div class="panel panel-default">
	<div class="panel-heading">
		<h3 class="panel-title">
			 修改成功
		</h3>
	</div>
	<div class="panel-body">
		<c:forEach var="user" items="${sessionScope.list }">
		账号：${user.userId }<br>
		密码：${user.password }<br>
		真实姓名：${user.userName }<br>
		角色：${user.type}<br>
	</c:forEach>
	</div>
</div>
     
</body>
</html>