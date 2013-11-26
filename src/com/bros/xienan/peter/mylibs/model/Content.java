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
	 * �ؼ��ʣ���ֹһ��������List
	 */
	private List<String> keyWords;
	
	/**
	 * ���±���
	 */
	@Column
	private String title;
	
	@Column
	private String author;
	
	/**
	 * ����/����ʱ��
	 */
	@Column
	private String buildTime;
	
	/**
	 * �ϴ��Ķ�ʱ��
	 */
	@Column
	private String lastReadTime;
	
	/**
	 * ���´�С��kb
	 */
	@Column
	private Integer size;
	
	/**
	 * ����ժҪ
	 */
	@Column
	private String summery;

	/**
	 * ��Ŀ¼�����õ����£������¼�˸�Ŀ¼����Ӧ������
	 */
	@Column
	private String uri;
	
	/**
	 * ��Ŀ¼�������鼮��һ��Ŀ¼ֻ������һ���鼮
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
