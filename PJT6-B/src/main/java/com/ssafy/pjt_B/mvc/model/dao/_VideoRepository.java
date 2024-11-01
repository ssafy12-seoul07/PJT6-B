package com.ssafy.ssafit.model.repository;

import com.ssafy.ssafit.model.dto.Video;
import java.util.List;

public interface VideoRepository {
    // 조회수 기준으로 상위 영상을 가져오는 메서드
    List<Video> findTopVideos();

    // 특정 운동 부위에 해당하는 영상을 가져오는 메서드
    List<Video> findVideosByBodyPart(String bodyPart);
    
    // 모든 영상을 가져오는 메서드
    List<Video> findAll();
}
