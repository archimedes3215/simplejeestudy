package com.yuqiaotech.simplejee.javase.reflect;

import static org.junit.Assert.assertTrue;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import org.junit.Test;

import com.yuqiaotech.simplejee.model.User;

public class ReflectTest {

	public String reflectionToString(Object o) throws IllegalArgumentException, IllegalAccessException, InvocationTargetException {
		// 使用反射完成本函数
		String toStr = "";
		Method[] method=o.getClass().getMethods();
		for(int i=0;i<method.length;i++){
			Method m=method[i];
			String mName=m.getName();
			if(mName.startsWith("get")){
				String proName=mName.substring(3, 4).toLowerCase()+mName.substring(4);
				toStr+=proName+":"+m.invoke(o)+",";
			}
		}
		return toStr;
	}

	@Test
	public void testToStringBuilder() throws IllegalArgumentException, IllegalAccessException, InvocationTargetException {
		User u = new User();
		u.setUsername("test");
		u.setRealName("Tom");
		u.setAge(12);
		u.setGender("男");
		String str = reflectionToString(u);// 应该返回类似如下字符串:username:test,realName:Tom,age:12,gender:1,xxxxx
		assertTrue(str.contains("username:test"));
		assertTrue(str.contains("realName:Tom"));
		assertTrue(str.contains("age:12"));
		assertTrue(str.contains("gender:男"));

	}
}
