package com.news.dao;

import java.util.ArrayList;

public interface CategoryListdao {
public ArrayList<?> selttype(int tp);
public void addc(String str);
public ArrayList<?> update(int nid,String tname);
public int ttype(int tid);
public boolean detype(int tid);
}
