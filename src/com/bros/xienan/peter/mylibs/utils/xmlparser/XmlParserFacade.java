package com.bros.xienan.peter.mylibs.utils.xmlparser;

import java.util.List;

import com.bros.xienan.peter.mylibs.model.Book;

import android.content.Context;

/**
 * xml解析管理类，负责接收一个路径和class，就给你返回相应你所需要的实体类
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
			//把xmlPath传给bookXmlParser
		}
		
		return null;
	}
	

}
