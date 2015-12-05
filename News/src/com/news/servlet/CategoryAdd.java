package com.news.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.JOptionPane;

import com.news.dao.impl.CategoryListdaoImpl;

/**
 * Servlet implementation class CategoryAdd
 */
public class CategoryAdd extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CategoryAdd() {
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
		String pwd=request.getParameter("pwd");
		if(pwd.equals("")){
			JOptionPane.showMessageDialog(null, "类别名称不能为空");
			response.sendRedirect("/News/Manager/News/CategoryAdd.jsp");
		}else{
			new CategoryListdaoImpl().addc(pwd);
			JOptionPane.showMessageDialog(null, "添加成功");
			response.sendRedirect("/News/Manager/News/CategoryList.jsp");
		}
	}

}
