package com.ssafy.pjt_B.mvc.model.dao;

import java.util.List;

import com.ssafy.pjt_B.mvc.model.dto.Review;

public interface ReviewDao {
	
	
	//전체 게시글 가져오기
		public abstract List<Review> selectAll();

		//게시글 조회하기
		public abstract Review selectOne(int id);

		//게시글 등록하기
		public abstract int insertReview(Review review);

		//게시글 수정하기
		public abstract int updateReview(Review review);

		//게시글 삭제하기
		public abstract int deleteReview(int id);
}
