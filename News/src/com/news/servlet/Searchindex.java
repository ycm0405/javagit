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
 * Servlet implementation class Searchindex
 */
public class Searchindex extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public Searchindex() {
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
		String str2=request.getParameter("select");
		ArrayList<NRC_NEWS> alist;
		if(str1.equals("")){
			alist=new NewsSearchdaoIpml().load(0, str1);
		}else{
			if(str2.equals("标题")){
				alist=new NewsSearchdaoIpml().load(1, str1);
			}else{
				alist=new NewsSearchdaoIpml().load(2, str1);
			}
		}
		request.setAttribute("alist", alist);
		RequestDispatcher rr=request.getRequestDispatcher("Search.jsp");
		rr.forward(request, response);
	}

}
