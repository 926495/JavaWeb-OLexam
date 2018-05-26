<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt" %> 
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>无标题文档</title>
<link href="<%=path%>/css/style2.css" rel="stylesheet" type="text/css" />
<link href="<%=path%>/css/default.css" rel="stylesheet" type="text/css" />
<link href="<%=path%>/css/calendar-blue.css" rel="stylesheet" type="text/css" />
<link rel="stylesheet" href="<%=path%>/css/table.css">
<link rel="stylesheet" href="<%=path%>/layui/css/layui.css"  media="all">
<style>
p {
	text-indent: 2em;
}
textarea {
	　　resize: none;
}
</style>
</head>

<body>
<h3 class="subTitle">修改学生信息
		&nbsp;&nbsp;&nbsp;&nbsp;学生编号${student.id }</h3>
	<div class="contact" >
		<form style="background-color: #D4D4D4" name="form1" action="<%=path%>/studentModifyServlet"  method="post">
			<!-- 用新的标签存id -->
			<input type="hidden" readonly="readonly" name="id" id="id"
					value="${student.id }" />
			<ul>
				<li>
					<label>姓名：</label>
					<input type="text" name="name"	id="name" value="${student.name }" />
				</li>
				<li>
					<label>密码：</label>
					<input type="password" name="pwd" id="pwd"
							value="${student.pwd }" />
				</li>
				<li>
					<label>性别：</label>
					<input type="radio" value="男" name="sex"  <c:if test="${student.sex =='男' }">checked="checked"</c:if> />男 
					<input type="radio" value="女" name="sex"  <c:if test="${student.sex =='女' }">checked="checked"</c:if> />女
				</li>
				<li>
					<label>出生日期：</label>
					<input type="text" name="born" id="born" value="${student.born }" />
				</li>
				<li>
					<label>所在学校：</label>
					<input type="text" name="school" id="school" value="${student.school }" />
				</li>
				<li>
					<label>所在班级：</label>
					<select name="classId">
							<c:forEach var="c" items="${classList}">
								<option value=${c.id}>${c.name}</option>
							</c:forEach>
					</select>
				</li>
			</ul>
			<b class="btn"><input class="layui-btn layui-btn-normal layui-btn-radius" type="submit" value="提交"/>
			<input class="layui-btn layui-btn-warm layui-btn-radius" type="reset" value="重置"/></b>
		</form>
	</div>
	
<p>
<script type="text/javascript" src="<%=path%>/js/calendar.js"></script>
<script>
Calendar.setup({
inputField : "born",
ifFormat : "%Y-%m-%d",
showsTime : true,
timeFormat : "24"
});
</script>
</p>

<script src="<%=path%>/layui/layui.js" charset="utf-8"></script>
</body>
</html>