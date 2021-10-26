<%--
  User: Yemao Luo
  Date: 2021/10/18
  Time: 23:04
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>WElCOME</title>
    <link rel="shortcut icon" type="image/x-icon" href="/img/logo.ico"/>
</head>
<body>
<div align="center">
    <img src="${pageContext.request.contextPath}/img/logo.png" style="width: 1200px; height: 600px; margin-top: 150px"
         onclick="location.href = '${pageContext.request.contextPath}/login.jsp'"/><br>
    <span style="font-size: 20px">点击图片登录</span>
</div>
<div style="position: fixed; bottom: 1px;">
    <span style="font-size: 20px; text-align: center">@CopyRight GEHA GDSYZX 2021</span>
</div>
</body>
</html>
