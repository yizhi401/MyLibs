package com.bros.xienan.peter.mylibs.model;

import java.util.TreeMap;

public class Article {
	/**
	 * ���±���
	 */
	private String title;
	
	private String author;
	
	/**
	 * ����/����ʱ��
	 */
	private String buildTime;
	
	/**
	 * �ϴ��Ķ�ʱ��
	 */
	private String lastReadTime;
	
	/**
	 * ���´�С��kb
	 */
	private Integer size;
	
	/**
	 * ����ժҪ
	 */
	private String summery;
	
	/**
	 * �����½ڣ��������νṹ��֯
	 */
	private TreeMap<Integer, Chapter> chapters;

}
