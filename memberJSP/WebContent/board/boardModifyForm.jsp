<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
request.setCharacterEncoding("UTF-8");
String seq = request.getParameter("seq");
String subject = request.getParameter("subject");
String content = request.getParameter("content");
%>
<!DOCTYPE html>
<html>
  <head>
    <meta charset="UTF-8">
    <title>글 수정</title>
    <style>
      .key{text-align:center;}
      textarea{overflow-y: scroll;}
    </style>
  </head>
  <body>
    <h3>글 수정</h3>
    <form name="boardModifyForm" action="boardModify.jsp" method="get">
       <table border=1 cellpadding="3" cellspacing="0">
        <tr>
        <td class='key'>제목</td>
        <td class='value'>
          <input type="hidden" name="seq" value=<%=seq%>>
          <input type="text" name="subject"size="50" value=<%=subject%>>
        </td>
      </tr>
        <tr>
        <td class='key'>내용</td>
        <td class='value'>
          <textarea name="content" cols="60" rows="10"><%=content%></textarea>
        </td>
      </tr>
        <tr>
          <td colspan="2" align="center">
            <input type="button" value="글수정" onclick="checkBoardModifyForm()">
            <input type="reset" value="다시작성">
          </td>
        </tr>
      </table>
  </form>
</body>
<script type="text/javascript" src="../js/member.js?ver=1"></script>
</html>