<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">

<html xmlns="http://www.w3.org/1999/xhtml">

<head>

<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />

<title>Welcome</title>

		<style media="screen" type="text/css">

			img { display: none; }

			body { overflow: hidden; }

			#canvas { position: absolute; top: 0px; left: 0px; }

		</style>

		<script src="<%=path%>/js/rainyday.js" type="text/javascript"></script>

		<script type="text/javascript">

 			function demo() {

				var engine = new RainyDay('canvas','demo2', window.innerWidth, window.innerHeight);

 					engine.gravity = engine.GRAVITY_NON_LINEAR;

 					engine.trail = engine.TRAIL_DROPS;

 					engine.VARIABLE_GRAVITY_ANGLE = Math.PI / 8;

					engine.rain([

						engine.preset(0, 2, 0.5),

						engine.preset(4, 4, 1)

					], 50);

 			}

		</script>

</head>



<body onLoad="demo();">

		<img id="demo2" src="<%=path%>/img/back.jpg" />

		<div id="cholder">

			<canvas id="canvas"></canvas>

		</div>

	</body>

</html>

