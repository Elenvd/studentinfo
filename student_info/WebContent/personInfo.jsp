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
<style>
p{font-size:30px;margin-left:30px;}
h4{font-size:40px;margin-left:30px;}
</style>
</head>
<body>
<div id="main" style="width:600px;margin-top:100px;margin-left:100px;">
	<div class="media">
    <div class="media-left">
      <img src="https://static.runoob.com/images/mix/img_avatar.png" class="media-object" style="width:200px;height:200px;">
    </div>
    <c:forEach var="user" items="${sessionScope.list }">
    <div class="media-body">
      <h4 class="media-heading">个人账号信息</h4>
      <br>
      
      <p>账号：${user.userId }</p>
      <p>密码：${user.password }</p>
      <p>真实姓名：${user.userName }</p>
      <p>身份：${user.type }</p>
    </div>
    </c:forEach>
  </div>
</div>	
</body>
</html>