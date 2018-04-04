package com.hsp.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hsp.domain.Users;
import com.hsp.service.BooksService;
import com.hsp.service.UsersService;

public class GoHallUI extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public GoHallUI() {
		super();
	}

	/**
	 * Destruction of the servlet. <br>
	 */
	public void destroy() {
		super.destroy(); // Just puts "destroy" string in log
		// Put your code here
	}

	/**
	 * The doGet method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to get.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html; charset=utf-8"); //处理中文乱码
		PrintWriter out = response.getWriter();
		
		//得到从登录页面传递的用户名和密码
		String id = request.getParameter("id");
		String p = request.getParameter("passwd");
		
		//创建一个Users对象
		Users loginUser = new Users(Integer.parseInt(id), p);
		UsersService userService = new UsersService();
		//使用业务逻辑类，完成验证
		if(userService.checkUser(loginUser)){
			//说明是合法用户,跳转到购物大厅
			//给下一个页面hall.jsp准备好要显示的数据
			//模式开发，在一定程度上约束了程序员的自由
			BooksService booksSerice = new BooksService();
			ArrayList al = booksSerice.getAllBooks();
			request.setAttribute("books", al);
			request.getRequestDispatcher("/WEB-INF/hall.jsp").forward(request, response);
		}else{
			//不合法
			request.getRequestDispatcher("/WEB-INF/login.jsp").forward(request, response);
			
		}
		
		

	}

	/**
	 * The doPost method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to post.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doGet(request, response);
	}



	/**
	 * Initialization of the servlet. <br>
	 *
	 * @throws ServletException if an error occurs
	 */
	public void init() throws ServletException {
		// Put your code here
	}

}
