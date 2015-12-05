package com.news.entity;

public class NRC_NEWS {
private int N_ID;
private String N_TITLE;
private String N_CONTENT;
private String T_ID;
private String N_PUBLISHTIME;
public NRC_NEWS(int n_ID, String n_TITLE, String n_CONTENT, String t_ID,
		String n_PUBLISHTIME) {
	super();
	N_ID = n_ID;
	N_TITLE = n_TITLE;
	N_CONTENT = n_CONTENT;
	T_ID = t_ID;
	N_PUBLISHTIME = n_PUBLISHTIME;
}
public int getN_ID() {
	return N_ID;
}
public void setN_ID(int n_ID) {
	N_ID = n_ID;
}
public String getN_TITLE() {
	return N_TITLE;
}
public void setN_TITLE(String n_TITLE) {
	N_TITLE = n_TITLE;
}
public String getN_CONTENT() {
	return N_CONTENT;
}
public void setN_CONTENT(String n_CONTENT) {
	N_CONTENT = n_CONTENT;
}
public String getT_ID() {
	return T_ID;
}
public void setT_ID(String t_ID) {
	T_ID = t_ID;
}
public String getN_PUBLISHTIME() {
	return N_PUBLISHTIME;
}
public void setN_PUBLISHTIME(String n_PUBLISHTIME) {
	N_PUBLISHTIME = n_PUBLISHTIME;
}
}
