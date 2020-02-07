<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<jsp:useBean id="boardDAO" class="board.dao.BoardDAO"/>
<%@ page import="board.bean.BoardDTO" %>
<%@ page import="board.bean.BoardPaging" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList"%>

<%
int pg = Integer.parseInt(request.getParameter("pg"));
int endNum = pg*5;
int startNum = endNum-4;
List<BoardDTO> list = boardDAO.getArticle(startNum, endNum);
int totalA = boardDAO.getTotalArticle();
BoardPaging boardPaging = new BoardPaging();
boardPaging.setCurrentPage(pg);
boardPaging.setPageBlock(3);
boardPaging.setPageSize(5);
boardPaging.setTotalA(totalA);

boardPaging.makePagingHTML();
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
  #currentPaging{color:red; text-decoration:underline;}
  #paging{color:black; text-decoration:none;}
  .logo{width: 50px; height: 50px;}
  .logo img{position: absolute;}
  .content:link{color: black; text-decoration:none;}
  .content:visited{color: black; text-decoration:none;}
  .content:active{color: black; text-decoration:none;}
  .content:hover{color: black; text-decoration:underline;}
</style>
</head>
<body>
<table border = "1" cellspacing = "0" cellborder = "3" frame="hsides" rules="rows">
  <tr>
    <th>글번호</th><th>제목</th><th align="left">작성자</th><th>작성일</th><th>조회수</th>
  </tr>
  <%if(list!=null){ %>
  <%for(BoardDTO boardDTO : list){
      int seq = boardDTO.getSeq();
      String subject = boardDTO.getSubject();
      String id = boardDTO.getId();
      String logtime = boardDTO.getLogtime();
      int hit = boardDTO.getHit();
  %>
      <tr>
      <td width="76px" align="center"><%=seq%></td>
      <td width="594px">
        <a class="content" href="javascript:isLogin(<%=seq%>);"><%=subject%></a>
      </td>
      <td width="118px"><%=id%></td>
      <td><%=logtime%></td>
      <td width="68px" align="center"><%=hit%></td>
      </tr>
  <%}
  }%>
</table> <br>
<div class="logo" style="float:left; border: 1px solid red; ">
  <jsp:include page="../main/logo.jsp"/>
</div>
<div style="display:inline-block; text-align:center; float:left; border: 1px;  width:700px ">
<%=boardPaging.getPagingHTML() %>
</div>
</body>
<script type="text/javascript">
  function isLogin(seq) {
	  var id = '<%=session.getAttribute("memId")%>';
	  if(id == 'null') {
		  alert("로그인을 해주세요.");
	  }else{
		  location.href="boardView.jsp?seq="+seq;
	  }
  }
</script>
</html>
