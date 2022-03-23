package service;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kr.co.ict.BoardDTO;
import kr.co.ict.UserDAO;
import kr.co.ict.UserVO;

public class UserListManagerService implements boardInterface_Service{

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		
		//add [no access for unauthorize manager option]
		String spNum = request.getParameter("pageNum");
		int pNum =0;
	
		try {
			pNum = Integer.parseInt(spNum);
		}
		catch(Exception e) {
			pNum=1;
		}
		HttpSession session = request.getSession();
		
		String sId = (String)session.getAttribute("session_id");
		
		request.setAttribute("sId", sId);
		
		UserDAO dao = UserDAO.getInstance();
		
		List<UserVO> userList = dao.getAllUserList(pNum);
		
		int userCount = dao.getPageNum();
		
		request.setAttribute("userList", userList);
		
		BoardDTO dto = new BoardDTO(userCount, pNum);
		
		request.setAttribute("dto", dto);
		
		
		
	}

}
