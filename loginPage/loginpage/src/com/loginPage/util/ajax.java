package com.loginPage.util;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.loginPage.service.userService;

/**
 * Servlet implementation class ajax
 */
@WebServlet("/ajax")
public class ajax extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ajax() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		System.out.println("doget--name:"+request.getParameter("name")+"--message:"+request.getParameter("message"));
		response.getWriter().append("doget收到了");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//解决乱码
		response.setContentType("text/html;charset=utf-8");
		//检验用户名，手机号，邮箱是否已经存在，进行判断并进行反馈
		String checkType = request.getParameter("checkType");
		String value = request.getParameter("value");
		int isPass = userService.check(checkType, value);
		response.getWriter().print(isPass);
		System.out.println(checkType+"  "+value+"  "+isPass);
	}

}
