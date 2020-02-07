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
  <table border=1 cellpadding="3" cellspacing="0" frame="hsides" rules="rows">
    <tr>
      <td colspan="4">
        <h3><%=boardDTO.getSubject()%></h3>
    </tr>
    <tr>
      <td width="150">글번호: <%=boardDTO.getSubject()%></td>
      <td width="150">작성자: <%=boardDTO.getId()%></td>
      <td width="150">조회수: <%=boardDTO.getHit()%></td>
    </tr>
    <tr>
      <%-- <td class='key'>내용</td>
      <td class='value' colspan="2"><textarea name="content" cols="60" rows="10" readonly><%=boardDTO.getContent() %></textarea></td> --%>
      <td colspan="3" height="200"><pre><%=boardDTO.getContent() %></pre></td>
    </tr>
    <tr>
      <td colspan="3" align="center">
      <input type="button" value="글 목록" onclick="history.back()">
    </tr>
  </table>
  <%if(session.getAttribute("memId").equals(boardDTO.getId())){%>
  <input type ="button" value="글수정">
  <input type ="button" value="글삭제">
  <%}%>
</body>
</html>