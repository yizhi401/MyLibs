package com.bros.xienan.peter.mylibs.utils.interfaces;

import java.util.List;

/**
 * xml�����ӿڣ�����xml�ļ�����Ϊʵ���ಢ����
 * @author yizhi401
 *
 */
public interface IXMLParser {
	
	public <T> List<T> getEntityFromXML(String xmlPath, Class<T> clazz); 

}
