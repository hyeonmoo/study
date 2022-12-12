<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="java.net.URLDecoder" %>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>철좀들어</title>
    <link rel="stylesheet" href="/kang/resources/css/index.css">
</head>
<body>
    <div id="container">
        <div class="colume" id="logo"></div>
        <div class="colume" id="login_menu">
            <div id="loginInfo" class="article">
                <a href="<c:url value='/login/logout'/>">로그아웃</a>
            </div>
            <div id="menu1" class="article menu"><a href="<c:url value='board/list'/>">상품구매</a></div>
            <div id="menu2" class="article menu"><a href="<c:url value='#'/>">PT예약</a></div>
        </div>
        <div class="colume" id="article_colume1">
            <div id="recommend" class="article">게시판 화면</div>
            <div id="machine_info" class="article"></div>
        </div>
        <div class="colume" id="article_colume2">
            <div id="rank" class="article"></div>
            <div id="matching" class="article"></div>
            <div id="club_info" class="article">
                <a href="#" ><p>
                    충북 청주시 서원구 사직대로 109<br> 
                    043.000.0000
                </p></a>
            </div>
        </div>
    </div>
</body>
</html>