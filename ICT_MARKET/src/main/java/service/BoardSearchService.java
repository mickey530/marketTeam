package service;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.ict.BoardDAO;
import kr.co.ict.BoardDTO;
import kr.co.ict.BoardVO;

public class BoardSearchService implements boardInterface_Service {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		BoardDAO dao = BoardDAO.getInstance();
		List<BoardVO> searchResult = null;
		int searchResultNum = 0;
		 
		request.setCharacterEncoding("utf-8");
		
		//Seaech where?
		String searchwhere = request.getParameter("search_where");
		
		//Search Keyword
	    String searchkeyword = request.getParameter("search_keyword");
	    
	    //WTS or WTB
	    String sellorbuy;
	    Boolean SorB;
	    
	    String strpNum = request.getParameter("PageNum");
		int pNum = 0;
		try {
			pNum = Integer.parseInt(strpNum);
		}catch(Exception e) {
			pNum = 1;
		}
	    
	    //* criteria (OR)
	    //String qOnly = request.getParameter("only");
	    //String qAnd = request.getParameter("and");
	    
	    if(searchwhere.equals("board")) {
	   
	    sellorbuy = request.getParameter("board_info");
		SorB = Boolean.valueOf(sellorbuy).booleanValue();
		    
	    searchResult = dao.getSearchBoard(SorB, searchkeyword, pNum);
	    searchResultNum = dao.getsearchCount(SorB, searchkeyword);
	    
	    }else if(searchwhere.equals("header")) {
	    
	    searchResult = dao.getsearchBoardhead(searchkeyword, pNum);
	    searchResultNum = dao.getsearchheadCount(searchkeyword);
	    }
	    
	    int allPageNum = dao.getAllPageNum();
		BoardDTO dto = new BoardDTO(allPageNum, pNum);
		request.setAttribute("dto", dto);
	    
	    request.setAttribute("searchResult", searchResult);
	    request.setAttribute("searchResultNum", searchResultNum);
	}
}
