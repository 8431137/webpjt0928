<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>로그 아웃</title>
</head>
<body>
<%

	request.setCharacterEncoding("UTF-8");
	String id = request.getParameter("id");
	session.invalidate();
%>
	<script>
	alert("로그아웃 하셨습니다.");
	</script>
	
	<a href="/Spring06">로긴창으로</a>
</body>
</html>