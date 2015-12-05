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
	//根据类别名称查询类别
	public NewsTypeBean findByTypename(String newstypename) {
		// TODO Auto-generated method stub
		NewsTypeBean newstypebean = null;
    	Connection conn = null;//连接对象（建立通道java-驱动）
    	PreparedStatement pstmt = null;//执行对象（执行sql语句）
        ResultSet rs = null;//结果集（查询数据库返回结果集）    	
    	String sql = "select * from NRC_TYPE where T_NAME=?";
    	try {
			 //1获得连接
    		conn = DBConnection.getConnection();
    		//2创建执行对象
    		pstmt = conn.prepareStatement(sql);
    		//给参数（?）赋值
    		pstmt.setString(1, newstypename);
    		//4执行
    		
    		rs = pstmt.executeQuery();
    		
    		if(rs.next()){
    			//判断是否查询到数据
    			newstypebean = new NewsTypeBean();
    			//把rs中的数据封装到user对象
    			newstypebean.setT_id(rs.getInt(1));//rs索引从1开始，表示表中第一列,按照数据库表列的顺序
    			newstypebean.setT_name(rs.getString(2));
    			newstypebean.setT_memo(rs.getString(3));
    		}
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			//关闭资源
			DBConnection.closeResultSet(rs);
			DBConnection.closeStatement(pstmt);
			DBConnection.closeConn(conn);
		}
    	return newstypebean;
	}

	@Override
	//新闻类别的添加
	public int add(NewsTypeBean newstypebean) {
		// TODO Auto-generated method stub
		Connection conn = null;//连接对象
		PreparedStatement pstmt = null;//参数化执行对象
		int result = 0; //数据库操作影响的行数（增删改相同）
		String sql = "insert into nrc_type values(?,?,?)";
		try {
			//1获得连接
			conn = DBConnection.getConnection();
			//2创建执行对象
			pstmt = conn.prepareStatement(sql);
			//给参数赋值
			pstmt.setString(1, newstypebean.getT_name());
			pstmt.setString(2, newstypebean.getT_memo());

           //4执行
			result = pstmt.executeUpdate();
		
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			//关闭资源
			DBConnection.closeStatement(pstmt);
			DBConnection.closeConn(conn);
		}
		return result;
	}

	@Override
	//新闻类别删除,根据新闻类别的id删除
	public int delete(int id) {
		// TODO Auto-generated method stub
		Connection conn = null;//连接对象
		PreparedStatement pstmt = null;//参数化执行对象
		int result = 0; //数据库操作影响的行数（增删改相同）
		String sql = "delete nrc_type  where T_ID =?";
		try {
			//1获得连接
			conn = DBConnection.getConnection();
			//2创建执行对象
			pstmt = conn.prepareStatement(sql);
			//给参数赋值
			pstmt.setInt(1, id);
			
           //4执行
			result = pstmt.executeUpdate();
		
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			//关闭资源
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
		Connection conn = null;//连接对象
		PreparedStatement pstmt = null;//参数化执行对象
		int result = 0; //数据库操作影响的行数（增删改相同）
		String sql = "update nrc_type set T_NAME=?,T_MEMO=? where T_ID=?";
		try {
			//1获得连接
			conn = DBConnection.getConnection();
			//2创建执行对象
			pstmt = conn.prepareStatement(sql);
			//给参数赋值
			pstmt.setString(1, newstypebean.getT_name());
			pstmt.setString(2, newstypebean.getT_memo());
			pstmt.setInt(3, newstypebean.getT_id());//根据id做修改
           //4执行
			result = pstmt.executeUpdate();
		
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			//关闭资源
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
    	Connection conn = null;//连接对象（建立通道java-驱动）
    	PreparedStatement pstmt = null;//执行对象（执行sql语句）
        ResultSet rs = null;//结果集（查询数据库返回结果集）    	
    	String sql = "select * from nrc_type";
    	try {
			 //1获得连接
    		conn = DBConnection.getConnection();
    		//2创建执行对象
    		pstmt = conn.prepareStatement(sql);
    
    		//3执行
    		
    		rs = pstmt.executeQuery();
    		
    		while(rs.next()){//判断是否查询到数据
    			type = new NewsTypeBean();
    			//把rs中的数据封装到user对象
    			type.setT_id(rs.getInt(1));//rs索引从1开始，表示表中第一列,按照数据库表列的顺序
    			type.setT_name(rs.getString(2));
    			type.setT_memo(rs.getString(3));
    
    			//将对象添加到集合
    			list.add(type);
    			
    		}
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			//关闭资源
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
    	Connection conn = null;//连接对象（建立通道java-驱动）
    	PreparedStatement pstmt = null;//执行对象（执行sql语句）
        ResultSet rs = null;//结果集（查询数据库返回结果集）    	
    	String sql = "select * from nrc_type where t_id=?";
    	System.out.println(id);
    	try {
			 //1获得连接
    		conn = DBConnection.getConnection();
    		//2创建执行对象
    		pstmt = conn.prepareStatement(sql);
    		//给参数（?）赋值
    		pstmt.setInt(1, id);
    		//4执行	
    		rs = pstmt.executeQuery();
    		if(rs.next()){
    			//判断是否查询到数据
    			newstypebean = new NewsTypeBean();
    			//把rs中的数据封装到user对象
    			
    			newstypebean.setT_id(rs.getInt(1));//rs索引从1开始，表示表中第一列,按照数据库表列的顺序
    			
    			newstypebean.setT_name(rs.getString(2));
    			newstypebean.setT_memo(rs.getString(3));
    			System.out.println("555555555555");
    			System.out.println(newstypebean.toString());
    		}
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			//关闭资源
			DBConnection.closeResultSet(rs);
			DBConnection.closeStatement(pstmt);
			DBConnection.closeConn(conn);
		}
    	return newstypebean;
	}

}
