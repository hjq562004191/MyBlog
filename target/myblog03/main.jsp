<%@ page import="com.myblog.Pojo.Blog" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: 郝建强
  Date: 2018/10/30
  Time: 18:46
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
    <style type="text/css">
        .divall{
            border: 5px solid black;
            margin-top: 70px;
            margin-left: 45px;
        }
        .divtour{
            position: absolute;
            width: 94%;
            border: 5px solid black;
            margin-top: 40px;
        }
        .divuser{
              /*position: absolute;!*绝对定位*!*/
              width: 307px;
              height: 130px;

              border: 5px solid black;
              /*text-align: center;!*(让div中的内容居中)*!*/
              top: 50%;
              left: 50%;
            margin-top: 3%;
            margin-left: 3%;
          }
        .divout{
            position: absolute;
            width: 75px;
            height: 63px;

            /*border: 3px solid black;*/
            text-align: center;/*(让div中的内容居中)*/
            top: 50%;
            left: 50%;
            margin-top: -330px;
            margin-left: 630px;
        }
        .divform{
            width: 75px;
            height: 63px;

            border: 3px solid midnightblue;
            text-align-last: center;
            top: 50%;
            left: 50%;
            margin-top: -8%;
            margin-left: 30%;
        }
        .divform2{
            /*             position: absolute; */
            width: 75px;
            height: 63px;

            border: 3px solid midnightblue;
            text-align-last: center;
            top: 50%;
            left: 50%;
            margin-top: -4.5%;
            margin-left: 40%;
        }
        .divform3{
            /*             position: absolute; */
            width: 75px;
            height: 63px;

            border: 3px solid midnightblue;
            text-align-last: center;
            top: 50%;
            left: 50%;
            margin-top: -4.5%;
            margin-left: 49%;
        }
        .divform4{
            /*             position: absolute; */
            width: 75px;
            height: 63px;

            border: 3px solid midnightblue;
            text-align-last: center;
            top: 50%;
            left: 50%;
            margin-top: -4.5%;
            margin-left: 59%;
        }

    </style>
</head>
<body style="background-image:url(4.jpg)">

<div class="divuser">
    <%
        HttpSession hs = request.getSession();
        Object f = hs.getAttribute("tour");
            if (f!=null){

    %>

    <br>

    &nbsp;&nbsp;&nbsp;&nbsp;昵称:Tourist<br><br>
    &nbsp;&nbsp;&nbsp;&nbsp;签名:先去注册一个账号吧~<br>

    <form action="userreg.jsp">
        &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; <input type="submit"  value="点击注册">
    </form>

    <% }else {%>

    <br>

    &nbsp;&nbsp;&nbsp;昵称:<%=session.getAttribute("name")%><br>
    &nbsp;&nbsp;&nbsp;性别:<%=session.getAttribute("sex")%><br>
    &nbsp;&nbsp;&nbsp;生日:<%=session.getAttribute("birthday")%><br>
    &nbsp;&nbsp;&nbsp;签名:<%=session.getAttribute("personal")%><br>

</div>

<div class="divform">
<form action="userInfo.jsp">
    <div><br>
            <input type="submit" value="修改信息">
    </div>
</form>
</div>
<div class="divform2">
<form action="pwd.jsp">
    <div><br>
            <input type="submit" value="修改密码">
    </div>
</form>
</div>
<div class="divform3">
    <form action="blogwrite.jsp">
        <div><br>
            <input type="submit" value="发布博客">
        </div>
    </form>
</div>
<div class="divform4">
    <form action="boke/myblog" method="post">
        <input type="hidden" name="oper" value="myblog">
        <div><br>
            <input type="submit" value="我的博客">
        </div>
    </form>
</div>
<% } %>

<%
    if (f != null){
%>
<div class="divtour">
<%}else {%>
<div class="divall">
    <%
        }
    %>
<%
    HttpSession hs1 = request.getSession();
    List<Blog> list = null;
    if (hs1.getAttribute("allblog") != null)
        list = (List<Blog>) hs.getAttribute("allblog");


        for (Blog b:list
             ) {
%>

    <h1>&nbsp;&nbsp;&nbsp;<a href="boke/showallblog?id3=<%=b.getId()%>"><%=b.getTitle()%> </a></h1>
    <h4>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<%=b.getIntroduction()%></h4>
    <p>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;作者:<%=b.getAuthor()%>&nbsp;&nbsp;&nbsp;浏览量:<%=b.getView()%></p>
    <hr>
<%}%>
</div>

<div class="divout" >
    <button onclick="out()" >退出</button>
</div>
<script>
    function out() {
        var r=confirm("确定退出吗？");
        if (r==true){
            window.top.location.href="<c:url value="user/out" />";
        }
    }
</script>

</body>
</html>
