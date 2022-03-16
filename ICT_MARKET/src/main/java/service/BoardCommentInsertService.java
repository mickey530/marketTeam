package service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.ict.BoardCommentDAO;

public class BoardCommentInsertService implements boardInterface_Service{

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		int board_num = Integer.parseInt(request.getParameter("board_num"));
		BoardCommentDAO dao = BoardCommentDAO.getInstance();
		dao.insertComment(board_num);
	}

}
