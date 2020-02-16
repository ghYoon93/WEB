package imageboard.action;

import java.util.List;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.control.CommandProcess;

import board.bean.BoardPaging;
import imageboard.bean.ImageDTO;
import imageboard.dao.ImageDAO;

public class ImageboardListAction implements CommandProcess {
    public String requestPro(HttpServletRequest request, HttpServletResponse response) 
            throws Throwable {
    	String path = request.getServletContext().getRealPath("/storage");
        int pg = Integer.parseInt(request.getParameter("pg")); 
        int endNum = pg*5; 
        int startNum = endNum-4;
        ImageDAO imageDAO = ImageDAO.getInstance();
        List<ImageDTO> list = imageDAO.imageboardList(startNum, endNum);
        int totalA = imageDAO.getBoardTotalA();
        BoardPaging boardPaging = new BoardPaging();
        boardPaging.setCurrentPage(pg);
        boardPaging.setPageBlock(3);
        boardPaging.setPageSize(5);
        boardPaging.setTotalA(totalA);
        
        boardPaging.makePagingHTML();

        HttpSession session = request.getSession();
        if(session.getAttribute("memId")!=null) {
            Cookie cookie = new Cookie("memHit", "0");
            cookie.setMaxAge(30*60);
            response.addCookie(cookie);
        }
        request.setAttribute("path", path);
        request.setAttribute("list", list);
        request.setAttribute("boardPaging", boardPaging);
        request.setAttribute("display", "/imageboard/imageboardList.jsp?pg="+pg);
 
        return "/main/index.jsp";
    }

}
