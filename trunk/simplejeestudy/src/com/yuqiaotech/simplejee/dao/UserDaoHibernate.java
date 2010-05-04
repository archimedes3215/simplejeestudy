package com.yuqiaotech.simplejee.dao;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Component;

import com.yuqiaotech.simplejee.model.User;

@Component("userDaoHibernate")
public class UserDaoHibernate implements UserDao {

	private HibernateTemplate hibernateTemplate;

	@Override
	public void delete(Long id) {
		// TODO Auto-generated method stub
		User user = (User) hibernateTemplate.get(User.class, id);
		hibernateTemplate.delete(user);
	}

	@Override
	public User findByUsername(String username) {
		// TODO Auto-generated method stub
		User user = (User) hibernateTemplate.find(
				"from User u where u.username=?", new Object[] { username });
		return user;
	}

	@Override
	public User get(Long id) {
		User user = (User) hibernateTemplate.get(User.class, id);
		return user;
	}

	@Override
	public void insert(User user) {
		hibernateTemplate.save(user);
	}

	@Override
	public List<User> queryAll() {
		// TODO Auto-generated method stub
		List<User> users = hibernateTemplate.find("from User");
		return users;
	}

	@Override
	public void update(User user) {
		hibernateTemplate.update(user);
	}

	/**
	 * @return the hibernateTemplate
	 */
	public HibernateTemplate getHibernateTemplate() {
		return hibernateTemplate;
	}

	/**
	 * @param hibernateTemplate
	 *            the hibernateTemplate to set
	 */
	@Resource
	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}

}
