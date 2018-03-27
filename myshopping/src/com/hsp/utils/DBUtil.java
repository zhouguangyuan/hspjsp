package com.hsp.utils;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

//这是一个工具类，专门用于得到连接和关闭连接
public class DBUtil {
	private static Connection ct = null;// 定义数据库连接
	private PreparedStatement ps = null;// 定义数据库操作类
	private ResultSet rs = null;// 输出数据类

	// 连接数据库参数
	private static String url = "";
	private static String drivername = "";
	private static String username = "";
	private static String password = "";
	private static InputStream fiS;

	// 加载驱动，static块（只能执行一次）
	static {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Properties pp = new Properties();
			fiS = DBUtil.class.getClassLoader().getResourceAsStream(
					"db.properties"); // 注意放在src目录下，
			pp.load(fiS);
			// 属性文件读取信息
			drivername = pp.getProperty("dbDriver");
			username = pp.getProperty("dbUserName");
			password = pp.getProperty("dbPassWord");
			url = pp.getProperty("dbUrl");
			Class.forName(drivername);
			System.out.println("得到数据源");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				fiS.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	// 取得链接
	public static Connection getConn() {
		try {
			/*
			 * 在这里我犯了一个错误，此方法中前三个参数都是String类型的，但是三个参数分别为不同的含义： 第一个参数为url，
			 * 第二个参数为username， 第三个参数为password，我从别人那里复制过来的代码
			 * 将第一个参数和第二个参数颠倒了，结果编译时不出错，到了运行时总是提示， 
			 * java.sql.SQLException: No suitable driver at java.sql.DriverManager.getConnection(Unknown
			 * Source) at java.sql.DriverManager.getConnection(Unknown Source)
			 * at com.hsp.utils.DBUtil.getConn(DBUtil.java:59)
			 */
			ct = DriverManager.getConnection(url, username, password);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return ct;
	}

	// 关闭资源(先开后关)
	public static void closeResource(ResultSet rs, PreparedStatement ps,
			Connection ct) {

		if (rs != null) {
			try {
				rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			rs = null;
		}
		if (ps != null) {
			try {
				ps.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			ps = null;
		}
		if (null != ct) {
			try {
				ct.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			ct = null;
		}
	}
}
