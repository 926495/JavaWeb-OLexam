<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>增加试题</title>
<link href="<%=path%>/css/style2.css" rel="stylesheet" type="text/css" />
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
	<form id="form1" method="get" action="<%=path%>/questionQueryServlet">
		<h3 class="subTitle">
			题库管理
			<div class="search">
				<select name="selectk" id="selectk">
					<option selected="selected" value="name">课程科目</option>
					<option value="queTitle">试题题目</option>
				</select> 
				<input type="text" name="searchName" id="searchName" value='' /> <input
					type="submit" name="Submit" class="btn_grey" value="搜索" />
			</div>
			&nbsp;&nbsp;&nbsp;&nbsp;<a href='<%=path%>/questionAddServlet'>增加试题</a>
		</h3>
		<br />
	</form>
	<div class="c-table c-table--border">
		<table cellspacing="0" cellpadding="0" border="0" role="c-table">
			<colgroup>
              <col width="100" data-sort="up">
              <col name="" width="130" data-sort="true">
              <col name="" width="100" >
              <col name="" width="" >
              <col name="" width="150">
              <col name="" width="100" data-sort="true">
              <col name="" width="190">
            </colgroup>
            <thead>
              <tr>
                <th class="">
                  <div class="cell">题号 </div>
                </th>
                <th class="">
                  <div class="cell">考试科目</div>
                </th>
                <th class="">
                  <div class="cell">题型</div>
                </th>
                <th class="">
                  <div class="cell">题干</div>
                </th>
                <th class="">
                  <div class="cell">选项</div>
                </th>
                <th class="">
                  <div class="cell">答案</div>
                </th>
                <th class="">
                  <div class="cell">操作</div>
                </th>
              </tr>
            </thead>
			<c:forEach var="que" items="${queList}">
			<tr align="center">
				<td width="10">${que.id}</td>
				<td width="20">${que.name}</td>
				<td width="20">单选题</td>
				<td width="40">${que.queTitle}</td>
				<td width="150"><p>A. ${que.choiceA}
						&nbsp;&nbsp;&nbsp;&nbsp; B. ${que.choiceB}</p>
					<p>C. ${que.choiceC} &nbsp;&nbsp;&nbsp;&nbsp; D. ${que.choiceD}</p></td>
				<td width="30" align="center">${que.ans}</td>
				
				<td><button class="layui-btn" onclick="window.location.href='<%=path%>/questionModifyServlet?id=${que.id}'"><i class="layui-icon"></i>修改</button>
				<button class="layui-btn" onclick="window.location.href='<%=path%>/questionDeleteServlet?id=${que.id}';"><i class="layui-icon"></i>删除</button></td>	
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