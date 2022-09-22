<%--
  Created by IntelliJ IDEA.
  User: Student
  Date: 22.09.2022
  Time: 19:53
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>add address</title>
</head>
<body>

<form method="post" action="/address">
  <h1>Input address</h1>
  country: <input type="text" name="country"><br><br>
  city: <input type="text" name="city"><br><br>
  street: <input type="text" name="street"><br><br>
  home: <input type="text" name="home"><br><br>
  <input type="submit" name="submit">

</form>

</body>
</html>
