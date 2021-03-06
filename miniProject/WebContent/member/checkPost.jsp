<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="../css/member.css">
</head>
<body>
<form method="post" action="checkPost.do">
<table border="1" width="100%" cellspacing="0" cellpadding="3">
<tr>
    <td align="center">시도</td>
    <td>
    <select name="sido" style="width: 100px;" >
        <option value="">시도선택</option>
        <option value="서울">서울</option>
        <option value="인천">인천</option>
        <option value="대전">대전</option>
        <option value="대구">대구</option>
        <option value="울산">울산</option>
        <option value="세종">세종</option>
        <option value="광주">광주</option>
        <option value="경기">경기</option>
        <option value="강원">강원</option>
        <option value="전남">전남</option>
        <option value="전북">전북</option>
        <option value="경남">경남</option>
        <option value="경북">경북</option>
        <option value="충남">충남</option>
        <option value="충북">충북</option>
        <option value="부산">부산</option>
        <option value="제주">제주</option>
    </select>
    </td>
    <td align="center">시.군.구</td>
    <td>
        <input type="text" name="sigungu">
    </td>
</tr>
<tr>
    <td align="center">도로명</td>
    <td  colspan="3">
        <input type="text" name="roadname" style="width: 200px">
        <input type="submit" value="검색" >
    </td>
</tr>
<tr>
    <td align="center">우편번호</td>
    <td colspan="3" align="center">주소</td>
</tr>
<c:if test="${list!=null }">
<c:forEach var="zipcodeDTO" items="${list }">
  <c:set var="address" value="${zipcodeDTO.sido
                            } ${zipcodeDTO.sigungu 
                            } ${zipcodeDTO.yubmyundong 
                            } ${zipcodeDTO.ri 
                            } ${zipcodeDTO.roadname 
                            } ${zipcodeDTO.buildingname }"/> 
  <tr>
    <td align="center">${zipcodeDTO.zipcode }</td>
    <td colspan="3"><a class="addressA" href="#" onclick="checkPostClose('${zipcodeDTO.zipcode }','${address }')">${address }</a></td>
  </tr>
</c:forEach>
</c:if>
</table>
</form>
</body>
<script>
function checkPostClose(zipcode, address){
    /* opener.document.forms[0].zipcode.value = zipcode;
    opener.document.forms[0].addr1.value = address;
    window.close();
    opener.document.forms[0].addr2.focus(); */
    
    opener.document.getElementById('zipcode').value = zipcode;
    opener.document.getElementById('addr1').value = address;
    window.close();
    opener.document.getElementById('addr2').focus();
}
</script>
</html>