package com.news.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.news.bean.NewsBean;
import com.news.bean.NewsTypeBean;
import com.news.service.NewsService;
import com.news.service.NewsShowService;
import com.news.service.NewsTypeService;
import com.news.service.impl.NewShowServiceImpl;
import com.news.service.impl.NewsServiceImpl;
import com.news.service.impl.NewsTypeServiceImpl;
import com.news.util.TimeUtil;

/**
 * Servlet implementation class NewsServlet
 */
//@WebServlet("/NewsServlet")
public class NewsServlet extends HttpServlet {
	//注入Service
	NewsService newsservice=new NewsServiceImpl();
	NewsShowService newsshowservice=new NewShowServiceImpl();
	NewsTypeService newstypeservice=new NewsTypeServiceImpl();
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public NewsServlet() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		this.doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
				//字符编码
				request.setCharacterEncoding("utf-8");
				response.setContentType("text/html;charset=utf-8");
				//请求方法
				String method = request.getParameter("method");
				if(method.equals("add")){
					addNews(request,response);
				}if(method.equals("delete")){
					deleteNews(request,response);
				}if(method.equals("update")){
					updateNews(request,response);
				}if(method.equals("findnewsbyid")){
					findNewsById(request,response);
				}if(method.equals("findallnewstype")){
					findAllType(request,response);
				}if(method.equals("findnewsbypage")){
					findByPage(request,response);
				}
	}
	//根据页面的id查找的
	private void findByPage(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		
		System.out.println(request.getParameter("pageid").toString());
		String pageid1=request.getParameter("pageid").toString();
		int pageid=Integer.parseInt(pageid1);
		System.out.println("页面id"+pageid);
		int apagecount=10;
		//页面id
		request.setAttribute("pageid", pageid);
		//页面显示数量
		request.setAttribute("apagecount", apagecount);
		//查找
		List<NewsBean> newslist=newsservice.findByPageID(pageid, apagecount);
		request.setAttribute("newslist", newslist);
		//转发
		request.getRequestDispatcher("/Manager/News/NewsList.jsp").forward(request, response);
	}

	//通过id查找新闻，然后返回到修改页面
	private void findNewsById(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		int id=Integer.parseInt(request.getParameter("id"));
		//查找news
		System.out.println(id);
		NewsBean news=newsservice.findById(id);
		id=news.getT_id();
		//通过id查询当前new的所属类别
		NewsTypeBean newstype=newstypeservice.findById(id);
		String typename=null;
		if(newstype!=null){
			typename=newstype.getT_name();
		}
		request.setAttribute("typename", typename);
		request.setAttribute("news", news);
		List<NewsTypeBean> newstypelist=newstypeservice.findall();
		request.setAttribute("newstypelist", newstypelist);
		request.getRequestDispatcher("/Manager/News/NewsModify.jsp").forward(request, response);
	}

	//获取新闻的所有类别，NewsAdd.jsp
	private void findAllType(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//获取新闻类别列表
		List<NewsTypeBean> newstypelist=newstypeservice.findall();
		//setAttribute,页面传值
		request.setAttribute("newstypelist", newstypelist);
		//转发
   	 	request.getRequestDispatcher("/Manager/News/NewsAdd.jsp").forward(request, response);
   	 	
   	 	//问题：前台须得到新闻的类别，这里传送的是对象列表，可以在这把内容提出
	}
	//更新新闻，NewsModify.jsp,
	private void updateNews(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		int n_id=Integer.parseInt(request.getParameter("id"));
		String typename=request.getParameter("newstypename");
		String title=request.getParameter("header");
		String content=request.getParameter("content");
		NewsTypeBean newstype=newstypeservice.findByTypename(typename);
		int id=newstype.getT_id();
		NewsBean news=new NewsBean();
		String publishtime = TimeUtil.getCurrentTime();
		news.setN_id(n_id);
		news.setT_id(id);
		news.setN_title(title);
		news.setN_content(content);
		news.setN_publishtime(publishtime);
		news.toString();
		boolean result=newsservice.updateNews(news);
		if(result){
			System.out.println("修改成功");
			request.getRequestDispatcher("/Manager/News/NewsList.jsp").forward(request, response);
		}else{
			System.out.println("failed");
		}
		
	}
	//删除新闻,NewsList.jsp
	private void deleteNews(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		int id=Integer.parseInt(request.getParameter("id"));
		boolean result=newsservice.deleteNews(id);
		if(result){
			request.getRequestDispatcher("/Manager/News/NewsList.jsp").forward(request, response);
		}else{
			System.out.println("failed");
		}
	}
	//添加新闻,NewsAdd.jsp
	private void addNews(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//处理思路：首先读取页面上的内容，对于类型需要转换成类型id，然后对对象封装
		String typename=request.getParameter("newstypename");
		String title=request.getParameter("header");
		String content=request.getParameter("content");
		
		NewsTypeBean newstype=newstypeservice.findByTypename(typename);
		int id=newstype.getT_id();
		NewsBean news=new NewsBean();
		String publishtime = TimeUtil.getCurrentTime();
		news.setT_id(id);
		news.setN_title(title);
		news.setN_content(content);
		news.setN_publishtime(publishtime);
		news.toString();
		boolean result=newsservice.addNews(news);
		if(result){
			System.out.println("添加成功");
			request.getRequestDispatcher("/Manager/News/NewsList.jsp").forward(request, response);
		}else{
			System.out.println("failed");
		}
	}

}
