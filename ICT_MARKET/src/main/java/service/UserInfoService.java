package service;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.ict.UserDAO;
import kr.co.ict.UserVO;

public class UserInfoService implements boardInterface_Service{

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
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
		
	}

}
