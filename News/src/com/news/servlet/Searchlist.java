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
 * Servlet implementation class Searchlist
 */
public class Searchlist extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Searchlist() {
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
		String str1=request.getParameter("textfield");
		int num=Integer.parseInt(request.getParameter("type"));
		if(str1.equals("")){
			num=0;
		}
		ArrayList<NRC_NEWS> alist=new NewsSearchdaoIpml().sload(num, str1);
		request.setAttribute("alist", alist);
		RequestDispatcher rr=request.getRequestDispatcher("Search.jsp");
		rr.forward(request, response);
	}

}
