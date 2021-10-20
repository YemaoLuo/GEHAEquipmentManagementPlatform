<%--
  User: Yemao Luo
  Date: 2021/10/19
  Time: 15:11
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>equipmentCRUD</title>
</head>
<body>
<button id="back">返回</button>
<hr>
<h1>Search</h1>
<form method="post" action="/equipment/findEquipmentByName">
    <input name="name" placeholder="name">
    <input type="submit" value="查询">
</form>
<table border="1" cellspacing="0" cellpadding="3">
    <tr>
        <th>编号</th>
        <th>名字</th>
        <th>状态</th>
    </tr>
    <c:forEach items="${equipment_findEquipmentByName}" var="equipment">
        <tr>
            <th>${equipment.id}</th>
            <th>${equipment.name}</th>
            <th>${equipment.inUse_str}</th>
        </tr>
    </c:forEach>
    <span style="color: red">${msg_findEquipmentByName.message}</span>
</table>
<br>
<hr>
<h1>Delete</h1>
<form method="post" action="/equipment/deleteEquipmentByName" onsubmit="return confirm('确认删除吗?')">
    <input name="name" placeholder="name">
    <input type="submit" value="删除">
</form>
<span style="color: red">${msg_deleteEquipmentByName.message}</span>
<br>
<hr>
<div style="position: fixed; bottom: 1px;">
    <span style="font-size: 20px; text-align: center">@CopyRight GEHA GDSYZX 2021</span>
</div>
</body>
</html>
<script>
    function checkInsert() {
        let flag = confirm("确认提交吗？");
        let name = document.getElementById("name").value;
        let gender = document.getElementById("gender").value;
        let role = document.getElementById("role").value;
        //不可以单纯对比null 好像为undefined
        if (!!!name || !!!gender || !!!role) {
            flag = false;
            document.getElementById("msg_insertUser").innerText = "缺少必要信息";
        }
        return flag;
    }

    function checkUpdate() {
        let flag = confirm("确认更改吗？");
        let name = document.getElementById("name_u").value;
        let gender = document.getElementById("gender_u").value;
        let role = document.getElementById("role_u").value;
        //不可以单纯对比null 好像为undefined
        if (!!!name || !!!gender || !!!role) {
            flag = false;
            document.getElementById("msg_updateUser").innerText = "缺少必要信息";
        }
        return flag;
    }
</script>
<script>
    window.onload = function () {
        document.getElementById("back").onclick = function () {
            location.href = "/equipment/toHome";
        }
    }
</script>