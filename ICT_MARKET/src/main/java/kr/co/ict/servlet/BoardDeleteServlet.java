package kr.co.ict.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.ict.BoardDAO;

/**
 * Servlet implementation class BoardDeleteServlet
 */
@WebServlet("/boardDelete")
public class BoardDeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BoardDeleteServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String boardnum = request.getParameter("board_num");
		int board_num = Integer.parseInt(boardnum);
		
		BoardDAO dao = BoardDAO.getInstance();
		dao.deleteBoard(board_num);

		response.sendRedirect("http://localhost:8181/ICT_MARKET/boardList?board_info=ALL");
//		RequestDispatcher dp = request.getRequestDispatcher("boardList?board_info=ALL");
//		dp.forward(request, response);
	}

}
