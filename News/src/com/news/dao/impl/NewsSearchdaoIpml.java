package com.news.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.news.dao.NewsSearchdao;
import com.news.entity.NRC_NEWS;
import com.news.util.DBConnection;

public class NewsSearchdaoIpml implements NewsSearchdao {

	@Override
	public ArrayList<NRC_NEWS> load(int num, String str) {
		Connection con = DBConnection.getConnection();
		ArrayList<NRC_NEWS> alist=new ArrayList<NRC_NEWS>();
		try {
			PreparedStatement ps;
			if(num==1){
				ps=con.prepareStatement("select * from NRC_NEWS left join NRC_TYPE on NRC_NEWS.T_ID=NRC_TYPE.T_ID where N_TITLE like '%" +str+ "%' order by  N_PUBLISHTIME desc ");
			}else if(num==2){
				ps=con.prepareStatement("select * from NRC_NEWS left join NRC_TYPE on NRC_NEWS.T_ID=NRC_TYPE.T_ID where N_CONTENT like '%" +str+ "%' order by  N_PUBLISHTIME desc ");
			}else{
				ps=con.prepareStatement("select * from NRC_NEWS left join NRC_TYPE on NRC_NEWS.T_ID=NRC_TYPE.T_ID order by  N_PUBLISHTIME desc ");
			}
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

	@Override
	public ArrayList<NRC_NEWS> sload(int num, String str) {
		Connection con = DBConnection.getConnection();
		ArrayList<NRC_NEWS> alist=new ArrayList<NRC_NEWS>();
		try {
			PreparedStatement ps;
			if(num==0){
				ps=con.prepareStatement("select * from NRC_NEWS left join NRC_TYPE on NRC_NEWS.T_ID=NRC_TYPE.T_ID order by  N_PUBLISHTIME desc ");
			}else{
				ps=con.prepareStatement("select * from NRC_NEWS left join NRC_TYPE on NRC_NEWS.T_ID=NRC_TYPE.T_ID where NRC_NEWS.T_ID="+num+" and ( N_CONTENT like '%" +str+ "%' or N_TITLE like '%"+str+"%' ) order by  N_PUBLISHTIME desc ");
			}
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

	@Override
	public ArrayList<NRC_NEWS> lload(String str) {
		Connection con = DBConnection.getConnection();
		ArrayList<NRC_NEWS> alist=new ArrayList<NRC_NEWS>();
		try {
			PreparedStatement ps;
			if(str.equals("")){
				ps=con.prepareStatement("select * from NRC_NEWS left join NRC_TYPE on NRC_NEWS.T_ID=NRC_TYPE.T_ID order by  N_PUBLISHTIME desc");
			}else{
				ps=con.prepareStatement("select * from NRC_NEWS left join NRC_TYPE on NRC_NEWS.T_ID=NRC_TYPE.T_ID where N_CONTENT like '%" +str+ "%' or N_TITLE like '%"+str+"%' order by  N_PUBLISHTIME desc ");
			}
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
