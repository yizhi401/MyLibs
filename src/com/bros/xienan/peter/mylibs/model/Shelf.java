package com.bros.xienan.peter.mylibs.model;

import com.bros.xienan.peter.mylibs.utils.annotations.Column;
import com.bros.xienan.peter.mylibs.utils.annotations.Table;

@Table(tableName = "table_shelfs")
public class Shelf {
	
	@Column(isPrimaryKey = true)
	private Integer _id;
	
	@Column
	private Integer shelfid;
	
	@Column
	private String name;

	public Integer getShelfid() {
		return shelfid;
	}

	public void setShelfid(Integer shelfid) {
		this.shelfid = shelfid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
}
