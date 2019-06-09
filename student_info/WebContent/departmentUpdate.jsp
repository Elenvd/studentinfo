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
    
    <title>My JSP 'updateInfo.jsp' starting page</title>
    <link rel="stylesheet" href="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/css/bootstrap.min.css">  
	<script src="https://cdn.staticfile.org/jquery/2.1.1/jquery.min.js"></script>
	<script src="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/js/bootstrap.min.js"></script>
	<script>
	$(function () { $("[data-toggle='tooltip']").tooltip(); });
    </script>

  </head>
  
  <body>	
  <div class="main" style="margin-top:5%;margin-left:35%;">
  	<h1> <span class="label label-info">院系信息修改</span></h1>
  	<br>
  	<br>
	<form class="bs-example bs-example-form" role="form"  action="${pageContext.request.contextPath }/departmentUpdate2.action" method="post">
		<s:iterator id="department" value="department">
		<div class="input-group">
			<span class="input-group-addon">院系号：</span>
			<input type="text" class="form-control" name="department.id" size="50" maxlength="20" style="width:300px;"
							value='<s:property value="department.id"/>' readonly="true">
		</div><br>
		<div class="input-group">
			<span class="input-group-addon">院系名：</span>
			<input type="text" class="form-control" name="department.departmentName" size="50" maxlength="20" style="width:300px;"
							value='<s:property value="department.departmentName"/>'>
		</div><br>
		<div class="form-group">
		<div class="col-sm-offset-2 col-sm-10">
			<button type="submit" class="btn btn-default" data-toggle="tooltip" data-placement="bottom" title="检查好了再提交哦！">提交</button>
			&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
			<button type="reset" class="btn btn-default">重置</button>
		</div>
	</div>
	</s:iterator>
	</form>
</div>
  </body>
</html>
