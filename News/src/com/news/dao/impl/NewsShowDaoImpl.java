package com.news.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.news.bean.NewsBean;
import com.news.bean.NewsShow;
import com.news.dao.NewsShowDao;
import com.news.util.DBConnection;

public class NewsShowDaoImpl implements NewsShowDao{

	@Override
	//视图查询，前台页面上的类别，标题，时间
	public List<NewsShow> findAll() {
		// TODO Auto-generated method stub
		List<NewsShow> newsshowlist=new ArrayList<NewsShow>();
		Connection conn = null;
		PreparedStatement pstmt= null;
		ResultSet rs = null;
		String sql = "select nrc_type.t_name,nrc_news.n_title,nrc_news.n_publishtime from nrc_news,nrc_type where nrc_news.t_id=nrc_type.t_id";
		//获取连接
		conn = DBConnection.getConnection();
		try {
			//创建执行对象
			pstmt = conn.prepareStatement(sql);
			//执行
			rs = pstmt.executeQuery();
			//遍历结果集
			while(rs.next()){
			    NewsShow newsshow=new NewsShow();
			    newsshow.setN_title(rs.getString(2));
			    newsshow.setT_name(rs.getString(1));
			    newsshow.setN_publishtime(rs.getString(3));
			    newsshowlist.add(newsshow);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			DBConnection.closeResultSet(rs);
			DBConnection.closeStatement(pstmt);
			DBConnection.closeConn(conn);
		}
		
		return newsshowlist;
	}

}
