package com.news.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.news.dao.CategoryListdao;
import com.news.entity.NRC_TYPE;
import com.news.util.DBConnection;

public class CategoryListdaoImpl implements CategoryListdao {
	Connection con=DBConnection.getConnection();
	@Override
	public ArrayList<NRC_TYPE> selttype(int tp) {
		ArrayList<NRC_TYPE> alist=new ArrayList<NRC_TYPE>();
		try {
			PreparedStatement ps=con.prepareStatement("select * from NRC_TYPE where T_ID=? ");
			ps.setInt(1, tp);
			ResultSet rs=ps.executeQuery();
			if(rs.next()){
				int Tid=rs.getInt(1);
				String Tname=rs.getString(2);
				String Tmemo=rs.getString(3);
				NRC_TYPE nadd=new NRC_TYPE(Tid,Tname,Tmemo);
				alist.add(nadd);
				System.out.println(Tname);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return alist;
	}
	@Override
	public void addc(String str) {
		try {
			PreparedStatement ps=con.prepareStatement("insert into NRC_TYPE (T_NAME) values(?) ");
			ps.setString(1, str);
			ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	@Override
	public ArrayList<NRC_TYPE> update(int nid, String tname) {
		ArrayList<NRC_TYPE> alist=new ArrayList<NRC_TYPE>();
		try {
			PreparedStatement ps=con.prepareStatement(" update NRC_TYPE set T_NAME=? where T_ID=? ");
			ps.setString(1, tname);
			ps.setInt(2, nid);
			ps.executeUpdate();
			NRC_TYPE adda=new NRC_TYPE(nid, tname, null);
			alist.add(adda);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return alist;
	}
	@Override
	public int ttype(int tid) {
		int num=0;
		try {
			PreparedStatement ps=con.prepareStatement(" select COUNT(*) from NRC_TYPE left join NRC_NEWS on NRC_TYPE.T_ID=NRC_NEWS.T_ID where NRC_TYPE.T_ID=? ");
			ps.setInt(1, tid);
			ResultSet re=ps.executeQuery();
			if(re.next()){
				num=re.getInt(1);
			}
			System.out.println(num);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return num;
	}
	@Override
	public boolean detype(int tid) {
		boolean num=false;
		try {
			PreparedStatement ps=con.prepareStatement(" delete NRC_TYPE where T_ID=? ");
			ps.setInt(1, tid);
			int n=ps.executeUpdate();
			if(n==0){
				num=false;
			}else{
				num=true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return num;
	}

}
