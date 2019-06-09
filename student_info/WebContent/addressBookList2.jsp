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
<title>教师通讯录列表</title>
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
       	  	<th>联系电话</th>
       	  </tr>
       </thead>
       <tbody>
          <c:choose>
		  <c:when test="${!empty sessionScope.addressBook2list}">
		  <c:forEach var="addressBook2" items="${sessionScope.addressBook2list}">
       	      <tr>
       	  		<td>${addressBook2.userId }</td>
       	  		<td>${addressBook2.teacherName }</td>
       	  		<td>${addressBook2.phoneNum }</td>

       	 	 </tr>
       	  </c:forEach>
		  </c:when>
		  </c:choose>
       </tbody>
   </table>
</body>
</html>