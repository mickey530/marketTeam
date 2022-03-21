package kr.co.ict.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.ict.UserDAO;

/**
 * Servlet implementation class UserInfoDeleteServlet
 */
@WebServlet("/userInfoDelete")
public class UserInfoDeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserInfoDeleteServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String struNum = request.getParameter("user_num");
		int uNum = Integer.parseInt(struNum);
		
		// 1. dao����
		UserDAO dao = UserDAO.getInstance();
		// 2. �������� ����
		dao.deleteUser(uNum);
		// 3. ������ boardList�� �����̷�Ʈ
		response.sendRedirect("http://localhost:8181/ICT_MARKET/Userlist");
		
	}

}
