package com.yuqiaotech.simplejee.javase.reflect;

import static org.junit.Assert.assertTrue;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

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
	
	public Object populate(Object o, Map data){
		
		String className = null;
		String username=(String) data.get("username");
		String realName=(String) data.get("realName");
		Integer age=(Integer) data.get("age");
		String gender=(String) data.get("gender");
		//o.getClass().toString()之后的结果是：class com.yuqiaotech.simplejee.model.User
		//所以要取6之后的字符串
		className = o.getClass().toString().substring(6);
		try {
			Class clazz = Class.forName(className);
			//Constructor c = clazz.getConstructor();
			//Object o1 = c.newInstance();
			
			Method m1 = clazz.getMethod("setUsername", String.class);
			m1.invoke(o, new String(username));
			Method m2= clazz.getMethod("setRealName", String.class);
		    m2.invoke(o, new String(realName));
			Method m3=clazz.getMethod("setAge", Integer.class);
			m3.invoke(o, new Integer(age));
			Method m4=clazz.getMethod("setGender", String.class);
			m4.invoke(o, new String(gender));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return o;
	}

	@Test
	public void testToStringBuilder() throws IllegalArgumentException, IllegalAccessException, InvocationTargetException {
		Map data = new HashMap();
		data.put("username", "test");
		data.put("realName", "Tom");
		data.put("age", 12);
		data.put("gender", "男");
		
		User u = new User();
		populate(u,data);
		
		String str = reflectionToString(u);// 应该返回类似如下字符串:username:test,realName:Tom,age:12,gender:1,xxxxx
		assertTrue(str.contains("username:test"));
		assertTrue(str.contains("realName:Tom"));
		assertTrue(str.contains("age:12"));
		assertTrue(str.contains("gender:男"));

	}
}
