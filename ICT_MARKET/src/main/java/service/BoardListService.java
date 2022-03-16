package service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.ict.BoardDAO;
import kr.co.ict.BoardVO;

public class BoardListService implements boardInterface_Service {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
	
		String board_info = request.getParameter("board_info");
		BoardDAO dao = BoardDAO.getInstance();
		List<BoardVO> boardList;
		String info;
		
		if(board_info.equals("WTS")) {
			boardList = dao.getAllBoardList(true);
			info = "Want to Sell";
			
		} else if(board_info.equals("WTB")) {
			boardList = dao.getAllBoardList(false);
			info = "Want to Buy";
		} else {
			boardList = dao.getAllBoardList();
			info = "All Products";
		}
				
		request.setAttribute("boardList", boardList);
		request.setAttribute("info", info);
		
	}

}
