package guestbook.action;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import guestbook.bean.GuestbookDAO;
import guestbook.bean.GuestbookDTO;

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
		GuestbookDTO dto = new GuestbookDTO();
		dto.setName(name);
		dto.setEmail(email);
		dto.setHomepage(homepage);
		dto.setSubject(subject);
		dto.setContent(content);
		
		GuestbookDAO dao = GuestbookDAO.getInstance();
		dao.insert(dto);
		
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();
		out.println("<html>");
		out.println("<body>");
		out.println("작성하신 글을 저장했습니다.");
		out.println("</body>");
		out.println("</html>");
	}

}
