<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>首页</title>
<link rel="stylesheet" href="css/frame.css" type="text/css" />
<script type="text/javascript" src="js/jquery-3.2.1.min.js"></script>
</head>
<body>
	<img alt="海贼王横幅" src="images/onePieceBanner.jpg">
	<div style="float: right; margin-right: 20px; margin-top:16px">
		 <a href="saveFigure.do">保存人物</a>
		 <a style="margin-left: 16px;" href="index.do">&nbsp;首&nbsp;&nbsp;&nbsp;页&nbsp;</a>
	</div>
	<!-- 利用a标签实现跳转时，请求的后缀名不能是.jsp -->
	<div>
		<a style="text-align: center; font-size: 23px" id="getFigures" onclick="getFigures()">主人公介绍</a>
		<div style="width: 650px">
			<div id="Figures" style="border: 1px dotted #7B68EE; padding: 3px, 3px; font-size: 23px; width: 650px;">
				<div style="padding: 6px; display: inline-block"><a href="getFigureDetail.do?name=Luffy">路飞</a></div>
				<div style="padding: 6px; display: inline-block"><a href="getFigureDetail.do?name=Zoro">索隆</a></div>
				<div style="padding: 6px; display: inline-block"><a href="getFigureDetail.do?name=Usopp">乌索普</a></div>
				<div style="padding: 6px; display: inline-block"><a href="getFigureDetail.do?name=Sanji">山治</a></div>
				<div style="padding: 6px; display: inline-block"><a href="getFigureDetail.do?name=Nami">娜美</a></div>
				<div style="padding: 6px; display: inline-block"><a href="getFigureDetail.do?name=Chopper">乔巴</a></div>
				<div style="padding: 6px; display: inline-block"><a href="getFigureDetail.do?name=Robin">罗宾</a></div>
				<div style="padding: 6px; display: inline-block"><a href="getFigureDetail.do?name=Franky">弗兰奇</a></div>
				<div style="padding: 6px; display: inline-block"><a href="getFigureDetail.do?name=Brook">布鲁克</a></div>
			</div>
		</div>
	</div>
	<a href="saveFigure.do">保存人物信息</a>
</body>
</html>