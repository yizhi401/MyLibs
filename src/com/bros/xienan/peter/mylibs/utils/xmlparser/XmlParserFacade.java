package com.bros.xienan.peter.mylibs.utils.xmlparser;

import java.util.List;

import com.bros.xienan.peter.mylibs.model.Book;

import android.content.Context;

/**
 * xml���������࣬�������һ��·����class���͸��㷵����Ӧ������Ҫ��ʵ����
 * @author yizhi401
 *
 */
public class XmlParserFacade{
	
	Context context;
	
	public XmlParserFacade(Context context){
		this.context = context;
	}
	
	public <T> List<T> getEntityFromXml(String xmlPath, Class<T> clazz){

		String className = clazz.getName();
		
		if (className == Book.class.getName()){
			//��xmlPath����bookXmlParser
		}
		
		return null;
	}
	

}
