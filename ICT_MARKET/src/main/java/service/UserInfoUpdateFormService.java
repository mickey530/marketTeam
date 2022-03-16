package service;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.ict.UserDAO;
import kr.co.ict.UserVO;

public class UserInfoUpdateFormService implements boardInterface_Service{

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		String struNum = request.getParameter("user_num");
		int uNum = Integer.parseInt(struNum);
		
		UserDAO dao = UserDAO.getInstance();
		// 2. BoardVO ��������
		UserVO user = dao.getUserData(uNum);
		// 3. ������ ������ ���ε�
		request.setAttribute("user", user);
		// 4. �������� ������(boardUpdateForm.jsp)
		
	}

}
