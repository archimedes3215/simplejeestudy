package com.yuqiaotech.simplejee.struts2.action;

import java.util.List;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;

import com.opensymphony.xwork2.ActionSupport;
import com.yuqiaotech.simplejee.dao.UserDao;
import com.yuqiaotech.simplejee.dao.UserDaoFactory;
import com.yuqiaotech.simplejee.model.User;
@Namespace("/user")
@Action("userAdmin")
@Results({
	@Result(name="list",location="/crud/list.jsp"),
	@Result(name="add",location="userAdmin",type="chain",params={"method","list"}),
	@Result(name="delete",location="userAdmin",type="chain",params={"method","list"}),
	@Result(name="update",location="userAdmin",type="chain",params={"method","list"}),
	@Result(name="prepareUpdate",location="/crud/edit.jsp")
})
public class UserAdminAction extends ActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private User user;
	private List<User> users;
	//Hibernate实现
	//private UserDao userDao = UserDaoFactory.getUserDaoHibernate();
	
	//JDBC实现
	private UserDao userDao = UserDaoFactory.getUserDaoJDBC();

	public String add() {
		userDao.insert(user);
		return "add";
	}

	public String delete() {
		userDao.delete(user.getId());
		return "delete";
	}

	public String update() {
		userDao.update(user);
		return "update";
	}

	public String list() {
		this.users=userDao.queryAll();
		return "list";
	}
	
	public String prepareUpdate(){
		user=userDao.get(user.getId());
		return "prepareUpdate";
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public List<User> getUsers() {
		return users;
	}

	public void setUsers(List<User> users) {
		this.users = users;
	}
	

}
