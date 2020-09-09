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
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/register.css"/>

<%
    String userName="11111";
    String password="111111";
%>

<div id="loginDiv">
        <h1 style="text-align: center;color:#666666">登陆</h1>
<%--        <p style="color: #666666;font-size: larger">手机号:<input id="userNname" value="<%=userName %>" type="text"/>--%>
<%--            <label id="name_trip"></label>--%>
<%--        </p>--%>

<%--        <p style="color: #666666;font-size: larger">密码： <input id="password" value="<%=password %>" type="password"/>--%>
<%--            <label id="password_trip"></label>--%>
<%--        </p>--%>
<%--        <div style="text-align: center;margin-top: 30px;"></div>--%>
<%--        <button class="button" value="进入" action="test"/>--%>


    <form action="loginCL.jsp" method="post" name=form >
        <font size="5">登录界面</font><br>
        用户名：<input type="text" value=""name="username"><br>
        密    码：<input type="text"value="" name="password"><br>
        <input type="submit"value="提交"name="submit">
        <input type="reset"value="重置">
    </form>
</div>
</body>

</html>
