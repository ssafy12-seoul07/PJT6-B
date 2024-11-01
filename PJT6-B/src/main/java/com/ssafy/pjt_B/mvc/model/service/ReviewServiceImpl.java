package com.ssafy.pjt_B.mvc.model.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.ssafy.pjt_B.mvc.model.dao.ReviewDao;
import com.ssafy.pjt_B.mvc.model.dto.Review;
@Service
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
		return reviewDao.selectOne(id);
	}
	
	@Override
	public int writeReview(Review review) {
		int result = reviewDao.insertReview(review);
		return result;
	}
	
	@Override
	public int modifyReview(Review review) {
		int result = reviewDao.updateReview(review);
		return result;
	}
	
	@Override
	public int removeReview(int id) {
		int result = reviewDao.deleteReview(id);
		return result;
	}
	
	
}
