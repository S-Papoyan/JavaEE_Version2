<%@ page import="com.digi.repository.UserRepository" %>
<%@ page import="java.io.PrintWriter" %><%--
  Created by IntelliJ IDEA.
  User: Student
  Date: 15.09.2022
  Time: 21:13
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Verification</title>
</head>
<body>
<%
    boolean count = false;
    String email = request.getParameter("email");
    String verifyCode = UserRepository.verifyCode(email);
    PrintWriter writer = response.getWriter();
    if (count) {
        String verify = request.getParameter("verify");
        if (!verify.equals(verifyCode)) {
            writer.write("Wrong verify");
        }
    }
    if (verifyCode != null) {
        writer.println(verifyCode);
    } else {
        writer.write("Wrong email");
    }

%>
<form method="post" action="/verification">
    <h1>verifyCode</h1><br><br>
    email: <input type="text" name="email"><br><br>
    Verify_code: <input type="text" name="verify"><br><br>
    <input type="submit" name="submit">

</form>
</body>
</html>
