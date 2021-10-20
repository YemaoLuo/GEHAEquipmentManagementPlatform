<%--
  User: Yemao Luo
  Date: 2021/10/18
  Time: 16:52
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<script>
    function findAllUser() {
        window.location.href = "/user/findAllUser";
    }

    function findAllEquipment() {

        window.location.href = "/equipment/findAllEquipment";
    }

    function userCRUD() {
        window.location.href = "/user/userCRUDPage";
    }

    function equipmentCRUD() {
        window.location.href = "/equipment/equipmentCRUDPage";
    }

    function changePassword() {
        let password = prompt("新密码：");
        window.location.href = "/user/changePasswordByName?password=" + password;
    }
</script>
<html>
<head>
    <title>home</title>
</head>
<body>
<h1>this is home hello ${user.name} !
    <button id="changePassword" onclick="changePassword()">更改密码</button>
    <span style="color: red">${msg_changePasswordByName.message}</span></h1>
<hr>
<button onclick="findAllUser()">查询所有用户</button>
<span style="color: red">${msg_findAllUser.message}</span>
<hr>
<hr>
<button onclick="findAllEquipment()">查询所有设备</button>
<span style="color: red">${msg_findAllEquipment.message}</span>
<hr>
<button onclick="userCRUD()">用户CRUD</button>
<span style="color: red">${msg_userCRUD.message}</span>
<hr>
<button onclick="equipmentCRUD()">设备CRUD</button>
<span style="color: red">${msg_equipmentCRUD.message}</span>
</body>
</html>
