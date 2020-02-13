<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:choose>
  <c:when test="${memId == null }">
  <a href="../member/writeForm.do">회원가입</a><br>
  <a href="../member/loginForm.do">로그인</a><br>
  </c:when>
  <c:when test="${memId != null }">
  <a href="">회원정보수정</a><br>
  <a href="../member/logout.do">로그아웃</a><br>
  <a href="">글쓰기</a><br>
  <a href="">목록</a><br>
  <a href="">이미지등록</a><br>
  <a href="">이미지목록</a><br>
  </c:when>
</c:choose>
