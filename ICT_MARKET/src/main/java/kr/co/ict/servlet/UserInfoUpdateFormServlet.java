package kr.co.ict.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.ict.UserDAO;
import kr.co.ict.UserVO;

/**
 * Servlet implementation class UserInfoUpdateFormServlet
 */
@WebServlet("/userInfoUpdateForm")
public class UserInfoUpdateFormServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserInfoUpdateFormServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String struNum = request.getParameter("user_num");
		int uNum = Integer.parseInt(struNum);
		
		// ������ư�� �������� ������, �۳���, �۾��� ���� ���Ե� ���·� ����â�� ������ ��
		// ���Ե� ���°� �Ƿ��� ���� �Էµ� �� ��ȣ�� �ش��ϴ� �� ������ DB���� �ڹٷ� �����;� �մϴ�.
		// �� ��ȣ �Է½� �ش� ��ȣ ���� ������ �������� ������ BoardDAO�� getBoardDetail()�� �ۼ��Ǿ� �ֽ��ϴ�.
		
		// 1. dao����
		UserDAO dao = UserDAO.getInstance();
		// 2. BoardVO ��������
		UserVO user = dao.getUserData(uNum);
		// 3. ������ ������ ���ε�
		request.setAttribute("user", user);
		// 4. �������� ������(boardUpdateForm.jsp)
		RequestDispatcher dp = request.getRequestDispatcher("/users/userUpdateForm.jsp");
		dp.forward(request, response);
	}

	}


