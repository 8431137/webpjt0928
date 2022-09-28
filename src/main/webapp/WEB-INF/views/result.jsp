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
String userId = request.getParameter("id");
%>
<%=userId %>님 투표가 완료되었습니다 !
<h3> 호랑이 : ${hoCount} </h3>
<h3> 독수리 : ${docCount} </h3>
<h3> 코끼리 : ${koCount} </h3>
<h3> 투표 남은 인원 : ${nullCount} </h3>
</body>
</html>