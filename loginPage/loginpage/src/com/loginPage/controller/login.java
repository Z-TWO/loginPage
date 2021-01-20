package com.loginPage.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.loginPage.dao.DBMain;
import com.loginPage.model.User;



/**
 * Servlet implementation class login
 */
public class login extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String sql_isContain = "select * from user where username=?";
		
		//�ж��Ƿ��Ѿ����ڸ��û�
		boolean isContain = DBMain.isContain(username);
		if(isContain) {
			//����
			User user = DBMain.selectUser("sql_isContain",username);
			if (user!=null && user.getPassword().equals(password)) {
				response.sendRedirect(request.getContextPath()+"/web/user/userIndex.jsp");
			}else {
				//��½ʧ��
				request.setAttribute("insertDiv","<div id=\"returnText\" style=\"display: block;>�û������������</div>");
				request.getRequestDispatcher(request.getContextPath()+"/login.jsp").forward(request, response);
			}
		}else {
			//��½ʧ��
			request.setAttribute("insertDiv","<div id=\"returnText\" style=\"display: block;>�û������������</div>");
			request.getRequestDispatcher("/login.jsp").forward(request, response);
		}
	}

}
