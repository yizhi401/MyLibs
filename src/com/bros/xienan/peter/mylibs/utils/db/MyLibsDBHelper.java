package com.bros.xienan.peter.mylibs.utils.db;

import java.lang.reflect.Field;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.bros.xienan.peter.mylibs.model.BSRelation;
import com.bros.xienan.peter.mylibs.model.Book;
import com.bros.xienan.peter.mylibs.model.Content;
import com.bros.xienan.peter.mylibs.model.Keyword;
import com.bros.xienan.peter.mylibs.model.Shelf;
import com.bros.xienan.peter.mylibs.utils.annotations.Column;
import com.bros.xienan.peter.mylibs.utils.annotations.Table;
import com.bros.xienan.peter.mylibs.utils.db.MyLibsDBContract.BSRelationTable;

/**
 * 数据库管理类，程序所有数据存于此。要添加一个新表或者删除一个表， 除了更新相应的实体类，MyLibsDBContract.java中的类，
 * 还要记得在这里执行建表或者删除表的功能。
 * 
 * 该类仅提供以下功能： 1. 建立一个数据库（不需要手动调用） 2. 建立表或者删除表（不需要手动调用）
 * 
 * 使用方法： 1. 获取该类的实例，通过getInstance来获取 2.
 * 调用getWritableDatabase、或者getReadableDatabase来获取db实例
 * 
 * @author yizhi401
 * 
 */
public class MyLibsDBHelper extends SQLiteOpenHelper {

	public static MyLibsDBHelper mInstance = null;

	public static final String DATABASE_NAME = "MyLibsDatabase.db";

	public static final int DATABASE_VERSION = 1;

	// 以下三个变量均为构建表时候sql语句所用
	private static final String TEXT_TYPE = " TEXT";

	private static final String INTEGER_TYPE = " INTEGER";

	private static final String COMMA_SEP = ",";
	
	private static final String PRIMARY_KEY = "INTEGER PRIMARY KEY,";

	/**
	 * 只提供单例模式，因为全局只需要一个db对象
	 * 
	 * @param context
	 * @return
	 */
	public static MyLibsDBHelper getInstance(Context context) {
		if (mInstance == null) {
			mInstance = new MyLibsDBHelper(context);
		}
		return mInstance;
	}

	private MyLibsDBHelper(Context context) {
		super(context, DATABASE_NAME, null, DATABASE_VERSION);
	}

	/**
	 * 创立数据库时候所调用方法，所有表在此建表。
	 * 
	 * @param db
	 */
	@Override
	public void onCreate(SQLiteDatabase db) {
		// 在此建表
		createTable(db, Book.class);
		createTable(db, Shelf.class);
		createTable(db, Content.class);
		createTable(db, BSRelation.class);
		createTable(db, Keyword.class);
	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

		// TODO我暂时还想不到要有什么更新整个数据库的情况
	}


	/**
	 * 根据所提供的实体类在数据库中建表，如果db中存在此表，直接返回
	 * 
	 * @param <T>
	 * @param db
	 *            要建表的数据库
	 * @param clazz
	 *            实体类
	 */
	public <T> void createTable(SQLiteDatabase db,Class<T> clazz){
		
		StringBuffer createTableSQL = new StringBuffer("CREATE TABLE ");
		Table table = clazz.getAnnotation(Table.class);
		if (table != null)
		{
			createTableSQL.append(table.tableName());
			createTableSQL.append(" (");
			
			Field[] fields = clazz.getDeclaredFields();
			
			for (Field field: fields)
			{
				if (field.isAnnotationPresent(Column.class))
				{
					if (field.getAnnotation(Column.class).isPrimaryKey())
					{
						createTableSQL.append(field.getName());
						createTableSQL.append(PRIMARY_KEY);
					
					} else{
						createTableSQL.append(field.getName());
						createTableSQL.append(TEXT_TYPE);
						createTableSQL.append(COMMA_SEP);
					}
				
				}
			}
			
			createTableSQL.append(" )");
			db.execSQL(createTableSQL.toString());
		}
		
	}

	/**
	 * 根据所提供的实体类删除相应的表，如果db无此表，不进行操作
	 * 
	 * @param <T>
	 * @param db
	 *            数据库
	 * @param clazz
	 *            实体类
	 */
	public <T> void deleteTable(SQLiteDatabase db, Class<T> clazz) {
		StringBuffer deleteTableSQL = new StringBuffer("DROP TABLE IF EXSITS ");
		Table table = clazz.getAnnotation(Table.class);
		
		if (table != null)
		{
			deleteTableSQL.append(table.tableName());
			db.execSQL(deleteTableSQL.toString());
		}
	}

}
