package com.ssafy.ssafit.model.service;

import java.util.List;

import com.ssafy.ssafit.model.dto.Review;

public interface ReviewService {
	
	// 전체 게시글 조회
		public abstract List<Review> getList();
		
		// 게시글 조회
		public abstract Review getReview(int id);

		// 게시글 작성
		public abstract void writeReview(Review review);

		// 게시글 수정
		public abstract void modifyReview(Review review);

		// 게시글 삭제
		public abstract void removeReview(int id);
}
