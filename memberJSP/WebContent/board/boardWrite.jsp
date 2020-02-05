<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<jsp:useBean id="boardDTO" class="board.bean.BoardDTO"/>
<jsp:useBean id="boardDAO" class="board.dao.BoardDAO"/>
<jsp:setProperty property="subject" name="boardDTO"/>
<jsp:setProperty property="content" name="boardDTO"/>
<%
String id = (String) session.getAttribute("memId");
String name = (String) session.getAttribute("memName");
String email = (String) session.getAttribute("memEmail");
boardDTO.setId(id);
boardDTO.setName(name);
boardDTO.setEmail(email);
boardDAO.write(boardDTO);

%>
<!DOCTYPE html>
<html>
  <head>
  </head>
  <body>
<div align="center">작성 완료</div><br>
<div align="center"><input type="button" value="확인" onclick="location.href='../main/index.jsp'"/></div>
  </body>
</html>