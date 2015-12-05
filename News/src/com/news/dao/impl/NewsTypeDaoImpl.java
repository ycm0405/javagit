package com.news.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.news.bean.NewsTypeBean;
import com.news.dao.NewsTypeDao;
import com.news.util.DBConnection;



public class NewsTypeDaoImpl implements NewsTypeDao {

	@Override
	//����������Ʋ�ѯ���
	public NewsTypeBean findByTypename(String newstypename) {
		// TODO Auto-generated method stub
		NewsTypeBean newstypebean = null;
    	Connection conn = null;//���Ӷ��󣨽���ͨ��java-������
    	PreparedStatement pstmt = null;//ִ�ж���ִ��sql��䣩
        ResultSet rs = null;//���������ѯ���ݿⷵ�ؽ������    	
    	String sql = "select * from NRC_TYPE where T_NAME=?";
    	try {
			 //1�������
    		conn = DBConnection.getConnection();
    		//2����ִ�ж���
    		pstmt = conn.prepareStatement(sql);
    		//��������?����ֵ
    		pstmt.setString(1, newstypename);
    		//4ִ��
    		
    		rs = pstmt.executeQuery();
    		
    		if(rs.next()){
    			//�ж��Ƿ��ѯ������
    			newstypebean = new NewsTypeBean();
    			//��rs�е����ݷ�װ��user����
    			newstypebean.setT_id(rs.getInt(1));//rs������1��ʼ����ʾ���е�һ��,�������ݿ���е�˳��
    			newstypebean.setT_name(rs.getString(2));
    			newstypebean.setT_memo(rs.getString(3));
    		}
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			//�ر���Դ
			DBConnection.closeResultSet(rs);
			DBConnection.closeStatement(pstmt);
			DBConnection.closeConn(conn);
		}
    	return newstypebean;
	}

	@Override
	//�����������
	public int add(NewsTypeBean newstypebean) {
		// TODO Auto-generated method stub
		Connection conn = null;//���Ӷ���
		PreparedStatement pstmt = null;//������ִ�ж���
		int result = 0; //���ݿ����Ӱ�����������ɾ����ͬ��
		String sql = "insert into nrc_type values(?,?,?)";
		try {
			//1�������
			conn = DBConnection.getConnection();
			//2����ִ�ж���
			pstmt = conn.prepareStatement(sql);
			//��������ֵ
			pstmt.setString(1, newstypebean.getT_name());
			pstmt.setString(2, newstypebean.getT_memo());

           //4ִ��
			result = pstmt.executeUpdate();
		
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			//�ر���Դ
			DBConnection.closeStatement(pstmt);
			DBConnection.closeConn(conn);
		}
		return result;
	}

	@Override
	//�������ɾ��,������������idɾ��
	public int delete(int id) {
		// TODO Auto-generated method stub
		Connection conn = null;//���Ӷ���
		PreparedStatement pstmt = null;//������ִ�ж���
		int result = 0; //���ݿ����Ӱ�����������ɾ����ͬ��
		String sql = "delete nrc_type  where T_ID =?";
		try {
			//1�������
			conn = DBConnection.getConnection();
			//2����ִ�ж���
			pstmt = conn.prepareStatement(sql);
			//��������ֵ
			pstmt.setInt(1, id);
			
           //4ִ��
			result = pstmt.executeUpdate();
		
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			//�ر���Դ
			DBConnection.closeStatement(pstmt);
			DBConnection.closeConn(conn);
		}
		
		return result;
	}

//	@Override
//	public int delete(String newtypename) {
//		// TODO Auto-generated method stub
//		return 0;
//	}

	@Override
	public int update(NewsTypeBean newstypebean) {
		// TODO Auto-generated method stub
		Connection conn = null;//���Ӷ���
		PreparedStatement pstmt = null;//������ִ�ж���
		int result = 0; //���ݿ����Ӱ�����������ɾ����ͬ��
		String sql = "update nrc_type set T_NAME=?,T_MEMO=? where T_ID=?";
		try {
			//1�������
			conn = DBConnection.getConnection();
			//2����ִ�ж���
			pstmt = conn.prepareStatement(sql);
			//��������ֵ
			pstmt.setString(1, newstypebean.getT_name());
			pstmt.setString(2, newstypebean.getT_memo());
			pstmt.setInt(3, newstypebean.getT_id());//����id���޸�
           //4ִ��
			result = pstmt.executeUpdate();
		
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			//�ر���Դ
			DBConnection.closeStatement(pstmt);
			DBConnection.closeConn(conn);
		}

		return result;
	}

//	@Override
//	public NewsTypeBean findById(int id) {
//		// TODO Auto-generated method stub
//		return null;
//	}

	@Override
	public List<NewsTypeBean> findall() {
		// TODO Auto-generated method stub
		List<NewsTypeBean> list = new ArrayList<NewsTypeBean>();
		NewsTypeBean type = null;
    	Connection conn = null;//���Ӷ��󣨽���ͨ��java-������
    	PreparedStatement pstmt = null;//ִ�ж���ִ��sql��䣩
        ResultSet rs = null;//���������ѯ���ݿⷵ�ؽ������    	
    	String sql = "select * from nrc_type";
    	try {
			 //1�������
    		conn = DBConnection.getConnection();
    		//2����ִ�ж���
    		pstmt = conn.prepareStatement(sql);
    
    		//3ִ��
    		
    		rs = pstmt.executeQuery();
    		
    		while(rs.next()){//�ж��Ƿ��ѯ������
    			type = new NewsTypeBean();
    			//��rs�е����ݷ�װ��user����
    			type.setT_id(rs.getInt(1));//rs������1��ʼ����ʾ���е�һ��,�������ݿ���е�˳��
    			type.setT_name(rs.getString(2));
    			type.setT_memo(rs.getString(3));
    
    			//��������ӵ�����
    			list.add(type);
    			
    		}
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			//�ر���Դ
			DBConnection.closeResultSet(rs);
			DBConnection.closeStatement(pstmt);
			DBConnection.closeConn(conn);
		}
    	
    	
    	return list;
	}

	@Override
	public NewsTypeBean findById(int id) {
		// TODO Auto-generated method stub
		NewsTypeBean newstypebean = null;
    	Connection conn = null;//���Ӷ��󣨽���ͨ��java-������
    	PreparedStatement pstmt = null;//ִ�ж���ִ��sql��䣩
        ResultSet rs = null;//���������ѯ���ݿⷵ�ؽ������    	
    	String sql = "select * from nrc_type where t_id=?";
    	System.out.println(id);
    	try {
			 //1�������
    		conn = DBConnection.getConnection();
    		//2����ִ�ж���
    		pstmt = conn.prepareStatement(sql);
    		//��������?����ֵ
    		pstmt.setInt(1, id);
    		//4ִ��	
    		rs = pstmt.executeQuery();
    		if(rs.next()){
    			//�ж��Ƿ��ѯ������
    			newstypebean = new NewsTypeBean();
    			//��rs�е����ݷ�װ��user����
    			
    			newstypebean.setT_id(rs.getInt(1));//rs������1��ʼ����ʾ���е�һ��,�������ݿ���е�˳��
    			
    			newstypebean.setT_name(rs.getString(2));
    			newstypebean.setT_memo(rs.getString(3));
    			System.out.println("555555555555");
    			System.out.println(newstypebean.toString());
    		}
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			//�ر���Դ
			DBConnection.closeResultSet(rs);
			DBConnection.closeStatement(pstmt);
			DBConnection.closeConn(conn);
		}
    	return newstypebean;
	}

}
