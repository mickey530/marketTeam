package service;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.ict.BoardCommentDAO;

public class CommentUpdateService implements boardInterface_Service{

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		int comment_num = Integer.parseInt(request.getParameter("comment_num"));
		int comment_board_num = Integer.parseInt(request.getParameter("comment_board_num"));
		String comment_content = request.getParameter("comment_content");
		
		BoardCommentDAO dao = BoardCommentDAO.getInstance();
		dao.updateComment(comment_content, comment_num);		
	}

}
