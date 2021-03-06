<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link href="<%=path%>/css/style2.css" rel="stylesheet" type="text/css" />
<link rel="stylesheet" href="<%=path%>/css/jqTable.css">
<link rel="stylesheet" href="<%=path%>/layui/css/layui.css"  media="all">
<style>
	.p20{
		padding:20px;
	}
</style>
</head>
<body>
<div class="p20">
	<h3 class="subTitle">
		班级排课管理
		<div class="search">
			<form action="<%=path%>/scheduleQueryServlet" method = "post">
				课程名称 :	<input type="text" name= "courseSearch"  value="${courseSearch }">
				<input type="submit" class="btn_grey" value="搜索">
				
			</form>
		</div>
		&nbsp;&nbsp;&nbsp;&nbsp;<a href="<%=path%>/scheduleAddServlet">新加排课信息</a>
	</h3>
	<br />
	<div class="c-table c-table--border">
		<table cellspacing="0" cellpadding="0" border="0" role="c-table">
			<colgroup>
              <col  width="160" data-sort="up">
              <col name="" width="" data-sort="true">
              <col name="" width="180" data-sort="true">
              <col name="" width="180" data-sort="true">
              <col name="" width="150">
              <col name="" width="150">
            </colgroup>
            <thead>
              <tr>
                <th class="">
                  <div class="cell">序号 </div>
                </th>
                <th class="">
                  <div class="cell">课程名称 </div>
                </th>
                <th class="">
                  <div class="cell">任课教师</div>
                </th>
                <th class="">
                  <div class="cell">所教班级</div>
                </th>
                <th class="">
                  <div class="cell">修改操作</div>
                </th>
                <th class="">
                  <div class="cell">删除操作</div>
                </th>
              </tr>
            </thead>
			<c:forEach var="tc" items="${tcList}">
				<tr align="center">
					<td>${tc.id}</td>
					<td>${tc.courName}</td>
					<td>${tc.teaName}</td>
					<td>${tc.className}</td>
					<td><button class="layui-btn" onclick="window.location.href='<%=path%>/scheduleModifyServlet?id=${tc.id}'"><i class="layui-icon"></i>修改</button></td>
					<td><button class="layui-btn" onclick="window.location.href='<%=path%>/scheduleDeleteServlet?id=${tc.id}'"><i class="layui-icon"></i>删除</button></td>
			</tr>
			</c:forEach>
		</table>
	</div>
 </div>

   <script src="http://www.jq22.com/jquery/jquery-1.10.2.js"></script>
    <script src="<%=path%>/js/jstable/plugins/artTemplate.js"></script>
    <!--另一个插件，消息提示插件  -->
    <script src="<%=path%>/js/jstable/plugins/message.js"></script>
    <!-- 总引入  -->
    <script src="<%=path%>/js/jstable/zipJs/jqTable.all.min.js"></script>
    <!-- 临时用的json -->
    <script src="<%=path%>/js/jstable/json.js"></script>
    <!-- 排序 -->
    <script type="text/javascript">
      $(function(){
          $('[role="c-table"]').jqTable({
            fixedLeft: true,
            fixedRight: true
          });
      });
    </script>
<script src="<%=path%>/layui/layui.js" charset="utf-8"></script>
</body>
</html>