package com.ssafy.pjt_B.mvc.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssafy.pjt_B.mvc.model.dao.VideoDao;
import com.ssafy.pjt_B.mvc.model.dto.Video;

@Service
public class VideoServiceImpl implements VideoService {

    private final VideoDao videoDao;

    @Autowired
    public VideoServiceImpl(VideoDao videoDao) {
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
