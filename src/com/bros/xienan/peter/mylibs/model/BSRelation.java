package com.bros.xienan.peter.mylibs.model;

import com.bros.xienan.peter.mylibs.utils.annotations.Column;
import com.bros.xienan.peter.mylibs.utils.annotations.Table;

@Table(tableName = "table_book_shelf_relationship")
public class BSRelation {

	@Column(isPrimaryKey = true)
	private Integer _id;
	
	@Column
	private Integer bookid;
	
	@Column
	private Integer shelfid;

	public Integer getBookid() {
		return bookid;
	}

	public void setBookid(Integer bookid) {
		this.bookid = bookid;
	}

	public Integer getShelfid() {
		return shelfid;
	}

	public void setShelfid(Integer shelfid) {
		this.shelfid = shelfid;
	}
	
	
}
