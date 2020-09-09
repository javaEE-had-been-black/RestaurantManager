<%--
  Created by IntelliJ IDEA.
  User: 25832
  Date: 2020-09-09
  Time: 10:44
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/PersonInfo.css"/>
    <title>个人信息</title>
</head>
<body background="resources/images/background.jpg"
      style="background-repeat:no-repeat;
background-size:100% 100%;
background-attachment:fixed;">

<h1 style="text-align: -webkit-left;color:aliceblue">云客来餐厅</h1>

<div class="Show">

    <div class="Choice">
        <form action="personInfor.jsp">
            <button class="button" style="text-align: left">个人信息</button>
        </form>
        <form action="management.jsp">
            <button class="button" style="text-align: left">我的餐馆</button>
        </form>
        <form action="PersonIn">
            <button class="button" style="text-align: left">关注的餐馆</button>
        </form>
        <form action="PersonIn">
            <button class="button" style="text-align: left">我的消息</button>
        </form>
    </div>


    <div class="Info">
        <img src="resources/images/headpic.jpg" alt=" headpic" height="80" width="78"> </img>
        <form>
            <p>
                <label class="labelInfo">姓名</label>
                <input class="labelMain" id="userFn" type="text"/>
            </p>

            <p>
                <label class="labelInfo">昵称</label>
                <input class="labelMain" id="number" type="text"/>
            </p>

            <p>
                <label class="labelInfo">电话</label>
                <input class="labelMain" id="sex" type="text"/>
            </p>

            <p>
                <label class="labelInfo">密码</label>
                <input class="labelMain" id="Key" type="text"/>
            </p>

            <p>
                <label class="labelInfo">性别</label>
                <select id="sexCh" name="sex" style="text-align: center; ">
                    <option value="man">男性</option>
                    <option value="woman">女性</option>
                </select>
            </p>

            <br>
            <br>
            <p>
                <button class="buttonSave" id="Save" action="PersonIn">保存</button>
                <button class="buttonSave" id="Quit" action="PersonIn">取消</button>
            </p>
        </form>

    </div>
    <div class="Save">
        <form>
            <button class="buttonKey" action="PersonIn">修改密码</button>
        </form>
    </div>
</div>

</body>
</html>
