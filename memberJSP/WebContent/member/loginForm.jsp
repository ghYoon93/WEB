<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
  <head>
    <meta charset="UTF-8">
    <title>Insert title here</title>
    <style>
      .key{width: 70; text-align: center;}
    </style>
  </head>
  <body>
    <form name="loginForm" method="post" action="http://localhost:8080/memberJSP/member/login.jsp">
      <table border="1" cellpadding="10" cellspacing="0">
        <tr>
          <td class=key>아이디</td>
          <td><input type="text" size=15 name="id"/></td>
        </tr>
        <tr>
          <td class=key>비밀번호</td>
          <td><input type="password" size=20 name="password"/></td>
        </tr>
        <tr>
          <td colspan="2" align="center">
            <input type="button" onclick="login()" value="로그인"/>
            <input type="button" onclick="location.href='http://localhost:8080/memberJSP/member/writeForm.jsp'" value="회원가입"/>
          </td>
        </tr>
      </table>
    </form>
  </body>
  <script type="text/javascript" src="http://localhost:8080/memberJSP/js/member.js"></script>
</html>