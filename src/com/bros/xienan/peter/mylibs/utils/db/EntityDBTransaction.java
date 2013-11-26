package com.bros.xienan.peter.mylibs.utils.db;

import java.util.List;

import com.bros.xienan.peter.mylibs.utils.interfaces.IDBTransaction;


public class EntityDBTransaction<T> implements IDBTransaction<T>{

	@Override
	public void addDataToDB(List<T> data, Class<T> clazz) {
		// TODO Auto-generated method stub
		
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
