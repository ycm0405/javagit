package com.news.service.impl;

import java.util.ArrayList;
import java.util.List;

import com.news.bean.NewsShow;
import com.news.dao.NewsShowDao;
import com.news.dao.impl.NewsShowDaoImpl;
import com.news.service.NewsShowService;

public class NewShowServiceImpl implements NewsShowService{

	@Override
	//��������ҳ����
	public List<NewsShow> findAll() {
		// TODO Auto-generated method stub
		List<NewsShow> newsshowlist=new ArrayList<NewsShow>();
		NewsShowDao newsshow=new NewsShowDaoImpl();
		newsshowlist=newsshow.findAll();
		return newsshowlist;
	}

}
