<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>
<%@ page import="java.util.*, java.text.*"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<head>
<title>메인 페이지</title>
</head>
<body>
<form method="post" action="t1" >
	<fieldset id="regbox">
		<legend>로그인</legend>
		<label for="id">아이디</label>
		<input type="text" name="id"/><br/>
		<label for="pwd">비밀번호</label>
		<input type="text" name="pwd"/><br/>
		<input type="submit" value="로그인">
	</fieldset>
</form>
<br>
</body>

