<%--
  Created by IntelliJ IDEA.
  User: 郝建强
  Date: 2018/10/31
  Time: 21:19
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <style type="text/css">
        .divform{
            position: absolute;/*绝对定位*/
            width: 300px;
            height: 150px;

            border: 5px solid black;
            text-align: -moz-center;/*(让div中的内容居中)*/
            top: 50%;
            left: 50%;
            margin-top: -200px;
            margin-left: -150px;
        }
    </style>
</head>

<body style="background-image:url(4.jpg)">
<div class="divform">
<form action="user/pwd" method="post" id="f">
    <input type="hidden" name="oper" value="pwd" />
    <br>
    新密码:<input type="text" name="newpwd" value="" formtarget=""/><br><br>
    确认密码:<input type="text" name="repwd" value="" /><br><br>
    <input type="submit" name="" value="提交">
</form>
</div>
<div style="position: absolute; top: 10px;right: 20px;">
    <a href="boke/main">首页</a>
</div>
</body>
</html>
