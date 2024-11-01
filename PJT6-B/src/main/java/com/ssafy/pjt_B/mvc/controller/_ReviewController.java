package com.ssafy.ssafit.controller;

import java.io.IOException;

import com.ssafy.ssafit.model.dto.Review;
import com.ssafy.ssafit.model.service.ReviewService;
import com.ssafy.ssafit.model.service.impl.ReviewServiceImpl;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/review")
public class ReviewController extends HttpServlet{
	private static final long serialVersionUID = 1L;

	//ReviewServiceImpl 의존성 주입
	private ReviewService service = ReviewServiceImpl.getInstance();
	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String action = request.getParameter("action");
		
		switch(action) {
		case "writeform":
			doWriteForm(request, response);
			break;
		case "write":
			doWrite(request, response);
			break;
		case "update":
			doUpdate(request, response);
			break;
		case "list":
			doList(request, response);
			break;
		case "detail":
			doDetail(request, response);
			break;
		case "delete":
			doRemove(request, response);
			break;
		case "updateform":
			doUpdateForm(request, response);
			break;
		default :
			System.out.println("잘못된 접근");
			break;
		}
	}

	//리뷰를 삭제하는 메서드
	private void doRemove(HttpServletRequest request, HttpServletResponse response) throws IOException {
		int id = Integer.parseInt(request.getParameter("id"));

		service.removeReview(id);
		response.sendRedirect("review?action=list");


	}
	
	//리뷰를 수정하는 메서드
	private void doUpdateForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));

		//수정된 리뷰 객체 생성
		Review review = service.getReview(id);
		request.setAttribute("review", review);
		request.getRequestDispatcher("/WEB-INF/views/review/reviewUpdate.jsp").forward(request, response);

	}

	//상세 리뷰 페이지로 이동시키는 메서드
	private void doDetail(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));

		request.setAttribute("review", service.getReview(id));
		request.getRequestDispatcher("/WEB-INF/views/review/detail.jsp").forward(request, response);
	}

	//작성한 리뷰를 객체에 저장하는 메서드
	private void doWrite(HttpServletRequest request, HttpServletResponse response) throws IOException {
		String title = request.getParameter("title");
		String writer = request.getParameter("writer");
		String content = request.getParameter("content");
		
		//객체 생성
		Review review = new Review(title, writer, content);
		//리뷰 저장
		service.writeReview(review);
		//리뷰 목록으로 이동
		response.sendRedirect("review?action=list");
	}

	//리뷰 목록을 보여주는 메서드
	private void doList(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setAttribute("list", service.getList());
		request.getRequestDispatcher("/WEB-INF/views/review/reviewList.jsp").forward(request, response);
		
	}
	//리뷰를 수정하는 페이지로 보내는 메서드
	private void doUpdate(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//id로 수정할 리뷰 객체 생성
		Review review = service.getReview(Integer.parseInt(request.getParameter("id")));
		//리뷰 내용 수정
		review.setTitle(request.getParameter("title"));
		review.setContent(request.getParameter("content"));
		//리뷰 객체 수정
		service.modifyReview(review);
		//리다이렉트
		response.sendRedirect("review?action=list");
		
		
	}
	//리뷰를 작성하는 페이지로 보내는 메서드
	private void doWriteForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("/WEB-INF/views/review/reviewWrite.jsp").forward(request, response);
		
		
	}
	
	
	
}
