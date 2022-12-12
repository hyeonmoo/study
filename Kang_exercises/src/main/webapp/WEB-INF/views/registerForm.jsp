<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="java.net.URLDecoder" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>CreateAccount</title>
    <link rel="stylesheet" href="/kang/resources/css/RegisterForm.css">
</head>
<body>
<!--<form action="<c:url value="/register/save"/>" method="post" onsubmit="return formCheck(this)"> -->
	<form:form modelAttribute="user">
		<h1>Register</h1>
		<!--<div id="alert" class="article">${URLDecoder.decode(param.msg,"utf-8")}</div>-->
		<div id="alert" class="article"><form:errors path="id"/></div>
		<div class="article">
			<label for="user_id">아이디</label>
			<input type="text" id="user_id" name="id" placeholder="8~12자의 영문,숫자 조합" autofocus>
		</div>
		<div class="article">
			<label for="user_pw">비밀번호</label>
			<input type="password" id="user_pw" name="pw" placeholder="8~15자의 영문,숫자 조합" >
		</div>
		<div class="article">
			<label for="user_name">이름</label>
			<input type="text" id="user_name" name="name" placeholder="ex)홍길동">
		</div>
		<div class="article">
			<label for="user_email">이메일</label>
			<input type="email" id="user_email" name="email" placeholder="ex)emailID@domain.com">
		</div>
		<div class="article">
			<label for="user_birth">생년월일</label>
			<input type="text" id="user_birth" name="birth" placeholder="1994/08/25">
		</div>
		<div class="article">
			<label for="user_hobby">취미</label>
			<input type="text" id="user_hobby" name="hobby" placeholder=" 피아노#베이킹">
		</div>
		<div class="article" id="checkbox">
			<label><input type="checkbox" name="sns" value="facebook"/>페이스북</label>
			<label><input type="checkbox" name="sns" value="kakaotalk"/>카카오톡</label>
			<label><input type="checkbox" name="sns" value="instagram"/>인스타그램</label>
		</div>
	    <div id="article">
	        <button id="submit" type="submit">회원가입</button>
	    </div>
	</form:form>
	<script src="https://kit.fontawesome.com/5b08a44acf.js" crossorigin="anonymous"></script>
<!-- 	<script type="text/javascript">
		function formCheck(form){
			var msg='';
			if(form.id.value.length<5){
				setMessage("id의 길이는 5~12자 이내여야 합니다.", form.id);
				return false;
			}
			if(form.pw.value.length<5 || form.pw.value.length>15){
				setMessage("비밀번호는 5~15자 이내여야 합니다.");
				return false;
			}
			return true;
		}
		function setMessage(msg,element){
			document.getElementById("alert").innerHTML=`<i class="fa-solid fa-triangle-exclamation">${'${msg}'}</i>`;
			if(element){
				element.select();
			}
		}
	</script> -->
</body>
</html>