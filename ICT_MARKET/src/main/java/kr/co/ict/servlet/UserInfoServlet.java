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
		// dao ����
		UserDAO dao = UserDAO.getInstance();
		// dao���� �ش� �۹�ȣ�� ���� ������ �������� 
		UserVO user = dao.getUserData(user_num);
		// ������ ���Դ��� �����
		 System.out.println(user);
		// �������������� ������(�����̵�)
		 request.setAttribute("user",user);
			
			// 4. /board/boardlist.jsp�� �������ϱ�
			// ������ ��  el�� ���ε��� �ڷḦ ȭ�鿡 �ѷ�������
			RequestDispatcher dp = request.getRequestDispatcher("/users/userinfo.jsp");
			dp.forward(request, response);
			
	}

}
