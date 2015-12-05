package com.news.dao;

import java.util.List;

import com.news.bean.NewsTypeBean;

public interface NewsTypeDao {
	//新闻类型操作接口
	//根据类别名称查询类别,应用：根据类别名查询id
	public NewsTypeBean findByTypename(String newstypename);
	//新闻类别的添加
	public int add(NewsTypeBean newstypebean);
	//新闻类别删除,根据新闻类别的id删除
	public int delete(int id);
	//新闻类别id修改
	public int update(NewsTypeBean newstypebean);
	//根据id查找所有的新闻类别
	public NewsTypeBean findById(int id);
	//显示所有的新闻类别
	public List<NewsTypeBean> findall();
}
