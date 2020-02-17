<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<style>
  #currentPaging{color:red; text-decoration:underline;}
  #paging{color:black; text-decoration:none;}
  .content{width:100px; height:100px}
  .content:link{color: black; text-decoration:none;}
  .content:visited{color: black; text-decoration:none;}
  .content:active{color: black; text-decoration:none;}
  .content:hover{color: black; text-decoration:underline;}
</style>
<h2>이미지 목록</h2>

<table border="1" cellpadding="5" cellspacing="0">
	<tr>
		<th>번호</th>
		<th>이미지</th>
		<th>상품명</th>
		<th>단가</th>
		<th>개수</th>
		<th>합계</th>
	</tr>
    <c:if test="${list!=null }">
       <c:forEach var="imageDTO" items="${list }">
		<tr>
			<td width="76px" align="center">${imageDTO.seq }</td>
			<td ><img class="content" src="../storage/${imageDTO.image1 }" onclick="isLogin('${memId }', '${imageDTO.seq }', '${boardPaging.currentPage }')"></td>
			<td width="118px" align="center">${imageDTO.imageName }</td>
			<td align= "center"><fmt:formatNumber type="number" value = "${imageDTO.imagePrice }" pattern="#,###"/></td>
			<td width="68px" align="center"><fmt:formatNumber type="number" value = "${imageDTO.imageQty }" pattern="#,###"/></td>
			<td width="68px" align="center"><fmt:formatNumber type="number" value = "${imageDTO.imagePrice*imageDTO.imageQty }" pattern="#,###"/> </td>
		</tr>
        </c:forEach>
    </c:if>
	</table>
	<div align="center" style="display:inline-block; text-align:center; float:left; border: 1px;  width:700px ">
        ${boardPaging.pagingHTML }
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