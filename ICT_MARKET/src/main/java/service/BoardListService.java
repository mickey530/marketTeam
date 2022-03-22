package service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.ict.BoardDAO;
import kr.co.ict.BoardDTO;
import kr.co.ict.BoardVO;

public class BoardListService implements boardInterface_Service {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		
		
		String board_info = request.getParameter("board_info");
		
		BoardDAO dao = BoardDAO.getInstance();
		List<BoardVO> boardList;
		String info;
		String infourl;
		String strpNum = request.getParameter("PageNum");
		int pNum = 0;
		try {
			pNum = Integer.parseInt(strpNum);
		}catch(Exception e) {
			pNum = 1;
		}
		
		if(board_info.equals("WTS")) {
			boardList = dao.getAllBoardList(true,pNum);
			info = "Want to Sell";
			infourl = "WTS";
			
		} else if(board_info.equals("WTB")) {
			boardList = dao.getAllBoardList(false,pNum);
			info = "Want to Buy";
			infourl = "WTB";
		} else {
			boardList = dao.getAllBoardList(pNum);
			info = "All Products";
			infourl = "ALL";
		}
				
		request.setAttribute("boardList", boardList);
		
		int allPageNum = dao.getAllPageNum();
		BoardDTO dto = new BoardDTO(allPageNum, pNum);
		request.setAttribute("dto", dto);
		System.out.println(dto);
		
		request.setAttribute("info", info);
		request.setAttribute("infourl", infourl);
	}

}
