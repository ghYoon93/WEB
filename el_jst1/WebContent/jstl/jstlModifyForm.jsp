<%@ page language="java" contentType="text/html; charset=UTF-8"
  pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql" %>
<c:set var="userId" value="${param.id }"/> 
<sql:query var="rs" dataSource="jdbc/oracle">
  SELECT * FROM usertable WHERE id=?
  <sql:param value="${userId }"/>
</sql:query>

<c:set var="userName" value="${rs.rows[0].name }"/>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원 정보 수정</title>
<style>
.key {
  width: 70;
  text-align: center;
}
</style>
</head>
<body>
  <form name="jstlModifyForm" method="post" action="jstlModify.jsp">
    <table border="1" cellspacing="0" cellpadding="3">
      <tr>
        <td class=key>이름</td>
        <td><input type="text" name="name" value="${userName }" size="10"></td>
      </tr>
      <tr>
        <td class=key>아이디</td>
        <td><input type="text" name="id" value="${userId }" readonly size="25"> 
        </td>
      </tr>
      <tr>
        <td class=key>비밀번호</td>
        <td><input type="password" name="pwd"></td>
      </tr>
      <tr>
          <td class="key" colspan="2">
            <input type="submit" value="회원 정보 수정">
            <input type="reset" value="다시 작성">
            <input type="button" value="목록" onclick="location.href='jstlList.jsp'">
          </td>
        </tr>
    </table>
  </form>
</body>
</html>