<%--
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
        .divtitle{
            width: 400px;
            height: 30px;

            /*border: 5px solid black;*/
            /*text-align: center;!*(让div中的内容居中)*!*/
            top: 50%;
            left: 50%;
            margin-top: 30px;
            margin-left: 300px;
        }
        .divsub{
            position: absolute;
            width: 75px;
            height: 63px;

            text-align: center;/*(让div中的内容居中)*/
            top: 50%;
            left: 50%;
            margin-top: -330px;
            margin-left: 580px;
        }
        /*h2{*/
            /*width: 400px;*/
            /*height: 30px;*/
        /*}*/
    </style>
    <meta charset="utf-8">
    <title>编辑博客</title>
    <link type="text/css" href="editor.md-master/lib/codemirror/codemirror.min.css">
    <script type="text/javascript" src="editor.md-master/jquery-3.1.1.min.js"></script>
    <script type="text/javascript" src="editor.md-master/editormd.min.js"></script>
    <link rel="stylesheet" href="editor.md-master/css/editormd.css">
</head>

<body style="background-image:url(4.jpg)">
<form method="post" action="boke/write">

    <div class="divtitle">
    <h1>标题:<input type="text" name="title"  required="required" ></h1>
    </div>

    <input type="hidden" name="oper" value="write">

    <input type="hidden" name="author" value="<%=session.getAttribute("name")%>">
    <input type="hidden" name="aid" value="<%=session.getAttribute("id")%>">

    <div class="editormd" id="test-editormd" style="top: 70px">
        <textarea class="editormd-markdown-textarea" name="markdown" required="required"></textarea>
        <!-- 第二个隐藏文本域，用来构造生成的HTML代码，方便表单POST提交，这里的name可以任意取，后台接受时以这个name键为准 -->
        <textarea class="editormd-html-textarea" name="essay"></textarea>
    </div>
    <div class="divsub">
        <input type="submit"  value="发布文章">
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