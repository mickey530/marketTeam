package service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kr.co.ict.BoardCommentDAO;

public class CommentInsertService implements boardInterface_Service{

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		HttpSession session = request.getSession();
		String comment_id = (String)session.getAttribute("session_id");
		int board_num = Integer.parseInt(request.getParameter("board_num"));
		String comment_content = request.getParameter("comment_content");
		int page_num = Integer.parseInt(request.getParameter("page_num"));
		
		request.setAttribute("board_num", board_num);
		request.setAttribute("page_num", page_num);
		BoardCommentDAO dao = BoardCommentDAO.getInstance();
		dao.insertComment(comment_id, board_num, comment_content);
	}

}
