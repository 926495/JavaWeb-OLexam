<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ page import="java.text.SimpleDateFormat" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title></title>
<link href="<%=path %>/css/style2.css" rel="stylesheet" type="text/css" />
<link rel="stylesheet" href="<%=path%>/css/jqTable.css">
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
	<h3 class="subTitle">
		近期考试
	</h3>
	<br />
	<div class="c-table c-table--border">
		<table cellspacing="0" cellpadding="0" border="0" role="c-table">
			<colgroup>
              <col  width="250" data-sort="up">
              <col name="" width="250" data-sort="true">
              <col name="" width="" data-sort="true">
              <col name="" width="250">
            </colgroup>
            <thead>
              <tr>
                <th class="">
                  <div class="cell">考试科目</div>
                </th>
                <th class="">
                  <div class="cell">考试名称 </div>
                </th>
                <th class="">
                  <div class="cell">考试截止时间</div>
                </th>
                <th class="">
                  <div class="cell">进入考试</div>
                </th>
              </tr>
            </thead>
			<c:forEach items="${testsList}" var="test">
			  <tr align="center">
			    <td width="113">${test.courseName }</td>
			    <td width="260">${test.testName }</td>
			    <td width="220">${test.endDate }</td>
			    <td width="81" ><a href='studentTest?testId=${test.id}' target="_parent" class="layui-btn">开始考试</a></td>
			  </tr>
			</c:forEach>
		</table>
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
