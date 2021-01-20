package com.loginPage.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.loginPage.model.User;
import com.loginPage.util.DBUtil;

public class DBMain {
	private static String sql_selAll = "select * from user";
	private static String sql_inNew = "insert into user values(null,?,?,?,?,now(),now(),now())";
	private static String sql_find = "select * from user where username=?";
	
	public static void main(String[] args) {
		isContain("usern");
	}
	
	//��ѯ������
	public static void selectAll() {
		Connection con = null;
		PreparedStatement psta = null;
		ResultSet res = null;
		
		try {
			con = DBUtil.getConnction();
			psta = con.prepareStatement(sql_selAll);
			res = psta.executeQuery();
			
			while(res.next()) {
				System.out.println("userid:"+res.getInt("userid")+
						"  username:"+res.getString("username")+
						"  password:"+res.getString("password")+
						"  teleNum:"+res.getString("teleNum")+
						"  email:"+res.getString("email"));
			}
		} catch (SQLException e) {
			System.out.println("��ѯʧ�ܣ�");
		}finally {
			DBUtil.close(res, psta, con);
		}
	}

	//�����û�(�û�ע��)
	public static void addUser(User user) {
		Connection con = null;
		PreparedStatement psta = null;
		ResultSet res = null;
		
		try {
			con = DBUtil.getConnction();
			psta = con.prepareStatement(sql_inNew);
			psta.setString(1, user.getUsername());
			psta.setString(2, user.getPassword());
			psta.setString(3, user.getTeleNum());
			psta.setString(4, user.getEmial());
			int result = psta.executeUpdate();
			System.out.println(result);
		} catch (SQLException e) {
			System.out.println("���ݲ���ʧ�ܣ�");
		}
	}

	//��ѯ�û��Ƿ��Ѿ�����
	public static boolean isContain(String username) {
		Connection con = null;
		PreparedStatement psta = null;
		ResultSet res = null;
		
		try {
			con = DBUtil.getConnction();
			psta = con.prepareStatement(sql_find);
			psta.setString(1, username);
			res = psta.executeQuery();
			if (res.next()) {
				return true;//���ڷ��أ�true
			}else {
				return false;
			}
		} catch (SQLException e) {
			System.out.println("���ڲ�ѯ����");
		}finally {
			DBUtil.close(res, psta, con);
		}
		return false;
	}

	//�����û���ѯ(����username��teleNum��email��ѯ��
	public static User selectUser(String sql,String value) {
		Connection con = null;
		PreparedStatement psta = null;
		ResultSet res = null;
		User user =null;
		
		try {
			con = DBUtil.getConnction();
			psta = con.prepareStatement(sql);
			psta.setString(1, value);
			res = psta.executeQuery();
			if(res.next()) {
				User loginUser = new User(res.getString("username"), res.getString("password"), res.getString("teleNum"), res.getString("email"));
				return loginUser;
			}else {
				return null;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			DBUtil.close(res, psta, con);
		}
		return null;
	}
	

}
