package member.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.control.CommandProcess;

import member.bean.MemberDTO;
import member.dao.MemberDAO;

public class CheckIdAction implements CommandProcess {

    @Override
    public String requestPro(HttpServletRequest request, HttpServletResponse response) 
    		throws Throwable {
    	String id = request.getParameter("id");
    	MemberDAO memberDAO = MemberDAO.getInstance();
    	MemberDTO memberDTO = memberDAO.getMember(id);
    	request.setAttribute("id", id);
    	if(memberDTO != null) {
    		return "checkIdFail.jsp";
    	}
        return "checkIdOk.jsp";
    }

}
