<%--
  Created by IntelliJ IDEA.
  User: 86180
  Date: 2020/9/8
  Time: 13:28
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%
    int type = 0;
//    String typeString=request.getParameter("type");
//    if(typeString.equals("")){
//        type=1;
//    }
//    else {
//        type=Integer.getInteger(typeString);
//    }
%>


<html>
<head>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/management.css"/>
    <title>manage</title>
</head>
<body background="resources/images/background.jpg"
      style="background-repeat:no-repeat;background-size:100% 100%;background-attachment:fixed;">


<%--<script type="text/javascript">--%>
<%--    function myRefresh(){--%>
<%--        --%>

<%--    }--%>


<%--</script>--%>


<div class="show">
    <div id="choice" class="choice">
        <button onclick="window.location.replace(" management.jsp
        ")">座位管理</button>
        <button onclick="<% type=2; %>">菜谱管理</button>
        <button onclick="<% type=3; %>">会员管理</button>
        <button onclick="<% type=4; %>">人事管理</button>
        <button onclick="<% type=5; %>">报表统计</button>
        <button onclick="<% type=6; %>">报表管理</button>
        <p>零零零零<%=type %>
        </p>
    </div>

    <% if (type == 1) {
    %>
    <%--餐位的部分--%>
    <div id="seats-content" class="seats-content">

        <div id="seatSearch">

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

            <input id="searchKey" type="text"/>
            <img src="resources/images/search.jpg" style="width: 30px;height: 30px" alt="搜索"/>

        </div>

        <div class="seats-container">
            <%--                <% for(int i=0;i<9;i++){--%>
            <%--                //这里循环显示桌子【小图片和状态以及桌号】--%>
            <%--                %>--%>
            <div class="seat-container">
                <img src="resources/images/seat.jpg" style="width: 50px;height: 50px" alt="座位"/><br/>
                未使用
                <br>
                A01
            </div>
            <div class="seat-container">
                <img src="resources/images/seat.jpg" style="width: 50px;height: 50px" alt="座位"/><br/>
                未使用
                <br>
                A01
            </div>
            <%--                <% } %>--%>
        </div>

    </div>

    <% } else if (type == 2) {
    %>

    <%--菜谱部分--%>
    <div id="dishes-content" class="dishes-content">
        <div class="dishInput">
            <input type="text"/>
            <img src="resources/images/search.jpg" style="width: 30px;height: 30px" alt="搜索"/>
        </div>

        <% int dishType = 0; %>
        <div class="dishes-type">
            <button onclick="<% dishType=0; %>">全部</button>
            <button onclick="<% dishType=1; %>">炒菜</button>
            <button onclick="<% dishType=2; %>">酒水</button>
            <button onclick="<% dishType=3; %>">其他</button>
        </div>

        <div class="dishes-container">
            <% for (int i = 0; i < 9; i++) { %>
            <div class="dish-container">
                <img src="resources/images/seat.jpg" style="width: 100px;height: 100px;border:2px solid grey" alt="座位">
                <p>
                    油闷大虾<br>
                    价格:￥50
                </p>
            </div>
            <% } %>
        </div>

    </div>

    <% } else if (type == 3) {
    %>

    <%--    会员管理--%>
    <div id="vips-content" class="vips-content">
        <%--        能够实现分页排行榜/搜索即可--%>
        <% int sortType = 0; %>
        <div class="vipInput">
            <input type="text"/>
            <img src="resources/images/search.jpg" style="width: 30px;height: 30px" alt="搜索"/>

            <button onclick="<% sortType=0; %>">积分</button>
            <button onclick="<% sortType=1; %>">日期</button>

        </div>

        <%--            这边还需要实现一个分页的管理--%>
        <table>
            <tr>
                <th>手机号</th>
                <th>姓名</th>
                <th>积分</th>
            </tr>
            <% for (int i = 0; i < 9; i++) { %>
            <tr>
                <td>18055548766</td>
                <td>任梦婕</td>
                <td>777</td>
            </tr>
            <% } %>
        </table>

    </div>


    <% } else if (type == 4) {
    %>

    <%--人事管理--%>
    <% int personnelType = 1; %>
    <div id="personnels-content" class="personnels-content">
        <div class="personnel-operation">
            <button onclick="<% personnelType=1; %>">添加账号</button>
            <button onclick="<% personnelType=2; %>">更改账号</button>
            <button onclick="<% personnelType=3; %>">查看账号</button>
        </div>
        <% if (personnelType == 1) { %>
        <div class="addPersonnel">
            <p>添加用户</p><br>
            <p>*账号</p><input type="text"><br>
            <p>*姓名</p><input type="text"><br>
            <p>*密码</p><input type="text"><br>
            <p>*手机</p><input type="text"><br>
            <p>*身份证</p><input type="text"><br>
            <p>职位</p>
            <select class="positionSelect" id="positionSelect">
                <option value="all">全部</option>
                <option value="spare">空余</option>
                <option value="service">使用中</option>
            </select>
            <br>
            <button>确认添加</button>
            <button>重置</button>
        </div>
        <% } else if (personnelType == 2) { %>
        <%--        更改账号信息--%>

        <div class="changePersonnel">
            <p>更改用户</p><br>
            <%--            这里是一个搜索框--%>
            <input type="text">
            <img src="resources/images/search.jpg" style="width: 30px;height: 30px" alt="搜索"/>

            <p>*账号</p><input type="text" value="18055548766" disabled><br>
            <p>*姓名</p><input type="text"><br>
            <p>*密码</p><input type="text"><br>
            <p>*手机</p><input type="text"><br>
            <p>*身份证</p><input type="text"><br>
            <p>职位</p>
            <select class="positionSelect">
                <option value="all">全部</option>
                <option value="spare">空余</option>
                <option value="service">使用中</option>
            </select>
            <br>
            <button>确认添加</button>
            <button>重置</button>
        </div>

        <% } else if (personnelType == 3) { %>
        <%--        查询账户信息--%>

        <div class="searchPersonnel">
            <input type="text">
            <img src="resources/images/search.jpg" style="width: 30px;height: 30px" alt="搜索"/>

            <table>
                <tr>
                    <th>账号</th>
                    <th>姓名</th>
                    <th>身份证</th>
                    <th>职位</th>
                    <th>密码</th>
                </tr>
                <% for (int i = 0; i < 9; i++) { %>
                <tr>
                    <td>18055548766</td>
                    <td>任梦婕</td>
                    <td>777777777777777777777777</td>
                    <td>外卖小哥</td>
                    <td>7777777</td>
                </tr>
                <% } %>
            </table>

        </div>

        <% } %>
    </div>


    <% } else if (type == 5) {
    %>

    <%--    报表统计--%>
    <div id="statistics-content" class="statistics-content">
        <p>太难了，要使用canvas绘制统计图，我不会呀</p>
    </div>


    <% } else if (type == 6) {
    %>

    <%--    仓库管理--%>
    <% int warehousesType = 1; %>
    <div id="warehouses-content" class="warehouses-content">
        <div class="warehousesType">
            <p>进货信息</p>
            <p>销售信息</p>
            <p>货余量</p>
        </div>

        <% if (warehousesType == 1) { %>
        <div>


        </div>


        <% } else if (warehousesType == 2) { %>


        <% } else if (warehousesType == 3) { %>


        <% } %>


    </div>

    <% } %>


</div>


</body>
</html>
