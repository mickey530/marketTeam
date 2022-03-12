package kr.co.ict.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.ict.BoardDAO;
import kr.co.ict.BoardVO;

/**
 * Servlet implementation class BoardbuyListServlet
 */
@WebServlet("/boardList")
public class BoardListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BoardListServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String board_info = request.getParameter("board_info");
		BoardDAO dao = BoardDAO.getInstance();
		List<BoardVO> boardList;
		String info;
		
		if(board_info.equals("WTS")) {
			boardList = dao.getAllBoardList(true);
			info = "Want to Sell";
			
		} else if(board_info.equals("WTB")) {
			boardList = dao.getAllBoardList(false);
			info = "Want to Buy";
		} else {
			boardList = dao.getAllBoardList();
			info = "All Products";
		}
				
		request.setAttribute("boardList", boardList);
		request.setAttribute("info", info);
		RequestDispatcher dp = request.getRequestDispatcher("/board/Board_list.jsp");
		dp.forward(request, response);
	}
}
