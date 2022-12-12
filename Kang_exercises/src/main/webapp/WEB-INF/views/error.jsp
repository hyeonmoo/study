<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR" isErrorPage="true"%> <!-- 예외처리페이지임을 명시 -->
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>error.jsp</title>
</head>
<body>
	<h1>예외가 발생했습니다.</h1>
	발생한 예외 : ${pageContext.exception }<br> <!-- 모델 객체를 전달하지 않고도 사용 가능 -->
	예외 메시지 : ${pageContext.exception.message }<br>
	<ol>
		<c:forEach var="i" items="${pageContext.exception.stackTrace }">
			<li>${i.toString()}</li>
		</c:forEach>
	</ol>
</body>
</html>

