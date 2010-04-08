<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <title>User List</title>
    <style type="text/css">
        table {
            border: 1px solid black;
            border-collapse: collapse;
        }
        
        table thead tr th {
            border: 1px solid black;
            padding: 3px;
            background-color: #cccccc;
        }
        
        table tbody tr td {
            border: 1px solid black;
            padding: 3px;
        }
    </style>
    <base href="<%=basePath%>"/>
</head>
<body> 
	<br />   
    <h2 align="center">用户列表</h2>
	<hr />
        <table cellspacing="0" align="center">
            <thead>
                <tr>
                    <th>ID</th>
                    <th>用户名</th>
                    <th>密码</th>
                    <th>真实姓名</th>
                    <th>性别</th>
                    <th>年龄</th>
                    <th>生日</th>
                    <th>Email</th>
                    <th></th>
                </tr>
            </thead>
            <tbody>
                <c:forEach items="${users}" var="user" varStatus="status">
                    <tr>
                        <td>${user.id }</td>
                        <td>${user.username }</td>
                        <td>${user.password }</td>
                        <td>${user.realName }</td>
                        <td>${user.gender }</td>
                        <td>${user.age }</td>
                        <td>${user.birthday }</td>
                        <td>${user.email }</td>
                        
                        <td>
                            <a href='user/prepareUpdate.action?user.id=${user.id }'>
                                                                                      编辑
                            </a>
                            &nbsp;
                            <a href='user/deleteUser.action?user.id=${user.id }'>
                                                                                     删除
                            </a>
                        </td>
                        
                        
                    </tr>
                </c:forEach>
            </tbody>
        </table>
        <br/>
       <div align="center"> <a href="crud/add.jsp" >新增用户</a></div>
</body>
</html>
