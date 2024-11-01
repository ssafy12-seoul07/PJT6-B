package com.ssafy.ssafit.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import com.ssafy.ssafit.model.dto.Video;
import com.ssafy.ssafit.model.service.VideoService;
import com.ssafy.ssafit.model.service.impl.VideoServiceImpl;

import java.io.IOException;
import java.util.List;

@WebServlet("/main")
public class MainController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private VideoService videoService;

    @Override
    public void init() throws ServletException {
        videoService = new VideoServiceImpl();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 조회수 기준 운동 영상 출력
        List<Video> topVideos = videoService.getTopVideos();
        req.setAttribute("topVideos", topVideos);

        // 운동 부위별 운동 영상 출력
        String bodyPart = req.getParameter("bodyPart");
        if (bodyPart != null && !bodyPart.isEmpty()) {
            List<Video> videosByBodyPart = videoService.getVideosByBodyPart(bodyPart);
            req.setAttribute("videosByBodyPart", videosByBodyPart);
        }

        req.getRequestDispatcher("/WEB-INF/views/video/videoList.jsp").forward(req, resp);
    }
}
