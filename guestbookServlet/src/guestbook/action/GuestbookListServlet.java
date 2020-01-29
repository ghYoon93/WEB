package guestbook.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import guestbook.bean.GuestbookDAO;
import guestbook.bean.GuestbookDTO;


@WebServlet("/GuestbookListServlet")
public class GuestbookListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ArrayList<GuestbookDTO> list = new ArrayList<GuestbookDTO>();
	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
	        throws ServletException, IOException {
	    GuestbookDAO dao = GuestbookDAO.getInstance();
	    list = dao.selectAll();
	    
	    response.setContentType("text/html; charset=UTF-8");
	    PrintWriter out = response.getWriter();
	    out.println("<html>");
	    out.println("<head>");
	    out.println("<title>");
	    out.println("글 목록");
	    out.println("</title>");
	    out.println("</head>");
	    out.println("<body>");
	    out.println("<h1>");
	    out.println("방명록");
	    out.println("</h1>");
	    for(GuestbookDTO dto : list) {
	        out.println("<table border=\"1\" cellspacing=\"0\" cellpadding=\"3\">");
	        out.println("<tr>");
	        out.println("<td class='key'>작성자</td>");
	        out.println("<td>");
	        out.println("<div class='value' name='name'>");
	        out.println(dto.getName());
	        out.println("</div>");
	        out.println("</td>");
	        out.println("<td class='key'>작성일</td>");
	        out.println("<td>");
	        out.println("<div class='value' name='date'>");
	        out.println(dto.getDate());
	        out.println("</div>");
	        out.println("</td>");
	        out.println("</tr>");
	        out.println("<tr>");
	        out.println("<td class='key'>이메일</td>");
	        out.println("<td colspan=\"3\">");
	        out.println(dto.getEmail());
	        out.println("<div class='value' name='email'>");
	        out.println("</div>");
	        out.println("</td>");
	        out.println("</tr>");
	        out.println("<tr>");
	        out.println("<td class='key'>홈페이지</td>");
	        out.println("<td colspan=\"3\">");
	        out.println(dto.getHompage());
	        out.println("<div class='value' name='homepage'>");
	        out.println("</div>");
	        out.println("</td>");
	        out.println("</tr>");
	        out.println("<tr>");
	        out.println("<td class='key'>제목</td>");
	        out.println("<td colspan=\"3\">");
	        out.println("<div class='value' name='content'>");
	        out.println(dto.getContent());
	        out.println("</div>");
	        out.println("</td>");
	        out.println("</tr>");
	        out.println("<tr>");
	        out.println("<td colspan=\"4\">");
	        out.println("<textarea class='value' readonly cols=\"60\" rows=\"10\">");
	        out.println(dto.getContent());
	        out.println("</textarea></td>");
	        out.println("</tr>");
	        out.println("</table>");
	        out.println("<br>");
	    }
	    out.println("</body>");
	    out.println("</html>");
	}
}
