<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>保存人物信息界面</title>
<link rel="stylesheet" href="css/frame.css" type="text/css" />
<script type="text/javascript" src="js/jquery-3.2.1.min.js"></script>
<script type="text/javascript">
	function showWeaponText(){
		$("#weaponText").css("display", "inline");
	}
	function hideWeaponText(){
		$("#weaponText").css("display", "none");
	}
	
	function backToIndex(){
		window.location.href = "index.do";
	}
</script>
</head>
<body>
	<div style="float: right; margin-right: 20px; margin-top:16px">
		 <a href="saveFigure.do">&nbsp;返&nbsp;&nbsp;&nbsp;回&nbsp;</a>
		 <a style="margin-left: 16px;" href="index.do">&nbsp;首&nbsp;&nbsp;&nbsp;页&nbsp;</a>
	</div>
	<div style="width: 475px;">
		<h2 style="display: inline-block;">保存人物信息</h2>
		<button style="padding-right: 10px;" onclick="backToIndex()">首页</button>
	</div>
	<div>
		<form style="font-size: 20px; font-family: fantasy;" action="saveFigureDone.do">
			姓名：<input type="text" name="name" placeholder="请输入姓名" required="required" autocomplete="on">&nbsp;&nbsp;
			年龄：<input type="number" name="age" max="100" min="1" value="20"><br>
			性格：<input type="text" name="characteristic" placeholder="请输入性格" required="required" autocomplete="on">&nbsp;&nbsp;
			爱好：<input type="text" name="hobby" placeholder="请输入爱好" required="required" autocomplete="on"><p>
			是否使用武器：<input type="radio" name="useWeapon" value="true" onclick="showWeaponText()">是
					   	  <input type="radio" name="useWeapon" checked value="false" onclick="hideWeaponText()">否&nbsp;&nbsp;
					   	  <input id="weaponText" type="text" name="weapon" placeholder="请输入武器" style="display: none; height: 13px"><br/></p>
			<textarea style="width: 360px; resize: none;" name="description" placeholder="请输入人物简介" rows="6" required="required"></textarea><br>
			<input style="height: 36px; width: 50px;" type="submit" value="保存">
			<input style="height: 36px; width: 50px;" type="reset" value="清空" onclick="hideWeaponText()">
		</form>
	</div>
</body>
</html>