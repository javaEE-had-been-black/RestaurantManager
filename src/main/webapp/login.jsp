<%--
  Created by IntelliJ IDEA.
  User: 25832
  Date: 2020-09-09
  Time: 9:44
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>
</head>

<body background="resources/images/background.jpg"
      style="background-repeat:no-repeat;background-size:100% 100%;background-attachment:fixed;">
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/login.css"/>

<div id="loginDiv">
    <h1 style="text-align: center;color:#666666">登陆</h1>
    <form action="loginCL.jsp" method="post" name=form>
        <p style="color: #666666;font-size: larger">手机号:<input id="userNname" type="text"/></p>
        <p style="color: #666666;font-size: larger">密&nbsp&nbsp&nbsp码:<input id="password" type="password"/></p>
        <div style="text-align: center;margin-top: 30px;"></div>
        <input class="button" type="submit" value="提交" name="submit">
        <input class="button" type="reset" value="重置">
    </form>
</div>
</body>

</html>
