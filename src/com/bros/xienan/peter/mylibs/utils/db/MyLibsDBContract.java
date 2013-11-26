package com.bros.xienan.peter.mylibs.utils.db;

import android.provider.BaseColumns;

/**
 * 数据库中表的栏目，注意，如果要变更表的结构，不仅仅变更这里，还需要变更相应的实体类
 * 
 * 变更表结构的步骤： 1. 如果该表结构涉及到实体类的变更（而且一般都会涉及到），请到model包中修改相应的实体类 2. 在相应的表类中添加column
 * 3. 在相应表类的构建语句中添加该column的构建语句
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
	 * 书籍表，包含所有的书籍，与书架属于多对多，其关系维护在书籍-书架关系表中 与目录是一对多，关系维护在目录表中
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
				+ "INTEGER PRIMARY　KEY," + BookTable.COLUMN_ID + TEXT_TYPE
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
	 * 书架表，包含目前所知的所有书架，与书籍是多对多关系，维护在书籍-书架关系表中
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
				+ "INTEGER PRIMARY　KEY," + ShelfTable.COLUMN_ID + TEXT_TYPE
				+ COMMA_SEP + ShelfTable.COLUMN_NAME + TEXT_TYPE + COMMA_SEP
				+ " )";

		public static final String SQL_DELETE_SHELFTABLE = "DROP TABLE IF EXISTS"
				+ ShelfTable.TABLE_NAME;
	}

	/**
	 * 书籍-书架关系表
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
				+ "INTEGER PRIMARY　KEY," + BSRelationTable.COLUMN_BOOK
				+ TEXT_TYPE + COMMA_SEP + BSRelationTable.COLUMN_SHELF
				+ TEXT_TYPE + COMMA_SEP + " )";

		public static final String SQL_DELETE_BSRELATIONABLE = "DROP TABLE IF EXISTS"
				+ BSRelationTable.TABLE_NAME;
	}

	/**
	 * 目录表，维护了所有书籍的目录，并且保存了其所对应的书籍
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
				+ "INTEGER PRIMARY　KEY," + ContentTable.COLUMN_ID + TEXT_TYPE
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
	 * 关键词表：一篇文章对应着多个关键词，属于一对多关系，在keywords里面添加一个属性 ，指向其所在文章，以及该文章所在的书籍
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
				+ "INTEGER PRIMARY　KEY," + KeywordsTable.COLUMN_KEYWORD
				+ TEXT_TYPE + COMMA_SEP + KeywordsTable.COLUMN_BOOK + TEXT_TYPE
				+ COMMA_SEP + KeywordsTable.COLUMN_CONTENT + TEXT_TYPE
				+ COMMA_SEP + " )";

		public static final String SQL_DELETE_KEYWORDSTABLE = "DROP TABLE IF EXISTS"
				+ KeywordsTable.TABLE_NAME;
	}

}
