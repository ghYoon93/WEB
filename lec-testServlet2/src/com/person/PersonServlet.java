package com.person;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class PersonServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
	        throws ServletException, IOException {
	    //데이터
		String name = request.getParameter("name");
		String gender = request.getParameter("gender").equals("0")?"남자":"여자";
		String color = request.getParameter("color");
		String[] hobby = request.getParameterValues("hobby");
		String[] subject = request.getParameterValues("subject");
		
		//응답
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		out.println("<html>");
		out.println("<head>");
		out.println("<style>");
		out.println("#aaa{color:"+color+"; font-weight:bold;}");
		out.println(".backA:link{color:red; text-decoration:none;}"); // a태그가 처음 걸렸을 때
		out.println(".backA:visited{color:blue; text-decoration:none;}"); // a태그를 클릭했을 때
		out.println(".backA:hover{color:green; text-decoration:underline;}"); // a태그에 마우스를 올렸을 때
		out.println(".backA:active{color:magenta; text-decoration:none;}"); // a태그를 누르고 있을 때
		out.println("</style>");
		out.println("</head>");
		out.println("<body>");
		out.println("<ul id='aaa'>");
		out.println("<li>");
		out.println("이름: ");
		out.println(name);
		out.println("<li>");
		out.println("성별: ");
		out.println(gender);
		out.println("<li>");
		out.println("색깔: ");
		out.println(color);
		out.println("<li>");
		out.println("취미: ");
		for(int i=0; i<hobby.length; i++) out.print(hobby[i]+" ");
		out.println("<li>");
		out.println("과목: ");
		for(int i=0; i<subject.length; i++) out.print(subject[i]+" ");
		out.println("</ul>");
		out.println("<a class=backA href='javascript:history.go(-1)'>");
        out.println("뒤로");
        out.println("</a>");
		out.println("</body>");
		out.println("</html>");
	}

}
