package com.yuqiaotech.simplejee.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.yuqiaotech.simplejee.model.User;
import com.yuqiaotech.simplejee.utils.DBConnection;

public class UserDaoJDBC implements UserDao {

	private DBConnection db=DBConnection.getInstance();
	private Connection conn = null;
	private PreparedStatement ps = null;
	private ResultSet rs = null;

	@Override
	public void delete(Long id) {
		// TODO Auto-generated method stub
		conn=db.getConnection();
		String sql = "delete from user where id=" + id;
		try {
			ps = conn.prepareStatement(sql);
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			db.closeStatement(ps);
			db.close();
		}
	}

	@Override
	public void insert(User user) {
		// TODO Auto-generated method stub
		conn = db.getConnection();
		String sql = "insert into user(username,password,real_name,gender,age,birthday,email) values(?,?,?,?,?,?,?)";
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, user.getUsername());
			ps.setString(2, user.getPassword());
			ps.setString(3, user.getRealName());
			ps.setString(4, user.getGender());
			ps.setInt(5, user.getAge());
			ps.setString(6, user.getBirthday());
			ps.setString(7, user.getEmail());
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			db.closeStatement(ps);
			db.close();
		}
	}

	@Override
	public List<User> queryAll() {
		// TODO Auto-generated method stub
		conn = db.getConnection();
		List<User> users = new ArrayList<User>();
		String sql = "select * from user";
		try {
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery(sql);
			while (rs.next()) {
				User user = new User();
				composeUser(user, rs);
				users.add(user);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			db.closeResultSet(rs);
			db.closeStatement(ps);
			db.close();
		}
		return users;
	}

	@Override
	public void update(User user) {
		// TODO Auto-generated method stub
		conn =db.getConnection();
		String sql = "update user set username=?,password=?,real_name=?,age=?,birthday=?,email=? where id=?";
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, user.getUsername());
			ps.setString(2, user.getPassword());
			ps.setString(3, user.getRealName());
			//ps.setString(4, user.getGender());
			ps.setInt(4, user.getAge());
			ps.setString(5, user.getBirthday());
			ps.setString(6, user.getEmail());
			ps.setLong(7, user.getId());
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			db.closeStatement(ps);
			db.close();
		}
	}

	@Override
	public User findByUsername(String username) {
		// TODO Auto-generated method stub
		User user = null;
		conn = db.getConnection();
		String sql = "select * from user where username='"+username+"'";
		try {
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery(sql);
			if (rs.next()) {
				user = new User();
				composeUser(user, rs);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			db.closeResultSet(rs);
			db.closeStatement(ps);
			db.close();
		}
		return user;
	}

	@Override
	public User get(Long id) {
		// TODO Auto-generated method stub
		User user = null;
		conn = db.getConnection();
		String sql = "select * from user where id='"+id+"'";
		try {
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery(sql);
			if (rs.next()) {
				user = new User();
				composeUser(user, rs);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			db.closeResultSet(rs);
			db.closeStatement(ps);
			db.close();
		}
		return user;
	}

	private User composeUser(User user, ResultSet rs) {
		try {
			user.setId(rs.getLong("id"));
			user.setUsername(rs.getString("username"));
			user.setPassword(rs.getString("password"));
			user.setRealName(rs.getString("real_name"));
			user.setGender(rs.getString("gender"));
			user.setAge(rs.getInt("age"));
			user.setBirthday(rs.getString("birthday"));
			user.setEmail(rs.getString("email"));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return user;
	}

}
