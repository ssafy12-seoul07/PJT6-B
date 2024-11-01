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
	private ResponseEntity<Review> writeReview(@ModelAttribute Review review) {
		reviewService.writeReview(review);
		return new ResponseEntity<Review>(review, HttpStatus.CREATED);
	}
	
	//리뷰 목록을 보여주는 메서드(Read)
	@GetMapping("/review")
	private ResponseEntity<List<Review>> list() {
		return new ResponseEntity<>(reviewService.getList(), HttpStatus.OK);
	}
	
	
	//리뷰 하나만 보여주는 메서드(Read)
	@GetMapping("/review/{id}")
	private ResponseEntity<Review> selectOne(@PathVariable("id") int id) {
		Review review = reviewService.getReview(id);
		return new ResponseEntity<>(review, HttpStatus.OK);
	}
	
	//리뷰를 수정하는 메서드(Update)
	@PutMapping("/review/{id}")
	private ResponseEntity<Void> doUpdateForm(@PathVariable("id") int id, @RequestBody Review review) {
		review.setId(id);
		reviewService.modifyReview(review);
		return new ResponseEntity<Void>(HttpStatus.OK);
	}

	//리뷰를 삭제하는 메서드(Delete)
	@DeleteMapping("/review/{id}")
	private ResponseEntity<String> removeReview(@PathVariable("id") int id) {
		boolean isDeleted = reviewService.removeReview(id);
		if(isDeleted) 
			return ResponseEntity.status(HttpStatus.OK).body("Board deleted");
		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed");

	}



}
