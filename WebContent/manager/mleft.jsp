<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html>
<html>

<head>

  <meta charset="UTF-8">

  <title>CSS3带小图标垂直下拉菜单DEMO演示</title>
  <link href="http://maxcdn.bootstrapcdn.com/font-awesome/4.2.0/css/font-awesome.min.css" rel="stylesheet">
  <link rel="stylesheet" href="<%=path%>/css/reset-left.css">
    <link rel="stylesheet" href="<%=path%>/css/style-left.css" media="screen" type="text/css" />
    
<script>
history.go(1);//屏蔽回退
	document.oncontextmenu = function(e){
		if(e==null)e = window.event;
		e.cancelBubble = true;
		e.returnValue=false;
		return true;//右键屏蔽
	};
</script>
</head>

<body>

  <div class="menu">
    <header class="menu__header">
      <h1 class="menu__header-title">Onlinexam--Admin</h1>
    </header>
    <div class="menu__body">
      <ul class="nav">
        <li class="nav__item">
        <!-- 超链接可以向后台发送请求  超链接：a href
        	target 指向的时相应的frame -->
          <a href="mmain.jsp" target="mainFrame" class="nav__item-link" >
            <i class="fa fa-flag nav__item-icon"></i>
            <span class="nav__item-text">欢迎页面</span>
          </a>   
        </li>
        <li class="nav__item">
          <a href="<%=path%>/stuClassQueryServlet" target="mainFrame" class="nav__item-link">
            <i class="fa fa-flag nav__item-icon"></i>
            <span class="nav__item-text">班级管理</span>
          </a>   
        </li>
         <li class="nav__item">
          <a href="<%=path%>/teacherQueryServlet" target="mainFrame" class="nav__item-link">
            <i class="fa fa-flag nav__item-icon"></i>
            <span class="nav__item-text">教师管理</span>
          </a>   
        </li>
        <li class="nav__item">
          <a href="<%=path%>/courseQueryServlet" target="mainFrame" class="nav__item-link">
            <i class="fa fa-flag nav__item-icon"></i>
            <span class="nav__item-text">课程管理</span>
          </a>   
        </li>
        <li class="nav__item">
          <a href="<%=path%>/scheduleQueryServlet" target="mainFrame" class="nav__item-link">
            <i class="fa fa-flag nav__item-icon"></i>
            <span class="nav__item-text">班级排课管理</span>
          </a>   
        </li>
        <li class="nav__item">
          <a href="<%=path %>/studentQueryServlet" target="mainFrame" class="nav__item-link">
            <i class="fa fa-flag nav__item-icon"></i>
            <span class="nav__item-text">学生管理</span>
          </a>   
        </li>
        <li class="nav__item">
          <a href="<%=path %>/logoutServlet" target="_parent" onclick="javascript: return confirm('确认退出用户吗？');" class="nav__item-link">
            <i class="fa fa-space-shuttle nav__item-icon"></i>
            <span class="nav__item-text">退出用户</span>
          </a>   
        </li>
      </ul>
    </div>
  </div>

<div style="text-align:center;clear:both;">
<script src="/gg_bd_ad_720x90.js" type="text/javascript"></script>
<script src="/follow.js" type="text/javascript"></script>
</div>
</body>

</html>