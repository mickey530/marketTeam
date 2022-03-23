package service;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kr.co.ict.UserDAO;

public class UserInfoDeleteService implements boardInterface_Service{

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		String user_id = request.getParameter("user_id");
		String struNum = request.getParameter("user_num");
		int uNum = Integer.parseInt(struNum);
		HttpSession session = request.getSession();
		String sId = (String)session.getAttribute("session_id");
		// 1. dao����
		if(sId == user_id) {
		UserDAO dao = UserDAO.getInstance();
		// 2. �������� ����
		dao.deleteUser(uNum);
		session.invalidate();
		}
	}

}
