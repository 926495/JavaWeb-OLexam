<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
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
	<h3 class="subTitle">
		班级管理
		 
		&nbsp;&nbsp;&nbsp;&nbsp;<a href="<%=path%>/stuClassAddServlet">增加班级</a>
	</h3>
	<br/>
	
	<div class="c-table c-table--border">
		<table cellspacing="0" cellpadding="0" border="0" role="c-table">
			<colgroup>
              <col  width="" data-sort="up">
              <col name="" width="250" data-sort="true">
              <col name="" width="250">
              <col name="" width="250">
            </colgroup>
            <thead >
              <tr  >
                <th class="">
                  <div class="cell">班级名称 </div>
                </th>
                <th class="">
                  <div class="cell">所属属性 </div>
                </th>
                <th class="">
                  <div class="cell">修改操作</div>
                </th>
                <th class="">
                  <div class="cell">删除操作</div>
                </th>
              </tr>
            </thead>
            <!-- 页面元素的遍历可以使用jstl
			1.导入jar包--jstl.jar,standard.jar
			2.在页面导入一行代码
			taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"
			 -->
			<c:forEach var="sc" items="${scList}">
			<tr align="center">
				<td>${sc.name}</td>
				<td>${sc.deptName}</td>
				<td><button class="layui-btn" onclick="window.location.href='<%=path%>/stuClassModifyServlet?id=${sc.id}'"><i class="layui-icon"></i>修改</button></td>
				<td><button class="layui-btn" onclick="window.location.href='<%=path%>/stuClassDeleteServlet?id=${sc.id}'"><i class="layui-icon"></i>删除</button></td>
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
    <script>
layui.use('layer', function(){ //独立版的layer无需执行这一句
  var $ = layui.jquery, layer = layui.layer; //独立版的layer无需执行这一句
  
  //触发事件
  var active = {
   	offset: function(othis){
      var type = othis.data('type')
      ,text = othis.text();
      
      layer.open({
        type: 1
        ,offset: type //具体配置参考：http://www.layui.com/doc/modules/layer.html#offset
        ,id: 'layerDemo'+type //防止重复弹出
        ,content: '<div style="padding: 20px 100px;">'+ text +'</div>'
        ,btn: '确认删除'
        ,btnAlign: 'c' //按钮居中
        ,shade: 0 //不显示遮罩
        ,yes: function(){
          layer.closeAll();
          window.location.href="<%=path%>/stuClassDeleteServlet?id=${sc.id}"
           /* var userName = $("input[name='userName']").val();
              $.get("CheckUserNameServlet?userName="+userName, function(result){
                 if(result == 'Y') {
                     //result就是servlet返回的数据
                     alert("用户名已存在");
                 }
              },"text");//可根据需要选用不同数据类型 */
        }
      });
    }
  };
  
  $('#layerDemo .layui-btn').on('click', function(){
    var othis = $(this), method = othis.data('method');
    active[method] ? active[method].call(this, othis) : '';
  });
  
});
</script>



    
</body>
</html>