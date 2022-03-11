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
				String board_title = request.getParameter("title");
				String board_content = request.getParameter("content");
				
				// data check
				System.out.println(board_title);
				System.out.println(board_content);
				
				String boardAmount = request.getParameter("board_amount");
				int board_amount = Integer.parseInt(boardAmount);
				

				dao.insertBoard(user_id, board_info, board_category, board_title, board_content, board_amount);

//				response.sendRedirect("#");
		
		
	}

}
