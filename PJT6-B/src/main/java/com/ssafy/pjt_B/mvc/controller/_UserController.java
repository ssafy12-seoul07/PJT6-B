package com.ssafy.ssafit.controller;

import java.io.IOException;
import java.io.PrintWriter;

import com.ssafy.ssafit.model.dto.User;
import com.ssafy.ssafit.model.service.UserService;
import com.ssafy.ssafit.model.service.impl.UserServiceImpl;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/user")
public class UserController extends HttpServlet{

	private static final long serialVersionUID = 2L;
	
	private static UserService service = UserServiceImpl.getInstance();

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String action = req.getParameter("action");
		
		switch(action) {
		case "loginForm":
			doLoginForm(req, resp);
			break;
		case "signupForm":
			doSignupForm(req, resp);
			break;
		case "login":
			doLogin(req, resp);
			break;
		case "loginSuccess":
			successPage(req, resp);
			break;
		case "signRegist":
			doSignRegist(req, resp);
			break;
		default:
			System.out.println("재확인 필요");
			break;
		}
	}

	
	private void doSignRegist(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String userId = req.getParameter("userid");
		String password = req.getParameter("pw");
		String userName = req.getParameter("userName");
		String nickName = req.getParameter("nickName");
		
		User user = new User();
		user.setUserId(userId);
		user.setPassword(password);
		user.setUserName(userName);
		user.setNickName(nickName);
		
		resp.setContentType("text/html; charset=UTF-8");
		
		if(!service.signup(user)) {
			req.setAttribute("joinError", "회원가입 실패");
			req.getRequestDispatcher("/WEB-INF/views/user/signup.jsp").forward(req, resp);
			return;
		} else {
			// 회원가입 성공
			req.setAttribute("joinOK", "회원가입 성공");
			req.getRequestDispatcher("/WEB-INF/views/user/login.jsp").forward(req, resp);
		}
		
	}

	private void successPage(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.getRequestDispatcher("${pageContext.request.contextPath}/main").forward(req, resp);
	}

	private void doLogin(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
		// id, pw 확인
		String id = req.getParameter("id");
		String pw = req.getParameter("password");
		
		User user = service.login(id, pw);
//		System.out.println(service.login(id, pw));
//		System.out.println("id : " + id);
//		System.out.println("pw : " + pw);
		
		if (user == null) {
			resp.setContentType("text/html; charset=UTF-8");
			req.setAttribute("loginError", "로그인 실패");
			req.getRequestDispatcher("/WEB-INF/views/user/login.jsp").forward(req, resp);	
			return;
		}
		
		resp.sendRedirect(req.getContextPath() + "/main");

	}

	private void doSignupForm(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// 회원가입 페이지 이동
		req.getRequestDispatcher("/WEB-INF/views/user/signup.jsp").forward(req, resp);
		
	}

	private void doLoginForm(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// 로그인 페이지 이동
		req.getRequestDispatcher("/WEB-INF/views/user/login.jsp").forward(req, resp);
		
	}

}
