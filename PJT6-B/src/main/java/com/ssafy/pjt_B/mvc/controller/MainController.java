package com.ssafy.pjt_B.mvc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import com.ssafy.pjt_B.mvc.model.dto.Video;
import com.ssafy.pjt_B.mvc.model.service.VideoService;

@RestController
@RequestMapping("/api/videos")
public class MainController {
    
    private final VideoService videoService;

    @Autowired
    public MainController(VideoService videoService) {
        this.videoService = videoService;
    }

    // Endpoint to get top videos by views
    @GetMapping("/top")
    public List<Video> getTopVideos() {
        return videoService.getTopVideos();
    }

    // Endpoint to get videos by body part
    @GetMapping
    public List<Video> getVideosByBodyPart(@RequestParam(required = false) String bodyPart) {
        if (bodyPart != null && !bodyPart.isEmpty()) {
            return videoService.getVideosByBodyPart(bodyPart);
        } else {
            return videoService.getAllVideos();
        }
    }
}
