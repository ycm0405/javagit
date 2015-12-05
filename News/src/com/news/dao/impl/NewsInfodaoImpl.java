package com.news.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import com.news.dao.NewsInfodao;
import com.news.entity.NRC_NEWS;
import com.news.entity.NRC_REVIEW;
import com.news.util.DBConnection;

public class NewsInfodaoImpl implements NewsInfodao {

	@Override
	public ArrayList<NRC_REVIEW> pinglun(int str) {
		Connection con = DBConnection.getConnection();
		ArrayList<NRC_REVIEW> alist=new ArrayList<NRC_REVIEW>();
		try {
			PreparedStatement ps=con.prepareStatement("select * from NRC_REVIEW  where N_ID=? ");
			ps.setInt(1, str);
			ResultSet rs=ps.executeQuery();
			while(rs.next()){
				int Rid=rs.getInt(1);
				String Rcontent=rs.getString(2);
				String Rusername=rs.getString(3);
				String Rrevtime=rs.getString(4);
				int Nid=rs.getInt(5);
				NRC_REVIEW nadd=new NRC_REVIEW(Rid,Rcontent,Rusername,Rrevtime,Nid);
				alist.add(nadd);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return alist;
	}

	@Override
	public ArrayList<NRC_NEWS> loadn(int i) {
		Connection con = DBConnection.getConnection();
		ArrayList<NRC_NEWS> alist=new ArrayList<NRC_NEWS>();
		try {
			PreparedStatement ps=con.prepareStatement("select * from NRC_NEWS left join NRC_TYPE on NRC_NEWS.T_ID=NRC_TYPE.T_ID where N_ID=? ");
			ps.setInt(1, i);
			ResultSet rs=ps.executeQuery();
			if(rs.next()){
				int Nid=rs.getInt(1);
				String Ntitle=rs.getString(2);
				String Ncontent=rs.getString(3);
				String Tid=rs.getString(7);
				String Npublishtime=rs.getString(5);
				NRC_NEWS nadd=new NRC_NEWS(Nid,Ntitle,Ncontent,Tid,Npublishtime);
				alist.add(nadd);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return alist;
	}

	@Override
	public int addre(int num, String str1, String str2) {
		Connection con = DBConnection.getConnection();
		Date aa=new Date();
		int bu = 0;
		SimpleDateFormat time=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SS");
		String str3=time.format(aa);
		//long time=aa.getTime();
		try {
			PreparedStatement ps=con.prepareStatement("insert into NRC_REVIEW (R_CONTENT,R_USERNAME,R_REVTIME,N_ID) values(?,?,?,?)");
			ps.setString(1, str1);
			ps.setString(2, str2);
			ps.setString(3, str3);
			ps.setInt(4, num);
			bu=ps.executeUpdate();
			System.out.println("添加了"+bu+"条数据");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return bu;
	}

}
