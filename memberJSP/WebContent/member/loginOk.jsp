<%@ page language="java" contentType="text/html; charset=UTF-8"
  pageEncoding="UTF-8"%>
<%-- <jsp:useBean id="memberDTO" class="member.bean.MemberDTO" scope="session"></jsp:useBean> --%>
<%
request.setCharacterEncoding("UTF-8");
String name = null;
String id = null;
// 쿠키는 특정 쿠키만 가져올 수 없으므로 모든 쿠키를 가져와야한다.
// Cookie[] ar = request.getCookies();
// if (ar != null) {
//     for (int i = 0; i < ar.length; i++) {
        //  String cookieName = ar[i].getName();
        //  String cookieValue = ar[i].getValue();
        //  System.out.println("쿠키명 = "+cookieName);
        //  System.out.println("쿠키값 = "+cookieValue);
        //  System.out.println("<br>");/
//         if(ar[i].getName().equals("memName"))
//             name = ar[i].getValue();
//         if(ar[i].getName().equals("memId"))
//             id = ar[i].getValue();
//     }
// }
name = (String)session.getAttribute("memName");
id = (String) session.getAttribute("memId");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
  <jsp:include page="../main/logo.jsp"/>
  <div align="center">
    <%=name%>님 환영합니다.
  </div>
  <br>
  <div align="center">
    <input type="button" value="회원 정보 수정"
      onclick="location.href='modifyForm.jsp'" />
      <input type="button" value="로그 아웃"
      onclick="location.href='logout.jsp'" />
  </div>
</body>
</html>