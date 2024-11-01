package com.ssafy.pjt_B.mvc.model.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.ssafy.pjt_B.mvc.model.dto.Video;

@Mapper  // Tells MyBatis to create an implementation at runtime
public interface VideoDao {
    // Retrieve top videos by views
    List<Video> findTopVideos();

    // Retrieve videos by body part
    List<Video> findVideosByBodyPart(@Param("bodyPart") String bodyPart);
    
    // Retrieve all videos
    List<Video> findAll();
}
