<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<h2>답글</h2>
<form name="boardReplyForm" method="post" action="boardReply.do">
<input type = "hidden" name = "seq" value="${seq }">
<input type = "hidden" name = "pg" value="${pg }">
<table border="1" cellpadding="3" cellspacing="0">
	<tr>
		<td width="70" align="center">제목</td>
		<td>
			<input type="text" id="subject" name="subject"placeholder="제목 입력" size="50">
			<div id="subjectDiv"></div>
		</td>
	</tr>

	<tr>
		<td align="center" width="70">내용</td>
		<td>
			<textarea id="content" name="content" placeholder="내용 입력" rows="15" cols="40"></textarea>
			<div id="contentDiv"></div>
		</td>
	</tr>
	<tr>
		<td colspan="2" align="center">
		  <input type="button" id="boardReplyFormBtn"value="답글 쓰기">
		</td>
	</tr>
</table>
</form>
<script type="text/javascript" src="../js/jquery-3.4.1.min.js"></script>
<script type="text/javascript" src="../js/member.js?ver=1"></script>