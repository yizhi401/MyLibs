package com.bros.xienan.peter.mylibs.model;

import java.util.List;

import com.bros.xienan.peter.mylibs.utils.annotations.Column;
import com.bros.xienan.peter.mylibs.utils.annotations.Table;

@Table(tableName = "table_books")
public class Book {

	@Column(isPrimaryKey = true)
	private Long _ID;
	
	@Column
	private Long bookid;
	
	@Column
	private String name;
	
	@Column	
	private String author;
	
	/**
	 * 书籍大小，kb为单位
	 */
	@Column	
	private Long size;
	
	/**
	 * 构建时间，如果从网上下载的则为下载时间
	 */
	@Column
	private String buildTime;
	
	@Column
	private String description;
	
	/**
	 * 书籍的封面图片，是一个uri链接
	 */
	@Column
	private String coverUri;
	
	/**
	 * 该书籍的uri
	 */
	@Column
	private String uri;
	
	/**
	 * 书籍所隶属的书架,一本书可能属于多个目录
	 */
	private List<String> bookShelfs;
	
	/**
	 * 该书籍所有的目录
	 */
	private List<Content> content;

	public Long getBookid() {
		return bookid;
	}

	public void setBookid(Long bookid) {
		this.bookid = bookid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public Long getSize() {
		return size;
	}

	public void setSize(Long size) {
		this.size = size;
	}

	public String getBuildTime() {
		return buildTime;
	}

	public void setBuildTime(String buildTime) {
		this.buildTime = buildTime;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getCoverUri() {
		return coverUri;
	}

	public void setCoverUri(String coverUri) {
		this.coverUri = coverUri;
	}

	public String getUri() {
		return uri;
	}

	public void setUri(String uri) {
		this.uri = uri;
	}

	public List<String> getBookShelfs() {
		return bookShelfs;
	}

	public void setBookShelfs(List<String> bookShelfs) {
		this.bookShelfs = bookShelfs;
	}

	public List<Content> getContent() {
		return content;
	}

	public void setContent(List<Content> content) {
		this.content = content;
	}
	
	
	
}
