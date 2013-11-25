package com.bros.xienan.peter.mylibs.model;

import java.util.Map;

public class Chapter {
	/**
	 * 父级目录
	 */
	private String father;
	
	/**
	 * 同级目录的上一级目录
	 */
	private String brother;
	
	/**
	 * 章节标题
	 */
	private String title;
	
	
	/**
	 * 本章内容，包含paragraph, images, audios, videos等
	 */
	private Map<Integer, Object> contents;
 
}
