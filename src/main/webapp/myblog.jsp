<%@ page import="java.util.List" %>
<%@ page import="com.myblog.Pojo.Blog" %>
<%--
  Created by IntelliJ IDEA.
  User: 郝建强
  Date: 2018/11/11
  Time: 20:44
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>

    <title>Title</title>
    <style type="text/css">
        .divform{
            width: 400px;
            height: 50px;

            border: 5px solid black;
            top: 50%;
            left: 50%;
            margin-top: 70px;
            margin-left: 35%;
        }
        body{
            background: bisque;
        }
    </style>
</head>
<body style="background-image:url(4.jpg)">
    <%
        HttpSession hs = request.getSession();
        List<Blog> list = (List<Blog>) hs.getAttribute("myblog");
        if (list!=null){
        for (Blog b:list
             ) {
    %>
<table class="divform">
    <tr>
        <th><a href="boke/showmyblog?id2=<%=b.getId()%>"><%=b.getTitle()%> </a>  </th>
    </tr>
</table>
    <%}}else {%>
    <h1 style="color: red" class="divform">暂无博客</h1>
    <%
        }
    %>
    <div style="position: absolute; top: 10px;right: 20px;">
        <a href="boke/main">首页</a>
    </div>
</body>
</html>
