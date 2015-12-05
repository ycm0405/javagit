<%@page import="com.news.dao.impl.NewsIndexdaoImpl"%>
<%@page import="com.news.entity.NRC_TYPE"%>
<%@page import="com.news.dao.impl.NewsListdaoImpl"%>
<%@page import="com.news.entity.NRC_NEWS"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.time.format.DateTimeFormatter"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.Date"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<%ArrayList<NRC_NEWS> alist=(ArrayList<NRC_NEWS>)session.getAttribute("alist"); %>
<%=alist.size() %>
<c:forEach items="${alist }" var="uu" begin="0" end="3" step="1">
   ${uu.t_ID },${uu.n_ID }${uu.n_TITLE},${uu.n_PUBLISHTIME }<br>
</c:forEach>
</body>
</html>