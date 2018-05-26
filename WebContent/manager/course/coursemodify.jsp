<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>无标题文档</title>
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
</style>
</head>
<body>
	<div class="contact" >
		<!-- 因为是增加，所以method="post" -->
		<form style="background-color: #D4D4D4" name="form1" action="courseModifyServlet"  method="post">
			<input hidden="hidden" name="courId" id="courId"
				value="${cour.id}"></input>
			<ul>
				<li>
					<label>课程名称：</label>
					<td width="240"><input type="text" name="coursename"
						id="classname" value="${cour.name}" /></td>
				</li>
			</ul>
			<b class="btn"><input class="layui-btn layui-btn-normal layui-btn-radius" type="submit" value="提交"/>
			<input class="layui-btn layui-btn-warm layui-btn-radius" type="reset" value="重置"/></b>
					
		</form>
    <script src="<%=path%>/layui/layui.js" charset="utf-8"></script>
</body>
</html>