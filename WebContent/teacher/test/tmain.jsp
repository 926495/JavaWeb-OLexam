<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page import="java.text.SimpleDateFormat"%>
<%@ page import="java.util.Date"%>
<%@ page import="java.util.Locale" %>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<link href="<%=path%>/css/style2.css" rel="stylesheet" type="text/css" />
<link rel="stylesheet" href="<%=path%>/css/jqTable.css">
<link rel="stylesheet" href="<%=path%>/layui/css/layui.css"  media="all">
<title>无标题文档</title>
<script>
	history.go(1);//屏蔽回退
	document.oncontextmenu = function(e) {
		if (e == null)
			e = window.event;
		e.cancelBubble = true;
		e.returnValue = false;
		return true;//右键屏蔽
	};
</script>
<style>
	.p20{
		padding:20px;
	}
</style>
</head>

<body>
<div class="p20">
	<h3 class="subTitle">近期考试</h3>
	<br />
	
	<div class="c-table c-table--border">
		<table cellspacing="0" cellpadding="0" border="0" role="c-table">
			<colgroup>
              <col  width="120" data-sort="up">
              <col name="" width="120" data-sort="true">
              <col name="" width="150" data-sort="true">
              <col name="" width="100" data-sort="true">
              <col name="" width="" >
              <col name="" width="100" data-sort="true">
              <col name="" width="100" data-sort="true">
            </colgroup>
            <thead>
              <tr>
                <th class="">
                  <div class="cell">考试科目 </div>
                </th>
                <th class="">
                  <div class="cell">考试名称 </div>
                </th>
                <th class="">
                  <div class="cell">考试截止时间</div>
                </th>
                <th class="">
                  <div class="cell">考试时长</div>
                </th>
                <th class="">
                  <div class="cell">考试对象</div>
                </th>
                <th class="">
                  <div class="cell">考试分值</div>
                </th>
                <th class="">
                  <div class="cell">考试状态</div>
                </th>
              </tr>
            </thead>
			<c:forEach var="test" items="${testsList }">
				<tr align="center">
					<td>${test.courseName }</td>
					<td><a href = '<%=path%>/testDetailInfoServlet?id=${test.id}' class="layui-btn layui-btn-warm">${test.name }</a></td>
					<td>${test.endDate }</td>
					<td>${test.testTime }</td>
					<td>${test.classNames }</td>
					<td>${test.scores }</td>
					<td >${test.Date}</td>
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