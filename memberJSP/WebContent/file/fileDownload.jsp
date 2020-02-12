<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="java.io.BufferedInputStream"%>
<%@page import="java.io.BufferedOutputStream"%>
<%@ page import = "java.io.File" %>
<%@page import="java.io.FileInputStream"%>
<%@page import="java.io.FileOutputStream"%>
<%@ page import="java.net.URLEncoder"%>
<%
//  데이터
String fileName = request.getParameter("fileName");
String realFolder = request.getServletContext().getRealPath("/storage");
File file = new File(realFolder, fileName);
fileName = URLEncoder.encode(fileName, "UTF-8").replace("+"," ");
response.setHeader("content-Disposition", "attachment;fileName="+fileName);
response.setHeader("content-Length", file.length()+"");
/*
getOutputStream() has already been called for this response
JSP에서는 SERVLET으로 변환할 때 내부적으로 out객체가 자동으로 생성하기 때문에
out객체를 만들면 충돌이 일어난다. 따라서 먼저 out을 초기화하고 생성하면 된다.
*/
out.clear(); // 초기화
out=pageContext.pushBody();

BufferedInputStream bis = new BufferedInputStream(new FileInputStream(file));
BufferedOutputStream bos = new BufferedOutputStream(response.getOutputStream());

int size = (int)file.length();
byte[] b = new byte[size];
bis.read(b,0,size);
bos.write(b);
bis.close();
bos.close();


%>