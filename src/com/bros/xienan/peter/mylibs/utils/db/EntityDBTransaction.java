package com.bros.xienan.peter.mylibs.utils.db;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import com.bros.xienan.peter.mylibs.utils.annotations.Column;
import com.bros.xienan.peter.mylibs.utils.annotations.Table;
import com.bros.xienan.peter.mylibs.utils.interfaces.IDBTransaction;

/**
 * 数据库基础类，提供将实体类的List与数据库之间相互转化功能，支持增删改查
 * 
 * 
 * @author yizhi401
 * 
 * @param <T>
 */
public class EntityDBTransaction implements IDBTransaction {

	/**
	 * 不管是转换哪一张表，dbHelper都是一定的
	 */
	private static MyLibsDBHelper dbHelper = null;

	private static EntityDBTransaction mInstance = null;

	public EntityDBTransaction getInstance(Context context) {

		if (mInstance == null) {
			mInstance = new EntityDBTransaction(context);
		}

		return mInstance;
	}

	/**
	 * 单例模式私有构造方法
	 * 
	 * @param context
	 */
	private EntityDBTransaction(Context context) {
		if (dbHelper == null) {
			dbHelper = MyLibsDBHelper.getInstance(context);
		}
	}

	/**
	 * 参加相关接口说明IDBTransaction
	 * 
	 * @param data
	 * @param clazz
	 */
	@Override
	public <T> void addDataToDB(List<T> data, Class<T> clazz) {

		if (data == null || data.size() == 0) {
			return;
		}

		// 如果给的clazz不是一张表，也return
		Table table = clazz.getAnnotation(Table.class);
		if (table == null) {
			return;
		}

		SQLiteDatabase db = dbHelper.getWritableDatabase();
		db.beginTransaction();
		try {
			// 将data中的数据插入db
			for (int i = 0; i < data.size(); i++) {
				T item = data.get(i);

				ContentValues value = this.getValueFromEntity(item, clazz);
				db.insert(table.tableName(), null, value);
			}

			db.setTransactionSuccessful();

		} catch (Exception e) {
			Log.i("mInfo", "插入数据失败");

		} finally {

			db.endTransaction();
		}

	}

	/**
	 * 从数据库中删除数据，仅支持根据ID删除对应的条目，其他删除请自行操作
	 * 
	 * @param data
	 *            要删除数据的集合，在此集合中的数据均会被删除
	 * @param clazz
	 *            表
	 */
	@Override
	public <T> void deleteDataInDB(List<T> data, Class<T> clazz) {

		Table table = clazz.getAnnotation(Table.class);

		if (table == null || data == null || data.size() == 0) {
			return;
		}

		SQLiteDatabase db = dbHelper.getWritableDatabase();

		db.beginTransaction();
		try {
			for (int i = 0; i < data.size(); i++) {
				T item = data.get(i);

				Field field = clazz.getDeclaredField("_ID");
				String selection = field.getName() + " =?";
				String[] selectionArgs = { String.valueOf(field.getLong(item)) };

				db.delete(table.tableName(), selection, selectionArgs);

			}

			db.setTransactionSuccessful();

		} catch (NoSuchFieldException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			db.endTransaction();
		}

	}

	/**
	 * 更新表中数据， 按照ID来进行更新，更新全部column
	 * 
	 * @param data 要更新的条目集合
	 * 
	 * @param clazz 
	 * 
	 */
	@Override
	public <T> void updateDataInDB(List<T> data, Class<T> clazz) {
		

		Table table = clazz.getAnnotation(Table.class);

		if (table == null || data == null || data.size() == 0) {
			return;
		}

		SQLiteDatabase db = dbHelper.getWritableDatabase();

		db.beginTransaction();
		try {
			for (int i = 0; i < data.size(); i++) {
				T item = data.get(i);

				Field field = clazz.getDeclaredField("_ID");
				String selection = field.getName() + " =?";
				String[] selectionArgs = { String.valueOf(field.getLong(item)) };
				
				ContentValues value = this.getValueFromEntity(item, clazz);
				
				db.update(table.tableName(), value, selection, selectionArgs);
			}

			db.setTransactionSuccessful();

		} catch (NoSuchFieldException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			db.endTransaction();
		}


	}

	/**
	 * 从数据库中查询，只能提供一个查询条件，将item中部位null的column作为查询条件
	 * 注意：目前不为null的语句均作为and连接，如果要使用or来连接，请采取多次查询
	 * 策略，或者自己写sql语句,结果将会返回所有的column，如果要指定的column请自行查询 查询结果按照ID升序排列
	 * 
	 * 注意：查询的表中必须含有_id这一列
	 * 
	 * @param item
	 *            查询条件 为null表示查询所有项
	 * @param clazz
	 *            查询的实体类
	 * @return List<T> 返回结果
	 * 
	 */
	@Override
	public <T> List<T> queryDataFromDB(T item, Class<T> clazz) {

		Table table = clazz.getAnnotation(Table.class);

		if (table == null) {
			return null;
		}

		final String CONDITION = "=?";
		final String AND = " AND ";
		SQLiteDatabase db = dbHelper.getReadableDatabase();

		StringBuffer selection = null;
		List<String> selectionArgs = new ArrayList<String>();

		if (item != null) {

			Field[] fields = clazz.getDeclaredFields();

			for (Field field : fields) {
				if (field.isAnnotationPresent(Column.class)) {
					// item 转化为查询条件selection 和 selectionArgs
					try {
						// item的这个属性不为null，说明是查询条件
						if (field.get(item) != null) {
							if (selection == null) {
								selection = new StringBuffer("");
								selection.append(field.getName());
								selection.append(CONDITION);
							} else {
								selection.append(AND);
								selection.append(field.getName());
								selection.append(CONDITION);
							}

							// 如果是string类型直接添加
							if (field.getType().equals(String.class)) {
								selectionArgs.add((String) field.get(item));
							}

							// 如果是Long类型，转化为string
							if (field.getType().equals(Long.class)) {
								selectionArgs.add(((Long) field.get(item))
										.toString());
							}
						}
					} catch (IllegalArgumentException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (IllegalAccessException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
		}
		// 得到查询结果cursor
		String sortOrder = "_ID ASC";

		Cursor cursor;
		if (selection == null) {

			cursor = db.query(table.tableName(), null, null, null, null, null,
					sortOrder);
		} else {
			cursor = db.query(table.tableName(), null, selection.toString(),
					selectionArgs.toArray(new String[selectionArgs.size()]),
					null, null, sortOrder);
		}
		// 将cursor转化为实体类list<T>并返回
		List<T> data = new ArrayList<T>();

		cursor.moveToFirst();

		while (!cursor.isAfterLast()) {
			T newItem = cursorToEntity(cursor, clazz);
			data.add(newItem);
			cursor.moveToNext();
		}

		return data;
	}

	private <T> T cursorToEntity(Cursor cursor, Class<T> clazz) {

		try {
			T item = clazz.newInstance();

			Field[] fields = clazz.getDeclaredFields();

			for (Field field : fields) {
				if (field.isAnnotationPresent(Column.class)) {
					int columnIndex = cursor.getColumnIndex(field.getName());

					if (field.getType().equals(String.class)) {
						field.set(item, cursor.getString(columnIndex));
					}

					if (field.getType().equals(Long.class)) {
						field.set(item, cursor.getLong(columnIndex));
					}
				}
			}

			return item;
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return null;
	}

	/**
	 * 根据所传入的实体类，将其转化为ContentValue以供数据库读写使用
	 * 
	 * @param item
	 *            实体类
	 * @param clazz
	 *            实体类的clazz
	 * @return
	 */
	private <T> ContentValues getValueFromEntity(T item, Class<T> clazz) {

		ContentValues value = new ContentValues();
		Field[] fields = clazz.getDeclaredFields();

		// 将所有的column放入value，准备写入数据库
		for (Field field : fields) {
			if (field.isAnnotationPresent(Column.class)) {
				if (field.getType().equals(String.class)) {
					try {
						value.put(field.getName(), (String) field.get(item));
					} catch (IllegalArgumentException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (IllegalAccessException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}

				if (field.getType().equals(Long.class)) {
					try {
						value.put(field.getName(), (Long) field.get(item));
					} catch (IllegalArgumentException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (IllegalAccessException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
		}
		return value;
	}

}
