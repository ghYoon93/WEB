<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<style>
  #currentPaging{color:red; text-decoration:underline;}
  #paging{color:black; text-decoration:none;}
  .content:link{color: black; text-decoration:none;}
  .content:visited{color: black; text-decoration:none;}
  .content:active{color: black; text-decoration:none;}
  .content:hover{color: black; text-decoration:underline;}
</style>
<h2>글 목록</h2>

<table border="1" cellpadding="5" cellspacing="0">
	<tr>
		<th>글번호</th>
		<th>제목</th>
		<th>작성자</th>
		<th>작성일</th>
		<th>조회수</th>
	</tr>
   <c:if test="${list!=null }">
    <c:forEach var="boardDTO" items="${list }">
		<tr>
			<td width="76px" align="center">${boardDTO.seq }</td>
			<td width="594px">
                <c:forEach var="i" begin="1" end="${boardDTO.lev }">
                  &emsp;
                </c:forEach>
                <c:if test="${boardDTO.pseq != 0 }">
                <img  src="../image/reply.gif">
                </c:if>
                
                <a class="content" href="javascript:isLogin('${sessionScope.memId }','${boardDTO.seq }','${boardPaging.currentPage }');" id="subject">
                 ${boardDTO.subject }</a></td>
			<td width="118px">${boardDTO.id }</td>
			<td>${boardDTO.logtime }</td>
			<td width="68px" align="center">${boardDTO.hit }</td>
		</tr>
        </c:forEach>
	</c:if>
	</table>
	<div align="center" style="display:inline-block; text-align:center; border: 1px;  width:700px ">
      ${boardPaging.pagingHTML }
	</div>
	<div id="searchDiv" align="center" style="display:inline-block; text-align:center; border: 1px;  width:700px; height:21px; ">
      <select name="color" style="height:100%;">
        <option value="red">빨강</option>
        <option value="yellow">노랑</option>
        <option value="green">초록</option>
        <option value="blue">파랑</option>
        <option value="magenta">보라</option>
      </select>
      <input type="text" name="input_text" style="height:100%;">
      <input type="button" name="input_btn" value="검색" style="height:100%;">
	</div>
<script type="text/javascript">
  function isLogin(id, seq, pg) {
      if(id == '') {
          alert("로그인을 해주세요.");
      }else{
          location.href="boardView.do?seq="+seq+"&pg="+pg;
      }
  }
</script>