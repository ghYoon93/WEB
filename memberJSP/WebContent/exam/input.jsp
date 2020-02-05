<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
  .key{align: center;}
</style>
</head>
<body>
<form method='get' action='sum.jsp'>
  <table border='1' cellspacing='0' cellpadding='10'>
    <tr>
      <td class='key'>X</td>
      <td><input size = 10 type="text" name="x"></td>
    </tr>
    <tr>
      <td class='key'>Y</td>
      <td><input size = 10 class = 'value' type="text" name="y"></td>
    </tr>
    <tr>
      <td colspan='2' align='center'>
        <input type='submit' value='합 구하기'>
          <input type='reset' value='취소'>
      </td>
    </tr>
  </table>
</form>
</body>
</html>
