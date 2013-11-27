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
 * ���ݿ�����࣬�ṩ��ʵ�����List�����ݿ�֮���໥ת�����ܣ�֧����ɾ�Ĳ�
 * 
 * 
 * @author yizhi401
 * 
 * @param <T>
 */
public class EntityDBTransaction implements IDBTransaction {

	/**
	 * ������ת����һ�ű�dbHelper����һ����
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
	 * ����ģʽ˽�й��췽��
	 * 
	 * @param context
	 */
	private EntityDBTransaction(Context context) {
		if (dbHelper == null) {
			dbHelper = MyLibsDBHelper.getInstance(context);
		}
	}

	/**
	 * �μ���ؽӿ�˵��IDBTransaction
	 * 
	 * @param data
	 * @param clazz
	 */
	@Override
	public <T> void addDataToDB(List<T> data, Class<T> clazz) {

		if (data == null || data.size() == 0) {
			return;
		}

		// �������clazz����һ�ű�Ҳreturn
		Table table = clazz.getAnnotation(Table.class);
		if (table == null) {
			return;
		}

		SQLiteDatabase db = dbHelper.getWritableDatabase();
		db.beginTransaction();
		try {
			// ��data�е����ݲ���db
			for (int i = 0; i < data.size(); i++) {
				T item = data.get(i);

				ContentValues value = this.getValueFromEntity(item, clazz);
				db.insert(table.tableName(), null, value);
			}

			db.setTransactionSuccessful();

		} catch (Exception e) {
			Log.i("mInfo", "��������ʧ��");

		} finally {

			db.endTransaction();
		}

	}

	/**
	 * �����ݿ���ɾ�����ݣ���֧�ָ���IDɾ����Ӧ����Ŀ������ɾ�������в���
	 * 
	 * @param data
	 *            Ҫɾ�����ݵļ��ϣ��ڴ˼����е����ݾ��ᱻɾ��
	 * @param clazz
	 *            ��
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
	 * ���±������ݣ� ����ID�����и��£�����ȫ��column
	 * 
	 * @param data Ҫ���µ���Ŀ����
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
	 * �����ݿ��в�ѯ��ֻ���ṩһ����ѯ��������item�в�λnull��column��Ϊ��ѯ����
	 * ע�⣺Ŀǰ��Ϊnull��������Ϊand���ӣ����Ҫʹ��or�����ӣ����ȡ��β�ѯ
	 * ���ԣ������Լ�дsql���,������᷵�����е�column�����Ҫָ����column�����в�ѯ ��ѯ�������ID��������
	 * 
	 * ע�⣺��ѯ�ı��б��뺬��_id��һ��
	 * 
	 * @param item
	 *            ��ѯ���� Ϊnull��ʾ��ѯ������
	 * @param clazz
	 *            ��ѯ��ʵ����
	 * @return List<T> ���ؽ��
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
					// item ת��Ϊ��ѯ����selection �� selectionArgs
					try {
						// item��������Բ�Ϊnull��˵���ǲ�ѯ����
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

							// �����string����ֱ�����
							if (field.getType().equals(String.class)) {
								selectionArgs.add((String) field.get(item));
							}

							// �����Long���ͣ�ת��Ϊstring
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
		// �õ���ѯ���cursor
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
		// ��cursorת��Ϊʵ����list<T>������
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
	 * �����������ʵ���࣬����ת��ΪContentValue�Թ����ݿ��дʹ��
	 * 
	 * @param item
	 *            ʵ����
	 * @param clazz
	 *            ʵ�����clazz
	 * @return
	 */
	private <T> ContentValues getValueFromEntity(T item, Class<T> clazz) {

		ContentValues value = new ContentValues();
		Field[] fields = clazz.getDeclaredFields();

		// �����е�column����value��׼��д�����ݿ�
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
