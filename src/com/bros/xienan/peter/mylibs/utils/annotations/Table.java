package com.bros.xienan.peter.mylibs.utils.annotations;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * ORMע�⣬��עҪӳ��Ϊ�����
 * @author yizhi401
 *
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface Table {
	
	/**
	 * ӳ���ı���
	 * @return
	 */
	public String tableName() default "table_name";

}
