package com.hsp.utils;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

//����һ�������࣬ר�����ڵõ����Ӻ͹ر�����
public class DBUtil {
	private static Connection ct = null;// �������ݿ�����
	private PreparedStatement ps = null;// �������ݿ������
	private ResultSet rs = null;// ���������

	// �������ݿ����
	private static String url = "";
	private static String drivername = "";
	private static String username = "";
	private static String password = "";
	private static InputStream fiS;

	// ����������static�飨ֻ��ִ��һ�Σ�
	static {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Properties pp = new Properties();
			fiS = DBUtil.class.getClassLoader().getResourceAsStream(
					"db.properties"); // ע�����srcĿ¼�£�
			pp.load(fiS);
			// �����ļ���ȡ��Ϣ
			drivername = pp.getProperty("dbDriver");
			username = pp.getProperty("dbUserName");
			password = pp.getProperty("dbPassWord");
			url = pp.getProperty("dbUrl");
			Class.forName(drivername);
			System.out.println("�õ�����Դ");
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

	// ȡ������
	public static Connection getConn() {
		try {
			/*
			 * �������ҷ���һ�����󣬴˷�����ǰ������������String���͵ģ��������������ֱ�Ϊ��ͬ�ĺ��壺 ��һ������Ϊurl��
			 * �ڶ�������Ϊusername�� ����������Ϊpassword���Ҵӱ������︴�ƹ����Ĵ���
			 * ����һ�������͵ڶ��������ߵ��ˣ��������ʱ��������������ʱ������ʾ�� 
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

	// �ر���Դ(�ȿ����)
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
