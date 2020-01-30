package guestbook.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import guestbook.bean.GuestbookDTO;
import guestbook.dao.GuestbookDAO;


@WebServlet("/GuestbookListServlet")
public class GuestbookListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ArrayList<GuestbookDTO> list = new ArrayList<GuestbookDTO>();
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
	        throws ServletException, IOException {
	    int pg = Integer.parseInt(request.getParameter("pg"));
	    int endNum = pg*3;
	    int startNum = endNum-2;
	    
	    
	    GuestbookDAO guestbookDAO = GuestbookDAO.getInstance();
	    int totalA = guestbookDAO.getTotalArticle();
	    int totalP = (totalA+2)/3;
	    list = guestbookDAO.selectAll(startNum, endNum);	    
	    System.out.println(list.size());
	    response.setContentType("text/html; charset=UTF-8");
	    PrintWriter out = response.getWriter();
	    out.println("<html>");
	    out.println("<head>");
	    out.println("<title>");
	    out.println("글 목록");
	    out.println("</title>");
	    out.println("<style>");
	    out.println("#currentPaging {color: red; text-decoration: underline;}");
	    out.println("#paging {color: black; text-decoration: none;}");
	    out.println("</style>");
	    out.println("</head>");
	    out.println("<body>");
	    out.println("<h1>");
	    out.println("방명록");
	    out.println("</h1>");
	    for(int i=1; i<=totalP; i++) {
	        if(pg==i) out.println("[<a id='curruntPaging' href = '/guestbookServlet/GuestbookListServlet?pg="+i+"'>"+i+"</a>]");
	        else out.println("[<a id='paging' href = '/guestbookServlet/GuestbookListServlet?pg="+i+"'>"+i+"</a>]");
	    }
	    out.println("<br>");
	    for(GuestbookDTO guestbookDTO : list) {
	        out.println("<table border=\"1\" cellspacing=\"0\" cellpadding=\"3\">");
	        out.println("<tr>");
	        out.println("<td class='key'>작성자</td>");
	        out.println("<td>");
	        out.println("<div class='value' name='name'>");
	        out.println(guestbookDTO.getName());
	        out.println("</div>");
	        out.println("</td>");
	        out.println("<td class='key'>작성일</td>");
	        out.println("<td>");
	        out.println("<div class='value' name='date'>");
	        out.println(guestbookDTO.getLogTime());
	        out.println("</div>");
	        out.println("</td>");
	        out.println("</tr>");
	        out.println("<tr>");
	        out.println("<td class='key'>이메일</td>");
	        out.println("<td colspan=\"3\">");
	        out.println(guestbookDTO.getEmail());
	        out.println("<div class='value' name='email'>");
	        out.println("</div>");
	        out.println("</td>");
	        out.println("</tr>");
	        out.println("<tr>");
	        out.println("<td class='key'>홈페이지</td>");
	        out.println("<td colspan=\"3\">");
	        out.println(guestbookDTO.getHompage());
	        out.println("<div class='value' name='homepage'>");
	        out.println("</div>");
	        out.println("</td>");
	        out.println("</tr>");
	        out.println("<tr>");
	        out.println("<td class='key'>제목</td>");
	        out.println("<td colspan=\"3\">");
	        out.println("<div class='value' name='subject'>");
	        out.println(guestbookDTO.getSubject());
	        out.println("</div>");
	        out.println("</td>");
	        out.println("</tr>");
	        out.println("<tr>");
	        out.println("<td colspan=\"4\">");
	        out.println("<textarea class='value' readonly cols=\"60\" rows=\"10\">");
	        out.println(guestbookDTO.getContent());
	        out.println("</textarea></td>");
	        out.println("</tr>");
	        out.println("</table>");
	        out.println("<br>");
	    }
	    out.println("</body>");
	    out.println("</html>");
	}
}
