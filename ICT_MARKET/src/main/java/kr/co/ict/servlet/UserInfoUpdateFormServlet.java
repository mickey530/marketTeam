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
		
		// 수정버튼을 눌렀을때 글제목, 글내용, 글쓴이 등이 기입된 상태로 수정창이 열려야 함
		// 기입된 상태가 되려면 먼저 입력된 글 번호에 해당하는 글 정보를 DB에서 자바로 가져와야 합니다.
		// 글 번호 입력시 해당 번호 글의 정보를 가져오는 로직은 BoardDAO의 getBoardDetail()에 작성되어 있습니다.
		
		// 1. dao생성
		UserDAO dao = UserDAO.getInstance();
		// 2. BoardVO 가져오기
		UserVO user = dao.getUserData(uNum);
		// 3. 가져온 데이터 바인딩
		request.setAttribute("user", user);
		// 4. 목적지로 포워딩(boardUpdateForm.jsp)
		RequestDispatcher dp = request.getRequestDispatcher("/users/userUpdateForm.jsp");
		dp.forward(request, response);
	}

	}


