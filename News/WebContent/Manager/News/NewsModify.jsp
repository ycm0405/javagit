<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.news.bean.*"%>
<%@ page import="com.news.service.impl.*"%>
<%@ page import="com.news.util.*"%>

<%
	//获取当前路径
	String ctx = request.getContextPath();
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>添加新闻</title>
<link href="./Manager/Style/Css.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" charset="utf-8" src="./kindeditor/kindeditor.js"></script><!-- 添加kindeditor的引用 -->     
    <script type="text/javascript">     
    KE.show({     
    id : 'content_1'//TEXTAREA输入框的ID     
    });     
    </script>
<script language="javascript">

String.prototype.trim = function(){   
    //用正则表达式将前后空格用空字符串替代。   
    return   this.replace(/(^\s*)|(\s*$)/g,"");   
	}
	function check()
	{
		if(document.all.form1.title.value.Trim()==""){
			alert("请填写标题!");
			return false;
		 }
		 return true;
	}
	function goto1()
	{
		if(check()){
	    	document.form1.submit();
		}
	}
	function back()
	{
		document.all.form1.action="NewsList.jsp";
		document.form1.submit();
	}
</script>
</head>
<body>
	<!-- 获取下拉列表的内容 -->
	<%
	//获取类型列表
	List<NewsTypeBean> typelist=(List<NewsTypeBean>)request.getAttribute("newstypelist");
	String typename=(String)request.getAttribute("typename");
	NewsBean news=(NewsBean)request.getAttribute("news");
	%>

<h3 class="subTitle">修改新闻</h3>

<form id="form1" name="form1" action="<%=ctx %>/news.do?method=update" method="post">
		<input type="hidden" name="id" value="<%=news.getN_id() %>">
		<table width="90%" border="0" align="center" cellpadding="0" class="table2" cellspacing="0">
		    <tr>
          <th width="15%" align="right">新闻类别</th>
          <td>
          	<select name="newstypename">
          		<% 
          			for(int i=0;i<typelist.size();i++) {
          			NewsTypeBean newstype=typelist.get(i);
          		%>
					<option value="<%=newstype.getT_name()%>" ><%=newstype.getT_name() %></option>
				<%
					}
          		%>
			</select>
			</td>
			
      	</tr>
		    <tr>
		        <th align="right">文章标题</th>
		        <td><input name="header" type="text" class="input1" id="header" value="<%=news.getN_title() %>"/></td>
		    </tr>
		    <tr>
		        <th align="right" valign="top">文章内容</th>
		        <td>
		        	<textarea id="content_1" name="content" style="width:605px;height:300px;visibility:hidden;"><%=news.getN_content() %></textarea>
		        </td>
		    </tr>
		</table>
    <table width="90%" border="0" align="center" cellpadding="0" cellspacing="0" class="yesno">
        <tr>
            <td height="50" align="center">
            	<input type="submit" name="Submit" value="修改" />
            	<input type="reset" name="Submit2" value="重置" />
            	<input type="button" name="Submit" value="取消" onclick="back()"/> 
           	</td>
        </tr>
    </table>
</form>
</body>
</html>
