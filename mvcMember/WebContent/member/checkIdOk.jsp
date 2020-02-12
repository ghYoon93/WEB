<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>아이디 중복 확인</title>
</head>
<body>
<div align="center">
  ${param.id }은(는) 사용 가능<br><br>
  <input type="button" value="사용하기" onclick="checkIdClose('${param.id }')">
</div>
</body>
<script type="text/javascript" src="../js/member.js"></script>
</html>