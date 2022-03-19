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

public class BoardDetailService implements boardInterface_Service {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String boardnum = request.getParameter("board_num");
		int board_num = Integer.parseInt(boardnum);
		
		BoardDAO dao = BoardDAO.getInstance();
		BoardVO boarddetail = dao.getBoardDetail(board_num);
		request.setAttribute("boarddetail", boarddetail);
		
		BoardCommentDAO cDao = BoardCommentDAO.getInstance();
		List<BoardCommentVO> comment = cDao.getBoardCommentList(board_num);
		request.setAttribute("comment", comment);
		
	}

}
