<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%request.setCharacterEncoding("UTF-8"); %>
<jsp:useBean id="memberDTO" class="member.bean.MemberDTO"/>
<jsp:useBean id="memberDAO" class="member.dao.MemberDAO"/>
<jsp:setProperty property="*" name="memberDTO"/>
<%
  memberDAO.update(memberDTO);
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<div align="center">수정 완료</div><br>
<div align="center"><input type="button" value="확인" onclick="location.href=../main/index.jsp"/></div>
</body>
</html>