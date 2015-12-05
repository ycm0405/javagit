package com.news.entity;

public class NRC_TYPE {
private int T_ID;
private String T_NAME;
public NRC_TYPE(int t_ID, String t_NAME, String t_MEMO) {
	super();
	T_ID = t_ID;
	T_NAME = t_NAME;
	T_MEMO = t_MEMO;
}
private String T_MEMO;
public int getT_ID() {
	return T_ID;
}
public void setT_ID(int t_ID) {
	T_ID = t_ID;
}
public String getT_NAME() {
	return T_NAME;
}
public void setT_NAME(String t_NAME) {
	T_NAME = t_NAME;
}
public String getT_MEMO() {
	return T_MEMO;
}
public void setT_MEMO(String t_MEMO) {
	T_MEMO = t_MEMO;
}
}
