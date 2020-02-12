<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<fmt:requestEncoding value="UTF-8"/>
<sql:update dataSource="jdbc/oracle">
  UPDATE usertable SET name = ?, pwd = ? WHERE id = ?
  <sql:param value="${param.name }"/>
  <sql:param value="${param.pwd }"/>
  <sql:param value="${param.id }"/>
</sql:update>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<div align ="center">회원 정보를 수정했습니다.</div>
<div align="center">
<input type = "button" value="회원 목록" onclick="location.href='jstlList.jsp'">
</div>
</body>
</html>