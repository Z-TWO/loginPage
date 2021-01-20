package com.loginPage.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.loginPage.dao.DBMain;
import com.loginPage.model.User;



/**
 * 用户注册
 */
public class register extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public register() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String teleNum = request.getParameter("teleNum");
		String email = request.getParameter("email");
		if (!DBMain.isContain(username)) {
			//创建并添加用户
			User user = new User(username, password, teleNum, email);
			DBMain.addUser(user);
			//跳转到登录界面
			response.sendRedirect(request.getContextPath()+"/login.jsp");
		}else {
			System.out.println("用户已经存在，注册失败！");
		}
		DBMain.selectAll();
	}
}
