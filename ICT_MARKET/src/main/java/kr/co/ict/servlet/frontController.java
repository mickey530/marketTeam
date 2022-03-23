package kr.co.ict.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.CommentInsertService;
import service.BoardDeleteService;
import service.BoardDetailService;
import service.BoardInsertFormService;
import service.BoardInsertService;
import service.BoardListService;
import service.BoardSearchService;
import service.BoardUpdateFormService;
import service.BoardUpdateService;
import service.JoinService;
import service.LoginService;
import service.LogoutService;
import service.MainService;
import service.UserInfoDeleteService;
import service.UserInfoManagerDeleteService;
import service.UserInfoManagerService;
import service.UserInfoService;
import service.UserInfoUpdateFormService;
import service.UserInfoUpdateService;
import service.UserListManagerService;
import service.boardInterface_Service;

/**
 * Servlet implementation class frontController
 */
@WebServlet("*.com")
public class frontController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public frontController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doRequest(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doRequest(request, response);
	}
	private void doRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");	
		String uri = request.getRequestURI();
		String ui = null;
		boardInterface_Service is = null;
		
		if (uri.equals("/ICT_MARKET/main.com")) {
			is = new MainService();
			is.execute(request, response);
			ui = "/main.jsp";
		}else if (uri.equals("/ICT_MARKET/userJoin.com")) {
			is = new JoinService();
			is.execute(request, response);
			ui = "/users/join_form.jsp";
		}else if (uri.equals("/ICT_MARKET/userLogin.com")) {
			is = new LoginService();
			is.execute(request, response);
			ui = "/users/login_form.jsp";
		}else if (uri.equals("/ICT_MARKET/userJoinCheck.com")) {
			is = new JoinService();
			is.execute(request, response);
			ui = "/";
		}else if (uri.equals("/ICT_MARKET/userLoginCheck.com")) {
			is = new LoginService();
			is.execute(request, response);
			ui = "/";
		}else if (uri.equals("/ICT_MARKET/userLogout.com")) {
			is = new LogoutService();
			is.execute(request, response);
			ui = "/main.com";
		}else if (uri.equals("/ICT_MARKET/userInfo.com")) {
			is = new UserInfoService();
			is.execute(request, response);
			ui = "/users/userinfo.jsp";
		}
		else if (uri.equals("/ICT_MARKET/userInfoManager.com")) {
			is = new UserInfoManagerService();
			is.execute(request, response);
			ui = "/users/manager_userinfo.jsp";
		}
		else if (uri.equals("/ICT_MARKET/userInfoDelete.com")) {
			is = new UserInfoDeleteService();
			is.execute(request, response);
			ui = "/main.com";
		}
		else if (uri.equals("/ICT_MARKET/userInfoManagerDelete.com")) {
			is = new UserInfoManagerDeleteService();
			is.execute(request, response);
			ui = "/main.com";
		}
		else if (uri.equals("/ICT_MARKET/userInfoUpdateForm.com")) {
			is = new UserInfoUpdateFormService();
			is.execute(request, response);
			ui = "/users/userUpdateForm.jsp";
		}else if (uri.equals("/ICT_MARKET/userInfoUpdate.com")) {
			is = new UserInfoUpdateService();
			is.execute(request, response);
			ui = "/userInfo.com";
		}else if (uri.equals("/ICT_MARKET/userList.com")) {
			is = new UserListManagerService();
			is.execute(request, response);
			ui = "/users/userlist.jsp";
		}else if (uri.equals("/ICT_MARKET/boardList.com")) {
			is = new BoardListService();
			is.execute(request, response);
			ui = "/board/Board_list.jsp?board_info=" + request.getParameter("board_info");
		}else if (uri.equals("/ICT_MARKET/boardDetail.com")) {
			is = new BoardDetailService();
			is.execute(request, response);
			ui = "/board/board_detail.jsp";
		}else if (uri.equals("/ICT_MARKET/boardInsertForm.com")) {
			is = new BoardInsertFormService();
			is.execute(request, response);
			ui = "/board/Board_Insertform.jsp";
		}else if (uri.equals("/ICT_MARKET/boardInsert.com")) {
			is = new BoardInsertService();
			is.execute(request, response);
			ui = "/boardList.com";
		}else if (uri.equals("/ICT_MARKET/boardUpdateForm.com")) {
			is = new BoardUpdateFormService();
			is.execute(request, response);
			ui = "/board/boardUpdateForm.jsp";
		}else if (uri.equals("/ICT_MARKET/boardUpdate.com")) {
			is = new BoardUpdateService();
			is.execute(request, response);
			ui = "/ICT_MARKET/boardDetail.com?board_num=" + request.getParameter("board_num");
		}else if (uri.equals("/ICT_MARKET/boardDelete.com")) {
			is = new BoardDeleteService();
			is.execute(request, response);
			ui = "/ICT_MARKET/boardList.com";

		}else if (uri.equals("/ICT_MARKET/boardSearchResult.com?"+ request.getParameter("search_keyword"))){
			is = new BoardSearchService();
			is.execute(request, response);
			ui = "/board/Board_search.jsp";
		}
		
		RequestDispatcher dp = request.getRequestDispatcher(ui);
		dp.forward(request, response);	
	}
}
