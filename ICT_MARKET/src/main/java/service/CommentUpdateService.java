package service;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.ict.BoardCommentDAO;
import kr.co.ict.BoardCommentVO;
import kr.co.ict.BoardDAO;
import kr.co.ict.BoardVO;

public class CommentUpdateService implements boardInterface_Service{

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		int comment_num = Integer.parseInt(request.getParameter("comment_num"));
		int board_num = Integer.parseInt(request.getParameter("comment_board_num"));
		String comment_content = request.getParameter("comment_content");
		System.out.println(comment_num);
		System.out.println(board_num);
		System.out.println(comment_content);
		request.setAttribute("board_num", board_num);
		
		BoardDAO dao = BoardDAO.getInstance();
		BoardVO boarddetail = dao.getBoardDetail(board_num);
		request.setAttribute("boarddetail", boarddetail);

		
		BoardCommentDAO cDao = BoardCommentDAO.getInstance();
		cDao.updateComment(comment_content, comment_num);		
		List<BoardCommentVO> comment = cDao.getBoardCommentList(board_num);
		request.setAttribute("comment", comment);
	}

}
