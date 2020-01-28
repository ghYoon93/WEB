package member.action;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import member.bean.MemberDAO;

@WebServlet("/CheckIdServlect")
public class CheckIdServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
	        throws ServletException, IOException {
        String id = request.getParameter("id");
        MemberDAO memberDAO = MemberDAO.getInstance();
        boolean idExists = memberDAO.idExists(id);
        String result = id+"는(은) 사용 가능";
        if(idExists) result = id+"는(은) 불가능";
        
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();
		out.println("<html>");
		out.println("<head>");
		out.println("</head>");
		out.println("<body>");
		out.println(result);
		out.println("</body>");
		out.println("</html>");
		   
	}

 
}
