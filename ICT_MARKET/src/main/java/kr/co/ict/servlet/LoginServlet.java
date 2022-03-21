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

import org.apache.tomcat.jni.User;

import kr.co.ict.UserDAO;
import kr.co.ict.UserVO;

import kr.co.ict.BoardDAO;
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
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		    String id = request.getParameter("id");
			String pw = request.getParameter("pw");
			
			
			UserDAO dao = UserDAO.getInstance();
			
			 UserVO user = dao.getUserLoginData(id);
			 if(user != null){

					String uId = user.getUser_id();// hint * getter
					String uPw = user.getUser_pw();

					if(id.equals(uId) && pw.equals(uPw)){

						HttpSession session = request.getSession();
						session.setAttribute("session_id", uId);
						session.setAttribute("session_pw", uPw);
						RequestDispatcher dp = request.getRequestDispatcher("/Main_bk.jsp");
						dp.forward(request, response);

					} else {
						response.sendRedirect("http://localhost:8181/ICT_MARKET/users/pw_error.jsp");
						
					}
					
				} else {
					response.sendRedirect("http://localhost:8181/ICT_MARKET/users/id_error.jsp");
				}
	}
}
		
			
			
				 	
			    
	
			


