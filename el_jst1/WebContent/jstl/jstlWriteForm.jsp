<%@ page language="java" contentType="text/html; charset=UTF-8"
  pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원 가입</title>
<style>
.key {
  width: 70;
  text-align: center;
}
</style>
</head>
<body>
  <form name="jstlWriteForm" method="post" action="jstlWrite.jsp">
    <table border="1" cellspacing="0" cellpadding="3">
      <tr>
        <td class=key>이름</td>
        <td><input type="text" name="name" placeholder="이름 입력"
          size="10"></td>
      </tr>
      <tr>
        <td class=key>아이디</td>
        <td><input type="text" name="id" placeholder="아이디 입력"
          size="25"> 
        </td>
      </tr>
      <tr>
        <td class=key>비밀번호</td>
        <td><input type="password" name="pwd"></td>
      </tr>
      <tr>
          <td class="key" colspan="2">
            <input type="submit" value="회원 가입">
            <input type="reset" value="다시 작성">
            <input type="button" value="목록" onclick="location.href='jstlList.jsp'">
          </td>
        </tr>
    </table>
  </form>
</body>
</html>