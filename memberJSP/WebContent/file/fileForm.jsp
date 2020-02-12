<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<form method="post" enctype="multipart/form-data" action="fileUpload.jsp">
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
    <td colspan="2">
      <input type="file" name="upload1" size="50">
    </td>
  </tr>
  <tr>
    <td colspan="2">
      <input type="file" name="upload2" size="50">
    </td>
  </tr>
  <tr>
    <td colspan="2">
      <input type="submit" value="파일 업로드">
      <input type="reset" value="다시작성">
  </tr>
</table>
</form>
</body>
</html>