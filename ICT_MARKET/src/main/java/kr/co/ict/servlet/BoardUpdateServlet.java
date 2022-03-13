package kr.co.ict.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.ict.BoardDAO;

/**
 * Servlet implementation class BoardUpdateServlet
 */
@WebServlet("/boardUpdate")
public class BoardUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BoardUpdateServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
request.setCharacterEncoding("utf-8");
		
		String board_title= request.getParameter("board_title");
		String board_content= request.getParameter("board_content");
		String board_category = request.getParameter(" board_category");
		String board_amount = request.getParameter("board_amount");
		String board_sold = request.getParameter("board_sold");
		int boardsold = Integer.parseInt(board_sold);
		String user_id = request.getParameter("user_id");

		BoardDAO dao = BoardDAO.getInstance();
		
		response.sendRedirect("http://localhost:8181/ICT_MARKET/board/boarddetail.jsp?board_title=" + board_title);

	}

}
