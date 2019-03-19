<%@ page import="com.myblog.Pojo.Blog" %><%--
  Created by IntelliJ IDEA.
  User: 郝建强
  Date: 2018/11/3
  Time: 17:30
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <style>
        .divuser{
            position: absolute;/*绝对定位*/
            width: 400px;
            height: 30px;

            /*border: 5px solid black;*/
            /*text-align: center;!*(让div中的内容居中)*!*/
            top: 50%;
            left: 50%;
            margin-top: -340px;
            margin-left: -600px;
        }
        .divout{
            position: absolute;
            width: 75px;
            height: 63px;

            text-align: center;/*(让div中的内容居中)*/
            top: 50%;
            left: 50%;
            margin-top: -330px;
            margin-left: 580px;
        }
        h2{
            width: 400px;
            height: 30px;
        }
    </style>
    <meta charset="utf-8">
    <title>编辑博客</title>
    <link type="text/css" href="editor.md-master/lib/codemirror/codemirror.min.css">
    <script type="text/javascript" src="editor.md-master/jquery-3.1.1.min.js"></script>
    <script type="text/javascript" src="editor.md-master/editormd.min.js"></script>
    <link rel="stylesheet" href="editor.md-master/css/editormd.css">
</head>
<%
    HttpSession hs = request.getSession();
    Blog b = (Blog) hs.getAttribute("seeblog");
%>
<body style="background-image:url(4.jpg)">
<form method="post" action="boke/updatablog?id=<%=b.getId()%>">

    <div class="divuser">
        <h2>标题:<input type="text" name="title" value="<%=b.getTitle()%>" required="required" ></h2>
    </div>
    <%--<input type="hidden" name="id" value="<%=b.getId()%>">--%>
    <div class="editormd" id="test-editormd" style="top: 70px">
        <textarea class="editormd-markdown-textarea" name="markdown"  required="required"><%=b.getMarkdown()%></textarea>

        <textarea class="editormd-html-textarea" name="essay"></textarea>
    </div>
    <div class="divout">
        <input type="submit"  value="保存编辑">
    </div>
</form>
<br />
<script type="text/javascript">
    $(function() {
        editormd("test-editormd", {
            width   : "90%",
            height  : 640,
            syncScrolling : "single",
            //你的lib目录的路径，我这边用JSP做测试的
            path    : "editor.md-master/lib/",
            //这个配置在simple.html中并没有，但是为了能够提交表单，使用这个配置可以让构造出来的HTML代码直接在第二个隐藏的textarea域中，方便post提交表单。
            saveHTMLToTextarea : true
        });
    });
</script>
<div style="position: absolute; top: 10px;right: 20px;">
    <a href="boke/main">首页</a>
</div>
</body>
</html>