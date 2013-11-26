package com.bros.xienan.peter.mylibs.model;

import java.util.List;

import com.bros.xienan.peter.mylibs.utils.annotations.Column;
import com.bros.xienan.peter.mylibs.utils.annotations.Table;

@Table(tableName = "table_contents")
public class Content {

	@Column(isPrimaryKey = true)
	private Integer _id;
	
	@Column
	private Integer contentid;
	
	/**
	 * 关键词，不止一个，存入List
	 */
	private List<String> keyWords;
	
	/**
	 * 文章标题
	 */
	@Column
	private String title;
	
	@Column
	private String author;
	
	/**
	 * 构建/下载时间
	 */
	@Column
	private String buildTime;
	
	/**
	 * 上次阅读时间
	 */
	@Column
	private String lastReadTime;
	
	/**
	 * 文章大小，kb
	 */
	@Column
	private Integer size;
	
	/**
	 * 文章摘要
	 */
	@Column
	private String summery;

	/**
	 * 该目录所对用的文章，里面记录了该目录所对应的内容
	 */
	@Column
	private String uri;
	
	/**
	 * 该目录所属的书籍，一个目录只能属于一个书籍
	 */
	@Column
	private Integer bookid;

	public Integer getContentid() {
		return contentid;
	}

	public void setContentid(Integer contentid) {
		this.contentid = contentid;
	}

	public List<String> getKeyWords() {
		return keyWords;
	}

	public void setKeyWords(List<String> keyWords) {
		this.keyWords = keyWords;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getBuildTime() {
		return buildTime;
	}

	public void setBuildTime(String buildTime) {
		this.buildTime = buildTime;
	}

	public String getLastReadTime() {
		return lastReadTime;
	}

	public void setLastReadTime(String lastReadTime) {
		this.lastReadTime = lastReadTime;
	}

	public Integer getSize() {
		return size;
	}

	public void setSize(Integer size) {
		this.size = size;
	}

	public String getSummery() {
		return summery;
	}

	public void setSummery(String summery) {
		this.summery = summery;
	}

	public String getUri() {
		return uri;
	}

	public void setUri(String uri) {
		this.uri = uri;
	}

	public Integer getBookid() {
		return bookid;
	}

	public void setBookid(Integer bookid) {
		this.bookid = bookid;
	}
	
	
	
}
