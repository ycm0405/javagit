package com.news.bean;

public class NewsBean {
	//���±��
	private int n_id;
	//���±���
	private String n_title;
	//��������
	private String n_content;
	//�����������
	private int t_id;
	//����ʱ��
	private String n_publishtime;

	public int getN_id() {
		return n_id;
	}
	public void setN_id(int n_id) {
		this.n_id = n_id;
	}
	public String getN_title() {
		return n_title;
	}
	public void setN_title(String n_title) {
		this.n_title = n_title;
	}
	public String getN_content() {
		return n_content;
	}
	public void setN_content(String n_content) {
		this.n_content = n_content;
	}
	public int getT_id() {
		return t_id;
	}
	public void setT_id(int t_id) {
		this.t_id = t_id;
	}
	public String getN_publishtime() {
		return n_publishtime;
	}
	public void setN_publishtime(String n_publishtime) {
		this.n_publishtime = n_publishtime;
	}
	@Override
	public String toString() {
		return this.n_id+","+this.n_title+","+this.n_content+","+this.t_id+","+this.n_publishtime;
	}
	
}
