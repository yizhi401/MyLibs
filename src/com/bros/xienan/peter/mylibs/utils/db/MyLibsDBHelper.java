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
 * ���ݿ�����࣬�����������ݴ��ڴˡ�Ҫ���һ���±����ɾ��һ���� ���˸�����Ӧ��ʵ���࣬MyLibsDBContract.java�е��࣬
 * ��Ҫ�ǵ�������ִ�н������ɾ����Ĺ��ܡ�
 * 
 * ������ṩ���¹��ܣ� 1. ����һ�����ݿ⣨����Ҫ�ֶ����ã� 2. ���������ɾ��������Ҫ�ֶ����ã�
 * 
 * ʹ�÷����� 1. ��ȡ�����ʵ����ͨ��getInstance����ȡ 2.
 * ����getWritableDatabase������getReadableDatabase����ȡdbʵ��
 * 
 * @author yizhi401
 * 
 */
public class MyLibsDBHelper extends SQLiteOpenHelper {

	public static MyLibsDBHelper mInstance = null;

	public static final String DATABASE_NAME = "MyLibsDatabase.db";

	public static final int DATABASE_VERSION = 1;

	// ��������������Ϊ������ʱ��sql�������
	private static final String TEXT_TYPE = " TEXT";

	private static final String INTEGER_TYPE = " INTEGER";

	private static final String COMMA_SEP = ",";
	
	private static final String PRIMARY_KEY = "INTEGER PRIMARY KEY,";

	/**
	 * ֻ�ṩ����ģʽ����Ϊȫ��ֻ��Ҫһ��db����
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
	 * �������ݿ�ʱ�������÷��������б��ڴ˽���
	 * 
	 * @param db
	 */
	@Override
	public void onCreate(SQLiteDatabase db) {
		// �ڴ˽���
		createTable(db, Book.class);
		createTable(db, Shelf.class);
		createTable(db, Content.class);
		createTable(db, BSRelation.class);
		createTable(db, Keyword.class);
	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

		// TODO����ʱ���벻��Ҫ��ʲô�����������ݿ�����
	}

	public static final String SQL_CREATE_BSRELATIONTABLE = "CREATE TABLE "
			+ BSRelationTable.TABLE_NAME + " (" + BSRelationTable._ID
			+ "INTEGER PRIMARY��KEY," + BSRelationTable.COLUMN_BOOK + TEXT_TYPE
			+ COMMA_SEP + BSRelationTable.COLUMN_SHELF + TEXT_TYPE + COMMA_SEP
			+ " )";

	public static final String SQL_DELETE_BSRELATIONABLE = "DROP TABLE IF EXISTS"
			+ BSRelationTable.TABLE_NAME;

	/**
	 * �������ṩ��ʵ���������ݿ��н������db�д��ڴ˱�ֱ�ӷ���
	 * 
	 * @param <T>
	 * @param db
	 *            Ҫ��������ݿ�
	 * @param clazz
	 *            ʵ����
	 */
	public <T> void createTable(SQLiteDatabase db,Class<T> clazz){
		
		StringBuffer createTableSQL = new StringBuffer("CREATE TABLE ");
		Table tableName = clazz.getAnnotation(Table.class);
		if (tableName != null)
		{
			createTableSQL.append(tableName.tableName());
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
		}
		
	}

	/**
	 * �������ṩ��ʵ����ɾ����Ӧ�ı����db�޴˱������в���
	 * 
	 * @param <T>
	 * @param db
	 *            ���ݿ�
	 * @param clazz
	 *            ʵ����
	 */
	public <T> void deleteTable(SQLiteDatabase db, Class<T> clazz) {

	}

}
