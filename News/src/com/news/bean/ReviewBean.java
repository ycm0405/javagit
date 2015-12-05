package com.news.bean;

public class ReviewBean {
	private int r_id;
	private String r_content;
	private String r_username;
	private String r_revitme;
	private int n_id;
	public int getR_id() {
		return r_id;
	}
	public void setR_id(int r_id) {
		this.r_id = r_id;
	}
	public String getR_content() {
		return r_content;
	}
	public void setR_content(String r_content) {
		this.r_content = r_content;
	}
	public String getR_username() {
		return r_username;
	}
	public void setR_username(String r_username) {
		this.r_username = r_username;
	}
	public String getR_revitme() {
		return r_revitme;
	}
	public void setR_revitme(String r_revitme) {
		this.r_revitme = r_revitme;
	}
	public int getN_id() {
		return n_id;
	}
	public void setN_id(int n_id) {
		this.n_id = n_id;
	}
	@Override
	public String toString() {
		return this.r_id+","+this.r_content+","+this.r_username+","+this.r_revitme+","+this.n_id;
	}
	
}
