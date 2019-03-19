<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="com.myblog.Pojo.Blog" %>
<%@ page import="com.myblog.Pojo.User" %><%--
  Created by IntelliJ IDEA.
  User: 郝建强
  Date: 2018/11/3
  Time: 17:30
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<%
    Blog b = (Blog) session.getAttribute("seeblog");
    User u = (User) session.getAttribute("user");
%>
<head>
    <title></title>
    <link type="text/css" href="editor.md-master/lib/codemirror/codemirror.min.css">
    <link rel="stylesheet" href="editor.md-master/css/editormd.css">
    <script language="JavaScript" src="editor.md-master/jquery-3.1.1.min.js"></script>
    <style>
        .Show {
            position: absolute;
            left: 300px;
            width: 800px;
        }
        div,code
        {

        }
        body{
            background: bisque;
        }
    </style>
    <script type="text/javascript">
        $(function () {
            $("#delete").click(function () {
                var flag = window.confirm("确定?");
                if (flag){
                    window.top.location.href="boke/delete?id=<%=b.getId()%>";
                }
            })
        })
    </script>
</head>
<div class="Show">
    <body style="background-image:url(4.jpg)">

    <div style="text-align: center;background: white;border-radius: 10px;width: 818px">
        <h2><%=
            b.getTitle()
        %></h2>
        作者:<%=b.getAuthor()%>
        <br />
        浏览量:<%=b.getView()%>
        <br />
        <%--<br />--%>
        发布日期:<%=b.getDate()%>

            <a href="updatablog.jsp">编辑</a>
            <a href="javascript:void(0)" id="delete">删除</a>
    </div>
    <br />
    <div class="editormd-html-textarea" id="content" style="align-content: left;padding: 10px;"><%=b.getEssay()%></div>
    <script src="editor.md-master/jquery-3.1.1.min.js"></script>
    <script src="editor.md-master/lib/marked.min.js"></script>
    <script src="editor.md-master/lib/prettify.min.js"></script>
    <script src="editor.md-master/editormd.min.js"></script>
    <script type="text/javascript">
        editormd.markdownToHTML("content");
    </script>
    </body>
</div>
<div style="position: absolute; top: 10px;right: 20px;">
    <a href="boke/main">首页</a>
</div>
</html>