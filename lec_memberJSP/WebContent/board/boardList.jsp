<%@page import="java.util.List"%>
<%@page import="board.dao.BoardDAO"%>
<%@page import="board.bean.BoardDTO"%>
<%@page import="java.util.ArrayList"%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<jsp:useBean id="boardDAO" class="board.dao.BoardDAO"/>
<%

String id = (String)session.getAttribute("memId");
int pg = Integer.parseInt(request.getParameter("pg"));
int endNum = pg*5;
int startNum = endNum-4;

List<BoardDTO> list = boardDAO.boardList(startNum, endNum);

%>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>글 목록</title>

<style type="text/css">
h2{margin: 0 auto;}
table{margin: 0 auto;}

#subject:link { color:black; text-decoration:none; }
#subject:visited { color:black; text-decoration:none; }
#subject:hover { color:blue; text-decoration:underline; }
#subject:active { color:black; text-decoration:none; }
</style>

</head>

<body>
<h2>글 목록</h2>

<table border="1" cellpadding="5" cellspacing="0">
	<tr>
		<th>글번호</th>
		<th>제목</th>
		<th>작성자</th>
		<th>작성일</th>
		<th>조회수</th>
	</tr>
	<% if(list!=null){ %>
		<% for(BoardDTO data : list){ %>
		<tr>
			<td width="70" align="center"><%=data.getSeq() %></td>
			<td width="300"><a href="boardView.jsp?pg=<%=pg %>&seq=<%=data.getSeq() %>" id="subject"><%=data.getSubject() %></a></td>
			<td width="100" align="center"><%=data.getName() %></td>
			<td width="200" align="center"><%=data.getLogtime() %></td>
			<td width="70" align="right"><%=data.getHit() %></td>
		</tr>
		<% } %>
	<% } %>
	</table>
	<div align="center" style="display:inline-block; border: solid red; width:60px;">
		<jsp:include page="../main/logo.jsp"/>
	</div>
	<div  style="display:inline-block; border: 1px solid blue;">adfadf</div>
	<div align="center">
		<input type="button" value="메인으로" onclick="location.href='../main/index.jsp'">
		<input type="button" value="글 쓰기" onclick="location.href='boardWriteForm.jsp'">
	</div>
</body>


</html>