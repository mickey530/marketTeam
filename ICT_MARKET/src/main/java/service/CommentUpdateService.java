package service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.ict.BoardCommentDAO;

public class CommentUpdateService implements boardInterface_Service{

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		int comment_num = Integer.parseInt(request.getParameter("comment_num"));
		int board_num = Integer.parseInt(request.getParameter("board_num"));
		String comment_content = request.getParameter("comment_content");
		System.out.println(comment_num);
		System.out.println(board_num);
		System.out.println(comment_content);
		request.setAttribute("board_num", board_num);

		String page_num = request.getParameter("page_num");
		request.setAttribute("page_num", page_num);
		
		BoardCommentDAO cDao = BoardCommentDAO.getInstance();
		cDao.updateComment(comment_content, comment_num);		

	}

}
