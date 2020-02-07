<%@page import="board.bean.BoardDTO"%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	
<jsp:useBean id="boardDAO" class="board.dao.BoardDAO"/>

<%
String id = (String)session.getAttribute("memId");

int pg = Integer.parseInt(request.getParameter("pg"));
int seq = Integer.parseInt(request.getParameter("seq"));

BoardDTO boardDTO = boardDAO.boardOne(seq);

%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h2>boardView</h2>

<%if (id == null) {%> 
<script type="text/javascript">
window.onload= function() {
	alert("로그인 하고 들어와");
	location.href="../board/boardList.jsp?pg=1";
}
</script>
<%}	else {%>
		<table border="1">
			<tr>
				<td width="70" align="center">제목</td>
				<td>
					<input type="text"name="subject" size="50" value="<%=boardDTO.getSubject() %>">
				</td>
			</tr>
		
			<tr>
				<td align="center" width="70">내용</td>
				<td>
					<%=boardDTO.getContent() %>
				</td>
			</tr>
			<tr>
				<td colspan="2" align="center">
				<input type="button" value="글 수정" onclick="modify()"> 
				<input type="button" value="글 목록" onclick="location.href='boardList.jsp?pg=<%=pg %>';">
			</tr>
			
		</table>
		<% } %>

</body>
</html>






