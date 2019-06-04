<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>添加新用户</title>
    <link rel="stylesheet" href="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/css/bootstrap.min.css">  
	<script src="https://cdn.staticfile.org/jquery/2.1.1/jquery.min.js"></script>
	<script src="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/js/bootstrap.min.js"></script>
	<script>
	$(function () { $("[data-toggle='tooltip']").tooltip(); });
    </script>

  </head>
  
  <body>	
  <h1 class="text-danger">添加新用户</h1>
  <div style="text-align:center;margin-top:10%;">	
	<form class="form-horizontal" role="form" action="${pageContext.request.contextPath }/addUser.action" method="post">
	<div class="form-group">
		<label for="firstname" class="col-sm-2 control-label">用户账号：</label>
		<div class="col-sm-10">
			<input type="text" name="user.userId" size="100" maxlength="20" value=''>
		</div>
	</div>
	<div class="form-group">
		<label for="lastname" class="col-sm-2 control-label">用户姓名：</label>
		<div class="col-sm-10">
			<input type="text" name="user.userName" size="100" maxlength="20" value=''>
		</div>
	</div>
	<div class="form-group">
		<label for="lastname" class="col-sm-2 control-label">用户密码：</label>
		<div class="col-sm-10">
			<input type="text" name="user.password" size="100" maxlength="20" value=''>
		</div>
	</div>
	<div class="form-group">
		<label for="lastname" class="col-sm-2 control-label">用户角色：</label>
		<div class="col-sm-10">
			<input type="text" name="user.type" size="100" maxlength="20" value=''>
		</div>
	</div>
	<div class="form-group">
		<div class="col-sm-offset-2 col-sm-10">
			<button type="submit" class="btn btn-default" data-toggle="tooltip" data-placement="bottom" title="检查好了再提交哦！">提交</button>
			&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
			<button type="reset" class="btn btn-default">重置</button>
		</div>
	</div>

</form>
</div>
  </body>
</html>
