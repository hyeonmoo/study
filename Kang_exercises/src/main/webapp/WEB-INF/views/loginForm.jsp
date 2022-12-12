<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="java.net.URLDecoder" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Login</title>
<style>
	@import url('https://fonts.googleapis.com/css2?family=Do+Hyeon&family=Noto+Sans+KR&display=swap');
	*{
	    font-family: Noto sans KR;
	    margin:0; padding:0;
	    box-sizing: border-box;
	}
	form{
	    width:360px; height: 480px;
	    border: 3px solid rgb(70, 130, 150);
	    border-radius: 10px;
	    margin:30px auto;
	}
	.article, h1, .article>button{
	    width: 300px;
	    height: 40px;
	    margin:20px auto;
	    color: rgb(70,130,150);
	}
	h1{
	    margin:90px auto 50px auto;
	    font: 800 50px Do Hyeon;
	}
	#msg{
		text-align: center;
		width:300px; height:20px;
		font-size:0.8em;
		color:rgb(200,70,70);
	}
	.article input:not([type=checkbox]){
	    width:100%; height:100%;
	    padding:5px;
	    border:2px solid rgb(70, 130, 150);
	    border-radius: 5px;
	    color:rgb(70, 130, 150);
	}
	.article button{
	    margin:0 auto;
	    background-color: rgb(70, 130, 150);
	    border:0;
	    border-radius: 5px;
	    color:white;
	    font: 500 20px Do Hyeon;
	    cursor: pointer;
	}
	.article{text-align: center;}
	.article>a{
	    text-decoration: none;
	    margin:0 5px;
	    color: rgb(70,130,150);
	}
	.article>a:hover{text-decoration: underline;}
</style>
</head>
<body>
    <form action="<c:url value='/login/login'/>" method="post" onsubmit="return formCheck(this);">
        <h1>Login</h1>
        <div id="msg">
        	<c:if test="${not empty param.msg }">
        	<i class="fa fa-exclamation-circle"> ${URLDecoder.decode(param.msg) }</i>
        	</c:if>
        </div>
        <div class="article">
            <input type="email" id="email" name="email" class="textbox" placeholder="이메일 입력" required value="${cookie.email.value}">
        </div>
        <div class="article">
            <input type="password" id="pw" name="pw" class="textbox" placeholder="비밀번호" required>
            <input type="hidden" name="toURL" value="${param.toURL}">
        </div>
        <div class="article">
            <button type="submit">로그인</button>
        </div>
        <div class="article">
            <label><input type="checkbox" name="remId" ${empty cookie.email.value? "":"checked" }>아이디 기억</label>
            <a href="#">비밀번호 찾기</a>
            <a href="#">회원가입</a>
        </div>
        <script>
		   	function formCheck(frm){
		   		let msg='';
		   		
		   		if(frm.email.value.length==0){
		   			setMessage('이메일을 입력해주세요.',frm.email);
		   			return false;
		   		}
		   		if(frm.pw.value.length==0){
		   			setMessage('비밀번호를 입력해주세요.',frm.pw);
		   			return false;
		   		}
		   		return true;
		   	}
		   	function setMessage(msg, element){
		   		document.getElementById("msg").innerHTML=` ${'${msg}'}`;
		   		
		   		if(element) element.select();
		   	}
    	</script>
    </form>
</body>
</html>