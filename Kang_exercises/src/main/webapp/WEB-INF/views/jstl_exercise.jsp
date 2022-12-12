<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>JSTL 예제</title>
</head>
<body>
	<c:set var="to" value="10"/>									<!-- 변수 선언 -->
	<c:set var="array" value="10,20,30,40,50,60,70"/>				<!-- 배열 선언 -->
	<c:forEach var="i" begin="1" end="${to }">						<!-- 반복문 선언 -->
		<b>${i }</b>
	</c:forEach><br>
	
	<c:if test="${not empty arr }">									<!-- 조건문 선언 -->
		<c:forEach var="i" items="${array }" varStatus="status">	<!-- 배열반복문 선언 -->
			<b>${status.count }. array[${status.index }]=${i }</b><br>
			<!-- count:1부터 index:0부터 -->
		</c:forEach>
	</c:if>
</body>
</html>