<%--
  Created by IntelliJ IDEA.
  User: 郝建强
  Date: 2018/11/7
  Time: 20:55
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>

</head>
<style type="text/css">
    .divform{
        width: 390px;
        height: 430px;

        border: 5px solid black;
        top: 50%;
        left: 50%;
        margin-top: 70px;
        margin-left: 35%;
    }
    h1{
        text-align: center;
        color: cornflowerblue;
    }
    p{
        background-color: darkgoldenrod;
    }

</style>
<body style="background-image:url(4.jpg)">
<div class="divform">
    <form action="user/reg" method="post">
        <%--<input type="hidden" name="oper" value="changeinfo" />--%>
        <h1 align="center">个人信息</h1>
        <hr/>
        <table>
            <tr>
                <td width="10%">昵称</td>
                <td width="20%" ><input type="text" name="regname" value="" /></td>
            </tr>
            <tr>
                <td width="10%">密码</td>
                <td width="20%" ><input type="text" name="regpwd" value="" /></td>
            </tr>
            <tr>
                <td width="10%">性别</td>
                <td width="20%">男<input type="radio" name="regsex" value="男" checked = "checked">女<input type="radio" name="regsex" value="女">

            </tr>
            <tr>
                <td width="10%">生日</td>
                <td width="20%" ><input type="date" name="regbirthday" value="" /></td>
            </tr>
            <tr>
                <td>签名</td>
                <td>
                    <textarea name="regpersonal" cols="30%" rows="5%" ></textarea>
                </td>
            </tr>
            <tr>
                <td colspan="2" align="center">
                    <input type="submit" value="注册">
                </td>
            </tr>

        </table>
    </form>
</div>

</body>
</html>
