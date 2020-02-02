<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import = "member.dao.MemberDAO"%>
<%@ page import = "member.bean.MemberDTO"%>
<%
  String id = request.getParameter("id");
  String pwd = request.getParameter("password");
  MemberDAO memberDAO = MemberDAO.getInstance();
  
  boolean isIdExist = memberDAO.findMemberById(id);
  String result = "";
  if(isIdExist){
	  boolean isPwdMatch = memberDAO.passwordEquals(id, pwd);
	  if(isPwdMatch){
		  String name = memberDAO.getName(id);
		  result = name+"님 환영합니다.";
	  }else{
		  result = "아이디 또는 비밀번호가 틀렸습니다.";
	  }
  }else {
	  result = "아이디가 존재하지 않습니다.";
  }
%>
<!DOCTYPE html>
<html>
  <head>
    <meta charset="UTF-8">
    <title>Insert title here</title>
  </head>
  <body>
    <%=result%>
  </body>
</html>