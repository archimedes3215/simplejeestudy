<%@ page language="java" contentType="text/html; charset=GB18030"
    pageEncoding="GB18030"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=GB18030">
<title>menu</title>
</head>
<body>
	<hr>
	<ul>
		<li>
			<a href="<%=request.getContextPath()%>/count_access_show">ҳ�����ͳ��</a>
		</li>
		<li>
			<a href="<%=request.getContextPath()%>/filterlistener/count_online.jsp">ͳ����������</a>
		</li>
		<li>
			<a href="<%=request.getContextPath()%>/user/userAction!list.action">�û�CRUD(struts2,jsp,jdbc)</a>
		</li>
	</ul>
</body>
</html>