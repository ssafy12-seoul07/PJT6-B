package com.ssafy.pjt_B.mvc.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ssafy.pjt_B.mvc.model.dto.Review;
import com.ssafy.pjt_B.mvc.model.service.ReviewService;

@RestController
@RequestMapping("/api-review")
public class ReviewController {

	//ReviewServiceImpl 의존성 주입
	private ReviewService reviewService;
	
	public ReviewController(ReviewService reviewService) {
		this.reviewService = reviewService;
	
	}

	//리뷰를 등록하는 메서드(Create)
	@PostMapping("/review")
	private ResponseEntity<String> write(@ModelAttribute Review review) {
		int result = reviewService.writeReview(review);
		if(result > 0) 
			return ResponseEntity.status(HttpStatus.CREATED).body("review created");
		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("writeReview failed");
	}
	
	//리뷰 목록을 보여주는 메서드(Read)
	@GetMapping("/review")
	private ResponseEntity<List<Review>> list() {
		List<Review> list = reviewService.getList();
		if(list.size() != 0)
			return new ResponseEntity<>(list, HttpStatus.OK);
		return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	
	//리뷰 하나만 보여주는 메서드(Read)
	@GetMapping("/review/{id}")
	private ResponseEntity<Review> selectOne(@PathVariable("id") int id) {
		Review review = reviewService.getReview(id);
		if(review != null)
			return new ResponseEntity<>(review, HttpStatus.OK);
		return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	//리뷰를 수정하는 메서드(Update)
	@PutMapping("/review/{id}")
	private ResponseEntity<String> update(@PathVariable("id") int id, @ModelAttribute Review review) {
		review.setId(id);
		int result = reviewService.modifyReview(review);
		if(result > 0) return ResponseEntity.status(HttpStatus.OK).body("review updated");
		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("update failed");
	}

	//리뷰를 삭제하는 메서드(Delete)
	@DeleteMapping("/review/{id}")
	private ResponseEntity<String> remove(@PathVariable("id") int id) {
		int result = reviewService.removeReview(id);
		if(result>0) 
			return ResponseEntity.status(HttpStatus.OK).body("review deleted");
		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("delete failed");
	}



}
