package com.ssafy.pjt_B.mvc.model.service;

import java.util.List;

import com.ssafy.pjt_B.mvc.model.dao.VideoDao;
import com.ssafy.pjt_B.mvc.model.dto.Video;

public class VideoServiceImpl implements VideoService {
    private VideoDao videoDao;

    public VideoServiceImpl(VideoDao videoDao) {
        // VideoRepositoryImpl 인스턴스 생성
        this.videoDao = videoDao;
    }

    @Override
    public List<Video> getTopVideos() {
        return videoDao.findTopVideos();
    }

    @Override
    public List<Video> getVideosByBodyPart(String bodyPart) {
        return videoDao.findVideosByBodyPart(bodyPart);
    }

    @Override
    public List<Video> getAllVideos() {
        return videoDao.findAll();
    }
}
