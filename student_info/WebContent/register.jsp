<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>系统登录</title>
<link href="css/login.css" rel="stylesheet" rev="stylesheet" type="text/css" media="all" />
<link href="css/demo.css" rel="stylesheet" rev="stylesheet" type="text/css" media="all" />
<script type="text/javascript" src="js/jquery1.42.min.js"></script>
<script type="text/javascript" src="js/jquery.SuperSlide.js"></script>
<script type="text/javascript" src="js/Validform_v5.3.2_min.js"></script>
</head>
<body>
<div class="header">
  <h1 class="headerLogo"><img alt="logo" src="images/logo_school.png"></a></h1>
	<div class="headerNav">
		<a target="_blank" href="#">学校官网</a>
		<a target="_blank" href="#">关于松田</a>
		<a target="_blank" href="#">开发团队</a>
		<a target="_blank" href="#">意见反馈</a>
		<a target="_blank" href="#">帮助</a>	
	</div>
</div>

<div class="banner">

<div class="login-aside">
  <div id="o-box-up"></div>
  <div id="o-box-down"  style="table-layout:fixed;">
   <div class="error-box"></div>
   
   <form class="registerform" action="register.action" method="post">
   <div class="fm-item">
	   <label for="logonId" class="form-label">学生信息系统登陆：</label>
	   <input type="text" value="" maxlength="100" id="username" class="i-text" placeholder="请输入账号"  >    
       <div class="ui-form-explain"></div>
  </div>
  
  <div class="fm-item">
	   <label for="logonId" class="form-label">登陆密码：</label>
	   <input type="password" value="" maxlength="100" id="password" class="i-text" placeholder="请输入密码" >    
       <div class="ui-form-explain"></div>
  </div>
  <div class="fm-item">
	   <label for="logonId" class="form-label">确认密码：</label>
	   <input type="password" value="" maxlength="100" id="password" class="i-text" placeholder="请再次输入密码"  >    
       <div class="ui-form-explain"></div>
  </div>
  
  <div class="role">
  	<label for="logonId" class="form-label">您的角色：</label>
  	
  	
  	<input type="radio" name="role" value="学生" checked><span style="color: white">学生</span>
	<input type="radio" name="role" value="教师"><span style="color: white">教师</span>
	<input type="radio" name="role" value="管理员"><span style="color: white">管理员</span>
  </div>
  
  <div class="fm-item">
	   <label for="logonId" class="form-label"></label>
	   <input type="submit" value="" tabindex="4" id="send-btn" class="btn-register"> 
       <div class="ui-form-explain"></div>
  </div>
  
  	<a href="login.jsp">已有账号？</a>
  
  </form>
  
  </div>

</div>

	<div class="bd">
		<ul>
			<li style="background:url(images/bg2.jpg)  #CCE1F3 center 0 no-repeat;"></li>
			<li style="background:url(images/bg5.jpg) #BCE0FF center 0 no-repeat;"></li>
		</ul>
	</div>

	<div class="hd"><ul></ul></div>
</div>
<script type="text/javascript">jQuery(".banner").slide({ titCell:".hd ul", mainCell:".bd ul", effect:"fold",  autoPlay:true, autoPage:true, trigger:"click" });</script>


<div class="banner-shadow"></div>

<div class="footer">
   <p>Copyright &copy; 2019.Company name All rights reserved.</p>
</div>
<div style="display:none"><script src='http://v7.cnzz.com/stat.php?id=155540&web_id=155540' language='JavaScript' charset='gb2312'></script></div>
</body>
</html>
