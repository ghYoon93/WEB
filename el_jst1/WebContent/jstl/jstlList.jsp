<%@ page language="java" contentType="text/html; charset=UTF-8"
  pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql"%>
<sql:query var="rs" dataSource="jdbc/oracle">
    SELECT * FROM usertable
</sql:query>
<html>
  <head>
    <meta charset="UTF-8">
    <title>회원 목록</title>
  </head>
  <body>
    <table border="1">
      <tr>
      <!-- 필드명 -->
      <c:forEach var="colName" items="${rs.columnNames }">
        <td width="100" align="center">${colName }</td>
      </c:forEach>
        <td width="150" align="center">비고</td>
      </tr>
      <!-- 필드 -->
      <c:forEach var="row" items="${rs.rowsByIndex }"> <!-- 행 -->
      <tr>
      <c:forEach var="col" items="${row }">
          <td align="center" name="${col }">${col }</td>
      </c:forEach>
      <td width="150" align="center">
        <input type="button" value="수정" onclick="location.href='jstlModifyForm.jsp?id=${row[1] }'">
        <input type="button" value="삭제" onclick="location.href='jstlDelete.jsp?id=${row[1]}'"> 
      </td>
      </tr>
      </c:forEach>
    </table>
  </body>
  </html>