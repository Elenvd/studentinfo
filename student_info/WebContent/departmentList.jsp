<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>院系列表</title>
<link rel="stylesheet" href="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/css/bootstrap.min.css">  
<script src="https://cdn.staticfile.org/jquery/2.1.1/jquery.min.js"></script>
<script src="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/js/bootstrap.min.js"></script>
<script>
	$(function () { $("[data-toggle='tooltip']").tooltip(); });
</script>
</head>
<body>
<nav class="navbar navbar-default" role="navigation">

	<div class="container-fluid">

    <div class="navbar-header">

        <a class="navbar-brand" href="#">查找方式</a>

    </div>

    <div>

        <form action="${pageContext.request.contextPath }/search2.action" class="navbar-form navbar-left" role="search" method="post">

	<div id="search">	

		<select name="department.key" class="form-control">

			<option value="department.id" <c:if test="${sessionScope.strType=='userId'}">selected='selected'</c:if>>院系号</option>

			<option value="department.departmentName"<c:if test="${sessionScope.strType=='userName'}">selected='selected'</c:if>>院系名</option>

		</select>

		<input type="text" name="department.strKey" id="keyword" value="${sessionScope.strKey}" class="form-control" placeholder="关键字">

		<input type="submit" value="查询" class="btn btn-default" data-toggle="tooltip" title="查询" data-placement="bottom">

		<a href="${pageContext.request.contextPath }/addDepartment.jsp" target="right" class="btn btn-default navbar-btn" data-toggle="tooltip" title="添加院系信息" data-placement="bottom">添加院系信息</a>

	</div>

		</form>

    </div>

	</div>

</nav>
   <table class="table table-hover">
       <thead>
       	  <tr>
       	  	<th>院系号</th>
       	  	<th>院系名</th>
       	  	<th>操作</th>
       	  </tr>
       </thead>
       <tbody>
          <c:choose>
		  <c:when test="${!empty sessionScope.departmentlist}">
		  <c:forEach var="department" items="${sessionScope.departmentlist }">
       	      <tr>
       	  		<td>${department.id }</td>
       	  		<td>${department.departmentName }</td>
       	  		<td>

					<a href="${pageContext.request.contextPath }/deleteDepartment.action?id=${department.id }"  target="right" data-toggle="tooltip" data-placement="left" title="真的要删除我吗？" >删除</a>&nbsp;

					<a href="${pageContext.request.contextPath }/departmentUpdate.action?id=${department.id }"  target="right" data-toggle="tooltip" data-placement="right" title="想清楚哦！" >修改</a>&nbsp;
				</td>
       	 	 </tr>
       	  </c:forEach>
		  </c:when>
		  </c:choose>
       </tbody>
   </table>
</body>
</html>