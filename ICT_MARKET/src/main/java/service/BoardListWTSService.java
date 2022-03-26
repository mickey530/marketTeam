package service;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.ict.BoardDAO;
import kr.co.ict.BoardDTO;
import kr.co.ict.BoardVO;

public class BoardListWTSService implements boardInterface_Service {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String boardsold = request.getParameter("board_info");
		System.out.println("Onlysell?"+boardsold);
		
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
			
		info = "Want to Sell";
		infourl = "SaleOnly";
		boardList = dao.getAllOnSaleList(pNum);
		
		request.setAttribute("boardList", boardList);
		
		int allPageNum = dao.getAllPageNum();
		BoardDTO dto = new BoardDTO(allPageNum, pNum);
		request.setAttribute("dto", dto);
		System.out.println(dto);
		
		request.setAttribute("info", info);
		request.setAttribute("infourl", infourl);
	}
	

}
