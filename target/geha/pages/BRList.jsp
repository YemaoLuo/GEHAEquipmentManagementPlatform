<%--
  User: Yemao Luo
  Date: 2021/10/22
  Time: 19:20
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<link rel="shortcut icon" href="img/logo.png" rel="external nofollow" type="image/x-icon" />
<html>
<head>
    <title>BrList</title>
</head>
<body>
<button id="back">返回</button>
<hr>
<table border="1" cellspacing="0" cellpadding="3">
    <tr>
        <th>设备</th>
        <th>用户</th>
        <th>时间</th>
        <th>状态</th>
    </tr>
    <c:forEach items="${BRList}" var="br">
        <tr>
            <td>${br.ename}</td>
            <td>${br.uname}</td>
            <td>${br.date}</td>
            <td>${br.status}</td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
<script>
    window.onload = function () {
        document.getElementById("back").onclick = function () {
            location.href = "${pageContext.request.contextPath}/equipment/toHome";
        }
    }
</script>
