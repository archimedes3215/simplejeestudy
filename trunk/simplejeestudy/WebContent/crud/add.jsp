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
<title>add</title>
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
    function isEmail(v){
    	var emailPat=/^(.+)@(.+)$/;
    	var matchArray=v.match(emailPat);
    	if (matchArray==null) {return false;}
    	return true;
    }
    function isDate(v){
		if(v == null || v == "") return true;
		var regex = /^(\d{4})-(\d{2})-(\d{2})$/;
		if(!regex.test(v)){return false};
		return true;
    }

    function beforeSubmit(){
        var email = document.getElementById("email");
        var username = document.getElementById("username");
        var password = document.getElementById("password");
        var birthday = document.getElementsById("birthday");

        var msgStr = "";
        var pass = true;
		if(email.value != "" && !isEmail(email.value)){
			msgStr+="\nemail格式不正确，aaa@bbb.com";
			pass = false;
		}
		if(birthday.value != "" && !isDate(birthday.value)){
			msgStr+="\n生日格式不正确，yyyy-MM-dd";
			pass = false;
		}
		if(username.value == ""){
			msgStr+="\n用户名不能为空";
			pass = false;
		}

		if(!pass)alert(msgStr);
		return pass;
    }
    </script>
</head>
<body>
<div align="center"><h1>增加用户</h1></div>
<hr/>
<form id="form1" name="form1" method="post" action="user/addUser">
<table width="515" height="303" border="1" align="center">
	<tr>
		<td width="190" align="right">用户名：</td>
		<td width="309"><label> <input name="user.username"
			type="text" id="username" /> </label></td>
	</tr>
	<tr>
		<td align="right">密码：</td>
		<td><label></label> <input name="user.password" type="password"
			id="password" /></td>
	</tr>
	<tr>
		<td align="right">真实姓名：</td>
		<td><label></label> <input name="user.realName" type="text"
			id="realname" /></td>
	</tr>
	<tr>
		<td align="right">性别：</td>
		<td><label> <input name="user.gender" type="radio"
			value="男" checked="checked" /> 男</label> <label></label> <label>
		<input type="radio" name="user.gender" value="女" /> 女</label></td>
	</tr>
	<tr>
		<td align="right">年龄：</td>
		<td><input type="text" name="user.age" /></td>
	</tr>
	<tr>
		<td align="right">生日：</td>
		<td><input type="text" name="user.birthday" id="birthday"/> 格式如：1990-03-12</td>
	</tr>
	<tr>
		<td align="right">邮箱：</td>
		<td><input type="text" name="user.email" id="email"/></td>
	</tr>
	<tr>
		<td align="center"><input type="submit" name="Submit" value="提交" onclick="return beforeSubmit();"/></td>
		<td align="center"><input name="Reset" type="reset" id="Reset" value="重置" /></td>
	</tr>
</table>
</form>
</body>
</html>