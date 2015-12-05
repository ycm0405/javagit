package com.news.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.news.bean.NewsBean;
import com.news.dao.NewsDao;
import com.news.util.DBConnection;

public class NewsDaoImpl implements NewsDao{

	@Override
	//新闻类型添加
	public int addNews(NewsBean news) {
		
		Connection conn = null;//连接对象（建立通道java-驱动）
    	PreparedStatement pstmt = null;//执行对象（执行sql语句）
    	int row=0;
    	conn = DBConnection.getConnection();
    	String sql = "insert into nrc_news values(?,?,?,?)";
		//创建执行对象
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1,news.getN_title());
			pstmt.setString(2, news.getN_content());
			pstmt.setInt(3, news.getT_id());
			pstmt.setString(4, news.getN_publishtime());
			row = pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			DBConnection.closeStatement(pstmt);
			DBConnection.closeConn(conn);
		}
		return row;
	}

	@Override
	//新闻更改
	public int updateNews(NewsBean news) {
		int row = 0;
		Connection conn = null;
		PreparedStatement pstmt= null;
		String sql = "update nrc_news set n_title=?,n_content=?,t_id=?,n_publishtime=? where n_id=?";
			//获取连接
			conn = DBConnection.getConnection();
			System.out.println(news.toString());
			//创建执行对象
			try {
				//给参数赋值
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, news.getN_title());
				pstmt.setString(2, news.getN_content());
				pstmt.setInt(3, news.getT_id());
				pstmt.setString(4, news.getN_publishtime());
				pstmt.setInt(5, news.getN_id());
				row=pstmt.executeUpdate();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally{
				DBConnection.closeStatement(pstmt);
				DBConnection.closeConn(conn);
			}	
		return row;
	}

	@Override
	//删除
	public int deleteNews(int id) {
		int row = 0;
		Connection conn = null;
		PreparedStatement pstmt= null;
		String sql = "delete from nrc_news where n_id=?";
			//获取连接
			conn = DBConnection.getConnection();
			try {
				pstmt=conn.prepareStatement(sql);
				pstmt.setInt(1, id);
				row=pstmt.executeUpdate();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally{
				DBConnection.closeStatement(pstmt);
				DBConnection.closeConn(conn);
			}	
		return row;
	}

	@Override
	//查找所有
	public List<NewsBean> findAll() {
		List<NewsBean> newslist=new ArrayList<NewsBean>();
		Connection conn = null;
		PreparedStatement pstmt= null;
		ResultSet rs = null;
		String sql = "select * from nrc_news order by n_id ";
		//获取连接
		conn = DBConnection.getConnection();
		
		try {
			//创建执行对象
			pstmt = conn.prepareStatement(sql);
			//执行
			rs = pstmt.executeQuery();
			//遍历结果集
			while(rs.next()){
			    NewsBean news=new NewsBean();
			    news.setN_id(rs.getInt(1));
			    news.setN_title(rs.getString(2));
			    news.setN_content(rs.getString(3));
			    news.setT_id(rs.getInt(4));
			    news.setN_publishtime(rs.getString(5));
			    newslist.add(news);    
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			DBConnection.closeResultSet(rs);
			DBConnection.closeStatement(pstmt);
			DBConnection.closeConn(conn);
		}
		
		return newslist;
	}

	@Override
	//类型查询
	public List<NewsBean> findByType(String type) {
		
		return null;
	}

	@Override
	//根据内容查询
	public List<NewsBean> findByContent(String content) {
		return null;
	}

	@Override
	//根据标题查询
	public List<NewsBean> findByTitle(String title) {
		return null;
	}

	@Override
	//根据id号查询
	public NewsBean findById(int id) {
		NewsBean news=new NewsBean();
		Connection conn = null;
		PreparedStatement pstmt= null;
		ResultSet rs = null;
		String sql = "select * from nrc_news where n_id=?";
		
			//获取连接
			conn = DBConnection.getConnection();
			//创建执行对象
			try {
				pstmt = conn.prepareStatement(sql);
				pstmt.setInt(1, id);
				//执行
				rs = pstmt.executeQuery();
				//遍历结果集
				while(rs.next()){
					news.setN_id(rs.getInt(1));
					news.setN_title(rs.getString(2));
					news.setN_content(rs.getString(3));
					news.setT_id(rs.getInt(4));
					news.setN_publishtime(rs.getString(5));
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally{
				DBConnection.closeResultSet(rs);
				DBConnection.closeStatement(pstmt);
				DBConnection.closeConn(conn);
			}
		return news;
	}

	@Override
	//根据页面id和页面记录数查找
	public List<NewsBean> findByPageID(int pageid, int apagecount) {
		// TODO Auto-generated method stub
		List<NewsBean> newslist=new ArrayList<NewsBean>();
		Connection conn = null;
		PreparedStatement pstmt= null;
		ResultSet rs = null;
		String sql = "select top ? * from nrc_news where n_id not in (select top (?-1)*? n_id from nrc_news)";
		//获取连接
		conn = DBConnection.getConnection();
		
		try {
			//创建执行对象
			pstmt = conn.prepareStatement(sql);
			//执行
			pstmt.setInt(1, apagecount);
			pstmt.setInt(2, pageid);
			pstmt.setInt(3, apagecount);
			System.out.println("查询");
			rs = pstmt.executeQuery();
			//遍历结果集
			while(rs.next()){
			    NewsBean news=new NewsBean();
			    news.setN_id(rs.getInt(1));
			    news.setN_title(rs.getString(2));
			    news.setN_content(rs.getString(3));
			    news.setT_id(rs.getInt(4));
			    news.setN_publishtime(rs.getString(5));
			    newslist.add(news);    
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			DBConnection.closeResultSet(rs);
			DBConnection.closeStatement(pstmt);
			DBConnection.closeConn(conn);
		}
		
		return newslist;
	}

}
