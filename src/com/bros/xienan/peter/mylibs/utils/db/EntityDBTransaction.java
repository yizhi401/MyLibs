package com.bros.xienan.peter.mylibs.utils.db;

import java.lang.reflect.Field;
import java.util.List;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import com.bros.xienan.peter.mylibs.utils.annotations.Column;
import com.bros.xienan.peter.mylibs.utils.annotations.Table;
import com.bros.xienan.peter.mylibs.utils.interfaces.IDBTransaction;

public class EntityDBTransaction<T> implements IDBTransaction<T> {

	/**
	 * 不管是转换哪一张表，dbHelper都是一定的
	 */
	private static MyLibsDBHelper dbHelper = null;

	private static SQLiteDatabase db = null;

	public EntityDBTransaction(Context context) {
		if (dbHelper == null) {
			dbHelper = MyLibsDBHelper.getInstance(context);
		}

	}

	@Override
	public void addDataToDB(List<T> data, Class<T> clazz) {

		if (data == null || data.size() == 0) {
			return;
		}

		// 如果给的clazz不是一张表，也return
		Table table = clazz.getAnnotation(Table.class);
		if (table == null) {
			return;
		}

		db = dbHelper.getWritableDatabase();
		db.beginTransaction();

		try {
			// 将data中的数据插入db
			for (int i = 0; i < data.size(); i++) {
				T item = data.get(i);
				ContentValues value = new ContentValues();

				Field[] fields = clazz.getDeclaredFields();

				// 将所有的column放入value，准备写入数据库
				for (Field field : fields) {
					if (field.isAnnotationPresent(Column.class)) {
						if (field.getType().equals(String.class)) {
							try {
								value.put(field.getName(),
										(String) field.get(item));
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
								value.put(field.getName(),
										(Long) field.get(item));
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
				db.insert(table.tableName(), null, value);
				db.update(table, values, whereClause, whereArgs)
			}

			db.setTransactionSuccessful();

		} catch (Exception e) {
			Log.i("mInfo", "插入数据失败");

		} finally {

			db.endTransaction();
		}

	}

	@Override
	public void deleteDataInDB(List<T> data, Class<T> clazz) {
		// TODO Auto-generated method stub

	}

	@Override
	public void changeDataInDB(List<T> data, Class<T> clazz) {
		// TODO Auto-generated method stub

	}

	@Override
	public List<T> queryDataFromDB(List<T> data, Class<T> clazz) {
		// TODO Auto-generated method stub
		return null;
	}

}
