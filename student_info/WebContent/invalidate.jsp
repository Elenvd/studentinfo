<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>注销页面</title>
    <meta http-equiv="Refresh" content="1;URL=${pageContext.request.contextPath }/login.jsp" />
	
  </head>
  
  <body>
     <% session.invalidate(); %>
  </body>
</html>
