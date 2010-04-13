package com.yuqiaotech.simplejee.annotation;

import java.lang.reflect.Method;

import javax.persistence.Column;

import org.junit.Test;

import com.yuqiaotech.simplejee.model.User;


public class AnnotationTest {

	@Test
	public void testAnnotation(){
		Method m = null;
		try {
			m = User.class.getMethod("getUsername");
		} catch (SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NoSuchMethodException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Column column=m.getAnnotation(Column.class);
		System.out.println("Column注解的value属性的值为:"+column.nullable());
	}
}
