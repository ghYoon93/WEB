package imageboard.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.control.CommandProcess;

import imageboard.dao.ImageDAO;

public class ImageboardDeleteAction implements CommandProcess {

    @Override
    public String requestPro(HttpServletRequest request, HttpServletResponse response) 
            throws Throwable {
        String[] list = request.getParameter("seq").split(",");
        ImageDAO imageDAO = ImageDAO.getInstance();
        imageDAO.delete(list);
        int pg = Integer.parseInt(request.getParameter("pg"));
        request.setAttribute("pg", pg);
        request.setAttribute("display", "/imageboard/imageboardDelete.jsp");
        return "/main/index.jsp";
    }

}
