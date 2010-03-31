package com.yuqiaotech.simplejee.javase.reflect;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

import com.yuqiaotech.simplejee.model.User;

import static java.lang.Class.forName;
import static org.junit.Assert.*;
import org.junit.Test;

public class ReflectTest {

	public String reflectionToString(String className) {
		// 使用反射完成本函数
		String str = null;
		//String className = null;
		//className = o.getClass().toString().substring(6);
		try {
			Class clazz = Class.forName(className);
			Constructor c = clazz.getConstructor();
			Object o1 = c.newInstance();
			
			Method m1 = clazz.getMethod("setUsername", String.class);
			m1.invoke(o1, new String("test"));
			Method m2= clazz.getMethod("setRealName", String.class);
		    m2.invoke(o1, new String("Tom"));
			Method m3=clazz.getMethod("setAge", Integer.class);
			m3.invoke(o1, new Integer(12));
			Method m4=clazz.getMethod("setGender", Integer.class);
			m4.invoke(o1, new Integer(1));
			
			String username = (String)(clazz.getMethod("getUsername", null).invoke(o1, null));
			String realname = (String)clazz.getMethod("getRealName", null).invoke(o1, null);
			Integer age = (Integer)clazz.getMethod("getAge", null).invoke(o1, null);
			Integer gender = (Integer)clazz.getMethod("getGender", null).invoke(o1, null);
			//如果要灵活点可以用List
			str="username:"+username+",realName:"+realname+",age:"+age+",gender:"+gender;
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return str;
	}

	@Test
	public void testToStringBuilder() {
/*		User u = new User();
		u.setUsername("test");
		u.setRealName("Tom");
		u.setAge(12);
		u.setGender(1);*/
		String str = reflectionToString("com.yuqiaotech.simplejee.model.User");// 应该返回类似如下字符串:username:test,realName:Tom,age:12,gender:1,xxxxx
		assertTrue(str.contains("username:test"));
		assertTrue(str.contains("realName:Tom"));
		assertTrue(str.contains("age:12"));
		assertTrue(str.contains("gender:1"));

	}
}
