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
<script language="javascript" type="text/javascript"
	src="My97DatePicker/WdatePicker.js"></script>
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
		<form style="background-color: #D4D4D4" name="form1" action="studentAddServlet"  method="post">
			<ul>
				<li>
					<label>学生姓名：</label>
					<input type="text" name="stuName" id="stuName" />
				</li>
				<li>
					<label>密码：</label>
					<input type="text" name="pwd" id="pwd" />
				</li>
				<li>
					<label>学生性别：</label>
					<input type="radio" value="男"
							name="stuSex" />男 <input type="radio" value="女" name="stuSex" />女
				</li>
				
				<li>
					<label>出生日期：</label>
					<input type="text" name="bornDate"
						id="bornDate" onclick="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm'})" />
				</li>
				
				<li>
					<label>所在学校：</label>
					<input type="text" name="stuSchool"
						id="stuSchool" />
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

<script src="<%=path%>/layui/layui.js" charset="utf-8"></script>
</body>
</html>