package kr.co.ict.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.ict.BoardCommentDAO;

/**
 * Servlet implementation class BoardCommentUpdateServlet
 */
@WebServlet("/CommentUpdate")
public class CommentUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CommentUpdateServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		int comment_num = Integer.parseInt(request.getParameter("comment_num"));
		int comment_board_num = Integer.parseInt(request.getParameter("comment_board_num"));
		String comment_content = request.getParameter("comment_content");
		
		BoardCommentDAO dao = BoardCommentDAO.getInstance();
		dao.updateComment(comment_content, comment_num);
			
		response.sendRedirect("http://localhost:8181/ICT_MARKET/boardDetail?board_num=" + comment_board_num);
	}

}
