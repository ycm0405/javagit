package com.news.service.impl;

import java.util.List;

import com.news.bean.NewsTypeBean;
import com.news.dao.NewsTypeDao;
import com.news.dao.impl.NewsTypeDaoImpl;
import com.news.service.NewsTypeService;

public class NewsTypeServiceImpl implements NewsTypeService {

	NewsTypeDao type=new NewsTypeDaoImpl();

	@Override
	public boolean add(NewsTypeBean newstypebean) {
		// TODO Auto-generated method stub
		int result = type.add(newstypebean);
		if (result > 0) {
			return true;
		}else{
			return false;
		}
	}

	@Override
	public boolean delete(int id) {
		// TODO Auto-generated method stub
		int result = type.delete(id);
		if (result > 0) {
			return true;
		}else{
			return false;
		}
	}

	@Override
	public boolean update(NewsTypeBean newstypebean) {
		// TODO Auto-generated method stub
		int result = type.add(newstypebean);
		if (result > 0) {
			return true;
		}else{
			return false;
		}
	}

	@Override
	public NewsTypeBean findById(int id) {
		// TODO Auto-generated method stub
		NewsTypeBean t = type.findById(id);
		return t;
	}

	@Override
	public NewsTypeBean findByTypename(String newstypename) {
		// TODO Auto-generated method stub
		NewsTypeBean t = type.findByTypename(newstypename);
		return t;
	}

	@Override
	public List<NewsTypeBean> findall() {
		// TODO Auto-generated method stub
		List<NewsTypeBean> list = type.findall();
		return list;
	}


}
