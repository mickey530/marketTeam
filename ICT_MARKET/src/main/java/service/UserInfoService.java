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
		// dao ����
		UserDAO dao = UserDAO.getInstance();
		// dao���� �ش� �۹�ȣ�� ���� ������ �������� 
		UserVO user = dao.getUserData(user_num);
		// ������ ���Դ��� �����
		 System.out.println(user);
		// �������������� ������(�����̵�)
		 request.setAttribute("user",user);
		
	}

}
