package com.bros.xienan.peter.mylibs.model;

import java.util.TreeMap;

public class Article {
	/**
	 * 文章标题
	 */
	private String title;
	
	private String author;
	
	/**
	 * 构建/下载时间
	 */
	private String buildTime;
	
	/**
	 * 上次阅读时间
	 */
	private String lastReadTime;
	
	/**
	 * 文章大小，kb
	 */
	private Integer size;
	
	/**
	 * 文章摘要
	 */
	private String summery;
	
	/**
	 * 包含章节，按照树形结构组织
	 */
	private TreeMap<Integer, Chapter> chapters;

}
