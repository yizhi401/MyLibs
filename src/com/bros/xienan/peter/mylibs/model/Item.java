package com.bros.xienan.peter.mylibs.model;

import java.util.List;

public class Item {

	private String title;

	private List<String> keyWords;

	/**
	 * 该目录所对用的文章，里面记录了该目录所对应的内容
	 */
	private String detailUri;
	
	/**
	 * 该目录所属的书籍，一个目录只能属于一个书籍
	 */
	private String sourceBooks;
}
