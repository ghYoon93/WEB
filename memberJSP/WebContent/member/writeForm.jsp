<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
  <head>
    <meta charset="UTF-8">
    <title>Insert title here</title>
    <style>
      .key{width: 70; text-align:center;}
    </style>
  </head>
  <body>
    <form name="writeForm" method="post" action="http://localhost:8080/memberJSP/member/write.jsp">
      <table border="1" cellspacing="0" cellpadding="3">
        <tr>
          <td class=key>이름</td>
          <td><input type="text" name="name" placeholder="이름 입력" size="10"/></td>
        </tr>
        <tr>
          <td class=key>아이디</td>
          <td>
            <input type="text" name="id" placeholder="아이디 입력" size="25"/>
            <input type="hidden" name="availableId" value=""/>
            <input type="button" value="중복체크" onclick="checkId()"/>
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
            <input type="radio" name="gender" value="0" checked/>남
            <input type="radio" name="gender" value="1"/>여
          </td>
        </tr>
        <tr>
          <td class=key>이메일</td>
          <td>
            <input type="email" name="email1"/>@
            <input type="email" name="email2" list="email2" placeholder="직접입력"/>
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
             <select name="tel1">
               <option value="010">010</option>
               <option value="011">011</option>
               <option value="017">017</option>
               <option value="019">019</option>
             </select>
             <input type="tel" name="tel2" size="4"/>
             <input type="tel" name="tel3" size="4"/>
           </td>
         </tr>
         <tr>
           <td class=key>주소</td>
           <td>
             <input type="text" name="zipcode" id="zipcode" size="6" readonly/>
             <input type="button" value="우편번호검색" onclick="checkPost()"/>
             <br>
             <input type="text" name="addr1" id="addr1" size="50" placeholder="주소" readonly/>
             <br>
             <input type="text" name="addr2" id="addr2" size="50" placeholder="상세 주소"/>
           </td>
         </tr>
         <tr>
           <td colspan="2" align="center">
             <input type="button" value="회원 가입" onclick="checkWriteForm()"/>
             <input type="reset" value="다시 작성"/>
           </td>
         </tr>
      </table>
    </form>
  </body>
  <script type="text/javascript" src="http://localhost:8080/memberJSP/js/member.js"></script>
  <script src="https://t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
</html>