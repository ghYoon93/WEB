<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="member.dao.MemberDAO"%>    
<%@ page import="member.bean.MemberDTO"%>
<jsp:useBean id="memberDTO" class="member.bean.MemberDTO"/>
<%request.setCharacterEncoding("UTF-8");%>
<jsp:setProperty property="*" name="memberDTO"/>       
<%
  MemberDAO memberDAO = MemberDAO.getInstance();
  memberDAO.write(memberDTO);
%>
<!DOCTYPE html>
<html>
  <head>
    <meta charset="UTF-8">
</head>
  <body>
    <div align="center">회원 가입 완료</div>
    <br><br>
    <div align="center"><input type="button" value="확인" onclick="window.close()"/></div>
  </body>
</html>