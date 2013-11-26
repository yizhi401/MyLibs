package com.bros.xienan.peter.mylibs.model;

import java.util.Map;

public class Chapter {
	/**
	 * 父级目录
	 */
	private Chapter father;
	
	/**
	 * 同级目录的上一级目录
	 */
	private Chapter brother;
	
	/**
	 * 章节标题
	 */
	private String title;
	
	
	/**
	 * 本章内容，包含paragraph, images, audios, videos等
	 */
	private Map<Integer, Object> body;


	public Chapter getFather() {
		return father;
	}


	public void setFather(Chapter father) {
		this.father = father;
	}


	public Chapter getBrother() {
		return brother;
	}


	public void setBrother(Chapter brother) {
		this.brother = brother;
	}


	public String getTitle() {
		return title;
	}


	public void setTitle(String title) {
		this.title = title;
	}


	public Map<Integer, Object> getBody() {
		return body;
	}


	public void setBody(Map<Integer, Object> body) {
		this.body = body;
	}
 
	
	
}
