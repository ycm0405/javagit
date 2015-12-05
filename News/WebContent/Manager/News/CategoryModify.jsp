<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta http-equiv="Content-Language" content="zh-CN" />
<title>添加新闻类别</title>
<link href="../Style/Css.css" rel="stylesheet" type="text/css" />
<script language="javascript">
  String.prototype.Trim  =  function()
  {
		return  this.replace(/(^\s*)|(\s*$)/g,"");  
	}
	function back()
	{
		document.all.form1.action="CategoryList.jsp";
		document.form1.submit();
	}
</script>
</head>
<body>
<h3 class="subTitle">新闻类别</h3>

<form id="form1" name="form1" action="../../CategoryModify" method="post">	
	<table width="90%" border="0" align="center" cellpadding="0" cellspacing="0" class="table2">			
  		<c:forEach items="${sessionScope.alist }" var="nu">
  		   <tr>
              <th width="15%" align="right">类别编号</th>
              <td><input name="tid" type="text" class="input1" readonly="readonly" value="${nu.t_ID }"  /></td>
           </tr>
  		   <tr>
              <th width="15%" align="right">类别名称</th>
              <td><input name="tname" type="text" class="input1" value="${nu.t_NAME }"/></td>
           </tr>
  		</c:forEach>
    </table>
    <table width="90%" border="0" align="center" cellpadding="0" cellspacing="0" class="yesno">
        <tr>
            <td height="50" align="center">
            	<input type="submit" name="Submit1" value="添加"/> 
           		<input type="reset" name="Submit2" value="重置" />
           		<input type="button" name="Submit3" value="取消" onclick="back()"/>
           	</td>
        </tr>
    </table>
</form>
</body>
</html>