package com.loginPage.util;


import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.apache.commons.dbcp2.BasicDataSource;

public class DBUtil {
	private static final String url = "jdbc:mysql://8.129.224.99:3306/students?useUnicode=true&characterEncoding=UTF-8&useSSL=false";
	private static final String username = "root";
	private static final String password = "kczx402!!!";
	private static BasicDataSource dbcp;
	
	//创建dbcp数据源
	static{
		dbcp = new BasicDataSource();
		dbcp.setDriverClassName("com.mysql.jdbc.Driver");
		//创建连接
		dbcp.setUrl(url);
		dbcp.setUsername(username);
		dbcp.setPassword(password);
		//设置参数
		dbcp.setInitialSize(5);
		dbcp.setMaxTotal(20);
		dbcp.setMinIdle(2);
	}
	
	//从连接池获取连接
	public static Connection getConnction() {
		try {
			return dbcp.getConnection();
		} catch (SQLException e) {
			System.out.println("获取连接失败！");
		}
		return null;
	}
	
	//关闭资源
	public static void close(ResultSet res, Statement sta, Connection con) {
		if(res!=null)
			try {
				res.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		if(sta!=null)
			try {
				sta.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		if(con!=null)
			try {
				con.close();//dbcp的连接close并不是真正意义上的关闭，是将连接归回到dbcp数据源
			} catch (SQLException e) {
				e.printStackTrace();
			}
	}
	
}
