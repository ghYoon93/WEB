<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<h2>글쓰기</h2>
<form name="boardWriteForm" method="post" action="boardWrite.do">
<table border="1" cellpadding="3" cellspacing="0">
	<tr>
		<td width="70" align="center">제목</td>
		<td>
			<input type="text" id="subject" name="subject" placeholder="제목을 입력하시오" size="50">
             <div id="subjectDiv"></div>
		</td>
	</tr>

	<tr>
		<td align="center" width="70">내용</td>
		<td>
			<textarea id="content" name="content"  placeholder="내용을 입력하시오" rows="15" cols="40"></textarea>
            <div id="contentDiv"></div>
		</td>
	</tr>
	<tr>
		<td colspan="2" align="center">
		<input type="button" id="boardFormBtn" value="글쓰기" > 
		<input type="reset" value="다시작성"></td>
	</tr>
</table>
</form>
<script type="text/javascript" src="../js/jquery-3.4.1.min.js"></script>
<script type="text/javascript" src="../js/board.js"></script>