package com.yuqiaotech.simplejee.dao;

import java.util.List;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import com.yuqiaotech.simplejee.model.User;

public class UserDaoHibernate extends HibernateDaoSupport implements UserDao {
	
	@Override
	public void delete(Long id) {
		// TODO Auto-generated method stub
		User user = (User) this.getHibernateTemplate().get(User.class, id);
		this.getHibernateTemplate().delete(user);
	}

	@Override
	public User findByUsername(String username) {
		// TODO Auto-generated method stub
		List<User> users = this.getHibernateTemplate().find(
				"from User u where u.username=?", new Object[] { username });
		return users.get(0);
	}

	@Override
	public User get(Long id) {
		return (User) this.getHibernateTemplate().get(User.class, id);
	}

	@Override
	public void insert(User user) {
		this.getHibernateTemplate().save(user);
	}

	@Override
	public List<User> queryAll() {
		// TODO Auto-generated method stub
		return this.getHibernateTemplate().find("from User");
	}

	@Override
	public void update(User user) {
		this.getHibernateTemplate().update(user);
	}

}
