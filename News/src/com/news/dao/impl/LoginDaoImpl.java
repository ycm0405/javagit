package com.news.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.news.util.DBConnection;
import com.news.entity.Userbean;
import com.news.dao.LoginDao;

public class LoginDaoImpl implements LoginDao{

	@Override
	public Userbean Login(String username, String password) {
		
		Userbean user=null;
		ResultSet rs = null;
		Connection conn = null;
		PreparedStatement pstmt= null;
		String sql = "select * from NRC_USER where U_USERNAME=? and U_USERPWD=?";
		try{
			
			conn = DBConnection.getConnection();
			
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1,username);
			pstmt.setString(2,password);
			
			rs = pstmt.executeQuery();
			while(rs.next()){
				user=new Userbean();
				user.setId(rs.getInt(1));
				user.setUsername(rs.getString(2));
				user.setPassword(rs.getString(3));
				user.setName(rs.getString(4));
			}
		}catch(SQLException ex){
			ex.printStackTrace();
		}
		
			return user;
		
	
		
	}

}
