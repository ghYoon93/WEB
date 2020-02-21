<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.Date" %>
<%@ page import="java.util.Calendar" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%
request.setCharacterEncoding("UTF-8");
Date currentDate = new Date();
Calendar cal = Calendar.getInstance();
String name = request.getParameter("name");
String birth = request.getParameter("birth");
int year = Integer.parseInt(birth.substring(0, 4));
int month = Integer.parseInt(birth.substring(4,6));
int day = Integer.parseInt(birth.substring(6));
int currentYear = cal.get(Calendar.YEAR); 
int age = currentYear-year+1;

%>
<fmt:requestEncoding value="UTF-8"/>
<c:set var="now" value="<%=currentDate %>"/>
<c:set var="currentYear"><fmt:formatDate value="${now}" pattern="yyyy" /></c:set>
<fmt:parseDate var="birth" value="${param.birth }" pattern="yyyyMMdd"/>
<c:set var="year"><fmt:formatDate value="${birth }" pattern="yyyy" /></c:set>
<c:set var="age" value="${currentYear-year+1 }"/>
<%=name %>님의 생일은 <%=year %>년 <%=month %>월 <%=day %>일 입니다.<br>
나이는 <%=age %>살입니다.<br>

${param.name}님의 생일은 <fmt:formatDate value="${birth }" pattern="yyyy년 MM월 dd일"/> 입니다.<br>
나이는 ${age}살입니다.<br>