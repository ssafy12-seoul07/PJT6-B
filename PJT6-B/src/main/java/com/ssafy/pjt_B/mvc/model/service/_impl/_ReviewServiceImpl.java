package com.ssafy.ssafit.model.service.impl;

import java.util.List;

import com.ssafy.ssafit.model.dto.Review;
import com.ssafy.ssafit.model.repository.ReviewRepository;
import com.ssafy.ssafit.model.repository.impl.ReviewRepositoryImpl;
import com.ssafy.ssafit.model.service.ReviewService;

public class ReviewServiceImpl implements ReviewService{

	private static ReviewService service = new ReviewServiceImpl();
	private ReviewRepository repo = ReviewRepositoryImpl.getInstance();
	private ReviewServiceImpl() {}

	public static ReviewService getInstance() {
		return service;
	}
	
	@Override
	public List<Review> getList() {
		return repo.selectAll();
	
	}
	@Override
	public Review getReview(int id) {
		repo.updateViewCnt(id);
		return repo.selectOne(id);
	}
	
	@Override
	public void writeReview(Review review) {
		repo.insertReview(review);
	}
	
	@Override
	public void modifyReview(Review review) {
		repo.updateReview(review);
	}
	
	@Override
	public void removeReview(int id) {
		repo.deleteReview(id);
	}
	
	
}
