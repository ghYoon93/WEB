<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
	.td1{
		text-align: center;
		width: 80px;
		height: 30px;
		}
</style>
</head>
<body>
<form name="loginForm" method="post" action="/mvcMember/member/login.do">
<table border="1" cellspacing="0" cellpadding="3">
	<tr>
		<td class="td1">아이디</td>
		<td style="width:180px">
			<input type="text" name="id">
		</td>
	</tr>
	<tr>
		<td class="td1">비밀번호</td>
		<td>
			<input type="password" name="pwd">
		</td>
	</tr>
	<tr>
		<td colspan="2" align="center">
			<input type="button" value="로그인" onclick="checkLoginForm()">
			<input type="button" value="회원가입" onclick="location.href='/mvcMember/member/writeForm.do'">                                 
		</td>
	</tr>
</table>
</form>
</body>
<script type="text/javascript" src="../js/member.js"></script>
</html>