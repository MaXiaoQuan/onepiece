<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>登录</title>
<link rel="stylesheet" type="text/css" href="css/login-jsp.css" >
<link rel="stylesheet" type="text/css" href="css/font-awesome.min.css">
<link rel="stylesheet" type="text/css" href="css/animate.css">
<link rel="stylesheet" type="text/css" href="css/frame.css">
<style type="text/css">
	#login, button:hover {
		cursor: pointer;
	}
</style>
<script type="text/javascript" src="js/jquery-3.2.1.min.js"></script>
<script type="text/javascript" src="js/jquery.cookie.js"></script>
<script type="text/javascript">
	$(function(){
		var usernameOrPhone = $.cookie('usernameOrPhone');
		$("#usernameOrPhone").val(usernameOrPhone);
	})
	
	function login(){
		var usernameOrPhone = $("#usernameOrPhone").val();
		if(usernameOrPhone == ""){
			$(".fa-user-o").addClass("infinite");
			$("#usernameOrPhoneDiv").css("border", "1px solid red");
			return null
		}
		var password = $("#password").val();
		if(password == ""){
			$(".fa-lock").addClass("infinite");
			$("#passwordDiv").css("border", "1px solid red");
			return null
		}
		$.post('userValidation.do', {
			usernameOrPhone : usernameOrPhone,
			password : password
		}, function(data, status) {
			if(data.errcode == -1){
				$("#noUserPrompt").css("display", "inline");
				$("#waiting").css("display", "none");
			}else if(data.errcode == -2){
				$("#wrongPasswordPrompt").css("display", "inline");
				$("#waiting").css("display", "none");
			}else{
				window.location.href = "index.do";
			}
		});
	}
	
	function loginByEnter(event){
		if(event.keyCode == "13"){
			login();
		}
	}
	
	function removePrompt(){
		$("#noUserPrompt").css("display", "none");
		$("#wrongPasswordPrompt").css("display", "none");
		$("#usernameOrPhoneDiv").css("border", "1px solid white");
		$("#passwordDiv").css("border", "1px solid white");
		$(".fa-user-o").removeClass("infinite");
		$(".fa-lock").removeClass("infinite");
	}
</script>
</head>
<body style="position: absolute;" onkeyup="loginByEnter(event)">
	<div style="background-color: inherit; float: right; margin-right: 20px; margin-top: 16px">
		 <a id="12" href="signUp.do">立即注册</a>
		 <a style="margin-left: 16px;" href="findPassword.do">找回密码</a>
	</div>
	<div style="width: 23.4%; background-color: inherit; position: absolute; top: 30%;
		 border-radius: 16px; margin-left: 38.6%; text-align: center;">
		<h3 class="animated flip" style="margin: 0px; color: white; font-weight: normal;">Login in to embrace the world!</h3>
	</div>
	<div style="width: 280px; height: 36px; background-color: inherit; position: absolute; top: 36%; border: 1px solid white;
		 border-radius: 16px; margin-left: 40%;" id="usernameOrPhoneDiv">
		<i class="fa fa-user-o animated flash" aria-hidden="true"></i>
		<input id="usernameOrPhone" type="text" placeholder="Username/Phone" onmousedown="removePrompt()">
		<label id="noUserPrompt"><i class="fa fa-user-times animated jackInTheBox" aria-hidden="true"></i></label>
	</div>
	<div style="width: 280px; height: 36px; background-color: inherit; position: absolute; top: 44%; border: 1px solid white;
		 border-radius: 16px; margin-left: 40%;" id="passwordDiv">
		<i class="fa fa-lock fa-lg animated flash" aria-hidden="true"></i>
		<input id="password" type="password" placeholder="Password" onmousedown="removePrompt()" value="${sessionScope.user.password }">
		<label id="wrongPasswordPrompt"><i class="fa fa-times-circle animated rollIn" aria-hidden="true"></i></label>
	</div>
	<div style="width: 200px; height: 36px; background-color: #008080; position: absolute; top: 52%; border: 1px solid white; 
		 border-radius: 16px; margin-left: 42.8%;" onclick="login()" id="login">
		 <button style="font-size: 20px; color: white; background-color: inherit; border: none; position: relative; top: 11.11%; left: 33%; outline: none;">
		 	登&nbsp;&nbsp;&nbsp;录</button>
	</div>
</body>
</html>