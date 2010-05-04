package com.yuqiaotech.simplejee.dao;

public class UserDaoFactory {

	public static UserDao getUserDaoJDBC(){
		return new UserDaoJDBC();
	}
	
	public static UserDao getUserDaoHibernate(){
		return new UserDaoHibernate();
	}
}
