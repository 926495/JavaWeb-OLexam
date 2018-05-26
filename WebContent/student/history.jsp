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
<title>以往试卷成绩查询</title>
<link href="<%=path%>/css/style2.css" rel="stylesheet" type="text/css" />
<link rel="stylesheet" href="<%=path%>/css/jqTable.css">
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
		${user.name }，以往试卷成绩查询
		<div class="search">
			<form  action="<%=path%>/" method = "post">
				课程名称 :	<input type="text" name= "courseSearch" value=""> 
				<input type="submit" class="btn_grey" value="搜索">
			</form>
		</div>
	</h3>
	<br />
	<div class="c-table c-table--border">
		<table cellspacing="0" cellpadding="0" border="0" role="c-table">
			<colgroup>
              <col  width="200" data-sort="up">
              <col name="" width="200" data-sort="true">
              <col name="" width="200" data-sort="true">
              <col name="" width="200" data-sort="true">
              <col name="" width="200" data-sort="true">
            </colgroup>
            <thead>
              <tr>
                <th class="">
                  <div class="cell">考试科目</div>
                </th>
                <th class="">
                  <div class="cell">试卷名称</div>
                </th>
                <th class="">
                  <div class="cell">考试时长</div>
                </th>
                <th class="">
                  <div class="cell">考试时间</div>
                </th>
                <th class="">
                  <div class="cell">考试得分</div>
                </th>
              </tr>
            </thead>
		<c:forEach var="paper" items="${paperList}">
			<tr align="center">
				<td>${paper.courseName}</td>
				<td><a href = '<%=path%>/lookUpTestServlet?pId=${paper.pId}' class="layui-btn layui-btn-warm">${paper.testName}</a></td>
				<td>${paper.time}</td>
				<td>${paper.createDate}</td>
				<c:if test="${paper.score<60}">
					<td class="layui-btn layui-btn-danger layui-btn-radius">${paper.score}分</td>
				</c:if>
				<c:if test="${paper.score>=60}">
					<td class="layui-btn layui-btn-primary layui-btn-radius">${paper.score}分</td>
				</c:if>
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