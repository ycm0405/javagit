package com.news.service;

import com.news.bean.UserBean;

public interface UserService {
	//用户登陆接口
	public UserBean Login(String username,String userpwd);
}
