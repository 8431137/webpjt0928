<%@page import="Pack01.Person"%>
<%@page import="java.util.LinkedList"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
<h1>test02.jsp 입니다.</h1>
<%
	String name=(String)request.getAttribute("name");
	String age=(String)request.getAttribute("age");
	Integer temp=(Integer)request.getAttribute("int");
	String tempString=(String)request.getAttribute("tempString");
	String[] tempArrayString=(String[])request.getAttribute("tempArrayString");
	for(String value:tempArrayString){
		out.println(value);
	}
	@SuppressWarnings("unchecked")
	ArrayList<Integer>tempArrayList=(ArrayList<Integer>)request.getAttribute("tempArrayListInt");
	out.println(tempArrayList);
	@SuppressWarnings("unchecked")
	LinkedList<Integer>linkedListIntegers=(LinkedList<Integer>)request.getAttribute("linkedListIntegers");
	out.println(linkedListIntegers);
	Person person=(Person)request.getAttribute("person");
	@SuppressWarnings("unchecked")
	LinkedList<Person>person2=(LinkedList<Person>)request.getAttribute("person2");
	out.println(person2.get(0).getName()+" "+person2.get(0).getAge());
	
%>
<h1><%=name %></h1>
<h1><%=age %></h1>
<h1><%=temp %></h1>
<h1><%=tempString %></h1>
<h1><%=person.getAge() %><%=person.getName() %></h1>








<c:forEach var="a" items="${person2}" varStatus="b">
<c:out value="${a.name }"/>
<c:out value="${a.age }"/><p/>
</c:forEach>

<c:forEach var="t" items="${person2}" varStatus="c">
<c:out value="${t.getName() }"/>
<c:out value="${t.getAge() }"/><p/>
</c:forEach>

<c:forEach var="a" items="${person2}" varStatus="b">
${b.index}:${a.getName()} ${a.getAge()}
</c:forEach>
<c:forEach var="k" items="${person2}" varStatus="temp">
${temp.index}:${k.getName()} ${k.getAge()}
</c:forEach>












</body>
</html>