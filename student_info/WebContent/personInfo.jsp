<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>个人信息</title>
<link rel="stylesheet" href="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/css/bootstrap.min.css">  
<script src="https://cdn.staticfile.org/jquery/2.1.1/jquery.min.js"></script>
<script src="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
<body>
	<c:forEach var="user" items="${sessionScope.list }">
		<table class="table table-striped">
		  <caption>个人信息</caption>
		  <thead>
		      <th>账号</th>
		      <th>密码</th>
		      <th>真实姓名</th>
		      <th>身份</th>
		      <th>操作</th>
		  </thead>
		  <tbody>
		      <td>${user.userId }</td>
		      <td>${user.password }</td>
		      <td>${user.userName }</td>
		      <td>${user.type }</td>
		      <td>

					<a href="delete?userId=${user.userId }">删除</a>&nbsp;

					<a href="findOne?userId=${user.userId}">修改</a>

				</td>
		      
		  </tbody>
		</table>
	</c:forEach>
</body>
</html>