<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta http-equiv="Content-Language" content="zh-CN" />
<title>添加新闻类别</title>
<link href="../Style/Css.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" language="javascript">
  function check(pwd){
	  if(pwd==null){
		  alert("类别名称不能为空");
		  return false;
	  }else{
		  return true;
	  }
  }
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

<form id="form1" name="form1" action="../../CategoryAdd" method="post" >	
	<table width="90%" border="0" align="center" cellpadding="0" cellspacing="0" class="table2">
			
  		<tr>
          <th width="15%" align="right">类别名称</th>
          <td><input name="pwd" type="text" class="input1" /></td>
      </tr>
    </table>
    <table width="90%" border="0" align="center" cellpadding="0" cellspacing="0" class="yesno">
        <tr>
            <td height="50" align="center">
            	<input type="submit" name="Submit1" value="添加" /> 
           		<input type="reset" name="Submit2" value="重置" />
           		<input type="button" name="Submit3" value="取消" onclick="back()"/>
           	</td>
        </tr>
    </table>
</form>
</body>
</html>