package kr.co.ict.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.ict.BoardDAO;

/**
 * Servlet implementation class InsertBoardServlet
 */
@WebServlet("/boardInsert")
public class BoardInsertServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BoardInsertServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
				BoardDAO dao = BoardDAO.getInstance();
				request.setCharacterEncoding("utf-8");
				String user_id =  request.getParameter("user_id");
				Boolean board_info = Boolean.parseBoolean("board_info");//pstmt.setBoolean(2, board_info);
				String board_category = request.getParameter("board_category");
				String board_title = request.getParameter("board_title");
				String board_content = request.getParameter("board_content");
				String board_amount = request.getParameter("board_amount");
				int boardamount = Integer.parseInt(board_amount);
				Boolean board_sold = Boolean.parseBoolean("board_sold");
				//pstmtsetInt(6, board_amount);
				//pstmt.setBoolean(7, board_sold);
				
				dao.insertBoard(user_id, board_info, board_category, board_title,  board_content,
						 boardamount, board_sold);
				
				response.sendRedirect("#");
	}

}
