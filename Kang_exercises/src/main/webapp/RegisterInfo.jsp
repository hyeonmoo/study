<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Register Information</title>
<style>
@import url('https://fonts.googleapis.com/css2?family=Noto+Sans+KR:wght@400;900&display=swap');
body{background-color: rgb(70,130,150);}
h1{
	font: 20px 'Noto Sans KR', sans-serif;
	color:white;
}
h1 a{
	color:white;
	text-decoration:none;
	display:block;
	width:100px; height:30px;
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
	<h1>SNS: ${user.sns}</h1>
	<h1><a href="/kang/resources/RegisterForm.html">돌아가기</a></h1>
</body>
</html>