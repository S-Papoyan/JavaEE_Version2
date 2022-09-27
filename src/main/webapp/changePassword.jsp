<%--
  Created by IntelliJ IDEA.
  User: Student
  Date: 27.09.2022
  Time: 20:12
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Change password</title>
</head>
<body>

<form method="post" action="/change-password">
  <h1>Input passwords</h1>
  old password: <input type="text" name="old_password"><br><br><br>
  new password: <input type="text" name="new_password"><br><br>
  confirm password: <input type="text" name="confirm_password"><br><br>
  <input type="submit" name="submit">

</form>
</body>
</html>
