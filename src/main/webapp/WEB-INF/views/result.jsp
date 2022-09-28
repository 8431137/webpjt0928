<%@page import="org.apache.ibatis.reflection.SystemMetaObject"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
String userId = (String)session.getAttribute("userId");
String winner = (String)request.getAttribute("win");

%>
<%=userId %>님 투표가 완료되었습니다 !<br/>
<p>
<form method="get">
	<fieldset>
	<legend>투표결과</legend>
		<h3> 호랑이 : ${hoCount} </h3>
		<h3> 독수리 : ${docCount} </h3>
		<h3> 코끼리 : ${koCount} </h3>
	</fieldset>
	<h3> 남은 투표 수 : ${nullCount} </h3>
</form>

<%
if(winner.length() >= 2){
	out.println("<h1>당선동물 : "+ winner + "</h1>");
}
%>
<a href = "t3">로그아웃</a>
</body>
</html>