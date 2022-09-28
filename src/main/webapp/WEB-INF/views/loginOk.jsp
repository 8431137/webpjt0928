<%@ page language="java" contentType="text/html; charset=UTF-8"

pageEncoding="UTF-8"%>

<%@ page import="java.util.*, java.text.*"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<head>

<title>메인 페이지</title>

</head>

<body>
<form action ="t2" method="post">
	<input type="radio" name="voteName" value="호랑이" checked>호랑이
	<input type="radio" name="voteName" value="코끼리">코끼리
	<input type="radio" name="voteName" value="독수리">독수리
	<input type="submit" value="결과보기">
</form>
<br>
</body>