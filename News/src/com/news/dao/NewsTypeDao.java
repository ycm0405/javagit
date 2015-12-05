package com.news.dao;

import java.util.List;

import com.news.bean.NewsTypeBean;

public interface NewsTypeDao {
	//�������Ͳ����ӿ�
	//����������Ʋ�ѯ���,Ӧ�ã������������ѯid
	public NewsTypeBean findByTypename(String newstypename);
	//�����������
	public int add(NewsTypeBean newstypebean);
	//�������ɾ��,������������idɾ��
	public int delete(int id);
	//�������id�޸�
	public int update(NewsTypeBean newstypebean);
	//����id�������е��������
	public NewsTypeBean findById(int id);
	//��ʾ���е��������
	public List<NewsTypeBean> findall();
}
