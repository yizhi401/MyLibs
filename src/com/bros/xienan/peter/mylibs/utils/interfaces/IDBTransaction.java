package com.bros.xienan.peter.mylibs.utils.interfaces;

import java.util.List;

/**
 * ���ݿ��ʵ����ֱ���໥ת���Ľӿ�
 * @author yizhi401
 *
 * @param <T>
 */
public interface IDBTransaction{

	/**
	 * ��һ��list<ʵ����>д�����ݿ⣬������ݿ��Ѿ��и����ݣ����滻
	 * @param data  ʵ����Ҫд�������
	 * @param clazz ʵ�����Ӧ��
	 */
	public <T> void addDataToDB(List<T> data,Class<T> clazz);
	
	/**
	 * ��һ��list<ʵ����>�����ݿ���ɾ����������ݿ���û���������ݣ�������,������_ID�ֶν���ɾ��
	 * @param data  ʵ����Ҫд�������
	 * @param clazz ʵ�����Ӧ��
	 */
	public <T> void deleteDataInDB(List<T> data, Class<T> clazz);
	
	/**
	 * ��һ��list<ʵ����>���µ����ݿ���
	 * @param data  ʵ����Ҫд�������
	 * @param clazz ʵ�����Ӧ��
	 */
	public <T> void updateDataInDB(List<T> data, Class<T> clazz);
	
	/**
	 * ����ʵ�����в�Ϊnull����������ѯ���ݿ⣬���ҷ���Ϊlist<T>
	 * @param data  ʵ����Ҫд�������
	 * @param clazz ʵ�����Ӧ��
	 */
	public <T> List<T> queryDataFromDB(T item, Class<T> clazz);
}
