<%--
  User: Yemao Luo
  Date: 2021/10/19
  Time: 14:34
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<script>
    window.onload = function () {
        document.getElementById("back").onclick = function () {
            window.history.back();
        }
    }
</script>
<html>
<head>
    <title>查询所有用户</title>
</head>
<body>
<button id="back">返回</button>
<hr>
<table border="1" cellspacing="0" cellpadding="3">
    <tr>
        <th>用户名</th>
        <th>性别</th>
        <th>身份</th>
        <th>年份</th>
        <th>电话</th>
        <th>邮箱</th>
    </tr>
    <c:forEach items="${userList}" var="user">
        <tr>
            <td>${user.name}</td>
            <td>${user.gender}</td>
            <td>${user.role}</td>
            <td>${user.year}</td>
            <td>${user.phone}</td>
            <td>${user.email}</td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
