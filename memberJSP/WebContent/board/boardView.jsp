<%@ page language="java" contentType="text/html; charset=UTF-8"
  pageEncoding="UTF-8"%>
<%@ page import="board.bean.BoardDTO"%>
<jsp:useBean id="boardDAO" class="board.dao.BoardDAO" />

<%
    int seq = Integer.parseInt(request.getParameter("seq"));
    BoardDTO boardDTO = boardDAO.viewContent(seq);
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
.key {
  text-align: center;
}

textarea {
  overflow-y: scroll;
}
</style>
</head>
<body>
  <table border=1 cellpadding="3" cellspacing="0">
    <tr>
      <td class='key'>제목</td>
      <td class='value'><input type="text" name="subject" value=<%=boardDTO.getSubject() %> 
      size="50" readonly></td>
    </tr>
    <tr>
      <td class='key'>내용</td>
      <td class='value'><textarea name="content" cols="60" rows="10" readonly><%=boardDTO.getContent() %></textarea></td>
    </tr>
    <tr>
      <td colspan="2" align="center">
      <input type="button" value="글 목록" onclick="location.href='boardList.jsp?pg=1'">
    </tr>
  </table>
</body>
</html>