<%--
  User: Yemao Luo
  Date: 2021/10/18
  Time: 16:52
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<link rel="shortcut icon" href="img/logo.png" rel="external nofollow" type="image/x-icon"/>
<script>
    function findAllUser() {
        window.location.href = "${pageContext.request.contextPath}/user/findAllUser";
    }

    function findAllEquipment() {

        window.location.href = "${pageContext.request.contextPath}/equipment/findAllEquipment";
    }

    function userCRUD() {
        window.location.href = "${pageContext.request.contextPath}/user/userCRUDPage";
    }

    function equipmentCRUD() {
        window.location.href = "${pageContext.request.contextPath}/equipment/equipmentCRUDPage";
    }

    function changePassword() {
        let password = prompt("新密码：");
        window.location.href = "${pageContext.request.contextPath}/user/changePasswordByName?password=" + password;
    }

    function logOut() {
        window.location.href = "${pageContext.request.contextPath}/user/logOut";
    }

    function BRCRUD() {
        window.location.href = "${pageContext.request.contextPath}/br/BRCRUDPage";
    }

    function BRList() {
        window.location.href = "${pageContext.request.contextPath}/br/BRList";
    }
</script>
<html>
<head>
    <title>home</title>
</head>
<body>
<h1>this is home hello ${user.name} !
    <button id="changePassword" onclick="changePassword()">更改密码</button>
    <button id="logOut" onclick="logOut()">退出登录</button>
    <span style="color: red">${msg_changePasswordByName.message}</span></h1>
<hr>
<button onclick="findAllUser()">查询所有用户</button>
<span style="color: red">${msg_findAllUser.message}</span>
<hr>
<button onclick="findAllEquipment()">查询所有设备</button>
<span style="color: red">${msg_findAllEquipment.message}</span>
<hr>
<button onclick="userCRUD()">用户CRUD</button>
<span style="color: red">${msg_userCRUD.message}</span>
<hr>
<button onclick="equipmentCRUD()">设备CRUD</button>
<span style="color: red">${msg_equipmentCRUD.message}</span>
<hr>
<button onclick="BRCRUD()">设备借还</button>
<hr>
<button onclick="BRList()">借环情况</button>
<div style="position: fixed; bottom: 1px;">
    <span style="font-size: 20px; text-align: center">@CopyRight GEHA GDSYZX 2021</span>
</div>
</body>
</html>
