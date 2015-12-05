package com.news.dao;

import java.util.List;

import com.news.bean.NewsBean;

public interface NewsDao {
	//���Žӿڣ�ʵ�ֺ�������ص����в���
	//1���������
	public int addNews(NewsBean news);
	//2�������޸�
	public int updateNews(NewsBean news);
	//3������ɾ����id
	public int deleteNews(int id);
	//4���鿴��������
	public List<NewsBean> findAll();
	//5��������������ѯ
	public List<NewsBean> findByType(String type);
	//6���������ݲ�ѯ
	public List<NewsBean> findByContent(String content);
	//7�����ݱ����ѯ
	public List<NewsBean> findByTitle(String title);
	//8������id��ѯ
	public NewsBean findById(int id);
	//9������ҳ���ѯ
	public List<NewsBean> findByPageID(int pageid,int apagecount);
}
