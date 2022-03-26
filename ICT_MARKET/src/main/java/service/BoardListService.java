package service;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.ict.BoardDAO;
import kr.co.ict.BoardDTO;
import kr.co.ict.BoardVO;

public class BoardListService implements boardInterface_Service {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// protect null point error
		String board_info = "ALL";
		if(request.getParameter("board_info") != null) {
			board_info = request.getParameter("board_info");
		}
		
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
			info = "Want to Sell";
			infourl = "WTS";
			boardList = dao.getAllBoardList(true,pNum);
		} else if(board_info.equals("WTB")) {
			info = "Want to Buy";
			infourl = "WTB";
			boardList = dao.getAllBoardList(false,pNum);
		}else if(board_info.equals("ALL")){
			info = "All Products";
			infourl = "ALL";
			boardList = dao.getAllBoardList(pNum);
		}else{
			info = "Want to Sell";
			infourl = "SaleOnly";
			boardList = dao.getAllOnSaleList(pNum);
		}
		
				
		request.setAttribute("boardList", boardList);
		
		int allPageNum = dao.getAllPageNum();
		BoardDTO dto = new BoardDTO(allPageNum, pNum);
		request.setAttribute("dto", dto);
		System.out.println(dto);
		
		request.setAttribute("info", info);
		request.setAttribute("infourl", infourl);
		request.setAttribute("board_info", board_info);
	
	}
	}
	

