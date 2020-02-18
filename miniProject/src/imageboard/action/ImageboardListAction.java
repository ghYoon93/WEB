package imageboard.action;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.control.CommandProcess;

import imageboard.bean.ImageBoardPaging;
import imageboard.bean.ImageDTO;
import imageboard.dao.ImageDAO;

public class ImageboardListAction implements CommandProcess {
    public String requestPro(HttpServletRequest request, HttpServletResponse response) 
            throws Throwable {
    	String path = request.getServletContext().getRealPath("/storage");
        int pg = Integer.parseInt(request.getParameter("pg")); 
        int endNum = pg*3; 
        int startNum = endNum-2;
        Map<String, Integer> map = new HashMap<String, Integer>();
        map.put("startNum", startNum);
        map.put("endNum", endNum);
        ImageDAO imageDAO = ImageDAO.getInstance();
        List<ImageDTO> list = imageDAO.imageboardList(map);
        int totalA = imageDAO.getImageBoardTotalA();
        ImageBoardPaging imageBoardPaging = new ImageBoardPaging();
        imageBoardPaging.setCurrentPage(pg);
        imageBoardPaging.setPageBlock(3);
        imageBoardPaging.setPageSize(3);
        imageBoardPaging.setTotalA(totalA);
        
        imageBoardPaging.makePagingHTML();

        HttpSession session = request.getSession();
        if(session.getAttribute("memId")!=null) {
            Cookie cookie = new Cookie("memHit", "0");
            cookie.setMaxAge(30*60);
            response.addCookie(cookie);
        }
        request.setAttribute("path", path);
        request.setAttribute("list", list);
        request.setAttribute("imageBoardPaging", imageBoardPaging);
        request.setAttribute("display", "/imageboard/imageboardList.jsp?pg="+pg);
 
        return "/main/index.jsp";
    }

}
