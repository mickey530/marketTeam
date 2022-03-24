package service;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.ict.BoardCommentDAO;
import kr.co.ict.BoardCommentVO;

public class CommentUpdateFormService implements boardInterface_Service{

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int comment_num = Integer.parseInt(request.getParameter("comment_num"));
		int page_num = Integer.parseInt(request.getParameter("page_num"));
		BoardCommentDAO dao = BoardCommentDAO.getInstance();
		BoardCommentVO comment = dao.getComment(comment_num);
		request.setAttribute("comment", comment);
		request.setAttribute("page_num", page_num);
	}

}
