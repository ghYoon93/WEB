<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="com.oreilly.servlet.MultipartRequest"%>
<%@page import="com.oreilly.servlet.multipart.DefaultFileRenamePolicy"%>
<%@page import= "java.io.File" %>
<%@page import= "java.net.URLEncoder" %>
<%
String realFolder=request.getServletContext().getRealPath("/storage");
System.out.println("실제폴더 = "+realFolder); 
MultipartRequest multi = new MultipartRequest(request
                                             , realFolder
                                             , 5*1024*1024 //5mb
                                             ,"UTF-8"
                                             , new DefaultFileRenamePolicy());

String subject = multi.getParameter("subject");
String content = multi.getParameter("content");

String originalFileName1 = multi.getOriginalFileName("upload1");
String originalFileName2 = multi.getOriginalFileName("upload2");

String fileName1 = multi.getFilesystemName("upload1");
String fileName2 = multi.getFilesystemName("upload2");

File file1 = multi.getFile("upload1");
File file2 = multi.getFile("upload2");

long fileSize1=0;
long fileSize2=0;
if(file1!=null) fileSize1 = file1.length();
if(file2!=null) fileSize2 = file2.length();

%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>fileUpload.jsp</title>
</head>
<body>
<h3>파일이 업로드 되었습니다.</h3>
<ul>
<li> 제목: <%=subject %><br>
<li> 내용: <pre><%=content %></pre>
<li> 파일: <a href="fileDownload.jsp?fileName=<%=URLEncoder.encode(originalFileName1,"UTF-8")%>"><%=originalFileName1%></a>
<li> 파일: <%=fileName1 %>
<li> 크기: <%=fileSize1 %><br>
===================================
<li> 파일: <a href="fileDownload.jsp?fileName=<%=URLEncoder.encode(originalFileName2,"UTF-8")%>"><%=originalFileName2 %></a>
<li> 파일: <%=fileName2 %>
<li> 크기: <%=fileSize2 %>
</ul>
</body>
</html>