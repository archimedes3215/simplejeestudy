package com.yuqiaotech.simplejee.dao;

import java.util.List;

import com.yuqiaotech.simplejee.model.User;

public interface UserDao {

	public List<User> queryAll();
	
	public void insert(User user);
	
	public void delete(Long id);
	
	public void update(User user);
	
	public User findByUsername(String username);
	
	public User get(Long id);
}
