package com.hsp.service;

import java.util.ArrayList;

import com.hsp.domain.Users;
import com.hsp.utils.SqlHelper;

public class UsersService {
	// 验证用户是否合法
	public boolean checkUser(Users user) {
		// 到数据库去验证
		String sql = "SELECT * FROM test.users where id=? and passwd=?";
		String paras[] = { user.getId() + "", user.getPassword() };

		ArrayList al = new SqlHelper().executeQuery(sql, paras);
		if (al.size() == 0) {
			return false;
		} else {
			Object[] objects = (Object[]) al.get(0);
			user.setUsername((String) objects[1]);
			user.setGrade(Integer.parseInt(objects[5].toString()));
			return true;
		}
	}
}
