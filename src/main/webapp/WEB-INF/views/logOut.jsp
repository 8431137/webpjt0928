<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>�α� �ƿ�</title>
</head>
<body>
<%

	request.setCharacterEncoding("UTF-8");
	String id = request.getParameter("id");
	session.invalidate();
%>
	<script>
	alert("�α׾ƿ� �ϼ̽��ϴ�.");
	</script>
	
	<a href="/Spring06">�α�â����</a>
</body>
</html>