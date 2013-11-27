package com.bros.xienan.peter.mylibs.model;

import com.bros.xienan.peter.mylibs.utils.annotations.Column;
import com.bros.xienan.peter.mylibs.utils.annotations.Table;

@Table(tableName = "table_shelfs")
public class Shelf {
	
	@Column(isPrimaryKey = true)
	private Long _ID;
	
	@Column
	private Long shelfid;
	
	@Column
	private String name;

	public Long getShelfid() {
		return shelfid;
	}

	public void setShelfid(Long shelfid) {
		this.shelfid = shelfid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
}
