package com.news.service;

import java.util.List;

import com.news.bean.NewsShow;

public interface NewsShowService {
	//获取新闻显示页的内容
	public List<NewsShow> findAll();
}
