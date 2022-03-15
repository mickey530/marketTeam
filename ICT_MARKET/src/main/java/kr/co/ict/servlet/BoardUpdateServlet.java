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
		String Num = request.getParameter("board_num");
		int board_num = Integer.parseInt(Num); // casting
		String info = request.getParameter("board_info");
		Boolean board_info = Boolean.parseBoolean(info); // casting
		String board_category = request.getParameter("board_category");
		String board_title= request.getParameter("board_title");
		String board_content= request.getParameter("board_content");
		String price = request.getParameter("board_amount");
		int board_amount = Integer.parseInt(price); // casting
		
		System.out.println(board_num);
		System.out.println(board_title);
		System.out.println(board_category);
		System.out.println(board_content);
		System.out.println(board_amount);
		
		BoardDAO dao = BoardDAO.getInstance();
		dao.updateBoard(board_num, board_title, board_category, board_info, board_content, board_amount);
		
		response.sendRedirect("http://localhost:8181/ICT_MARKET/boardDetail?board_num=" + board_num);

	}

}
