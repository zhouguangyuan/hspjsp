package com.hsp.utils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;

public class SqlHelper {
	private Connection ct = null;
	private ResultSet rs = null;
	private PreparedStatement ps = null;

	public Connection getCt() {
		return ct;
	}

	public PreparedStatement getPs() {
		return ps;
	}

	public ResultSet getRs() {
		return rs;
	}

	/** 传入表名，返回该表的记录数* */
	public int getRowCount(String sql) {
		int rowCount = 0;
		ct = DBUtil.getConn();
		try {
			ps = ct.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				rowCount = rs.getInt(1);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBUtil.closeResource(rs, ps, ct);
		}
		return rowCount;
	}

	public int getRowCount(String sql, String[] paras) {
		int rowCount = 0;
		ct = DBUtil.getConn();
		try {
			ps = ct.prepareStatement(sql);
			if (paras != null) {
				for (int i = 0; i < paras.length; i++) {
					ps.setString(i + 1, paras[i]);
				}
			}
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				rowCount = rs.getInt(1);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBUtil.closeResource(rs, ps, ct);
		}
		return rowCount;
	}

	/** 传入sql语句返回查询结果封装成对象（每一行表示一个对象）集合* */
	public ArrayList executeQuery(String sql, String paras[]) {
		ArrayList al = new ArrayList();
		try {
			ct = DBUtil.getConn();
			ps = ct.prepareStatement(sql);
			for (int i = 0; i < paras.length; i++) {
				ps.setString(i + 1, paras[i]);
			}
			rs = ps.executeQuery();
			ResultSetMetaData rsmd = rs.getMetaData();
			int columnNum = rsmd.getColumnCount();
			while (rs.next()) {
				Object objects[] = new Object[columnNum];
				for (int i = 0; i < objects.length; i++) {
					objects[i] = rs.getObject(i + 1);
				}
				al.add(objects);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBUtil.closeResource(rs, ps, ct);
		}
		return al;
	}

	public boolean executeupdate(String sql, String[] paras) {
		ct = DBUtil.getConn();
		try {
			ps = ct.prepareStatement(sql);
			if (paras != null) {
				for (int i = 0; i < paras.length; i++) {
					ps.setString(i + 1, paras[i]);
				}
			}
			boolean n = ps.execute();
			System.out.println("n的值：" + n);
			return n;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new RuntimeException(e.getMessage());
		} finally {
			DBUtil.closeResource(rs, ps, ct);
		}

	}
}