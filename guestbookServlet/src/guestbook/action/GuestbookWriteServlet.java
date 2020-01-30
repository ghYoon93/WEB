package guestbook.action;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import guestbook.bean.GuestbookDTO;
import guestbook.dao.GuestbookDAO;

@WebServlet("/GuestbookWriteServlet")
public class GuestbookWriteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String name = request.getParameter("name");
		String email = request.getParameter("email");
		String homepage = request.getParameterValues("homepage")[0];
		String subject = request.getParameter("subject");
		String content = request.getParameter("content");
		GuestbookDTO guesetbookDTO = new GuestbookDTO();
		guesetbookDTO.setName(name);
		guesetbookDTO.setEmail(email);
		guesetbookDTO.setHomepage(homepage);
		guesetbookDTO.setSubject(subject);
		guesetbookDTO.setContent(content);
		
		GuestbookDAO guestbookDAO = GuestbookDAO.getInstance();
		guestbookDAO.insert(guesetbookDTO);
		
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();
		out.println("<html>");
		out.println("<body>");
		out.println("작성하신 글을 저장했습니다.");
		out.println("<br>");
		out.println("<br>");
		out.println("<input type='button' value='글목록' "
		        + "onclick=location.href='http://localhost:8080/guestbookServlet/GuestbookListServlet?pg=1'");
		out.println("</body>");
		out.println("</html>");
	}

}
