package com.bros.xienan.peter.mylibs.model;

import java.util.TreeMap;

public class Article {

	/**
	 * ͨ����Ϣ����itemĿ¼����
	 */
	private Content generalInfo;
	/**
	 * �����½ڣ��������νṹ��֯
	 */
	private TreeMap<Integer, Chapter> chapters;
	
	public Content getGeneralInfo() {
		return generalInfo;
	}
	
	public void setGeneralInfo(Content generalInfo) {
		this.generalInfo = generalInfo;
	}
	
	public TreeMap<Integer, Chapter> getChapters() {
		return chapters;
	}
	
	public void setChapters(TreeMap<Integer, Chapter> chapters) {
		this.chapters = chapters;
	}
	
	

}
