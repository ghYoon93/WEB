package member.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.control.CommandProcess;

import member.bean.MemberDTO;
import member.dao.MemberDAO;

public class LoginAction implements CommandProcess {

    @Override
    public String requestPro(HttpServletRequest request, HttpServletResponse response) 
            throws Throwable {
        String id = request.getParameter("id");
        String pwd = request.getParameter("pwd");
        
        //DB
        MemberDAO memberDAO = MemberDAO.getInstance();
        MemberDTO memberDTO = memberDAO.login(id, pwd);
        
        //응답
        if(memberDTO!=null) {
            HttpSession session = request.getSession();
            session.setAttribute("memName", memberDTO.getName());
            session.setAttribute("memId", id);
            session.setAttribute("memEmail", memberDTO.getEmail1()+"@"+memberDTO.getEmail2());
//            request.setAttribute("display", "/member/loginOk.jsp");
            request.setAttribute("display", "../template/body.jsp");
            if(request.getAttribute("error")!=null) {
                request.removeAttribute("error");
                System.out.println("메세지 삭제");
            }
            System.out.println(request.getAttribute("error"));
            System.out.println("메세지 삭제 X");
            return "/main/index.jsp";
        }else {
//            request.setAttribute("display", "/member/loginFail.jsp");
              request.setAttribute("error", "error");
              request.setAttribute("display", "../template/body.jsp");
            return "/main/index.jsp";
        }
    }
}
