package com.news.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.news.dao.impl.NewsInfodaoImpl;

/**
 * Servlet implementation class Infoselt
 */
public class Infoselt extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Infoselt() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String str1=request.getParameter("textarea");
		String str2=request.getParameter("username");
		int num=Integer.parseInt(request.getParameter("lb"));
		new NewsInfodaoImpl().addre(num,str1,str2);
		request.setAttribute("lb", num);
		RequestDispatcher rr=request.getRequestDispatcher("Info.jsp");
		rr.forward(request, response);
	}

}
