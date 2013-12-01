package com.bros.xienan.peter.mylibs.utils.xmlparser;

import java.util.List;

import android.content.Context;

import com.bros.xienan.peter.mylibs.model.Chapter;

/**
 * 
 * 程序有关xml操作管理类，主要包含以下两种操作：
 * 1. 把一本书加载如数据库,包括加载book和article到数据库
 * 2. 从一篇文章中读取chapters
 * 
 * 使用方法：
 * 1. 新建对象,传入context
 * 2. 调用loadBook(String bookuri)方法，开始读取书籍并写入数据库即可,若返回true, 加载成功；否则加载失败
 * 3. 可以调用getIsLoadingSuccess方法来获取书籍或者文章的chapters是否加载成功
 * @author yizhi401
 *
 */
public class MyLibsXmlManager {
	
	Context context;
	String bookuri;
	
	
	boolean isLoadingSuccess;
	
	public MyLibsXmlManager(Context context){
		this.context = context;
	}
	
	public boolean loadBook(String bookuri){
		isLoadingSuccess = true;
		this.bookuri = bookuri;
		
		parseBookToDatabase();
		
		parseArticleToDatabase();
		
		deleteBookInfo();
		
		return isLoadingSuccess;
		
	}
	
	/**
	 * 
	 * 给一篇文章的连接，返回该文章的所有chapters
	 * @param articleuri 文章连接
	 * @return 如果加载成功返回list<chapters>，否则返回null
	 */
	public List<Chapter> loadChapters(String articleuri){
		isLoadingSuccess = true;
		
		return null;
	}
	
	/**
	 * 该类负责解析所有和book.xml相关的方法调用
	 */
	private void parseBookToDatabase() {

		buildBookEntity();
		
		buildBookshelfEntity();
		
		buildBSRelationEntity();
		
	}

	/**
	 * 该类负责所有解析文章articles.xml的封装
	 */
	private void parseArticleToDatabase() {
		
		buildContentEntity();
		
		buildKeywordEntity();

	}
	
	
	/**
	 * 解析book.xml到book.java
	 */
	private void buildBookEntity() {
		// TODO Auto-generated method stub	
	}
	
	/**
	 * 解析book.xml到bookshelf.java
	 */
	private void buildBookshelfEntity() {
		// TODO Auto-generated method stub
		
	}

	/**
	 * 根据上面所建立的book.java和bookshelf.java，构建BSRelation.java
	 */
	private void buildBSRelationEntity() {
		// TODO Auto-generated method stub
		
	}
	
	/**
	 * 便利所有的article,解析article.xml到content.java
	 */
	private void buildContentEntity(){
		
	}
	
	/**
	 * 将article.xml解析为keyword.java
	 */
	private void buildKeywordEntity() {
		// TODO Auto-generated method stub
		
	}
	
	/**
	 * 加载完这本书的所有信息以后，可以将book.xml删除，来标识这本书已经加载到数据库了，
	 * 这时候book.xml所有信息入库，不再需要
	 */
	private void deleteBookInfo() {
		// TODO Auto-generated method stub
		
	}

}
