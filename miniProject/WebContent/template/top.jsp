<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<h2><a href="../main/index.do"><img src="../image/love.gif" width="70" height="70" style="cursor:pointer;"></a> MVC를 이용한 미니 프로젝트</h2>
<c:choose>
  <c:when test="${memId == null }">
  <a href="../member/writeForm.do">회원가입</a>
  <a href="../member/loginForm.do">로그인</a>
  </c:when>
  <c:when test="${memId != null }">
  <a href="../board/boardWriteForm.do">글쓰기</a>
  <a href="../board/boardList.do?pg=1">목록</a>
  <a href="../imageboard/imageboardWriteForm.do">이미지등록</a>
  <a href="../imageboard/imageboardList.do?pg=1">이미지목록</a>
  </c:when>
</c:choose>
