package kr.co.ict.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kr.co.ict.BoardCommentDAO;

/**
 * Servlet implementation class BoardCommentInsertServlet
 */
@WebServlet("/BoardCommentInsertServlet")
public class BoardCommentInsertServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BoardCommentInsertServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		request.setCharacterEncoding("utf-8");
		String comment_id = (String)session.getAttribute("session_id");
		int board_num = Integer.parseInt(request.getParameter("board_num"));
		String comment_content = request.getParameter("comment_content");
		
		
		BoardCommentDAO dao = BoardCommentDAO.getInstance();
		dao.insertComment(comment_id, board_num, comment_content);
		
		response.sendRedirect("http://localhost:8181/ICT_MARKET/boardDetail?board_num=" + board_num);
	}

}
