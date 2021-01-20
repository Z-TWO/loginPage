package com.loginPage.test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.loginPage.dao.DBMain;
import com.loginPage.model.User;
import com.loginPage.util.DBUtil;

public class test {
	static String sql = "select * from user where username=?";
	
	public static void main(String[] args) {
		User user = DBMain.selectUser("username", "用户名1");
		if (user != null) {
			System.out.println("username:"+user.getUsername()+"  password:"+user.getPassword());
		}else {
			System.out.println("null");
		}
		boolean isContain = DBMain.isContain("名1");
		System.out.println("isContain:"+isContain);
	}
}
