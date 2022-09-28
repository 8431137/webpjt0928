<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>
<%@ page import="java.util.*, java.text.*"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<head>
<title>메인 페이지</title>
</head>
<body>
<form action ="t2" method="get">
	<input type="radio" name="vote" value="호랑이">호랑이
	<input type="radio" name="vote" value="코끼리">코끼리
	<input type="radio" name="vote" value="독수리">독수리
	<input type="submit" value="결과보기">
</form>
<form action ="tt3" method="get">
<a href="logout.jsp">로그아웃</a>
</form>
<br>
</body>