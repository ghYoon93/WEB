<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<style type="text/css">
.contents {
    white-space: pre-line;
    word-break: break-all;
    width: 450px;
}
</style>

<form name="imageboardViewForm">
<input type="hidden" name="seq" value="${seq }">
<input type="hidden" name="pg" value="${pg }">

<table  cellpadding="5" frame="hsides" rules="rows">
    <tr>
        <td rowspan="4">
            <img src="../storage/${imageDTO.image1 }" width="200" height="200">
        </td>
        <td width = "250">
                        상품명: ${imageDTO.imageName }
        </td>
    <tr> 
        <td width="250">
                        단가 : <fmt:formatNumber type="number" value = "${imageDTO.imagePrice }" pattern="#,###원"/>
        </td>
    </tr>
    <tr>
        <td width="250">
                         개수 : <fmt:formatNumber type="number" value = "${imageDTO.imageQty }" pattern="#,###개"/> 
        </td>
    </tr>
    <tr>
        <td width="250">
                         합계 : <fmt:formatNumber type="number" value = "${imageDTO.imagePrice*imageDTO.imageQty }" pattern="#,###원"/>
        </td>
    </tr>
    <tr>
        <td colspan="3" height="200" valign="top">
            <pre class="contents">${imageDTO.imageContent }</pre>
        </td>
    </tr>
</table>
<input type="button" value="목록" onclick="location.href='imageboardList.do?pg=${pg }'">
<%-- <input type="button" value="답글" onclick="location.href='boardReplyForm.do?pseq=${seq}&pg=${pg }'">
<c:if test="${memId.equals(boardDTO.id) }">
    <input type="button" value="글수정" onclick="mode(1)">
    <input type="button" value="글삭제" onclick="mode(2)">
</c:if> --%>
</form>
</body>
<script type="text/javascript">
function mode(num){
    if(num==1){
        document.boardViewForm.method = 'post';
        document.boardViewForm.action = 'boardModifyForm.do';
        document.boardViewForm.submit();
        
    }else if(num==2){
        document.boardViewForm.method = 'post';
        //document.boardViewForm.action = 'boardDelete.jsp';
        document.boardViewForm.submit();
    }
}
</script>