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
  ${param.id }은(는) 사용 불가능<br><br>
  <form name="checkIdForm" method="get" action="checkId.do">
  <input type = text name="id" size="25" placeholder="아이디 입력">
  <input type="button" value="중복체크" onclick="checkId()">
  </form>
</div>
</body>
<script type="text/javascript">
    function checkId(){
	    var sId = document.checkIdForm.id.value;
	    if(sId == ""){
	        alert("아이디를 입력해주세요.");
	    }else{
	    	document.checkIdForm.submit();
	    }
  }
</script>
</html>