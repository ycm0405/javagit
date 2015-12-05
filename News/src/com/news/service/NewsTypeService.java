package com.news.service;

import java.util.List;

import com.news.bean.NewsTypeBean;

public interface NewsTypeService {
	//新闻类型操作接口
	//新闻类别的添加
	public boolean add(NewsTypeBean newstypebean);
	//新闻类别删除,根据新闻类别的id删除
	public boolean delete(int id);
	//新闻类别修改
	public boolean update(NewsTypeBean newstypebean);
	//根据id查找所有的新闻类别
	public NewsTypeBean findById(int id);
	//根据名称查找类别
	public NewsTypeBean findByTypename(String newstypename);
	//显示所有的新闻类别
	public List<NewsTypeBean> findall();
}
