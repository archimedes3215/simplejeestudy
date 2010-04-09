package com.yuqiaotech.simplejee.dao;

import java.util.List;


import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.yuqiaotech.simplejee.model.User;
import com.yuqiaotech.simplejee.utils.HibernateUtils;

public class UserDaoHibernate implements UserDao {

	private Session session=null;
	private Transaction ts=null;
	
	@Override
	public void delete(Long id) {
		// TODO Auto-generated method stub
		User user=null;
		try {
			session = HibernateUtils.getSession();
			ts = session.beginTransaction();
			user=(User)session.get(User.class, id);
			session.delete(user);
			ts.commit();
		} catch (Exception e) {
			e.printStackTrace();
			ts.rollback();
		} finally {
			HibernateUtils.closeSession(session);
		}
	}

	@Override
	public User findByUsername(String username) {
		// TODO Auto-generated method stub
		User user=null;
		try {
			session = HibernateUtils.getSession();
			ts = session.beginTransaction();
			Query q = session.createQuery("from User u where u.username=?").setParameter(0, username);
			user=(User)q.uniqueResult();
			ts.commit();
		} catch (Exception e) {
			e.printStackTrace();
			ts.rollback();
		} finally {
			HibernateUtils.closeSession(session);
		}
		return user;
	}

	@Override
	public User get(Long id) {
		// TODO Auto-generated method stub
		User user=null;
		try {
			session = HibernateUtils.getSession();
			ts = session.beginTransaction();
			user=(User)session.get(User.class, id);
			ts.commit();
		} catch (Exception e) {
			e.printStackTrace();
			ts.rollback();
		} finally {
			HibernateUtils.closeSession(session);
		}
		return user;
	}

	@Override
	public void insert(User user) {
		// TODO Auto-generated method stub
		try {
			session = HibernateUtils.getSession();
			ts = session.beginTransaction();
			session.save(user);
			ts.commit();
		} catch (Exception e) {
			e.printStackTrace();
			ts.rollback();
		} finally {
			HibernateUtils.closeSession(session);
		}
	}

	@Override
	public List<User> queryAll() {
		// TODO Auto-generated method stub
		List<User> users=null;
		try {
			session = HibernateUtils.getSession();
			ts = session.beginTransaction();
			Query q = session.createQuery("from User");
			users = (List<User>)q.list();
			ts.commit();
		} catch (Exception e) {
			e.printStackTrace();
			ts.rollback();
		} finally {
			HibernateUtils.closeSession(session);
		}
		
		return users;
	}

	@Override
	public void update(User user) {
		// TODO Auto-generated method stub
		try {
			session = HibernateUtils.getSession();
			ts = session.beginTransaction();
			session.update(user);
			ts.commit();
		} catch (Exception e) {
			e.printStackTrace();
			ts.rollback();
		} finally {
			HibernateUtils.closeSession(session);
		}
	}

}
