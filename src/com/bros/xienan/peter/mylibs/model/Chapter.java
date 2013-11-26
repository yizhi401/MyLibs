package com.bros.xienan.peter.mylibs.model;

import java.util.Map;

public class Chapter {
	/**
	 * ����Ŀ¼
	 */
	private Chapter father;
	
	/**
	 * ͬ��Ŀ¼����һ��Ŀ¼
	 */
	private Chapter brother;
	
	/**
	 * �½ڱ���
	 */
	private String title;
	
	
	/**
	 * �������ݣ�����paragraph, images, audios, videos��
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
