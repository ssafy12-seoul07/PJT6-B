package com.ssafy.ssafit.model.repository.impl;

import com.ssafy.ssafit.model.dto.Video;
import com.ssafy.ssafit.model.repository.VideoRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class VideoRepositoryImpl implements VideoRepository {
    // 임시로 메모리에 저장할 비디오 목록 (실제 데이터베이스 대신 사용)
    private List<Video> videos = new ArrayList<>();

    public VideoRepositoryImpl() {
        // 초기 데이터 추가 (테스트용)
        videos.add(new Video("1", "Yoga for Beginners", "Yoga for beginners video", "full body", 1500));
        videos.add(new Video("2", "Core Strengthening", "Core workout video", "core", 3000));
        videos.add(new Video("3", "Leg Day Workout", "Leg strengthening exercises", "legs", 2000));
        videos.add(new Video("4", "Upper Body Workout", "Upper body strength workout", "upper body", 4000));
    }

    @Override
    public List<Video> findTopVideos() {
        // 조회수 기준으로 상위 3개의 영상을 반환 (예시로 상위 3개)
        return videos.stream()
                .sorted((v1, v2) -> Integer.compare(v2.getViews(), v1.getViews()))
                .limit(3)
                .collect(Collectors.toList());
    }

    @Override
    public List<Video> findVideosByBodyPart(String bodyPart) {
        // 특정 운동 부위에 해당하는 영상을 필터링하여 반환
        return videos.stream()
                .filter(video -> video.getBodyPart().equalsIgnoreCase(bodyPart))
                .collect(Collectors.toList());
    }

    @Override
    public List<Video> findAll() {
        return new ArrayList<>(videos);
    }
}
