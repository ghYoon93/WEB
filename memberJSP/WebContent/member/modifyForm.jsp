<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<jsp:useBean id="memberDTO" class="member.bean.MemberDTO"/>
<jsp:useBean id="memberDAO" class="member.dao.MemberDAO"/>
<%
  String id = (String)session.getAttribute("memId");
  memberDTO = memberDAO.findMember(id);
  String name = memberDTO.getName();
  String gender = memberDTO.getGender();
  String email1 = memberDTO.getEmail1();
  String email2 = memberDTO.getEmail2();
  String tel1 = memberDTO.getTel1();
  String tel2 = memberDTO.getTel2();
  String tel3 = memberDTO.getTel3();
  String zipcode = memberDTO.getZipcode();
  String addr1 = memberDTO.getAddr1();
  String addr2 = memberDTO.getAddr2();
%>    

<!DOCTYPE html>
<html>
<head>

<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<form name="modifyForm" method="post" action="modify.jsp">
      <table border="1" cellspacing="0" cellpadding="3">
        <tr>
          <td class=key>이름</td>
          <td><input type="text" name="name" value= "<%=name%>"size="10"/></td>
        </tr>
        <tr>
          <td class=key>아이디</td>
          <td>
            <input type="text" name="id" value= "<%=id%>" size="25" readonly />
          </td>
        </tr>
        <tr>
          <td class=key>비밀번호</td>
          <td><input type="password" name="pwd"/></td>
        </tr>
        <tr>
          <td class=key>재확인</td>
          <td><input type="password" name="repwd"/></td>
        </tr>
        <tr>
          <td class=key>성별</td>
          <td>
            <input type="radio" name="gender" id="0" value="0"/>남
            <input type="radio" name="gender" id="1" value="1"/>여
          </td>
        </tr>
        <tr>
          <td class=key>이메일</td>
          <td>
            <input type="text" name="email1"  value= "<%=email1%>">@
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
             <select name="tel1" id = "tel1">
               <option value="010">010</option>
               <option value="011">011</option>
               <option value="017">017</option>
               <option value="019">019</option>
             </select>
             <input type="tel" name="tel2" size="4" value= "<%=tel2%>"/>
             <input type="tel" name="tel3" size="4" value= "<%=tel3%>"/>
           </td>
         </tr>
         <tr>
           <td class=key>주소</td>
           <td>
             <input type="text" name="zipcode" id="zipcode" size="6" readonly value= "<%=zipcode%>"/>
             <input type="button" value="우편번호검색" onclick="checkPost()"/>
             <br>
             <input type="text" name="addr1" id="addr1" size="50" placeholder="주소" value= "<%=addr1%>" readonly/>
             <br>
             <input type="text" name="addr2" id="addr2" size="50" placeholder="상세 주소" value= "<%=addr2%>"/>
           </td>
         </tr>
         <tr>
           <td colspan="2" align="center">
             <input type="button" value="회원 정보 수정" onclick="checkModifyForm()"/>
             <input type="reset" value="다시 작성"/>
           </td>
         </tr>
      </table>
    </form>
</body>
<script type = "text/javascript" src="../js/member.js"></script>
<script type = "text/javascript">
    window.onload=function(){
        document.modifyForm.gender[<%=gender%>].checked = true;
        document.modifyForm.email2.value = '<%=email2%>';
        document.modifyForm.tel1.value = '<%=tel1%>';
    }
</script>

</html>