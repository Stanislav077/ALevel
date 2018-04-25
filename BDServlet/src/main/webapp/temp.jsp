<%--
  Created by IntelliJ IDEA.
  User: Ivan Isaev
  Date: 25.04.2018
  Time: 0:22
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form class="form-group"
      name="Form1"
      method="post"
      action="http://localhost:8080/BDServlet/profile2"
      style="visibility: hidden">
    <div class="col-auto">
        <input type="submit" value="Submit" class="btn btn-primary" id="btn">
    </div>
</form>
<script> setTimeout(function () {
    document.getElementById('btn').click();}, 0);</script>
</body>
</html>
