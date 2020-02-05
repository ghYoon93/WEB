<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h3>** include directive **</h3>
<%@ include file="today.jsp" %>
<h3>** include JSP tag **</h3>
<jsp:include page="image.jsp"/>
<br><br>
<%
String name="홍길동";
%>
main.jsp name=<%=name%>
<h3>** 3초 뒤에 페이지 이동**</h3>
<% response.setHeader("Refresh", "3;url=input.jsp"); %>
</body>
</html>
<!-- URI: http://localhost:8080/memberJSP/exam/input.jsp?apple="사과"--> 
<!-- URL: 파일의 위치 http://localhost:8080/memberJSP/exam/input.jsp -->