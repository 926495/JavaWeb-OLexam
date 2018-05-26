<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE html>
<html>
<head>
<title>onlinexam</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="keywords" content="Flaty User login Form template Responsive, Login form web template,Flat Pricing tables,Flat Drop downs  Sign up Web Templates, Flat Web Templates, Login sign up Responsive web template, SmartPhone Compatible web template, free webdesigns for Nokia, Samsung, LG, SonyEricsson, Motorola web design" />
<script type="application/x-javascript"> addEventListener("load", function() { setTimeout(hideURLbar, 0); }, false); function hideURLbar(){ window.scrollTo(0,1); } </script>

<link href="css/style.css" rel="stylesheet" type="text/css" media="all" /> 


<script src="js/jquery-2.2.3.min.js"></script>


</head>
<body style="background: url(img/index.jpg);repeat center 0px;">
	<div class="main-agileits" >
		<h1>Online examination system</h1>
		<div class="mainw3-agileinfo form">
			<div id="login">    
				<form action="<%=path%>/loginServlet" method="post"> 
					<div class="field-wrap">
						<label> Your UserName<span class="req">*</span> </label>
						<input name ="username" type="username" "/>
					</div> 
					<div class="field-wrap">
						<label> Your Password<span class="req">*</span> </label>
						<input type="password" required autocomplete="off" name="password"/>
					</div> 
					<div id="v_container" style="width: 130px;height: 40px;"></div>
					<input type="text" id="code_input" value="" placeholder="请输入验证码"/> 
					<input type="hidden" name="vfCode" id="vfCode" value="null"/>
					<br>
					 <select name="role" id="role">
							<option value="admin" selected="selected" >管理员</option>
							<option value="teacher">教师</option>
							<option value="student">学生</option>
					</select>
					<button class="button button-block" id="my_button"/>Log In</button> 
				</form> 
			</div>
         
		</div>	
			<div class="w3copyright-agile">
		<p>© 2018 SDUT YL-lin</p>
	</div>
	</div>	

	<script>
	$('.form').find('input, textarea').on('keyup blur focus', function (e) { 
	  var $this = $(this),
		  label = $this.prev('label');

		  if (e.type === 'keyup') {
				if ($this.val() === '') {
			  label.removeClass('active highlight');
			} else {
			  label.addClass('active highlight');
			}
		} else if (e.type === 'blur') {
			if( $this.val() === '' ) {
				label.removeClass('active highlight'); 
				} else {
				label.removeClass('highlight');   
				}   
		} else if (e.type === 'focus') {
		  
		  if( $this.val() === '' ) {
				label.removeClass('highlight'); 
				} 
		  else if( $this.val() !== '' ) {
				label.addClass('highlight');
				}
		}
 
	}); 
	</script>
	<script src="js/input.js"></script>
</body>
<script src="js/gVerify-safe.js"></script>
<script>
		var verifyCode = new GVerify("v_container");
		document.getElementById("my_button").onclick = function(){
			var res = verifyCode.validate(document.getElementById("code_input").value);
			if(res){
				var psel = document.getElementById("vfCode");   
		        psel.value = "true"; 
			}else{
				var psel = document.getElementById("vfCode");   
				psel.value = "false"; 
			}
		}
	</script>
</html>