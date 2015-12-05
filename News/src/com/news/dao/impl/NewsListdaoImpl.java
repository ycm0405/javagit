package com.news.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.news.dao.NewsListdao;
import com.news.entity.NRC_NEWS;
import com.news.util.DBConnection;

public class NewsListdaoImpl implements NewsListdao {

	@Override
	public ArrayList<NRC_NEWS> load(int str) {
		Connection con = DBConnection.getConnection();
		ArrayList<NRC_NEWS> alist=new ArrayList<NRC_NEWS>();
		try {
			PreparedStatement ps=con.prepareStatement("select * from NRC_NEWS left join NRC_TYPE on NRC_NEWS.T_ID=NRC_TYPE.T_ID where NRC_NEWS.T_ID=? order by  N_PUBLISHTIME desc ");
			ps.setInt(1, str);
			ResultSet rs=ps.executeQuery();
			while(rs.next()){
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

}
