package kr.co.ict.servlet;



import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;



import kr.co.ict.UserDAO;
import kr.co.ict.UserVO;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/ICTL")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		    String fId = request.getParameter("fid");
			String fPw = request.getParameter("fpw");
	
		
			  UserDAO dao = UserDAO.getInstance();
			  UserVO user = dao.getUserData();     
			
		
			 if(user != null){                
				String sId = user.getUser_id();   
				String sPw = user.getUser_pw();   
				
				if(fId.equals(sId) && fPw.equals(sPw)){
					 
					 
					  session.setAttribute("session_id", sId);
					  session.setAttribute("session_pw", sPw);
					
					  response.sendRedirect("http://localhost:8181/ICT_MARKET/users/login_welcome.jsp");
				  }else {
					  response.sendRedirect("http://localhost:8181/ICT_MARKET/users/id_error.jsp");
				  }
			
			} else {
				 response.sendRedirect("http://localhost:8181/ICT_MARKET/users/pw_error.jsp");
			}
	}

}
