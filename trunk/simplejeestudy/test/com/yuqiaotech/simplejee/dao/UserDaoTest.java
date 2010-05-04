package com.yuqiaotech.simplejee.dao;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.BeforeClass;

import com.yuqiaotech.simplejee.model.User;

import static org.hamcrest.Matchers.*;

public class UserDaoTest {

	private static UserDao ud = null;

	@BeforeClass
	public static void beforeClass() {
		ud = UserDaoFactory.getUserDaoJDBC();
	}

	@Test
	public void testInsert() {
		User user = new User();
		user.setUsername("user1");
		user.setPassword("123456");
		user.setRealName("едед");
		user.setGender("Фа");
		user.setAge(24);
		user.setBirthday("1990-10-1");
		user.setEmail("zhaozhao@163.com");
		ud.insert(user);
	}
	
	@Test
	public void testFindByUsername(){
		User user=ud.findByUsername("user1");
		assertThat(user.getRealName(), is("едед"));
	}
}
