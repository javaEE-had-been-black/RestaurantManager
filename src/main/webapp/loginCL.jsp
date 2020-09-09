<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" %>
<%@ page import="web.RestaurantManager" %>

<jsp:useBean id="restaurantManager" scope="page" class="web.RestaurantManager" />

<html>

<head>

    <title>loginCL.jsp页面</title>

</head>

<body>

<%
    request.setCharacterEncoding("utf-8");

    response.setContentType("text/html;charset=utf-8");

    String name = request.getParameter("username");

    String password = request.getParameter("password");

//判断登陆界面的用户名和密码，根据输入的不同情况进行不同的处理


    //RestaurantManager restaurantManager = new RestaurantManager();
    Boolean result = restaurantManager.login(name, password);

    if (result) {
        response.sendRedirect("personInfor.jsp");
    } else {
        response.sendRedirect("login.jsp");
    }

%>

</body>

</html>