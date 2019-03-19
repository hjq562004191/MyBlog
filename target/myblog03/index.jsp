<html>
<body>
<h2>Hello World!</h2>
<%
    request.getRequestDispatcher("login.jsp").forward(request,response);
%>
</body>
</html>
