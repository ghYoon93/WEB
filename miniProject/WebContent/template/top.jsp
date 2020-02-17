<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<style>
    #topDiv a:link{color: black; text-decoration: none;} /* link: 기본 상태 */ 
    #topDiv a:visited{color: black; text-decoration: none;} /* visted: 방문했을 때 */
    #topDiv a:hover{color: blue; text-decoration: none;} /* hover: 마우스를 올렸을 때 */ 
    #topDiv a:active{color: black; text-decoration: none;} /* acitve: 마우스를 눌렀을 때 */ 
</style>
<h2><a href="../main/index.do"><img src="../image/love.gif" width="70" height="70" style="cursor:pointer;"></a> MVC를 이용한 미니 프로젝트</h2>
<div id = "topDiv">
<c:choose>
    <c:when test="${memId == null }">
    <a href="../member/writeForm.do">회원가입</a>&emsp;
    </c:when>
    <c:otherwise>
    <a href="../board/boardWriteForm.do">글쓰기</a>&emsp;
    <a href="../imageboard/imageboardWriteForm.do">이미지등록</a>&emsp;
    </c:otherwise>
</c:choose>
<a href="../board/boardList.do?pg=1">목록</a>&emsp;
<a href="../imageboard/imageboardList.do?pg=1">이미지목록</a>
</div>
