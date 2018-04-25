<%--
  Created by IntelliJ IDEA.
  User: Ivan Isaev
  Date: 22.04.2018
  Time: 19:42
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Servlet</title>
</head>
<body>
    Name: <%= request.getAttribute("name")%><br>
    Email: <%= request.getAttribute("email")%>
</body>
</html>
