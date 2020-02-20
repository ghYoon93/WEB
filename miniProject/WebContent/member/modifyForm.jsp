<%@ page language="java" contentType="text/html; charset=UTF-8"
  pageEncoding="UTF-8"%>
<form name="modifyForm" method="post" action="modify.do">
  <table border="1" cellspacing="0" cellpadding="3">
    <tr>
      <td class=key>이름</td>
      <td><input type="text" name="name" value="${memberDTO.name }"size="10"/></td>
    </tr>
    <tr>
      <td class=key>아이디</td>
      <td><input type="text" name="id" value="${memberDTO.id }" size="25" readonly /></td>
    </tr>
    <tr>
      <td class=key>비밀번호</td>
      <td><input type="password" name="pwd" id="pwd"/></td>
    </tr>
    <tr>
      <td class=key>재확인</td>
      <td><input type="password" name="repwd"/></td>
    </tr>
    <tr>
      <td class=key>성별</td>
      <td>
        <input type="radio" name="gender" value="0"/>남
        <input type="radio" name="gender" value="1"/>여
      </td>
    </tr>
    <tr>
      <td class=key>이메일</td>
      <td>
        <input type="text" name="email1"  value="${memberDTO.email1 }">@
        <input type="text" name="email2" list="email2" placeholder="직접입력"/>
        <datalist id="email2">
          <option value="gmail.com"/>
          <option value="hanmail.net"/>
          <option value="naver.com"/>
        </datalist>
      </td>
    </tr>
    <tr>
      <td>핸드폰</td>
      <td>
        <select name="tel1" id="tel1">
            <option value="010">010</option>
            <option value="011">011</option>
            <option value="017">017</option>
            <option value="019">019</option>
        </select>
        <input type="tel" name="tel2" size="4" value="${memberDTO.tel2 }"/>
        <input type="tel" name="tel3" size="4" value="${memberDTO.tel3 }"/>
      </td>
    </tr>
    <tr>
      <td class=key>주소</td>
      <td>
        <input type="text" name="zipcode" id="zipcode" size="6" readonly value="${memberDTO.zipcode }">
        <input type="button" value="우편번호검색" onclick="checkPost()"/><br>
        <input type="text" name="addr1" id="addr1" size="50" placeholder="주소" value="${memberDTO.addr1 }" readonly/><br>
        <input type="text" name="addr2" id="addr2" size="50" placeholder="상세 주소" value="${memberDTO.addr2 }"/>
      </td>
    </tr>
    <tr>
      <td colspan="2" align="center">
        <input type="button" value="회원정보수정" onclick="checkModifyForm()"/>
        <input type="reset" value="다시작성"/>
      </td>
    </tr>
  </table>
</form>
<script type="text/javascript" src="../js/member.js"></script>
<script type = "text/javascript">
window.onload=function(){
    document.modifyForm.gender['${memberDTO.gender}'].checked = true;
    document.modifyForm.email2.value = '${memberDTO.email2}';
    document.getElementById('tel1').value = '${memberDTO.tel1}';
}
</script>