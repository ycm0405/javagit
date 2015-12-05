package com.news.dao.impl;

import java.util.ArrayList;
import java.util.Iterator;

import com.news.entity.NRC_NEWS;

public class Test {
public static void main(String[] args) {
	ArrayList<NRC_NEWS> alist=new NewsIndexdaoImpl().loadnews();
	Iterator<NRC_NEWS> it=alist.iterator();
	while(it.hasNext()){
		NRC_NEWS a=it.next();
		System.out.println(a.getN_TITLE());
	}
}
}
