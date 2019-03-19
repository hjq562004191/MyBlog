<%--
  Created by IntelliJ IDEA.
  User: 郝建强
  Date: 2018/11/1
  Time: 19:08
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
<form action="user/changeinfo" method="post">
    <%--<input type="hidden" name="oper" value="changeinfo" />--%>
    <h1 align="center">个人信息</h1>
    <hr/>
    <table>
        <tr>
            <td width="10%">昵称</td>
            <td width="20%" ><input type="text" name="newname" value="<%=session.getAttribute("name")%>" /></td>
        </tr>
        <tr>
            <td width="10%">性别</td>
            <%if (session.getAttribute("sex").equals("男")){%>
            <td width="20%">男<input type="radio" name="newsex" value="男" checked = "checked">女<input type="radio" name="newsex" value="女">
        <%}else {%>
            <td width="20%">男<input type="radio" name="newsex" value="男" >女<input type="radio" name="newsex" value="女" checked = "checked">
                <%}%>
        </tr>
        <tr>
            <td width="10%">生日</td>
            <td width="20%" ><input type="date" name="newbirthday" value="<%=session.getAttribute("birthday")%>" /></td>
        </tr>
        <tr>
            <td>签名</td>
            <td>
                <textarea name="newpersonal" cols="30%" rows="5%" ><%=session.getAttribute("personal")%></textarea>
            </td>
        </tr>
        <tr>
            <td colspan="2" align="center">
                <input type="submit" value="保存">
            </td>
        </tr>

    </table>
</form>
</div>
<div style="position: absolute; top: 10px;right: 20px;">
    <a href="boke/main">首页</a>
</div>
</body>
</html>
