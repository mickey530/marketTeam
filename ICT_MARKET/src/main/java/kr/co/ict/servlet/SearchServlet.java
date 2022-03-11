package kr.co.ict.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//import kr.co.ict.UserDAO;
//import kr.co.ict.UserVO;

/**
 * Servlet implementation class SearchServlet
 */
@WebServlet("/search")
public class SearchServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SearchServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		BoardDAO boardao = BoardDAO.getInstance();
		
		request.setCharacterEncoding("utf-8");
		
	    String search = request.getParameter("searchkey");
	    
	    request.setAttribute("search",search);
	   
	    RequestDispatcher dp = request.getRequestDispatcher("/board/Board_search.jsp");
	    
	    dp.forward(request, response);
	}

}
