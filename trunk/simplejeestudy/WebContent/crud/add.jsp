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
			msgStr+="\nemail��ʽ����ȷ��aaa@bbb.com";
			pass = false;
		}
		if(birthday.value != "" && !isDate(birthday.value)){
			msgStr+="\n���ո�ʽ����ȷ��yyyy-MM-dd";
			pass = false;
		}
		if(username.value == ""){
			msgStr+="\n�û�������Ϊ��";
			pass = false;
		}

		if(!pass)alert(msgStr);
		return pass;
    }
    </script>
</head>
<body>
<div align="center"><h1>�����û�</h1></div>
<hr/>
<form id="form1" name="form1" method="post" action="user/addUser">
<table width="515" height="303" border="1" align="center">
	<tr>
		<td width="190" align="right">�û�����</td>
		<td width="309"><label> <input name="user.username"
			type="text" id="username" /> </label></td>
	</tr>
	<tr>
		<td align="right">���룺</td>
		<td><label></label> <input name="user.password" type="password"
			id="password" /></td>
	</tr>
	<tr>
		<td align="right">��ʵ������</td>
		<td><label></label> <input name="user.realName" type="text"
			id="realname" /></td>
	</tr>
	<tr>
		<td align="right">�Ա�</td>
		<td><label> <input name="user.gender" type="radio"
			value="��" checked="checked" /> ��</label> <label></label> <label>
		<input type="radio" name="user.gender" value="Ů" /> Ů</label></td>
	</tr>
	<tr>
		<td align="right">���䣺</td>
		<td><input type="text" name="user.age" /></td>
	</tr>
	<tr>
		<td align="right">���գ�</td>
		<td><input type="text" name="user.birthday" id="birthday"/> ��ʽ�磺1990-03-12</td>
	</tr>
	<tr>
		<td align="right">���䣺</td>
		<td><input type="text" name="user.email" id="email"/></td>
	</tr>
	<tr>
		<td align="center"><input type="submit" name="Submit" value="�ύ" onclick="return beforeSubmit();"/></td>
		<td align="center"><input name="Reset" type="reset" id="Reset" value="����" /></td>
	</tr>
</table>
</form>
</body>
</html>