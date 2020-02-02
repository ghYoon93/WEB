<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="member.dao.MemberDAO"%>    
<%@ page import="member.bean.MemberDTO"%>    
<%
    request.setCharacterEncoding("UTF-8");
    MemberDTO memberDTO = new MemberDTO();
    memberDTO.setName(request.getParameter("name"));
    memberDTO.setId(request.getParameter("id"));
    memberDTO.setPwd(request.getParameter("password"));
    memberDTO.setGender(request.getParameter("gender"));
    memberDTO.setEmail1(request.getParameter("email1"));
    memberDTO.setEmail2(request.getParameter("email2"));
    memberDTO.setTel1(request.getParameter("tel1"));
    memberDTO.setTel2(request.getParameter("tel2"));
    memberDTO.setTel3(request.getParameter("tel3"));
    memberDTO.setZipcode(request.getParameter("zipcode"));
    memberDTO.setAddr1(request.getParameter("addr1"));
    memberDTO.setAddr2(request.getParameter("addr2"));
    
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
    <div align="center"><input type="button" value="확안" onclick="window.close()"/></div>
  </body>
</html>