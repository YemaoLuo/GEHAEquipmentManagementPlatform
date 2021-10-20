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
    <title>查询设备列表</title>
</head>
<body>
<button id="back">返回</button>
<hr>
<table border="1" cellspacing="0" cellpadding="3">
    <tr>
        <th>编号</th>
        <th>名字</th>
        <th>状态</th>
    </tr>
    <c:forEach items="${equipmentList}" var="equipment">
        <tr>
            <td>${equipment.id}</td>
            <td>${equipment.name}</td>
            <td>${equipment.inUse_str}</td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
