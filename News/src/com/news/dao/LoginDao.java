package com.news.dao;

import com.news.entity.Userbean;

public interface LoginDao {
	public Userbean Login(String username,String password);

}
