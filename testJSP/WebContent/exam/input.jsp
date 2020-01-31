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
<form method='get' action='/testJSP/exam/result.jsp'>
  <table border='1' cellspacing='0' cellpadding='10'>
    <tr>
      <td class='key'>X</td>
      <td><input size = 10 type="text" name='X'></td>
    </tr>
    <tr>
      <td class='key'>Y</td>
      <td><input size = 10 class = 'value' type="text" name='Y'></td>
    </tr>
    <tr>
      <td colspan='2' align='center'>
        <input type='submit' value='계산'>
          <input type='reset' value='취소'>
      </td>
    </tr>
  </table>
</form>
</body>
</html>
