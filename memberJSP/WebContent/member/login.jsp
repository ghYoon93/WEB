<%@ page language="java" contentType="text/html; charset=UTF-8"
  pageEncoding="UTF-8"%>
<%@ page import="member.dao.MemberDAO"%>
<jsp:useBean id="memberDTO" class = "member.bean.MemberDTO"/>
<%
    request.setCharacterEncoding("UTF-8");
%>
<%-- <jsp:useBean id="memberDTO" class="member.bean.MemberDTO" scope="session"></jsp:useBean>
<jsp:setProperty property="id" name="memberDTO"/>
<jsp:setProperty property="password" name="memberDTO"/> --%>
<%@page import="java.net.URLEncoder"%>
<%
    String id = request.getParameter("id");
    String pwd = request.getParameter("pwd");

    // String id = memberDTO.getId();
    // String password = memberDTO.getPassword();

    MemberDAO memberDAO = MemberDAO.getInstance();

    boolean isIdExist = memberDAO.findMemberById(id);
    String result = "";
    if (isIdExist) {
        boolean isPwdMatch = memberDAO.pwdEquals(id, pwd);
        if (isPwdMatch) {
            //  memberDTO.setName(memberDAO.getName(id));
            memberDTO = memberDAO.findMember(id);
            String name = memberDTO.getName();
            String email = memberDTO.getEmail1()+"@"+memberDTO.getEmail2();
            //  쿠키
            //  Cookie cookie = new Cookie("memName", name);
            //  cookie.setMaxAge(30*60);
            //  response.addCookie(cookie);// 클라이언트에게 보내기
            
            //   Cookie cookie2 = new Cookie("memId", id);
            //  cookie2.setMaxAge(30*60);
            //  response.addCookie(cookie2);
            //  세션
            session = request.getSession();  
            session.setAttribute("memName", name);
            session.setAttribute("memId", id);
            session.setAttribute("memEmail", email);
            response.sendRedirect("loginOk.jsp");
        } else {
            response.sendRedirect("loginFail.jsp");
        }
    } else {
        response.sendRedirect("loginFail.jsp");
    }
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
  <%=result%>
</body>
</html>