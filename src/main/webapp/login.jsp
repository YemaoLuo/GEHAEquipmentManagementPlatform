<%--
  User: Yemao Luo
  Date: 2021/10/17
  Time: 10:34
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>航空社设备管理平台</title>
    <link rel="shortcut icon" type="image/x-icon" href="/img/logo.ico"/>
</head>
<body>
<div style="margin-top: 250px; font-size: 30px; text-align: center; alignment: center">广东实验中学航空社团设备管理平台</div>
<form name="userForm" action="${pageContext.request.contextPath}/user/login" method="post"
      style="margin-top: 50px; position: absolute; width: 100%">
    <div style="font-size: 15px; text-align: center; margin-top: 10px">
        账号：<input name="name">
    </div>
    <div style="font-size: 15px; text-align: center; margin-top: 10px">
        密码：<input type="password" name="password">
    </div>
    <div style="font-size: 15px; text-align: center; alignment: center; margin-top: 10px">
        <input type="submit" value="提交">
    </div>
    <div style="font-size: 15px; text-align: center; alignment: center; margin-top: 10px">
        <span id="msg" style="color: red">${msg.message}</span>
    </div>
</form>
<div style="position: fixed; bottom: 1px;">
    <span style="font-size: 20px; text-align: center">@CopyRight GEHA GDSYZX 2021</span>
</div>
</body>
</html>
