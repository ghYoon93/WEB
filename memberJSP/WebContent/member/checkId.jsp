<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="member.dao.MemberDAO"%>
<%
  request.setCharacterEncoding("UTF-8");
  String id = request.getParameter("id");
  MemberDAO memberDAO = MemberDAO.getInstance();
  String result = id+"는(은) 사용 가능";
  boolean isIdExist = memberDAO.findMemberById(id);
  if(isIdExist){
	  result = id+"는(은) 사용 불가능";
  }
%>
<!DOCTYPE html>
<html>
  <head>
    <meta charset="UTF-8">
    <title>아이디 중복 확인</title>
  </head>
  <body>
    <div align="center">
      <%=result%>
    </div>
    <br>
    <form method='get' action='http://localhost:8080/memberJSP/member/checkId.jsp'>
      <%
        if(isIdExist){
      %>
            아이디
      <input type='text' name='id' placeholder='아이디입력'/>
      <br>
      <div align="center">
      <input type='submit' value='중복체크'/>
      </div>
      <%
        }else {
      %>
      <div align="center">
        <input type='button' value='사용' onclick="checkIdClose('<%=id%>')"/>
      </div>
      <% 	
        }
      %>
    </form>
  </body>
  <script type='text/javascript' src="http://localhost:8080/memberJSP/js/member.js"></script>
</html>