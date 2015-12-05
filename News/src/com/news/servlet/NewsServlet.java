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
	//ע��Service
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
		
				//�ַ�����
				request.setCharacterEncoding("utf-8");
				response.setContentType("text/html;charset=utf-8");
				//���󷽷�
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
	//����ҳ���id���ҵ�
	private void findByPage(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		
		System.out.println(request.getParameter("pageid").toString());
		String pageid1=request.getParameter("pageid").toString();
		int pageid=Integer.parseInt(pageid1);
		System.out.println("ҳ��id"+pageid);
		int apagecount=10;
		//ҳ��id
		request.setAttribute("pageid", pageid);
		//ҳ����ʾ����
		request.setAttribute("apagecount", apagecount);
		//����
		List<NewsBean> newslist=newsservice.findByPageID(pageid, apagecount);
		request.setAttribute("newslist", newslist);
		//ת��
		request.getRequestDispatcher("/Manager/News/NewsList.jsp").forward(request, response);
	}

	//ͨ��id�������ţ�Ȼ�󷵻ص��޸�ҳ��
	private void findNewsById(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		int id=Integer.parseInt(request.getParameter("id"));
		//����news
		System.out.println(id);
		NewsBean news=newsservice.findById(id);
		id=news.getT_id();
		//ͨ��id��ѯ��ǰnew���������
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

	//��ȡ���ŵ��������NewsAdd.jsp
	private void findAllType(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//��ȡ��������б�
		List<NewsTypeBean> newstypelist=newstypeservice.findall();
		//setAttribute,ҳ�洫ֵ
		request.setAttribute("newstypelist", newstypelist);
		//ת��
   	 	request.getRequestDispatcher("/Manager/News/NewsAdd.jsp").forward(request, response);
   	 	
   	 	//���⣺ǰ̨��õ����ŵ�������ﴫ�͵��Ƕ����б�����������������
	}
	//�������ţ�NewsModify.jsp,
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
			System.out.println("�޸ĳɹ�");
			request.getRequestDispatcher("/Manager/News/NewsList.jsp").forward(request, response);
		}else{
			System.out.println("failed");
		}
		
	}
	//ɾ������,NewsList.jsp
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
	//�������,NewsAdd.jsp
	private void addNews(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//����˼·�����ȶ�ȡҳ���ϵ����ݣ�����������Ҫת��������id��Ȼ��Զ����װ
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
			System.out.println("��ӳɹ�");
			request.getRequestDispatcher("/Manager/News/NewsList.jsp").forward(request, response);
		}else{
			System.out.println("failed");
		}
	}

}
