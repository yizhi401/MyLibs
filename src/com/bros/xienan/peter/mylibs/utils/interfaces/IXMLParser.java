package com.bros.xienan.peter.mylibs.utils.interfaces;

import java.util.List;

/**
 * xml解析接口，负责将xml文件解析为实体类并返回
 * @author yizhi401
 *
 */
public interface IXmlParser {
	
	public List getEntityFromXML(String xmlPath); 

}
