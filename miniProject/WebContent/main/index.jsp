<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
  body{margin="0";}
</style>
</head>
<body>
<table width="100%" height="100%" border="1">
  <tr>
    <td colspan="2" align="center"><jsp:include page="../template/top.jsp"/></td>
  </tr>
  <tr>
    <td width="20%"><jsp:include page="../template/left.jsp"/></td>
    <%-- <td align="center"><jsp:include page="../template/body.jsp"/></td> --%>
    <td align="center"><jsp:include page="${display }"/></td>
  </tr>
  <tr>
    <td colspan="2" align="center"><jsp:include page="../template/bottom.jsp"/></td>
  </tr>

</table>
</body>
</html>