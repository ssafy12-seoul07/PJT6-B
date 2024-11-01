package com.ssafy.pjt_B.mvc.model.dto;

import java.io.Serializable;
import java.util.Date;

public class Review implements Serializable {
	private static final long serialVersionUID = 1L;

	private int id;
	private String title;
	private String writer;
	private String content;
	private String regDate;
	
	//기본 생성자
	public Review() {}
	
	public Review(String title, String writer, String content) {
		this.title = title;
		this.writer = writer;
		this.content = content;
		this.regDate = new Date().toString();
	}


	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getWriter() {
		return writer;
	}

	public void setWriter(String writer) {
		this.writer = writer;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getRegDate() {
		return regDate;
	}

	public void setRegDate(String regDate) {
		this.regDate = regDate;
	}



	@Override
	public String toString() {
		return "Review [id=" + id + ", title=" + title + ", writer=" + writer + ", content=" + content + ", regDate="
				+ regDate + ", viewCnt=" + "]";
	}
	
	
	
}
