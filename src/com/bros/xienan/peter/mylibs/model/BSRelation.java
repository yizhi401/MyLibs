package com.bros.xienan.peter.mylibs.model;

import com.bros.xienan.peter.mylibs.utils.annotations.Column;
import com.bros.xienan.peter.mylibs.utils.annotations.Table;

@Table(tableName = "table_book_shelf_relationship")
public class BSRelation {

	@Column(isPrimaryKey = true)
	private Long _ID;
	
	@Column
	private Long bookid;
	
	@Column
	private Long shelfid;

	public Long getBookid() {
		return bookid;
	}

	public void setBookid(Long bookid) {
		this.bookid = bookid;
	}

	public Long getShelfid() {
		return shelfid;
	}

	public void setShelfid(Long shelfid) {
		this.shelfid = shelfid;
	}
	
	
}
