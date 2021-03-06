<%@ page language="java" contentType="text/html; charset=UTF-8"
  pageEncoding="UTF-8"%>
<%@ page import="board.bean.BoardDTO"%>
<jsp:useBean id="boardDAO" class="board.dao.BoardDAO" />

<%  
int seq = Integer.parseInt(request.getParameter("seq"));
int pg = Integer.parseInt(request.getParameter("pg"));
Cookie[] cookies = request.getCookies();
boolean cookieExists = false;
for(int i = 0; i < cookies.length; i++){
	if(cookies[i].getName().equals("cookie")) {
		cookieExists=true;
	}
	
}
if(!cookieExists){
	Cookie cookie = new Cookie("cookie", Integer.toString(seq));
	cookie.setMaxAge(1*60*60*24);
	cookie.setPath("/");
	response.addCookie(cookie);
	boardDAO.updateHit(seq);
}
for(int i = 0; i < cookies.length; i++){
	System.out.println("view "+cookies[i].getName()+": "+cookies[i].getValue());	
}
BoardDTO boardDTO = boardDAO.viewContent(seq);
String writer = boardDTO.getId();
int hit = boardDTO.getHit();
String subject = boardDTO.getSubject();
String content = boardDTO.getContent();
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

.contents{
  white-space: pre-wrap;
  word-break: break-all;
  width: 420px;
}
</style>
</head>
<body>
  <form name="boardViewForm">
  <input type="hidden" name="pg" value=<%=pg%>>
  <table border=1 cellpadding="3" cellspacing="0" frame="hsides" rules="rows">
    <tr>
      <td colspan="4">
        <h3><%=subject%></h3>
        <input type="hidden"  name="subject" value="<%=subject%>">
    </tr>
    <tr>
      <td width="150">글번호: <%=seq%><input type="hidden" name="seq" value="<%=seq%>"></td>
      <td width="150">작성자: <%=writer%></td>
      <td width="150">조회수: <%=hit%></td>
    </tr>
    <tr>
      <td colspan="3">
        <pre class="contents" cols="60"><%=content%></pre>
        <input type="hidden" name="content" value="<%=content%>">
      </td>
    </tr>
  </table>
  <input type="button" value="글 목록" onclick="location.href='boardList.jsp?pg=<%=pg%>'">
  <%if(session.getAttribute("memId").equals(boardDTO.getId())){%>
  <input type ="button" value="글수정" onclick="mode(1)">
  <input type ="button" value="글삭제" onclick="mode(2)">
  </form>
  <%}%>
</body>
<script type="text/javascript">
function mode(num){
	if(num==1) {
		document.boardViewForm.method = 'post';
		document.boardViewForm.action = 'boardModifyForm.jsp';
	}else if(num==2){
		document.boardViewForm.method = 'post';
        //document.boardViewForm.action = 'boardDelete.jsp';
	}
	document.boardViewForm.submit();
}
</script>
</html>