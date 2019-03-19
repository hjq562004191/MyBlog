<%--
  Created by IntelliJ IDEA.
  User: 郝建强
  Date: 2018/10/30
  Time: 18:08
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>请先登陆</title>
</head>
<style type="text/css">
    .divf{
        position: absolute;/*绝对定位*/
        width: 300px;
        height: 200px;

        border: 5px solid black;
        text-align: center;/*(让div中的内容居中)*/
        top: 50%;
        left: 50%;
        margin-top: -200px;
        margin-left: -160px;
    }
</style>

<body style="background-image:url(4.jpg)">
    <div class="divf">
        <%
            HttpSession hs = request.getSession();
            Object f = hs.getAttribute("flag");
            if (f!=null){
        %>
        <div style="text-align: center;">
            <span style="font-size: 15px;color: navy;font-weight: bold">用户名或者密码错误</span>
        </div>
        <% }%>
<form action="user/login" method="post">
    <%--<input type="hidden" name="oper" value="login" />--%><br/>
    用户名:<input name="uname" type="text" placeholder=""  /><br/><br/>
    密码:<input  name="pwd" type="password" placeholder=""  /><br/><br/>
        <input name="" type="submit" value="登录" />
</form>

<a href="userreg.jsp">注册</a>

<a href="user/tourist">游客</a>
    </div>
</body>
</html>
