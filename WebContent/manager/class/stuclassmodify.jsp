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
select:hover{
	color:black;
}
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
		<form style="background-color: #D4D4D4" name="form1" action="stuClassModifyServlet"  method="post">
			<!-- 用新的标签存id -->
			<input hidden="hidden" name="stuClassId" id="stuClassId" value="${stuClass.id}"></input>
			<ul>
				<li>
					<label>班级名称：</label>
					<input type="text" name="classname"	id="classname" value="${stuClass.name}" />
				</li>
				<li>
					<label>所属方向：</label>
					<td><select name="depInfo">
							<c:forEach var="dept" items="${deptList}">
								<!-- 要把迭代出来的所属方向的值和要查询的对象的值要对应 
									dept是迭代的值，stuClss是后台传递过来的值
									deptName是
								-->
								<c:choose>
									<c:when test="${dept==stuClass.deptName}">
										<option value="${dept}" selected="selected">${dept}</option>
									</c:when>
									<c:otherwise>
										<option value="${dept}">${dept}</option>
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