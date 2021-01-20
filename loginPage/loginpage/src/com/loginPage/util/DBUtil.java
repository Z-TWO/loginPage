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
	
	//����dbcp����Դ
	static{
		dbcp = new BasicDataSource();
		dbcp.setDriverClassName("com.mysql.jdbc.Driver");
		//��������
		dbcp.setUrl(url);
		dbcp.setUsername(username);
		dbcp.setPassword(password);
		//���ò���
		dbcp.setInitialSize(5);
		dbcp.setMaxTotal(20);
		dbcp.setMinIdle(2);
	}
	
	//�����ӳػ�ȡ����
	public static Connection getConnction() {
		try {
			return dbcp.getConnection();
		} catch (SQLException e) {
			System.out.println("��ȡ����ʧ�ܣ�");
		}
		return null;
	}
	
	//�ر���Դ
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
				con.close();//dbcp������close���������������ϵĹرգ��ǽ����ӹ�ص�dbcp����Դ
			} catch (SQLException e) {
				e.printStackTrace();
			}
	}
	
}
