package kr.co.ict.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kr.co.ict.BoardDAO;
import kr.co.ict.BoardVO;
import kr.co.ict.UserDAO;
import kr.co.ict.UserVO;

/**
 * Servlet implementation class MainInfoServlet
 */
@WebServlet("/main")
public class MainInfoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MainInfoServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	
    	HttpSession session = request.getSession();
		String logornot = (String)session.getAttribute("session_id");
		
		UserDAO udao = UserDAO.getInstance();
		BoardDAO dao = BoardDAO.getInstance();
		
		UserVO myname = udao.getUserData(logornot);
		
		List<BoardVO> boardListsell = dao.getAllBoardList(true);
		List<BoardVO> boardListbuy = dao.getAllBoardList(false);
		
		request.setAttribute("boardListsell", boardListsell);
		request.setAttribute("boardListbuy", boardListbuy);
		request.setAttribute("myname", myname);
		
		RequestDispatcher dp = request.getRequestDispatcher("main.jsp");
		dp.forward(request, response);
    
	}

}
