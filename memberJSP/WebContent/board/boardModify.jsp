<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.Map" %>
<%@ page import="java.util.HashMap" %>
<jsp:useBean id="boardDAO" class="board.dao.BoardDAO"/>
<%
request.setCharacterEncoding("UTF-8");
String seq = request.getParameter("seq");
String subject = request.getParameter("subject");
String content = request.getParameter("content");
Map<String, String> map = new HashMap<String, String>();
map.put("seq", seq);
map.put("subject", subject);
map.put("content", content);
boardDAO.modifyBoard(map);
%>    
<!DOCTYPE html>
<html>
  <head>
  </head>
  <body>
<div align="center">수정 완료</div><br>
<div align="center"><input type="button" value="글 목록" onclick="location.href='boardList.jsp?pg=1'"/></div>
  </body>
</html>