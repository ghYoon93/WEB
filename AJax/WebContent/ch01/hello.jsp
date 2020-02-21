<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
request.setCharactorEncoding("UTF-8");
<%String name = request.getParameter("name");%>
안녕하세요 <%=name%>님 
--%>
<fmt:requestEncoding value="UTF-8"/>
안녕하세요 ${param.name }님

