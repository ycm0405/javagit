package com.news.dao;

import java.util.List;

import com.news.bean.NewsBean;

public interface NewsDao {
	//新闻接口：实现和新闻相关的所有操作
	//1、新闻添加
	public int addNews(NewsBean news);
	//2、新闻修改
	public int updateNews(NewsBean news);
	//3、新闻删除，id
	public int deleteNews(int id);
	//4、查看所有新闻
	public List<NewsBean> findAll();
	//5、根据新闻类别查询
	public List<NewsBean> findByType(String type);
	//6、根据内容查询
	public List<NewsBean> findByContent(String content);
	//7、根据标题查询
	public List<NewsBean> findByTitle(String title);
	//8、根据id查询
	public NewsBean findById(int id);
	//9、根据页面查询
	public List<NewsBean> findByPageID(int pageid,int apagecount);
}
