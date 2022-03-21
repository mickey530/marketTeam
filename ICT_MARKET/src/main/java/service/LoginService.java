package service;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kr.co.ict.UserDAO;
import kr.co.ict.UserVO;

public class LoginService implements boardInterface_Service{

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
				String id = request.getParameter("id");
				String pw = request.getParameter("pw");
				
				
				UserDAO dao = UserDAO.getInstance();
				
				UserVO user = dao.getUserLoginData(id);
				if(user != null){

				String uId = user.getUser_id();// hint * getter
				String uPw = user.getUser_pw();
				System.out.println("DB�� ���� ���̵� : " + uId);
				System.out.println("DB�� ���� ��й�ȣ : " + uPw);

				if(id.equals(uId) && pw.equals(uPw)){

				HttpSession session = request.getSession();
				session.setAttribute("session_id", uId);
				session.setAttribute("session_pw", uPw);
		
		
		
	}

			}	 
				 }
	}
