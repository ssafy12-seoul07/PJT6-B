package com.ssafy.ssafit.model.service.impl;

import com.ssafy.ssafit.model.dto.Video;
import com.ssafy.ssafit.model.repository.VideoRepository;
import com.ssafy.ssafit.model.repository.impl.VideoRepositoryImpl;
import com.ssafy.ssafit.model.service.VideoService;

import java.util.List;

public class VideoServiceImpl implements VideoService {
    private VideoRepository videoRepository;

    public VideoServiceImpl() {
        // VideoRepositoryImpl 인스턴스 생성
        this.videoRepository = new VideoRepositoryImpl();
    }

    @Override
    public List<Video> getTopVideos() {
        return videoRepository.findTopVideos();
    }

    @Override
    public List<Video> getVideosByBodyPart(String bodyPart) {
        return videoRepository.findVideosByBodyPart(bodyPart);
    }

    @Override
    public List<Video> getAllVideos() {
        return videoRepository.findAll();
    }
}
