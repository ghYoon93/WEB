package member.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.control.CommandProcess;

public class LogoutAction implements CommandProcess {
    public String requestPro(HttpServletRequest request, HttpServletResponse response) 
            throws Throwable {
        //세션 종료하기
        HttpSession session = request.getSession();
        session.removeAttribute("memName");
        session.removeAttribute("memId");
        session.removeAttribute("memEmail");
        session.invalidate();
//        request.setAttribute("display", "/member/logout.jsp");
        return "/main/index.do";
    }

}
