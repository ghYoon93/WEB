<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<style>
	.td1{
		text-align: center;
		width: 80px;
		height: 30px;
		}
</style>

<div align="center">
<form name="loginForm" method="post" action="../member/login.do">
<table border="1" cellspacing="0" cellpadding="3">
	<tr>
		<td class="td1">아이디</td>
		<td style="width:180px">
			<input type="text" name="id" id="loginId">
            <div id = "loginIdDiv"></div>
		</td>
	</tr>
	<tr>
		<td class="td1">비밀번호</td>
		<td>
			<input type="password" name="pwd" id = "loginPwd">
      <div id = "loginPwdDiv"></div>
		</td>
	</tr>
	<tr>
		<td colspan="2" align="center">
			<input type="button" id="loginFormBtn" value="로그인">
			<input type="button" value="회원가입" onclick="location.href='writeForm.do'">                                 
		</td>
	</tr>
</table>
<div id = loginFail></div>
</form>
</div>
<script type="text/javascript" src="../js/jquery-3.4.1.min.js"></script>
<script type="text/javascript" src="../js/member.js"></script>
