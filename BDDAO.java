package com.bookshop;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class BDDAO {
	public static String DB_NAME = "user_ip";

	public void createDB() {

	}

	public String getFirstName() {

		// 1. 驱动

		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		// 2.链接
		Connection conn = null;
		try {
//			test 表示数据库   root 表示用户名  123456 表示密码
			conn = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/test", "root", "123456");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		// 3. 创建Statement
		Statement stmt = null;
		ResultSet rs = null;
		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery("SELECT count(*) FROM " + DB_NAME);
			int nCount = 0;
			while (rs.next()) {
				String name = rs.getString(1);
				nCount = rs.getInt(1);
				return nCount + "";
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			return "" + e.toString();
		}

		// 4.关闭
		if (rs != null) {
			try {
				rs.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		if (stmt != null) {
			try {
				stmt.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		if (conn != null) {
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return "找不到";

	}

	public void Insert(String strIP) {

		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		Connection conn = null;
		try {
			conn = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/test", "root", "123456");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		Statement stmt = null;
		try {
			stmt = conn.createStatement();
			stmt.execute("INSERT " + DB_NAME + " (name) VALUES ('" + strIP
					+ "')");

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.toString();
		}

		if (stmt != null) {
			try {
				stmt.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		if (conn != null) {
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}
}
