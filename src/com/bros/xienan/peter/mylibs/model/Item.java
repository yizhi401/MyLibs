package com.bros.xienan.peter.mylibs.model;

import java.util.List;

public class Item {

	private String title;

	private String keyWords;

	/**
	 * 该目录所对用的xml文件，里面记录了该目录所对应的内容
	 */
	private String detailUri;
	
	/**
	 * 该目录所属的书籍，一个目录可能隶属于多个书籍
	 */
	private List<String> sourceBooks;
}
