<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
String id = (String) session.getAttribute("memId");
String name = (String) session.getAttribute("memName");
%>
<!DOCTYPE html>
<html>
  <head>
    <meta charset="UTF-8">
    <title>글쓰기</title>
    <style>
      .key{text-align:center;}
      textarea{overflow-y: scroll;}
    </style>
  </head>
  <body>
    <h3>글쓰기</h3>
    <form name="boardWriteForm" action="boardWrite.jsp" method="get">
       <table border=1 cellpadding="3" cellspacing="0">
        <tr>
        <td class='key'>제목</td>
        <td class='value'>
          <input type="text" name="subject" placeholder="제목 입력" size="50">
        </td>
      </tr>
        <tr>
        <td class='key'>내용</td>
        <td class='value'>
          <textarea name="content" placeholder="내용 입력" cols="60" rows="10"></textarea>
        </td>
      </tr>
        <tr>
          <td colspan="2" align="center">
            <input type="button" name="write" value="글작성" onclick="checkBoardWriteForm()">
            <input type="reset" name="reset" value="다시작성">
          </td>
        </tr>
      </table>
  </form>
</body>
<script type = "text/javascript" src="../js/member.js"></script>
</html>