package com.bros.xienan.peter.mylibs.utils.db;

import android.provider.BaseColumns;

/**
 * ���ݿ��б����Ŀ��ע�⣬���Ҫ�����Ľṹ������������������Ҫ�����Ӧ��ʵ����
 * 
 * �����ṹ�Ĳ��裺 1. ����ñ�ṹ�漰��ʵ����ı��������һ�㶼���漰�������뵽model�����޸���Ӧ��ʵ���� 2. ����Ӧ�ı��������column
 * 3. ����Ӧ����Ĺ����������Ӹ�column�Ĺ������
 * 
 * @author yizhi401
 * 
 */
@Deprecated
public class MyLibsDBContract {

	private static final String TEXT_TYPE = " TEXT";

	private static final String INTEGER_TYPE = " INTEGER";

	private static final String COMMA_SEP = ",";

	public MyLibsDBContract() {
	}

	/**
	 * �鼮���������е��鼮����������ڶ�Զ࣬���ϵά�����鼮-��ܹ�ϵ���� ��Ŀ¼��һ�Զ࣬��ϵά����Ŀ¼����
	 * 
	 * @author yizhi401
	 * 
	 */
	@Deprecated
	public static abstract class BookTable implements BaseColumns {
		public static final String TABLE_NAME = "table_books";
		public static final String COLUMN_ID = "book_id";
		public static final String COLUMN_NAME = "name";
		public static final String COLUMN_AUTHOR = "author";
		public static final String COLUMN_SIZE = "size";
		public static final String COLUMN_BUILDTIME = "buildtime";
		public static final String COLUMN_DESCRIPTION = "description";
		public static final String COLUMN_COVERURI = "coveruri";
		public static final String COLUMN_URI = "uri";

		public static final String SQL_CREATE_BOOKTABLE = "CREATE TABLE "
				+ BookTable.TABLE_NAME + " (" + BookTable._ID
				+ "INTEGER PRIMARY��KEY," + BookTable.COLUMN_ID + TEXT_TYPE
				+ COMMA_SEP + BookTable.COLUMN_NAME + TEXT_TYPE + COMMA_SEP
				+ BookTable.COLUMN_AUTHOR + TEXT_TYPE + COMMA_SEP
				+ BookTable.COLUMN_SIZE + INTEGER_TYPE + COMMA_SEP
				+ BookTable.COLUMN_BUILDTIME + TEXT_TYPE + COMMA_SEP
				+ BookTable.COLUMN_DESCRIPTION + TEXT_TYPE + COMMA_SEP
				+ BookTable.COLUMN_COVERURI + TEXT_TYPE + COMMA_SEP
				+ BookTable.COLUMN_URI + TEXT_TYPE + COMMA_SEP + " )";

		public static final String SQL_DELETE_BOOKTABLE = "DROP TABLE IF EXISTS"
				+ BookTable.TABLE_NAME;
	}

	/**
	 * ��ܱ�����Ŀǰ��֪��������ܣ����鼮�Ƕ�Զ��ϵ��ά�����鼮-��ܹ�ϵ����
	 * 
	 * @author yizhi401
	 * 
	 */
	@Deprecated
	public static abstract class ShelfTable implements BaseColumns {

		public static final String TABLE_NAME = "table_shelfs";
		public static final String COLUMN_ID = "shelf_id";
		public static final String COLUMN_NAME = "name";

		public static final String SQL_CREATE_SHELFTABLE = "CREATE TABLE "
				+ ShelfTable.TABLE_NAME + " (" + ShelfTable._ID
				+ "INTEGER PRIMARY��KEY," + ShelfTable.COLUMN_ID + TEXT_TYPE
				+ COMMA_SEP + ShelfTable.COLUMN_NAME + TEXT_TYPE + COMMA_SEP
				+ " )";

		public static final String SQL_DELETE_SHELFTABLE = "DROP TABLE IF EXISTS"
				+ ShelfTable.TABLE_NAME;
	}

	/**
	 * �鼮-��ܹ�ϵ��
	 * 
	 * @author yizhi401
	 * 
	 */
	@Deprecated
	public static abstract class BSRelationTable implements BaseColumns {
		public static final String TABLE_NAME = "table_book_shelf_relationship";
		public static final String COLUMN_BOOK = "book_id";
		public static final String COLUMN_SHELF = "shelf_id";

		public static final String SQL_CREATE_BSRELATIONTABLE = "CREATE TABLE "
				+ BSRelationTable.TABLE_NAME + " (" + BSRelationTable._ID
				+ "INTEGER PRIMARY��KEY," + BSRelationTable.COLUMN_BOOK
				+ TEXT_TYPE + COMMA_SEP + BSRelationTable.COLUMN_SHELF
				+ TEXT_TYPE + COMMA_SEP + " )";

		public static final String SQL_DELETE_BSRELATIONABLE = "DROP TABLE IF EXISTS"
				+ BSRelationTable.TABLE_NAME;
	}

	/**
	 * Ŀ¼��ά���������鼮��Ŀ¼�����ұ�����������Ӧ���鼮
	 * 
	 * @author yizhi401
	 * 
	 */
	@Deprecated
	public static abstract class ContentTable implements BaseColumns {
		public static final String TABLE_NAME = "table_contents";
		public static final String COLUMN_ID = "content_id";
		public static final String COLUMN_TITLE = "title";
		public static final String COLUMN_AUTHOR = "author";
		public static final String COLUMN_BUILDTIME = "buildtime";
		public static final String COLUMN_LASTREADTIME = "lastreadtime";
		public static final String COLUMN_SIZE = "size";
		public static final String COLUMN_SUMMERY = "summery";
		public static final String COLUMN_URI = "uri";
		public static final String COLUMN_SOURCEBOOK = "book_id";

		public static final String SQL_CREATE_CONTENTTABLE = "CREATE TABLE "
				+ ContentTable.TABLE_NAME + " (" + ContentTable._ID
				+ "INTEGER PRIMARY��KEY," + ContentTable.COLUMN_ID + TEXT_TYPE
				+ COMMA_SEP + ContentTable.COLUMN_TITLE + TEXT_TYPE + COMMA_SEP
				+ ContentTable.COLUMN_AUTHOR + TEXT_TYPE + COMMA_SEP
				+ ContentTable.COLUMN_SIZE + INTEGER_TYPE + COMMA_SEP
				+ ContentTable.COLUMN_BUILDTIME + TEXT_TYPE + COMMA_SEP
				+ ContentTable.COLUMN_SUMMERY + TEXT_TYPE + COMMA_SEP
				+ ContentTable.COLUMN_LASTREADTIME + TEXT_TYPE + COMMA_SEP
				+ ContentTable.COLUMN_SOURCEBOOK + TEXT_TYPE + COMMA_SEP
				+ ContentTable.COLUMN_URI + TEXT_TYPE + COMMA_SEP + " )";

		public static final String SQL_DELETE_CONTENTTABLE = "DROP TABLE IF EXISTS"
				+ ContentTable.TABLE_NAME;
	}

	/**
	 * �ؼ��ʱ�һƪ���¶�Ӧ�Ŷ���ؼ��ʣ�����һ�Զ��ϵ����keywords�������һ������ ��ָ�����������£��Լ����������ڵ��鼮
	 * 
	 * @author yizhi401
	 * 
	 */
	@Deprecated
	public static abstract class KeywordsTable implements BaseColumns {
		public static final String TABLE_NAME = "table_keywords";
		public static final String COLUMN_KEYWORD = "keyword";
		public static final String COLUMN_BOOK = "book_id";
		public static final String COLUMN_CONTENT = "content_id";

		public static final String SQL_CREATE_KEYWORDSTABLE = "CREATE TABLE "
				+ KeywordsTable.TABLE_NAME + " (" + KeywordsTable._ID
				+ "INTEGER PRIMARY��KEY," + KeywordsTable.COLUMN_KEYWORD
				+ TEXT_TYPE + COMMA_SEP + KeywordsTable.COLUMN_BOOK + TEXT_TYPE
				+ COMMA_SEP + KeywordsTable.COLUMN_CONTENT + TEXT_TYPE
				+ COMMA_SEP + " )";

		public static final String SQL_DELETE_KEYWORDSTABLE = "DROP TABLE IF EXISTS"
				+ KeywordsTable.TABLE_NAME;
	}

}
