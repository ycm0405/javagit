package com.news.service;

import java.util.List;

import com.news.bean.ReviewBean;

public interface ReviewService {
	//�������
	public boolean addReview(ReviewBean reviewbean);
	//��ʾ����,��ǰ���±��
	public List<ReviewBean> findAll(int id);
}
