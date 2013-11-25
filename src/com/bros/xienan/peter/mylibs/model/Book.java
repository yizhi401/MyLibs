package com.bros.xienan.peter.mylibs.model;

import java.util.List;

public class Book {
	
	private String name;
	
	private String author;
	
	/**
	 * 书籍大小，kb为单位
	 */
	private Integer size;
	
	/**
	 * 构建时间，如果从网上下载的则为下载时间
	 */
	private String buildTime;
	
	private String description;
	
	/**
	 * 书籍的封面图片，是一个uri链接
	 */
	private String coverUri;
	
	/**
	 * 该书籍的uri
	 */
	private String uri;
	
	/**
	 * 书籍所隶属的书架,一本书可能属于多个目录
	 */
	private List<String> bookShelfs;
	
	/**
	 * 该书籍所有的目录
	 */
	private List<Item> content;
}
