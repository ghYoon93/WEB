package member.action;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
	        throws ServletException, IOException {
	    String id = request.getParameter("id");
	    String pw = request.getParameter("password");
	    String result = "아이디 또는 비밀번호가 맞지 않습니다.";
	    MemberDAO memberDAO = MemberDAO.getInstance();
	    boolean isExistId = memberDAO.isExistId(id);
	    if(isExistId && memberDAO.isPwMatch(id, pw)) {
	        String name = memberDAO.findName(id);
	        result = name+"님 환영합니다.";
	    }
	    response.setContentType("text/html; charset=UTF-8");
	    PrintWriter out = response.getWriter();
	    out.println("<html>");
	    out.println("<body>");
	    out.println(result);
	    out.println("</body>");
	    out.println("</html>");
	}

}
