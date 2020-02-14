<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<div align = "center">
${sessionScope.memName }님 로그인<br><br>
<input type="button" value="로그아웃" onclick="location.href='../member/logout.do'">
<input type="button" value="회원정보수정" onclick="location.href='../member/modifyForm.do'">
</div>