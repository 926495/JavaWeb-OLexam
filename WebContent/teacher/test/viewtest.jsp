<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%-- <%@ page import="com.sdut.onlinexam.po.Question"%> --%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!-- 查看试卷时候使用 -->
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>无标题文档</title>
<link rel="stylesheet" href="<%=path%>/css/style2.css">
<link rel="stylesheet" href="<%=path%>/css/jqTable.css">
<link rel="stylesheet" href="<%=path%>/layui/css/layui.css"  media="all">
<style>
p {
	text-indent: 2em;
}
.p20{
		padding:20px 100px 0px 150px;
}
</style>
</head>

<body>
	
	<div class="p20">
	<br><br><br>
	<lable class="layui-btn layui-btn-sm layui-btn-normal">试卷属性：</lable><br>
		<div class="c-table c-table--border">
			<table cellspacing="0" cellpadding="0" border="0" role="c-table">
				<colgroup>
	              <col  width="100" >
	              <col name="" width="100" >
	              <col name="" width="260" >
	              <col name="" width="180" >
	              <col name="" width="100" >
	            </colgroup>
	            <thead>
	              <tr>
	                <th class="">
	                  <div class="cell">试卷名称 </div>
	                </th>
	                <th class="">
	                  <div class="cell">考试科目</div>
	                </th>
	                <th class="">
	                  <div class="cell">考试班级</div>
	                </th>
	                <th class="">
	                  <div class="cell">考试截止时间</div>
	                </th>
	                <th class="">
	                  <div class="cell">考试时长</div>
	                </th>
	              </tr>
	            </thead>
				<td>${test.name}</td>
				<td >${test.cName}</td>
				<td>${test.className}</td>
				<td> ${test.endDate}</td>
				<td> ${test.testTime}min</td>
			</table>
		</div>
	</div>
	
	<div class="p20">
	<lable class="layui-btn layui-btn-sm layui-btn-normal">试卷内容：</lable><br>
		<div class="c-table c-table--border">
			<table cellspacing="0" cellpadding="0" border="0" role="c-table">
				<colgroup>
	              <col  width="100" >
	              <col name="" width="320" >
	              <col name="" width="200" >
	              <col name="" width="120" >
	            </colgroup>
	            <thead>
	              <tr>
	                <th class="">
	                  <div class="cell">题型 </div>
	                </th>
	                <th class="">
	                  <div class="cell">题目</div>
	                </th>
	                <th class="">
	                  <div class="cell">选项</div>
	                </th>
	                <th class="">
	                  <div class="cell">正确答案</div>
	                </th>
	              </tr>
	            </thead>
				<c:forEach var="que" items="${quesList}" varStatus="status">
					<tr>
						<td>单项选择</td>
						<td class="text">${status.index + 1} .${que.queTitle}</td>
						<td> A---${que.choiceA }； B---${que.choiceB }；C---${que.choiceC }；D---${que.choiceD }</td>
						<td class="layui-btn"> 正确答案：${que.ans }</td>
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
<script src="<%=path%>/layui/layui.js" charset="utf-8"></script>
</body>
</html>