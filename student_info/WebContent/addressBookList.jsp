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
<title>学生通讯录列表</title>
<link rel="stylesheet" href="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/css/bootstrap.min.css">  
<script src="https://cdn.staticfile.org/jquery/2.1.1/jquery.min.js"></script>
<script src="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/js/bootstrap.min.js"></script>
<script>
	$(function () { $("[data-toggle='tooltip']").tooltip(); });
</script>
</head>
<body>

   <table class="table table-hover">
       <thead>
       	  <tr>
       	  	<th>账号</th>
       	  	<th>姓名</th>
       	  	<th>专业</th>
       	  	<th>班级</th>
       	  	<th>院系</th>
       	  	<th>联系电话</th>
       	  </tr>
       </thead>
       <tbody>
          <c:choose>
		  <c:when test="${!empty sessionScope.addressBooklist}">
		  <c:forEach var="addressBook" items="${sessionScope.addressBooklist }">
       	      <tr>
       	  		<td>${addressBook.userid }</td>
       	  		<td>${addressBook.studentName }</td>
       	  		<td>${addressBook.major }</td>
       	  		<td>${addressBook.cs }</td>
       	  		<td>${addressBook.departmentName }</td>
       	  		<td>${addressBook.phoneNum }</td>

       	 	 </tr>
       	  </c:forEach>
		  </c:when>
		  </c:choose>
       </tbody>
   </table>
</body>
</html>