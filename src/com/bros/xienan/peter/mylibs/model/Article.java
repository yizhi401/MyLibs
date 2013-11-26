package com.bros.xienan.peter.mylibs.model;

import java.util.TreeMap;

public class Article {

	/**
	 * 通用信息，与item目录共享
	 */
	private Content generalInfo;
	/**
	 * 包含章节，按照树形结构组织
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
