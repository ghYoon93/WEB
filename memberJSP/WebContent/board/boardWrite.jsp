<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import ="java.util.HashMap"%>
<%@ page import ="java.util.Map"%>
<jsp:useBean id="boardDAO" class="board.dao.BoardDAO"/>
<%
String id = (String) session.getAttribute("memId");
String name = (String) session.getAttribute("memName");
String email = (String) session.getAttribute("memEmail");
String subject = request.getParameter("subject");
String content = request.getParameter("content");
Map<String, String> map = new HashMap<String, String>();
map.put("id", id);
map.put("name", name);
map.put("email", email);
map.put("subject", subject);
map.put("content", content);
boardDAO.boardWrite(map);

%>
<!DOCTYPE html>
<html>
  <head>
  </head>
  <body>
<div align="center">작성 완료</div><br>
<div align="center"><input type="button" value="확인" onclick="location.href='boardList.jsp?pg=1'"/></div>
  </body>
</html>