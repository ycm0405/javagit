package com.news.service.impl;

import java.util.List;

import com.news.bean.NewsBean;
import com.news.dao.NewsDao;
import com.news.dao.impl.NewsDaoImpl;
import com.news.service.NewsService;

public class NewsServiceImpl implements NewsService {
	NewsDao newdao=new NewsDaoImpl();
	@Override
	public boolean addNews(NewsBean news) {
		// TODO Auto-generated method stub
		int result=newdao.addNews(news);
		if(result>0){
			return true;
		}else{
			return false;
		}
	}

	@Override
	public boolean updateNews(NewsBean news) {
		// TODO Auto-generated method stub
		int result=newdao.updateNews(news);
		if(result>0){
			return true;
		}else{
			return false;
		}
	}

	@Override
	public boolean deleteNews(int id) {
		// TODO Auto-generated method stub
		int result=newdao.deleteNews(id);
		if(result>0){
			return true;
		}else{
			return false;
		}
	}

	@Override
	public List<NewsBean> findAll() {
		// TODO Auto-generated method stub
		//ֱ�ӷ���һ���б�
		return newdao.findAll();
	}

	@Override
	public List<NewsBean> findByType(String type) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<NewsBean> findByContent(String content) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<NewsBean> findByTitle(String title) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public NewsBean findById(int id) {
		// TODO Auto-generated method stub
		//ͨ��id�������ţ�Ȼ�󷵻�NewsBean����
		NewsBean news=newdao.findById(id);
		return news;
	}

	@Override
	//����pageid��apagecount�õ�һ��ҳ��������б�
	public List<NewsBean> findByPageID(int pageid, int apagecount) {
		// TODO Auto-generated method stub
		List<NewsBean> newslist=newdao.findByPageID(pageid, apagecount);
		return newslist;
	}
}
