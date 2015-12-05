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
	//�����������
	public int addNews(NewsBean news) {
		
		Connection conn = null;//���Ӷ��󣨽���ͨ��java-������
    	PreparedStatement pstmt = null;//ִ�ж���ִ��sql��䣩
    	int row=0;
    	conn = DBConnection.getConnection();
    	String sql = "insert into nrc_news values(?,?,?,?)";
		//����ִ�ж���
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
	//���Ÿ���
	public int updateNews(NewsBean news) {
		int row = 0;
		Connection conn = null;
		PreparedStatement pstmt= null;
		String sql = "update nrc_news set n_title=?,n_content=?,t_id=?,n_publishtime=? where n_id=?";
			//��ȡ����
			conn = DBConnection.getConnection();
			System.out.println(news.toString());
			//����ִ�ж���
			try {
				//��������ֵ
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
	//ɾ��
	public int deleteNews(int id) {
		int row = 0;
		Connection conn = null;
		PreparedStatement pstmt= null;
		String sql = "delete from nrc_news where n_id=?";
			//��ȡ����
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
	//��������
	public List<NewsBean> findAll() {
		List<NewsBean> newslist=new ArrayList<NewsBean>();
		Connection conn = null;
		PreparedStatement pstmt= null;
		ResultSet rs = null;
		String sql = "select * from nrc_news order by n_id ";
		//��ȡ����
		conn = DBConnection.getConnection();
		
		try {
			//����ִ�ж���
			pstmt = conn.prepareStatement(sql);
			//ִ��
			rs = pstmt.executeQuery();
			//���������
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
	//���Ͳ�ѯ
	public List<NewsBean> findByType(String type) {
		
		return null;
	}

	@Override
	//�������ݲ�ѯ
	public List<NewsBean> findByContent(String content) {
		return null;
	}

	@Override
	//���ݱ����ѯ
	public List<NewsBean> findByTitle(String title) {
		return null;
	}

	@Override
	//����id�Ų�ѯ
	public NewsBean findById(int id) {
		NewsBean news=new NewsBean();
		Connection conn = null;
		PreparedStatement pstmt= null;
		ResultSet rs = null;
		String sql = "select * from nrc_news where n_id=?";
		
			//��ȡ����
			conn = DBConnection.getConnection();
			//����ִ�ж���
			try {
				pstmt = conn.prepareStatement(sql);
				pstmt.setInt(1, id);
				//ִ��
				rs = pstmt.executeQuery();
				//���������
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
	//����ҳ��id��ҳ���¼������
	public List<NewsBean> findByPageID(int pageid, int apagecount) {
		// TODO Auto-generated method stub
		List<NewsBean> newslist=new ArrayList<NewsBean>();
		Connection conn = null;
		PreparedStatement pstmt= null;
		ResultSet rs = null;
		String sql = "select top ? * from nrc_news where n_id not in (select top (?-1)*? n_id from nrc_news)";
		//��ȡ����
		conn = DBConnection.getConnection();
		
		try {
			//����ִ�ж���
			pstmt = conn.prepareStatement(sql);
			//ִ��
			pstmt.setInt(1, apagecount);
			pstmt.setInt(2, pageid);
			pstmt.setInt(3, apagecount);
			System.out.println("��ѯ");
			rs = pstmt.executeQuery();
			//���������
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
