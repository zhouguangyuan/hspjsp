package com.hsp.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hsp.domain.Users;
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

		response.setContentType("text/html; charset=utf-8"); //������������
		PrintWriter out = response.getWriter();
		
		//�õ��ӵ�¼ҳ�洫�ݵ��û���������
		String id = request.getParameter("id");
		String p = request.getParameter("passwd");
		
		//����һ��Users����
		Users loginUser = new Users(Integer.parseInt(id), p);
		UsersService userService = new UsersService();
		//ʹ��ҵ���߼��࣬�����֤
		if(userService.checkUser(loginUser)){
			//˵���ǺϷ��û�,��ת���������
			request.getRequestDispatcher("/WEB-INF/hall.jsp").forward(request, response);
		}else{
			//���Ϸ�
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