<%--
  Created by IntelliJ IDEA.
  User: Student
  Date: 10.09.2022
  Time: 11:15
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Registration</title>
</head>
<body>
<form method="post" action="/registration">
  <h1>Registration Page</h1>
  name: <input type="text" name="name"><br><br>
  surname: <input type="text" name="surname"><br><br>
  age: <input type="text" name="age"><br><br>
  email: <input type="text" name="email"><br><br>
  password: <input type="text" name="password"><br><br>
  <input type="submit" name="submit">

</form>
</body>
</html>
