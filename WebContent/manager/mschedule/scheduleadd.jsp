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
<link rel="stylesheet" href="<%=path%>/css/table.css">
<link rel="stylesheet" href="<%=path%>/layui/css/layui.css"  media="all">
<style>
p {
	text-indent: 2em;
}

textarea {
	　　resize: none;
}

.text2 {
	width: 700px;
	line-height: 40px;
	font-size: 16px;
	font-family: Arial, "宋体";
	margin: 0 auto;
	margin-top: 20px;
}
</style>
</head>
<body>
	<div class="contact" >
		<form style="background-color: #D4D4D4" name="form1" action="scheduleAddServlet"  method="post">
			<!-- 用新的标签存id -->
			<input hidden="hidden" name="stuClassId" id="stuClassId" value="${stuClass.id}"></input>
			<ul>
				<li>
					<label>课程名称：</label>
					<select name="course">
							<c:forEach var="course" items="${courseList}">
								<option value="${course.id}">${course.name}</option>
							</c:forEach>
					</select>
				</li>
				<li>
					<label>讲师姓名：</label>
					<select name="teacher">
							<c:forEach var="tea" items="${teaList}">
								<option value="${tea.id}">${tea.name}</option>
							</c:forEach>
					</select>
				</li>
				<li>
					<label>负责班级：</label>
					<select name="stuclass">
							<c:forEach var="stucl" items="${stuclList}">
								<option value="${stucl.id}">${stucl.name}</option>
							</c:forEach>
					</select>
				</li>
			</ul>
			<b class="btn"><input class="layui-btn layui-btn-normal layui-btn-radius" type="submit" value="提交"/>
			<input class="layui-btn layui-btn-warm layui-btn-radius" type="reset" value="重置"/></b>
		</form>
	</div>
	
<script src="<%=path%>/layui/layui.js" charset="utf-8"></script>
</body>
</html>