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
<link href="<%=path%>>/css/style2.css" rel="stylesheet" type="text/css" />
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
<script>
	function anscheck(eeId) {
		var a = document.getElementById("ans").value;
		var re = /^[A-D]{1,4}$/;
		if (re.test(a)) {
			return true;
		} else {
			var msg = "正确答案只能为大写英文！";
			showErrorMsg(msg, eeId);
			return false;
		}
	}
	function isNotNull(uuid) {
		var value = document.getElementById(uuid).value;
		if (value == null || value == "") {
			return false;
		} else {
			return true;
		}
	}
	function showErrorMsg(msg, eeId) {
		document.getElementById(eeId).style.display = "";
		document.getElementById(eeId).innerHTML = msg;
	}
	//当获得焦点 错误信息就不显示
	function clearErrorMsg(eId) {
		document.getElementById(eId).style.display = "none";
	}

	function verInput() {
		var obj = document.getElementById("type");
		var value = obj.selectedIndex;
		if (value == 2) {
			if (anscheck('ans_hint') && isNotNull('ques')
					&& isNotNull('choice_A') && isNotNull('choice_B')) {
				return true;
			} else {
				alert("添加失败，请将信息填写完整、正确！");
				return false;
			}
		} else {
			if (anscheck('ans_hint') && isNotNull('ques')
					&& isNotNull('choice_A') && isNotNull('choice_B')
					&& isNotNull('choice_C') && isNotNull('choice_D')) {
				return true;
			} else {
				alert("添加失败，请将信息填写完整、正确！");
				return false;
			}
		}
	}
	function selectChoice() {
		var obj = document.getElementById("type");
		var value = obj.selectedIndex;
		if (value == 2) {
			document.getElementById("choice_C").style.display = "none";
			document.getElementById("choice_D").style.display = "none";
		}
		if (value == 0 || value == 1) {
			document.getElementById("choice_A").style.display = "block";
			document.getElementById("choice_B").style.display = "block";
			document.getElementById("choice_C").style.display = "block";
			document.getElementById("choice_D").style.display = "block";
		}
	}
</script>
</head>

<body>
	<div class="contact" >
		<form style="background-color: #D4D4D4" name="form1" action="questionAddServlet" onsubmit="return verInput();" method="post">
			<ul>
				<li>
					<label>科目：</label>
					 <select name="courseId" id="courseId">
							<c:forEach var="course" items="${courseList}">
								<option value="${course.id}">${course.name}</option>
							</c:forEach>
					</select>
				</li>
				<li>
					<label>题目类型：</label>单项选择
				</li>
				<li>
					<label>题目：</label>
					 <textarea name="queTitle" id="queTitle" style="resize: none;"></textarea>
				</li>
				<li>
					<label>选项A：</label>
					<input type="text" name="choiceA" id="choiceA" />
				</li>
				<li>
					<label>选项B：</label>
					<input type="text" name="choiceB" id="choiceB" />
				</li>
				<li>
					<label>选项C：</label>
					<input type="text" name="choiceC" id="choiceC" />
				</li>
				<li>
					<label>选项D：</label>
					<input type="text" name="choiceD" id="choiceD" />
				</li>
				<li>
					<label>正确答案：</label>
					<input type="text" name="ans" id="ans" />
				</li>
			</ul>
			<b class="btn"><input class="layui-btn layui-btn-normal layui-btn-radius" type="submit" value="提交"/>
			<input class="layui-btn layui-btn-warm layui-btn-radius" type="reset" value="重置"/></b>
		</form>
	</div>
<script src="<%=path%>/layui/layui.js" charset="utf-8"></script>
</body>
</html>