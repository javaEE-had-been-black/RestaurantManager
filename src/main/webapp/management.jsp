<%--
  Created by IntelliJ IDEA.
  User: 86180
  Date: 2020/9/8
  Time: 13:28
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<link rel="stylesheet" type="text/css" href="/resources/css/management.css" />
<html>
<head>
    <title>manage</title>
</head>
<body background="resources/images/background.jpg"
      style="background-repeat:no-repeat;background-size:100% 100%;background-attachment:fixed;">
<div class="show">
    <div id="choice" class="choice">
        <p>座位管理</p>
        <p>菜谱管理</p>
        <p>会员管理</p>
        <p>人事管理</p>
        <p>报表统计</p>
        <p>仓库管理</p>
    </div>
    <div id="seats-content" class="content">
        <div id="seatSearch">
            <form id="searchForm">
                <select class="listSelect" id="seat-state">
                    <option value="all">全部</option>
                    <option value="spare">空余</option>
                    <option value="service">使用中</option>
                </select>

                <select class="listSelect" id="seat-searchKey">
                    <option value="type">桌型</option>
                    <option value="number">桌号</option>
                    <option value="comment">备注</option>
                </select>

                <inputText id="searchKey" type="text"/>
                <img src="resources/images/search.jpg" style="width: 30px;height: 30px" alt="搜索" />
            </form>
        </div>

        <div class="seats-container">

                <% for(int i=0;i<9;i++){
                //这里循环显示桌子【小图片和状态以及桌号】
                %>
                <div class="seat-container">
                    <img src="resources/images/seat.jpg" style="width: 50px;height: 50px" alt="座位"/><br/>
<%--                    <p><%=state%></p>--%>
<%--                    <p><%=number%></p>--%>
                </div>
                <% } %>
        </div>

    </div>
</div>


</body>
</html>
