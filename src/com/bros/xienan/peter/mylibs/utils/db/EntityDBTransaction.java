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
	 * ������ת����һ�ű�dbHelper����һ����
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

		// �������clazz����һ�ű�Ҳreturn
		Table table = clazz.getAnnotation(Table.class);
		if (table == null) {
			return;
		}

		db = dbHelper.getWritableDatabase();
		db.beginTransaction();

		try {
			// ��data�е����ݲ���db
			for (int i = 0; i < data.size(); i++) {
				T item = data.get(i);
				ContentValues value = new ContentValues();

				Field[] fields = clazz.getDeclaredFields();

				// �����е�column����value��׼��д�����ݿ�
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
			Log.i("mInfo", "��������ʧ��");

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
