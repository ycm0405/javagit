package com.news.bean;
//用户包
public class UserBean {
	private int u_id;
	//用户名
	private String u_username;
	//用户密码
	private String u_userpwd;
	//用户姓名
	private String u_name;
	public int getU_id() {
		return u_id;
	}
	public void setU_id(int u_id) {
		this.u_id = u_id;
	}
	public String getU_username() {
		return u_username;
	}
	public void setU_username(String u_username) {
		this.u_username = u_username;
	}
	public String getU_userpwd() {
		return u_userpwd;
	}
	public void setU_userpwd(String u_userpwd) {
		this.u_userpwd = u_userpwd;
	}
	public String getU_name() {
		return u_name;
	}
	public void setU_name(String u_name) {
		this.u_name = u_name;
	}
	public String toString() {
		return this.u_id+","+this.u_username+","+this.u_userpwd+","+this.u_name;
				
	}
	
}
