package service;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kr.co.ict.BoardCommentDAO;

public class CommentDeleteService implements boardInterface_Service{

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		String session_id = (String)session.getAttribute("session_id");
		String comment_id = request.getParameter("comment_id");
		int comment_num = Integer.parseInt(request.getParameter("comment_num"));
		int board_num = Integer.parseInt(request.getParameter("board_num"));

		if(session_id.equals(comment_id)) {
			BoardCommentDAO dao = BoardCommentDAO.getInstance();
			dao.deleteComment(comment_num);			
		}
		
	}

}
