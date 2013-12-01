package com.bros.xienan.peter.mylibs.utils.xmlparser;

import java.util.List;

import android.content.Context;

import com.bros.xienan.peter.mylibs.model.Chapter;

/**
 * 
 * �����й�xml���������࣬��Ҫ�����������ֲ�����
 * 1. ��һ������������ݿ�,��������book��article�����ݿ�
 * 2. ��һƪ�����ж�ȡchapters
 * 
 * ʹ�÷�����
 * 1. �½�����,����context
 * 2. ����loadBook(String bookuri)��������ʼ��ȡ�鼮��д�����ݿ⼴��,������true, ���سɹ����������ʧ��
 * 3. ���Ե���getIsLoadingSuccess��������ȡ�鼮�������µ�chapters�Ƿ���سɹ�
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
	 * ��һƪ���µ����ӣ����ظ����µ�����chapters
	 * @param articleuri ��������
	 * @return ������سɹ�����list<chapters>�����򷵻�null
	 */
	public List<Chapter> loadChapters(String articleuri){
		isLoadingSuccess = true;
		
		return null;
	}
	
	/**
	 * ���ฺ��������к�book.xml��صķ�������
	 */
	private void parseBookToDatabase() {

		buildBookEntity();
		
		buildBookshelfEntity();
		
		buildBSRelationEntity();
		
	}

	/**
	 * ���ฺ�����н�������articles.xml�ķ�װ
	 */
	private void parseArticleToDatabase() {
		
		buildContentEntity();
		
		buildKeywordEntity();

	}
	
	
	/**
	 * ����book.xml��book.java
	 */
	private void buildBookEntity() {
		// TODO Auto-generated method stub	
	}
	
	/**
	 * ����book.xml��bookshelf.java
	 */
	private void buildBookshelfEntity() {
		// TODO Auto-generated method stub
		
	}

	/**
	 * ����������������book.java��bookshelf.java������BSRelation.java
	 */
	private void buildBSRelationEntity() {
		// TODO Auto-generated method stub
		
	}
	
	/**
	 * �������е�article,����article.xml��content.java
	 */
	private void buildContentEntity(){
		
	}
	
	/**
	 * ��article.xml����Ϊkeyword.java
	 */
	private void buildKeywordEntity() {
		// TODO Auto-generated method stub
		
	}
	
	/**
	 * �������Ȿ���������Ϣ�Ժ󣬿��Խ�book.xmlɾ��������ʶ�Ȿ���Ѿ����ص����ݿ��ˣ�
	 * ��ʱ��book.xml������Ϣ��⣬������Ҫ
	 */
	private void deleteBookInfo() {
		// TODO Auto-generated method stub
		
	}

}
