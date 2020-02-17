package board.action;

import java.util.List;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.control.CommandProcess;

import board.bean.BoardDTO;
import board.bean.BoardPaging;
import board.dao.BoardDAO;

public class BoardListAction implements CommandProcess {

    @Override
    public String requestPro(HttpServletRequest request, HttpServletResponse response) 
            throws Throwable {
        // 데이터
        int pg = Integer.parseInt(request.getParameter("pg")); 
        
        // DB
        int endNum = pg*5; 
        int startNum = endNum-4;
        BoardDAO boardDAO = BoardDAO.getInstance(); 
        List<BoardDTO> list = boardDAO.boardList(startNum, endNum);
        int totalA = boardDAO.getBoardTotalA();
        
        // 응답
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
        
        request.setAttribute("list", list);
        request.setAttribute("boardPaging", boardPaging);
        request.setAttribute("display", "/board/boardList.jsp?pg="+pg);
 
        return "/main/index.jsp";
    }

}
