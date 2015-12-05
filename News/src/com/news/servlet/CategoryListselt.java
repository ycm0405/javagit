package com.news.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.JOptionPane;

import com.news.dao.impl.CategoryListdaoImpl;

/**
 * Servlet implementation class CategoryListselt
 */
public class CategoryListselt extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CategoryListselt() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		int tid=Integer.parseInt(request.getParameter("tid"));
	//	int num=new CategoryListdaoImpl().ttype(tid);
		int tt=JOptionPane.showConfirmDialog(null, "改类别中有"+new CategoryListdaoImpl().ttype(tid)+"条新闻是否删除", "删除提示", JOptionPane.YES_NO_OPTION);
		if(tt==0){
			new CategoryListdaoImpl().detype(tid);
			JOptionPane.showConfirmDialog(null, "删除成功","删除成功",JOptionPane.CANCEL_OPTION);
		}
		response.sendRedirect("/News/Manager/News/CategoryList.jsp");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
