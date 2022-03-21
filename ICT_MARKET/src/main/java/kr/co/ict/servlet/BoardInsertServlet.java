package kr.co.ict.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

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
				
				HttpSession session = request.getSession();
				String sId = (String)session.getAttribute("session_id");
				
				String boardInfo = request.getParameter("board_info");
				System.out.println("fuckfuck "+boardInfo);
				Boolean board_info = Boolean.valueOf(boardInfo).booleanValue() ;
				System.out.println("test "+board_info);
				
				String board_category = request.getParameter("board_category");
				String board_title = request.getParameter("board_title");
				String board_content = request.getParameter("board_content");
				String boardAmount = request.getParameter("board_amount");
				int board_amount = Integer.parseInt(boardAmount); // casting
				
				dao.insertBoard(sId, board_info, board_category, board_title, board_content, board_amount);
				response.sendRedirect("http://localhost:8181/ICT_MARKET/boardList?board_info=ALL");
		
	}

}
