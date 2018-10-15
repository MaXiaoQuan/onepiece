<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>登录</title>
<link rel="stylesheet" type="text/css" href="css/frame.css" />
<script type="text/javascript" src="js/jquery-3.2.1.min.js"></script>
	
</head>
<body>
	Hello!
	<c:if test="${sessionScope.user.userName == null }">
		<a href="login.do">登录</a>
		<a href="signUp.do">注册</a>
	</c:if>
	${sessionScope.user.userName }
</body>
</html>