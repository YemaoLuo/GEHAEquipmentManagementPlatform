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
<button id="back">返回</button>
<hr>
<h1>Search</h1>
<form method="post" action="${pageContext.request.contextPath}/user/findUserByName">
    <input name="name" placeholder="name">
    <input type="submit" value="查询">
</form>
<table border="1" cellspacing="0" cellpadding="3">
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
<h1>Delete</h1>
<form method="post" action="${pageContext.request.contextPath}/user/deleteUserByName"
      onsubmit="return confirm('确认删除吗?')">
    <input name="name" placeholder="name">
    <input type="submit" value="删除">
</form>
<span style="color: red">${msg_deleteUserByName.message}</span>
<br>
<hr>
<h1>Insert</h1>
<form id="insert" method="post" action="${pageContext.request.contextPath}/user/insertUser"
      onsubmit="return checkInsert()">
    <span style="color: red">*</span> <input name="name" placeholder="name" id="name"><br>
    <span style="color: red">*</span> <input name="gender" placeholder="gender" id="gender"><br>
    <span style="color: red">*</span> <input name="role" placeholder="role" id="role"><br>
    &nbsp <input name="year" placeholder="year"><br>
    &nbsp <input name="password" placeholder="password"><br>
    &nbsp <input name="phone" placeholder="phone"><br>
    &nbsp <input name="email" placeholder="email"><br>
    &nbsp <input type="submit" value="添加">
</form>
<span style="color: red" id="msg_insertUser">${msg_insertUser.message}</span>
<br>
<hr>
<h1>Update</h1>
<form id="update" method="post" action="${pageContext.request.contextPath}/user/updateUser"
      onsubmit="return checkUpdate()">
    <span style="color: red">*</span> <input name="name" placeholder="name" id="name_u"><br>
    <span style="color: red">*</span> <input name="gender" placeholder="gender" id="gender_u"><br>
    <span style="color: red">*</span> <input name="role" placeholder="role" id="role_u"><br>
    &nbsp <input name="year" placeholder="year"><br>
    &nbsp <input name="password" placeholder="password"><br>
    &nbsp <input name="phone" placeholder="phone"><br>
    &nbsp <input name="email" placeholder="email"><br>
    &nbsp <input type="submit" value="修改">
</form>
<span style="color: red" id="msg_updateUser">${msg_updateUser.message}</span>
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
            location.href = "${pageContext.request.contextPath}/user/toHome";
        }
    }
</script>
