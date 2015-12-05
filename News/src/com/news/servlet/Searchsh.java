package com.news.servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.news.dao.impl.NewsSearchdaoIpml;
import com.news.entity.NRC_NEWS;

/**
 * Servlet implementation class Searchsh
 */
public class Searchsh extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Searchsh() {
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
		String str=request.getParameter("textfield");
		ArrayList<NRC_NEWS> alist=new NewsSearchdaoIpml().lload(str);
		request.setAttribute("alist", alist);
		RequestDispatcher rr=request.getRequestDispatcher("Search.jsp");
		rr.forward(request, response);
	}

}
