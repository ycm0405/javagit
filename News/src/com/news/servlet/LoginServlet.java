package com.news.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.JOptionPane;

import com.news.dao.LoginService;
import com.news.dao.impl.LoginServiceImpl;

public class LoginServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	LoginService loginService= new LoginServiceImpl();
       
  
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html");
		String username= request.getParameter("username");
		String password= request.getParameter("password");
		if(username.equals("")||password.equals(""))
		{
			JOptionPane.showMessageDialog(  null, "用户名或者密码不能为空");
			response.sendRedirect("/News/Manager/Login.jsp");
			
		}
		else{
			System.out.println("aaa");
		boolean a=loginService.login(username, password);
		System.out.println(a);
		
		if(a){
			
			response.sendRedirect("/News/Manager/Index.jsp");
		}
		else{
			JOptionPane.showMessageDialog(  null, "用户名或者密码错误");
			response.sendRedirect("/News/Manager/Login.jsp");
		}
		}
	}

}
