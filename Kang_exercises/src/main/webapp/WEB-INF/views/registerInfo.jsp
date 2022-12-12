<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Register Information</title>
<style>
body{background-color: rgb(70,130,150);}
h1{
	color:white;
}
h1 a{
	color:white;
	text-decoration:none;
	display:block;
	width:200px; height:30px;
	border:2px solid white;
	border-radius:5px;
	text-align:center;
	padding:5px;
	line-height:30px;
}
h1 a:hover{
	background-color:white;
	color:rgb(70,130,150);
}
</style>
</head>
<body>
	<h1>아이디: ${user.id }</h1>
	<h1>비밀번호: ${user.pw }</h1>
	<h1>이름: ${user.name }</h1>
	<h1>이메일: ${user.email }</h1>
	<h1>생년월일: ${user.birth }</h1>
	<c:forEach var="i" items="${user.sns }">
		<h1>SNS: ${i}</h1>
	</c:forEach>
	<h1>취미: <c:forEach var="hob" items="${user.hobby }">
		${hob} 
	</c:forEach></h1>
	<h1><a href="<c:url value="/register/add"/>">돌아가기</a></h1>
</body>
</html>