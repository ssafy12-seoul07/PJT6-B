package com.ssafy.ssafit.model.repository;

import java.util.List;

import com.ssafy.ssafit.model.dto.Review;

public interface ReviewRepository {
	
	
	//전체 게시글 가져오기
		public abstract List<Review> selectAll();

		//게시글 조회하기
		public abstract Review selectOne(int id);

		//게시글 등록하기
		public abstract void insertReview(Review review);

		//게시글 수정하기
		public abstract void updateReview(Review review);

		//게시글 삭제하기
		public abstract void deleteReview(int id);

		//게시글 조회수 증가
		public abstract void updateViewCnt(int id);
}
