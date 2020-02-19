<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<style>
  #currentPaging{color:red; text-decoration:underline;}
  #paging{color:black; text-decoration:none;}
  #deleteBtn{float:right}
  .content{width:100px; height:100px}
  .content:link{color: black; text-decoration:none;}
  .content:visited{color: black; text-decoration:none;}
  .content:active{color: black; text-decoration:none;}
  .content:hover{color: black; text-decoration:underline;}
</style>
<h2>이미지 목록</h2>
<input type="hidden" name="pg" value="${imageBoardPaging.currentPage}">
<table frame="hsides" rules="rows">
	<tr>
		<th><input type="checkbox" id=checkAll name = checkAll onclick="checkAll()">번호</th>
		<th>이미지</th>
		<th>상품명</th>
		<th>단가</th>
		<th>개수</th>
		<th>합계</th>
	</tr>
    <c:if test="${list!=null }">
       <c:forEach var="imageDTO" items="${list }">
		<tr>
			<td width="76px" align="center">
                 <input type="checkbox" name = checkItem value="${imageDTO.seq }">
                 ${imageDTO.seq }
            </td>
			<td >
                <img class="content" src="../storage/${imageDTO.image1 }" onclick="isLogin('${memId }', '${imageDTO.seq }', '${imageBoardPaging.currentPage }')">
            </td>
			<td width="118px" align="center">${imageDTO.imageName }</td>
			<td align= "center"><fmt:formatNumber type="number" value = "${imageDTO.imagePrice }" pattern="#,###원"/></td>
			<td width="68px" align="center"><fmt:formatNumber type="number" value = "${imageDTO.imageQty }" pattern="#,###개"/></td>
			<td width="68px" align="center"><fmt:formatNumber type="number" value = "${imageDTO.imagePrice*imageDTO.imageQty }" pattern="#,###원"/> </td>
		</tr>
        </c:forEach>
    </c:if>
      <tr border = "0">
        <td colspan="6"><input type="button" id="deleteBtn" value="선택 목록 삭제"><br></td>
      </tr>
	</table>
	<div align="center" style="display:inline-block; border: 1px;  width:700px ">
        ${imageBoardPaging.pagingHTML }
	</div>
<script type="text/javascript" src="../js/jquery-3.4.1.min.js"></script>
<script type="text/javascript" src="../js/imageboard.js"></script>
