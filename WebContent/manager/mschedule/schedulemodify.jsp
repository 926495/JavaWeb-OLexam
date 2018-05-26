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
</style>
</head>
<body>
	<div class="contact" >
		<form style="background-color: #D4D4D4" name="form1" action="scheduleModifyServlet"  method="post">
			<!-- 用新的标签存id -->
			<input type="hidden" readonly="readonly" name="id" id="id"
					value="${tc.id }" />
			<tr style="text-align:center">
					<td ><label style="color:red" >&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;课程名称不允许修改,只能修改课程和老师班级之间的关联</label></td>
			</tr>
			<ul>
				<li>
					<label>课程名称：</label>
					<td><select name="course">
						<c:forEach var="cour" items="${courList}">
							<c:choose>
								<c:when test="${cour.id==tc.courseId}">
									<option value="${cour.id}" selected="selected">${cour.name}</option>
								</c:when>
								<c:otherwise>
									<option value="${cour.id}">${cour.name}</option>
								</c:otherwise>
							</c:choose>
						</c:forEach>
					</select></td>
				</li>
				<li>
					<label>讲师姓名：</label>
					<td><select name="teacher">
							<c:forEach var="tea" items="${teaList}">
								<c:choose>
									<c:when test="${tea.id==tc.teaId}">
										<option value="${tea.id}" selected="selected">${tea.name}</option>
									</c:when>
									<c:otherwise>
										<option value="${tea.id}">${tea.name}</option>
									</c:otherwise>
								</c:choose>
							</c:forEach>
					</select></td>
				</li>
				<li>
					<label>负责班级：</label>
					<td><select name="stuclass">
							<c:forEach var="stucl" items="${stuclList}">
								<c:choose>
									<c:when test="${stucl.id==tc.classId}">
										<option value="${stucl.id}" selected="selected">${stucl.name}</option>
									</c:when>
									<c:otherwise>
										<option value="${stucl.id}">${stucl.name}</option>
									</c:otherwise>
								</c:choose>
							</c:forEach>
					</select></td>
				</li>
			</ul>
			<b class="btn"><input class="layui-btn layui-btn-normal layui-btn-radius" type="submit" value="提交"/>
			<input class="layui-btn layui-btn-warm layui-btn-radius" type="reset" value="重置"/></b>
		</form>
	</div>
	
	
    <script src="<%=path%>/layui/layui.js" charset="utf-8"></script>
</body>
</html>