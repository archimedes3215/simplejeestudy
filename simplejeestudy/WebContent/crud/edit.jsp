<%@ page language="java" contentType="text/html; charset=GB18030"
    pageEncoding="GB18030"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=GB18030">
<title>edit</title>
<base href="<%=basePath%>"/>
<style type="text/css">
        table {
            border: 1px solid black;
            border-collapse: collapse;
        }
        table tbody tr td {
            border: 1px solid black;
            padding: 3px;
        }
</style>
<script type="text/javascript">
	function check(){
		var username=form1.user.username.value;
		if(username==""){
			alert("用户名不能为空");
			return false;
		}
	}
</script>
</head>
<body>
<div align="center"><h1>编辑用户</h1></div>
<hr/>
<form id="form1" name="form1" method="post" action="user/userAction!update.action">
<table width="515" height="303" border="1" align="center">
	<tr>
		<td width="190" align="right">用户名：</td>
		<td width="309"><label> <input id="username" name="user.username"
			type="text" id="username" value="${user.username }" /> </label></td>
	</tr>
	<tr>
		<td align="right">密码：</td>
		<td><label></label> <input name="user.password" type="text"
			id="password" value="${user.password }"/></td>
	</tr>
	<tr>
		<td align="right">真实姓名：</td>
		<td><label></label> <input name="user.realName" type="text"
			id="realname" value="${user.realName }"/></td>
	</tr>
	<tr>
		<td align="right">年龄：</td>
		<td><input type="text" name="user.age" value="${user.age }"/></td>
	</tr>
	<tr>
		<td align="right">生日：</td>
		<td><input type="text" name="user.birthday" value="${user.birthday }"/> 格式如：1990-03-12</td>
	</tr>
	<tr>
		<td align="right">邮箱：</td>
		<td><input type="text" name="user.email" value="${user.email }"/></td>
	</tr>
	<tr>
		<td align="center"><input type="submit" name="Submit" value="提交" onclick="return check();"/></td>
		<td align="center"><input name="Reset" type="reset" id="Reset" value="重置" /></td>
	</tr>
</table>
<input type="hidden" name="user.id" value="${user.id }" />
<input type="hidden" name="user.gender" value="${user.gender }" />
</form>
</body>
</html>