package com.loginPage.service;

import com.loginPage.dao.DBMain;
import com.loginPage.model.User;

public class userService {
	
	//username��teleNum,email���ڲ�ѯ
	public static int check(String checkType,String value) {
		User user = null;
		switch (checkType) {
		case "username":
			user = DBMain.selectUser("select * from user where username=?",value);
			break;
		case "teleNum":
			user = DBMain.selectUser("select * from user where teleNum=?",value);
			break;
		case "email":
			user = DBMain.selectUser("select * from user where email=?",value);
			break;
		}
		if (user == null) {
			return 1;//ͨ��
		}else {
			return 0;//��ͨ��
		}
	}
}
