package com.ssafy.pjt_B.mvc.model.service;

import java.util.List;

import com.ssafy.pjt_B.mvc.model.dao.ReviewDao;
import com.ssafy.pjt_B.mvc.model.dto.Review;

public class ReviewServiceImpl implements ReviewService{
	private final ReviewDao reviewDao;
	
	public ReviewServiceImpl(ReviewDao reviewDao) {
		this.reviewDao = reviewDao;
	}
	
	@Override
	public List<Review> getList() {
		return reviewDao.selectAll();
	}
	
	@Override
	public Review getReview(int id) {
		reviewDao.updateViewCnt(id);
		return reviewDao.selectOne(id);
	}
	
	@Override
	public void writeReview(Review review) {
		reviewDao.insertReview(review);
	}
	
	@Override
	public void modifyReview(Review review) {
		reviewDao.updateReview(review);
	}
	
	@Override
	public void removeReview(int id) {
		reviewDao.deleteReview(id);
	}
	
	
}
