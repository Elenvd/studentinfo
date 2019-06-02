<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<link rel="stylesheet" href="css/base.css" />
<link rel="stylesheet" type="text/css" href="css/jquery.dialog.css" />
<link rel="stylesheet" href="css/index.css" />
    <style>
        .layui-layer-title{
        background:url(images/righttitlebig.png) repeat-x;
        font-weight:bold;
        color:#46647e;
         border:1px solid #c1d3de;
         height: 33px;
         line-height: 33px;
         }
         #top_menu{
           margin-right:30px;
           margin-top:30px;
         }
         #top_menu a{
           font-size:15px;
           color:white;
           text-decoration:none;
           font-family:Arial;
           margin-right:10px;
         }
         #top_menu a:hover{color:yellow;}
    </style>
<title>学生信息管理系统</title>
</head>
<body>
<div id="container">
	<div id="hd">
    	<div class="hd-wrap ue-clear">
        	<div class="top-light"></div>
            <h1 class="logo"></h1>
            <div class="login-info ue-clear">
                <div class="welcome ue-clear"><span>欢迎您,
                   <c:forEach var="user" items="${sessionScope.list }">
                        ${user.userName }
                        &nbsp;&nbsp; &nbsp;&nbsp; 角色：${user.type }
                   </c:forEach>
                </span></div>
                
            </div>
            <div id="top_menu" style="float:right">
                 <a href="login.jsp" onFocus="this.blur()" class="admin-out">登录</a>
                 <a href="${pageContext.request.contextPath }/invalidate.jsp" class="admin-out">退出</a>
            </div>
        </div>
    </div>
    <div id="bd">
    	<div class="wrap ue-clear">
        	<div class="sidebar">
            	<h2 class="sidebar-header"><p>功能导航</p></h2>
                <ul class="nav">
                	<li class="office current"><div class="nav-header"><a href="index_home.jsp" target="right" class="ue-clear"><span>首页</span><i class="icon"></i></a></div></li>
                	
                    <li class="land"><div class="nav-header"><a href="JavaScript:;" class="ue-clear"><span>个人信息管理</span><i class="icon hasChild"></i></a></div>
                        <ul class="subnav">                  
                            <li><a href="personInfo.jsp" target="right">我的信息</a></li>
                            <li><a href="#" target="right">修改密码</a></li>                         
                        </ul>
                    </li>
                     
                                     
                    <li class="train"><div class="nav-header"><a href="JavaScript:;" class="ue-clear" ><span>教师管理</span><i class="icon hasChild"></i></a></div>
                        <ul class="subnav">
                            <li><a href="#" target="right">教师列表</a></li>
                            <li><a href="#" target="right">课程管理</a></li>

                        </ul>
                    </li>
                    
                  
                    <li class="email"><div class="nav-header"><a href="#"class="ue-clear"  target="right"><span>消息推送</span><i class="icon"></i></a></div></li>
                    <li class="list_m"><div class="nav-header"><a href="#" class="ue-clear" target="right"><span>通讯录管理</span><i class="icon"></i></a></div>
                    	<ul class="subnav">
                            <li><a href="#" target="right">学生通讯录</a></li>
                            <li><a href="#" target="right">教师通讯录</a></li>

                        </ul>
                    </li>
                    <li class="news_m"><div class="nav-header"><a href="#" class="ue-clear"  target="right"><span>通知通告</span><i class="icon"></i></a></div></li>



                     
                    <li class="dossier"><div class="nav-header"><a href="JavaScript:;" class="ue-clear" ><span>学生信息管理</span><i class="icon hasChild"></i></a></div>
                        <ul class="subnav">
                            <li><a href="#" target="right">学生档案</a></li>
                            <li><a href="#" target="right">学生成绩管理</a></li>

                        </ul>
                    </li>

                    <li class="part"><div class="nav-header"><a href="JavaScript:;" class="ue-clear" ><span>系统管理</span><i class="icon hasChild"></i></a></div>
                        <ul class="subnav">
                            <li><a href="${pageContext.request.contextPath }/userList.action" target="right">用户管理</a></li>
                            <li><a href="#" target="right">院系管理</a></li>
                            <li><a href="#" target="right">班级管理</a></li>
                            <li><a href="#" target="right">角色管理</a></li>

                        </ul>
                    </li>
                </ul>
            </div>
            <div class="content">
            	<iframe src="index_home.jsp" id="iframe" width="100%" height="100%" frameborder="0" name="right" style="min-width: 1100px"></iframe>
            </div>
        </div>
    </div>
    <div id="ft" class="foot_div">

        <p style="text-align:center">Copyright &copy; 2019.Company name All rights reserved.</p>

        
    </div>
</div>

</body>
<script type="text/javascript" src="js/jquery.js"></script>
<script type="text/javascript" src="js/core.js"></script>
<script type="text/javascript" src="js/jquery.dialog.js"></script>
<script type="text/javascript" src="js/index.js"></script>
<script src="js/layer_v2.1/layer/layer.js"></script>

</html>
