package service;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kr.co.ict.UserDAO;

public class UserInfoManagerDeleteService implements boardInterface_Service{

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String struNum = request.getParameter("user_num");
		int uNum = Integer.parseInt(struNum);
		

		UserDAO dao = UserDAO.getInstance();

		dao.deleteUser(uNum);

		}

		
	}


