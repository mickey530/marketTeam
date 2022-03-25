package service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kr.co.ict.BoardCommentDAO;
import kr.co.ict.BoardCommentVO;
import kr.co.ict.BoardDAO;
import kr.co.ict.BoardVO;
import kr.co.ict.PickedDAO;
import kr.co.ict.PickedVO;

public class BoardDetailService implements boardInterface_Service {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		String picked_id = (String)session.getAttribute("session_id");
		
		String boardnum = request.getParameter("board_num");
		int board_num = Integer.parseInt(boardnum);
		request.setAttribute("boardnum", boardnum);
		
		BoardDAO dao = BoardDAO.getInstance();
		BoardVO boarddetail = dao.getBoardDetail(board_num);
		String board_info = boarddetail.toString();
		System.out.println(board_info);
		request.setAttribute("boarddetail", boarddetail);
		
		//Pick or not
		PickedDAO pickedDao = PickedDAO.getInstance();
		ArrayList<PickedVO> getPicked = pickedDao.getPicked(picked_id, board_num);
		request.setAttribute("getPicked", getPicked);
		
		BoardCommentDAO cDao = BoardCommentDAO.getInstance();
		List<BoardCommentVO> comment = cDao.getBoardCommentList(board_num);
		request.setAttribute("comment", comment);
		
	}

}
