<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql" %>
<sql:update dataSource="jdbc/oracle">
  DELETE FROM userTable WHERE id = ?
  <sql:param value="${param.id }"/>
</sql:update>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<div align ="center">회원 정보를 삭제했습니다.</div>
<div align="center">
<input type = "button" value="회원 목록" onclick="location.href='jstlList.jsp'">
</div>
</body>
</html>