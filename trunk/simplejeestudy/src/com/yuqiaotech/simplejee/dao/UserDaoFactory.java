package com.yuqiaotech.simplejee.dao;

public class UserDaoFactory {

	public static UserDao getUserDaoJDBC(){
		return new UserDaoJDBC();
	}
}
