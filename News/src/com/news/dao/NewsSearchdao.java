package com.news.dao;

import java.util.ArrayList;

public interface NewsSearchdao {
public ArrayList<?> load(int num,String str);
public ArrayList<?> sload(int num,String str);
public ArrayList<?> lload(String str);
}
