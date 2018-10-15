<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>用户注册界面</title>
<link rel="stylesheet" href="css/frame.css" type="text/css" />
</head>
<body style="position: relative;">
	<div style="width: 40% ; height: 72%; background-color: #BFEFFF; position: absolute; top: 14%; left: 30%; border: 7px solid white; border-radius: 36px;">
		<form action="signUpDone.do" method="post">
		   <label style="margin-top: 60px; margin-left:30px; font-family: Microsoft YaHei; font-size: 16px;">姓&nbsp;&nbsp;名：</label>
		   <input style="margin-top: 30px; height:23px; border-radius: 10px; outline: none; font-family: Microsoft YaHei; font-size: 15px; text-align:center; " name="realName" type="text" size="15" />
		   <br/>
		   <label style="margin-top: 60px; margin-left:30px; font-family: Microsoft YaHei; font-size: 16px;">昵&nbsp;&nbsp;称：</label>
		   <input style="margin-top: 30px; height:23px; border-radius: 10px; outline: none; font-family: Microsoft YaHei; font-size: 15px; text-align:center; " name="userName" type="text" size="15" />
		   <br/>
		   <label style="margin-top: 60px; margin-left:30px; font-family: Microsoft YaHei; font-size: 16px;">年&nbsp;&nbsp;龄：</label>
		   <input style="margin-top: 30px; height:23px; border-radius: 10px; outline: none; font-family: Microsoft YaHei; text-align:center; width: 135px" name="age" type="number" value="20"/>
		   <br/>
		   <label style="margin-top: 60px; margin-left:30px; font-family: Microsoft YaHei; font-size: 16px;">性&nbsp;&nbsp;别：</label>
		   <input style="margin-top: 30px; margin-left:0px; font-family: Microsoft YaHei; font-size: 16px;" name="gender" type="radio" size="25" value="true" checked="checked"/>男&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
		   <input style="margin-top: 30px; margin-left:0px; font-family: Microsoft YaHei; font-size: 16px;" name="gender" type="radio" size="25" value="false"/>女
		   <br/>
		   <label style="margin-top: 60px; margin-left:30px; font-family: Microsoft YaHei; font-size: 16px;">密&nbsp;&nbsp;码：</label>
		   <input style="margin-top: 30px; height:23px; border-radius: 10px; outline: none; font-family: Microsoft YaHei; font-size: 15px; text-align:center; " name="password" type="password" size="15" />
		   <br/>
		   <label style="margin-top: 60px; margin-left:30px; font-family: Microsoft YaHei; font-size: 16px;">电&nbsp;&nbsp;话：</label>
		   <input style="margin-top: 30px; height:23px; border-radius: 10px; outline: none; font-family: Microsoft YaHei; font-size: 15px; text-align:center; " name="phone" type="text" size="15" />
		   <br/>
		   <label style="margin-top: 60px; margin-left:30px; font-family: Microsoft YaHei; font-size: 16px;">生&nbsp;&nbsp;日：</label>
		   <input style="margin-top: 30px; height:23px; width: 136px; border-radius: 10px; outline: none; font-family: Microsoft YaHei; font-size: 15px; text-align:center;" name="birthDate" type="date"/>
		   <br/>
		   <input style="margin-top: 20px; margin-left:230px; font-family: Microsoft YaHei; font-size: 16px;" type="submit" value="保存"/>
		   <input style="font-family: Microsoft YaHei; font-size: 16px;" type="reset" value="清空"/>
		</form>
	</div>
</body>
</html>