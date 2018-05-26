<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
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
		学生管理
		 <div class="search">
			  <form id="form1" method="get" action="">
				班级名称
				<input type="text" name="courname" id = "courname">
				<input type="submit" name="Submit" class="btn_grey" value="搜索" />
			</form>
			
		</div>
		&nbsp;&nbsp;&nbsp;&nbsp;<a href="<%=path%>/studentAddServlet">增加学生</a>
	</h3>
	<br/>
	<div class="c-table c-table--border">
		<table cellspacing="0" cellpadding="0" border="0" role="c-table">
			<colgroup>
              <col  width="" data-sort="up">
              <col name="" width="110" data-sort="true">
              <col name="" width="110" data-sort="true">
              <col name="" width="110" data-sort="true">
              <col name="" width="120" data-sort="true">
              <col name="" width="120" data-sort="true">
              <col name="" width="110" data-sort="true">
              <col name="" width="110">
              <col name="" width="110">
            </colgroup>
            <thead>
              <tr>
                <th class="">
                  <div class="cell">学生学号</div>
                </th>
                <th class="">
                  <div class="cell">学生姓名</div>
                </th>
                <th class="">
                  <div class="cell">登录密码</div>
                </th>
                <th class="">
                  <div class="cell">学生性别</div>
                </th>
                <th class="">
                  <div class="cell">出生日期</div>
                </th>
                <th class="">
                  <div class="cell">所在班级</div>
                </th>
                <th class="">
                  <div class="cell">所属属性</div>
                </th>
                <th class="">
                  <div class="cell">修改操作</div>
                </th>
                <th class="">
                  <div class="cell">删除操作</div>
                </th>
              </tr>
            </thead>
			<c:forEach var="st" items="${stuList}">
			<tr align="center">
				<td>${st.id}</td>
				<td>${st.name}</td>
				<td>${st.pwd}</td>
				<td>${st.sex}</td>
				<td>${st.born}</td>
				<td>${st.className}</td>
				<td>${st.deptName}</td>
				<td><button class="layui-btn" onclick="window.location.href='<%=path%>/studentModifyServlet?id=${st.id}'"><i class="layui-icon"></i>修改</button></td>
				<td><button class="layui-btn" onclick="window.location.href='<%=path%>/studentDeleteServlet?id=${st.id}'"><i class="layui-icon"></i>删除</button></td>
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