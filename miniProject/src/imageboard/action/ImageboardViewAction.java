package imageboard.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.control.CommandProcess;

import board.dao.BoardDAO;
import imageboard.bean.ImageDTO;
import imageboard.dao.ImageDAO;

public class ImageboardViewAction implements CommandProcess {

    @Override
    public String requestPro(HttpServletRequest request, HttpServletResponse response) 
            throws Throwable {
        int seq = Integer.parseInt(request.getParameter("seq"));
        int pg = Integer.parseInt(request.getParameter("pg"));
        ImageDAO imageDAO = ImageDAO.getInstance();
        ImageDTO imageDTO = imageDAO.getImageBoard(seq);
        request.setAttribute("imageDTO", imageDTO);
        request.setAttribute("seq", seq);
        request.setAttribute("pg", pg);
        request.setAttribute("display", "/imageboard/imageboardView.jsp");
        return "/main/index.jsp";
    }

}
