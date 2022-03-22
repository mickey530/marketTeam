package service;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.ict.UserDAO;
import kr.co.ict.UserVO;

public class UserInfoManagerService implements boardInterface_Service{

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String suNum = request.getParameter("user_num");
		System.out.println(suNum);
		int uNum = 0;
		if(suNum != null) {
			uNum = Integer.parseInt(suNum);
		}
		else {
			uNum = 1;
		}
		
		UserDAO dao = UserDAO.getInstance();
		UserVO user = dao.getUserDataManager(uNum);
		request.setAttribute("user", user);
		
	}

}
