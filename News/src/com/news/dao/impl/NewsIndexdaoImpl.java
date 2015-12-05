package com.news.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;

import com.news.dao.NewsIndexdao;
import com.news.entity.NRC_NEWS;
import com.news.entity.NRC_TYPE;
import com.news.util.DBConnection;

public class NewsIndexdaoImpl implements NewsIndexdao {
	Connection con=DBConnection.getConnection();
	
	@Override
	public ArrayList<NRC_NEWS> loadnews() {
		ArrayList<NRC_NEWS> alist=new ArrayList<NRC_NEWS>();
		String sql="select * from NRC_NEWS left join NRC_TYPE on NRC_NEWS.T_ID=NRC_TYPE.T_ID order by  N_PUBLISHTIME desc ";
		try {
			PreparedStatement ps=con.prepareStatement(sql);
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
	public ArrayList<NRC_TYPE> loadtype() {
		ArrayList<NRC_TYPE> alist=new ArrayList<NRC_TYPE>();
		String sql="select * from NRC_TYPE ";
		try {
			PreparedStatement ps=con.prepareStatement(sql);
			ResultSet rs=ps.executeQuery();
			while(rs.next()){
				int Tid=rs.getInt(1);
				String Tname=rs.getString(2);
				String Tmemo=rs.getString(3);
				NRC_TYPE nadd=new NRC_TYPE(Tid,Tname,Tmemo);
				alist.add(nadd);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return alist;
	}

	@Override
	public ArrayList<NRC_NEWS> hotdnews() {
		ArrayList<NRC_NEWS> alist= new ArrayList<NRC_NEWS>();
		int[] a=new int [100];
		try {
			PreparedStatement ps=con.prepareStatement("select * from NRC_REVIEW order by N_ID asc ");
			ResultSet rr=ps.executeQuery();
			while(rr.next()){
				int nid=rr.getInt(5);
				a[nid]+=1;
				System.out.println("a["+nid+"]="+a[nid]);
			}
//			for(int i=0;i<a.length;i++){
//				System.out.println(a[i]);
//			}
			int [] b=Arrays.copyOf(a, a.length);
			int [] did=new int[10];
			Arrays.sort(b);
			for(int i=0;i<10;i++){
//				System.out.println("b["+i+"]="+b[a.length-1-i]);
				for(int j=0;j<a.length;j++){
					if(a[j]==b[a.length-i-1]){
						if(i==0){
							did[i]=j;
						}else{
							for(int l=0;l<i;l++){
								if(did[l]==j){
									break;
								}else if(l+1==i){
									did[i]=j;
								}
							}
						}
						if(did[i]==j){
							break;
						}
					}
				}
			}
			for(int i=0;i<10;i++){
//				System.out.println("选中"+did[i]);
				PreparedStatement ps1=con.prepareStatement("select * from NRC_NEWS left join NRC_TYPE on NRC_NEWS.T_ID=NRC_TYPE.T_ID where N_ID= ? ");
				ps1.setInt(1, did[i]);
				ResultSet re=ps1.executeQuery();
				if(re.next()){
					int Nid=re.getInt(1);
					String Ntitle=re.getString(2);
					String Ncontent=re.getString(3);
					String Tid=re.getString(7);
					String Npublishtime=re.getString(5);
					NRC_NEWS nadd=new NRC_NEWS(Nid,Ntitle,Ncontent,Tid,Npublishtime);
					alist.add(nadd);
				}
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return alist;
	}

}
