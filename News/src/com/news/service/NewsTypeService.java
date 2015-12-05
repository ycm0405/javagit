package com.news.service;

import java.util.List;

import com.news.bean.NewsTypeBean;

public interface NewsTypeService {
	//�������Ͳ����ӿ�
	//�����������
	public boolean add(NewsTypeBean newstypebean);
	//�������ɾ��,������������idɾ��
	public boolean delete(int id);
	//��������޸�
	public boolean update(NewsTypeBean newstypebean);
	//����id�������е��������
	public NewsTypeBean findById(int id);
	//�������Ʋ������
	public NewsTypeBean findByTypename(String newstypename);
	//��ʾ���е��������
	public List<NewsTypeBean> findall();
}
