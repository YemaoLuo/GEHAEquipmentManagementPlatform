<%--
  User: Yemao Luo
  Date: 2021/10/19
  Time: 15:11
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>userCRUD</title>
</head>
<body>
<h1>Search</h1>
<form method="post" action="/user/findUserByName">
    <input name="name" placeholder="name">
    <input type="submit" value="查询">
</form>
<table style="border: black 1px solid; border-collapse:collapse;">
    <tr>
        <th>用户名</th>
        <th>性别</th>
        <th>身份</th>
        <th>年份</th>
        <th>电话</th>
        <th>邮箱</th>
    </tr>
    <tr>
        <th>${user_search.name}</th>
        <th>${user_search.gender}</th>
        <th>${user_search.role}</th>
        <th>${user_search.year}</th>
        <th>${user_search.phone}</th>
        <th>${user_search.email}</th>
    </tr>
    <span style="color: red">${msg_findUserByName.message}</span>
</table>
<br>
<hr>
<br>
<h1>Delete</h1>
</body>
</html>
