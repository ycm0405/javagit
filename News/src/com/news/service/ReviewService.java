package com.news.service;

import java.util.List;

import com.news.bean.ReviewBean;

public interface ReviewService {
	//添加评论
	public boolean addReview(ReviewBean reviewbean);
	//显示评论,当前文章编号
	public List<ReviewBean> findAll(int id);
}
