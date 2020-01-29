package member.action;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import member.bean.MemberDAO;

public class CheckIdServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
	        throws ServletException, IOException {
        String id = request.getParameter("id");
        MemberDAO memberDAO = MemberDAO.getInstance();
        boolean idExists = memberDAO.idExists(id);
        String result = id+"는(은) 사용 가능";
        if(idExists) result = id+"는(은) 사용 불가능";
        
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();
		out.println("<html>");
		out.println("<head>");
		out.println("</head>");
		out.println("<body>");
		out.println(result);
		out.println("<br>");
		out.println("<form method='get' action='http://localhost:8080/memberServlet/checkIdServlet'>");
		if(idExists) {
		    out.println("아이디");
		    out.println("<input type='text' name='id' placeholder='아이디 입력'>");
		    out.println("<input type='submit' value='중복체크'>");
		}else {
		    out.println("<input type='button' value='사용' onclick='checkIdClose(\""+id+"\")'>");
		}
		out.println("</form>");
//		out.println("");
		out.println("</body>");
		out.println("<script type='text/javascript' src='http://localhost:8080/memberServlet/js/member.js'>");
		out.println("</script>");
		out.println("</html>");
		   
	}

 
}
