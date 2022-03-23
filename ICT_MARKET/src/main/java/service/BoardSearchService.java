package service;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.ict.BoardDAO;

public class BoardSearchService implements boardInterface_Service {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		BoardDAO dao = BoardDAO.getInstance();
		
		request.setCharacterEncoding("utf-8");
		
		//Search Keyword
	    String searchkeyword = request.getParameter("search_keyword");
	    
	    //WTS or WTB
	    String sellorbuy = request.getParameter("board_info");
	    Boolean SorB = Boolean.valueOf(sellorbuy).booleanValue();
	    
	    //Search criteria
	    String sCrite = request.getParameter("search_category");
	    
	    //* criteria (OR)
	    //String qOnly = request.getParameter("only");
	    //String qAnd = request.getParameter("and");
	    
	    dao.getsearchBoard(sCrite,SorB,searchkeyword);
	}

}
