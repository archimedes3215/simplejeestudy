package com.yuqiaotech.simplejee.jdbc;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

import com.yuqiaotech.simplejee.utils.DBConnection;

public class JDBCMetaData {
	
	public static void main(String[] args) {
		DBConnection db=DBConnection.getInstance();
		Connection conn = null;
		Statement sm = null;
		ResultSet rs = null;
		try {
			conn = db.getConnection();
			sm = conn.createStatement();

			// 获取所有的表
			System.out.println("打印simplejee库的所有表名");
			ResultSet rsTables = conn.getMetaData().getTables(null, null, null,
					new String[] { "TABLE" });
			while (rsTables.next()) {
				System.out.println(rsTables.getString("TABLE_NAME"));
			}

			System.out.println("打印worker表的所有字段");
			ResultSet rsColumns = conn.getMetaData().getColumns(null, null,
					"worker", null);
			while (rsColumns.next()) {
				System.out.println(rsColumns.getString("COLUMN_NAME"));
			}

			// 查询数据
			String sql = "select name,gender from worker";
			// 查询结果是保存在一个ResultSet的对象里
			rs = sm.executeQuery(sql);
			// 通过ResultSetMetaData可以获取结果集本身的一些信息，如字段等
			ResultSetMetaData md = rs.getMetaData();
			int colCount = md.getColumnCount();

			// 对resultset调用next方法，可以讲数据指向第一条，
			// 调用类似getString之类的方法就可以获取该数据某个字段的值
			System.out.println("打印查询记录的列名和内容。");
			while (rs.next()) {
				for (int i = 0; i < colCount; i++) {
					String colName = md.getColumnName(i + 1);
					System.out.print(" " + colName + ":" + rs.getObject(i + 1));
				}
				System.out.println();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			db.closeResultSet(rs);
			db.closeStatement(sm);
			db.close();
		}
	}
}
