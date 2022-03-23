package kr.co.ict.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.ict.BoardCommentDAO;
import kr.co.ict.BoardCommentVO;

/**
 * Servlet implementation class CommentUpdateFormServlet
 */
@WebServlet("/CommentUpdateForm")
public class CommentUpdateFormServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CommentUpdateFormServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int comment_num = Integer.parseInt(request.getParameter("comment_num"));
		BoardCommentDAO dao = BoardCommentDAO.getInstance();
		BoardCommentVO comment = dao.getComment(comment_num);
		
		request.setAttribute("comment", comment);
		RequestDispatcher dp = request.getRequestDispatcher("/board/Comment_update_Form.jsp");
		dp.forward(request, response);
	}

}
