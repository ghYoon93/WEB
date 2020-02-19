package board.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.control.CommandProcess;

import board.dao.BoardDAO;

public class BoardDeleteAction implements CommandProcess {

    @Override
    public String requestPro(HttpServletRequest request, HttpServletResponse response) throws Throwable {
        int seq = Integer.parseInt(request.getParameter("seq"));
        int pg = Integer.parseInt(request.getParameter("pg"));
        BoardDAO boardDAO = BoardDAO.getInstance();
        boardDAO.boardDelete(seq);
        request.setAttribute("pg", pg);
        request.setAttribute("display", "/board/boardDelete.jsp");
        return "/main/index.jsp";
    }

}
