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
 * Servlet implementation class UserInfoServlet
 */
@WebServlet("/userInfo")
public class UserInfoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserInfoServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String usernum = request.getParameter("user_num");
		int user_num = Integer.parseInt(usernum);
		System.out.println(user_num);
		// dao 생성
		UserDAO dao = UserDAO.getInstance();
		// dao에서 해당 글번호에 대한 정보를 가져오고 
		UserVO user = dao.getUserData(user_num);
		// 정보가 들어왔는지 디버깅
		 System.out.println(user);
		// 디테일페이지로 포워딩(조금이따)
		 request.setAttribute("user",user);
			
			// 4. /board/boardlist.jsp로 포워딩하기
			// 포워딩 후  el로 바인딩한 자료를 화면에 뿌려보세요
			RequestDispatcher dp = request.getRequestDispatcher("/users/userinfo.jsp");
			dp.forward(request, response);
			
	}

}
