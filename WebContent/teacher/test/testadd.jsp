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
<title></title>
<link href="<%=path%>/css/style2.css" rel="stylesheet" type="text/css" />
<link href="<%=path%>/css/default.css" rel="stylesheet" type="text/css" />
<link href="<%=path%>/css/calendar-blue.css" rel="stylesheet" type="text/css" />
<link rel="stylesheet" href="<%=path%>/css/table.css">
<link rel="stylesheet" href="<%=path%>/layui/css/layui.css"  media="all">
<style>
p {
	text-indent: 2em;
}

</style>

</head>

<body>
	<div class="contact" >
		<form style="background-color: #D4D4D4" name="form1" action="testAddServlet" onsubmit="return InputM();" method="post">
			<ul>
				<li>
					<label>考试科目为：</label>
					 <select name="courseid" id="courseid">
						<c:forEach var="course" items="${courseList }">
							<option value="${course.id}">${course.name}</option>
						</c:forEach>
					</select>
				</li>
				<li>
					<label>试卷名称为：</label>
					<input type="text" name="testname" id="testname" onblur="isNotNull('testname');" />
				</li>
				<li>
					<label>考试截止时间为：</label>
					<input name="enddate" type="text" id="control_date" size="20" maxlength="10" readonly="readonly" value='' />
				</li>
				<li>
					<label>单项选择题总分：</label>
					<input name="sinscores" id="sinscores" type="text" size="1"	onblur="isNotNull('sinscores');" />
					&nbsp;&nbsp; 
				</li>
				<li>
					<label>单项选择题数量：</label>
					<input name="sinnum" type="text" id="sinnum" size="5" onblur="isNotNull('sinnum');" /> 
					<br/>
				</li>
				<li>
					<label>考试时间：</label>
					<input name="testtime" id="testtime" value="45"	type="text" size="5" onblur="isNotNull('testtime')" />分钟
				</li>
				<li>
					<label>面向班级：</label>
					<c:forEach var="stuclass" items="${classesList}">
						<input type="checkbox" name="classCheck" value="${stuclass.id}" checked="checked"/>${stuclass.name}
					</c:forEach>
				</li>
			</ul>
			<b class="btn"><input class="layui-btn layui-btn-normal layui-btn-radius" type="submit" value="提交"/>
			<input class="layui-btn layui-btn-warm layui-btn-radius" type="reset" value="重置"/></b>
		</form>
	</div>
	
	<p>
<script type="text/javascript" src="<%=path%>/js/calendar.js"></script>
<script src="<%=path%>/layui/layui.js" charset="utf-8"></script>
<script>
Calendar.setup({
inputField : "control_date",
ifFormat : "%Y-%m-%d %H:%M:%S",
showsTime : true,
timeFormat : "24"
});
</script>
	</p>
</body>${hint }
</html>