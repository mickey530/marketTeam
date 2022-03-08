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
			// form에서 받아온 데이터 
		    String fId = request.getParameter("fid");
			String fPw = request.getParameter("fpw");
			
			UserDAO dao = UserDAO.getInstance();
			UserVO user = dao.getUserData(fId);
	
			// 유저 아이디와 비밀번호가 DB에 있는 데이터와 일치한다면
			if(fId.equals(user.getUser_id()) && fPw.equals(user.getUser_pw())) {
				// 세션 발급
				HttpSession session = request.getSession(); 
				session.setAttribute("sId", fId);
				System.out.println("로그인에 성공했습니다.");
				response.sendRedirect("http://localhost:8181/ICT_MARKET/");
			} else {
				// 일치하지 않는다면
				// arlert로 로그인 실패 메세지 띄운 뒤 다시 로그인 페이지로 리다이렉트 할 예정
				System.out.println("로그인에 실패했습니다.");
				response.sendRedirect("http://localhost:8181/ICT_MARKET/users/login_form.jsp");
			}
		
			

			
			// 포워딩이 필요한가?
			RequestDispatcher dp = request.getRequestDispatcher("users/login_check.jsp");
			dp.forward(request, response);
	}

}
