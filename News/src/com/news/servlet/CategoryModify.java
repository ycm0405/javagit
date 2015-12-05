package com.news.servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.swing.JOptionPane;

import com.news.dao.impl.CategoryListdaoImpl;
import com.news.entity.NRC_TYPE;

/**
 * Servlet implementation class CategoryModify
 */
@WebServlet("/CategoryModify")
public class CategoryModify extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CategoryModify() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String str=request.getParameter("type");
		int tp=Integer.parseInt(str);
		ArrayList<NRC_TYPE> alist=new CategoryListdaoImpl().selttype(tp);
		HttpSession session =request.getSession();
		session.setAttribute("alist", alist);
		response.sendRedirect("/News/Manager/News/CategoryModify.jsp");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		int tid=Integer.parseInt(request.getParameter("tid"));
		String tname=request.getParameter("tname");
		ArrayList<NRC_TYPE> alist=new CategoryListdaoImpl().update(tid, tname);
		HttpSession session =request.getSession();
		session.setAttribute("alist", alist);
		JOptionPane.showMessageDialog(null, "修改成功");
		response.sendRedirect("/News/Manager/News/CategoryModify.jsp");
	}

}
