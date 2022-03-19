package service;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kr.co.ict.UserDAO;
import kr.co.ict.UserVO;

public class UserListManagerService implements boardInterface_Service{

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		
		//add [no access for unauthorize manager option]
		
		HttpSession session = request.getSession();
		
		String sId = (String)session.getAttribute("session_id");
		
		request.setAttribute("sId", sId);
		
		UserDAO dao = UserDAO.getInstance();
		
		List<UserVO> userList = dao.getAllUserList();
		
		request.setAttribute("userList", userList);
		
	}

}
