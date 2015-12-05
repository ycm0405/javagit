package com.news.dao.impl;

import com.news.entity.Userbean;
import com.news.dao.LoginDao;
import com.news.dao.impl.LoginDaoImpl;
import com.news.dao.LoginService;

public class LoginServiceImpl implements LoginService {
  LoginDao loginDao=new LoginDaoImpl();
	@Override
	public boolean login(String username, String password) {
		Userbean a=loginDao.Login(username, password);
		if(a==null){
			return false;
		}else{
			return true;
		}
	}

}
