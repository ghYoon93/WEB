package com.person;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class PersonServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public PersonServlet() {
        super();
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		String name = request.getParameter("name");
		String gender = Integer.parseInt(request.getParameter("gender")) == 0 ?"남자":"여자";
		String color = request.getParameter("color");
		String[] hobby = request.getParameterValues("hobby");
		String[] subject = request.getParameterValues("subject");
		
		
		out.println("<html>");
		out.println("<head>");
		out.println("<style>");
		out.println("li {color:"+color+";}");
		out.println("</style>");
		out.println("</head>");
		out.println("<body>");
		out.println("<ul>");
		out.println("<li>");
		out.println("이름: "+ name);
		out.println("</li>");
		out.println("<li>");
		out.println("성별: "+ gender);
		out.println("</li>");
		out.println("<li>");
		out.println("색깔: "+ color);
		out.println("</li>");
		out.println("<li>");
		out.println("취미: ");
		for(int i = 0; i<hobby.length; i++) out.print(hobby[i]+" ");
		out.print("<br>");
		out.println("</li>");
		out.println("<li>");
		out.println("과목: ");
		for(int i = 0; i<hobby.length; i++) out.print(subject[i]+" ");
		out.print("<br>");
		out.println("</li>");
		out.println("</ul>");
		out.println("<body>");
		out.println("</html>");
	}

}
