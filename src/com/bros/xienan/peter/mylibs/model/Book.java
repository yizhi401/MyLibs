package com.bros.xienan.peter.mylibs.model;

import java.util.List;

public class Book {
	
	private String name;
	
	private String author;
	
	/**
	 * �鼮��С��kbΪ��λ
	 */
	private Integer size;
	
	/**
	 * ����ʱ�䣬������������ص���Ϊ����ʱ��
	 */
	private String buildTime;
	
	private String description;
	
	/**
	 * �鼮�ķ���ͼƬ����һ��uri����
	 */
	private String coverUri;
	
	/**
	 * ���鼮��uri
	 */
	private String uri;
	
	/**
	 * �鼮�����������,һ����������ڶ��Ŀ¼
	 */
	private List<String> bookShelfs;
	
	/**
	 * ���鼮���е�Ŀ¼
	 */
	private List<Item> content;
}
