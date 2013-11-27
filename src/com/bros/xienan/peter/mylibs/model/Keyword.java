package com.bros.xienan.peter.mylibs.model;

import com.bros.xienan.peter.mylibs.utils.annotations.Column;
import com.bros.xienan.peter.mylibs.utils.annotations.Table;

@Table(tableName = "table_keywords")
public class Keyword {

	@Column(isPrimaryKey = true)
	private Long _ID;
	
	@Column
	private String keyword;
	
	@Column
	private Long bookid;
	
	@Column
	private Long contentid;

	public String getKeyword() {
		return keyword;
	}

	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}

	public Long getBookid() {
		return bookid;
	}

	public void setBookid(Long bookid) {
		this.bookid = bookid;
	}

	public Long getContentid() {
		return contentid;
	}

	public void setContentid(Long contentid) {
		this.contentid = contentid;
	}
	
	
	
}
