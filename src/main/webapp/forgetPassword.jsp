<%--
  Created by IntelliJ IDEA.
  User: Student
  Date: 24.09.2022
  Time: 11:06
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>forget password</title>
</head>
<body>

<form method="post" action="/inputEmail">
  <h1>Input passwords</h1>
  new password: <input type="text" name="new_password"><br><br>
  confirm password: <input type="text" name="confirm_password"><br><br>
  <input type="submit" name="submit">

</form>

</body>
</html>
