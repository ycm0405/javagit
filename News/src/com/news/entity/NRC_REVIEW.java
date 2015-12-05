package com.news.entity;

public class NRC_REVIEW {
private int R_ID;
private String R_CONTENT;
private String R_USERNAME;
private String R_REVTIME;
private int N_ID;
public int getR_ID() {
	return R_ID;
}
public void setR_ID(int r_ID) {
	R_ID = r_ID;
}
public NRC_REVIEW(int r_ID, String r_CONTENT, String r_USERNAME,
		String r_REVTIME, int n_ID) {
	super();
	R_ID = r_ID;
	R_CONTENT = r_CONTENT;
	R_USERNAME = r_USERNAME;
	R_REVTIME = r_REVTIME;
	N_ID = n_ID;
}
public String getR_CONTENT() {
	return R_CONTENT;
}
public void setR_CONTENT(String r_CONTENT) {
	R_CONTENT = r_CONTENT;
}
public String getR_USERNAME() {
	return R_USERNAME;
}
public void setR_USERNAME(String r_USERNAME) {
	R_USERNAME = r_USERNAME;
}
public String getR_REVTIME() {
	return R_REVTIME;
}
public void setR_REVTIME(String r_REVTIME) {
	R_REVTIME = r_REVTIME;
}
public int getN_ID() {
	return N_ID;
}
public void setN_ID(int n_ID) {
	N_ID = n_ID;
}
}
