package member.action;

import java.util.HashMap;
import java.util.Map;

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
        Map<String,String> map = new HashMap<String, String>();
        map.put("id",id);
        map.put("pwd",pwd);
        //DB
        MemberDAO memberDAO = MemberDAO.getInstance();
        MemberDTO memberDTO = memberDAO.login(map);
        
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
            }
            System.out.println(request.getAttribute("error"));
            return "/main/index.jsp";
        }else {
              request.setAttribute("error", "error");
              request.setAttribute("display", "../template/body.jsp");
            return "/main/index.jsp";
        }
    }
}
