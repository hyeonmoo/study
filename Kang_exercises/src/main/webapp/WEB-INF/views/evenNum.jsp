<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>짝수 판별기</title>
<style>
	*{box-sizing:border-box;}
	form{
		width: 300px; height: 400px;
		margin: 30px auto;
		border:1px solid black;
		border-radius:10px;
		text-align:center;
	}
	h1{
		margin:50px;
	}
	label{
		display:block;
		border:1px solid black;
		border-radius:5px;
		width:150px; height:30px;
		margin:5px auto;
		padding-left:5px;
	}
	input{
		width:115px; height:28px;
		border:0;
		margin-left:5px;
	}
	input:focus{
		outline:none;
	}
	button{
		width:150px;
		margin: 20px;
	}
	.alert{
		width:200px; height:50px;
		margin : 20px auto;
	}
</style>
</head>
<body>
	<form:form modelAttribute="even">
		<h1>짝수 판별기</h1>
		<label for="number_X">
			X:
			<input id="number_X" type="number" name="num_X">
		</label>
		<label for="number_Y">
			Y:
			<input id="number_Y" type="number" name="num_Y">
		</label>
		<button type="submit" id="bt_submit">판별</button>
		<div class="alert">
			<form:errors path="num_X"/><br>
			<form:errors path="num_Y"/>
		</div>
	</form:form>
</body>
</html>