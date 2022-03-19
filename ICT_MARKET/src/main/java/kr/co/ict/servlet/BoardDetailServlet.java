package kr.co.ict.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.ict.BoardCommentDAO;
import kr.co.ict.BoardCommentVO;
import kr.co.ict.BoardDAO;
import kr.co.ict.BoardVO;

/**
 * Servlet implementation class BoardDetailServlet
 */
@WebServlet("/boardDetail")
public class BoardDetailServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BoardDetailServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

				String boardnum = request.getParameter("board_num");
				int board_num = Integer.parseInt(boardnum);
				
				BoardDAO dao = BoardDAO.getInstance();
				BoardVO boarddetail = dao.getBoardDetail(board_num);
				request.setAttribute("boarddetail", boarddetail);
				
				BoardCommentDAO cDao = BoardCommentDAO.getInstance();
				List<BoardCommentVO> comment = cDao.getBoardCommentList(board_num);
				request.setAttribute("comment", comment);

				
				RequestDispatcher dp = request.getRequestDispatcher("/board/board_detail.jsp");
				dp.forward(request, response);
	}

}
