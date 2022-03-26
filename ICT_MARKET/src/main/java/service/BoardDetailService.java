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
import kr.co.ict.BoardDTO;
import kr.co.ict.BoardVO;
import kr.co.ict.PickedDAO;
import kr.co.ict.PickedVO;

public class BoardDetailService implements boardInterface_Service {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// comment page
		String spNum = request.getParameter("page_num");
		int pNum = 0;
	
		try {
			pNum = Integer.parseInt(spNum);
		}
		catch(Exception e) {
			pNum=1;
		}
		
		request.setAttribute("page_num", pNum);
		
		int board_num = Integer.parseInt(request.getParameter("board_num"));
		request.setAttribute("board_num", board_num);

		HttpSession session = request.getSession();
		String picked_id = (String)session.getAttribute("session_id");
		
		BoardDAO dao = BoardDAO.getInstance();
		BoardVO boarddetail = dao.getBoardDetail(board_num);
		String board_info = boarddetail.toString();
		System.out.println(board_info);
		request.setAttribute("boarddetail", boarddetail);
		
		//Pick or not
		PickedDAO pickedDao = PickedDAO.getInstance();
		ArrayList<PickedVO> getPicked = pickedDao.getPicked(picked_id, board_num);
		request.setAttribute("getPicked", getPicked);
		System.out.println(getPicked);
		
		BoardCommentDAO cDao = BoardCommentDAO.getInstance();
		List<BoardCommentVO> comment = cDao.getBoardCommentList(board_num, pNum);
		request.setAttribute("comment", comment);
		
		int number_of_comment = cDao.getNumberOfComment(board_num);
		BoardDTO dto = new BoardDTO(number_of_comment, pNum);
		request.setAttribute("dto", dto);
		
	}

}
